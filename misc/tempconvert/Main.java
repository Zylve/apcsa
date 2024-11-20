import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
    public static JFrame mainFrame;

    public static JLabel celsiusLabel;
    public static JTextField celsiusField;

    public static JLabel fahrenheitLabel;
    public static JTextField fahrenheitField;

    public static JButton ctoFButton;
    public static JButton ftoCButton;

    public static void main(String[] args) {
        mainFrame = new JFrame("Temperature Converter");
        mainFrame.setSize(300, 200);
        mainFrame.setLayout(new FlowLayout());

        celsiusLabel = new JLabel("Celsius");
        celsiusField = new JTextField(5);

        fahrenheitLabel = new JLabel("Fahrenheit");
        fahrenheitField = new JTextField(5);

        ctoFButton = new JButton("Convert C to F");
        ftoCButton = new JButton("Convert F to C");

        setupButtons();

        mainFrame.add(celsiusLabel);
        mainFrame.add(celsiusField);
        mainFrame.add(fahrenheitLabel);
        mainFrame.add(fahrenheitField);
        mainFrame.add(ctoFButton);
        mainFrame.add(ftoCButton);

        mainFrame.setVisible(true);
    }

    public static void setupButtons() {
        ftoCButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double f = Double.parseDouble(fahrenheitField.getText());
                    double c = (f - 32) * 5 / 9;
                    celsiusField.setText(String.valueOf(c));
                }
            }
        );

        
        ctoFButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    double c = Double.parseDouble(celsiusField.getText());
                    double f = (c * 9 / 5) + 32;
                    fahrenheitField.setText(String.valueOf(f));
                }
            }
        );
    }
}
