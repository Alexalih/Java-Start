package lessonCore1;

public class Course {
    private Track[] courseArr;

    public Course(Track track1, Track track2, Track track3) {
        this.courseArr = new Track[]{track1, track2, track3};
    }

    public Track[] getCourseArr() {
        return courseArr;
    }

    public void passCourse(Team team) {
        team.passCourse(this);
    }

}


