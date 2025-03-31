package components;
import java.util.Scanner;


public class AppMenu {
    private Scanner sc = new Scanner(System.in);
    private Player[] players = new Player[20];
    private Referee[] referees = new Referee[20];
    private int contador = 0;
    private int contadorplayer = 0;

    private int numeroRondas;
    private int numeroJugadores;

    public void ShowMenu(){
        boolean exit = false;
        boolean personas_registradas = false;

        while (!exit){
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Registrar Jugadores y Árbitros");
        System.out.println("2. Iniciar Juego");
        System.out.println("3. Ver Estadísticas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion){
            case 1:
            registerPersonas();
            personas_registradas = true;
            break;
            case 2:
            StartGame(personas_registradas);
             break;
            case 3:
            System.out.println("estadisticas");
            System.out.println("numero de rondas: " + numeroRondas);
            System.out.println("numero de jugadores: " + numeroJugadores);
            System.out.println("personas registradas: " + contador);
            for (int i = 0; i <contadorplayer; i++) {
                System.out.println("Jugador " + (i + 1) + ": " + players[i].getname());
                System.out.println("Aciertos: " + players[i].getAciertos());
               players[i].wins();
               players[i].imprimirAciertos();
                players[i].getJuegosJugados();
            }
            break;
            case 4:
            exit = true;
            System.out.println("graciaaas por jugar");
            break;
            default:
            System.out.println("opcion invalida");
            break;
        


            }
        }
    }
    

//--------------------------PARA EL CASO 1 DE REGISTAR PERSONAS---------------------------------------------
        private void registerPersonas(){
        System.out.println("registrar jugadores o arbitros (minimo 3)" );
        System.out.println("minimo dos jugadores y un arbitro");

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
                contadorplayer++;

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


            if (contador >= 3){
            if (contador < 20 ){
                System.out.print("¿Registrar otra persona? (S/N): ");
                String response = sc.nextLine();
                
                if (response.equalsIgnoreCase("N")){
                    break;
                }
            }
            }
        }
    }      

//----------------------------PA SELECCIONAR JUGADORES O ARBITRO (PAL CASO 2)---------------------------------------------------------
        //jugador
        private Player[] selectPlayers(){
            Player[] selectedPlayers = new Player [2];

            for (int i = 0; i < numeroJugadores; i++){
                System.out.println("Seleccione el jugador #" + (i + 1) + " (1-" + contador + "): ");
            int playerChoice = sc.nextInt() - 1;

            if(playerChoice>=0 && playerChoice < contador){
                selectedPlayers[i] = players [playerChoice  ];
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

//--------------------------------------CASO 2 DE INICIAR JUEGO-------------------------------------------
    private void StartGame(boolean registeredPersons){
        if (registeredPersons){
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
    System.out.println("fin del juego");
}else {
    System.out.println("NO HAY PERSONAS REGISTRADAS");
}
    }


}
        
