/**
 * 
 * Creo esta clase para con herencia tener el tipo de vehiculo Motocicleta con sus atributos
 * 
 * @author Antonio Mallen
 *
 */
public class Motocicleta extends Vehiculo {

	private int cilindrada;
	private String sidecar;
	
	
	
	public Motocicleta(String marca, String modelo, int anno, int cilindrada, String sidecar) {
		super(marca, modelo, anno);
		this.cilindrada=cilindrada;
		this.sidecar=sidecar;
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return super.toString()+"\n"+"Cilindrada: "+cilindrada+" cc"+"\n"+"Sidecar: "+sidecar+"\n";
	}

}
