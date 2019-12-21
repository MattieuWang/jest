package com.jest.views;

import com.jest.Controller.ViewController;
import com.jest.models.JoueurBref;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class ChoixView extends JPanel {

    private JPanel choixPanel;
    private boolean isOver;
    private ArrayList<JoueurBref> joueurs;
    private JPanel joueurListePanel;
    private JButton confirmer;
    private int nbJV;
    private int nbJP;


    private static final int C_HEIGHT = 300;
    private static final int C_WIDTH = 400;

    public ChoixView()
    {
        nbJV=1;
        nbJP=1;
        isOver = false;
        joueurs = new ArrayList<>();
        choixPanel = new JPanel(new BorderLayout());
        choixPanel.setVisible(false);
        choixPanel.setBounds(ViewController.WIDTH/2 - C_WIDTH/2,ViewController.HEIGHT/2 - C_HEIGHT/2,C_WIDTH,C_HEIGHT);
        choixPanel.setBackground(Color.gray);

        joueurs.add(new JoueurBref(0,"vous",0));

        joueurListePanel = new JPanel(new GridLayout(4,1));
        choixPanel.add(joueurListePanel,BorderLayout.CENTER);

        // title
        JPanel titlePanel = new JPanel(new BorderLayout()); // une texte, 2 boutons adjouter, supprimer
        choixPanel.add(titlePanel,BorderLayout.NORTH);
        JLabel title = new JLabel("liste de joueurs:");
        JPanel titleBoutonPanel = new JPanel(new BorderLayout());
        JButton addP = new JButton("+JP");
        JButton addV = new JButton("+JV");
        JButton minus = new JButton("-");
        titleBoutonPanel.add(addP,BorderLayout.WEST);
        titleBoutonPanel.add(addV,BorderLayout.CENTER);
        titleBoutonPanel.add(minus,BorderLayout.EAST);
        titlePanel.add(title,BorderLayout.WEST);
        titlePanel.add(titleBoutonPanel,BorderLayout.EAST);
        updateListePanel();

        addP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController controller = ViewController.getInstance();
                if (joueurs.size() <= controller.getNbJoueurs())
                {
                    System.out.println("add JP");
                    joueurs.add(new JoueurBref(0,"joueurP"+nbJP,0));
                    nbJP++;
                    updateListePanel();
                    System.out.println(joueurs.size());
//                    listerJoueurs();
                }
            }
        });
        addV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController controller = ViewController.getInstance();
                if (joueurs.size() <= controller.getNbJoueurs())
                {
                    System.out.println("add JV");
                    joueurs.add(new JoueurBref(1,"joueurV"+nbJV,1));
                    nbJV++;
                    updateListePanel();
                    listerJoueurs();
                }
            }
        });
        minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (joueurs.size() > 1) {
                    if (joueurs.get(joueurs.size()-1).getType() == 0)
                    {
                        nbJP --;
                    }
                    else
                    {
                        nbJV --;
                    }
                    joueurs.remove(joueurs.size() - 1);
                    updateListePanel();
                    listerJoueurs();
                }
            }
        });
        joueurListePanel.setBounds(0,0,C_WIDTH,C_HEIGHT);

        confirmer = new JButton("confirmer");
        choixPanel.add(confirmer,BorderLayout.SOUTH);
        confirmer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewController controller = ViewController.getInstance();
                System.out.println(joueurs.size());
                System.out.println(controller.getNbJoueurs());
                if (joueurs.size() - 1 == controller.getNbJoueurs()) {
                    isOver = true;
                    choixPanel.setVisible(false);
                }
            }
        });

    }

    public void initView()
    {
        JoueurBref tmp = joueurs.get(0);
        joueurs.clear();
        joueurs.add(tmp);
    }

    public ArrayList<JoueurBref> getJoueurs() {
        return joueurs;
    }

    private void updateListePanel()
    {
        joueurListePanel.removeAll();
        for (JoueurBref j : joueurs)
        {
            JPanel joueurPanel = new JPanel(new GridLayout(1,3));
            JLabel jname = new JLabel(j.getName());
            JLabel jtype = null;
            JComboBox comboBox = null;

            if (j.getType() == 0)
            {
                jtype = new JLabel("Joueur Physique");
                joueurPanel.add(jname);
                joueurPanel.add(jtype);
                JLabel jtmp = new JLabel("-----------");
                joueurPanel.add(jtmp);
            }
            else if (j.getType() == 1)
            {
                jtype = new JLabel("Joueur Virtuel");
                comboBox = new JComboBox();
                if (j.getNiveau() == 1) {
                    comboBox.addItem("facile");
                    comboBox.addItem("difficile");
                }
                else if (j.getNiveau() == 2)
                {
                    comboBox.addItem("difficile");
                    comboBox.addItem("facile");

                }
                comboBox.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (((String)e.getItem()).equals("facile"))
                        {
                            System.out.println("facile");
                            j.setNiveau(1);
                        }
                        else if (((String)e.getItem()).equals("difficile"))
                        {
                            System.out.println("difficile");
                            j.setNiveau(2);
                        }
                    }
                });
                joueurPanel.add(jname);
                joueurPanel.add(jtype);
                joueurPanel.add(comboBox);

            }
            joueurListePanel.add(joueurPanel);
        }
        joueurListePanel.validate();
        joueurListePanel.repaint();
        choixPanel.repaint();
    }
    private void listerJoueurs()
    {
        for (JoueurBref joueurBref : joueurs)
        {
            System.out.println(joueurBref);
        }
    }
    public JPanel getPanel() {
        return choixPanel;
    }

    public boolean isOver() {
        return isOver;
    }
}
