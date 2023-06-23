<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Expense</title>
<style type="text/css">
.card_sd {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="all_css_js.jsp"%>
</head>
<body>
	<c:if test="${empty loginUser}">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	<div>
		<%@include file="navbar.jsp"%>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card card_sd">
					<div class="card-header text-center">
						<p class="fs-3">Add Expense</p>
						<c:if test="${not empty msg }">
							<p class="text-center text-danger fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="saveExpense" method="post">
							<div class="mb-3">
								<label>Title</label> <input type="text" name="title"
									class="form-control" />
							</div>
							<div class="mb-3">
								<label>Date</label> <input type="date" name="date"
									class="form-control" />
							</div>
							<div class="mb-3">
								<label>Time</label> <input type="time" name="time"
									class="form-control" />
							</div>
							<div class="mb-3">
								<label>Description</label> <input type="text" name="description"
									class="form-control" />
							</div>
							<div class="mb-3">
								<label>Price</label> <input type="text" name="price"
									class="form-control" />
							</div>
							<button class="btn btn-success col-md-12">Add</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>