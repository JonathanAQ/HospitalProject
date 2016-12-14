package com.hospital.fase.prog3.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value = "/HospitalServlet")
public class HospitalServlet extends HttpServlet {
	
	Random pront = new Random();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String H1 = "<h1 algn = left><center><b> HOSPITAL FACULDADE JOAQUIM NABUCO </b></center> </h1>";
		String H3 = "<h3 algn = justify> <center><b> PRONTUÁRIO DO PACIENTE </b></center></h3>";
		String icone = "<link rel=\"shortcut icon\" href=\"http://orig02.deviantart.net/2c7e/f/2010/298/5/e/logo_hospital_01_by_davicinpuntocom-d31hfy2.jpg\">";
		String titulo = "Prontuário Médico";
		String docType = "<!DOCTYPE html PUBLIC " +
				"-//W3C//DTD HTML 4.01" +
				"Transitional//EN" + "http://www.w3.org/TR/html4/loose.dtd" +
				">\n";
		String dir_inf = ".direito-inferior { "
					+ "position:absolute;"
					+ "background-image:url(https://openclipart.org/image/1000px/svg_to_png/59257/logo-hospital.png);"
					+ "width:1000px;"
					+ "height:405px;" 
					+ "float: right;" 
					+ "margin-bottom: 0;"
					+ "position: absolute;"
					+ "right: 0px;"
					+ "bottom: 0;"
				+"}";
		
		//Montando o HTML 
		out.println(docType +
				"<html>\n" +
				"<head>"+
				"<title>" + titulo + "</title>" + icone + H1 + H3 +
				"</head>\n" +
				"<style>" + dir_inf + "</style>" +
				"<body><ul>\n" +
				//Background
				"<div class=\"direito-inferior\"></div>" +
				//Prontuário Médico
				"<label><b>Prontuário</label></b>: " +
				pront.nextInt(100) + "<br /><br />"+
				//Nome Completo
				"<label><b>Nome Completo</label></b>: " +
				request.getParameter("nome") + "<br /><br />"+
				//Data Nascimento
				"<label><b>Data de Nascimento</label></b>: " +
				request.getParameter("data") + "<br /><br />" +
				//RG
				"<label><b>RG</label></b>: " +
				request.getParameter("rge") + "<br /><br />" +
				//CPF
				"<label><b>CPF</label></b>: " +
				request.getParameter("cpf") + "<br /><br />" +
				//Pai
				"<label><b>Nome do Pai</label></b>: " +
				request.getParameter("pai") + "<br /><br />" +
				//Mãe
				"<label><b>Nome da Mãe</label></b>: " +
				request.getParameter("mae") + "<br /><br />" +
				//tipo de consulta
				"<label><b>Tipo de Consulta</label></b>: " +
				request.getParameter("Tipo de Consulta") + "<br /><br />" +
				//cns
				"<label><b>Cartão SUS</label></b>: " +
				request.getParameter("cns") + "<br /><br />" +
				//telefone
				"<label><b>Telefone</label></b>: " +
				request.getParameter("tel") + "<br /><br />" +
				//celular
				"<label><b>Celular</label></b>: " +
				request.getParameter("celular")+ "<br /><br />" +
				"</ul>\n" +
				"</body></html>");
		
		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

