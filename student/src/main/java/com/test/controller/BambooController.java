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
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.service.BambooService;
import com.test.vo.BambooVO;


@Controller
@RequestMapping("/bamboo/*")
public class BambooController {
	
	@Autowired
	BambooService service;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@RequestMapping(value = "/bamboo/main", method = RequestMethod.GET)
	public String main(Model model) throws Exception {
		logger.info("대나무숲 메인");
		
		List<BambooVO> list = service.getList();

		model.addAttribute("list", list);
		
		return "/bamboo/main";
	}
	
	@RequestMapping(value = 	"/bamboo/write", method = RequestMethod.GET)
	public String writeView(Model model) throws Exception {
		logger.info("대나무숲 글쓰기 view");
		
		return "/bamboo/write";
	}
	
	@RequestMapping(value = "/bamboo/write", method = RequestMethod.POST)
	public String write(Model model, BambooVO vo, HttpServletRequest req) throws Exception {
		logger.info("대나무숲 글쓰기 처리");
		
		String ip = req.getHeader("X-Forwarded-For");
		if (ip == null) ip = req.getRemoteAddr();
		vo.setIp(ip);
		
		service.write(vo);
		
		return "redirect:/bamboo/main";
	}
	
	@ResponseBody
	@RequestMapping(value = "/bamboo/favorite", method = RequestMethod.POST)
	public void faviteIncrement(int favNum, int b_no) throws Exception {
		logger.info("좋아요 up");
		System.out.println(favNum);
		System.out.println(b_no);
		
		BambooVO vo = new BambooVO();
		
		vo.setB_no(b_no);
		vo.setFavorite(favNum);
		
		service.favIncrement(vo);
	}
	
	@ResponseBody
	@RequestMapping(value = "/bamboo/notFavorite", method = RequestMethod.POST)
	public void notFavIncrement(int notFavNum, int b_no) throws Exception {
		logger.info("싫어요 up");
	
		BambooVO vo = new BambooVO();
		
		vo.setB_no(b_no);
		vo.setNotFav(notFavNum);
		
		service.notFavIncrement(vo);
	}
	
	@RequestMapping(value = "/bamboo/search", method = RequestMethod.GET)
	public String search(Model model, BambooVO vo, String category) throws Exception {
		logger.info("대나무숲 검색");
		System.out.println(vo.toString());
		
		vo.setCategory(category);		
		List<BambooVO> search = service.search(vo);

		model.addAttribute("search", search);
		
		return "/bamboo/main";
	}
	
}
