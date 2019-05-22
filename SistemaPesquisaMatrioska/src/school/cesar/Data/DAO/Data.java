package school.cesar.Data.DAO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Data {
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////// TEM QUE MODIFICAR PRA MUDAR O PATH DO LOCAL ONDE VAI LER O CSV /////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	public static List<String> readFile() {
		
		// Caminho onde se encontra o arquivo
		String path = "/home/otacilio_siqueira/Workspace/"
				+ "Code_Projects/CESAR_School/Matrioska/"
				+ "SistemaPesquisaMatrioska/src/school/"
				+ "cesar/Data/DAO/Avaliacao_Humor_Gera_Alunos_3.csv";
		
		List<String> listLineRead = new ArrayList<String>();
		
		
		// Instanciando as streams diretamente no bloco try
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			// lendo as linhas
			while(line != null) {
//				System.out.println(line);
				listLineRead.add(line);			// Adicionando cada valor(linha) ao meu arraylist
				line = br.readLine();	// Ler novamente outra linha com o BufferedReader
			}
			
		} catch (IOException e) {	// Pegando exceção de IO, nesse caso pq é de leitura de arquivo
			System.out.println("Error: " + e.getMessage());
			
		}
		listLineRead.remove(0);	// removendo do arraylist a linha cabecalho
		return listLineRead;
	}
	
	
}
