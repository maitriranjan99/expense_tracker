<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<style type="text/css">
.card_sd {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="all_css_js.jsp"%>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%>
	</div>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card card_sd">
					<div class="card-header">
						<p class="text-center">Register Page</p>
						<c:if test="${not empty msg }">
							<p class="text-center text-success fs-4">${msg}</p>
							<c:remove var="msg" />
						</c:if>
					</div>
					<div class="card-body">
						<form action="userRegister" method="post">
							<div class="mb-3">
								<label>Enter Full name</label><input type="text"
									class="form-control" name="name">
							</div>
							<div class="mb-3">
								<label>Email</label><input type="email" class="form-control"
									name="email">
							</div>
							<div class="mb-3">
								<label>Password</label><input type="password"
									class="form-control" name="password">
							</div>
							<div class="mb-3">
								<label>About</label><input type="text" class="form-control"
									name="about">
							</div>
							<button class="btn btn-success col-md-12">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>