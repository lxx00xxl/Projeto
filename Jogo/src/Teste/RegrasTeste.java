package Teste;
import org.junit.*;
import static org.junit.Assert.*;
import Model.Regras;
import org.junit.Test;

public class RegrasTeste {
	Regras reg = new Regras(0,4);
	int dado[] = reg.jogardado();
	@Test
	public void dado_teste() {
		assertNotNull(dado);
	}
	@Test
	public void dado_colorido_teste() {
		reg.movimentar(1, 0, dado[0], 2);/*Movimenta o 'V' no sentido j*/
		assertNotEquals(reg.getposicao(1, 0)[1],4);
		/*volta o explorador 0 do jogador 'V' ao polo inicial */
		reg.acao_dado_colorido(0, 'V', 0);
		/*Posicao inicial do seu polo*/
		assertEquals(reg.getposicao(1, 0)[0],8);
		assertEquals(reg.getposicao(1, 0)[1],4);
	}
	
	@Test
	public void dado_colorido_teste2() {
		/*Leva o explorador 0 ao polo oposto*/
		reg.acao_dado_colorido(1, 'V', 0);
		/*Posicao do seu polo oposto*/
		assertEquals(reg.getposicao(1, 0)[0],8);
		assertEquals(reg.getposicao(1, 0)[1],14);
	}

	@Test
	public void movimentos_teste() {
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],4);
		/*Movimenta explorador 0 do jogador 0 no sentido j*/
		reg.movimentar(0, 0, dado[0], 2);
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertNotEquals(reg.getposicao(0, 0)[1],4);
		/*Movimenta no sentido i*/
		reg.movimentar(0, 0, dado[0], 1);
		assertNotEquals(reg.getposicao(0, 0)[0],8);
		assertNotEquals(reg.getposicao(0, 0)[1],4);
	}
	@Test
	public void movimentos_teste2() {
		/*Leva o explorador 0 ao polo oposto*/
		reg.acao_dado_colorido(1, 'V', 0);
		/*explorador não realiza mais movimentos*/
		assertEquals(reg.movimentar(1, 0, dado[0], 2),-1);
		
	}
	@Test
	public void movimentos_teste3() {/*Teste de captura do explorador*/
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],4);
		/*Movimenta explorador 0 do jogador 0 no sentido j*/
		reg.movimentar(0, 0, 2, 2);
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],6);
		/*Movimenta explorador 1 do jogador 0 no sentido j e captura o explorador do jogador 0*/
		reg.movimentar(1, 0, 2, 2);
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],4);
		
	}
	@Test
	public void movimentos_teste4() {/*Teste de tentativa de captura*/
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],4);
		/*Movimenta explorador 0 do jogador 0 no sentido j*/
		reg.movimentar(0, 0, 2, 2);
		
		/*Posicao do explorador 1 do jogador 0*/
		assertEquals(reg.getposicao(0, 1)[0],8);
		assertEquals(reg.getposicao(0, 1)[1],4);
		/*Movimenta explorador 0 do jogador 0 no sentido j*/
		reg.movimentar(0, 1, 2, 2);
		
		/*Posicao do explorador 0 e 1 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],6);
		assertEquals(reg.getposicao(0, 1)[0],8);
		assertEquals(reg.getposicao(0, 1)[1],6);
		
		/*Tenta movimentar o explorador do jogador 1 mas tem mais de 1 explorador de outro jogador na casa*/
		assertEquals(reg.movimentar(1, 0, 2, 2), 0);
		/*Posicao do explorador 0 do jogador 1*/
		assertEquals(reg.getposicao(1, 0)[0],8);
		assertEquals(reg.getposicao(1, 0)[1],4);
		
	}
	@Test
	public void movimentos_teste5() {/*Teste de conquista de meta*/
		/*Posicao do explorador 0 do jogador 0*/
		assertEquals(reg.getposicao(0, 0)[0],8);
		assertEquals(reg.getposicao(0, 0)[1],4);
		
		/*Movimenta explorador 0 do jogador 'A'(indice 0) no sentido j*/
		reg.movimentar(0, 0, 2, -2);
		assertNotEquals(reg.ver_ganhador(),'A');
		
		/*Movimenta explorador 1 do jogador 'A'(indice 0) no sentido j e conquista meta*/
		reg.movimentar(0, 1, 2, -2);
		assertEquals(reg.ver_ganhador(),'A');
	}


	@Test
	public void ganhou_teste() {
		/*Levando os 3 exploradores do jogador 1 ao polo oposto*/
		reg.acao_dado_colorido(1, 'V', 0);
		reg.acao_dado_colorido(1, 'V', 1);
		reg.acao_dado_colorido(1, 'V', 2);
		/*Verifica se ganhou*/
		assertFalse(reg.ganhou(1));
		/*Levando os outros 3 exploradores do jogador 1 ao polo oposto*/
		reg.acao_dado_colorido(1, 'V', 3);
		reg.acao_dado_colorido(1, 'V', 4);
		reg.acao_dado_colorido(1, 'V', 5);
		assertTrue(reg.ganhou(1));
		assertEquals(reg.ver_ganhador(),'V');

	}

	

}
