package fila;

import listaligada.ListaLigada;

public class Fila {
	
	private ListaLigada lista = new ListaLigada();
	
	public void adicionar (Object novoElemento) {
		lista.adicionarNoFinal(novoElemento);
	}
	
	public void remover () {
		lista.removerDoComeco();
	}
	
	public boolean filaVazia() {
		return lista.tamanho() == 0;
	}
	public Object poll() {
		if (filaVazia()) {
			return null;
		}
		Object primeiro = lista.pegaPrimeiro();
		remover();
		return primeiro;
	}
	
	public boolean contem (Object elementoBuscado) {
		return lista.contem(elementoBuscado);
	}
	
	public int tamanho() {
		return lista.tamanho();
	}
	
	public Object pegarUltimo(){
		return lista.pegaUltimo();
	}
	public Object pegarPrimeiro(){
		return lista.pegaPrimeiro();
	}
	
	

}
