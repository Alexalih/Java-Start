package lessonCore2;

import java.util.Random;

public class HomeWorkCore2 {
    public static void main(String[] args) {

        String[][] arr = new String[4][4];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                arr[i][j] = "1";
            }
        }
//        arr[2][3] ="h";

        try {
            System.out.println(convertArr(arr));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int convertArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {

        if (arr.length != 4 || arr[0].length != 4) {
            throw new MyArraySizeException("Массив не того размера");
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Элемент массива [%s][%s] %s не число", i, j, arr[i][j]));
                }
            }
        }
        return sum;
    }

}
