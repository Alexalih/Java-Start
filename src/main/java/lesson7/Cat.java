package lesson7;

import java.util.Random;

public class Cat {
    private String name;
    private boolean fullness;

    public Cat(String name) {
        this.name = name;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (!isFullness()) {
            int catEatenAmount = new Random().nextInt(3, 10);
            System.out.printf("Кот %s хочет съесть %d корма. %n", name, catEatenAmount);
            if (plate.decreaseFood(catEatenAmount)) {
                fullness = true;
                System.out.printf("Кот %s сытый. %n", name, catEatenAmount);
            } else {
                System.out.printf("Кот %s остался голодный. %n", name, catEatenAmount);
            }


        } else {
            System.out.printf("Кот %s сытый", name);
            plate.pintInfo();
        }
    }

    public boolean isFullness() {
        return fullness;
    }

    public void setFullness(boolean fullness) {
        this.fullness = fullness;
    }

    public String getName() {
        return name;
    }
}
