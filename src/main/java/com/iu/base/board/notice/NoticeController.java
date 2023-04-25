package com.iu.base.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.base.board.SubVO;
import com.iu.base.member.memberController;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/notice/*")
@Slf4j
public class NoticeController {
	
	public ModelAndView setAdd() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		SubVO subVO = new SubVO();
		
		log.error("=========={}=========", subVO.getSubName());
		
		
		mv.setViewName("/notice/list");
		
		return mv;
	}
	
	
}
