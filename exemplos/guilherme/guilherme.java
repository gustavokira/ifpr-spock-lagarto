import java.util.Scanner;
 
class Main {
  public static void main(String[] args) {
    
    Jogo jogo = new Jogo();
    jogo.jogar();
  }
}
 
class Jogo{
  
  private Jogador jogador;
  private Computador computador;
  
  public Jogo(){
    jogador = new Jogador();
    computador = new Computador();
  }
  
  public void jogar(){
    boolean empatou = true;
 
    while(empatou){
      jogador.escolher();
      computador.escolher();
      empatou = verificarVencedor();
    }
  }
  
  public boolean verificarVencedor(){
    String jogadaJogador = this.jogador.getJogada();
    String jogadaComputador = this.computador.getJogada();
    boolean ComputadorVenceu = true;
    boolean empatou = false;
    if(!jogadaJogador.equals(jogadaComputador)){
      switch(jogadaJogador){
        case "Papel":
          switch(jogadaComputador){
            case "Pedra":
              ComputadorVenceu = false;
              break;
            case "Spock":
              ComputadorVenceu = false;
              break;
          }
          break;
        case "Pedra":
          switch(jogadaComputador){
            case "Lagarto":
              ComputadorVenceu = false;
              break;
            case "Tesoura":
              ComputadorVenceu = false;
              break;
          }
          break;
        case "Tesoura":
          switch(jogadaComputador){
            case "Lagarto":
              ComputadorVenceu = false;
              break;
            case "Papel":
              ComputadorVenceu = false;
              break;
          }
          break;
        case "Lagarto":
          switch(jogadaComputador){
            case "Papel":
              ComputadorVenceu = false;
              break;
            case "Spock":
              ComputadorVenceu = false;
              break;
          }
          break;
        case "Spock":
          switch(jogadaComputador){
            case "Tesoura":
              ComputadorVenceu = false;
              break;
            case "Pedra":
              ComputadorVenceu = false;
              break;
          }
          break;
        default:
          
      }
      if(ComputadorVenceu){
        System.out.println("Computador Venceu!!!");
      }
      else{
        System.out.println("Jogador venceu");
      }
    }
    else{
      empatou = true;
       System.out.println("Houve empate, jogaremos mais uma rodada!!!");
    }
    System.out.println("");
    return empatou;
  }
  
  
}
 
class Jogador{
  private String jogada;
  
  public Jogador(){
    jogada = "";
  }
  
  public void escolher(){
    int jogada = 0;
    boolean escolheu = false;
    Scanner sc = new Scanner(System.in);
    
    while(!escolheu){
      System.out.println("Escolha a sua jogada:");
      System.out.println("1 - Papel");
      System.out.println("2 - Pedra");
      System.out.println("3 - Tesoura");
      System.out.println("4 - Lagarto");
      System.out.println("5 - Spock");
      jogada = sc.nextInt();
      if(jogada>=1 && jogada <=5){
        escolheu = true;
      }
      else{
         System.out.println("Jogada invalida!!! escolha novamente!!!");
      }
    }
   
    //esta em string para ficar mais facil de comparar dpois
    switch(jogada){
      case 1:
        this.jogada = "Papel";
        break;
      case 2:
        this.jogada = "Pedra";
        break;
      case 3:
        this.jogada = "Tesoura";
        break;
      case 4:
        this.jogada = "Lagarto";
        break;
      case 5:
        this.jogada = "Spock";
        break;
    }
     System.out.println("Jogador Escolheu: "+this.jogada);
     
  }
  
  public String getJogada(){
    return jogada;
  }
}
 
class Computador{
  private String jogada;
  
  public Computador(){
    jogada = "";
  }
  
  public void escolher(){
    double valorAleatorio = Math.random();
    if(valorAleatorio<=0.2){
      this.jogada = "Papel";
    }
    else if(valorAleatorio<=0.4){
      this.jogada = "Pedra";
    }
    else if(valorAleatorio<=0.6){
      this.jogada = "Tesoura";
    }
    else if(valorAleatorio<=0.8){
      this.jogada = "Lagarto";
    }
    else{
      this.jogada = "Spock";
    }
    
    System.out.println("Computador Escolheu: " + this.jogada );
  }
  
  public String getJogada(){
    return jogada;
  }
}
 
