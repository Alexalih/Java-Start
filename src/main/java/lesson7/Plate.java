package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void pintInfo() {
        System.out.printf("В миске %d корма%n", food);
    }

    public boolean decreaseFood(int eatenAmount) {
        if (food >= eatenAmount) {
            food -= eatenAmount;
            System.out.printf("Еда в миске уменьшилась на %d. ", eatenAmount);
            pintInfo();
            return true;
        } else {
            System.out.print("В миске не хватает еды! ");
            pintInfo();
            return false;
        }
    }

    public void putFood (int amount) {
        food += amount;
    }

}
