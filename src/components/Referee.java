package components;

public class Referee extends Person{
    private int vecesInterferidas;

     public Referee(int id, String nombre){
        vecesInterferidas = 0;   
        setname(nombre);
        setid(id);
    }

    public void setInterferencias(){
        vecesInterferidas++;
        System.out.println("Ha intervenido: " + vecesInterferidas + "veces.");
    }
}





