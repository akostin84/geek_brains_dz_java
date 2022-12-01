/*
Семинар 1 Java: знакомство и как пользоваться базовым API

1) Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

2) Вывести все простые числа от 1 до 1000

3) Реализовать простой калькулятор

4) Задано уравнение вида q + w = e. При q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса, например 
2? + ?5 = 69. Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, 
что его нет.

Студент: Костин Андрей Михайлович
Группа: номер группы не нашел, Факультет Разработчик - Программист, семинары по выходным
ТГ канал: Программирование | 6 | 3050 / 3426 | 21.09.2022
*/
import java.util.Scanner;


public class seminar_01{
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        task01(reader);
        task02();
        task03(reader);
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

    public static void task02() {
        System.out.println("Task 2: Print prime numbers less than 1000");
        for(int i = 1; i <= 1000; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
    }

    public static void task03(Scanner reader) {
        System.out.println("Task 3: Console calculator");
        int n1 = readIntFromTerminal("Please enter integer number N: ", reader);
        String operation = getOperation("Please enter operation: ", reader);
        int n2 = readIntFromTerminal("Please enter integer number N: ", reader);
        int result = 0;
        switch(operation){
            case "+":
                result = n1 + n2;
                break;
            case "-":
                result = n1 - n2;
                break;
            case "*":
                result = n1 * n2;
                break;
            case "/":
                result = n1 / n2;
                break;
            default:
                System.out.println("Unrecognizable operation");
                break;
        }
        System.out.println(operation);
        System.out.println(result);
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

    static boolean isPrime(int n){
        if(n <= 1){
            return false;
        }
        for(int i = 2; i <= n/2; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    static String getOperation(String message, Scanner reader){
        System.out.println(message);
        String operation = reader.nextLine();
        return operation;
    }
}
