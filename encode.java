import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// When decrypting, sometimes the last index is a space,
//  so entering a space at the end of the code will ensure proper decryption

public class encode{
  private static ArrayList<String> letters = new ArrayList<>(Arrays.asList(
  "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
  "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
  "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
  "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", " ", " ", " ", " ", " "));

  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    while(true){
      System.out.println("Type \"E\" for encrypt or \"D\" for decrypt: ");
      String codeType = input.nextLine();
      if(codeType.equals("E")){
        System.out.println("Enter message: ");
        String message = input.nextLine();

        String encryption = encrypt(message);
        System.out.println("\n" + encryption);
        break;

      }else if(codeType.equals("D")){
        System.out.println("Enter code: ");
        String message = input.nextLine();

        String decryption = decrypt(message);

        System.out.println("\n" + decryption);
        break;
      }
    }
  }



  public static String encrypt(String message){
    String code = "";

    for(int i = 0; i < message.length(); i++){
      String letter = message.substring(i, i + 1);
      code += letter;

      int amount = Math.abs(letter.compareTo("a"));
      for(int j = 0; j < amount; j++){
        code += randomizer();
      }
    }
    return code;
  }



  public static String decrypt(String answer){
    String message = "";
    String code = answer;

    for(int i = 0; i < code.length(); i++){
      String letter = code.substring(i, i + 1);
      message += letter;

      int amount = Math.abs(letter.compareTo("a"));
      code = code.substring(0, i + 1) + code.substring(i + 1 + amount);
    }
    return message;
  }




  public static String randomizer(){
    int rand = ((int)(Math.random() * 56) + 1);
    return letters.get(rand);
  }
}
