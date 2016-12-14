<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<title>HFJN - CADSATRO DE PACIENTE</title>
<link rel="shortcut icon"
	href="http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg">
<style>
body {
	background-image:
		url(http://2.bp.blogspot.com/-KUY2L3m-ECA/Va5mA0AiMsI/AAAAAAAAFaE/pY5CBrpGWcc/s1600/Medicina2.jpg);
	margin: 0;
	text-align: center;
	margin: 0;
	padding: 0;
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
	font-family: "Calibri";
}

#formulario {
	text-align: left;
	margin: 0 0px;
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
	margin: 0 0 0 0;
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
		<b>HOSPITAL JOAQUIM NABUCO</b>
	</h1>
</div>
<div id="h3">
	<h3 algn=justify>
		<b>CADASTRO DE PACIENTE</b>
	</h3>
</div>
</head>
<body>
	<!-- Corpo -->
	<div id="corpo">
		<!-- Formulário -->
		<div id="formulario">
			<form action="inserirPacienteServlet" method="POST">
				<div class="data direita" id="">
					<label for="data_de_nascimento"><b>Data de Nascimento:</b></label><br>
					<input type="text" size="25" name="data" placeholder="__/__/____">
				</div>

				<div class="esquerda" id="">
					<label for="nome"><b>Nome Completo:</b></label><br> <input
						type="text" name="nome" size="35" placeholder="Nome Completo"
						required>
				</div>
				<div class="rg esquerda" id="">
					<label for="rg"><b>RG:</b></label><br> <input type="text"
						name="rge" placeholder="00.000.000-0" required>
				</div>
				<div class="cpf direita" id="">
					<label for="cpf"><b>CPF:</b></label><br> <input type="text"
						name="cpf" size="25" placeholder="000.000.000-0" required>
				</div>
				<div class="esquerda" id="">
					<label for="filiacao_pai"><b>Pai:</b></label><br> <input
						type="text" name="pai" size="30" placeholder="Nome do Pai">
				</div>
				<div class="direita" id="">
					<label for="filiacao_mae"><b>Mãe:</b></label><br> <input
						type="text" name="mae" size="25" placeholder="Nome da Mãe">
				</div>
				<div class="esquerda" id="">
					<label for="Tipo de Consulta"><b>Tipo de Consulta:</b></label><br>
					<select name="Tipo de Consulta" id="">
						<option value="Selecione">Selecione</option>
						<option value="Ambulatorio">Ambulatório</option>
						<option value="Emergencia">Emergência</option>
					</select>
				</div>
				<div class="direita" id="">
					<label for="CNS"><b>CNS:</b></label><br> <input type="text"
						name="cns" size="25" placeholder="Cartão SUS" required>
				</div>
				<div class="telefone esquerda" id="">
					<label for="telefone"><b>Telefone:</b></label><br> <input
						type="text" name="tel" placeholder="0000-0000">
				</div>
				<div class="celular direita" id="">
					<label for="celular"><b>Celular:</b></label><br> <input
						type="text" name="celular" size="25" placeholder="(00) 0000-0000">
				</div>
				<br> <input type="submit" value="Cadastrar" class="botao">
				<input type="reset" value="Limpar Campos" class="botao"> <input
					type="button" value="Pesquisar"
					onclick="location.href='http://localhost:8080/Hospital/Pesquisa_Paciente.jsp' "
					class="botao">
			</form>
		</div>
		<!-- /Formulário -->
	</div>
	<!-- /Corpo -->
</body>
</html>