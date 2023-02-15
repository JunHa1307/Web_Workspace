package com.kh.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class memberDeleteController
 */
@WebServlet("/delete.me")
public class memberDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userPwd = request.getParameter("userPwd");
		String userId = ((Member)request.getSession().getAttribute("loginUser")).getUserId();
		
		// 로그인한 회원의 정보를 얻어오는 방법
		// 방법1. session영역에 담겨있는 회원 객체로부터 뽑아내기
		// 방법2. input type="hidden"으로 회원정보를 숨겨서 요청시 함께 전달하기
		
		int result = new MemberService().deleteMember(userId,userPwd);
		
		
		HttpSession session = request.getSession();
		
		if(result > 0) {
			// 먼저 세션 안에 담긴 데이터를 날린 후에 alertMsg만 추가
			//session.invalidate();
			
			session.setAttribute("alertMsg", "회원탈퇴 성공.");
			
			// 세션에서 loginUser정보만 지워줌
			session.removeAttribute("loginUser");
			
			// invalidate() 메소드는 사용시 세션이 만료되어 안에 들어간 데이터가 모두 날라감 --> alertMsg 호출불가
			// removeAttribute("loginUser") : 로그인한 사용자의 정보를 지워줌
			response.sendRedirect(request.getContextPath()+"/myPage.me");
			
			// 로그아웃처리를 로그아웃서블릿에 위임하는 방법
			// response.sendRedirect(request.getContextPath()+"logout.me");
			
		}else {
			session.setAttribute("alertMsg", "회원탈퇴 실패.");
			response.sendRedirect(request.getContextPath()+"/myPage.me");
		}
		
	}

}
