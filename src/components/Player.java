package components;


public class Player extends Person implements statistics{
    private int aciertos, juegosJugados, ganados;

    public Player(int id, String nombre){
        juegosJugados = 0;
        ganados = 0;
        aciertos = 0;
    }

    public void gainPoint(){
        aciertos++;
        System.out.println("Tienes " + aciertos + ".");
    }

    public void juego(){
        juegosJugados++;
        System.out.println("Has jugado: "+ juegosJugados + ".");
    }

   
    public void sumarGanados(){
        ganados++;
        System.out.println("Has ganado " + ganados);
    }

    @Override
    public void wins(){
        System.out.println("Llevas: " + ganados + "juegos ganados.");
    }
    @Override
    public void imprimirAciertos(){
        System.out.println("Llevas: " + aciertos + "aciertos.");
    }

    public void imprimirNombres(){
    System.out.println ("el nombre es" + getname());

    } 
}
