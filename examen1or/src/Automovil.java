/**
 * 
 * Creo esta clase para con herencia tener el tipo de vehiculo Automovil con sus atributos
 * 
 * Ademas esta clase servira para que hereden los atributos Electrico y Combustion
 * 
 * @author Antonio Mallen
 *
 */
public class Automovil extends Vehiculo {

	protected int num_plazas;
	protected int potencia;
	
	
	public Automovil(String marca, String modelo, int anno,int num_plazas, int potencia) {
		super(marca, modelo,anno);
		this.num_plazas=num_plazas;
		this.potencia=potencia;
		// TODO Auto-generated constructor stub
	}
	public String toString(){
		return super.toString()+"\n"+"Numero de plazas: "+num_plazas+"\n"+"Potencia: "+potencia+" CV";
	}
	

}
