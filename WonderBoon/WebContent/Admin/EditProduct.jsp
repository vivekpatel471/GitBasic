<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.frm {
	height: 400px;
	width: 800px;
	border-bottom-right-radius: 20px;
	border-bottom-left-radius: 20px;
	border-top-right-radius: 20px;
	border-top-left-radius: 20px;
	background-color: white;
	margin-left: 100px;
	border: 1px solid #666;
	box-shadow: 0px 8px 14px 0px #000000;
}

.txt {
	width: 380px;
	font-size: 14px;
	border-radius: 20px;
	box-shadow: 0px 4px 10px 0px #000000;
	transition: all 1s;
}

.btn {
	width: 100px;
	height: 40px;
	background-image: url("pexels-photo-953214.jpeg"); //
	background-color: blue;
	margin-left: 100px;
	color: #FFFFFF;
	font-family: "Times New Roman";
	border-radius: 10px;
	font-size: 24px;
	margin-top: 20px;
}

h1 {
	text-align: center;
	line-height: 80px;
	color: #FFFFFF;
}

.two {
	height: 290px;
	width: 480px;
	margin: left:300px;
}

.tbl {
	margin-top: 20px;
	border-collapse: separate;
	border-spacing: 60px 10px;
	cell-padding: 10px;
}

label {
	font-style: italic;
	font-face: arial;
	font-size: 18px;
	color: black;
}

.txt:hover { //
	transform: scale(1.5);
	background-color: #99CC99;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<h1 align="center">
		<font color="#CC6633" face="Algerian"><u>Manage Product</u></font>
	</h1>
	<br>
	<br>

	<div class="two">
		<form method="post" action="../Admin/ProductUpdateServlet" class="frm"
			enctype="multipart/form-data">

			<input type="hidden" name="product_id" id="product_id"
				value="${user.product_id}">

			<table class="tbl" align="center">

				<tr>
					<td><label>Product Name</label></td>
					<td><input type="text" name="txtProductName" class="txt"
						value=${user.p_name } /></td>
				</tr>
				<tr>
					<td><label> Description&nbsp;</label></td>
					<td><input type="textarea" name="txtDescription" class="txt"
						value=${user.p_description } /></td>
				</tr>
				<tr>
					<td><label>Product Price</label></td>
					<td><input type="text" name="txtPrice" class="txt"
						value=${user.price } /></td>
				</tr>
				<tr>
					<td><label>Product Quantity</label></td>
					<td><input type="text" name="txtQuantity" class="txt"
						value=${user.quantity } /></td>
				</tr>
				<tr>
					<td><label>Product Image</label></td>
					<td><input type="file" name="txtImage" class="txt"
						value=${user.p_image } /></td>
				</tr>
				<tr>
					<td><label>Category ID</label></td>
					<td><input type="text" name="txtCategory_id" class="txt"
						value=${user.category_id } /></td>
				</tr>





				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update" class="btn" /></td>
				</tr>
			</table>
		</form>
	</div>
	<div>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>