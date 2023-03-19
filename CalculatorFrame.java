import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame implements ActionListener {
    private JLabel lengthLabel, widthLabel, heightLabel;
    private JTextField lengthText, widthText, heightText;
    private JButton calculateButton, resetButton;
    private JTextArea resultArea;

    public CalculatorFrame() {
        setTitle("Calculator");
        setLayout(new GridLayout(5, 2, 5, 5));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        lengthLabel = new JLabel("Length: ");
        add(lengthLabel);

        lengthText = new JTextField();
        add(lengthText);

        widthLabel = new JLabel("Width: ");
        add(widthLabel);

        widthText = new JTextField();
        add(widthText);

        heightLabel = new JLabel("Height: ");
        add(heightLabel);

        heightText = new JTextField();
        add(heightText);

        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        add(calculateButton);

        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        add(resetButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(resultArea);

        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculate();
        } else if (e.getSource() == resetButton) {
            reset();
        }
    }

    private void calculate() {
        try {
            double length = Double.parseDouble(lengthText.getText());
            double width = Double.parseDouble(widthText.getText());
            double height = Double.parseDouble(heightText.getText());

            double area = length * width;
            double perimeter = 2 * (length + width);
            double volume = length * width * height;
            double surfaceArea = 2 * ((length * width) + (length * height) + (width * height));

            resultArea.setText("Area: " + area + "\nPerimeter: " + perimeter +
                                "\nVolume: " + volume + "\nSurface Area: " + surfaceArea);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "An error occurred", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void reset() {
        lengthText.setText("");
        widthText.setText("");
        heightText.setText("");
        resultArea.setText("");
    }
}
