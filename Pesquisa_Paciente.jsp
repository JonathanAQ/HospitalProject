<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>HFJN - PESQUISA DE PACIENTE</title>
<link rel="shortcut icon"
	href="http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg">
<style>
body {
	background-image:
		url(http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg);
	margin: 0;
	text-align: center;
}

h1, h2, h3, h4 {
	font-weight: inherit;
	font-family: "Calibri";
	color: #363636;
}

hr {
	border: 0;
	border-top: 1px solid #ddd;
}

#corpo {
	margin: 50px 150px;
}

#formulario {
	text-align: left;
	margin: 0 0px;
	font-family: "Calibri";
}

#formulario .direita {
	float: right;
	width: 50%;
}

#formulario .esquerda {
	float: left;
	width: 50%;
}

#formulario label {
	line-height: 30px;
	text-align: left;
	color: #363636;
}

#formulario input {
	padding: 9px;
	border: 1px solid #CCCCCC;
	background: #E8EFE4;
	border-radius: 4px;
	color: #363636;
}

#formulario select {
	padding: 9px;
	border: 1px solid #CCCCCC;
	background: #E8EFE4;
	border-radius: 4px;
	color: #363636;
}

#formulario .botao {
	cursor: pointer;
	text-align: left;
	margin: 50px 0 0 0;
	color: #FFF;
	background-color: #363636;
}

#formulario .botao:hover {
	background-color: #363636;
}

#copy {
	color: #363636;
	text-align: center;
	margin: 50px 150px;
}
</style>
<div id="h1">
	<h1 algn=justify>
		<b>HOSPITAL FACULDADE JOAQUIM NABUCO</b>
	</h1>
</div>
<div id="h3">
	<h3 algn=justify>
		<b>PESQUISA DE PACIENTE</b>
	</h3>
</div>
</head>
<body>
	<!-- Corpo -->
	<div id="corpo">
		<!-- Formulário -->
		<div id="formulario">
			<form action="upDatePacienteServlet" method="POST">
				<c:set var="isPacienteCheio" value="${not empty paciente}" />

				<div class="esquerda" id="">
					<label for="pront"><b>Prontuário:</b></label><br> <input
						type="text" name="pront" size="10" placeholder="Prontuário" required
						value='<c:if test="${isPacienteCheio}">${paciente.prontuario}</c:if>'>
				</div>
				<div class="data direita" id="">
					<label for="data_de_nascimento"><b>Data de Nascimento:</b></label><br>
					<input type="text" size="25" name="data" placeholder="__/__/____"
					value='<c:if test="${isPacienteCheio}">${paciente.dtNascimento}</c:if>'>
				</div>
				<div class="esquerda" id="">
					<label for="nome"><b>Nome Completo:</b></label><br> <input
						type="text" name="nome" size="35" placeholder="Nome Completo"
						value='<c:if test="${isPacienteCheio}">${paciente.nomePaciente}</c:if>' /><br />
				</div>
				<div class="rg esquerda" id="">
					<label for="rg"><b>RG:</b></label><br> <input type="text"
						name="rge" size="25" placeholder="00.000.000-0"
						value='<c:if test="${isPacienteCheio}">${paciente.rg}</c:if>'>
				</div>
				<div class="cpf direita" id="">
					<label for="cpf"><b>CPF:</b></label><br> <input type="text"
						name="cpf" size="25" placeholder="000.000.000-0"
						value='<c:if test="${isPacienteCheio}">${paciente.cpf}</c:if>'>
				</div>
				<div class="esquerda" id="">
					<label for="filiacao_pai"><b>Pai:</b></label><br> <input
						type="text" name="pai" size="30" placeholder="Nome do Pai"
						value='<c:if test="${isPacienteCheio}">${paciente.nomePai}</c:if>' /><br />
				</div>
				<div class="direita" id="">
					<label for="filiacao_mae"><b>Mãe:</b></label><br> <input
						type="text" name="mae" size="25" placeholder="Nome da Mãe"
						value='<c:if test="${isPacienteCheio}">${paciente.nomeMae}</c:if>'>
				</div>
				<div class="esquerda" id="">
					<label for="Tipo de Consulta"><b>Tipo de Consulta:</b></label><br>
					<input type="text" name="mae" size="25" placeholder="Tipo de Consulta"
						value='<c:if test="${isPacienteCheio}">${paciente.tipoAtendimento}</c:if>'>

				</div>
				<div class="direita" id="">
					<label for="CNS"><b>CNS:</b></label><br> <input type="text"
						name="cns" size="25" placeholder="Cartão SUS"
						value='<c:if test="${isPacienteCheio}">${paciente.cns}</c:if>'>
				</div>
				<div class="telefone esquerda" id="">
					<label for="telefone"><b>Telefone:</b></label><br> <input
						type="text" name="tel" placeholder="0000-0000"
						value='<c:if test="${isPacienteCheio}">${paciente.telefoneFixo}</c:if>'>
				</div>
				<div class="celular direita" id="">
					<label for="celular"><b>Ceular:</b></label><br> <input
						type="text" name="celular" size="25" placeholder="(00) 0000-0000"
						value='<c:if test="${isPacienteCheio}">${paciente.telefoneCel}</c:if>'>
				</div>
				<c:choose>
					<c:when test="${not empty paciente}">
						<input type="submit" name="botao" value="Alterar" class="botao" />
						<input type="reset" value="Limpar Campos"
							onclick="location.href='http://localhost:8080/Hospital/Pesquisa_Paciente.jsp' "
							class="botao">
					</c:when>
					<c:otherwise>
						<input type="submit" name="botao" value="Buscar" class="botao" />
						<input type="reset" value="Limpar Campos" class="botao">
						<input type="button" value="Voltar"
							onClick="location.href='http://localhost:8080/Hospital/Cadastro_Paciente.jsp' "
							class="botao">
					</c:otherwise>
				</c:choose>
			</form>
		</div>
		<input type="image" name="Logout" class="botao"
			src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTKO51jvAArjaIlWeKJ4l-S7l8EUimDehFEzraa6sQB44RAKeRf4w"
			width="30px" height="30px"
			style="float: right; margin-right: -500px; margin-top: -400px" />
		<!-- /Formulário -->
	</div>
	<!-- /Corpo -->
</body>
</html>
