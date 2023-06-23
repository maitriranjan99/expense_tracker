package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		HttpSession session = req.getSession();
		ExpenseDao dao = new ExpenseDao();
		boolean f = dao.deleteExpense(id);
		
		if(f)
		{
			session.setAttribute("msg","Deleted successfully");
			resp.sendRedirect("view_expense.jsp");
		}
		else
		{
			session.setAttribute("msg", "Something wrong on server");
			resp.sendRedirect("view_expense.jsp");
		}
	}
}
