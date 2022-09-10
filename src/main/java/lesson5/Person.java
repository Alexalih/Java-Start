package lesson5;

public class Person {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Person(String fullName, String position, String email, String phone, int salary, int age){
        this.fullName =fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.printf("%s - %s, возраст %d %n", position, fullName, age);
        System.out.printf("тел.: %s, email: %s %n", phone, email);
        System.out.printf("Зарплата %s руб. %n", salary);
    }

    public int getAge(){
        return age;
    }
}
