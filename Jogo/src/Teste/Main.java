package Teste;
import Model.*;

import java.util.Scanner;
public class Main
{
	    
	public static void main(String[] args) {
	
	Scanner s = new Scanner(System.in);
	int exp, pos,sentido, jog =0;
	int dado[] = new int[2], pos_ant[],mov;
	String tab[][] = new String[15][20];
	Regras a = new Regras(0,4);
	Tab tabuleiro = new Tab(tab);

	while(!a.ganhou(jog)){
	    System.out.println("Sua vez: Jogue o dado");
	    dado = a.jogardado();
	    System.out.println("dado 0:"+dado[0]);
	    System.out.println("dado 1:"+dado[1]);
	    System.out.println("Escolha o explorador: 0 - 6");
	    exp = s.nextInt();
	    System.out.println("Escolha qual dado usar: 0 ou 1");
	    pos = s.nextInt();
	    System.out.println("Escolha o sentido: 1 -1 2 -2");
	    sentido = s.nextInt();
	    pos_ant = a.getposicao(jog, exp);
	    mov = a.movimentar(jog,exp,pos,sentido);
	    while(mov !=1 || (a.getposicao(jog, exp)[0] >= 15 || a.getposicao(jog, exp)[0] < 0 || a.getposicao(jog, exp)[1] >= 20 || a.getposicao(jog, exp)[1] < 0)){
	        if(mov == 1) {
	        	a.movimentar(jog,exp,pos,-sentido);
	        }
	        
	        sentido = s.nextInt();
	        mov = a.movimentar(jog,exp,pos,sentido);
	        
	    	
	    }
	    tabuleiro.atualiza_mapa(a, jog, exp,pos_ant);
	    tabuleiro.exibir();
	    System.out.println("Escolha o explorador:");
	    exp = s.nextInt();
	    System.out.println("Escolha o sentido:");
	    sentido = s.nextInt();
	    pos_ant = a.getposicao(jog, exp);
	    mov = a.movimentar(jog,exp,(pos+1)%2,sentido);
	    while(mov !=1 || (a.getposicao(jog, exp)[0] >= 15 || a.getposicao(jog, exp)[0] < 0 || a.getposicao(jog, exp)[1] >= 20 || a.getposicao(jog, exp)[1] < 0)){
	        if(mov == 1) {
	        	a.movimentar(jog,exp,(pos+1)%2,-sentido);
	        }
	        
	        sentido = s.nextInt();
	        mov = a.movimentar(jog,exp,(pos+1)%2,sentido);
	        
	    	
	    }
	    tabuleiro.atualiza_mapa(a, jog, exp,pos_ant);
	    tabuleiro.exibir();
	    jog++;
	    if(jog>3){
	        jog =0;
	    }
	}

}
}
