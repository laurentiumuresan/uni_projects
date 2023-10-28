/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package isp.lab10.raceapp;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Semaphore {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Semaphore");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SemaphorePanel semaphorePanel = new SemaphorePanel("Start signal");

        frame.getContentPane().add(semaphorePanel);
        frame.pack();
        frame.setVisible(true);

        SemaphoreThread semaphoreThread = new SemaphoreThread(semaphorePanel);
        semaphoreThread.start();
    }
}

class SemaphoreThread extends Thread {
    private SemaphorePanel semaphorePanel;

    public SemaphoreThread(SemaphorePanel semaphorePanel) {
        this.semaphorePanel = semaphorePanel;
    }

    public void run() {
        try {
            semaphorePanel.setGray();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setYellow();
            Thread.sleep((int) (Math.random() * 5000) + 2000);

            semaphorePanel.setGreen();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphorePanel extends JPanel {
    private Color color;

    public SemaphorePanel(String title) {
        setPreferredSize(new Dimension(100, 100));
        color = Color.GRAY;
        Border border = BorderFactory.createTitledBorder(title);
        setBorder(border);
    }

    public void setGray() {
        color = Color.GRAY;
        repaint();
    }

    public void setYellow() {
        color = Color.YELLOW;
        repaint();
    }

    public void setGreen() {
        color = Color.GREEN;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int diameter = Math.min(getWidth(), getHeight()) - 20;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;

        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);

        g.setColor(Color.BLACK);
        g.drawOval(x, y, diameter, diameter);
    }
}
