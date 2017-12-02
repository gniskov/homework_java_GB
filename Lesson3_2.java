/**
 * Java. Level1. Lesson3_2. homework 
 * @author  Gennady Niskovskikh
 * @version 30.11.17
*/

import java.io.*;
import java.util.*;
class Lesson3_2{
    public static void main(String[] args) {

        String TmpString;
        String[] OutArray = new String[100];
        char[] Input;
        char[] ArrayFile;
        int InputKey;
        int FileKey;

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        int randomNumb = rnd.nextInt(24);
        readToStrArray(OutArray);
        ArrayFile = OutArray[randomNumb].toCharArray();

        System.out.println("Hello, guess the word!");
        System.out.println("Input word:");

        while(true){
            TmpString = sc.next();
            Input = TmpString.toCharArray();

            InputKey = Input.length;
            FileKey = ArrayFile.length;

            if(TmpString.equals(OutArray[randomNumb])) {
                System.out.println("You Win!!"); 
                break;
            }

            for(int k=0; k<InputKey; k++) { 
                if(TmpString.charAt(k) != OutArray[randomNumb].charAt(k)) System.out.print("#");
                    if(TmpString.charAt(k) == OutArray[randomNumb].charAt(k)) System.out.print(TmpString.charAt(k));
            }

            if(InputKey<15) {
                for(int l=0;l<(15-InputKey);l++) System.out.print("#");
            }

            System.out.println("");
            System.out.println("No please again:");
        
        }
    }

//method fills an array from a file
    public static void readToStrArray(String[] out){
        int Spase=32;
        char Temp;
        int KeyNumb=0;
        char[] ch = new char[166];
        try {
            int b;
            FileReader file = new FileReader("words.txt");
            while ((b = file.read(ch)) != -1)
                Temp=(char)b;
                file.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int j=0; j<ch.length; j++){
            if(ch[j]!=Spase){ 
                if(out[KeyNumb]==null) out[KeyNumb] = String.valueOf(ch[j]);
                    else out[KeyNumb] += String.valueOf(ch[j]);
            }
            else KeyNumb++;
        }
    }
}
