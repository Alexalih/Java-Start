package lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        int year = 2024;
        String word = "Привет!";

        System.out.println(checkTotal(a, b));

        checkNamber(a);

        System.out.println(numberIsPositive(a));

        seriesWord(word, a);

        System.out.println(isLeapYear(year));

    }

    private static boolean isLeapYear(int year) {
        if (year % 4 != 0 || year % 100 == 0 && year % 400 != 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void seriesWord(String word, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(word);
        }
    }

    private static boolean numberIsPositive(int a) {
        if (a < 0) {
            return false;
        } else {
            return true;
        }
    }

    private static void checkNamber(int a) {
        if (a >= 0) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    private static boolean checkTotal(int a, int b) {
        int total = a + b;
        if (total >= 10 && total <= 20) {
            return true;
        } else {
            return false;
        }
    }
}
