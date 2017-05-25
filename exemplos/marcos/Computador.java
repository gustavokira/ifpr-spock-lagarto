
public class Computador extends  Jogador{
    public Computador() {
    }

    public void setJogadaComputador() {
        this.jogadaEscolhida =  ( (int)(Math.random( )*4) -1);
    }
}