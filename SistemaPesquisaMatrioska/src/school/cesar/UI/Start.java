package school.cesar.UI;

import school.cesar.Data.DAO.*;

public class Start {

	public static void main(String[] args) {
		
		// APENAS PARA TESTE, POREM SERÁ FEITA TODA A INTERFACE AINDA
		
		for (String string : Data.readFile()) {
			System.out.println(string);
		}
		

	}

}
