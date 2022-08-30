package pilha;

import listaligada.ListaLigada;

public class Pilha {
	
	private ListaLigada lista = new ListaLigada();
	
	public void push (Object novoElemento) {
		lista.adicionarNoFinal(novoElemento);
	}
	
	public void pop() {
		lista.removerDoFinal();
	}
	
	public Object top() {   //peek
		return lista.pegaUltimo();
	}
	
	public boolean pilhaVazia() {
		return lista.tamanho() == 0;
	}
	
	public boolean contem(Object elementoBuscado) {
		return lista.contem(elementoBuscado);
	}
	
	public int tamanho() {
		return lista.tamanho();
	}
	
	
	

}
