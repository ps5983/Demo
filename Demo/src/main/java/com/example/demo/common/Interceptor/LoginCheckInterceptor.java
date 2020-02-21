package com.example.demo.common.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)//인터셉터에 들어갈때
	// 컨트롤러에서 건건히 로그인체크할게 아니고 여기 인터셉터에서 한번에 로그인 체크 해줌 
			throws Exception {
		HttpSession session = request.getSession(true);
		
		if(session.getAttribute("LOGIN_USER") == null) {
			response.sendRedirect(request.getContextPath()+"/loginForm");
			return false;
		}
			
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,//클라이언트(브라우저)한테까지 응답 가기 전단계
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)//나갈때(다 보내줬을때)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
