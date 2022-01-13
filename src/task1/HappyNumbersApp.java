package task1;

import java.util.ArrayList;
import java.util.Scanner;

/*
* the program finds happy numbers in the list of positive integers
*
*  A number is called happy if it leads to 1 after a sequence of
*  steps wherein each step number is replaced by the sum of squares of its digit that is
*  if we start with Happy Number and keep replacing it with digits square sum, we reach 1.
*
* A number will not be a Happy Number when it makes a loop
*  in its sequence that is it touches a number in sequence which already been touched
 * */

public class HappyNumbersApp {

    public static Scanner s = new Scanner(System.in);
    public static ArrayList listOfNumbers = new ArrayList();
    public static ArrayList happyNumbers = new ArrayList();
    public static ArrayList numbersList;


    //a function that loads numbers into a list
    static ArrayList loadListOfNumbers(int sizeOfList){
        for(int i=0;i<sizeOfList;i++){
            int number=s.nextInt();
            if(number<0) {
                System.out.println("You entered a negative integer!! ");
                System.exit(0);
            }
            listOfNumbers.add(number);
        }
    return listOfNumbers;
    }

    // Utility method to return sum of square of digit of n
    static int squareSum(int n){
        int sum=0;
        while(n>0){
            int digit=n%10;
            sum=sum+ digit*digit;
            n=n/10;

        }
        return sum;
    }

    //  method return true if n is Happy number or list of unhappy numbers
    static boolean isHappy(int n){
        numbersList = new ArrayList();
        numbersList.add(n);

        while(true){
            if(n==1)
                return true;
            n= squareSum(n);

            if(numbersList.contains(n)) {
                numbersList.add(n);
                System.out.println(numbersList.toString());
                return false;

            }
            numbersList.add(n);

        }
    }

    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          System.out.println("enter size of list");
          int listSize=sc.nextInt();
          System.out.println("enter elements of list");

          ArrayList loadedListOfNumbers= loadListOfNumbers(listSize);

          for(int i =0;i<loadedListOfNumbers.size();i++){
              int numbreFromList= (int) loadedListOfNumbers.get(i);

              if(isHappy(numbreFromList))
                  happyNumbers.add(numbreFromList);
              else continue;

          }
        System.out.println("Happy numbers are:" + happyNumbers.toString());

    }
}
