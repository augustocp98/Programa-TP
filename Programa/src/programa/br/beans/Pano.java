package programa.br.beans;

public class Pano {
int codigoPano;
String dataMontagem;
boolean emprestado;
Cliente cliente;

public Pano(int codigoPano, String dataMontagem, boolean emprestado, Cliente cliente) {
	super();
	this.codigoPano = codigoPano;
	this.dataMontagem = dataMontagem;
	this.emprestado = emprestado;
	this.cliente = cliente;
}

public int getCodigoPano() {
	return codigoPano;
}
public void setCodigoPano(int codigoPano) {
	this.codigoPano = codigoPano;
}
public String getDataMontagem() {
	return dataMontagem;
}
public void setDataMontagem(String dataMontagem) {
	this.dataMontagem = dataMontagem;
}
public boolean isEmprestado() {
	return emprestado;
}
public void setEmprestado(boolean emprestado) {
	this.emprestado = emprestado;
}
public Cliente getCliente() {
	return cliente;
}
public void setCliente(Cliente cliente) {
	this.cliente = cliente;
}



}
