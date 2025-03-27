package components;
import java.util.Random;

public class Tablero extends userInput{
    private Random r = new Random();
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

    private boolean collisionCheck(boolean[][] boolMatrix, int i, int j) {
        boolean collision = false;

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
        while (tempCounter < 3) {
            int tempX = 0;
            int tempY = 0;
            int tempDirection = r.nextInt(2);
            int tempCouLen = wordArray[tempCounter].length();

            switch (tempDirection){
                case 0: //Diagonal
                    tempX = r.nextInt(10);
                    tempY = r.nextInt(10);
                    for(int i = 0; i < tempCouLen; i++){
                         myTable[i+tempY][i+tempX] = wordArray[tempCounter].charAt(i);
                         isOccupied[i+tempY][i+tempX] = true;
                    }

                    break;
                case 1://Vertical
                    tempX = r.nextInt(15);
                    tempY = r.nextInt(10);
                    for(int i = 0; i < wordArray[tempCounter].length(); i++){
                        myTable[tempY+i][tempX] = wordArray[tempCounter].charAt(i);
                        isOccupied[i+tempY][tempX] = true;
                    }

                    break;
                case 2://Horizontal
                    tempX = r.nextInt(10);
                    tempY = r.nextInt(15);

                    for(int i = 0; i < wordArray[tempCounter].length(); i++){
                        myTable[tempY][tempX+i] = wordArray[tempCounter].charAt(i);
                        isOccupied[tempY][tempX+i] = true;
                    }
                    break;
            }

            tempCounter++;
        }
    }

    public Tablero(){
        myTable = fillTable(createTable());
        setWords();
    }
}
