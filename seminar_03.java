/*
Домашнее задание к семинару Урок 3. Коллекции JAVA: Введение
1. Реализовать алгоритм сортировки слиянием
2. Пусть дан произвольный список целых чисел, удалить из него четные числа
3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

Студент: Костин Андрей Михайлович
Группа: номер группы не нашел, Факультет Разработчик - Программист, семинары по выходным
ТГ канал: Программирование | 6 | 3050 / 3426 | 21.09.2022

Формат сдачи: файл с расширением java или ссылка на гит с подписанными ФИ и номером группы.
*/
import java.util.Arrays;


public class seminar_03 {
    public static void main(String[] args){
        task01();
        task02();
        task03();
    }

    public static void task01() {
        System.out.println("Task 1: Merge Sort");
        int[] a1 = new int[] {1, 2, 68, 5, 10, 1, 3, 8, 4, 0};
        System.out.println("Unsorted array:");
        System.out.println(Arrays.toString(a1));
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(mergeSort(a1)));
    }

    public static void task02() {
        System.out.println("Task 2: Remove Even Elements");
        int[] a = new int[] {1, 2, 68, 5, 10, 1, 3, 8, 4, 0, 3, 8, 17};
        System.out.println("Original array:");
        System.out.println(Arrays.toString(a));
        System.out.println("Filtered array:");
        System.out.println(Arrays.toString(removeEven(a)));
    }

    public static void task03() {
        System.out.println("Task 3: Min Max Mean in Array ");
        int[] a = new int[] {1, 2, 68, 5, 10, 1, 3, 8, 4, 0, 3, 8, 17};
        int n = a.length;
        int min = 0;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] < min){
                min = a[i];
            }

            if (a[i] > max){
                max = a[i];
            }

            sum += a[i];
        }
        double mean = sum/n;
        System.out.println("Original array:");
        System.out.println(Arrays.toString(a));
        System.out.printf("Min: %d\n", min);
        System.out.printf("Max: %d\n", max);
        System.out.printf("Mean: %f\n", mean);
        
    }

    static int[] mergeSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int i = 0;
        int j = 0;
        int k = 0;
        int[] c = new int[n + m];

        while (i < n && j < m){
            if (a[i] <= b[j]){
                c[k] = a[i];
                k += 1;
                i += 1;
            } else {
                c[k] = b[j];
                k += 1;
                j += 1;
            }
        }

        while (i < n){
            c[k] = a[i];
            k += 1;
            i += 1;
        }
        
        while (j < m){
            c[k] = b[j];
            k += 1;
            j += 1;
        }
       
        return c;
    }

    static int[] mergeSort(int[] a) {
        if (a.length < 2){
            return a;
        }
            int middlePosition = Math.round(a.length / 2);
            int[] leftPart = new int[middlePosition];
            int[] rightPart = new int[a.length - middlePosition];
            int[] sortedLeftPart = new int[middlePosition];
            int[] sortedRightPart = new int[a.length - middlePosition];
            
            for (int i = 0; i < middlePosition; i++) {
                leftPart[i] = a[i];
            }

            for (int i = middlePosition; i < a.length; i++) {
                rightPart[i - middlePosition] = a[i];
            }

            sortedLeftPart = mergeSort(leftPart);
            sortedRightPart = mergeSort(rightPart);

            return mergeSortedArrays(sortedLeftPart, sortedRightPart);
        }

        static int countEvenElements(int[] a){
            int count = 0;
            for(int i = 0; i < a.length; i++){
                if (a[i] % 2 == 0) {
                    count++;
                }
            }
            return count;
        }

        static int[] removeEven(int[] a){
            int[] filtered = new int[countEvenElements(a)];
            int k = 0;
            for(int i = 0; i < a.length; i++){
                if (a[i] % 2 != 0) {
                    filtered[k] = a[i];
                    k++;
                }
            }
            return filtered;
        }
}  
        
        
    

