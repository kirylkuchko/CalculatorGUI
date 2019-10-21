package calculator;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel implements ActionListener {
    private JButton[] num = new JButton[10];
    private Font font = new Font("SanSerif", 1, 20);
    private JTextField output;
    private JButton delete;
    private JButton clear;
    private JButton rowne;
    private JButton plus;
    private JButton minus;
    private JButton mnorzenie;
    private JButton dzielenie;
    private JFrame wind = new JFrame("Kalkulator");
    private JButton dot;
    static double a = 0.0D;
    static double b = 0.0D;
    static double result = 0.0D;
    static int operator = 0;

    public Calculator() {
        this.wind.setLayout((LayoutManager) null);
        this.wind.setSize(317, 337);
        this.wind.setVisible(true);
        this.wind.setDefaultCloseOperation(3);
        this.wind.setResizable(false);

        for (int x = 0; x < 3; ++x) {
            for (int y = 0; y < 3; ++y) {
                this.num[y * 3 + x + 1] = new JButton(String.valueOf(y * 3 + x + 1));
                this.num[y * 3 + x + 1].setBounds(x * 60 + 10, y * 60 + 70, 50, 50);
                this.num[y * 3 + x + 1].setFont(this.font);
                this.num[y * 3 + x + 1].addActionListener(this);
                this.wind.add(this.num[y * 3 + x + 1]);
            }
        }

        this.num[0] = new JButton("0");
        this.num[0].setBounds(70, 250, 50, 50);
        this.num[0].setFont(this.font);
        this.num[0].addActionListener(this);
        this.wind.add(this.num[0]);
        this.delete = new JButton("<");
        this.delete.setBounds(190, 250, 50, 50);
        this.delete.setFont(this.font);
        this.delete.addActionListener(this);
        this.wind.add(this.delete);
        this.clear = new JButton("C");
        this.clear.setBounds(10, 250, 50, 50);
        this.clear.setFont(this.font);
        this.clear.addActionListener(this);
        this.wind.add(this.clear);
        this.rowne = new JButton("=");
        this.rowne.setBounds(250, 190, 50, 110);
        this.rowne.setFont(this.font);
        this.rowne.addActionListener(this);
        this.wind.add(this.rowne);
        this.plus = new JButton("+");
        this.plus.setBounds(250, 70, 50, 110);
        this.plus.setFont(this.font);
        this.plus.addActionListener(this);
        this.wind.add(this.plus);
        this.minus = new JButton("-");
        this.minus.setBounds(190, 70, 50, 50);
        this.minus.setFont(this.font);
        this.minus.addActionListener(this);
        this.wind.add(this.minus);
        this.mnorzenie = new JButton("*");
        this.mnorzenie.setBounds(190, 130, 50, 50);
        this.mnorzenie.setFont(this.font);
        this.mnorzenie.addActionListener(this);
        this.wind.add(this.mnorzenie);
        this.dzielenie = new JButton("/");
        this.dzielenie.setBounds(190, 190, 50, 50);
        this.dzielenie.setFont(this.font);
        this.dzielenie.addActionListener(this);
        this.wind.add(this.dzielenie);
        this.dot = new JButton(".");
        this.dot.setBounds(130, 250, 50, 50);
        this.dot.setFont(this.font);
        this.dot.addActionListener(this);
        this.wind.add(this.dot);
        this.output = new JTextField();
        this.output.setBounds(10, 10, 290, 50);
        this.output.setEditable(false);
        this.output.setFont(this.font);
        this.output.addActionListener(this);
        this.wind.add(this.output);
    }

    public void actionPerformed(ActionEvent e) {
        int i;
        for (int x = 0; x < 3; ++x) {
            for (i = 0; i < 3; ++i) {
                if (e.getSource() == this.num[i * 3 + x + 1]) {
                    this.output.setText(this.output.getText().concat(String.valueOf(i * 3 + x + 1)));
                }
            }
        }

        if (e.getSource() == this.dot) {
            this.output.setText(this.output.getText().concat("."));
        }

        if (e.getSource() == this.num[0]) {
            this.output.setText(this.output.getText().concat("0"));
        }

        if (e.getSource() == this.plus) {
            a = Double.parseDouble(this.output.getText());
            operator = 1;
            this.output.setText("");
        }

        if (e.getSource() == this.minus) {
            a = Double.parseDouble(this.output.getText());
            operator = 2;
            this.output.setText("");
        }

        if (e.getSource() == this.mnorzenie) {
            a = Double.parseDouble(this.output.getText());
            operator = 3;
            this.output.setText("");
        }

        if (e.getSource() == this.dzielenie) {
            a = Double.parseDouble(this.output.getText());
            operator = 4;
            this.output.setText("");
        }

        if (e.getSource() == this.rowne) {
            b = Double.parseDouble(this.output.getText());
            switch (operator) {
                case 1:
                    result = a + b;
                    break;
                case 2:
                    result = a - b;
                    break;
                case 3:
                    result = a * b;
                    break;
                case 4:
                    result = a / b;
                    break;
                default:
                    result = 0.0D;
            }

            this.output.setText("" + result);
        }

        if (e.getSource() == this.clear) {
            this.output.setText("");
        }

        if (e.getSource() == this.delete) {
            String s = this.output.getText();
            this.output.setText("");

            for (i = 0; i < s.length() - 1; ++i) {
                this.output.setText(this.output.getText() + s.charAt(i));
            }
        }

    }

}