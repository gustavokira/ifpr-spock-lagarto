import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GameManager {
    public boolean playing = true;
    private boolean humanTurn = true;

    private Jogador jogador = new Jogador();
    private Computador computador = new Computador();

    public String avalieVencedor() {
        String jogadaComputador = computador.getJogada();
        if (jogador.getJogada().equals(jogadaComputador)) {
            return "";
        } else {
            switch (jogador.getJogada()) {
                case "tesoura":
                    if (jogadaComputador.equals("papel") || jogadaComputador.equals("lagarto")) {
                        return "jogador";
                    } else {
                        if (jogadaComputador.equals("spock") || jogadaComputador.equals("pedra")) {
                            return "computador";
                        }
                    }
                    break;
                case "papel":
                    if (jogadaComputador.equals("pedra") || jogadaComputador.equals("spock")) {
                        return "jogador";
                    } else {
                        if (jogadaComputador.equals("lagarto") || jogadaComputador.equals("tesoura")) {
                            return "computador";
                        }
                    }
                    break;
                case "pedra":
                    if (jogadaComputador.equals("lagarto") || jogadaComputador.equals("tesoura")) {
                        return "jogador";
                    } else {
                        if (jogadaComputador.equals("papel") || jogadaComputador.equals("spock")) {
                            return "computador";
                        }
                    }
                    break;
                case "lagarto":
                    if (jogadaComputador.equals("spock") || jogadaComputador.equals("papel")) {
                        return "jogador";
                    } else {
                        if (jogadaComputador.equals("pedra") || jogadaComputador.equals("tesoura")) {
                            return "computador";
                        }
                    }
                    break;
                case "spock":
                    if (jogadaComputador.equals("pedra") || jogadaComputador.equals("tesoura")) {
                        return "jogador";
                    } else {
                        if (jogadaComputador.equals("papel") || jogadaComputador.equals("lagarto")) {
                            return "computador";
                        }
                    }
                    break;
                default:
                    break;

            }
        }

        return "";
    }

    public void startGame() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Digite o nome do jogador: ");
        String s = br.readLine();
        System.out.print("Bem vindo " + s);
        while (playing) {

            boolean jogadaCorreta = false;
            do {
                System.out.print("Digite o numero da sua jogada (0 - pedra, 1 - papel, 2 - tesoura, 3 - lagarto, 4 - spock");
                try {
                    int jogadaEscolhida = Integer.parseInt(br.readLine());
                    jogador.setJogada(jogadaEscolhida);
                    jogadaCorreta = true;
                } catch (NumberFormatException nfe) {
                    System.err.println("Digite o numero correto...!");
                }

            } while (!jogadaCorreta);
            computador.setJogadaComputador();

            System.out.println("Voce escolheu: " + jogador.getJogada());
            System.out.println("O computador escolheu: " + computador.getJogada());

            String vencedor = avalieVencedor();
            if(vencedor.equals("")){
                System.out.println("Houve um empate, vamos para a próxima rodada");
            }else{
                System.out.println("O vencedor foi: "  + avalieVencedor());
                playing = false;
            }
        }
    }

}

