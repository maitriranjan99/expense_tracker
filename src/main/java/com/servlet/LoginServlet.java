package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao();
		HttpSession session = req.getSession();
		
		try {
			
			User u = dao.login(email, password);
			session.setAttribute("loginUser", u);
			resp.sendRedirect("home.jsp");

		} 
		catch (Exception e) {

			session.setAttribute("msg", "invalid email and password");
			resp.sendRedirect("login.jsp");
		}
	}

}
