package com.jest.Controller;
import com.jest.views.ViewManager;

import javax.swing.*;

public class ViewController {
    private JFrame frame;
    private ViewManager views;

    public ViewController()
    {
        views = new ViewManager();
        frame = new JFrame();
        frame.setResizable(false);
        frame.setSize(1200,700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(views.getLayeredPane());
        frame.setVisible(true);
    }

    public int getNbJoueurs()
    {
        return views.getNbJoueurs();
    }


}
