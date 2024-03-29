package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main.bit")
public class MainController extends HttpServlet {
	//url을 다 main으로 할 수 있음 + 메인 controller를 하나만 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//소속 확인
		HttpSession session = req.getSession();
		int belong = (int) session.getAttribute("belong");
		
		RequestDispatcher rd = null;
		
		if(belong ==1){//등록 학생
			rd = req.getRequestDispatcher("/student/main.jsp");
		}else if(belong ==3){//행정팀
			rd = req.getRequestDispatcher("/admin/main.jsp");
		}else if(belong ==4){//강사팀
			rd = req.getRequestDispatcher("/lecturer/main.jsp");
		}
		rd.forward(req, resp);
	}
}
