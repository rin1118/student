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

import com.test.service.LoginService;
import com.test.vo.DepartmentVO;
import com.test.vo.LoginVO;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	LoginService service;
	
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
}
