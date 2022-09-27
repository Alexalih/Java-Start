package lesson7;

public class Homework7 {
    public static void main(String[] args) {

        Cat[] cats = {
                new Cat("Васька"),
                new Cat("Пушок"),
                new Cat("Рыжик"),
                new Cat("Снежок"),
                new Cat("Барсик")};

        Plate plate = new Plate(20);

        StringBuilder fullness = new StringBuilder("Cытые коты:");
        StringBuilder hungry = new StringBuilder("Остались голодными коты:");


        for (Cat cat : cats) {
            cat.eat(plate);
            if (!cat.isFullness()) {
                hungry.append("\n -" + cat.getName());
            } else {
                fullness.append("\n -" + cat.getName());
            }
            System.out.println();
        }
        System.out.println(hungry.toString());
        System.out.println(fullness.toString());

    }
}
