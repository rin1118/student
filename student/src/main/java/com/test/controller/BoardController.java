package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.service.BoardService;
import com.test.vo.BoardVO;
import com.test.vo.Criteria;
import com.test.vo.PageMaker;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/board/main", method = RequestMethod.GET)
	public String board(Model model, Criteria cri) throws Exception {
		logger.info("게시판 메인");
		
		model.addAttribute("list", service.list(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "/board/board";
	}
	
//	@RequestMapping(value = "/board/main", method = RequestMethod.GET)
//	public String board(Model model) throws Exception {
//		logger.info("게시판 메인");
//		List<BoardVO> list = service.getList();
//		model.addAttribute("list", list);
//		return "/board/board";
//	}
	
	@RequestMapping(value = "/board/detail", method = RequestMethod.GET)
	public String boardDetail(Model model, HttpServletRequest request) throws Exception {
		logger.info("게시글 디테일 페이지");
		int b_no =  Integer.parseInt(request.getParameter("id"));
		BoardVO vo = service.selectOne(b_no);
		model.addAttribute("id", vo.getB_no());
		model.addAttribute("title", vo.getTitle());
		model.addAttribute("writer", vo.getWriter());
		model.addAttribute("content", vo.getContent());
		return "/board/boardDetail";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String getWrite() {
		logger.info("글 작성 폼 보여주기!");
		return "/board/boardWrite";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String postWrite(BoardVO boardVO) throws Exception {
		logger.info("글 작성!");
		service.write(boardVO);
		return "redirect:main";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.GET)
	public String getUpdate(BoardVO boardVO, HttpServletRequest request, Model model) throws Exception {
		logger.info("글 수정!");
		int b_no =  Integer.parseInt(request.getParameter("id"));
		BoardVO vo = service.selectOne(b_no);
		model.addAttribute("id", vo.getB_no());
		model.addAttribute("title", vo.getTitle());
		model.addAttribute("writer", vo.getWriter());
		model.addAttribute("content", vo.getContent());
		return "/board/boardUpdate";
	}
	
	@RequestMapping(value = "/board/update", method = RequestMethod.POST)
	public String postUpdate(BoardVO boardVO, HttpServletRequest request) throws Exception {
		logger.info("글 수정!");
		int b_no =  Integer.parseInt(request.getParameter("id"));
		boardVO.setB_no(b_no);;
		
		service.update(boardVO);

		return "redirect:main";
	}

	@RequestMapping(value = "/board/delete", method = RequestMethod.POST)
	public String deletetWrite(BoardVO boardVO, HttpServletRequest request) throws Exception {
		logger.info("글 삭제!");
		
		int b_no = Integer.parseInt(request.getParameter("id"));
		service.delete(b_no);
		
		return "redirect:main";
	}
}



