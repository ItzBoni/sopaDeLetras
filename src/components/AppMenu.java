package components;
import java.util.Scanner;


public class AppMenu {
    private Scanner sc = new Scanner(System.in);
    private Person[] personas = new Person [20];
    private int contador = 0;
    private int numeroRondas;
    private int numeroJugadores;
    private Game game;


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

        int rondaactual = 1;
        do {
            
            
            System.out.println("iniciando la ronda" + rondaactual);
            //se inicia el juego con el numero de jugadores
            //falta crear un nuevo juego
            rondaactual++;



        }while (rondaactual <= numeroRondas);




    }

        private void registerPersonas(){
        System.out.println("registrar jugadores o arbitros" );
        for (int i = 0; i < 20; i++){
            System.out.println("ingrese el nombre de la persona: ");
            String name= sc.nextLine();
            System.out.println("ingrese el id de la persona: ");
            int id = sc.nextInt();


            System.out.println("es un jugador o un arbitro? J/A ");
            String tipo = sc.nextLine();


            if (tipo.equalsIgnoreCase("J")) {
                Player player = new Player(id, name);
                player.setRol("Jugador");
                personas[contador] = player;
                personas [contador] = player;

            }else if (tipo.equalsIgnoreCase("A")) {
                Referee referee = new Referee(id, name);
                    referee.setRol("arbitro");
            personas [contador] = referee;

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




            }

        }







    }
            
}

