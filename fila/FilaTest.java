package fila;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FilaTest {

	Fila fila;
	
	@BeforeEach
	void inicializarFila() {
		fila = new Fila();
	}
	
	@Test
	void testarTamanho() {
		assertEquals(0, fila.tamanho());
		fila.adicionar("fernando");
		fila.adicionar("temer");
		fila.adicionar("justo");
		assertEquals(3, fila.tamanho());
	}
	
	@Test
	void adicionarFilaVazia() {
		
		fila.adicionar("fernando");
		
		assertEquals(1, fila.tamanho());
		assertTrue(fila.contem("fernando"));
	}
	
	@Test
	void adicionarFilaComElementos() {
		fila.adicionar("fernando");
		fila.adicionar("marcos");
	
		fila.adicionar("ana");
		
		assertEquals(3, fila.tamanho());
		assertTrue(fila.contem("ana"));
		assertEquals("ana", fila.pegarUltimo());
	}
	
	@Test
	void removerFilaVazia() {
		assertThrows(IllegalArgumentException.class, () -> fila.remover());
	}
	
	@Test 
	void removerFilaComElementos(){
		
		fila.adicionar("fernando");
		fila.adicionar("marcos");
		fila.adicionar("ana");
		
		fila.remover();
		
		assertEquals(2, fila.tamanho());
		assertFalse(fila.contem("fernando"));
		assertEquals("marcos", fila.pegarPrimeiro());
		
	}
	
	@Test
	void PollVazio() {
		assertEquals(null, fila.poll());
		fila.adicionar("marcos");
		fila.adicionar("ana");
		assertEquals("marcos", fila.poll());
	}
	
	@Test
	void PollComElementos() {
		fila.adicionar("fernando");
		fila.adicionar("marcos");
		fila.adicionar("ana");
		
		assertEquals("fernando", fila.poll());
		
	}
	
	@Test 
	void ContemComElementos() {
		
		fila.adicionar("Fernando");
		assertTrue(fila.contem("Fernando"));
	}
	
	@Test 
	void ContemSemElementos() {
		assertFalse(fila.contem("Fernando"));
	}
	
	@Test
	void pegarUltimoComElemento() {
		fila.adicionar("fernando");
		fila.adicionar("marcos");
		fila.adicionar("ana");
		
		assertEquals("ana", fila.pegarUltimo());
	}
	
	@Test
	void pegarUltimoSemElemento() {

		assertThrows(IllegalArgumentException.class, () -> fila.pegarUltimo());
	}
	@Test
	void pegarPrimeiroComElementos() {
		fila.adicionar("fernando");
		fila.adicionar("marcos");
		fila.adicionar("ana");
		
		assertEquals("fernando", fila.pegarPrimeiro());
	}
	@Test
	void pegarPrimeiroSemElementos() {
		assertThrows(IllegalArgumentException.class, () -> fila.pegarPrimeiro());
	}
	
	
	

}
