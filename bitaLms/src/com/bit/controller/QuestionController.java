package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/question.bit")
public class QuestionController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//�Ҽ� Ȯ��
		HttpSession session = req.getSession();
		int belong = (int) session.getAttribute("belong");
		
		RequestDispatcher rd = null;
		
		if(belong ==1){//��� �л�
			rd = req.getRequestDispatcher("/student/main.jsp");
		}else if(belong ==3){//������
			rd = req.getRequestDispatcher("/admin/main.jsp");
		}else if(belong ==4){//������
			rd = req.getRequestDispatcher("/lecturer/question/questionList.jsp");
		}
		rd.forward(req, resp);
	}
}
