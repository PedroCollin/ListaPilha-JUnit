package listaligada;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ListaLigadaTest {

	ListaLigada lista;

	@BeforeEach
	void inicializarListaLigada() {
		this.lista = new ListaLigada();
	}

	@Test
	void adicionarComecoListaVazia() {

		lista.adicionarNoComeco("fernando");

		assertEquals(1, lista.tamanho());
		assertTrue(lista.contem("fernando"));

	}

	@Test
	void adicionarFinalListaVazia() {

		lista.adicionarNoFinal("fernando");

		assertEquals(1, lista.tamanho());
		assertTrue(lista.contem("fernando"));

	}

	@Test
	void adicionarComecoListaComElementos() {

		lista.adicionarNoFinal("fernando");
		lista.adicionarNoFinal("maria");
		lista.adicionarNoFinal("bruno");

		lista.adicionarNoComeco("didi");

		assertEquals(4, lista.tamanho());
		assertTrue(lista.contem("didi"));
		assertEquals("didi", lista.pegaPrimeiro());

	}

	@Test
	void adicionarFinalListaComElementos() {

		lista.adicionarNoComeco("fernando");
		lista.adicionarNoComeco("maria");
		lista.adicionarNoComeco("bruno");

		lista.adicionarNoFinal("didi");

		assertEquals(4, lista.tamanho());
		assertTrue(lista.contem("didi"));
		assertEquals("didi", lista.pegaUltimo());

	}

	@Test
	void pegaCelulaPosicaoValida() {

		lista.adicionarNoComeco("fernando");
		lista.adicionarNoComeco("maria");
		lista.adicionarNoComeco("bruno");

		assertEquals("maria", lista.pegar(1));
	}

	@Test
	void pegaCelulaPosicaoInvalida() {

		lista.adicionarNoComeco("fernando");
		lista.adicionarNoComeco("maria");
		lista.adicionarNoComeco("bruno");

		assertThrows(IllegalArgumentException.class, () -> lista.pegar(10));
	}

	@Test
	void adicionaPosicaoInvalida() {

		lista.adicionarNoComeco("fernando");
		lista.adicionarNoComeco("maria");
		lista.adicionarNoComeco("bruno");

		assertThrows(IllegalArgumentException.class, () -> lista.adicionarNaPosicao(-100, "fernando"));

	}

	@Test
	void adicionaPosicaoValida() {

		lista.adicionarNoComeco("fernando");
		lista.adicionarNoComeco("maria");
		lista.adicionarNoFinal("bruno");

		lista.adicionarNaPosicao(1, "didi");

		assertEquals(4, lista.tamanho());
		assertTrue(lista.contem("didi"));
		assertEquals("maria", lista.pegar(0));
		assertEquals("didi", lista.pegar(1));
		assertEquals("fernando", lista.pegar(2));

	}

	@Test
	void removerNoFinalListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.removerDoFinal());
	}

	@Test
	void removerNoFinalComElementos() {
		lista.adicionarNaPosicao(0, "didi");
		lista.adicionarNaPosicao(1, "mussum");
		lista.adicionarNaPosicao(2, "zacarias");

		lista.removerDoFinal(); 

		assertEquals("mussum", lista.pegaUltimo());
	}

	@Test
	void removerNoComecoListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.removerDoComeco());
	}

	@Test
	void removerNoComecoComElementos() {
		lista.adicionarNaPosicao(0, "didi");
		lista.adicionarNaPosicao(1, "mussum");
		lista.adicionarNaPosicao(2, "zacarias");

		lista.removerDoComeco();

		assertEquals("mussum", lista.pegaPrimeiro());
	}

	@Test
	void removerNaPosicaoListaVazia() {
		assertThrows(IllegalArgumentException.class, () -> lista.remover(0));
	}

	@Test
	void removerNaPosicaoInvalida() {
		lista.adicionarNaPosicao(0, "didi");
		assertThrows(IllegalArgumentException.class, () -> lista.remover(1));
		assertThrows(IllegalArgumentException.class, () -> lista.remover(-1));
		assertThrows(IllegalArgumentException.class, () -> lista.remover(10));
	}

	@Test
	void removerNaPosicaoListaComElementos() {
		lista.adicionarNaPosicao(0, "didi");
		lista.adicionarNaPosicao(1, "mussum");
		lista.adicionarNaPosicao(2, "zacarias");

		lista.remover(1);

		assertEquals("zacarias", lista.pegar(1));
		assertEquals("didi", lista.pegar(0));
	}

}
