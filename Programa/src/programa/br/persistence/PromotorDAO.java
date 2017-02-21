package programa.br.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import programa.br.beans.Promotor;


public class PromotorDAO {
	private static final String NOME_ARQUIVO = "Promotores.txt";
	private static ArrayList<Promotor> promotores = new ArrayList();

	public void inserir(Promotor p){
		promotores.add(p);
	   
		escreverArquivo();
	}

	public void escreverArquivo(){
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);	
			bw = new BufferedWriter(fw);
			for (Promotor promotor : promotores) {
				bw.write(promotor.getNome()+";"+promotor.getCarro()+";"+promotor.getPanos());	
				bw.newLine(); 
			}


		} catch (IOException e) {
		
			e.printStackTrace();
		}finally{
			try {
				fw.close();
				bw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}


	}

 static{
	 File f = new File(NOME_ARQUIVO);
	 FileReader fr = null;
	 BufferedReader br = null;
	 try{
	  fr = new FileReader(f);
	  br = new BufferedReader(fr);
	  
	  String linha;
	  while((linha = br.readLine()) != null){
		String[] dados = linha.split(";");   
		Promotor p = new Promotor();
		promotores.add(p);
		
	  }
	  
	 }catch(IOException e){
		 e.printStackTrace();
	 }finally{
		 try {
			fr.close();
			 br.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	 }
	  
	 
 }

}
