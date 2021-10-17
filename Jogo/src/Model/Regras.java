package Model;

public class Regras {
	int modo, qnt;
	Jogo novo;
	public Regras(int modo, int qnt) {
		this.modo = modo;
		this.qnt = qnt;
		novo = new Jogo(modo,qnt);
		
	}
	
	public int[] jogardado() {/*joga os dados e retorna {dado0,dado1}*/
		return novo.jogardado();
	}
	public char dadocolorido() {/*joga o dado colorido e retorna a cor*/
		char cor = novo.dado_colorido();
		
		return cor;
	}
	public void acao_dado_colorido(int ind_jog, char cor, int ind_exp) {/*faz a acao do dado colorido*/
		int indice = novo.compara_cor(cor);
		novo.acao_dado_colorido(ind_jog, indice, ind_exp);
	}
	public int[] getposicao(int ind_jog,int ind_exp) {/*retorna a posicao do explorador*/
		return novo.getposicao(ind_jog, ind_exp);
	}
	public int movimentar(int ind_jog, int ind_exp, int dado, int sentido) {/*movimenta se possível o explorador no sentido escolhido*/
		return novo.movimentar(ind_jog, ind_exp, dado, sentido);
	}
	
	public boolean ganhou(int ind_jog) {/*verifica se todos os 6 exploradores do jogador estão no polo oposto*/
		return novo.ganhou(ind_jog);
	}
	public char ver_ganhador() {/*Faz a contagem dos pontos e retorna quem tiver maior pontuacao*/
		return novo.ver_ganhador();
	}
}
