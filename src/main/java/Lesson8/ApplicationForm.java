package Lesson8;

import Lesson8.components.DigitJButton;
import Lesson8.components.OperationJButton;
import Lesson8.listeners.ButtonListener;
import Lesson8.listeners.ClearFieldButtonListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ApplicationForm extends JFrame {
    private JTextField inputField;
    private int sum;
    private String operation;

    //  настройка конструктора
    public ApplicationForm(String title) {
        super(title);

        setBounds(1000,100,250, 370); // координаты и размер окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);  // закрытие по крестику
        setAlwaysOnTop(true); // поверх всех окон

        setLayout(new BorderLayout()); // установка(создание типа BorderLayout ) компоновщика зон в окне

        // Добавление(создание) зон(панелей) в окне
        add(createTopPanel(), BorderLayout.NORTH); // первый аргумент- метод создающий панель, второй- компоновщик, указывающий расположение
        add(createCenterPanel(), BorderLayout.CENTER);
        setJMenuBar(createMenu());// устанавка (создание) верхней строчки менюбар


        setVisible(true); //  включение видимости окна
    }

    // Создание менюбара
    private JMenuBar createMenu() {
        JMenuBar menuBar = new JMenuBar(); // создание экземпляра  менюбара

        JMenu file = new JMenu("File"); // создание экземпляра меню  для бара
        //создание и добовление экземпляров пунктов в меню
        JMenuItem clear = new JMenuItem("Clear");
        clear.addActionListener(new ClearFieldButtonListener(inputField));
        file.add(clear);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(e -> System.exit(0));
        file.add(exit);

        JMenu options = new JMenu("Options");
        options.add(new JMenuItem("Help"));
        options.add(new JMenuItem("About"));

        // добавление мюню в менюбар
        menuBar.add(file);
        menuBar.add(options);

        return menuBar;
    }

    private JPanel createTopPanel() {
        JPanel topPanel = new JPanel(); // Создание экземпляра панели
        topPanel.setLayout(new BorderLayout()); // Установка компоновщика для этой панели


        inputField = new JTextField(); // Создание экземпляра поля ввода в ранее объявленную переменную
        inputField.setEditable(false); // запрет на изменения
        inputField.setText("");
        topPanel.add(inputField); // добавление поля ввода на панель

        inputField.setFont(new Font("Arial", Font.PLAIN, 20)); // установка шрифта для поля
        inputField.setMargin(new Insets(8,0,8,0)); // установка отступов поля на панели
        inputField.setBackground(new Color(96, 184, 146)); //установка фонового цвета

        return topPanel;
    }

    private JPanel createCenterPanel() {
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        ActionListener buttonListener = new ButtonListener(inputField); //  создание экземпляра слушателя для цифр

        // Добавление в центральную панель еще 2 панели( для цифр и опарторов)
        centerPanel.add(createDigitsPanel(buttonListener),BorderLayout.CENTER);
        centerPanel.add(createOperationsPanel(buttonListener),BorderLayout.WEST);

        return centerPanel;
    }

    private JPanel createDigitsPanel(ActionListener buttonListener) {
        JPanel digitsPanel = new JPanel();
        digitsPanel.setLayout(new GridLayout(4,3)); // установка на панель компоновщика "сетка"

        // Создание кнопок циклом
        for (int i = 0; i < 10; i++) {
            String btnTitle = (i == 9) ? "0" : String.valueOf(i + 1); //тернарный оператор
            JButton btn = new DigitJButton(btnTitle); // создание кнопки по новому классу из components
            btn.addActionListener(buttonListener); //Добавление к нопке слушателя
            digitsPanel.add(btn); //добавление кнопки на панель
        }

        JButton total = new OperationJButton("=");
        total.addActionListener(buttonListener);
        digitsPanel.add(total);
//        total.setEnabled(false);//кнопка выключена

        JButton clear = new OperationJButton("C");
        clear.addActionListener(new ClearFieldButtonListener(inputField));
        digitsPanel.add(clear);

        return digitsPanel;
    }

    private JPanel createOperationsPanel(ActionListener buttonListener) {
        JPanel operationsPanel= new JPanel();
        operationsPanel.setLayout(new GridLayout(4,1));

        JButton plus = new OperationJButton("+");
        plus.addActionListener(buttonListener);
        operationsPanel.add(plus);

        JButton minus = new OperationJButton("-");
        minus.addActionListener(buttonListener);
        operationsPanel.add(minus);

        JButton multiply = new OperationJButton("x");
        multiply.addActionListener(buttonListener);
        operationsPanel.add(multiply);

        JButton divide = new OperationJButton("/");
        divide.addActionListener(buttonListener);
        operationsPanel.add(divide);

        return operationsPanel;
    }


}