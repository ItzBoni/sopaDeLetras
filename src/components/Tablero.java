package components;
import java.util.Random;
//Santi
public class Tablero extends userInput{
    private Random r = new Random();
    private int[] direction = new int[8];
    private char[][] myTable;
    private boolean[][] isOccupied = new boolean[16][16];
    private String[] wordArray = new String[8];
    public int wordsFound = 0;

    private char[][] createTable(){
        int tam = 16;
        char[][] matriz = new char[tam][tam];

        //For para llenar el arreglo isOccupied de 0's cuando se cree la tabla de palabras
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                isOccupied[i][j] = false;
            }
        }

        return matriz;
    }

    private char[][] fillTable(char[][] table){
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                table[i][j] = (char)(65 + r.nextInt(26));
            }
        }
        return table;
    }

    public void printTable(){
        for (int i = 0; i < 16; i++) {
            char myChar = (char)(65 + i);
            System.out.print(myChar + "    ");
        }
        System.out.print("\n");
        System.out.print("-----------------------------------------------------------------------------------");
        System.out.print("\n");
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                System.out.print(myTable[i][j] + "    ");
            }
            System.out.print( (i + 1) + "\n");
        }
    }

    //Funcion que revisa si hay colisiones
    private boolean collisionCheck(boolean[][] boolMatrix, int i, int j, int dir, String word) { 
        boolean collision = false;

        switch (dir) {
            case 0://Diagonal
                for (int temp = 0; temp < word.length(); temp++) {
                    if(boolMatrix[temp+i][temp+j]){
                        collision = true;
                        break;
                    }
                }
                break;
            case 1: //Vertical
                for (int temp = 0; temp < word.length(); temp++) {
                    if(boolMatrix[temp+i][j])
                    {
                        collision = true;
                        break;
                    }
                }
                break;
            case 2: //Horizontal
                for (int temp = 0; temp < word.length(); temp++) {
                    if (boolMatrix[i][temp+j])
                    {
                        collision = true;
                        break;
                    }
                }
                break;
            default:
                break;
        }

        collision = boolMatrix[i][j];

        return collision;
    }
    
    private void setWords(){               
        wordArray = captureUserInput();
        for (int i = 0; i < wordArray.length; i++) {
            System.out.println(wordArray[i]);  
        }
        int tempCounter = 0;
        //Intento agregar la palabra en una posicion random y si colisiona entonces la mando a otra posicion
        while (tempCounter < 8) {
            int tempX = 0;
            int tempY = 0;
            direction[tempCounter] = r.nextInt(2);
            int tempCouLen = wordArray[tempCounter].length();

            switch (direction[tempCounter]){
                case 0: //Diagonal
                    do{
                        tempX = r.nextInt(10);
                        tempY = r.nextInt(10);
                    } while (collisionCheck(isOccupied, tempY, tempX, direction[tempCounter], wordArray[tempCounter]));

                    for(int i = 0; i < tempCouLen; i++){
                         myTable[i+tempY][i+tempX] = wordArray[tempCounter].charAt(i);
                         isOccupied[i+tempY][i+tempX] = true;
                    }

                    break;
                case 1://Vertical
                    do {
                        tempX = r.nextInt(15);
                        tempY = r.nextInt(10);
                    } while (collisionCheck(isOccupied, tempY, tempX, direction[tempCounter], wordArray[tempCounter]));

                    for(int i = 0; i < wordArray[tempCounter].length(); i++){
                        myTable[tempY+i][tempX] = wordArray[tempCounter].charAt(i);
                        isOccupied[i+tempY][tempX] = true;
                    }

                    break;
                case 2://Horizontal
                    do{
                        tempX = r.nextInt(10);
                        tempY = r.nextInt(15);
                    } while (collisionCheck(isOccupied, tempY, tempX, direction[tempCounter], wordArray[tempCounter]));

                    for(int i = 0; i < wordArray[tempCounter].length(); i++){
                        myTable[tempY][tempX+i] = wordArray[tempCounter].charAt(i);
                        isOccupied[tempY][tempX+i] = true;
                    }
                    break;
            }

            tempCounter++;
        }
    }

    //Función que remueve las letras del tablero cuando el jugador encuentre alguna de las coordenadas de la palabra
    void removeFromTable(int[] coords, String word){
        for (int i = 0; i < 8; i++) {
            if (wordArray[i].equals(word)) {
                 switch(direction[i]){
                    case 0:
                        for (int j = 0; j < word.length(); j++) {
                            myTable[j+coords[1]][j+coords[0]] = ' ';
                            isOccupied[j+coords[1]][j+coords[0]] = true;
                        }
                        break;
                    case 1:
                        for (int j = 0; j < word.length(); j++) {
                            myTable[coords[1]+j][coords[0]] = ' ';  
                            isOccupied[coords[1]+j][coords[0]] = false;
                        }
                        break;
                    case 2:
                        for(int j = 0; j < word.length(); j++) {
                            myTable[coords[1]][coords[0]+j] = ' ';  
                            isOccupied[coords[1]][coords[0]+j] = false;
                        }
            }
        } //agregue ese for para que ponga vacio las palabras y unos parametros a la funcion para que "jale" supongo
    }
}

    //Función que retorna un booleano si las palabras y las coordenadas coinciden
    public boolean findWords(){
        boolean correct = false;
        System.out.println("Por favor introduzca la palabra que encontró");
        String wordFound = captureSingleWord();
        System.out.println("Por favor introduzca las coordenadas de la palabra");
        int[] coords = captureCoordinates();
        
        for (int i = 0; i < 8; i++) {
            if (wordArray[i].equals(wordFound)  && myTable[coords[0]][coords[1]] == wordFound.charAt(0)) {
                correct = true;
                System.out.println("Palabra encontrada");
                break;
            }
        }

        if (correct) {
            //removeFromTable(coords, wordFound); //le agrege parametros aqui de las cordenadas y la palabra
            wordsFound++;
            System.out.println("Tienes " + wordsFound + " palabras encontradas");
        } else {
            System.out.println("Respuesta incorrecta, intenta de nuevo");
        }

        return correct;
    }

    public Tablero(){
        myTable = fillTable(createTable());
        setWords();
    }
}
