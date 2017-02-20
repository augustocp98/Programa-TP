package programa.br.beans;
import java.util.ArrayList;
public class Cliente {
private String nome;
private String cpf;
private String municipio;
private String estado;
private String rua;
private String bairro;
private  double totalVenda;

public Cliente(String nome, String cpf, String municipio, String estado, String rua, String bairro, double totalVenda) {
	super();
	this.nome = nome;
	this.cpf = cpf;
	this.municipio = municipio;
	this.estado = estado;
	this.rua = rua;
	this.bairro = bairro;
	this.totalVenda = totalVenda;
}



public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCpf() {
	return cpf;
}
public void setCpf(String cpf) {
	this.cpf = cpf;
}
public String getMunicipio() {
	return municipio;
}
public void setMunicipio(String municipio) {
	this.municipio = municipio;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getRua() {
	return rua;
}
public void setRua(String rua) {
	this.rua = rua;
}
public String getBairro() {
	return bairro;
}
public void setBairro(String bairro) {
	this.bairro = bairro;
}
public double getTotalVenda() {
	return totalVenda;
}
public void setTotalVenda(double totalVenda) {
	this.totalVenda = totalVenda;
}


}
