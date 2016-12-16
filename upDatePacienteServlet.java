package com.hospital.fase.prog3.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hospital.fase.prog3.Dao.ConnectionFactory;
import com.hospital.fase.prog3.Dao.JDBCPacienteDAO;
import com.hospital.fase.prog3.Model.Paciente;

/**
 * Servlet implementation class upDatePacienteServlet
 */
@WebServlet("/upDatePacienteServlet")
public class upDatePacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public upDatePacienteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		JDBCPacienteDAO dao =new JDBCPacienteDAO(conn); 
		Paciente paciente = new Paciente ();
		
		paciente.setNomePaciente(request.getParameter("nome"));
		paciente = dao.buscar(paciente);
		request.setAttribute("paciente", paciente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pesquisa_Paciente.jsp");
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("paciente", ""); //
		String nomeBotaoChamado = request.getParameter("botao");
		if (nomeBotaoChamado.equals("Buscar")) {
			buscar(request, response);
		} else {
			alterar(request, response);
		}

	}

	private void alterar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("alterando");
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		JDBCPacienteDAO dao =new JDBCPacienteDAO(conn); 
		Paciente paciente = new Paciente ();
		int pront = Integer.parseInt(request.getParameter("pront"));

		paciente.setProntuario(pront);
		paciente.setNomePaciente(request.getParameter("nome"));
		paciente.setNomePai(request.getParameter("pai"));
		paciente.setNomeMae(request.getParameter("mae"));
		paciente.setDtNascimento(request.getParameter("data"));
		paciente.setRg(request.getParameter("rge"));
		paciente.setCpf(request.getParameter("cpf"));
		paciente.setCns(request.getParameter("cns"));
		paciente.setTipoAtendimento(request.getParameter("Tipo de Consulta"));
		paciente.setTelefoneFixo(request.getParameter("tel"));
		paciente.setTelefoneCel(request.getParameter("celular"));

		dao.alterar(paciente);
		List<Paciente> pacientes = dao.listarPaciente();
		request.setAttribute("pacientes", pacientes);


		cf.close();

		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Listar_Pacientes.jsp");
		requestDispatcher.forward(request, response);
		
	}

	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		JDBCPacienteDAO dao =new JDBCPacienteDAO(conn); 
		Paciente paciente = new Paciente ();
		int pront = Integer.parseInt(request.getParameter("pront"));

		paciente.setProntuario(pront);
		paciente = dao.buscar(paciente);
		request.setAttribute("paciente", paciente);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Pesquisa_Paciente.jsp");
		requestDispatcher.forward(request, response);

	}

}
