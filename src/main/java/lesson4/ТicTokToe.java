package lesson4;

import java.util.Random;
import java.util.Scanner;

public class ТicTokToe {
    private static int size;
    private static final int MIN_SIZE = 3;
    private static final int MAX_SIZE = 9;
    private static int winSize = 3;

    private static final char DOT_EMPTY = '*';
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = '0';

    private static final String HEADER_SYMBOL = "#";
    private static final String MAP_SPACE = " ";

    private static char[][] map = new char[size][size];

    private static Scanner scan = new Scanner(System.in);
    private static Random random = new Random();

    private static int rowNumber;
    private static int columnNumber;

    private static int movesCount = 0;

    public static void main(String[] args) {
        startGame();
    }

    private static void startGame() {
        do {
            init();
            printMap();
            playGame();
        } while (isContinueGame());

    }

    private static void init() {
        System.out.println("Крестики-нолики. Начинаем игру!");
        size = getSizeFromUser();
        winSize = getWinSize();
        System.out.printf("Для победы  соберите %d 'X' в одну линию.%n", winSize);
        movesCount = 0;
        initMap();
    }

    private static void printMap() {
        printHeader();
        printBody();
    }

    private static void playGame() {
        while (true) {
            moveHuman();
            printMap();
            if (checkEnd(DOT_HUMAN)) {
                break;
            }

            moveAi();
            printMap();
            if (checkEnd(DOT_AI)) {
                break;
            }
        }
    }

    private static boolean checkEnd(char symbol) {
        if (checkWin(symbol)) {
            if (symbol == DOT_HUMAN) {
                System.out.println("Вы победили!");
            } else if (symbol == DOT_AI) {
                System.out.println("Победил компьютер!");
            }
            return true;
        }

        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }

        return false;
    }

    private static boolean checkWin(char symbol) {
        if (checkHorizontal(symbol)) {
            return true;
        }
        if (checkVertiсal(symbol)) {
            return true;
        }
        if (checkDiagonalLeft(symbol)) {
            return true;
        }
        if (checkDiagonalRight(symbol)) {
            return true;
        }

        return false;
    }

    private static boolean checkHorizontal(char symbol) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (map[rowNumber][i] == symbol) {
                counter++;
                if (counter >= winSize) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    private static boolean checkVertiсal(char symbol) {
        int counter = 0;
        for (int i = 0; i < size; i++) {
            if (map[i][columnNumber] == symbol) {
                counter++;
                if (counter >= winSize) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

    private static boolean checkDiagonalLeft(char symbol) {
        int counter = 0;
        int shift = Math.abs(rowNumber - columnNumber);
        if (rowNumber >= columnNumber) {
            for (int i = 0; i < size - shift; i++) {
                if (map[i + shift][i] == symbol) {
                    counter++;
                    if (counter >= winSize) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        if (rowNumber < columnNumber) {
            for (int i = 0; i < size - shift; i++) {
                if (map[i][i + shift] == symbol) {
                    counter++;
                    if (counter >= winSize) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        return false;
    }

    private static boolean checkDiagonalRight(char symbol) {
        int counter = 0;
        int lastIndex = size - 1;
        int shift = Math.abs(rowNumber - (lastIndex - columnNumber));
        if (rowNumber < lastIndex - columnNumber) {
            for (int i = 0; i < size - shift; i++) {
                if (map[i][lastIndex - shift - i] == symbol) {
                    counter++;
                    if (counter >= winSize) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        if (rowNumber >= lastIndex - columnNumber) {
            for (int i = 0; i < size - shift; i++) {
                if (map[shift + i][lastIndex - i] == symbol) {
                    counter++;
                    if (counter >= winSize) {
                        return true;
                    }
                } else {
                    counter = 0;
                }
            }
        }

        return false;
    }

    private static boolean checkDraw() {
        return (movesCount >= size * size);
    }

    private static void moveAi() {
        System.out.println("Ход компьютера...");
        do {
            rowNumber = random.nextInt(size);
            columnNumber = random.nextInt(size);
        } while (!isCellFree(rowNumber, columnNumber));

        map[rowNumber][columnNumber] = DOT_AI;
        movesCount++;
    }

    private static void moveHuman() {

        while (true) {
            System.out.println("Ваш ход!");
            System.out.println("Выберете номер строки.");
            rowNumber = getValidNumberFromUser(1, size) - 1;
            System.out.println("Выберете номер столбца.");
            columnNumber = getValidNumberFromUser(1, size) - 1;

            if (isCellFree(rowNumber, columnNumber)) {
                break;
            }
            System.out.printf("Ошибка! Клетка %d:%d занята!%n", rowNumber + 1, columnNumber + 1);
        }
        map[rowNumber][columnNumber] = DOT_HUMAN;
        movesCount++;
    }

    private static void printHeader() {
        System.out.print(HEADER_SYMBOL + MAP_SPACE);
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + MAP_SPACE);
        }
        System.out.println();
    }

    private static void printBody() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + 1 + MAP_SPACE);
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j] + MAP_SPACE);
            }
            System.out.println();
        }
    }

    private static int getWinSize() {
        if (size >= 3 && size <= 5) {
            return 3;
        }
        if (size > 5 && size <= 8) {
            return 4;
        }
        return 5;
    }

    private static int getSizeFromUser() {
        System.out.println("Зададим размер поля.");
        return getValidNumberFromUser(MIN_SIZE, MAX_SIZE);
    }

    private static int getValidNumberFromUser(int min, int max) {
        while (true) {
            System.out.printf("Введите число от %d до %d:", min, max);
            if (scan.hasNextInt()) {
                int n = scan.nextInt();
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.printf("ОЩИБКА! Число %s не входит в диапозон от  %s до %s!%n", n, min, max);
            } else {
                System.out.printf("ОШИБКА! Допускается ввод только целых чисел. %s не является целым числом!%n", scan.next());
            }
        }

    }

    private static void initMap() {
        map = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static boolean isCellFree(int rowNumber, int columnNumber) {
        return (map[rowNumber][columnNumber] == DOT_EMPTY);
    }

    private static boolean isContinueGame() {
        System.out.println("Сыграем еще раз? д/н");
        return switch (scan.next()) {
            case "y", "+", "д", "да", "l" -> true;
            default -> false;
        };
    }
}
