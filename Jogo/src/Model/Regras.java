package Model;

public class Regras {
	int modo, qnt;
	Jogo novo;
	public Regras(int modo, int qnt) {
		this.modo = modo;
		this.qnt = qnt;
		novo = new Jogo(modo,qnt);
		
	}
	
	public int[] jogardado() {
		return novo.jogardado();
	}
	public int dadocolorido() {
		return novo.dado_colorido();
	}
	public int[] getposicao(int ind_jog,int ind_exp) {
		return novo.getposicao(ind_jog, ind_exp);
	}
	public int movimentar(int ind_jog, int ind_exp, int dado, int sentido) {
		return novo.movimentar(ind_jog, ind_exp, dado, sentido);
	}
	
	public boolean ganhou(int ind_jog) {
		return novo.ganhou(ind_jog);
	}
}
