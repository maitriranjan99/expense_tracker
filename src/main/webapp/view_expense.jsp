<%@page import="com.entity.Expense"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.User"%>
<%@page import="com.dao.ExpenseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Expense</title>
<%@include file="all_css_js.jsp"%>
</head>
<body>
	<c:if test="${empty loginUser}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div>
		<%@include file="navbar.jsp"%>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-8 offset-md-2">
				<div class="card">
					<div class="card-header text-center">
						<p class="fs-3">All Expenses</p>
						<c:if test="${not empty msg }">
							<p class="text-center text-danger fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Title</th>
									<th scope="col">Description</th>
									<th scope="col">Date</th>
									<th scope="col">Time</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User u = (User) session.getAttribute("loginUser");
								ExpenseDao dao = new ExpenseDao();
								List<Expense> list = dao.getAllExpenseByUser(u);

								if (list.size() > 0) {

									for (Expense e : list) {
								%>
								<tr>
									<th scope="row"><%=e.getTitle()%></th>
									<td><%=e.getDescription()%></td>
									<td><%=e.getDate()%></td>
									<td><%=e.getTime()%></td>
									<td><%=e.getPrice()%></td>
									<td><a href="edit.jsp?id=<%=e.getId()%>"
										class="btn btn-sm btn-primary me-1">Edit</a> <a
										href="deleteExpense?id=<%=e.getId()%>"
										class="btn btn-sm btn-danger me-1">Delete</a></td>
								</tr>
								<%
								}
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>