/**
 * Java. Level1. Lesson3. homework 
 * @author  Gennady Niskovskikh
 * @version 28.11.17
*/

import java.util.*;
class Lesson3{
    public static void main(String[] args) {
        
        int Numb =0;
        int Exit =0;
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        while(true) {
            int Val = rnd.nextInt(4);
            System.out.println("Input number from 0 to 9:");
            Numb = sc.nextInt();

            for(int i=0;i<3; i++) {
                if(Numb==Val) {
                    System.out.println("You win!!");
                    break;
                }
                if(i==2) {
                    System.out.println("You luse!!"); 
                    break;
                }
                if(Numb<Val) System.out.println("More");
                if(Numb>Val) System.out.println("Less");

                System.out.println("Input again number from 0 to 9:");
                Numb = sc.nextInt();
            }
        System.out.println("Do you want again? 1-Yes / 0 - no");
        Exit = sc.nextInt();
        if(Exit==0) break;
        }
    }
}
