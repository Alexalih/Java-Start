package lessonCore7.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterFace() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя города кириллицой:");
            String city = scanner.nextLine();
            String command;

            while (true) {
                System.out.println("Введите 1 для получения погоды на сегодня;" + "\n" +
                        "Введите 5 для прогноза на 5 дней;" + "\n" + "Для выхода введите 0:");
                command = scanner.nextLine();


                if (command.equals("0") || command.equals("5") || command.equals("1")  ) {
                    break;
                }
//                if (command.equals("5") ) {
//                    break;
//                }
//                if (command.equals("1") ) {
//                    break;
//                }
                System.out.println("Ошибка, невверная комманда, попробуйте еще раз!");
            }

            if (command.equals("0")) {
                break;
            }


            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
