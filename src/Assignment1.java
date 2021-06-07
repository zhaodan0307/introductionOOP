//tast1太简单了，我就不写了，你自己做把。

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Assignment1 {

    public static void task2(){
        //1)
        int[][] multiArray = new int[10][10];
        for (int i = 0;i<10;i++){
            for(int j = 0;j<10;j++){
                multiArray[i][j]=(i+1)*(j+1);
                System.out.print(multiArray[i][j]+" ");
            }
            System.out.println();
        }

        //2)

        try{
            System.out.println("How many question would you like to answer?");
            Scanner in = new Scanner(System.in);
            int numberOfQuestion = in.nextInt();

            if(numberOfQuestion<=0){
                throw new IllegalArgumentException();
            }

            Random rand = new Random();
            int row;
            int col;
            int answer;
            int numberOfCorrect=0;

            for (int i = 0 ;i<numberOfQuestion; i++){
                row = rand.nextInt(10);
                col = rand.nextInt(10);
                System.out.println("What is "+(row+1)+" x "+(col+1));
                answer=in.nextInt();

                if(answer==multiArray[row][col]){
                    System.out.println("Answer is correct");
                    numberOfCorrect++;
                }else{
                    System.out.println("The correct answer's "+multiArray[row][col]);
                }
            }

            //summary

            System.out.printf("Your answered %s correct out of %s number of questions %nThat's percentage of %s",
                    numberOfCorrect,numberOfQuestion,(numberOfCorrect*100/numberOfQuestion));



        }catch (InputMismatchException e){
            System.err.println("Please input number");
        }catch (IllegalArgumentException e){
            System.err.println("the time of playing must over zero");

        }

    }

    public static void main(String[] args) {
        task2();
    }


}

