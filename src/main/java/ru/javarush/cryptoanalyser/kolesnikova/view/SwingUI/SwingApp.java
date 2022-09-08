package ru.javarush.cryptoanalyser.kolesnikova.view.SwingUI;


import javax.swing.*;
import java.awt.*;

public class SwingApp extends JFrame {

    private JPanel mailPanel;
    private JLabel label;
    private JTextField login;
    private JPasswordField password;
    private JButton enter;

    public void init() {
        setTitle("���� ������");
        setSize(600, 400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //������������
        setLayout(new BorderLayout());
        setResizable(false); // �������� ������� ���������

        mailPanel = new JPanel();
        this.add(mailPanel);

        label = new JLabel("�����");
        login = new JTextField(10);
        password = new JPasswordField(10);
        enter = new JButton("Enter");
        mailPanel.add(label);
        mailPanel.add(login);
        mailPanel.add(password);
        mailPanel.add(enter);

        enter.addActionListener(e -> {
            String passTxt = new String(password.getPassword());
            if (passTxt.equals("123123")) {
                label.setText(login.getText() + "is OK");
            } else {
                label.setText("incoorect pass");
            }
        });

//        BoxLayout boxLayout = new BoxLayout(mailPanel, BoxLayout.Y_AXIS);
//        mailPanel.setLayout(boxLayout);


        this.setVisible(true);

    }


}
