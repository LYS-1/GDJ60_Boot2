package com.iu.base.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class memberController {
	@Autowired
	private MemberService memberService;
	
	
	
	
	@GetMapping("join")
	public ModelAndView setJoin() throws Exception{
		ModelAndView mv = new ModelAndView();
		MemberVO memberVO = new MemberVO();
		mv.setViewName("member/join");
		mv.addObject(memberVO);
		return mv;
	}
	
	@PostMapping("join")
	public ModelAndView setJoin(@Valid MemberVO memberVO, BindingResult bindingResult) throws Exception{
		
		ModelAndView mv = new ModelAndView();
		
		boolean check = memberService.pwCheck(memberVO, bindingResult);
		
		if(check) {
			mv.setViewName("member/join");
			return mv;
		}
		
		
		int result = memberService.setJoin(memberVO);
		
		mv.setViewName("member/login");
		
		return mv;
	}

	
	@GetMapping("login")
	public ModelAndView getLogin() throws Exception{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("./member/login");
		return mv;
	}
	
	@GetMapping("logout")
	public ModelAndView getLogOut(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:/home");
		return mv;
	}
	
	
	@PostMapping("login")
	public ModelAndView getLogin(MemberVO memberVO, HttpSession session,String remember,HttpServletRequest response) throws Exception{
		ModelAndView mv = new ModelAndView();
		memberVO = memberService.getLogin(memberVO);
		
		session.setAttribute("member", memberVO);

		mv.setViewName("redirect:./login");
		if(memberVO !=null) {
        	mv.setViewName("redirect:/home");
		}	
		return mv;
	}
	
	@GetMapping("idDuplicateCheck")
	@ResponseBody
	public boolean idDuplicateCheck(MemberVO memberVO) throws Exception{
		//log.debug("==========id중복체크===========");
		boolean check = false;
		long ch = memberService.getCheckId(memberVO);
		System.out.println(ch);
		if(ch > 0) {
			check = true;
		}
		
		return check;
	}
	@GetMapping("mypage")
	public void getMypage() throws Exception{
		
	}
	@GetMapping("admin")
	public void getAdmin() throws Exception{
		
	}
}
