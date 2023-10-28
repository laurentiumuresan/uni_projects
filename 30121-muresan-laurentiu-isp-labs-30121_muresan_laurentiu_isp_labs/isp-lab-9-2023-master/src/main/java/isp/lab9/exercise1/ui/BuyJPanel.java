package isp.lab9.exercise1.ui;

import isp.lab9.exercise1.services.UserPortfolio;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BuyJPanel extends JPanel {
    private StockMarketJFrame mainFrame;

    public BuyJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents(){
        setLayout(new GridLayout(2, 2));

        JPanel buyPanel = new JPanel();
        buyPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        JTextField availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel<>(mainFrame.getMarketService().getSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton buyButton = new JButton("Buy");
        buyButton.addActionListener(e -> buyButton.doClick());
//        if(
//    {
//            JDialog dialog = new JDialog();
//            dialog.setBounds(200, 200, 200, 100);
//            dialog.getContentPane().setLayout(new BorderLayout());
//            dialog.getContentPane().setBackground(Color.red);
//            JLabel dialogLabel = new JLabel("Thanks for buying!");
//            dialog.getContentPane().add(dialogLabel, BorderLayout.CENTER);
//            JButton dialogButton = new JButton("OK");
//            dialogButton.addActionListener(e -> dialog.dispose());
//            dialog.getContentPane().add(dialogButton, BorderLayout.SOUTH);
//            dialog.setModal(true);
//            dialog.setVisible(true);
//            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        } else {
//            JDialog dialog = new JDialog();
//            dialog.setBounds(200, 200, 200, 100);
//            dialog.getContentPane().setLayout(new BorderLayout());
//            dialog.getContentPane().setBackground(Color.red);
//            JLabel dialogLabel = new JLabel("Not enough founds!");
//            dialog.getContentPane().add(dialogLabel, BorderLayout.CENTER);
//            JButton dialogButton = new JButton("OK");
//            dialogButton.addActionListener(e -> dialog.dispose());
//            dialog.getContentPane().add(dialogButton, BorderLayout.SOUTH);
//            dialog.setModal(true);
//            dialog.setVisible(true);
//            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        });

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e -> calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

        buyPanel.add(availableFundsLabel);
        buyPanel.add(availableFundsTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(symbolLabel);
        buyPanel.add(symbolComboBox);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(quantityLabel);
        buyPanel.add(quantityTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(costLabel);
        buyPanel.add(costTextField);
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(new JPanel()); // empty cell in the grid
        buyPanel.add(costButton);
        buyPanel.add(buyButton);
        add(buyPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid

    }

    /**
     * Calculates the total transaction cost
     */

    private void calculateTotalCostActionPerformed(JComboBox<String> symbolComboBox,
                                                   JTextField quantityTextField,
                                                   JTextField totalCostTextField) {
        try {
            String symbol = (String) symbolComboBox.getSelectedItem();
            BigDecimal stockPrice = mainFrame.getMarketService().getStockPrice(symbol);

            try {
                int quantity = Integer.parseInt(quantityTextField.getText());
                DecimalFormat formatter = new DecimalFormat("#,##0.##");
                totalCostTextField.setText(
                        formatter.format(stockPrice.multiply(new BigDecimal(quantity))));
            } catch (NumberFormatException e) {
                totalCostTextField.setText("Invalid quantity value!");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
