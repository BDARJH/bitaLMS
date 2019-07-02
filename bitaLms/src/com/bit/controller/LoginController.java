package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit.model.UserDao;

@WebServlet("/login/form.bit")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("form.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//계정 정보 가져오기
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int belong =0;
		
		UserDao dao = new UserDao();
		
		// 아이디와 패스워드를 가지고 입력하면 리턴값으로 belong(소속 번호)를 받는다.
		// belong이 -1 : 회원이 아님, 0 : 등록전 학생 , 1 : 등록학생, 2:영업팀, 3:행정팀, 4:강사
		belong = dao.login(id,pw);
		
		
		if(belong <=-1 || belong >=5){//회원이 아닌 경우
			
			//등록 회원만 가능하다는 메세지
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"id와 pw를 다시확인\")</script>");
			doGet(req, resp);
		}else if(belong ==0){
			//등록 회원만 가능하다는 메세지
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"등록 회원이 아닙니다.\")</script>");
			doGet(req, resp);
		}else if(belong ==2){//회원
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"영업팀은 홈페이지 관리.\")</script>");
			doGet(req, resp);
			
		}else{// 등록 학생, 강사, 영업팀
			//session으로 페이지 이동시에도 사용가능하게 함
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("belong", belong);
			resp.sendRedirect(req.getContextPath()+"/main.bit");
		}
		
	}

}
