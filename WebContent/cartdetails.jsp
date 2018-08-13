<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BooksAdda Cart</title>
</head>
<style>
table{
align-content: center;
align-self: center;
border: thick;
}
td{
font-family: serif;
font-style: oblique;
font-weight: bold;
}
h3{
align-content: center;
font-family: serif;
font-weight: bolder;
}
</style>
<body>
	<div>
		<jsp:include page="header.jsp"></jsp:include>
	</div>
	<div align="center">Welcome to your Cart</div><br><br>
	<div align="right"><a href="home.app">Want to buy more?</a></div>
	<jstl:if test="${sessionScope.flag.size()>0 }">
	<table align="center" border="2" >
		<tr>
			<th>BookId</th>
			<th>Name</th>
			<th>Author</th>
			<th>Price</th>
			<th>Description</th>
			<th>Edit</th>
		</tr>
		<jstl:forEach var="book" items="${requestScope.book}">
		<tr>
			<td>${book.itemId}</td>
			<td>${book.name}</td>
			<td>${book.author}</td>
			<td>${book.price}</td>
			<td>${book.description}</td>
			<td><a href="delete.app?itemId=${book.itemId}">Delete</a></td>
			</tr>
		</jstl:forEach>
		<tr colspan="5"><h3>Total cost: Rs. ${sessionScope.total }</h3></tr>
	</table>
	</jstl:if>
	<jstl:if test="${sessionScope.flag.size()==0 }">
	<div>
	<h3>No item in your cart</h3>
	</div>
	</jstl:if>
	
</body>
</html>