import java.util.Scanner;
import java.util.Random;
 
 
class Player {
        
    private int move;
    private int wins;
    
    public Player() {
      this.wins = 0;
    }
        
    public void setMove(int move) {
        this.move = move;
    }
    
    public int getMove() {
        return this.move;
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public void winARound() {
        this.wins++;
    }
    
    public void resetStatus(){
      //reset the data
    }
}
 
class Computer {
    private int wins;
    private int move;
    private Random randomGenerator;
    
    
    public Computer() {
      this.randomGenerator = new Random();
      this.wins = 0;
    }
        
    public void nextMove() {
        this.move = randomGenerator.nextInt(5);
    }
    
    public int getWins() {
        return this.wins;
    }
    
    public int getMove() {
        return this.move;
    }
    
    public void winARound() {
        this.wins++;
    }
    
    
    public void resetStatus(){
      //reset the data
    }
}
 
class GameRules {
        
 
    private int[][] movesResults = new int[5][5];
    private String[] moveNames = new String[5];
    
    public GameRules() {
      
      movesResults[0][0] = 0;
      movesResults[0][1] = 2;
      movesResults[0][2] = 1;
      movesResults[0][3] = 1;
      movesResults[0][4] = 2;
      movesResults[1][0] = 1;
      movesResults[1][1] = 0;
      movesResults[1][2] = 2;
      movesResults[1][3] = 2;
      movesResults[1][4] = 1;
      movesResults[2][0] = 2;
      movesResults[2][1] = 1;
      movesResults[2][2] = 0;
      movesResults[2][3] = 1;
      movesResults[2][4] = 2;
      movesResults[3][0] = 2;
      movesResults[3][1] = 1;
      movesResults[3][2] = 2;
      movesResults[3][3] = 0;
      movesResults[3][4] = 1;
      movesResults[4][0] = 1;
      movesResults[4][1] = 2;
      movesResults[4][2] = 1;
      movesResults[4][3] = 2;
      movesResults[4][4] = 0;
      moveNames[0]="Pedra";
      moveNames[1]="Papel";
      moveNames[2]="Tesoura";
      moveNames[3]="Lagarto";
      moveNames[4]="Spock";
    }
    
    //This one can be made better with a interface :D
    public int getRoundResult(Player player, Computer computer) {
        return this.movesResults[player.getMove()][computer.getMove()];
    }
    
    public int getGameResult(Player player, Computer computer) {
        if((player.getWins()-computer.getWins())>0){
          return 1;
        }else if((player.getWins()-computer.getWins())<0){
          return 2;
        }
        return 0;
    }
    
    public String getMoveName(int move){
      return moveNames[move];
    }
}
 
 
 
/*
pedra papel tesoura lagarto spock
1     2     3       4       5
results[1][1] = 0;
results[1][2] = 2;
results[1][3] = 1;
results[1][4] = 1;
results[1][5] = 2;
 
results[2][1] = 1;
results[2][2] = 0;
results[2][3] = 2;
results[2][4] = 2;
results[2][5] = 1;
 
results[3][1] = 2;
results[3][2] = 1;
results[3][3] = 0;
results[3][4] = 1;
results[3][5] = 2;
 
results[4][1] = 2;
results[4][2] = 1;
results[4][3] = 2;
results[4][4] = 0;
results[4][5] = 1;
 
results[5][1] = 1;
results[5][2] = 2;
results[5][3] = 1;
results[5][4] = 2;
results[5][5] = 0;
 
scissors cut paper
paper cobber rock
rcok kill lizard
lizard poison spock
spock smach scissors
scissors decapicate lizard
lizazrd eat the paper
paper refute the spock
spock vaporize the rock
rock smach the scissors
 
*/
 
 
public class Main {
        
  public static void clearScreen() {  
    System.out.print("\033[H\033[2J");  
    System.out.flush();  
   }  
   
   public static void main(String args[]) {
 
      //Show end game results
       Scanner scanner = new Scanner(System.in);
       GameManager gameManager = new GameManager();
 
        System.out.println("Seja bem vindo(a) ao incrivel:");
        System.out.println("\n===================================");
        System.out.println("Pedra,Papel,Tesoura,Lagarto,Spock");
        System.out.println("===================================");
        
        do{
          System.out.println("\nPrecione 0 para obter informações de como o jogo funciona.");
          System.out.println("Ou um número positivo para a quantidade de rounds que gostaria de jogar:");
          int roundsToPlayNextGame = scanner.nextInt();
          if(roundsToPlayNextGame==0){
            System.out.println("\n=======TUTORIAL========");
            System.out.println("Tesoura Ganha de Papel");
            System.out.println("Papel ganha de Pedra");
            System.out.println("Pedra ganha de Lagarto");
            System.out.println("Lagarto ganha de Spock");
            System.out.println("Spock ganha de Tesoura");
            System.out.println("Tesoura ganha de Lagarto");
            System.out.println("Lagarto ganha de Papel");
            System.out.println("Papel Ganha de Spock");
            System.out.println("Spock Ganha de Pedra");
            System.out.println("Pedra ganha de Tesoura");
          }else{
            gameManager.newGame(roundsToPlayNextGame);
          }
        }while(true);
   }
}
 
 
 
class GameManager {
        
    private Player player;
    private Computer computer;
    private GameRules gameRules;
    private Scanner scanner;
    private int rounds;
    private int actualRound;
    private String[] gameWinnerMessages = {"Parabéns você ganhou! :D","Eita, você perdeu. :/"};
    
    public GameManager() {
      this.gameRules = new GameRules();
      this.scanner = new Scanner(System.in);
    }
 
   private static void clearScreen() {  
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    System.out.flush();  
   }  
    
    public void newGame(int rounds){
      //Gamelogic here
      this.rounds = rounds;    
      this.player = new Player();
      this.computer = new Computer();
      this.actualRound = 0;
      clearScreen();
      // Rounds loop
      while(newRound()){
        //Show information
        if(this.actualRound>this.rounds){
          System.out.println("====== DESEMPATE ======");
        }
        System.out.println("====== ROUND "+this.actualRound+" ======");
        System.out.println("Jogador:"+player.getWins()+" Computador:"+computer.getWins());
        System.out.println("Selecione sua jogada:");
        System.out.println("1)Pedra");
        System.out.println("2)Papel");
        System.out.println("3)Tesoura");
        System.out.println("4)Lagarto");
        System.out.println("5)Spock");
        
        //Get User Move
        int playerMove = 0;
        do{
          playerMove = scanner.nextInt();
          if(playerMove>5||playerMove<1){
            System.out.println("Número de jogada inválido, por favor tente novamente.");
          }
        }while(playerMove>5||playerMove<1);
        
        player.setMove(playerMove-1);
        
        //Get computer Move
        computer.nextMove();
        
        //Print Battle information
        clearScreen();
        System.out.println("\n\nRESULTADOS DO ROUND");
        System.out.println("---------------------------");
        System.out.println("PLAYER            COMPUTER");
        System.out.println(gameRules.getMoveName(player.getMove())+"      VS     "+gameRules.getMoveName(computer.getMove()));
        System.out.println("---------------------------");
 
        //RoundResult
        int roundResult = gameRules.getRoundResult(player,computer);
        
        if(roundResult==1){
          player.winARound();
          System.out.println("Você Ganhou Esse Round!\n\n\n");
        }else if(roundResult==2){
          computer.winARound();
          System.out.println("Você Perdeu Esse Round.\n\n\n");
        }else{
          System.out.println("Esse round empatou.\n\n\n");
        }
      }
        //Show end game results
    }
    
 
    
    public boolean newRound() {
        if(actualRound>=rounds){ 
          if(gameRules.getGameResult(player,computer)>0){
            System.out.println("FINAL");
            System.out.println("Jogador:"+player.getWins()+" Computador:"+computer.getWins());
            System.out.println(this.gameWinnerMessages[this.getWinner()]);
            return false;
          }
          this.actualRound++;
          return true;
        }else{
          this.actualRound++;
          return true;
        }
    }
    
    public int getWinner() {
        return 1;
    }
    
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
