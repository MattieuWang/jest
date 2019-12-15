package com.jest.views;

import com.jest.Controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FinDeJeuView extends JPanel {
    private JPanel panel;
    JTable table;
    private String joueurNom;
    private int note;
    Object[] columnName  = {"Nom","note"};
    Object[][] data;
    int index;

    public FinDeJeuView()
    {
        index = 0;
        data = new Object[4][2];
        panel = new JPanel(new BorderLayout());
        panel.setBounds(ViewController.WIDTH/2 - 100,ViewController.HEIGHT/2 - 50,200,100);
    }

    public void addData(String joueurNom, int note)
    {
        data[index][0] = joueurNom;
        data[index][1] = note;
        index++;
    }

    public JPanel getPanel()
    {
        table = new JTable(data,columnName);
        panel.add(table.getTableHeader(),BorderLayout.NORTH);
        panel.add(table,BorderLayout.CENTER);
        panel.setVisible(false);
        return panel;
    }


}















