package lessonCore4;

import java.util.HashMap;
import java.util.HashSet;

public class Homework4 {
    public static void main(String[] args) {
        String [] list = {"альфа", "бетта", "гамма", "дельта", "тета", "эта", "омега", "альфа", "бетта", "бетта"};

        HashSet <String> hashSet = new HashSet<>();
        HashMap <String, Integer> hashMap = new HashMap<>();

        for (String a:list) {
            hashSet.add(a);
            Integer counter = hashMap.getOrDefault(a, 0);
            counter ++;
            hashMap.put(a,counter);
        }

        System.out.println(hashSet);
        System.out.println(hashMap);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "1234");
        phoneBook.add("Петров", "3456");
        phoneBook.add("Сидоров", "12345678");
        phoneBook.add("Иванов", "87654");

        System.out.println(phoneBook.get("Иванов"));

    }

}
