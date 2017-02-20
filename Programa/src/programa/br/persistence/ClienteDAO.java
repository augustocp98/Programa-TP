package programa.br.persistence;

import programa.br.beans.Cliente;
import programa.br.beans.Pano;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;



public class ClienteDAO {

	private static final String NOME_ARQUIVO = "clientes.txt";
	private static ArrayList<Cliente> clientesAux = new ArrayList<Cliente>();

	/*
	 * Insere um cliente no ArrayList de clientes
	 */
	public void inserir(Cliente c) {
		clientesAux.add(c);

		escreverArquivo();
	}

	/*
     * exclui um cliente com um numero de cpf igual ao passado por parâmetro
     */
	
	public void excluir(String cpf) {

		Cliente clienteTemp = buscarPorCpf(cpf);
		clientesAux.remove(clienteTemp);

		escreverArquivo();
	}
    /*
     * altera as informações de um cliente especificado
     */
	
	public void alterar(Cliente c) {
		Cliente clienteTemp = buscarPorCpf(c.getCpf());

		clienteTemp.setNome(c.getNome());
		clienteTemp.setCpf(c.getCpf());
		clienteTemp.setMunicipio(c.getMunicipio());
		clienteTemp.setEstado(c.getEstado());
		clienteTemp.setRua(c.getRua());
		clienteTemp.setBairro(c.getBairro());
		clienteTemp.setTotalVenda(c.getTotalVenda());	

		escreverArquivo();
	}
    /*
     * procura dentro do ArrayList de clientes e retorna um cliente com os caracteres iguais aos passados por parâmetro
     */
	
	public static Cliente buscarPorCpf(String cpf) {
		for (Cliente clienteTemp : clientesAux) {
			if (clienteTemp.getCpf().equals(cpf)) {
				return clienteTemp;
			}
		}

		return null;
	}

	/*
	 * procura dentro do ArrayList de clientes e retorna um ArrayList 
	 * com todos os clientes que possuem caracteres iguais aos passados por parametro
	 * como String
	 */
	public ArrayList<Cliente> buscarPorNome(String nome) {
		ArrayList<Cliente> busca = new ArrayList<Cliente>();

		for (Cliente clienteTemp : clientesAux) {
			if (clienteTemp.getNome().toUpperCase().contains(nome.toUpperCase())) {
				busca.add(clienteTemp);
			}
		}

		return busca;
	}

	public ArrayList<Cliente> listar() {
		return clientesAux;
	}

	
	/*
	 *  salva as informaçoes no arquivo txt
	 */
	private void escreverArquivo() {
		File f = new File(NOME_ARQUIVO);
		FileWriter fw = null;
		BufferedWriter bw = null;

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);

			for (Cliente clienteTemp : clientesAux) {
				bw.write(clienteTemp.getNome()+";"+clienteTemp.getCpf()+";"+clienteTemp.getMunicipio()+";"+clienteTemp.getEstado()+";"+clienteTemp.getRua()+";"+clienteTemp.getBairro()+";"+clienteTemp.getTotalVenda());
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * recupera todas as informações salvas em txt ao instanciar a classe
	 */
	static {
		File f = new File(NOME_ARQUIVO);
		FileReader fr = null;
		BufferedReader br = null;

		try {
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String linha;
			while( (linha = br.readLine()) != null ) {
				String[] dados = linha.split(";");
				Cliente c = new Cliente(dados[0], dados[1],dados[2], dados[3],dados[4],dados[5],Double.parseDouble(dados[7]));
				clientesAux.add(c);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
