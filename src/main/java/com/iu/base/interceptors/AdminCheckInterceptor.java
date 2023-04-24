package com.iu.base.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.iu.base.member.MemberRoleVO;
import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AdminCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("interceptor 실행=================================");
		HttpSession session = request.getSession();
		Object memberVO = session.getAttribute("member");
		MemberVO vo = (MemberVO) memberVO;
		

			boolean checkAdmin = false;
			for(MemberRoleVO roleVO : vo.getRoleVOs()) {
				if(roleVO.getNum() == 1) {
					checkAdmin = true;
				}
			}
			if(checkAdmin == true) {
				return true;
			}else {				
				request.setAttribute("message", "권한이 필요합니다.");
				request.setAttribute("url", "/home");
				
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
				view.forward(request, response);
				return false;
			}
			

	}
	
	
}
