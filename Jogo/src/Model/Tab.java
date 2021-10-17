package Model;

public class Tab {
	String tab[][] = new String[15][20];
	int metas[] = {0,0};
	
	public Tab(String[][] tab) {
		for(int i = 0; i<15; i++){
            for(int j =0; j<20;j++){
                tab[i][j] = "0";
            }

        }
   	 	tab[8][4] = "P";
		tab[8][14] = "P";
		tab[8][2] = "M";
		tab[8][8] = "M";
		this.tab = tab;
		
	}
	
    public void atualiza_mapa(Regras reg,int ind_jog,int ind_exp,int[] pos_ant){
    	Jogo a = reg.novo;
        int j,i;
        char cor[] = {'A','V','R','L'}; 
        i = pos_ant[0];
        j = pos_ant[1];
        ver_metas(reg, ind_jog);
        if(a.ver_pos(ind_jog, i,j)[1] == 0) {
        	tab[i][j] = "0";
        }
        else {
        	tab[i][j] = cor[ind_jog] + Integer.toString(a.ver_pos(ind_jog, i, j)[1]);
        }
        i = a.getposicao(ind_jog,ind_exp)[0];
        j = a.getposicao(ind_jog,ind_exp)[1];
        if(metas[0] == 0) {
        	tab[8][2] = "M";
        }
        if(metas[1] == 0) {
        	tab[8][8] = "M";
        }
        tab[8][4] = "P";
		tab[8][14] = "P";
        tab[i][j] = cor[ind_jog] + Integer.toString(a.ver_pos(ind_jog, i, j)[1]);
    }
    
    public void ver_metas(Regras reg, int ind_jog) {
    	Jogo a = reg.novo;
    	if(a.ver_pos(ind_jog, 8, 2)[1] > 1) {
        	metas[0] = 1;
        }
    	if(a.ver_pos(ind_jog, 8, 8)[1] > 1) {
        	metas[1] = 1;
        }
    	
    }
    public void exibir(){
        for(String i[]: tab){
            for(String j: i){
                System.out.print(j + "  ");
            }
            System.out.println();
        }
    }

}
