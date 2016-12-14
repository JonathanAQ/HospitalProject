<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listar Pacientes</title>
<link rel="shortcut icon"
	href="http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg">
<style>
body {
	background-image:
		url(http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg);
	margin: 0;
	text-align: center;
	font-family: Calibri;
	font-size: 14px;
	 font-weight: bold;
}
</style>
</head>
<body>
	<table border="1" cellpadding="10">
		<tr>
			<th>Nome</th>
			<th>Mae</th>
			<th>Pai</th>
			<th>RG</th>
		</tr>

		<c:forEach var="paciente" items="${pacientes}">
			<tr>
				<td>${paciente.nomePaciente}</td>
				<td>${paciente.nomeMae}</td>
				<td>${paciente.nomePai}</td>
				<td>${paciente.rg}</td>

			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>

