package programa.br.beans;

public class Emprestimo {
	private String cpfCliente;
	private int codigoPano;
	private String dataRecebimento;
	private String dataEntrega;
	
	public Emprestimo(String cpfCliente, int codigoPano, String dataRecebimento, String dataEntrega) {
		super();
		this.cpfCliente = cpfCliente;
		this.codigoPano = codigoPano;
		this.dataRecebimento = dataRecebimento;
		this.dataEntrega = dataEntrega;
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
