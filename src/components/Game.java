package components;
import java.util.Scanner;
import java.lang.String;

public class Game {
  private Scanner sc = new Scanner(System.in);
  private String condicion;
  private boolean refereeIntervencion;
  AppMenu menu = new AppMenu();
  private Player player1;
  private Player player2;
  private Referee referee;

  public Game(Player player1, Player player2, Referee referee){
    this.player1 = player1;
    this.player2 = player2;
    this.referee= referee;
  }

  public void iniciarJuego(){
      
    System.out.println("Estos son los jugadores:" + player1.getname() + " y " + player2.getname());
    System.out.println("Este es el referee: " + referee.getname());
    Tablero table = new Tablero(); //Crear el tablero

    System.out.println("Iniciar juego? true para sí, false para no");
    condicion = sc.nextLine(); //Booleano para iniciar el juego, pura estetica 
    condicion = condicion.toUpperCase();

    if(condicion.equals("TRUE")){
      do {
        for(int i = 0; i < 2; i++){
          table.printTable();
          System.out.println("Turno :" + (i+1));
          boolean isCorrect = table.findWords();
          if(isCorrect){
            if(i == 0){
              player1.gainPoint();
            }else{
              player2.gainPoint();
            }
          }
          System.out.println("El referee quiere intervenir? (true/false)");
          refereeIntervencion = sc.nextBoolean();
          if(refereeIntervencion){
            referee.setInterferencias();
          }else{
            System.out.println("Juego Limpio");
          }

        }
      }while(table.wordsFound < 8);
      //Salio del while
    }else{
      System.out.println("Juego cancelado");
    }
  }


  public void finJuego(){
    int aciertos1 = player1.getAciertos();
    int aciertos2 = player2.getAciertos();

    if(aciertos1 > aciertos2){
      System.out.println("Ganador: " + player1.getname());
      player1.gainPoint();
    }else if(aciertos1 <  aciertos2){
      System.out.println("Ganador: " + player2.getname());
      player2.gainPoint();
    }else{
      System.out.println("Empate!!!");
    }
    player1.imprimirAciertos();
    player1.wins();
    player2.imprimirAciertos();
    player2.wins();
  }
}


