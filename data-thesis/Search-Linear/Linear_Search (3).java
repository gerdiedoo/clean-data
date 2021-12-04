/*
 Question:
     Search item 37 using linear search algorithm from the following list.
          A= [20, 35, 37, 40, 45, 50, 51, 67, 69, 75]
*/


package Searching_Algorithm;

import java.util.Scanner;

public class Linear_Search {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A[] = new int[10], Search;
        boolean flag = false;

        System.out.println("Enter Search number:");
        Search = scanner.nextInt();

        System.out.println("Enter 10 int number:");
        for (int i=0; i<A.length; i++){
            A[i] = scanner.nextInt();
        }

        for (int i=0; i<A.length; i++){
            if (A[i] == Search){
                flag = true;
            }
        }

        if (flag){
            System.out.println("Found");
        }else {
            System.out.println("Not Found");
        }
    }
}
