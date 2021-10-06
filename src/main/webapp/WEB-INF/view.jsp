]
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>View Expense</h1>
		<a href="/">Back</a>
		<h3>
			Name: <c:out value="${expense.name}" />
		</h3>

		<h3>
			Vendor: <c:out value="${expense.vendor }" />
		</h3>
		<h3>
			Description: <c:out value="${expense.description }" />
		</h3>
		<h3>
			Amount: $<c:out value="${expense.amount }" />
		</h3>

	</div>
</body>
</html>