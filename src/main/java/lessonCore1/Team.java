package lessonCore1;

public class Team {
    private String name;
    private Sportsman [] teamArr;
    private StringBuilder results = new StringBuilder("Всю полосу препятствий прошли:");

    public Team(String name, Sportsman part1, Sportsman part2, Sportsman part3, Sportsman part4) {
        this.name = name;
        this.teamArr = new Sportsman[]{part1, part2, part3, part4};
    }

    public void passCourse (Course course){
        for (Sportsman part: teamArr) {
            if (part.passCourse(course)){
                results.append( "\n -" + part.getName());
            }
        }
        System.out.println(name + " прошла полосу препятствий!");

    }
     public void showResults() {
         System.out.println(results);
     }

     public void info() {
         for (Sportsman part: teamArr) {
             System.out.println(part);
         }
     }

}
