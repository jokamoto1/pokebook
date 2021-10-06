
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
		<h1>Edit Expense</h1>
		<a href="/">Back</a>
		<form:form action="/edit/${expense.id}" method="post"
			modelAttribute="expense">
			<div class="d-flex flex-column">
				<form:label path="name">Expense Name</form:label>
				<form:errors path="name" />
				<form:input path="name" value="${oneExpense.name}" />
			</div>
			<div class="d-flex flex-column">
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" value="${oneExpense.vendor }" />
			</div>
			<div class="d-flex flex-column">
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:input path="description" value="${oneExpense.description }" />
			</div>
			<div class="d-flex flex-column">
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" />
				<form:input type="number" path="amount" step=".01"
					value="${oneExpense.amount }" />
			</div>


			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>