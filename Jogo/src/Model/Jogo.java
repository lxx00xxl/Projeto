package Model;
import java.util.Random;
class Jogo{

    Random random = new Random();
    int dado[] = new int[2], pos_metas[][]= {{8,2},{8,8}}, modo = 0,polo[]= new int[2], polo_oposto[] = new int[2];
    Jogador jog[];
    char cor[] = {'A','V','R','L'}, time1[] = {cor[0],cor[1]},time2[] = {cor[2],cor[3]};
    {
        
        polo[0] = 4;
        polo[1] = 8;
        polo_oposto[0] = 14;
		polo_oposto[1] = 8;
    }
    
    
    public Jogo(int modo, int qnt){
        this.modo = modo;
        jog = new Jogador[qnt];
        
        for(int x =0; x<qnt;x++) {
        	if(x >= qnt/2) {
        		polo[0] = 14;
                polo[1] = 8;
                polo_oposto[0] = 4;
        		polo_oposto[1] = 8;
        	}
            jog[x] = new Jogador(polo,polo_oposto,cor[x]);
        }
    }
    public int[] jogardado(){
        dado[0] = random.nextInt(6)+1;
        dado[1] = random.nextInt(6)+1;
        return dado;
    }
    public int dado_colorido(){
        if(dado[0] == dado[1]){
            return 1;
        }
        return 0;
    }
    int ver_exp(int ind_jog, int i, int j) {/*verifica qual explorador de um jogador esta na posicao [i][j]*/
    	for(int x =0; x<6;x++) {
    		if(jog[ind_jog].getposicao(x)[0] == j && jog[ind_jog].getposicao(x)[1] == i) {
    			return x;
    		}
    	}
    	return 0;
    }
    boolean ver_time(char time[], char a, char b) {/*Verifica se a e b pertencem ao mesmo time*/
    	return (a == time[0] || a == time[1]) && (b == time[0] || b == time[1]) ;
    }
    boolean capturar(int ind_jog,int i, int j) {
    	boolean meta = false;
    	int pos[] = ver_pos(ind_jog,i,j), ind_jog2 = pos[0],ind_exp;
    	if(pos[1] == 1) {/*Se a posicao que o explorador vai se mover ja tem 1 explorador do mesmo jogador*/
    		for (int x[]: pos_metas) {
    			if(i == x[0] && j == x[1]) {/*Se tiver uma meta*/
    				meta = true;
    				x[1] = -1;
    				x[0] = -1;
    			}
    			
    		}
    		if(meta) {/*adiciona a meta ao jogador e soma os pontos*/
    			jog[ind_jog].addmeta();
    			jog[ind_jog].somarpontos(1);
    			System.out.println("Ganhou uma meta!");

    		}
    	}
    	else if(pos[1] == -1) {/*Se a posicao tiver um explorador de outro jogador*/
    		if(modo == 1) {/*Se o jogo for em duplas*/
    			if(ver_time(time1,jog[ind_jog].getcor(),jog[ind_jog2].getcor()) || ver_time(time2,jog[ind_jog].getcor(),jog[ind_jog2].getcor())) {
    				return false;
    			}
    		}
    		System.out.println("Capturou!");
    		/*Captura o explorador advesário*/
    		ind_exp = ver_exp(ind_jog2,i,j);
    		jog[ind_jog2].volta_polo(ind_exp);
    		
    	}
    	return true;
    }
    public int[] ver_pos(int ind_jog,int i,int j){/*verifica a posicao que o explorador vai se mover*/
    	int qnt =0, ind_jog2 =0,y=0, res[] = {0,0};
        for(Jogador x: jog) {
        	for(int ind =0;ind<6;ind++) {
        		if(x.getposicao(ind)[0] == j && x.getposicao(ind)[1] == i ) {/*Se a posicao tiver exploradores*/
        			if(x == jog[ind_jog]) {/*Se o explorador for do mesmo jogador*/
            			qnt++;
            		}
        			else {/*Se o explorador for de um jogador diferente*/
        				qnt--;
        			}
        			ind_jog2 = y;
        		}
        		
        	}
        	y++;
        }
        res[0] = ind_jog2 ;
        res[1] = qnt;
        return res; /*retorna o indice do jogador e a quantidade de exploradores na posicao*/
    }
    public int movimentar(int ind_jog,int ind_exp,int x, int sent){
        int i,j,dis[] = {0,0};
        if(jog[ind_jog].status_exp(ind_exp)){
    		return 0;
    	}
        
        i = jog[ind_jog].getposicao(ind_exp)[1];
        j = jog[ind_jog].getposicao(ind_exp)[0];
        dis[0] = j;
        dis[1] = i;
        if(sent ==1){
        	dis[1] += dado[x];
        }
        else if(sent == -1){
        	dis[1] -= dado[x];
        }
        else if(sent == 2){
        	dis[0] += dado[x];
        }
        else{
        	dis[0] -= dado[x];
        }
        
        if((ver_pos(ind_jog,dis[1],dis[0])[1] > -2    && capturar(ind_jog,dis[1],dis[0])) || (jog[ind_jog].polo_oposto[1] == dis[1] && jog[ind_jog].polo_oposto[0] == dis[0]) ){
        	System.out.println("Movimentou!");
        	jog[ind_jog].setposicao(ind_exp, dis[1], dis[0]);
        	return 1;
        }        
        
        return 0;
    }

    
}
