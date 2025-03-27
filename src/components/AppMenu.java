package components;
import java.util.Scanner;


public class AppMenu {
    private Scanner sc = new Scanner(System.in);
    private Registro registro = new Registro();
    private Tablero gameTable =     new Tablero();

public void showmenu(){
    int op;
    do {
        System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar Jugador");
            System.out.println("2. Registrar Árbitro");
            System.out.println("3. Iniciar Juego");
            System.out.println("4. Mostrar Estadísticas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            op = sc.nextInt();
            sc.nextLine();


        switch (op){
            case 1:
            registerPlayer();
            break;
            case 2:
            registerReferee();
            break;
            case 3:
            startGame();
            break;
            case 4:
            showStatistics();
            break;
            case 5:
            System.out.println("xddd");
            break;
            default:
            System.out.println("opcion invalida");

        }
    } while (op !=5);
}

    public void registerPlayer(){
        System.out.println("ingrese el nombre del jugador: ");
        String name = sc.nextLine();
        System.out.println("ingrese el ID del jugador: ");
        int id = sc.nextInt();


        Player player = new Player (id, name);}
        player

    }







}
