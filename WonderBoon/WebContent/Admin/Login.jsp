<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>Untitled Document</title>

<%
	String msg = (String) session.getAttribute("getAlert");
	if (msg != null) {
%>
<script type="text/javascript">
	function msg() { alert("Inavlid Username or Password!!!!!!");} 
	 setTimeout(msg,500);
	  
	 
</script>

<%
	}
%> 
<style>
.one {
	width: 400px;
	height: 70px;
	background-image: url(pexels-photo-953214.jpeg);
	margin-left: 450px;
	margin-top: 150px;
	border-top-right-radius: 20px;
	border-top-left-radius: 20px;
}

.frm {
	height: 230px;
	width: 400px;
	border-bottom-right-radius: 20px;
	border-bottom-left-radius: 20px;
	margin-left: 450px;
	border: 0px solid #666;
	box-shadow: 0px 8px 14px 0px #ffffff;
}

.txt {
	width: 320px;
	font-size: 18px;
	border-radius: 20px;
	box-shadow: 0px 4px 10px 0px #000000;
	transition: all 1s;
}

.btn {
	width: 90px;
	height: 40px;
	background-image: url(pexels-photo-953214.jpeg);
	margin-left: 130px;
	color: #FFFFFF;
	font-family: Times New Roman;
	border-radius: 10px;
	font-size: 24px;
	margin-top: 22px;
}

h1 {
	text-align: center;
	line-height: 80px;
	color: #FFFFFF;
	font-family: Algerian;
	font-size: 26px;
}

.two {
	height: 290px;
	width: 400px;
	margin: left:300px;
}

.tbl {
	margin-top: 20px;
	margin-left: 20px;
}

label {
	font-style: italic;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 16px;
	color: #FFFFFF;
}
</style>
</head>
<body background="wp2993820 - Copy.jpg">
	<div class="one">
		<h1>Login</h1>
	</div>
	<div class="two">
		<form action="../AdminLoginServlet" class="frm">

			<table class="tbl">
				<tr>
					<td><label>Enter UserName</label></td>
				</tr>
				<tr>
					<td><input type="text" name="txtUserName" class="txt" /></td>
				</tr>
				<tr>
					<td><label>Enter Password</label></td>
				</tr>
				<tr>
					<td><input type="password" name="txtPassword" class="txt" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" class="btn" /></td>

				</tr>

			</table>

		</form>
	</div>


<% session.invalidate(); %>
</body>
</html>
