package isp.lab10.raceapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Stats {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Stats");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StatsPanel statsPanel=new StatsPanel("Stats");

        frame.getContentPane().add(statsPanel);
        frame.pack();
        frame.setSize(500, 500);
        frame.setVisible(true);

    }
}
    class StatsPanel extends JPanel {
        private int[] carPositions;
        private String[] carNames;
        private Color[] carColors;

        public StatsPanel(String title) {
            carPositions = new int[4];
            carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
            carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
            Border border = BorderFactory.createTitledBorder(title);
            setBorder(border);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < 4; i++) {
                int yPos = 50 + i * 100; // Vertical position of the car
                int xPos = carPositions[i]; // Horizontal position of the car
                int carSize = 30; // Size of the car

                g.setColor(carColors[i]);
                g.fillOval(xPos, yPos, carSize, carSize);
                g.setColor(Color.BLACK);
                g.drawString(carNames[i], xPos, yPos - 5);
            }
        }

    }
