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

public class EmprestimoDAO {
	private static final String NOME_ARQUIVO = "emprestimo.txt";
	static ArrayList<Emprestimo> emprestimos = new ArrayList();

	public void emprestar(int cod,String cpf){
		
		ClienteDAO cdao = new ClienteDAO();
		PanoDAO pdao = new PanoDAO();
		
		Cliente c = cdao.buscarPorCpf(cpf); 	
		Pano p = pdao.procurarPorCodigo(cod);	

		p.setCliente(c);
		p.setEmprestado(true);
		
		escreverArquivo();
	}

	public void receber(int cod){
		PanoDAO pdao = new PanoDAO();
		ClienteDAO cdao = new ClienteDAO();

		Pano p = pdao.procurarPorCodigo(cod);
		Cliente c = p.getCliente();

		p.setCliente(null);
		p.setEmprestado(false);
		
		escreverArquivo();            
	}

	public void escreverArquivo(){
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			for (Emprestimo emprestimo : emprestimos) {
				bw.write(emprestimo.getCpfCliente()+";"+emprestimo.getCodigoPano()+";"+emprestimo.getDataRecebimento()+";"+emprestimo.getDataEntrega());
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

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] dados = linha.split(";");
				Emprestimo e = new Emprestimo(dados[0],Integer.parseInt(dados[1]),dados[2],dados[3]);
				emprestimos.add(e);
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

