<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="RSI.cursos.model.Cuenta,java.util.List "%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
     <script src="https://ajax.googleapis.com/ajax/libs/d3js/6.2.0/d3.min.js"></script> 

</head>
<body>
<div>
	<table>
		<thead><tr><th>Numero de cuenta</th> <th>Saldo</th> <th>Tipo de cuenta</th></tr></thead>
		<tbody>
		<%List<Cuenta> cuentas=(List<Cuenta>)request.getAttribute("cuentas");
		for(Cuenta c:cuentas){%>
		<tr>
			<td><%=c.getNumeroCuenta() %></td>
			<td><%=c.getSaldo() %></td>
			<td><%=c.getTipoCuenta() %></td>
		</tr>
		<%}%>
		</tbody>
	</table>
</div>
<br/>
<a href="volver">VOLVER</a>
</body>
</html>