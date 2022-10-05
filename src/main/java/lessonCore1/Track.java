package lessonCore1;

public abstract class Track {

    private String name;
    private int length;

    public Track (String name, int length){
        this.name = name;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

}
