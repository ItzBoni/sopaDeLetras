package components;

public class Person {
    private String name;
    private int id;
    private int num_game;
    private String rol;


    public Person (int id, String name){
        this.name = name;
        this.id = id;
        num_game = 0;
    }

    public Person (){
        name = "nule";
        id = 0;
    }
    

public String getname() {
    return name;
}

public void setname (String name){
this.name = name;
}


public void  setid (int id){
    this.id=id;
}

public int getid (){
    return id;
}


public void setnum_game (int num_game){
this.num_game = num_game;
}


public int getnum_game (){
    return num_game;
}

public void setRol(String rol){
    this.rol = rol;
}

public void getRol(){
    System.out.println("Tu rol es: " + rol);
}

//mostrar info xdxdxd
public void mostrar_info(){
    System.out.println("nombre: " + name );
    System.out.println("id: " + id);
    System.out.println("juego que esta jugando: "+ num_game);
    System.out.println("rol" + rol);
}



    
}
