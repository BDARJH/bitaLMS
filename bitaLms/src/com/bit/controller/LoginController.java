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
		//���� ���� ��������
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		int belong =0;
		
		UserDao dao = new UserDao();
		
		// ���̵�� �н����带 ������ �Է��ϸ� ���ϰ����� belong(�Ҽ� ��ȣ)�� �޴´�.
		// belong�� -1 : ȸ���� �ƴ�, 0 : ����� �л� , 1 : ����л�, 2:������, 3:������, 4:����
		belong = dao.login(id,pw);
		
		
		if(belong <=-1 || belong >=5){//ȸ���� �ƴ� ���
			
			//��� ȸ���� �����ϴٴ� �޼���
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"id�� pw�� �ٽ�Ȯ��\")</script>");
			doGet(req, resp);
		}else if(belong ==0){
			//��� ȸ���� �����ϴٴ� �޼���
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"��� ȸ���� �ƴմϴ�.\")</script>");
			doGet(req, resp);
		}else if(belong ==2){//ȸ��
			req.setAttribute("errmsg", "<script type=\"text/javascript\">alert(\"�������� Ȩ������ ����.\")</script>");
			doGet(req, resp);
			
		}else{// ��� �л�, ����, ������
			//session���� ������ �̵��ÿ��� ��밡���ϰ� ��
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			session.setAttribute("belong", belong);
			resp.sendRedirect(req.getContextPath()+"/main.bit");
		}
		
	}

}
