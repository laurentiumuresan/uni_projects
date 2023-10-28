package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mihai.hulea
 * @author radu.miron
 */
public class LoginJFrame extends JFrame {
    public static final Map<String, String> accounts = new HashMap<>();

    public LoginJFrame() {
        //set the window
        this.setTitle("Login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(200, 200, 300, 200);

        //create and add components
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 100, 20);
        this.add(userLabel);

        JTextField userInputField = new JTextField();
        userInputField.setBounds(160, 20, 100, 20);
        this.add(userInputField);

        JLabel pwdLabel = new JLabel("Password:");
        pwdLabel.setBounds(20, 60, 100, 20);
        this.add(pwdLabel);

        JPasswordField pwdInputField = new JPasswordField();
        pwdInputField.setBounds(160, 60, 100, 20);
        this.add(pwdInputField);

        JButton button = new JButton("Login");
        button.setBounds(20, 100, 240, 20);
        this.add(button);

        // add event listener to button
        button.addActionListener(e -> verifyCredentials(userInputField, pwdInputField));

        //initialize accounts
        initAccounts();

        //display
        this.setVisible(true);
    }

    private void verifyCredentials(JTextField userInputField, JPasswordField pwdInputField) {
        LoginJFrame.this.setVisible(false);
        if (accounts.containsKey(userInputField.getText()) && accounts.containsValue(pwdInputField.getText())) {
            if (accounts.get(userInputField.getText()).equals(pwdInputField.getText())) {
                new StockMarketJFrame();
            }
        } else {
            JDialog dialog = new JDialog();
            dialog.setBounds(200, 200, 200, 100);
            dialog.getContentPane().setLayout(new BorderLayout());
            dialog.getContentPane().setBackground(Color.red);
            JLabel dialogLabel = new JLabel("Incorrect credentials!");
            dialog.getContentPane().add(dialogLabel, BorderLayout.CENTER);
            JButton dialogButton = new JButton("OK");
            dialogButton.addActionListener(e -> dialog.dispose());
            dialog.getContentPane().add(dialogButton, BorderLayout.SOUTH);
            dialog.setModal(true);
            dialog.setVisible(true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        }
    }

    private void initAccounts() {
        accounts.put("1", "1");
    }
}
