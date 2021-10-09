package Model;


class Jogador{
    int exploradores[][] = new int[6][2], pontos =0, metas = 0, status_exp[] = {0,0,0,0,0,0}, polo[] = new int[2], polo_oposto[] = new int[2];
    private char cartas[] = new char[10];
    char cor ;
    
    public Jogador(int polo[],int polo_oposto[], char cor){
        this.cor = cor;
        this.polo[0] = polo[0];
        this.polo[1] = polo[1];
       
        this.polo_oposto[0] = polo_oposto[0];
        this.polo_oposto[1] = polo_oposto[1];
        
        for (int i=0;i<6;i++){
            exploradores[i][0] = polo[0];
            exploradores[i][1] = polo[1];
        }
    }
    public int[] getposicao(int ind){
        return exploradores[ind];
    }
    void setposicao(int ind,int i,int j) {
    	exploradores[ind][0] = j;
    	exploradores[ind][1] = i;
    	
    	if(exploradores[ind] == polo_oposto) {
    		status_exp[ind] = 1;
    		pontos++;
    	}
    	
    }
    public void somarpontos(int pontos){
        this.pontos += pontos;
    }
    public int getpontos(){
        return pontos;
    }
    char getcor() {
    	return cor;
    }
    
    boolean status_exp(int ind) {
    	return status_exp[ind] == 1;
    }
    void addmeta() {
    	metas++;
    }
    void volta_polo(int ind) {
    	exploradores[ind][0] = polo[0];
        exploradores[ind][1] = polo[1];

    }
}
