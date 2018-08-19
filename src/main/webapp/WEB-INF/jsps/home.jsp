<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<div>
		<div>
			<h1>Player Registration</h1>
			<h5>${message}</h5>
		</div>
		<div>
			<form action="${pageContext.request.contextPath}/regPlayer" method="POST">
				Player Id : <input type="text" name="palyerId"></br>
				Player Name : <input type="text" name="playerName"></br>
				Email : <input type="email" name="email"></br>
				Mobile : <input type="text" name="mobile"></br>
				Matches : <input type="text" name="matches"></br>
				Centuries : <input type="text" name="centuries"></br> 
				<input type="submit" value="Player Registration">
			</form>
		</div>
	</div>
</body>
</html>