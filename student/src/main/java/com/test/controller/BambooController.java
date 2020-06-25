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
	
	@RequestMapping(value = "/bamboo/update", method = RequestMethod.GET)
	public String updateView(Model model) throws Exception {
		logger.info("대나무숲 업데이트 뷰 페이지");
		
		return "/bamboo/update";
	}
	
	@RequestMapping(value = "/bamboo/writeMessage", method = RequestMethod.GET)
	@ResponseBody
	public BambooVO writeMessage(Model model, String writer, int password, int b_no) throws Exception {
		logger.info("대나무숲 작성자명, 비밀번호를 받아 해당 작성자 글 select");
		
		System.out.println(writer);
		System.out.println(password);
		System.out.println(b_no);
		
		BambooVO vo = new BambooVO();
	
		vo.setWriter(writer);
		vo.setPassword(password);
		vo.setB_no(b_no);
		
		BambooVO result = null;
		
		try {
			result = service.writeMessage(vo);			
			model.addAttribute("result", result);
			System.out.println(result.toString());
		} catch(NullPointerException e) {
			System.out.println("비밀번호가 틀렸습니다");
		}
	
		return result;
	}
	
	@RequestMapping(value = "/bamboo/update", method = RequestMethod.POST)
	public String update(Model model, BambooVO vo) throws Exception {
		logger.info("대나무숲 업데이트 처리");
		
		System.out.println(vo.toString());
		
		service.messageUpdate(vo);
		
		return "redirect:/bamboo/main";
	}
	
	@RequestMapping(value = "/bamboo/delete", method = RequestMethod.POST)
	public String delete(Model model, int b_no) throws Exception {
		logger.info("대나무숲 삭제 처리");
		
		service.messageDel(b_no);
		
		return "redirect:/bamboo/main";
	}

}
