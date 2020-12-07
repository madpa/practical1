<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="abc.insert?p=1" method="post">
	
	<input type="text" name="purchaser_name"  placeholder="Enter Name.." ><br/></br>
	<input type ="number" name="Amountpaid" placeholder="Enter Amount"></br></br> 
		<select name="item">
			<option selected="selected">---Select Item---</option>
			<option value = "Coke">Coke  25 Rs</option>
			<option value = "Pepsi">Pepsi 35 Rs</option>
			<option value = "Soda">Soda 45 Rs</option>
		</select></br></br>
	<input type="number" name="qty"></br></br>
		
	<button type="submit">Submit</button></br></br>	
	</form>
	
	<%= request.getAttribute("msg") %>
	
	<table border="1dp">
		<tr> 
			<th>Sr No.</th>
			<th>Purchaser Name</th>
			<th>Item</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>Action</th>
		</tr>
		<% 
		if(request.getAttribute("rs") != null){
		ResultSet r = (ResultSet) request.getAttribute("rs");
			int i = 1; 
			while(r.next()){
		%>
		<tr>
			<td><%= i++ %></td>
			<td><%= r.getString("p_name")%></td>
			<td><%= r.getString("item") %></td>
			<td><%= r.getString("qty") %></td>
			<td><%= r.getInt("price") %></td>
			<td><button onclick="del(<%= r.getString("p_id")%>)">Delete</button></td>
		
		<%}}%>
	</table></br></br>
	
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

<script type="text/javascript">

function del(name) {

 	window.location.href=("abc.insert?id="+name+"&val=pur");
	
}


</script>
</html>