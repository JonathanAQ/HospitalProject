package com.hospital.fase.prog3.Action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

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
 * Servlet implementation class inserirPacienteServlet
 */
@WebServlet("/inserirPacienteServlet")
public class inserirPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inserirPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		PrintWriter out = response.getWriter();
		ConnectionFactory cf = new ConnectionFactory();
		Connection conn = cf.getConnection();
		JDBCPacienteDAO dao =new JDBCPacienteDAO(conn); 
		Paciente paciente = new Paciente ();


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
		
		dao.inserirPaciente(paciente);
		List<Paciente> pacientes = dao.listarPaciente();
		request.setAttribute("pacientes", pacientes);


		cf.close();
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Listar_Pacientes.jsp");
		requestDispatcher.forward(request, response);

		//RequestDispatcher requestDispatcher = request.getAttribute();
	}

}
