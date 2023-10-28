package isp.lab9.exercise1.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  todo: implement portfolio panel; for each owned stock add symbol, quantity, price per unit, total price of the position
 *  it should look similar to the 'Market' panel
 */
public class PortofolioJPanel extends JPanel {
    private StockMarketJFrame frame;

    public PortofolioJPanel(StockMarketJFrame frame){
        this.frame = frame;
        initComponent();
    }

    public PortofolioJPanel() {

    }

    private void initComponent() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JTable jTablePortfolio = new JTable();
        jTablePortfolio.setModel(frame.getMarketService());
        JScrollPane portfolioScrollablePane = new JScrollPane(jTablePortfolio);

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(evt -> buttonRefreshActionPerformed(evt));

        add(portfolioScrollablePane);
        add(refreshButton);

    }

    /**
     * Refreshes the stock data.
     */
    private void buttonRefreshActionPerformed(ActionEvent evt) {
        try {
            frame.getMarketService().refreshMarketData();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(StockMarketJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
