package lessonCore3;

import java.util.ArrayList;

public class BoxFruit<T extends Fruit> {

    private ArrayList<T> box = new ArrayList<>();

    public BoxFruit(){
    }

    public void addBox (T fruit){
        box.add(fruit);
    }

    public float getWeight() {

//        float weight = 0;
//        for (T fruit : box) {
//            weight += fruit.getWeight();
//        }
        return box.size() * box.get(0).getWeight();
    }

    public boolean compare(BoxFruit boxFruit){
       return getWeight() == boxFruit.getWeight();
    }

    public void transferFruit (BoxFruit<T> boxFruit){
       boxFruit.getBox().addAll(box);
       box.clear();

    }

    @Override
    public String toString() {
        return "BoxFruit{" +
                "box=" + box +
                '}';
    }

    public ArrayList<T> getBox(){
        return box;
    }

    public void setBox(ArrayList<T> box) {
        this.box = box;
    }
}
