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

import com.test.service.LectureService;
import com.test.vo.EvaluateVO;
import com.test.vo.LectureVO;
import com.test.vo.LoginVO;
import com.test.vo.SearchVO;

@Controller
@RequestMapping("/lecture/evaluate/*")
public class LectureEvaluateController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	LectureService service;

	@RequestMapping(value = "/lecture/evaluate/main", method = RequestMethod.GET)
	public String main(Model model, HttpServletRequest req) throws Exception {
		logger.info("강의 평가(학생) 메인");
		
		String url="";
		try {
			HttpSession session = req.getSession();
			
			if(session.getAttribute("member") == null) {
				url = "redirect:/login";
			} else {
				url = "/lectureEvaluate/main";
			}
			
			List<EvaluateVO> list = service.evaluateList();
			
			model.addAttribute("list", list);
		}catch (NullPointerException e) {
			return "redirect:/";
		}
		
		return url;
	}
	
	@RequestMapping(value = "/lecture/evaluate/write", method = RequestMethod.GET)
	public String writeList(Model model, HttpServletRequest req) throws Exception {
		logger.info("강의 평가 리스트(학생)");
		
		int s_no = 0; //로그인 미구현이라 임의의 값 넣어줌, 구현후에는 학번 던질꺼임
		try {
			HttpSession session = req.getSession();
			if(session != null) {
				LoginVO member = (LoginVO) session.getAttribute("member");
				s_no = member.getM_no();
			}
			
			List<LectureVO> bookList = service.lectureSignUpList(s_no);	
			model.addAttribute("bookList", bookList);

		}catch(NullPointerException e) {
			return "redirect:/";
		}
				
		return "/lectureEvaluate/write";
	}
	
	@RequestMapping(value = "/lecture/evaluate/writeView", method = RequestMethod.GET)
	public String writeView(Model model, LectureVO vo) throws Exception {
		logger.info("강의 평가(학생) 작성 뷰");
		
		try {
			model.addAttribute("l_no", vo.getL_no());
			model.addAttribute("category", vo.getCategory());
			model.addAttribute("title", vo.getTitle());
			model.addAttribute("professor", vo.getProfessor());
		} catch(NullPointerException e) {
			return "redirect:/";
		}
		
		return "/lectureEvaluate/writeView";
	}
	
	@RequestMapping(value = "/lecture/evaluate/write", method = RequestMethod.POST)
	public String write(Model model, EvaluateVO vo, HttpServletRequest req) throws Exception {
		logger.info("강의 평가 작성 처리(학생)");
		
		int s_no = 0; //로그인 미구현이라 임의의 값 넣어줌, 구현후에는 학번 던질꺼임
		
		HttpSession session = req.getSession();
		if(session != null) {
			LoginVO member = (LoginVO) session.getAttribute("member");
			s_no = member.getM_no();
		}
		
		vo.setS_no(s_no);
		System.out.println(vo.toString());
		
		service.evaluateWrite(vo);
		
		return "redirect:/lecture/evaluate/main";
	}
	
	@RequestMapping(value = "/lecture/evaluate/update", method = RequestMethod.GET)
	public String updateView(Model model, EvaluateVO vo) throws Exception {
		logger.info("강의 평가 수정 뷰 화면(학생)");
		
		try {
			EvaluateVO result = service.evaluateOne(vo.getE_no());
			
			System.out.println(result.toString());
			
			model.addAttribute("e_no", result.getE_no());
			model.addAttribute("title", result.getTitle());
			model.addAttribute("description", result.getDescription());
			model.addAttribute("category", result.getCategory());
			model.addAttribute("professor", result.getProfessor());
		
		}catch(NullPointerException e) {
			return "redirect:/";
		}
			
		return "/lectureEvaluate/update";
	}
	
	@RequestMapping(value = "/lecture/evaluate/update", method = RequestMethod.POST)
	public String update(Model model, EvaluateVO vo) throws Exception {
		logger.info("강의 평가 수정 처리(학생)");
		
		service.evaluateUpdate(vo);
		
		return "redirect:/lecture/evaluate/main";
	}
	
	@RequestMapping(value = "/lecture/evaluate/delete", method = RequestMethod.POST)
	public String delete(Model model, EvaluateVO vo) throws Exception {
		logger.info("강의 평가 삭제 처리(학생)");
		
		service.evaluateDelete(vo.getE_no());
		
		return "redirect:/lecture/evaluate/main";
	}
	
	@RequestMapping(value = "/lecture/evaluate/search", method = RequestMethod.GET)
	public String search(Model model, SearchVO vo) throws Exception {
		logger.info("강의 평가 검색");
		System.out.println(vo.toString());
		try {
			List<EvaluateVO> list = service.search(vo);
			
			model.addAttribute("search", list);
			model.addAttribute("count", list.size());
		}catch(NullPointerException e) {
			return "redirect:/";
		}
		
		return "/lectureEvaluate/main";
	}
}
