package lessonCore9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Homework {
    public static void main(String[] args) {
        Course course1 =new Course("Ядерная физика");
        Course course2 =new Course("Химия");
        Course course3 =new Course("Военная подготовка");
        Course course4 =new Course("Санкциология");
        Course course5 =new Course("Философия");
        Course course6 =new Course("Русский язык");
        Course course7 =new Course("География");
        Course course8 =new Course("Драконоведение");
        Course course9 =new Course("Ориентирование на местности");
        Course course10 =new Course("ОБЖ");
        Course course11 =new Course("Кумысоведение");
        Course course12 =new Course("Квасология");


        List<Student> students = new ArrayList<>();
        students.add( new Student("Ким Чен Ын", Arrays.asList(
              course1, course2,course3)));
        students.add( new Student("Джо Байден", Arrays.asList(
                course4, course5)));
        students.add( new Student("Игорь Шмыгарь", Arrays.asList(
                course1, course5, course2, course6)));
        students.add( new Student("Акакий Шмакодявкин оглы", Arrays.asList(
                course11, course12, course6)));
        students.add( new Student("Джон Сноу", Arrays.asList(
               course7, course8, course9, course10, course3)));


        System.out.println(students.stream()
                .map(s -> s.getCourseList())
                .flatMap(c -> c.stream())
                .map(k ->k.getName())
                .collect(Collectors.toSet()));

        System.out.println(students.stream()
                .sorted((s1, s2) -> s2.getCourseList().size() - s1.getCourseList().size())
                .limit(3)
                .collect(Collectors.toList()));


        System.out.println(students.stream()
                .filter(s -> s.getCourseList().contains(course6))
                .collect(Collectors.toList()));


    }


}
