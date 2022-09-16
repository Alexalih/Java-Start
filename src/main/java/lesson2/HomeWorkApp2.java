package lesson2;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        int a = 5;
        int b = 8;
        int year = 2025;
        String word = "Привет!";

        System.out.println(checkSum(a, b));

        checkNamber(a);

        System.out.println(numberIsPositive(a));

        seriesWord(word, a);

        System.out.println(isLeapYear(year));

    }

    private static boolean isLeapYear(int year) {

        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }

        if (year % 4 == 0) {
            return  true;
        }
        return  false;
    }

    private static void seriesWord(String word, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(word);
        }
    }

    private static boolean numberIsPositive(int a) {
        return (a >= 0);
    }

    private static void checkNamber(int a) {
        if (numberIsPositive(a)) {
            System.out.println("Число положительное");
        } else {
            System.out.println("Число отрицательное");
        }
    }

    private static boolean checkSum(int a, int b) {
        return (a + b > 10 && a + b < 20);
    }
}
