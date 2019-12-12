package com.jest.views;

import com.jest.models.CardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class ViewManager extends JPanel {
    private JLayeredPane layeredPane;
    private BackgroundView bgView;
    private LinkedList<CardModel> cdModels;
    private StartRequireView startRequireView;
    public static final int WIDTH = 1200;
    public static final int HEIGHT = 700;

    public ViewManager()
    {
        cdModels = new LinkedList<>();
        layeredPane = new JLayeredPane();
        bgView = new BackgroundView(WIDTH,HEIGHT);
        startRequireView = new StartRequireView();
        CardModel cardRef = new CardModel((new ImageIcon("src/images/cardRef.jpg")).getImage(),5);
        cardRef.setBounds(WIDTH/2 - cardRef.getW()/2,HEIGHT/2 - cardRef.getH()/2,cardRef.getW(),cardRef.getH());
        cardRef.setVisible(false);
        layeredPane.add(cardRef,5,1);
        layeredPane.add(bgView,0,0);

        JButton btn_start = new JButton("start");
        btn_start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layeredPane.getComponent(layeredPane.getIndexOf(startRequireView.getPanel())).setVisible(true);
                layeredPane.getComponent(layeredPane.getIndexOf(btn_start)).setVisible(false);
            }
        });
        btn_start.setBounds(550,300,100,50);
        layeredPane.add(btn_start,1,1);

        layeredPane.add(startRequireView.getPanel(),1,2);
    }

    public JLayeredPane getLayeredPane() {
        return layeredPane;
    }

    public int getNbJoueurs()
    {
        return startRequireView.getChoix();
    }
}
