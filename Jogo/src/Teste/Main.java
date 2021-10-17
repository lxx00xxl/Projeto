package Teste;
import Model.*;

import java.util.Scanner;
public class Main
{
	    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int exp, pos,sentido, jog =0, ant =0, qnt, modo = 0;
	int dado[] = new int[2], pos_ant[],mov;
	String tab[][] = new String[15][20];
	Tab tabuleiro = new Tab(tab);
	char cor;
	System.out.println("Quantos jogadores: 2 ou 4");
    qnt = s.nextInt();
    if(qnt >2) {
    	 System.out.println("modo: 0 - individual 1 - duplas");
    	 modo = s.nextInt();
    }
    Regras a = new Regras(modo,qnt);
	while(!a.ganhou(ant)){
		exp = -1;
	    System.out.println("Sua vez: Jogue o dado jogador " + (jog+1));
	    dado = a.jogardado();
	    System.out.println("dado 0:"+dado[0]);
	    System.out.println("dado 1:"+dado[1]);
	    
	    if(dado[0] == dado[1]) {
	    	cor = a.dadocolorido();
	    	System.out.println("Dado colorido!");
	    	System.out.println("cor: " + cor);
	    	if(cor != 'P') {
	    		System.out.println("Escolha o explorador do jogador da cor: 0 - 6");
			    exp = s.nextInt();
	    	}
	    	a.acao_dado_colorido(jog, cor, exp);
	    }
	    
	    System.out.println("Escolha o explorador: 0 - 6");
	    exp = s.nextInt();
	    System.out.println("Escolha qual dado usar: 0 ou 1");
	    pos = s.nextInt();
	    System.out.println("Escolha o sentido: 1(baixo) -1(cima) 2(lado-es) -2(lado-di)");
	    sentido = s.nextInt();
	    pos_ant = a.getposicao(jog, exp);
	    mov = a.movimentar(jog,exp,dado[pos],sentido);
	    while(mov !=1 || (a.getposicao(jog, exp)[0] >= 15 || a.getposicao(jog, exp)[0] < 0 || a.getposicao(jog, exp)[1] >= 20 || a.getposicao(jog, exp)[1] < 0)){
	        if(mov == 1) {
	        	a.movimentar(jog,exp,dado[pos],-sentido);
	        }
	        else if(mov == -1) {
	        	System.out.println("Explorador chegou no Polo. Escolha outro explorador:");
	    	    exp = s.nextInt();
	        }

	        sentido = s.nextInt();
	        mov = a.movimentar(jog,exp,dado[pos],sentido);
	        
	    	
	    }
	    System.out.println("Movimentou!");
	    tabuleiro.atualiza_mapa(a, jog, exp,pos_ant);
	    tabuleiro.exibir();
	    System.out.println("Escolha o explorador:");
	    exp = s.nextInt();
	    System.out.println("Escolha o sentido:");
	    sentido = s.nextInt();
	    pos_ant = a.getposicao(jog, exp);
	    mov = a.movimentar(jog,exp,dado[(pos+1)%2],sentido);
	    while(mov !=1 || (a.getposicao(jog, exp)[0] >= 15 || a.getposicao(jog, exp)[0] < 0 || a.getposicao(jog, exp)[1] >= 20 || a.getposicao(jog, exp)[1] < 0)){
	        if(mov == 1) {
	        	a.movimentar(jog,exp,dado[(pos+1)%2],-sentido);
	        }
	        else if(mov == -1) {
	        	System.out.println("Explorador chegou no Polo. Escolha outro explorador:");
	    	    exp = s.nextInt();
	        }
	        
	        sentido = s.nextInt();
	        mov = a.movimentar(jog,exp,dado[(pos+1)%2],sentido);
	        
	    	
	    }
	    System.out.println("Movimentou!");
	    tabuleiro.atualiza_mapa(a, jog, exp,pos_ant);
	    tabuleiro.exibir();
	    ant = jog;
	    jog++;
	    if(jog>qnt-1){
	        jog =0;
	    }
	}
	System.out.println("O ganhador foi o " + a.ver_ganhador());

}
}
