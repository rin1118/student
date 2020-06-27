package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.test.service.EmailService;
import com.test.service.LoginService;
import com.test.util.Util;
import com.test.util.UtilImpl;
import com.test.vo.DepartmentVO;
import com.test.vo.EmailVO;
import com.test.vo.LoginVO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	LoginService service;
	
	@Autowired
	EmailService email;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		logger.info("메인 페이지");
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginView(Model model) {

		logger.info("로그인 뷰 페이지");
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model mode, LoginVO vo, HttpServletRequest req, RedirectAttributes rttr) {
		
		logger.info("로그인 처리");
		
		String url="redirect:/";
		
		HttpSession session = req.getSession();	
		session.setMaxInactiveInterval(60*60);
		
		
		try {	
			LoginVO login = service.login(vo);
			
			System.out.println(login.toString());
			
			boolean pwMatch = pwEncoder.matches(vo.getPassword(), login.getPassword());
			
			if(login != null && pwMatch == true){
				session.setAttribute("member", login);
				url = "redirect:/";
			} else {
				url = "redirect:/login";
				session.setAttribute("member", null);
				rttr.addFlashAttribute("msg", false);
			}
			
		} catch(Exception e) {
			url = "redirect:/login";
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}
		
		return url;
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(Model model, HttpSession session) {

		logger.info("로그아웃");
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String joinView(Model model) {
		
		logger.info("회원가입 뷰 페이지");
		
		List<DepartmentVO> list = service.getDepartment();		

		model.addAttribute("list", list);
		
		return "join";
	}
	
	@RequestMapping(value = "/idChk", method = RequestMethod.GET)
	@ResponseBody
	public int idChk(String id) {
		
		logger.info("아이디 중복 확인");
		
		int result = service.idChk(id);
		
		return result;
	}
	
	@RequestMapping(value = "/emailChk", method = RequestMethod.GET)
	@ResponseBody
	public int emailChk(String email) {
		
		logger.info("이메일 중복 확인");
		
		int result = service.emailChk(email);
		
		return result;
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model model, LoginVO vo, HttpServletRequest req, RedirectAttributes rttr) {
		
		logger.info("회원가입 처리");
		
		System.out.println(vo.toString());
		
		try {
			String pw = pwEncoder.encode(vo.getPassword());
			vo.setPassword(pw);
			service.join(vo);
			this.login(model, vo, req, rttr);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/memberDrop", method = RequestMethod.POST)
	@ResponseBody
	public void memberDrop(Model model, HttpServletRequest req, RedirectAttributes rttr) {
		
		logger.info("회원 탈퇴 처리");
		
		try {
			HttpSession session = req.getSession();		
			LoginVO member = (LoginVO) session.getAttribute("member");
			service.memberDrop(member.getM_no());
			session.invalidate();
		} catch(NullPointerException e) {
			System.out.println(e);
		} 
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypageView() {
		
		logger.info("마이페이지 뷰 화면");
		
		return "mypage";
	}
	
	@RequestMapping(value = "/changePw", method = RequestMethod.GET)
	public String changePwView() {
		
		logger.info("비밀번호 변경 뷰 화면");
		
		return "changePw";
	}
	
	@RequestMapping(value = "/changePw", method = RequestMethod.POST)
	@ResponseBody
	public void changePw(String changePw, HttpServletRequest req) {
		
		logger.info("비밀번호 변경 처리");
		LoginVO vo = new LoginVO();
		
		try {
			HttpSession session = req.getSession();		
			LoginVO member = (LoginVO) session.getAttribute("member");
			
			String pw = pwEncoder.encode(changePw);
		
			vo.setM_no(member.getM_no());
			vo.setPassword(pw);
			service.changePw(vo);
			
		} catch(NullPointerException e) {
			System.out.println("비밀번호 변경 처리::::::" + e);
		} 
	}
	
	@RequestMapping(value = "/getPw", method = RequestMethod.GET)
	@ResponseBody
	public boolean getPw(HttpServletRequest req,  String pw) {
		
		logger.info("DB에서 비밀번호 select");
		
		String getPw="";
		boolean pwMatch = false;
		
		try {
			HttpSession session = req.getSession();		
			LoginVO member = (LoginVO) session.getAttribute("member");
			
			getPw = service.getPw(member.getM_no());
			pwMatch = pwEncoder.matches(pw, getPw);
			
		} catch(NullPointerException e) {
			System.out.println("비밀번호 select:::::" + e);
		} 
			return pwMatch;
	}
	
	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findId(Model model, String value) {

		logger.info("아이디 찾기 뷰 페이지");
		
		model.addAttribute("value", value);
		
		System.out.println(value);
		
		return "/findId";
	}
	
	@RequestMapping(value = "/findId", method = RequestMethod.POST)
	public String findIdEmail(Model model, EmailVO vo, RedirectAttributes rttr) {
		
		System.out.println(vo.getReceiveMail());
		
		logger.info("아이디 찾기 메일 보내기");
		
		try {
			int count = service.emailChk(vo.getReceiveMail());
			
			if(count == 1) {
				String getId = service.getId(vo.getReceiveMail());			
				String senderName = "아이디 알리미";
				String senderMail = "0302mong@gmail.com";
				String subject = "요청하신 아이디를 보냈습니다.";
				String message = "요청하신 아이디는 " + getId + " 입니다";
				
				vo.setSenderName(senderName);
				vo.setSenderMail(senderMail);
				vo.setSubject(subject);
				vo.setMessage(message);	
			
				String result = email.sendMail(vo);			
				System.out.println(result);
			}
			else if(count == 0){
				rttr.addFlashAttribute("msg", false);
				rttr.addAttribute("value", "id");   
				return "redirect:/find";
			}
		} catch(Exception e) {
			System.out.println(e);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/findPw", method = RequestMethod.POST)
	public String findPwEmail(Model model, EmailVO vo, RedirectAttributes rttr) {
		
		System.out.println(vo.getReceiveMail());
		
		logger.info("비밀번호 찾기 메일 보내기");
		
		try {
			//입력한 이메일이 db에 등록된 이메일인지 확인
			int count = service.emailChk(vo.getReceiveMail()); 
			
			if(count == 1) {
				//db에 이메일이 있는 경우
				
				//입력받은 이메일로 멤버 번호를 불러옴
				int m_no = service.getM_no(vo.getReceiveMail());
				LoginVO login = new LoginVO();
				
				//랜덤함수로 임시 비밀번호 생성
				int randomNum = 6;			
				Util util = new UtilImpl();			
				String password = util.randomPw(randomNum);
				
				//임시 비밀번호 암호화
				String encryptPw = pwEncoder.encode(password);
				
				//vo에 받아온 멤머 번호와 임시 비밀번호를 세팅해줌
				login.setM_no(m_no);
				login.setPassword(encryptPw);
							
				//비밀번호 변경
				service.changePw(login);
				
				//사용자에게 임시 비밀번호 메일 보내기
				String senderName = "비밀번호 알리미";
				String senderMail = "0302mong@gmail.com";
				String subject = "요청하신 임시 비밀번호를 보냈습니다.";
				String message = "요청하신 임시 비밀번호는 " + password + " 입니다.\n"
						+ "로그인 후 비밀번호를 변경해 주세요.";
				
				vo.setSenderName(senderName);
				vo.setSenderMail(senderMail);
				vo.setSubject(subject);
				vo.setMessage(message);	

				String result = email.sendMail(vo);			
				System.out.println(result);
			}
			else if(count == 0){
				//입력한 이메일이 db에 등록 되어있지 않는 경우
				rttr.addFlashAttribute("msg", false);
				rttr.addAttribute("value", "pw");   
				return "redirect:/find";
			}
		} catch(Exception e) {
			System.out.println(e);
			rttr.addFlashAttribute("msg", false);
			return "redirect:/";
		}
		return "redirect:/";
	}
	
}
