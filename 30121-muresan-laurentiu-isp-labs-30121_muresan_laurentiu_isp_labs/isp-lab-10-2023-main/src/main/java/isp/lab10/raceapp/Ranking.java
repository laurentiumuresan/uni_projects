package isp.lab10.raceapp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.IOException;


public class Ranking {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("Ranking");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RankingPanel rankingPanel = new RankingPanel("Rankings");

        frame.getContentPane().add(rankingPanel);
        frame.pack();
        frame.setSize(200, 200);
        frame.setVisible(true);
    }
}

class RankingPanel extends JPanel {
    private Color[] podiumColors;

    public RankingPanel(String title) throws IOException {
        podiumColors = new Color[]{Color.PINK, Color.YELLOW, Color.GRAY};
        Border border = BorderFactory.createTitledBorder(title);
        setBorder(border);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 3; i++) {
            int x = 200 * i + 100;
            int y = 300 - i * 100;
            int w = 200;
            int h = i * 100 + 100;
            if (i == 2) {
                y = 260;
                h = 140;
            }
            g.drawRect(x, y, w, h);
            g.setColor(podiumColors[i]);
            g.fillRect(x, y, w, h);
            g.setColor(Color.BLACK);
            g.drawRect(x, y, w, h);

        }
    }

}
