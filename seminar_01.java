/**
* to run seminar_01.java - type java seminar_01.java
*/
import java.util.Scanner;


public class seminar_01{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        task01(reader);
        reader.close();

    }

    public static void task01(Scanner reader) {
        System.out.println("Task 1a: triangle number");
        int n = readIntFromTerminal("Please enter integer number N: ", reader);
        System.out.println(getTriangleNumber(n));
        System.out.println("Task 1b: factorial");
        int n1 = readIntFromTerminal("Please enter integer number N: ", reader);
        System.out.println(getFactorial(n1));

    }

    static int readIntFromTerminal(String message, Scanner reader) {
        System.out.println(message);
        String strNumber = reader.nextLine(); 
        int Number = Integer.parseInt(strNumber);
        return Number;
      }

    static int getTriangleNumber(int n){
        if(n == 1){
            return 1;
        } else {
            return getTriangleNumber(n - 1) + n;
        }
      }

    static int getFactorial(int n){
        if(n == 0 || n == 1){
            return 1;
        } else {
            return n * getFactorial(n - 1);
        }
      }
 }