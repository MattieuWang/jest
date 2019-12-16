package com.jest.views;

import com.jest.Controller.Controller;
import com.jest.Controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class FinDeJeuView extends JPanel implements Runnable{
    private JPanel panelTable;
    private JTable table;
    private String joueurNom;
    private int note;
    private Object[] columnName  = {"Nom","note"};
    private Object[][] data;
    private int index;
    private JPanel panelBtn;
    private JPanel panel;

    private boolean next;

    private Controller controller;
    private ViewController viewController;

    private static final int FIN_HEIGHT = 120;
    private static final int FIN_WIDTH = 260;


    public FinDeJeuView()
    {
        controller = Controller.getInstance();
//        viewController = ViewController.getInstance();
        index = 0;
        data = new Object[4][2];
        panel = new JPanel(new BorderLayout(5,0));
        panel.setBounds(ViewController.WIDTH/2 - FIN_WIDTH/2,ViewController.HEIGHT/2 - FIN_HEIGHT/2,FIN_WIDTH,FIN_HEIGHT);
        panelTable = new JPanel(new BorderLayout());
//        panelBtn = new JPanel(new BorderLayout(0,0));
        panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER,10,0));

        next = false;

    }


    public void addData(String joueurNom, int note)
    {
        data[index][0] = joueurNom;
        data[index][1] = note;
        index++;
    }
    public void initData()
    {
        data = new Object[4][2];
        index = 0;
    }

    public JPanel getPanel()
    {
        JButton btnRecommence = new JButton("Recommencer");
        JButton btnFinie = new JButton("Finir le jeu");
        btnFinie.setBounds(0,0,100,50);
        btnRecommence.setBounds(0,0,100,50);
        btnRecommence.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewController = ViewController.getInstance();
                controller.initTous();
//                viewController.initTous();
                System.out.println("recommencer");
                panel.setVisible(false);
                next = true;
            }
        });

        btnFinie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                viewController = ViewController.getInstance();
                viewController.getFrame().dispatchEvent(new WindowEvent(viewController.getFrame(), WindowEvent.WINDOW_CLOSING));
                System.out.println("fini");
            }
        });


        panelBtn.add(btnRecommence);
        panelBtn.add(btnFinie);
        table = new JTable(data,columnName);
        table.setEnabled(false);
        panelTable.add(table.getTableHeader(),BorderLayout.NORTH);
        panelTable.add(table,BorderLayout.CENTER);
        panelTable.add(panelBtn,BorderLayout.SOUTH);
//        panelTable.setVisible(false);
        panel.add(panelTable,BorderLayout.CENTER);
        panel.add(panelBtn,BorderLayout.SOUTH);
//        panel.setVisible(true);
        panel.setVisible(false);
        return panel;
    }

    public boolean isNext() {
        return next;
    }
    public void initNext()
    {
        next = false;
    }

    @Override
    public void run() {

    }
}















