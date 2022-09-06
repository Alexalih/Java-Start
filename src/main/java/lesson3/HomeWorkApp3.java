package lesson3;


import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp3 {
    public static void main(String[] args) {
        //задание №1
        System.out.println("Задание №1");
        int[] arr = new int[10];
        SetArrayValuesBin(arr);
        System.out.println(Arrays.toString(arr));
        ChangeArrayValues(arr);
        System.out.println(Arrays.toString(arr));

        // задание №2
        System.out.println("Задание №2");
        int[] arr2 = new int[100];
        SetArrayValuesAutoinc(arr2);
        System.out.println(Arrays.toString(arr2));

        //задание №3
        System.out.println("Задание №3");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));
        ChangeValueslessThan6(arr3);
        System.out.println(Arrays.toString(arr3));

        // задание №4
        System.out.println("Задание №4");
        int[][] arrSquare = new int[5][5];
        SetArrSquareValues(arrSquare);

        //задание №5
        System.out.println("Задание №5");
        int len = 5;
        int initialValue = 15;
        CreateNewArr(len, initialValue);

        //задание №6
        System.out.println("Задание №6");
        int[] arr6 = new int[10];
        SetArrayRandomValues(arr6);
        System.out.println(Arrays.toString(arr6));
        FindMinMaxValues(arr6);

        //задание №7
        System.out.println("Задание №7");
        int[] arr7 = new int[10];
        SetArrayRandomValues(arr7);
        System.out.println(Arrays.toString(arr7));
        System.out.println(CheckRightAndLefSum(arr7));


        //задание №8, без дополнительного массива не получилось придумать.
        System.out.println("Задание №8");
        int[] arr8 = {1, 2, 3, 4, 5};
        int n = -1;
        System.out.println(Arrays.toString(arr8));
        ShiftArrayElement(arr8, n);

    }

    private static boolean CheckRightAndLefSum(int[] arr) {
        int suml = arr[0];
        int sumr = 0;
        for (int i = 1; i < arr.length; i++) {
            sumr = sumr + arr[i];
        }

        for (int i = 1; i < arr.length; i++) {
            if (suml == sumr) {
                return true;
            }
            suml = suml + arr[i];
            sumr = sumr - arr[i];

        }
        return false;
    }

    private static void ShiftArrayElement(int[] arr8, int n) {
        int[] temparr = new int[arr8.length];
        int shift = n % arr8.length;
        int newi;
        for (int i = 0; i < arr8.length; i++) {
            newi = i + shift;
            if (newi >= arr8.length) {
                newi = newi - arr8.length;
            } else if (newi < 0) {
                newi = newi + arr8.length;
            }
            temparr[newi] = arr8[i];
        }
        arr8 = temparr;
        System.out.println(Arrays.toString(arr8));
    }

    private static void FindMinMaxValues(int[] arr6) {
        int minValues = arr6[0];
        int maxValues = arr6[0];

        // способ № 1
        for (int num : arr6) {
            if (num > maxValues) {
                maxValues = num;
            }
            if (num < minValues) {
                minValues = num;
            }
        }
        System.out.println("Максимальное элемент в массиве - " + maxValues);
        System.out.println("Минимальный элемент в массиве - " + minValues);

        // способ №2
        Arrays.sort(arr6);
        minValues = arr6[0];
        maxValues = arr6[arr6.length - 1];
        System.out.println("Максимальное элемент в массиве - " + maxValues);
        System.out.println("Минимальный элемент в массиве - " + minValues);
    }

    private static void SetArrayRandomValues(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int a = random.nextInt(20);
            arr[i] = a;
        }
    }

    private static void CreateNewArr(int len, int initialValue) {
        int[] arr5 = new int[len];
        for (int i = 0; i < len; i++) {
            arr5[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr5));
    }

    private static void SetArrSquareValues(int[][] arrSquare) {
        for (int i = 0; i < arrSquare.length; i++) {
            for (int j = 0; j < arrSquare[i].length; j++) {
                if (i == j) {
                    arrSquare[i][j] = 1;
                }
            }
            for (int j = 0; j < arrSquare[i].length; j++) {
                if (i == j) {
                    arrSquare[i][arrSquare[i].length - j - 1] = 1;
                }
            }

            System.out.println(Arrays.toString(arrSquare[i]));
        }
    }

    private static void ChangeValueslessThan6(int[] arr3) {

        for (int i = 0; i < arr3.length; i++) {
            if (arr3[i] < 6) {
                arr3[i] = arr3[i] * 2;
            }

        }
    }


    private static void SetArrayValuesAutoinc(int[] arr) {
        int a = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a++;
        }
    }

    private static void ChangeArrayValues(int[] arr) {
        for (int i = 0; i < 10; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
    }

    private static void SetArrayValuesBin(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int a = random.nextInt(2);
            arr[i] = a;
        }

    }
}
