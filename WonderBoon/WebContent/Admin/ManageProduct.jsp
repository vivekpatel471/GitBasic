

        <%@ page import = "java.util.List" %>
    <%@ page import="java.util.ArrayList"%>
<%@page import="bean.ProductBean"%>


<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>
<html>
<head>
<title>Manage Product</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Modern Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
 <!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Graph CSS -->
<link href="css/lines.css" rel='stylesheet' type='text/css' />
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- jQuery -->
<script src="js/jquery.min.js"></script>
<!----webfonts--->
<link href='http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900' rel='stylesheet' type='text/css'>
<!---//webfonts--->  
<!-- Nav CSS -->
<link href="css/custom.css" rel="stylesheet">
<!-- Metis Menu Plugin JavaScript -->
<script src="js/metisMenu.min.js"></script>
<script src="js/custom.js"></script>
<!-- Graph JavaScript -->
<script src="js/d3.v3.js"></script>
<script src="js/rickshaw.js"></script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

      <div><br><br><br></div>
	   <h1 align = "center"><font color="#CC6633" face="Algerian"><u>Manage Product</u></font></h1><br><br>
		 
		 <div class="panel panel-warning" data-widget="{&quot;draggable&quot;: &quot;false&quot;}" data-widget-static="">
				<div class="panel-body no-padding">
					<table class="table table-striped">
					
					<% 
List<ProductBean> ListOfProduct = (ArrayList<ProductBean>) request.getAttribute("ListOfProduct");

if(ListOfProduct !=null){

%>
					
					
						<thead>
							<tr class="warning">
								<th><h5><b><font color="black">Product ID</font></b></h5></th>
								<th><h5><b><font color="black">Product Name</font></b></h5></th>
								
								<th><h5><b><font color="black">Description</font></b></h5></th>
								<th><h5><b><font color="black">Price</font></b></h5></th>
								<th><h5><b><font color="black">Quantity</font></b></h5></th>
								<th><h5><b><font color="black">Image</font></b></h5></th>
								<th><h5><b><font color="black">Category ID</font></b></h5></th>
								<th><h5><b><font color="black">Edit</font></b></h5></th>
								<th><h5><b><font color="black">Delete</font></b></h5></th>
								
							</tr>
						</thead>
						<tbody>
							<tr>
							
							<%
				for(int i=0;i<ListOfProduct.size();i++){
				ProductBean user = ListOfProduct.get(i);

%>
<td><b><%= user.getProduct_id()  %></b></td>
<td><b><%= user.getP_name()  %></b></td>
<td><b><%= user.getP_description()  %></b></td>
<td><b><%= user.getPrice()  %></b></td>
<td><b><%= user.getQuantity()  %></b></td>
<td><b><img src="<%= user.getP_image()  %>" height="100" width="100"></b></td>
<td><b><%= user.getCategory_id()  %></b></td>
<td><a href="../Admin/ProductEditServlet?product_id=<%=user.getProduct_id()%>"><img src="images/user_edit.png"></a></td>
<td><a href= "../Admin/ProductDeleteServlet?product_id= <%= user.getProduct_id() %>" ><img src="images/trash.png"> </a> </td>

</tr>
<% } %>
<% } 
else {
	%>
	<h1>No Records found</h1>
<%}
	
	
	%>

							
						</tbody>
					</table>
			</div>
			<a href="ProductInsert.jsp"><img src="images/add.png" height="40" width="90" style="margin-left:800px";></a>
					
				</div>
	

	</div>
		 <jsp:include page="footer.jsp"></jsp:include>
		 
		 		
</body>
</html>
