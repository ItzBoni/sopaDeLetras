package components;

public class Referee extends Person{
    private int vecesInterferidas;

     public Referee(int id, String nombre){
        vecesInterferidas = 0;   
    }

    public void setInterferencias(){
        vecesInterferidas++;
        System.out.println("Ha intervenido: " + vecesInterferidas + "veces.");
    }
}





