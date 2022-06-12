/**
 * 
 * Creo esta clase para con herencia tener el tipo de vehiculo Electrico con sus atributos
 * 
 * @author Antonio Mallen
 *
 */
public class Electrico extends Automovil {

	private int autonomia;
	private int tiempo_carga;
	
	public Electrico(String marca, String modelo, int anno,int num_plazas, int potencia,int autonomia, int tiempo_carga) {
		super(marca, modelo,anno,num_plazas , potencia);
		this.autonomia=autonomia;
		this.tiempo_carga=tiempo_carga;
	}
	public String toString(){
		return super.toString()+"\n"+"autonomia: "+autonomia+" Km"+"\n"+"Tiempo de carga: "+tiempo_carga+" minutos"+"\n";
	}

}
