package Model;


class Jogador{
    int exploradores[][] = new int[6][2], pontos =0, metas = 0, status_exp[] = {0,0,0,0,0,0}, polo[] = new int[2], polo_oposto[] = new int[2], ind_cartas = 0;
    private int cartas[] = new int[10];
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
    	
    	if(exploradores[ind][0] == polo_oposto[0] && exploradores[ind][1] == polo_oposto[1]) {
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
    void addcarta(int carta) {
    	this.cartas[ind_cartas] = carta;
    	this.ind_cartas += 1;
    }
    int[] getcartas() {
    	return cartas;
    }
    void volta_polo(int ind) {
    	exploradores[ind][0] = polo[0];
        exploradores[ind][1] = polo[1];

    }
    void vai_polo_oposto(int ind) {
    	setposicao(ind, polo_oposto[1],polo_oposto[0]);

    }
}
