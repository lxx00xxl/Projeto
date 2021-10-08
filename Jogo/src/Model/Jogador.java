package Model;


class Jogador{
    private int exploradores[][] = new int[6][2];
    private int pontos = 0;
    private char cartas[] = new char[10];
    char cor ;
    public Jogador(int polo[], char cor){
        this.cor = cor;
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
}