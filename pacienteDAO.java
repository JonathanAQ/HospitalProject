package com.hospital.fase.prog3.Dao;

import java.util.List;

import com.hospital.fase.prog3.Model.Paciente;

public interface pacienteDAO {

	void inserirPaciente(Paciente paciente);
	List <Paciente> listarPaciente ();
	void alterar (Paciente paciente);
	Paciente buscar (Paciente paciente);
	
	
}
