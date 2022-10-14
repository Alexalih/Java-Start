package lessonCore5;

import java.io.*;
import java.util.ArrayList;

public class AppData {
    private String[] header; // Массив заголовка
    private Integer[][] data; // Массив данных

    // Метод для сохранения header и data в файл
    public void save(File file) {

        // При работе с чтением/ записью  потока всегда использовать tryCatch
        //Попытка записать в буфер, а потом в сам файл file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

            writer.write(rowToString(header)); // записываем строку заголовка ( Массив заголовок превращается в строку методом rowToString)
            // записываем циклом каждую строку из двумерного массива данных( строка массива превращается в строку методом rowToString)
            for (Integer[] row : data) {
                writer.write(rowToString(row));
            }

        } catch (IOException e) {  // обработка любого исключения, связанного с доступом к данным и потоками
            e.printStackTrace();
        }
    }

    // метод для загрузки данных из фала file
    public void load(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { //загрузка потока  данных из файла в буфер
            header = reader.readLine().split(";"); // чтение первой строки readLine, преврашение в массив строк split( строка дробится на знаке ;
            ArrayList<Integer[]> list = new ArrayList<>(); // создание списка числовыми массивами
            String tempString;

            // со второй строки проходим по нима циклом, пока  не кончатся строки
            while ((tempString = reader.readLine()) != null) {
                list.add(stringToDataRow(tempString)); // каждую строку приводим к массиву чисел методом stringToDataRow и добавляем в список
            }
            data = list.toArray(new Integer[][]{{}});  // список приводим к массиву  и загружаем в переменную  data

        } catch (FileNotFoundException exception) {  // обработка исключения, если файл не найден
            exception.printStackTrace();

        } catch (IOException e) {  // обработка любого исключения, связанногос доступом к данным и потоками
            e.printStackTrace();
        }

    }

    // метод  превращающий строку в числовой массив
    private Integer[] stringToDataRow(String str) {
        String[] strings = str.split(";");

        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }
        return integers;
    }

    // метод(дженерик) , принимает на вход массив типа Т, возвращает строку. )
    private <T> String rowToString(T[] row) {
        String result = ""; // возвращаемая строка, вначале пустая
        for (int i = 0; i < row.length; i++) {
            result = result + row[i].toString();  // каждый элемент массива явно приводим к строке и добавляем в строку
            if (i != row.length - 1) {
                result = result + ";"; // если элемент не последний в массиве, в строке после него ставим ";" - разделитель в будущем csv файле
            }
        }
        result += "\n"; // после формирования строки,делаем перенос строки
        return result;
    }


    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }
}
