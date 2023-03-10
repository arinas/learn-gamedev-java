package de.learngamedev;

import javax.swing.*;
import java.awt.*;

public class Display extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static  final int WIDTH = 800;
    public static final int HEIGHT = 600;

    public static final String TITLE = "MyFirstGame";



    private Thread mainThread;
    private boolean running = false;

    private void start() {
        if(running) return;
        else {
            running = true;
            mainThread = new Thread(this);
            mainThread.start();
        }
    }

    private void stop() {
        if (!running) return;
        else {
            running = false;
            try {
                mainThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public void run() {
        while (running) {

        }
    }

    public static void main(String[] args) {
        Display game = new Display();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(WIDTH,HEIGHT);
        frame.setTitle(TITLE);
        frame.setResizable(false);
        frame.setVisible(true);
        game.start();

        System.out.println("Game running...");
    }
}
