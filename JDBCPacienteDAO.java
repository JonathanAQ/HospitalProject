package com.hospital.fase.prog3.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hospital.fase.prog3.Model.Paciente;
import com.mysql.jdbc.PreparedStatement;

public class JDBCPacienteDAO implements pacienteDAO {

	private Connection conn;
	//private boolean erro = false;
	
	public JDBCPacienteDAO(Connection conn) {
		this.conn = conn;
	}

	/*public boolean isErro() {
		return erro;
	}

	public void setErro(boolean erro) {
		this.erro = erro;
	}*/

	@Override
	public void inserirPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO paciente" + "(nome_PCT,nome_PAI,nome_MAE,dado_pct_DNASC,doc_RG,doc_CPF,doc_CNS,atend_TIPO,tel_FIXO,tel_CEL)" + "VALUES(?,?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt;

		try {
			stmt = (PreparedStatement) conn.prepareStatement(sql);

			stmt.setString(1, paciente.getNomePaciente());
			stmt.setString(2, paciente.getNomePai());
			stmt.setString(3, paciente.getNomeMae());
			stmt.setString(4, paciente.getDtNascimento());
			stmt.setString(5, paciente.getRg());
			stmt.setString(6, paciente.getCpf());
			stmt.setString(7, paciente.getCns());
			stmt.setString(8, paciente.getTipoAtendimento());
			stmt.setString(9, paciente.getTelefoneFixo());
			stmt.setString(10, paciente.getTelefoneCel());
			
			stmt.execute();
			
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			//erro = true;
		}

	}

	@Override
	public List<Paciente> listarPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();

		String sql = "SELECT * FROM paciente";

		try {
			java.sql.Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql); 
			while(rs.next()){
				Paciente paciente = new Paciente();
				paciente.setNomePaciente(rs.getString("nome_PCT"));
				paciente.setNomeMae(rs.getString("nome_MAE"));
				paciente.setNomePai(rs.getString("nome_PAI"));
				paciente.setRg(rs.getString("doc_RG"));


				pacientes.add(paciente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return pacientes;
	}


	@Override
	public void alterar(Paciente paciente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Paciente buscar(Paciente paciente) {
		String sql = "SELECT * FROM hospital.paciente where pront_iD =" + " \"" + paciente.getProntuario() + "\"";
		System.out.println(sql);
		try{
			PreparedStatement stmt =  (PreparedStatement) conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql); 
			if(rs.next() ){
				paciente.setProntuario(rs.getInt("pront_iD"));
				paciente.setNomePaciente(rs.getString("nome_PCT"));
				paciente.setNomePai(rs.getString("nome_PAI"));
				paciente.setNomeMae(rs.getString("nome_MAE"));
				paciente.setDtNascimento(rs.getString("dado_pct_DNASC"));
				paciente.setRg(rs.getString("doc_RG"));
				paciente.setCpf(rs.getString("doc_CPF"));
				paciente.setCns(rs.getString("doc_CNS"));
				paciente.setTipoAtendimento(rs.getString("atend_TIPO"));
				paciente.setTelefoneFixo(rs.getString("tel_FIXO"));
				paciente.setTelefoneCel(rs.getString("tel_CEL"));
			System.out.println(paciente.getNomePaciente());
			}
		
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return paciente;

	}
	
}
	
