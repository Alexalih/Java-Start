package lesson5;

public class main {
    public static void main(String[] args) {
        Person [] array = new Person [5];
        array[0] = new Person("Иванов Иван", "Разработчик", "ivanov@ivanov.ru","+790332211",150000, 27);
        array[1] = new Person("Петров Петр", "Разработчик", "petrov@pp.ru","+799994546",200000, 43);
        array[2] = new Person("Зайцева Анна", "Тестировщик", "zaic@pp.ru","+70000811",120000, 35);
        array[3] = new Person("Марков Марк", "Аналитик", "mark@bk.ru","+795662211",120000, 45);
        array[4] = new Person("Павлов Павел", "Продукт-менеджер", "pavlov@pp.ru","+7967541",220000, 40);

        for (Person person: array) {
            if (person.getAge() > 40){
                person.printInfo();
            }
        }


    }
}
