package dao;

import org.hibernate.Session;

import entity.Departamento;


public class DepartamentoDAO {
	
	public static void insertarDepartamento(Session s, Departamento departamento) {
		
		s.save(departamento);
	}
	//leer
	public static Departamento getDepartamento(Session s, int id) {
		return s.get(Departamento.class, id);
	}
	
	public static void updateDepartamento(Session s, Departamento departamento) {
		s.update(departamento);
	}
	
	public static void deleteDepartamento(Session s, Departamento departamento) {
		s.delete(departamento);
	}

}
