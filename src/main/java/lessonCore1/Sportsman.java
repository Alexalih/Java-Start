package lessonCore1;

import java.util.Random;

public class Sportsman {
    private String name;
    private int runDistance, swimDistance, bicycleDistance;
    private double runSpeed, swimSpeed, bicycleSpeed;
    private boolean passedPool, passedRunTrack, passedRideTrack;


    public Sportsman(String name) {
        this.name = name;
        this.runDistance = new Random().nextInt(190, 400);
        this.swimDistance = new Random().nextInt(30, 40);
        this.bicycleDistance = new Random().nextInt(390, 500);
        this.runSpeed = new Random().nextInt(5, 15);
        this.swimSpeed = new Random().nextInt(2, 10);
        this.bicycleSpeed = new Random().nextInt(20, 60);
    }


    public boolean passCourse(Course course) {
        for (Track part : course.getCourseArr()) {
            if (!passTrack(part)) {
                return false;
            }
        }
        return true;
    }


    public boolean passTrack(Track track) {
        if (track instanceof Pool) {
            Pool pool = (Pool) track;
            if (swimDistance >= pool.getLength()) {
                passedPool = true;
                double time = pool.getLength() / swimSpeed;
                System.out.printf("%s проплыл %s за %.2f минут.%n", name, pool.getName(), time);
            } else {
                passedPool = false;
                System.out.println(name + " не проплыл " + pool.getName());
            }

            return passedPool;

        } else if (track instanceof RunningTrack) {
            RunningTrack runningTrack = (RunningTrack) track;
            if (runDistance >= runningTrack.getLength()) {
                passedRunTrack = true;
                double time = runningTrack.getLength() / runSpeed;
                System.out.printf("%s пробежал %s за %.2f минут.%n", name, runningTrack.getName(), time);
            } else {
                passedRunTrack = false;
                System.out.println(name + " не пробежал " + runningTrack.getName());
            }

            return passedRunTrack;


        } else if (track instanceof CycleTrack) {
            CycleTrack cycleTrack = (CycleTrack) track;
            if (bicycleDistance >= cycleTrack.getLength()) {
                passedRideTrack = true;
                double time = cycleTrack.getLength() / bicycleSpeed;
                System.out.printf("%s проехал %s за %.2f минут.%n", name, cycleTrack.getName(), time);
            } else {
                passedRideTrack = false;
                System.out.println(name + " не проехал " + cycleTrack.getName());
            }

            return passedRideTrack;

        }
        return false;
    }


    @Override
    public String toString() {
        return " Sportsmen { " +
                "name=' " + name + '\'' +
                ", runDistance=' " + runDistance + '\'' +
                ", swimDistance=' " + swimDistance + '\'' +
                ", bicycleDistance=' " + bicycleDistance + '\'' +
                ", runSpeed=' " + runSpeed + '\'' +
                ", swimSpeed=' " + swimSpeed + '\'' +
                ", bicycleSpeed=' " + bicycleSpeed +
                '}';
    }

    public String getName() {
        return name;
    }
}