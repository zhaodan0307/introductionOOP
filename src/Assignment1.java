//tast1太简单了，我就不写了，你自己做把。

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Assignment1 {
    public static void task1(){
        System.out.println("how many element");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        System.out.println("have create a array size of "+ size);
        Object[] arr = new Object[size];
        String input;
        for(int i = 0 ;i<arr.length; i++){

            System.out.println("please input the "+i +" element");
            input=in.next();
            if(0==Integer.valueOf(input) || 1==Integer.valueOf(input)){
                arr[i]=Boolean.valueOf(input);

                System.out.println(arr[i].getClass().getSimpleName());
            }
            if((Integer.valueOf(input)>=-128&&Integer.valueOf(input)<=127)&&(Integer.valueOf(input)!=0)&&(Integer.valueOf(input)!=1) ){
                arr[i]=Byte.valueOf(input);
                System.out.println(arr[i].getClass().getSimpleName());
            }
            if((Integer.valueOf(input)<-128&&Integer.valueOf(input)>=-32768)||(Integer.valueOf(input)<=32767&&Integer.valueOf(input)>127)){
                arr[i]=Short.valueOf(input);
                System.out.println(arr[i].getClass().getSimpleName());
            }
            if((Integer.valueOf(input)<-32768)||(Integer.valueOf(input)>32767)){
                arr[i]=Integer.valueOf(input);
                System.out.println(arr[i].getClass().getSimpleName());
            }
        }

        for(int i =0;i<size;i++){
            System.out.println(arr[i]);
        }

    }

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
        task1();
        task2();
    }


}

