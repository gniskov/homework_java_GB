/**
 * Java. Level1. Lesson4. homework 
 * @author  Gennady Niskovskikh
 * @version 05.12.17
 * @link https://github.com/gniskov/homework_java_GB
*/

import java.io.*;
import java.util.*;

class Lesson4{
    final char DOT_X = 'x';
    final char DOT_O = 'o';
    final char DOT_EMPTY= '.';
    final int SIZE=5;
    char[][] map = new char[SIZE][SIZE];
    Random rnd = new Random();
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new Lesson4_1();
    }

    Lesson4(){
        System.out.println("Are you ready?:");
        initMapPoints(map);
        outputMap(map);
        while(true) {
            goHuman(map);
            outputMap(map);
                if(winnerIs(map)==0) {System.out.println("Com is win"); break;}
                if(winnerIs(map)==1) {System.out.println("Hum is win"); break;}
                if(mapIsFull(map)) {System.out.println("full"); break;}

            goComputer(map);
                if(winnerIs(map)==0) { System.out.println("Com is win"); break;}
                if(winnerIs(map)==1) { System.out.println("Hum is win"); break;}
            System.out.println("");
            outputMap(map);
            if(mapIsFull(map)) {System.out.println("full"); break;}
        }
    }

    void initMapPoints(char array [][]){
        for (int i=0; i<SIZE;i++)
            for(int j=0;j<SIZE;j++)
                map[i][j]=DOT_EMPTY;
    }

    void outputMap(char array[][]) {
        for(int k=0;k<SIZE;k++) {
            System.out.println("");
                for(int l=0;l<SIZE;l++)
                    System.out.print(map[k][l]+" ");
        }
        System.out.println("");
    }

    boolean correctValue(int x, int y, char array[][]) {
        if((x>0&&x<=SIZE)&&(y>0&&x<=SIZE)&&(array[y-1][x-1]==DOT_EMPTY)) 
            return false;
        else return true;
    }

    void goHuman(char array[][]) {
        int x=0;
        int y=0;
        System.out.println("Please you turn!");
        do {
            System.out.println("Input x and y [0-5]:");
            x = sc.nextInt();
            y = sc.nextInt();
            if(x>5&&y>5||x<1&&y<1) continue; 
        } while (correctValue(x,y,map));
        array[y-1][x-1]=DOT_X;
    }

    void goComputer(char array[][]) {
        while (true){
            int x = rnd.nextInt(SIZE+1);
            int y = rnd.nextInt(SIZE+1);
            if((correctValue(x,y,array)==false)&&(array[y-1][x-1]!=DOT_X)&&(array[y-1][x-1]!=DOT_O)) {
                array[y-1][x-1]=DOT_O; 
                break;
            }
        }
    }

    boolean mapIsFull(char array[][]) {
        int key=0;
        for(int i=0;i<SIZE;i++) 
            for(int j=0;j<SIZE;j++)
                if(array[i][j]==DOT_EMPTY) return false; 
        return true;
    }

    //return 0- winner is computer / 1 - winner is Human / 2 - no winner
    int winnerIs(char array[][]) {
        int key_x_hor=0;
        int key_o_hor=0;
        int key_x_ver=0;
        int key_o_ver=0;
        int key_x_diag=0;
        int key_x_diag1=0;
        int key_o_diag=0;
        int key_o_diag1=0;
        int key_x_diag2=0;
        int key_o_diag2=0;
        int key_x_diag3=0;
        int key_o_diag3=0;

        for(int i=0,k=SIZE-1;i<SIZE;i++,k--) {
            if(array[i][i]==DOT_X) key_x_diag++; 
            if((array[i][i]==DOT_X)&&(key_x_diag>=4)) return 1;
            if((array[i][i]==DOT_EMPTY)&&(key_x_diag!=4)) key_x_diag=0;
            
            if(i<4){
                if(array[i+1][i]==DOT_X) key_x_diag2++; 
                if((array[i+1][i]==DOT_X)&&(key_x_diag2==4)) return 1;

                if(array[i][i+1]==DOT_X) key_x_diag3++; 
                if((array[i][i+1]==DOT_X)&&(key_x_diag3==4)) return 1;
                
                if(array[i+1][i]==DOT_O) key_o_diag2++; 
                if((array[i+1][i]==DOT_O)&&(key_o_diag2==4)) return 0;

                if(array[i][i+1]==DOT_O) key_o_diag3++; 
                if((array[i][i+1]==DOT_O)&&(key_o_diag3==4)) return 0;
            }

            if(array[i][i]==DOT_O) key_o_diag++;
            if((array[i][i]==DOT_O)&&(key_o_diag>=4)) return 0;
            if((array[i][i]==DOT_EMPTY)&&(key_o_diag!=4)) key_o_diag=0;
            
            if(array[i][k]==DOT_X) key_x_diag1++; 
            if((array[i][k]==DOT_X)&&(key_x_diag1>=4)) return 1;
            if((array[i][k]==DOT_EMPTY)&&(key_x_diag1!=4)) key_x_diag1=0;

            if(array[i][k]==DOT_O) key_o_diag1++;
            if((array[i][k]==DOT_O)&&(key_o_diag1>=4)) return 0;
            if((array[i][k]==DOT_EMPTY)&&(key_o_diag1!=4)) key_o_diag1=0;

            key_x_hor=0; key_o_hor=0; key_x_ver=0; key_o_ver=0;

            for(int j=0;j<SIZE;j++) {
                if(array[i][j]==DOT_X) key_x_hor++;
                if((array[i][j]==DOT_X)&&(key_x_hor>=4)) return 1;
                if((array[i][j]==DOT_EMPTY)&&(key_x_hor!=4)) key_x_hor=0;

                if(array[j][i]==DOT_X) key_x_ver++;
                if((array[j][i]==DOT_X)&&(key_x_ver>=4)) return 1;
                if((array[j][i]==DOT_EMPTY)&&(key_x_ver!=4)) key_x_ver=0;

                if(array[i][j]==DOT_O) key_o_hor++;
                if((array[i][j]==DOT_O)&&(key_o_hor>=4)) return 0;
                if((array[i][j]==DOT_EMPTY)&&(key_o_hor!=4)) key_o_hor=0;

                if(array[j][i]==DOT_O) key_o_ver++;
                if((array[j][i]==DOT_O)&&(key_o_ver>=4)) return 0;
                if((array[j][i]==DOT_EMPTY)&&(key_o_ver!=4)) key_o_ver=0;
            }
        }
        return 2;
    }
}
