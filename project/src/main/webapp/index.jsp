<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath }" />
<spring:url var="css" value="/css" />

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Basic project">
<meta name="author" content="Abir Hosen">

<title>${title }</title>

<link href="${css}/app.css" rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

</head>

<body>

	<div class="container">
		<div class="row">
			<nav class="navbar navbar-light bg-light">
				<div class="container-fluid">
					<div>
						<ul class="nav">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="${contextRoot }/ ">Home</a></li>
							<security:authorize access="isAuthenticated()">
								<li class="nav-item"><a class="nav-link"
									href="${contextRoot }/profile">Profile</a></li>
							</security:authorize>
						</ul>
					</div>

					<div class="d-flex">
						<ul class="nav">
							<security:authorize access="!isAuthenticated()">
								<li class="nav-item"><a class="nav-link active"
									aria-current="page" href="${contextRoot }/signup">Registration</a>
								</li>
								<li class="nav-item"><a class="nav-link"
									href="${contextRoot }/login">Login</a></li>
							</security:authorize>
							<security:authorize access="isAuthenticated()">
								<li class="nav-item"><a class="nav-link"
									href="${contextRoot }/logout">Logout</a></li>
							</security:authorize>
						</ul>
					</div>

				</div>
			</nav>
		</div>
		<br> <br>

		<div class="row justify-content-md-center">

			<c:if test="${userClickHome==true }">
				<%@ include file="pages/home.jsp"%>
			</c:if>

			<c:if test="${userClickProfile==true }">
				<%@ include file="pages/profile.jsp"%>
			</c:if>

			<c:if test="${userClickEdit==true }">
				<%@ include file="pages/edit.jsp"%>
			</c:if>

			<c:if test="${userClickLogin==true }">
				<%@ include file="login.jsp"%>
			</c:if>

			<c:if test="${userClickSignUp==true }">
				<%@ include file="signup.jsp"%>
			</c:if>
		</div>
	</div>

</body>
</html>