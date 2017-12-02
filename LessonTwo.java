/**
 * Java. Level1. Lesson2. homework 
 * @author  Gennady Niskovskikh
 * @version 25.11.17
*/
import java.util.Arrays;
class LessonTwo{
    public static void main (String[] arg) {

        workWithArray();
        int[] expl = {0,1,2,3,4,5,6,7,8,9};
        int[] expl2 = {0,1,2,3,4,5,6,7,8,9}; 

        shiftdatAr(expl, -5);
        shiftdatAr(expl2, 2);

        int[] arrTest1 = {0,1,1,1,2,2,2,1,2,3,4,5,6,6,6,6};
        int[] arrTest2 = {0,1,1,2,2,2,1,2,3,4,5,6,6,6,6};

        System.out.println(checkBalance(arrTest1)); 
        System.out.println(checkBalance(arrTest2));
    }
    
    public static void workWithArray() {

        //The firs task:
        int[] arrBin = {1,1,1,0,0,1,0,1,1,0,0,1,0};
        System.out.println("It was:   " + Arrays.toString(arrBin)); 
        for (int i=0; i<arrBin.length;i++){
            if(arrBin[i]==1) 
                arrBin[i]=0;
            else arrBin[i]=1;
        }
        System.out.println("became: " + Arrays.toString(arrBin));
    
        //The second task:  
        int[] arr2 = new int[8];
        for(int i=0, j=0; i<arr2.length; i++, j += 3){
        arr2[i]=j; 
        }
        System.out.println("The result of the second job: " + Arrays.toString(arr2));
    
        //The third task:
    
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("It was:   " + Arrays.toString(arr3));
    
        for (int i=0; i<arr3.length; i++)
            if(arr3[i]<6) arr3[i] *=2;
        System.out.println("became: " + Arrays.toString(arr3));
    
        //The fourth task:
        int[][] arr4 = new int[10][10];
        for(int i=0, j=0; i< arr4.length; i++, j++)
        arr4[i][j] = 1;

        //The output in the console:
        System.out.println("Output fourth task: ");
        for(int k=0; k<arr4.length; k++){
            for(int l=0; l<arr4.length; l++)
                System.out.print(arr4[k][l] + " ");
                System.out.println();
        }
    
        int[] arr5 = {8, 12, 3, 2, 11, -4, 0, 2, 4, 2, 15, -8};
        int maxVal=arr5[0];
        int minVal=arr5[0];
    
        for (int i=0; i<arr5.length; i++) {
            if(arr5[i]>maxVal) maxVal=arr5[i];
            if(arr5[i]<minVal) minVal=arr5[i];
        }
    
        System.out.println("Max value is: " + maxVal);
        System.out.println("Min value is: " + minVal);
    }
    
    public static void shiftdatAr(int[] arr6, int n) {
        int cont = 0;
        int lng = arr6.length;
        int k=lng-1;
        if (n > 0){
            for (int i=0; i<n; i++) 
                cont=arr6[lng-1];
            
            for (int j=0; j<lng-1; j++) {
                arr6[k]=arr6[k-1];
                k--;
            }
            arr6[0]=cont;
            k=lng-1;
        }

        if(n < 0){
            n *= -1;
            for (int i=0; i<n; i++) {
                cont=arr6[0];
            
            for (int j=0; j<(arr6.length-1); j++)
                arr6[j]=arr6[j+1];
         
            arr6[lng-1]=cont;
            k=lng;
            }
        }
        
        System.out.println(Arrays.toString(arr6));
    }
    
    //The seven task:
    public static boolean checkBalance(int[] arr7) {
        int tmp=0;
        int tmp1=0;
        int l=1;
        int f=0;
        int leng=0;
        int lengArray=arr7.length;
        for (int i=1; i<lengArray; i++) {
            for(int j=0; j<l; j++)
                tmp = tmp + arr7[j];

            for(int k=lengArray-1; k>f; k--)
                tmp1 = tmp1 + arr7[k];

            if(tmp==tmp1) return true;
            
            l++;
            f++;
            tmp=0;
            tmp1=0;
        }
        return false;
    }
}