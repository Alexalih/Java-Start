package lesson6;

public class Cat extends Animal {

    public Cat (){
        super("Кошка",200,0 );
        Animal.addCountAnimals();
    }


    @Override
    public void swim(int distance) {
        System.out.println("Кошка отказывается заходить в воду и остается на берегу, потому что не умеет плавать");
    }
}
