package lessonCore1;

public class main {
    public static void main(String[] args) {

        Team team = new Team("Суперкомманда", new Sportsman("Сергей"), new Sportsman("Адександр"), new Sportsman("Андрей"), new Sportsman("Матвей"));
        Course course = new Course(new Pool("Бассейн", 30), new RunningTrack("Стадион", 200), new CycleTrack("Велотрек", 400));

        team.info();
        course.passCourse(team);
        team.showResults();





    }
}

