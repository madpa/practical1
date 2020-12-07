<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<body>
  
  <table border="1dp">
		<tr> 
			<th>Sr No.</th>
			<th>Item Name</th>
			<th>Quantity</th>
		</tr>
		<% 
		if(request.getAttribute("stock") != null){
		ResultSet r = (ResultSet) request.getAttribute("stock");
			int i = 1; 
			while(r.next()){
		%>
		<tr>
			<td><%= i++ %></td>
			<td><%= r.getString("item_name")%></td>
			<td><%= r.getString("item_qty") %></td>
			
		<%}}%>
	</table>
  
</body>
</html>