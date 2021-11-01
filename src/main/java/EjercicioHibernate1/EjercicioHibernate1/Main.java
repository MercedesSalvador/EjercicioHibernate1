package EjercicioHibernate1.EjercicioHibernate1;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;



import dao.EmpleadoDAO;
import entity.Empleado;
import entityUtil.HibernateUtil;




public class Main{
	private static Logger logger = LogManager.getLogger(Main.class);
	static boolean salirSeleccion = false;
	//static SessionFactory sessionFactory;

    public static void main( String[] args ){
    	
    	// La SessionFactory se instancia 1 vez por ejecución del programa.
    	// Todas las sesiones de hibernate se obtienen de esa SessionFactory;	
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	Transaction tx = null;
    	//int modifiedProviderId = 1;
    	try {
    		// Las opereaciones save/update/delete
    		tx = session.beginTransaction();
    		String[] OpcionesMenu= new String[5];
        	Scanner entrada = new Scanner(System.in);
        	
        	logger.info("Se muestran las opciones del Menu");
        	//Mostrar opciones del menu
        	Libreria.mostrarOpciones(Libreria.Menu());
        	
        	int opcion = Libreria.pedirOpcion(OpcionesMenu);
        	
    		
    		switch (opcion) {
        	case 1 :
        		logger.info("Caso para insertar el empleado");
        		System.out.println("Introduzca codigo de asignacion");
            	int codigo = entrada.nextInt();
            	System.out.println("Introduzca su nombre");
            	String nombre = entrada.next();
            	System.out.println("Introduzca su primer apellido");
            	String apellido1 = entrada.next();
            	System.out.println("Introduzca su segundo apellido");
            	String apellido2 = entrada.next();
            	
            	Empleado empleado1 = new Empleado(codigo,nombre, apellido1, apellido2);
            	//Insertamos el empleado
            	EmpleadoDAO.insertarEmpleado(session, empleado1);
        		
        		tx.commit();
        		
        		break;
        	case 2 :
        		logger.info("Caso para ver el empleado");
        		System.out.println("Introduzca codigo de empleado que desea ver");
            	int codigo1 = entrada.nextInt();
        		
        		EmpleadoDAO.getEmpleado(session, codigo1);
        		
        		tx.commit();
       	
        		break;
        	case 3 :
        		logger.info("Caso para actualizar el empleado");
        		System.out.println("Introduzca codigo de asignacion");
            	int codigo3 = entrada.nextInt();
            	System.out.println("Introduzca su nombre");
            	String nombre3 = entrada.next();
            	System.out.println("Introduzca su primer apellido");
            	String apell1 = entrada.next();
            	System.out.println("Introduzca su segundo apellido");
            	String apell2 = entrada.next();
            	Empleado empleado3 = new Empleado(codigo3,nombre3, apell1, apell2);
            	
        		EmpleadoDAO.updateEmpleado(session, empleado3);
        		
        		tx.commit();
        		break;
        		
        	case 4 :
        		logger.info("Caso para elimiar el empleado");
        		System.out.println("Introduzca codigo de empleado que desea eliminar");
            	int codigo4 = entrada.nextInt();
            	
        		EmpleadoDAO.deleteEmpleado(session,EmpleadoDAO.getEmpleado(session, codigo4));
        		
        		tx.commit();
        		break;
        	case 0 :
        		salirSeleccion = true;
        		break;
    		}
        	
    	}catch(Exception e) {
    		logger.error ("Error en el bucle", e);
  		  if (tx != null) {
  		    tx.rollback();
  		  }
    	}
		finally {
			if (session != null) {
				session.close();
			}
		}
    	
    	// Abrimos nueva sesión y recuperamos el proveedor 1 para comprobar que se ha actualizado
    	session = HibernateUtil.getSessionFactory().openSession();
    	//Proider modifiedProvider = ProviderDAO.getProvider(session, modifiedProviderId);
    	session.close();
		
    }
}
    	
    	
    	/*
    	Libreria.mostrarOpciones(Libreria.Menu());
    	
    	Libreria.controlarMenu(Libreria.pedirOpcion(OpcionesMenu));
    	
    	/*do {
            //MOSTRAMOS LAS OPCIONES AL USUARIO
            mostrarOpciones(Main.Menu());
            //RECOGEMOS LA OCPION QUE HAYA ESCOGIDO DE LA LISTA
            opcion = libreriaMenu.pedirOpción(menuInicial);
            //PASAMOS LOS DATOS A LA FUNCION QUE VA A CONTROLAR LA OPCION ELEGIDA
            controlarMenuInicial(opcion);
            //CONTROLAMOS QUE EL USUARIO QUIERA O NO QUIERA REALIZAR MAS ACCIONES
            System.out.println("Menú Principal. Desea realizar mas acciones? Si(s) Volver al menu principal(Cualquier tecla");
            respuesta = entrada.nextLine();
            
        } while (respuesta.equalsIgnoreCase("s"));*/

    	
		
    		
    	
   	
   



