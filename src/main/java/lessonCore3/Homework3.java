package lessonCore3;

public class Homework3 {
    public static void main(String[] args) {
        BoxFruit<Apple> appleBox = new BoxFruit<>();
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        appleBox.addBox(apple1);
        appleBox.addBox(apple2);

        BoxFruit<Orange> orangeBox = new BoxFruit<>();
        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        orangeBox.addBox(orange1);
        orangeBox.addBox(orange2);

        System.out.println(appleBox);
        System.out.println(orangeBox);
        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());
        System.out.println(orangeBox.compare(appleBox));

        BoxFruit<Apple> newAppleBox = new BoxFruit<>();

        appleBox.transferFruit(newAppleBox);
        System.out.println(newAppleBox);

        System.out.println(appleBox);
    }
}
