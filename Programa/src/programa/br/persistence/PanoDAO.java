package programa.br.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import programa.br.beans.Cliente;
import programa.br.beans.Emprestimo;
import programa.br.beans.Pano;

public class PanoDAO {
	private static final String NOME_ARQUIVO = "panos.txt";
	static ArrayList<Pano> panos = new ArrayList();

	public void inserirPano(Pano p){
		panos.add(p);
		escreverArquivo();
	}

	public void excluirPano(int cod){
		Pano p = procurarPorCodigo(cod);
		panos.remove(p);
		escreverArquivo();
	}

	public Pano procurarPorCodigo(int cod){
		for (Pano pano : panos) {

			if(pano.getCodigoPano() == cod)
				return pano;
		}

		return null;
	}
	
	public ArrayList<Pano> listarEmprestados(){
		ArrayList<Pano> temp = new ArrayList();
		for (Pano pano : temp) {
			if(pano.isEmprestado())
				temp.add(pano); 
		}
		return temp;
	}
	
	public void alterarPano(Pano p){
		Pano panotemp = procurarPorCodigo(p.getCodigoPano());

		panotemp.setCliente(p.getCliente());
		panotemp.setCodigoPano(p.getCodigoPano());
		panotemp.setDataMontagem(p.getDataMontagem());
		panotemp.setEmprestado(p.isEmprestado());

		escreverArquivo();
	}
	
	public void escreverArquivo(){
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			for (Pano pano : panos) {
				Cliente c = pano.getCliente();
				String cpfCliente = c.getCpf();
				bw.write(pano.getCodigoPano()+";"+pano.getDataMontagem()+";"+pano.isEmprestado()+";"+cpfCliente);
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

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] dados = linha.split(";");
				Cliente c =  ClienteDAO.buscarPorCpf(dados[3]);
				Pano p = new Pano(Integer.parseInt(dados[0]),dados[1],Boolean.parseBoolean(dados[2]),c);
				panos.add(p);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		finally{
			try {
				fr.close();
				br.close();

			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}

