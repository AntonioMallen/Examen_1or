import java.io.Serializable;
import java.util.Random;

/**
 * 
 * En esta clase se expecificaran los datos que tienen en comun
 * todos los vehiculos de nuestra base de datos
 * 
 * @author Antonio Mallen
 *
 */
public class Vehiculo implements Serializable{

	/**
	 * Creamos todos los atributos con protected para asi a traves
	 * de la herencia que los automoviles y las motocicletas puedan
	 * heredarlos
	 */
	protected String marca;
	protected String modelo;
	protected int anno;
	protected int tiempo_vida;
	
	
	public Vehiculo(String marca, String modelo,int anno) {
		this.marca=marca;
		this.modelo=modelo;
		this.anno=anno;
		generarTiempo();
		
		
	}
	
	

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public int getAnno() {
		return anno;
	}
	public int getTiempo_vida() {
		return tiempo_vida;
	}
	
	
	public void generarTiempo() {
		/**
		 * Se genera un numero aleatorio entre el 5 y el 20
		 */
		tiempo_vida=(int)((Math.random()*20-5+1)+5); 
	}
	
	public String toString(){
		String salida = "Marca: "+marca+"\n"+"Año de aparicion en el mercado: "+anno+"\n"+"Modelo: "+modelo+"\n"+"Tiempo de vida: "+tiempo_vida ;
		return salida;
	}
	
}
