package com.jest.views;

import com.jest.Controller.ViewController;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.models.CardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TakeCardView extends JPanel {

    private JLabel label;
    private JPanel cartePanel;
    private JPanel boutonPanel;
    private JButton confirmer;
    private JButton annuler;
    private int choix;
    private boolean isOver;
    public TakeCardView()
    {
        choix = 0;
        isOver = false;
        setBounds(ViewController.WIDTH/2-250,400,500,300);
//        setOpaque(false);
        setVisible(false);
        setLayout(new BorderLayout());
        cartePanel = new JPanel(new GridLayout(1,4));
        cartePanel.setBounds(0,20,500,200);
        boutonPanel = new JPanel(new GridLayout(1,2));
        boutonPanel.setBounds(0,300,400,50);
        confirmer = new JButton("confirmer");
        annuler = new JButton("annuler");
        boutonPanel.add(confirmer);
        boutonPanel.add(annuler);

    }


    public void takeCardOnTable(Joueur joueur,ArrayList<Carte> cartes)
    {
        isOver = false;
        int init_x = 0;
        choix=0;
        cartePanel.removeAll();
        removeAll();
        label = new JLabel();
        label.setText(joueur.getName()+" choit une carte: ");
        add(label,BorderLayout.NORTH);
        add(cartePanel,BorderLayout.CENTER);
        add(boutonPanel,BorderLayout.SOUTH);
        ArrayList<CardModel> offers = new ArrayList<>();
        for (Carte carte : cartes)
        {
            offers.add(new CardModel(carte,init_x,20));
            init_x += 90;
        }
        for (CardModel cardModel : offers)
        {
            cartePanel.add(cardModel);
            cardModel.setVisi(false);
            cardModel.setPosition(cardModel.getX(),20);
            cardModel.addMouseListener(new MouseListener() {
                boolean clicked = false;
                @Override
                public void mouseClicked(MouseEvent e) {
                    clicked = true;
                    cardModel.setPosition(cardModel.getX(),0);
                    for (CardModel c : offers)
                    {
                        if (c.getCarte().getId()!= cardModel.getCarte().getId())
                        {
                            c.setPosition(c.getX(),20);
                        }
                    }
                    for (int i=0;i<offers.size();i++)
                    {
                        if (offers.get(i).getCarte().getId() == cardModel.getCarte().getId())
                        {
                            choix = i;
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    if (!clicked)
                        cardModel.setPosition(cardModel.getX(),10);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!clicked)
                        cardModel.setPosition(cardModel.getX(),20);
                }
            });
        }

        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choix = 0;
                for (CardModel cardModel : offers)
                {
                    cardModel.setPosition(cardModel.getX(),20);
                }
            }
        });

        confirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("le choix: "+choix);
                System.out.println(cartes.get(choix));
                if ((choix != 0 && cartes.get(choix).getJoueurId() != joueur.getId())||(choix !=0 && cartes.size()==1))
                {
                    System.out.println("true");
                    isOver = true;
                }
                else if (cartes.get(choix).getJoueurId() != joueur.getId()&&cartes.size()>1)
                {
                    System.out.println("vous ne pouvez pas la carte de vous-meme");
                }
                else
                {
                    isOver = true;
                }
            }
        });
    }

    public int getChoix() {
        return choix;
    }

    public boolean isOver() {
        return isOver;
    }
}
