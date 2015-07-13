<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*,transactional.context.ejb.sample.persistence.Product"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>Sample</title>
</head>

<body>

	<form method="POST" action="case1">
	<b>Case 1:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>

	<br/>
	
	<form method="POST" action="case2">
	<b>Case 2:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>
	
	<br/>

	<form method="POST" action="case3">
	<b>Case 3:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>

	<br/>
	
	<form method="POST" action="case4">
	<b>Case 4:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>
	
	<br/>

	<form method="POST" action="case5">
	<b>Case 5:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>
	
	<br/>

	<form method="POST" action="case6">
	<b>Case 6:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>
	
	<br/>	
	
	<form method="POST" action="case7">
	<b>Case 7:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>

	<br/>

	<form method="POST" action="case8">
	<b>Case 8:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>
	
	<br/>
	
	<form method="POST" action="case9">
	<b>Case 9:</b>
		Product 1: <input type="text" name="productName1" /> Product 2: <input
			type="text" name="productName2" /> <input type="submit"
			value="submit" />
	</form>

	<hr>
	<ul>
		<%
			@SuppressWarnings("unchecked")
			List<Product> productList = (List<Product>) request.getAttribute("productList");
			if (productList != null) {
				for (Product product : productList) {
		%>
		<li><%=product%></li>
		<%
			}
			}
		%>
	</ul>
	<hr>

</body>
</html>