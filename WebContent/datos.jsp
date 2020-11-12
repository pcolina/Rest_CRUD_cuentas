<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>datos.jsp</title>
</head>
<body>
<form action="cuenta" method="post">
	<div>
		<label>Numero de cuenta:</label>
		<input name="numeroCuenta"/>
	</div>
	<div>
		<label>Saldo: </label>
		<input name="saldo"/>
	</div>
	<div>
		<label>Tipo de cuenta:</label>
		<input name="tipoCuenta"/>
	</div>
	<button type="submit">Enviar</button>
</form>
</body>
</html>