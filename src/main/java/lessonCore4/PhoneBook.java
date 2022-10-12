package lessonCore4;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap <String, ArrayList <String>> phoneBook = new HashMap<>();


    public void add(String surname, String phone){
         ArrayList<String> phoneList = phoneBook.getOrDefault(surname, new ArrayList<>());
         phoneList.add(phone);
         phoneBook.put(surname, phoneList);
    }
    public ArrayList<String> get(String surname){
        return phoneBook.get(surname);
    }

}
