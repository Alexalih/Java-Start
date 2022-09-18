package lesson6;

public abstract class Animal {
    private final String animalSpecies;
    private final int maxRunDistance;
    private final int maxSwimDistance;
    private static int countAnimals = 0;

    public Animal(String animalSpecies, int maxRunDistance, int maxSwimDistance) {
        this.animalSpecies = animalSpecies;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        countAnimals++;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }


    public void run(int distance) {
        if (distance > 0 && distance <= maxRunDistance) {
            System.out.printf("%s бежит %d м. %n", animalSpecies, distance);
        } else if (distance > 0) {
            System.out.printf("%s не может пробежать расстояние в %d м., максимум %d м. %n", animalSpecies, distance, maxRunDistance);
        } else {
            System.out.printf("%s стоит на месте. %n", animalSpecies);
        }
    }


    public void swim(int distance) {
        if (distance > 0 && distance <= maxSwimDistance) {
            System.out.printf("%s плывет %d м. %n", animalSpecies, distance);
        } else if (distance > 0) {
            System.out.printf("%s не может проплыть расстояние в %d м., максимум %d м. %n", animalSpecies, distance, maxSwimDistance);
        } else {
            System.out.printf("%s стоит на месте. %n", animalSpecies);
        }

    }


}
