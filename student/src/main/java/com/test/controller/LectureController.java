package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.LectureService;
import com.test.vo.LectureBookVO;
import com.test.vo.LectureVO;
import com.test.vo.LoginVO;


@Controller
@RequestMapping("/lecture/*")
public class LectureController {
private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	LectureService service;

	@RequestMapping(value = "/lecture/main", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		logger.info("강의(교수) 메인");
		
		List<LectureVO> list = service.getList();
		
		model.addAttribute("list", list);
		
		return "/lecture/main";
	}
	
	@RequestMapping(value = "/lecture/register", method = RequestMethod.GET)
	public String registerView(Model model) throws Exception {
		logger.info("강의 등록 뷰 화면");
		
		return "/lecture/lectureRegister";
	}
	
	@RequestMapping(value = "/lecture/register", method = RequestMethod.POST)
	public String register(Model model, LectureVO lectureVO) throws Exception {
		
		logger.info("강의 등록");
		service.register(lectureVO);
		
		return "redirect:/lecture/main";
	}
	
	@RequestMapping(value = "/lecture/update", method = RequestMethod.GET)
	public String updateView(Model model, HttpServletRequest request) throws Exception {
		logger.info("강의 수정 뷰화면");
		
		int l_no = Integer.parseInt(request.getParameter("id"));
		LectureVO vo = service.selectOne(l_no);
		model.addAttribute("id", vo.getL_no());
		model.addAttribute("category", vo.getCategory());
		model.addAttribute("title", vo.getTitle());
		model.addAttribute("professor", vo.getProfessor());
		model.addAttribute("description", vo.getDescription());
		
		return "/lecture/lectureUpdate";
	}
	
	@RequestMapping(value = "/lecture/update", method = RequestMethod.POST)
	public String update(Model model, LectureVO lectureVO) throws Exception {
		logger.info("강의 수정");
		
		System.out.println(lectureVO.getL_no());
		
		service.update(lectureVO);
		
		return "redirect:/lecture/main";
	}
	
	@RequestMapping(value = "/lecture/delete", method = RequestMethod.POST)
	public String delete(Model model, LectureVO lectureVO) throws Exception {
		logger.info("강의 삭제");
		
		int l_no = lectureVO.getL_no();
		service.delete(l_no);
		
		return "redirect:/lecture/main";
	}
	
	//수강신청
	
	@RequestMapping(value = "/lecture/signUp", method = RequestMethod.GET)
	public String signUpView(Model model, HttpServletRequest req) throws Exception {
		logger.info("수강신청 메인");
		
		String url="";
		
		HttpSession session = req.getSession();
		int s_no=0; //로그인 미구현이라 임의의 값 넣어줌, 구현후에는 학번 던질꺼임
		
		if(session != null) {
			if(session.getAttribute("member") == null) {
				url = "redirect:/login";
			} else {
				url = "/lectureBook/main";
				LoginVO member = (LoginVO) session.getAttribute("member");
				s_no = member.getM_no();				
			}
		} else {
			url = "redirect:/login";
		}
		
		List<LectureVO> lectureList = service.getList();
		model.addAttribute("lectureList", lectureList);
		
		List<LectureVO> bookList = service.lectureSignUpList(s_no);	
		model.addAttribute("bookList", bookList);

		return url;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/lecture/signUp", method = RequestMethod.POST)
	public Object lectureSignUp(Model model,  LectureBookVO bookVO, HttpServletRequest req) throws Exception {
		logger.info("수강신청 처리");
		
		int s_no  = 0;//학번
		
		HttpSession session = req.getSession();
		if(session != null) {
			LoginVO member = (LoginVO) session.getAttribute("member");
			s_no = member.getM_no();
		}
		
		bookVO.setS_no(s_no); //로그인 미구현이라 임의의 값 넣어줌, 구현후에는 학번 던질꺼임
		
		service.lectureSignUp(bookVO);

		List<LectureVO> bookList = service.lectureSignUpList(s_no);	
		model.addAttribute("bookList", bookList);
		System.out.println(bookList);
		
		return bookList;
	}
	
	@ResponseBody
	@RequestMapping(value = "/lecture/signUpCancel", method = RequestMethod.POST)
	public void signUpCancel(Model model,  LectureBookVO bookVO) throws Exception {
		logger.info("수강신청 취소 처리");
		
		int l_no = bookVO.getL_no();
		service.signUpCancel(l_no);
		
//		return l_no;
	}

}
