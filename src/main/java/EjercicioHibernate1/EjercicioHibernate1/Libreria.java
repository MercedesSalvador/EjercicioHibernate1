package EjercicioHibernate1.EjercicioHibernate1;

import java.util.Scanner;

import dao.EmpleadoDAO;


public class Libreria {
	
	static boolean salirSeleccion = false;
	
	public static String[] Menu() {
		String[] MenuInicial={
			"1.Insertar",
			"2.Mostrar",
			"3.Actualizar",
			"4.Borrar",
			"0.Salir"
			};
		return MenuInicial;
	}
	
	/* public static void mostrarOpciones() {
		 ArrayList <String> listaOpciones = new ArrayList<>();
			listaOpciones.add("1.Insertar");
			listaOpciones.add("2.Mostrar");
			listaOpciones.add("3.Actualizar");
			listaOpciones.add("4.Borrar");
			listaOpciones.add("0.Salir");
		 
	        listaOpciones.forEach((opcionMenu) -> {
	            System.out.println(opcionMenu);
	        });
	    }*/

	public static void mostrarOpciones(String[] OpcionesMenu){
		{
	        for(String opcionMenu: OpcionesMenu)
	        {
	            System.out.println(opcionMenu);
	        }
	    }
		
	}
	public static int pedirOpcion(String[] OpcionesMenu){
		Scanner entrada = new Scanner(System.in);
		
		int opcion;
		do {
    		
    		System.out.println("Introduza la opcion deseada");
    		opcion = entrada.nextInt();
    		System.out.println("Has seleccionado la opcion:" + opcion);
    		return opcion;
		
		}while(!salirSeleccion);
	
	
	}
	/*
	//CONTROLAR MENU 
	public static void controlarMenu(int opcion) {
		//int opcion; //opcion de usuario
		int id = 0;
		    	
    	switch (opcion) {
    	case 1 :
    		
    		
    		
    		break;
    	case 2 :
    		//EmpleadoDAO.getEmpleado(null, id);
    		System.out.println("2.Mostrar");
    		break;
    	case 3 :
    		System.out.println("3.Actualizar");
    		break;
    	case 4 :
    		System.out.println("4.Borrar");
    		break;
    	case 0 :
    		salirSeleccion = true;
    		break;
    	
    	}
		
	}*/


}
