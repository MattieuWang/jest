package com.jest.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartRequireView extends JPanel {

    private JPanel panel;
    private int choix;

    public StartRequireView()
    {
        panel = new JPanel();
        panel.setVisible(false);
        panel.setLayout(new GridLayout(3,1));
        panel.setBounds(450,200,300,150);
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
                    choix = 2;      // 2 joueurs virtuels
                }
                if (radioBtn2.isSelected())
                {
                    choix = 3;      // 3 joueurs virtuels
                }
                if (radioBtn1.isSelected() || radioBtn2.isSelected())
                    panel.setVisible(false);
                System.out.println(choix);
            }
        });
        btnPanel.add(btn_confirm);
    }

    public JPanel getPanel() {
        return panel;
    }

    public int getChoix() {
        return choix;
    }
}
