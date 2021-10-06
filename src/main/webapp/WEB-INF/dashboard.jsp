
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %> 
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
		<h1>All Expenses</h1>
		<table class="table table-bordered">
			<tr>
				<th>ID</th>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
			</tr>
			<c:forEach var="oneExpense" items="${expenses}">
				<tr>
					<td><c:out value="${oneExpense.id}"></c:out></td>
					<td><c:out value="${oneExpense.name}"></c:out></td>
					<td><c:out value="${oneExpense.vendor}"></c:out></td>
					<td>$<c:out value="${oneExpense.amount}"></c:out></td>
				</tr>
			</c:forEach>
		</table>
		<form:form action="/create" method="post" modelAttribute="expense">
		<div>
				<form:label path="name">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" />
		</div>
		<div>
				<form:label path="vendor">Vendor</form:label>
				<form:errors path="vendor" />
				<form:input path="vendor" />
		</div>
			<div>
				<form:label path="description">Description</form:label>
				<form:errors path="description" />
				<form:input  path="description" />
			</div>
			<div>
				<form:label path="amount">Amount</form:label>
				<form:errors path="amount" />
				<form:input type="number" path="amount" step=".01" />
			</div>
		
		
			<input type="submit" value="Submit" />
		</form:form>
	</div>
</body>
</html>