import java.util.ArrayList;

/**
 * Created by user on 12/04/2017.
 */
public class Jogador implements RegrasJogo {

    protected ArrayList<String> tipoJogada = new ArrayList<String>();
    protected int jogadaEscolhida = 0;

    protected Jogador() {
        tipoJogada.add("pedra");
        tipoJogada.add("papel");
        tipoJogada.add("tesoura");
        tipoJogada.add("lagarto");
        tipoJogada.add("spock");
    }

    @Override
    public String getJogada() {
        return tipoJogada.get(jogadaEscolhida);
    }

    @Override
    public void setJogada(int escolhaJogador) {
        jogadaEscolhida = escolhaJogador;
    }

}
