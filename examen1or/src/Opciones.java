import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Creo esta clase para tener almacenados las distintas opciones
 * que existen en el programa
 * 
 * @author Antonio Mallen
 *
 */
public class Opciones {

	/**
	 * Creo un arraylist en el cual se van a almacenar
	 * los Vehiculos para una manipulacion de datos mas comoda
	 */
	ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

	Scanner in = new Scanner(System.in); // solo es necesario para la opcion 6
	
	private String fichero;



	public Opciones(String archivo) {
		this.fichero=archivo;
	}


	/**
	 * Creo 3 metodos, segun se vaya validando en la clase menu, se llamara a uno u otro dependiendo
	 * del tipo de vehiculo que se vaya seleccionando.
	 * 
	 */
	
	public void anadirMoto (String marca, String modelo, int anno,int cilindrada, String sidecar) {
		if (!comprobarVehi(marca,modelo)) {
			Vehiculo nuevo = new Motocicleta(marca,modelo,anno,cilindrada,sidecar);
			vehiculos.add(nuevo);
		}else {
			System.out.println("Este vehiculo ya existe dentro de la base de datos");
		}
	}


	public void anadirCombustion (String marca, String modelo, int anno, int num_plazas, int potencia, String tipo_combustion, int cilindrada ) {
		if (!comprobarVehi(marca,modelo)) {
			Vehiculo nuevo = new Combustion(marca,modelo,anno,num_plazas,potencia,tipo_combustion,cilindrada);
			vehiculos.add(nuevo);
		}else {
			System.out.println("Este vehiculo ya existe dentro de la base de datos");
		}
	}


	public void anadirElectrico (String marca, String modelo, int anno, int num_plazas, int potencia,int autonomia, int tiempo_carga ) {
		if (!comprobarVehi(marca,modelo)) {
			Vehiculo nuevo = new Electrico(marca,modelo,anno,num_plazas,potencia,autonomia,tiempo_carga);
			vehiculos.add(nuevo);
		}else {
			System.out.println("Este vehiculo ya existe dentro de la base de datos");
		}
	}

	/**
	 * Recorro el array con un iterator para poder borrarlo y en caso de que los datos del next coincidan
	 * con los datos introducidos por teclado, me elimina ese Vehiculo
	 * 
	 * @param marca: valor de la marca introducido por teclado
	 * @param modelo: valor del modelo introducido por teclado
	 */
	public void borrar( String marca, String modelo ) {
		if(comprobarVehi(marca,modelo)) {
			Boolean borrado = false;
			Iterator<Vehiculo> itr = vehiculos.iterator(); // creo el iterator para recorrer el vector
			while(itr.hasNext() && borrado ==false) {
				Vehiculo x = itr.next();
				if(x.getModelo().equals(modelo) && x.getMarca().equals(marca)) {
					vehiculos.remove(x);
					borrado = true;
				}
			}
		}else {
			System.out.println("El vehiculo no existe");
		}
	}

	/**
	 * El metodo de ordenar tambien se podria hacer con un compareTo dentro de vehiculos y ordenar directamente
	 * todo el vector de vehiculos con vehiculos.sort
	 * 
	 * En mi caso he preferido hacerlo con un TreeSet para que no me alterara el orden
	 * de mi array principal (vehiculos)
	 */
	public void ordenar () {
		Set<String> ordenado = new TreeSet<String>();
		/**
		 * Lo añado en un tree set el cual los ordena automaticamente, como las strings en las que pone
		 * "Marca: " son iguales en todos, no lo tomara para ordenarlo, sino que
		 * solo comparara los valores de cada vehiculo
		 * */
		for(Vehiculo x : vehiculos) 
			ordenado.add("Marca: "+x.getMarca()+"\n"+"Año de aparicion en el mercado: "+x.getAnno()+"\n"+"Modelo: " +x.getModelo()+"\n"+"Tiempo de vida: "+x.getTiempo_vida() );

		System.out.println("Lista de vehiculos");
		for(String y : ordenado) {
			System.out.println(y+"\n");
		}

	}

	
	/**
	 * Primero llama a comprobarVehi, en caso de que el vehiculo este en la base de datos
	 * te recorre todo el array de vehiculos y cuando encuente el vehiculo con los datos pedidos
	 * te lo muestra por pantalla
	 * 
	 * @param marca: marca del vehiculo
	 * @param modelo: modelo del vehiculo
	 */
	public void datosVehiculo(String marca, String modelo) {
		if( comprobarVehi(marca, modelo)) {
			for(Vehiculo x : vehiculos) {
				if(x.getModelo().equals(modelo) && x.getMarca().equals(marca)) {
					System.out.println(x);
				}
			}
		}else {
			System.out.println("El vehiculo todavia no ha sido añadido a la base de datos");
		}
	}

	
	/**
	 * Recorre todo el vector de vehiculos y en caso de que algun vehiculo coincida con la marca deseada
	 * lo imprime
	 * 
	 * @param marca: marca de los vehiculos a buscar
	 */
	public void vehiculoMarca(String marca) {
		boolean existe = false;
		for(Vehiculo x : vehiculos) {
			if(x.getMarca().equals(marca)) {
				
				System.out.println(x);
				/**
				 * Creo un boolean para saber si por lo menos existe 1 vehiculo de esa marca,
				 * en caso de no su valor no cambia.
				 */
				existe=true;
			}
		}
		if(existe==false) {
			System.out.println("No existe ningun vehiculo de esa marca");
		}
	}


/**
 * Este metodo comprueba que distintos tipos de combustibles tienen los coches, si encuentra uno que no este repetido lo metera
 * dentro del array de combustibles. Posteriormente, te pregunta que tipo de combustible quieres
 * y segun elijas uno u otro te muestra todos los vehiculos con ese tipo de combustible.
 */
	public void cochesCombustible() {
		ArrayList<Combustion> vehiculosCombustion = new ArrayList<Combustion>();
		ArrayList<String> combustibles = new ArrayList<String>();
		boolean anadido = true;
		/**
		 * Este bucle recorre vehiculos y si alguno es de tipo Combustion lo añade en otro arraylist
		 */
		for(Vehiculo x : vehiculos) {
			if(x instanceof Combustion) {
				vehiculosCombustion.add((Combustion) x);
			}
		}
		
		/**
		 * Este bucle es el que va comprobando cada tipo de combustible, en caso de encontrar
		 * uno que no habia leido antes lo añade dentro del arrayList de combustibles
		 */
		for(Combustion y : vehiculosCombustion) {
			for(String z: combustibles) {
				if(y.getTipo_combustion().equals(z)) {
					anadido=false;
				}
			}
			if(anadido) {
				combustibles.add(y.getTipo_combustion());
			}
			anadido=true;
		}
		System.out.println("De que tipo de combustion quieres que se muestre la lista");
		/**
		 * aqui se imprimen los distintos tipos de combustibles
		 */
		for(int i = 0;i<combustibles.size();i++) {
			System.out.println(i+" "+combustibles.get(i));
		}
		/*
		 * segun se elija una opcion u otra se imprimiran todos los vehiculos con ese tipo de combustible
		 */
		int opcion=in.nextInt();
		for(Combustion y : vehiculosCombustion) {
			if( y.getTipo_combustion().equals(combustibles.get(opcion))) {
				System.out.println(y);
			}
		}
		
	}
	
	
/**
 * 
 * En este metodo se recorren todos los vehiculos y en caso de que el año introducido
 * por teclado este entre el año de su aparcion en el mercado y su año de tiempo de vida(cuando 
 * deja de comercializarse), se printea el vehiculo
 * 
 * @param anno: año introducido por teclado
 * @throws IOException
 */
	public void vehiculosAnno(int anno){
		int Contador=0;
		for(Vehiculo x : vehiculos) {
			if(x.getAnno()<=anno && (x.getTiempo_vida()+x.getAnno())>anno) {
				System.out.println(x);
				Contador++;
			}
		}
		if(Contador==0) {
			System.out.println("No hay ningun vehiculo comercializado en ese año"+"\n");
		}else {
			System.out.println("Hay un total de "+ Contador + " Vehiculos"+"\n");
		}
	}

/**
 * Este metodo comprueba si la marca y el modelo introducidos no estan ya en la base de datos
 * 
 * @param marca: marca del coche
 * @param modelo: modelo del coche
 * @return
 */
	public boolean comprobarVehi(String marca, String modelo) {
		if( vehiculos != null) {
			for(Vehiculo x : vehiculos) {
				if(x.getMarca().equals(marca) && x.getModelo().equals(modelo)) {
					return true;
				}
			}
		}
		return false;
	}

	public void guardar() {
		Archivo.escribir(fichero, vehiculos);
	}


	public void leer() {
		vehiculos.addAll(Archivo.leer(fichero));
	}
}
