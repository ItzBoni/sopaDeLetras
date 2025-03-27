package components;
import java.util.Scanner;

public class userInput {
    private Scanner sc = new Scanner(System.in);
    protected String[] inputArray = new String[3];
    public String[] captureUserInput(){
        String tempWord = "";
        System.out.println("Por favor ingrese 8 palabras de 5 letras maximo");

        for (int i = 0; i < 3; i++) {
            tempWord = sc.nextLine();

            /*while(tempSeparator[0].length() > 6 || tempSeparator.length > 2 || tempSeparator[1] != "V" || tempSeparator[1] != "D" || tempSeparator[1] != "H"){
                if(tempSeparator[0].length() > 6){
                    System.out.println("Entrada invalida, 5 letras o menos");
                } else if (tempSeparator.length > 2) {
                    System.out.println("Por favor nomás ingresar palabra y dirección (una sola letra)");
                } else if (tempSeparator[1].length() > 1) {
                    System.out.println("Por favor haga que la direccion sea una sola letra y sea valida.");
                }

                switch (tempSeparator[1]) {
                    case "D":
                        break;
                    case "V":
                        break;
                    case "H":
                        break;
                    default:
                        System.out.println("Ingrese una letra valida");
                        break;
                }
                tempWord = sc.nextLine();
                tempSeparator = tempWord.split(" ");
            }*/
            
            inputArray[i] = tempWord;
        }
        return inputArray;
    }
}
