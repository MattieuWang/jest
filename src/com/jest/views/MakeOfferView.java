package com.jest.views;

import com.jest.Controller.ViewController;
import com.jest.joueur.Joueur;
import com.jest.models.CardModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.util.ArrayList;

public class MakeOfferView extends JPanel {

    private static final int HEIGHT = 800;
    private static final int WIDTH = 1400;
    private ArrayList<Joueur> joueurs;

    private static final int j1x = 500;
    private static final int j1y = 500; //en bas
    private static final int j2x = 50;
    private static final int j2y = 300; //en gauche
    private static final int j3x = 900;
    private static final int j3y = 400; // en droit
    private static final int j4x = 300;
    private static final int j4y = 50; // en haut

    private static final int joueurWidth = 200;
    private static final int joueurHeight = 200;

    private boolean isOver;
    private boolean isOver2;

    private int[] choixCarte = {0,0,0,0};
    private int[] choixNb = {0,0,0,0};
    private boolean[] confi = {false,false,false,false};

    public MakeOfferView()
    {
        isOver = false;
        setBounds(0,0,WIDTH,HEIGHT);
        setOpaque(false);
        setVisible(false);
        setLayout(null);
    }


    public void afficherJoueur(Joueur joueur)
    {
        removeAll();
//        repaint();
        revalidate();
        choixCarte[0]=0;choixCarte[1]=0;choixCarte[2]=0;choixCarte[3]=0;
        choixNb[0]=0;choixNb[1]=0;choixNb[2]=0;choixNb[3]=0;
        confi[0]=false;confi[1]=false;confi[2]=false;confi[3]=false;
        System.out.println("DO MAKE OFFER "+ joueur.getName());
        isOver = false;
        isOver2 = false;
        JPanel joueurPanel = new JPanel();
        JPanel boutonPanel = new JPanel(new BorderLayout());
        JPanel nomPanel = new JPanel();
        nomPanel.setBounds(joueurWidth/2 - 50,150,100,15);
        nomPanel.setBackground(Color.white);
        JLabel nom = new JLabel(joueur.getName());
        nom.setBounds(0,0,100,15);
        nomPanel.add(nom);
        joueurPanel.setOpaque(false);
        joueurPanel.setLayout(new BorderLayout());


        JPanel cartePanel = new JPanel(new GridLayout(1,2));
        int init_x1 = 0;
        int init_x2 = 110;
        int init_y = 20;
        CardModel carte1 = new CardModel(joueur.getCarteOffer().get(0),init_x1,init_y);
        CardModel carte2 = new CardModel(joueur.getCarteOffer().get(1),init_x2,init_y);
        carte1.setVisi(true);
        carte2.setVisi(true);

        ArrayList<CardModel> cards = new ArrayList<>();
        cards.add(carte1);
        cards.add(carte2);
        cartePanel.setBounds(0,0,joueurWidth,joueurHeight);
        cartePanel.add(carte1);
        cartePanel.add(carte2);
        cartePanel.setOpaque(false);
        joueurPanel.add(cartePanel,BorderLayout.CENTER);
        add(joueurPanel);

        for (CardModel cardModel : cards)
        {
            cardModel.addMouseListener(new MouseListener() {
                boolean clicked = false;
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!confi[joueur.getId()-1]&&choixCarte[joueur.getId()-1]!=cardModel.getCarte().getId() && joueur.getType()==0) {
                        clicked = true;
                        cardModel.setPosition(cardModel.getX(), init_y - 20);
                        choixCarte[joueur.getId()-1] = cardModel.getCarte().getId();
                        if (carte1.getCarte().getId()==choixCarte[joueur.getId()-1])
                        {
                            choixNb[joueur.getId()-1] = 1;
                            carte1.setPosition(init_x1,init_y-20);
                            carte2.setPosition(init_x2,init_y);
                        }
                        else
                        {
                            choixNb[joueur.getId()-1] = 2;
                            carte1.setPosition(init_x1,init_y);
                            carte2.setPosition(init_x2,init_y-20);
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
                    if (!confi[joueur.getId()-1]&&!clicked) {
                        cardModel.setPosition(cardModel.getX(), cardModel.getY() - 10);
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!confi[joueur.getId()-1]&&!clicked) {
                        cardModel.setPosition(cardModel.getX(), init_y);
                    }
                }
            });
        }

        JButton confirmer = new JButton("confirmer");
        confirmer.setBounds(0,0,100,40);
        confirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (choixNb[joueur.getId()-1]!=0) {
                    try {
                        PrintWriter pw = new PrintWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("src/filetmp/choixtmp.txt"), "utf-8"));
                        pw.print(choixNb[joueur.getId() - 1]);
                        System.out.println("write " + choixNb[joueur.getId() - 1]);
                        pw.close();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    isOver = true;
                    if (choixNb[joueur.getId() - 1] == 1)
                    {
                        carte1.setVisi(true);
                        carte2.setVisi(false);
                        carte2.setImage(new ImageIcon("src/images/cachee.png").getImage());
                        carte1.setPosition(init_x1,init_y);
                    }
                    else
                    {
                        carte2.setVisi(true);
                        carte1.setVisi(false);
                        carte1.setImage(new ImageIcon("src/images/cachee.png").getImage());
                        carte2.setPosition(init_x2,init_y);
                    }
                    confi[joueur.getId()-1] = true;
                }
            }
        });
        JButton annuler = new JButton("annuler");
        annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carte1.setPosition(init_x1,init_y);
                carte2.setPosition(init_x2,init_y);
                choixCarte[joueur.getId()-1] = 0;
            }
        });
        annuler.setBounds(110,0,100,35);
        boutonPanel.add(annuler,BorderLayout.WEST);
        boutonPanel.add(confirmer,BorderLayout.EAST);
        boutonPanel.setBounds(0,165,250,35);
        boutonPanel.setOpaque(false);

//        joueurPanel.add(cartesPanel);
//        joueurPanel.add(nomPanel);
        if (joueur.getType()==0)
            joueurPanel.add(boutonPanel,BorderLayout.SOUTH);
//        joueurPanel.add(confirmer);
        joueurPanel.setOpaque(false);
//        joueurPanel.setBounds(100,100,200,200);


        if (joueur.getId() == 1)
        {
            joueurPanel.setBounds(j1x,j1y,joueurWidth,joueurHeight);
        }
        if (joueur.getId() == 2)
        {
            joueurPanel.setBounds(j2x,j2y,joueurWidth,joueurHeight);

        }
        if (joueur.getId() == 3)
        {
            joueurPanel.setBounds(j3x,j3y,joueurWidth,joueurHeight);
        }
        if (joueur.getId() == 4)
        {
            joueurPanel.setBounds(j4x,j4y,joueurWidth,joueurHeight);
        }

//        System.out.println(joueurPanel.getX()+" "+joueurPanel.getY());
//        System.out.println(getX()+" "+getY()+" "+getHeight()+" "+getWidth());
    }

    public void afficherResultatMakeOffer(ArrayList<Joueur> joueurs)
    {
        JButton continuer = new JButton("continuer");
        add(continuer);
        continuer.setBounds(1200,700,100,40);
        continuer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                continuer.setVisible(false);
                isOver2 = true;
            }
        });
        for (Joueur joueur : joueurs)
        {
            JPanel joueurPanel = new JPanel(new GridLayout(2,1));
            JPanel nomPanel = new JPanel();
            nomPanel.setBounds(joueurWidth/2 - 50,150,100,15);
            nomPanel.setBackground(Color.white);
            JLabel nom = new JLabel(joueur.getName());
            nom.setBounds(0,0,100,15);
            nomPanel.add(nom);
            joueurPanel.setOpaque(true);

            JPanel cartePanel = new JPanel(new BorderLayout());
            int init_x1 = 0;
            int init_x2 = 110;
            int init_y = 20;
            CardModel carte1 = new CardModel(joueur.getCarteOffer().get(0),init_x1,init_y);
            CardModel carte2 = new CardModel(joueur.getCarteOffer().get(1),init_x2,init_y);
            carte1.setVisi(carte1.getCarte().isVisible());
            carte2.setVisi(carte2.getCarte().isVisible());

            ArrayList<CardModel> cards = new ArrayList<>();
            cards.add(carte1);
            cards.add(carte2);
            cartePanel.setBounds(0,0,joueurWidth,joueurHeight);
            cartePanel.add(carte1);
            cartePanel.add(carte2);
            cartePanel.setOpaque(false);
            joueurPanel.add(cartePanel);
            add(joueurPanel);
//        joueurPanel.add(confirmer);
            joueurPanel.setOpaque(false);
            joueurPanel.setBounds(100,100,200,200);


            if (joueur.getId() == 1)
            {
                joueurPanel.setBounds(j1x,j1y,joueurWidth,joueurHeight);
            }
            if (joueur.getId() == 2)
            {
                joueurPanel.setBounds(j2x,j2y,joueurWidth,joueurHeight);

            }
            if (joueur.getId() == 3)
            {
                joueurPanel.setBounds(j3x,j3y,joueurWidth,joueurHeight);
            }
            if (joueur.getId() == 4)
            {
                joueurPanel.setBounds(j4x,j4y,joueurWidth,joueurHeight);
            }
        }
    }

    public boolean isOver() {
        return isOver;
    }

    public boolean isOver2() {
        return isOver2;
    }

    public int getChoix(Joueur joueur)
    {
        return choixNb[joueur.getId()-1];
    }
}
