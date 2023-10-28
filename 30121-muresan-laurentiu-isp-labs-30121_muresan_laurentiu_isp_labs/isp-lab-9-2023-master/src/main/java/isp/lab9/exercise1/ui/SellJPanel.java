package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * todo: implement - it should look similar to the 'Buy' panel
 */
public class SellJPanel extends JPanel {

    private StockMarketJFrame mainFrame;

    public SellJPanel(StockMarketJFrame mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
    }

    public SellJPanel() {

    }

    private void initComponents(){
        setLayout(new GridLayout(2, 2));

        JPanel sellPanel = new JPanel();
        sellPanel.setLayout(new GridLayout(10, 2));

        JLabel availableFundsLabel = new JLabel("Available funds:");
        JTextField availableFundsTextField = new JTextField(mainFrame.getPortfolio().getCash().toPlainString() + " $");
        availableFundsTextField.setEditable(false);

        JLabel symbolLabel = new JLabel("Symbol:");
        JComboBox<String> symbolComboBox = new JComboBox<>();
        symbolComboBox.setModel(new DefaultComboBoxModel(mainFrame.getMarketService().getSymbols()));

        JLabel quantityLabel = new JLabel("Quantity:");
        JTextField quantityTextField = new JTextField();

        JLabel costLabel = new JLabel("Total cost:");
        JTextField costTextField = new JTextField();
        costTextField.setEditable(false);

        JButton sellButton = new JButton("Sell");

        // todo: add event listener to 'Sell' button
        sellButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s=costTextField.getText();
                s = s.replace(",", "");
                String a=availableFundsTextField.getText();
                a=a.replace("$", "");
                double availableFunds=Double.parseDouble(a);
                double cost=Double.parseDouble(s);
                double totalFunds=availableFunds+cost;
                availableFundsTextField.setText(totalFunds+" $");
                System.out.println("Sold");

            }
        });

        JButton costButton = new JButton("Get cost");
        costButton.addActionListener(e ->
                calculateTotalCostActionPerformed(symbolComboBox, quantityTextField, costTextField));

        sellPanel.add(availableFundsLabel);
        sellPanel.add(availableFundsTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(symbolLabel);
        sellPanel.add(symbolComboBox);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(quantityLabel);
        sellPanel.add(quantityTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(costLabel);
        sellPanel.add(costTextField);
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(new JPanel()); // empty cell in the grid
        sellPanel.add(sellButton);
        sellPanel.add(costButton);
        add(sellPanel);
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid
        add(new JPanel()); // empty cell in the grid

    }
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
