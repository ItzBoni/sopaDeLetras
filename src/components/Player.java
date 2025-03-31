package components;


public class Player extends Person implements statistics{
    private int aciertos, juegosJugados, ganados;


    
    public Player(int id, String nombre){
        juegosJugados = 0;
        ganados = 0;
        aciertos = 0;
        setname(nombre);
        setid(id);

    }

    public void gainPoint(){
        aciertos++;
        System.out.println("Tienes " + aciertos + " aciertos.");
    }

    public void juego(){
        juegosJugados++;
        System.out.println("Has jugado: "+ juegosJugados + " juegos.");
    }

   
    public void sumarGanados(){
        ganados++;
        System.out.println("Has ganado " + ganados);
    }

    public int getAciertos(){
        return aciertos;
    }

    public int getJuegosJugados(){
        return juegosJugados;
    }

    public int getGanados(){
        return ganados;
    }

    @Override
    public void wins(){
        System.out.println(getname() + " llevas: " + ganados + " juegos ganados.");
    }
    @Override
    public void imprimirAciertos(){
        System.out.println(getname() + " llevas: " + aciertos + " aciertos.");
    }

    public void imprimirNombres(){
    System.out.println ("el nombre es" + getname());

    } 
}
