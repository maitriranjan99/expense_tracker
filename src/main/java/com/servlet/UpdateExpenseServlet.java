package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ExpenseDao;
import com.entity.Expense;
import com.entity.User;
@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String title = req.getParameter("title");
		String date = req.getParameter("date");
		String time = req.getParameter("time");
		String description = req.getParameter("description");
		double price = Double.parseDouble(req.getParameter("price")) ;
		
		HttpSession session = req.getSession();
		User u = (User) session.getAttribute("loginUser");
		
		Expense e = new Expense(title, date, time, description, price, u);
		e.setId(id);
		
		ExpenseDao dao = new ExpenseDao();
		boolean f = dao.updateExpense(e);
		
		if(f)
		{
			session.setAttribute("msg","Expense updated successfully");
			resp.sendRedirect("view_expense.jsp");
		}
		else
		{
			session.setAttribute("msg", "Something wrong");
			resp.sendRedirect("view_expense.jsp");
		}
		
	}

}
