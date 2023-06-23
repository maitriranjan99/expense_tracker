package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.entity.User;

@WebServlet("/userRegister")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String about = req.getParameter("about");
		
		User u = new User(name, email, password, about);
		HttpSession session = req.getSession();
		
		UserDao dao = new UserDao();
		boolean f = dao.saveUser(u);
		
		if(f)
		{
			session.setAttribute("msg","Register successfully");
			resp.sendRedirect("register.jsp");
		}
		else
		{
			session.setAttribute("msg", "Register Unsuccessful");
			resp.sendRedirect("register.jsp");
		}
	}
}