package components;
import java.util.Scanner;


public class AppMenu {
    private Scanner sc = new Scanner(System.in);
    private Player[] players = new Player[20];
    private Referee[] referees = new Referee[20];
    private int contador = 0;
    private int numeroRondas;
    private int numeroJugadores;

    public void ShowMenu(){
        registerPersonas();

        System.out.println("ingrese el numero de rondas: ");
        numeroRondas = sc.nextInt();


        System.out.println("ingrese el numero de jugadores: ");
        numeroJugadores = sc.nextInt();

        if (numeroJugadores < 1 || numeroJugadores>2){
            System.out.println("debe ser 1 o 2 jugadores");
            return;
        }
        Player[] selectedPlayers = selectPlayers();
        Referee selectedReferee = selectReferee();

        int rondaactual = 1;
        do {
            System.out.println("iniciando la ronda" + rondaactual);
             Game game = new Game(selectedPlayers[0], selectedPlayers[1], selectedReferee);
             game.iniciarJuego();
             game.finJuego();
             rondaactual++;
        }while (rondaactual <= numeroRondas);


    }

        private void registerPersonas(){
        System.out.println("registrar jugadores o arbitros (minimo 3)" );
        System.out.println("minimo dos jugadores y un arbitro");
        //cuantas personas desea registrar?
        //int xdxd = sc.next int

        for (int i = 0; i < 20; i++){
            System.out.println("ingrese el nombre de la persona: ");
            String name= sc.nextLine();
            int id = i;

            System.out.println("es un jugador o un arbitro? J/A ");
            String tipo = sc.nextLine();


            if (tipo.equalsIgnoreCase("J")) {
                Player player = new Player(id, name);
                player.setRol("Jugador");
                players[contador] = player;

            }else if (tipo.equalsIgnoreCase("A")) {
                Referee referee = new Referee(id, name);
                referee.setRol("arbitro");
                referees[contador] = referee;
            } else {
                System.out.println("opcion invalida, debe ser J o A");
                contador--;
                continue;
            }
            
            System.out.println("registrado con exito");
            contador++;

            if (contador < 20 ){
                System.out.print("¿Registrar otra persona? (S/N): ");
                String response = sc.nextLine();
                
                if (response.equalsIgnoreCase("N")){
                    if (contador<3){
                        System.out.print("registra otra persona (MINIMO SON 3 :V)");
                        System.out.print(" llevas: " + contador + " personas apenas registradas");
                    }
                    break;
                }
            }
        }
    }      

        //pa seleccionar jugadores o arbitro
        //jugador
        private Player[] selectPlayers(){
            Player[] selectedPlayers = new Player [2];

            for (int i = 0; i < numeroJugadores; i++){
                System.out.println("Seleccione el jugador #" + (i + 1) + " (1-" + contador + "): ");
            int playerChoice = sc.nextInt() - 1;

            if(playerChoice>=0 && playerChoice < contador){
                selectedPlayers[i] = players [playerChoice   ];
                System.out.println("Jugador seleccionado: " + selectedPlayers[i].getname());

            }else {
                System.out.println("intenta otra vez");
                i--;
            }
        }
            return selectedPlayers;
     }

     //pa albitro
     private Referee selectReferee() {
        System.out.println("Seleccione el árbitro (1-" + contador + "): ");
        int refereeChoice = sc.nextInt() - 1;  

        if (refereeChoice >= 0 && refereeChoice < contador) {
            System.out.println("Árbitro seleccionado: " + referees[refereeChoice].getname());
            return referees[refereeChoice];
        } else {
            System.out.println("Selección inválida, se asignará un árbitro predeterminado.");
            return referees[0];  
        }
    }
}
        
