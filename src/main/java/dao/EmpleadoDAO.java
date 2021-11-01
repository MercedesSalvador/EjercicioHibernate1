package dao;

import org.hibernate.Session;

import entity.Empleado;

public class EmpleadoDAO {
	
	//insertar
	public static void insertarEmpleado(Session s, Empleado empleado) {
		
		s.save(empleado);
	}
	//leer
	public static Empleado getEmpleado(Session s, int id) {
		return s.get(Empleado.class, id);
	}
	
	public static void updateEmpleado(Session s, Empleado empleado) {
		s.update(empleado);
	}
	
	
	public static void deleteEmpleado(Session s, Empleado empleado) {
		s.delete(empleado);
	}
	/*
	public static void deleteEmpleado(Session s, int id) {
		s.delete(Empleado.class);
	}*/

}
