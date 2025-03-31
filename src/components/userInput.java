
package components;
import java.util.Scanner;

public class userInput {
    private Scanner sc = new Scanner(System.in);
    protected String[] inputArray = new String[8];
    public String[] captureUserInput(){
        String tempWord = "";
        System.out.println("Por favor ingrese 8 palabras de 5 letras maximo");

        for (int i = 0; i < 8; i++) {
            tempWord = sc.nextLine();

            while(tempWord.length() > 5) {
                System.out.println("Por favor ingrese una palabra de 5 letras o menos");
                tempWord = sc.nextLine();
            }

            inputArray[i] = tempWord;
        }
        return inputArray;
    }
    
    public int[] captureCoordinates() {
        String userCoords;
        int[] coords = new int[2];
        String[] tempSeparator = new String[2];
        boolean exists = true;
        do{
            System.out.println("Por favor ingrese las coordenadas de la palabra separadas por un espacio");
            userCoords = sc.nextLine();
            tempSeparator = userCoords.split(" ");

            tempSeparator[0] = tempSeparator[0].toUpperCase();

            switch (tempSeparator[0]) {
            case "A":
                coords[0] = 0;
                coords[1] = 0;
                break;
            case "B":
                coords[0] = 0;
                coords[1] = 1;
                break;
            case "C":
                coords[0] = 0;
                coords[1] = 2;
                break;
            case "D":
                coords[0] = 0;
                coords[1] = 3;
                break;
            case "E":
                coords[0] = 0;
                coords[1] = 4;
                break;
            case "F":
                coords[0] = 0;
                coords[1] = 5;
                break;
            case "G":
                coords[0] = 0;
                coords[1] = 6;
                break;
            case "H":
                coords[0] = 0;
                coords[1] = 7;
                break;
            case "I":
                coords[0] = 0;
                coords[1] = 8;
                break;
            case "J":
                coords[0] = 0;
                coords[1] = 9;
                break;
            case "K":
                coords[0] = 0;
                coords[1] = 10;
                break;
            case "L":
                coords[0] = 0;
                coords[1] = 11;
                break;
            case "M":
                coords[0] = 0;
                coords[1] = 12;
                break;
            case "N":
                coords[0] = 0;
                coords[1] = 13;
                break;
            case "O":
                coords[0] = 0;
                coords[1] = 14;
                break;
            case "P":
                coords[0] = 0;
                coords[1] = 15;
                break;
            default:
                exists = false;
                System.out.println("Por favor introduzca un valor valido");
                break;
        }
            if(Integer.parseInt(tempSeparator[1]) > 16 || Integer.parseInt(tempSeparator[1]) <= 0){
                System.out.println("Por favor introduzca un valor valido");
                exists = false;
            } else {
                coords[0] = Integer.parseInt(tempSeparator[1]) - 1;
            }
        } while (!exists); 

        return coords;
    }


    public String captureSingleWord() {
        String word = sc.nextLine();
        return word;
    }
}


