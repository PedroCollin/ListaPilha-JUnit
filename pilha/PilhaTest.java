package pilha;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {

	Pilha pilha;

	@BeforeEach
	void inicializarFila() {
		pilha = new Pilha();
	}
	
	@Test
	void testeTamanho() {
		assertEquals(0, pilha.tamanho());
		
		pilha.push("fernando");
		pilha.push("marcos");
		pilha.push("ana");
		
		assertEquals(3, pilha.tamanho());
	}
	
	@Test
	void adicionarPilhaVazia() {
		
		pilha.push("fernando");
		
		assertEquals(1, pilha.tamanho());
		assertTrue(pilha.contem("fernando"));
	}
	
	@Test
	void adicionarPilhaComElementos() {
		
		pilha.push("fernando");
		pilha.push("marcos");
		pilha.push("ana");
		
		assertEquals(3, pilha.tamanho());
		assertTrue(pilha.contem("ana"));
		assertEquals("ana", pilha.top());
	}
	
	@Test
	void pilhaEstaVaziaSemElementos() {
		assertTrue(pilha.pilhaVazia());
	}
	
	@Test
	void pilhaEstaVaziaComElementos() {
		pilha.push("Michel");
		assertFalse(pilha.pilhaVazia());
	}
	
	
	@Test
	void TopElementoComElementos() {
		pilha.push("fernando");
		pilha.push("marcos");
		pilha.push("ana");
		
		assertTrue(pilha.contem("ana"));
	}
	
	void TopElementoSemElementos() {
		assertThrows(IllegalArgumentException.class, ()-> pilha.top());
	}
	
	@Test
	void ContemElementoComElemento() {
		pilha.push("Michel");
		assertTrue(pilha.contem("Michel"));
	}
	
	@Test
	void ContemElementoSemElemento() {
		assertFalse(pilha.contem("Michel"));
	}
	
	@Test
	void RemoverVazio() {
		assertThrows(IllegalArgumentException.class, ()-> pilha.pop());
		pilha.push("fernando");
		pilha.push("marcos");
		pilha.push("ana");
		pilha.pop();
		assertEquals(2, pilha.tamanho());
	}
	
	void RemoverContendo() {
		pilha.push("Michel");
		assertTrue(pilha.contem("Michel"));
		pilha.pop();
		assertEquals(0, pilha.tamanho());
	}
	

}
