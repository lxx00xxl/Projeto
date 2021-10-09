package Model;
import java.util.Random;
class Jogo{
    int modo = 0;
    Random random = new Random();
    int dado[] = new int[2], pos_metas[][]= {{2,1},{8,4}};
    Jogador jog[];
    int polo[]= new int[2], polo_oposto[] = new int[2];
    char cor[] = {'A','V','R','L'};
    {
        polo[0] = 3;
        polo[1] = 10;
        polo_oposto[0] = 17;
	polo_oposto[1] = 10;
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
}
