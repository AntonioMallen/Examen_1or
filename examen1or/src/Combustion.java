/**
 * 
 * Creo esta clase para con herencia tener el tipo de vehiculo Combustion con sus atributos
 * 
 * @author Antonio Mallen
 *
 */
public class Combustion extends Automovil {

	private String tipo_combustion;
	private int cilindrada;
	
	public String getTipo_combustion() {
		return tipo_combustion;
	}

	public Combustion(String marca, String modelo,int anno,int num_plazas, int potencia, String tipo_combustion, int cilindrada) {
		super(marca, modelo,anno, num_plazas, potencia);
		this.tipo_combustion=tipo_combustion;
		this.cilindrada=cilindrada;
	}
	
	public String toString(){
		return super.toString()+"\n"+"Tipo de combustion: "+tipo_combustion+"\n"+"Cilindrada: "+cilindrada+" cc"+"\n";
	}
}
