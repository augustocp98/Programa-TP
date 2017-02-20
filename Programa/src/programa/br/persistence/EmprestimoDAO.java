package programa.br.persistence;
import programa.br.beans.Cliente;
import programa.br.beans.Pano;
public class EmprestimoDAO {
	String cpfCliente;
	int codigoPano;
	String dataRecebimento;
	String dataEntrega;


	public void emprestar(int cod,String cpf){
		ClienteDAO cdao = new ClienteDAO();
		//PanoDAO pdao = new PanoDAO();
		Cliente c = cdao.buscarPorCpf(cpf); 	
		//Pano p = pdao.buscarPorCodigo(cod);	
		//p.setCliente(c);	

	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}


	public int getCodigoPano() {
		return codigoPano;
	}


	public void setCodigoPano(int codigoPano) {
		this.codigoPano = codigoPano;
	}


	public String getDataRecebimento() {
		return dataRecebimento;
	}


	public void setDataRecebimento(String dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}


	public String getDataEntrega() {
		return dataEntrega;
	}


	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}



}

