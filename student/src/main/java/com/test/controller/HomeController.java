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
		
		String url;
		HttpSession session = req.getSession();		
		LoginVO login = service.login(vo);
		
		session.setMaxInactiveInterval(60*60);
		
		if(login == null) {
			url = "redirect:/login";
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		} else {
			url = "redirect:/";
			session.setAttribute("member", login);
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
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(Model mode, LoginVO vo, HttpServletRequest req, RedirectAttributes rttr) {
		
		logger.info("회원가입 처리");

		try {
			service.join(vo);
			this.login(mode, vo, req, rttr);
		} catch(Exception e) {
			System.out.println(e);
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String mypageView() {
		
		logger.info("마이페이지 뷰 화면");
		
		return "mypage";
	}
}
