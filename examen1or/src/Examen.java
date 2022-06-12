import java.io.IOException;

public class Examen {

	public static void main(String[] args) {
		try {
			Menu m = new Menu("datos.dat");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
 