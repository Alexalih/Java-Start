package lesson6;

public class HomeWorkApp6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat();
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Cat cat2 = new Cat();

        dog1.run(400);
        dog1.swim(5);

        cat1.run(150);
        cat1.swim(14);

        System.out.println("Всего живтоных - "+ Animal.getCountAnimals());
    }
}
