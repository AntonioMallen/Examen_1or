

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


/**
 * 
 * Creo esta clase solamente para que me imprima el menu 
 * en el cual solo se imprimiran las opciones y te dejara escojer una.
 * estas seran llamadas atraves de la clase "Opciones" con sus 
 * distintos metodos
 * 
 * @author Antonio Mallen
 *
 */
public class Menu {

	// Nombre del archivo de trabajo
	String fichero;

	// Entrada de datos
	Scanner in = new Scanner(System.in);

	// Creo un objeto de tipo Opciones para llamar a los distintos metodos
	Opciones o = null;

	public Menu ( String archivo ) throws IOException {
		fichero = archivo;
		boolean fin;
		o = new Opciones(fichero);
		/**
		 * Se leera el archivo nada mas ejecutar el programa para que se carguen los 
		 * datos guardados con posterioridad
		 * 
		 * En este caso por comodidad he puesto que si se lanza la excepcion 
		 * NullPointerException (no existe el archivo donde se intentan leer los datos)
		 * que se genere automaticamente el archivo.
		 */
		try {
			o.leer();
		}catch (NullPointerException ex){
			o.guardar();	
		}

		do {
			fin = trabajo(); 	
		} while ( ! fin );
	}

	private void imprimir ( ) {
		System.out.println("Elija una opción");
		System.out.println("1.- Añadir un vehiculo\n"
				+ "2.- Eliminar un vehiculo\n"
				+ "3.- Listado de los vehiculos\n"
				+ "4.- Datos de un vehiculo\n"
				+ "5.- Vehiculo por marca\n"
				+ "6.- Coches por tipo de combustible\n"
				+ "7.- Vehiculos por año de venta\n"
				+ "8.- Guardar los datos");
		System.out.println("0.- Salir");

	}
	private boolean trabajo ( ) throws IOException {
		int opcion=0;

		do {
			if ( opcion < 0 || opcion > 8 ) {
				System.out.println("Debe introducir un número entre 0 y 8");
			}
			imprimir();
			try {
				opcion = in.nextInt();
			}catch(InputMismatchException e) {
				System.out.println("Solo se admiten numeros dentro de opcion");
			}
		} while ( opcion < 0 || opcion > 8 );
		if ( opcion == 0 ) {
			System.out.println("Programa finalizado");
			return true;
		}
		switch ( opcion ) {
		case 1:
			anadir();
			break;
		case 2:
			borrar();
			break;
		case 3:
			ordenar();
			break;
		case 4:
			datosVehiculo();
			break;

		case 5:
			vehiculoMarca();
			break;
		case 6:
			cochesCombustible();
			break;

		case 7:
			vehiculosAnno();
			break;
		case 8:
			guardar();
			break;
		}

		return false;
	}

	/**
	 * En anadir voy pidiendo datos dependiendo del tipo de vehiculo que sea.
	 */
	public void anadir ( ) {
		System.out.println("Dime la marca del vehiculo");
		in.nextLine();
		String marca = in.nextLine();
		System.out.println("Dime el modelo del vehiculo");
		String modelo = in.nextLine();
		System.out.println("Dime el año de aparicion en el mercado");
		int anno = in.nextInt();
		if(anno>1885 && anno<=2022) { // validamos que el año se mayor de 1885 y que sea menor o igual que 2022(año actual)
			System.out.println("Dime el tipo de vehiculo (coche o moto)");
			in.nextLine();
			String tipo = in.nextLine();
			if((tipo.toLowerCase()).equals("coche")){
				System.out.println("Dime el numero de plazas");
				int num_plazas = in.nextInt();
				System.out.println("Dime la potencia");
				int potencia = in.nextInt();

				System.out.println("Dime si el coche es de Combustion o electrico");
				in.nextLine();
				String tipoCombustion = in.nextLine();
				if((tipoCombustion.toLowerCase()).equals("combustion")){

					System.out.println("Dime el tipo de combustible");
					String tipo_combustible = in.nextLine();
					System.out.println("Dime la cilindrada");
					int cilindrada = in.nextInt();

					o.anadirCombustion(marca,modelo,anno,num_plazas,potencia,tipo_combustible,cilindrada);
				}else if((tipoCombustion.toLowerCase()).equals("electrico")){

					System.out.println("Dime la autonomia del vehiculo");
					int autonomia = in.nextInt();
					System.out.println("Dime el tiempo de carga (en minutos)");
					int tiempo_carga = in.nextInt();

					o.anadirElectrico(marca,modelo,anno,num_plazas,potencia,autonomia,tiempo_carga);
				}else{
					System.out.println("Tipo de combustion no valido");
				}

			}else if((tipo.toLowerCase()).equals("moto")) {

				System.out.println("Dime la cilindrada");
				int cilindrada = in.nextInt();
				System.out.println("Dime si tiene sidecar");
				in.nextLine();
				String sidecar = in.nextLine();
				if(sidecar.toLowerCase().equals("si")||sidecar.toLowerCase().equals("no")) {
					o.anadirMoto(marca,modelo,anno,cilindrada,sidecar);
				}else {
					System.out.println("Respuesta no valida");
				}

			}else {
				System.out.println("El tipo de vehiculo seleccionado no es correcto");
			}

		}else {
			System.out.println("El año introducido no es valido");
		}
	}





	public void borrar() throws IOException {
		System.out.println("Dime la marca del vehiculo");
		in.nextLine();
		String marca = in.nextLine();
		System.out.println("Dime el modelo del vehiculo");
		String modelo = in.nextLine();
		o.borrar(marca, modelo);
	}


	public void ordenar() throws IOException {
		o.ordenar();
	}


	public void datosVehiculo() {
		System.out.println("Dime la marca del vehiculo");
		in.nextLine();
		String marca = in.nextLine();
		System.out.println("Dime el modelo del vehiculo");
		String modelo = in.nextLine();
		o.datosVehiculo(marca, modelo);
	}


	public void vehiculoMarca() throws IOException {
		System.out.println("Dime la marca del vehiculo");
		in.nextLine();
		String marca = in.nextLine();
		o.vehiculoMarca(marca);
	}


	public void cochesCombustible() throws IOException {
		o.cochesCombustible();
	}


	public void vehiculosAnno() throws IOException {

		System.out.println("Dime el año de venta");
		int num = in.nextInt();
		o.vehiculosAnno(num);
	}


	public void guardar() {
		o.guardar();
		System.out.println("Se han guardado los datos con exito");
	}

}


