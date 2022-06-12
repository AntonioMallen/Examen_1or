
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * 
 * Clase para almacenar en un fichero todos los vehiculos, en esta se le pasara
 * un arraylist para guardar, y guardara objeto por objeto, y para leer, se leera
 * cada objeto y se ira almacenando en un arraylist el cual se devolvera
 * 
 * @author Antonio Mallen
 *
 */
public class Archivo {

	/**
	 * Se crea static para no tener que crear un objeto de tipo Archivo
	 * 
	 * @param fichero: lugar donde se quiere almacenar la informacion
	 * @return Arraylist con todos los objetos que hay dentro de nuestra base
	 */
	
	public static ArrayList<Vehiculo> leer(String fichero) {
		
		ArrayList<Vehiculo> vector =new ArrayList<Vehiculo>();
		
		ObjectInputStream lecturaObjetos = null;
		try { 
			lecturaObjetos = new ObjectInputStream(new FileInputStream(fichero));
			while(true){
				Vehiculo o = (Vehiculo)lecturaObjetos.readObject();
				vector.add(o);
			}

		} catch (FileNotFoundException ex) {
			return null;
		} catch (EOFException ex) {
			System.out.println("Contactos añadidos del fichero");
			if(lecturaObjetos!=null) {
				try {
					lecturaObjetos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return vector;
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} 
		if(lecturaObjetos!=null) {
			try {
				lecturaObjetos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return vector;
		
	}
	
	
	/**
	 * 
	 * este metodo es static para no tener que crear un objeto de
	 * tipo Archivo
	 * 
	 * @param fichero: lugar donde se quiere almacenar la informacion
	 * @param asd: arraylist con la informacion que queremos almacenar(en este caso objetos)
	 */
	public static void escribir(String fichero, ArrayList<Vehiculo> asd) {
		ObjectOutputStream escribirObjeto = null;
		try { 
			escribirObjeto = new ObjectOutputStream(new FileOutputStream(fichero));
			for (Object contactos : asd) {
				escribirObjeto.writeObject(contactos);
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} 
		if(escribirObjeto!=null) {
			try {
				escribirObjeto.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

	
	
}
