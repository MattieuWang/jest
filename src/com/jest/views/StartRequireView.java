package com.jest.views;

import com.jest.Controller.ViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

public class StartRequireView extends JPanel {

    private JPanel panel;
    private int nbJoueurs;
    private boolean isOver;
    private static final int S_HEIGHT = 150;
    private static final int S_WIDTH = 300;

    public StartRequireView()
    {
        isOver = false;
        panel = new JPanel();
        panel.setVisible(false);
        panel.setLayout(new GridLayout(3,1));
        panel.setBounds(ViewController.WIDTH/2 - S_WIDTH/2,ViewController.HEIGHT/2 - S_HEIGHT/2,S_WIDTH,S_HEIGHT);
        panel.setBackground(Color.gray);
        panel.setOpaque(true);

        JPanel txtPanel = new JPanel();
        JPanel radioBtnPanel = new JPanel();
        panel.add(txtPanel);
        panel.add(radioBtnPanel);
        JLabel txtLable = new JLabel("Choix: ");
        txtPanel.setLayout(new FlowLayout());
        txtPanel.add(txtLable);


        radioBtnPanel.setLayout(new GridLayout(2,1));
        JRadioButton radioBtn1 = new JRadioButton("3 joueurs");
        radioBtnPanel.add(radioBtn1);
        JRadioButton radioBtn2 = new JRadioButton("4 joueurs");
        radioBtnPanel.add(radioBtn2);

        ButtonGroup group = new ButtonGroup();
        group.add(radioBtn1);
        group.add(radioBtn2);



        JPanel btnPanel = new JPanel(new FlowLayout());
        panel.add(btnPanel);
        JButton btn_confirm = new JButton("confirmer");
        btn_confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioBtn1.isSelected())
                {
                    nbJoueurs = 2;      // 2 joueurs virtuels
                }
                if (radioBtn2.isSelected())
                {
                    nbJoueurs = 3;      // 3 joueurs virtuels
                }
                if (radioBtn1.isSelected() || radioBtn2.isSelected()) {
                    panel.setVisible(false);
                    isOver = true;
                }
//                System.out.println(nbJoueurs);
            }
        });
        btnPanel.add(btn_confirm);
    }

    public boolean isOver() {
        return isOver;
    }


    public JPanel getPanel() {
        return panel;
    }

    public int getNbJoueurs() {
        return nbJoueurs;
    }

    public void setNbJoueurs(int nbJoueurs) {
        this.nbJoueurs = nbJoueurs;
    }
}
