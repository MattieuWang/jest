package com.jest.visitor;

import com.jest.carte.Carte;
import com.jest.carte.CarteTypes;
import com.jest.joueur.Joueur;
import com.jest.joueur.Score;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Calendar;

public class JoueurVisitor implements Visitor {
    public void visit(Joueur joueur) {
        ArrayList<Carte> cartes = joueur.getJest();
        int face_valeur = 0;
        int jest_valeur = 0;
        boolean avecJoker = false;
        int nb_2 = 0;
        int nb_3 = 0;
        int nb_4 = 0;

        int nb_heart = 0;
        int nb_pas_ace = 0;
        int nb_ace = 0;

        // couleur: 0 JOKER, 1 HEART, 2 DIAM, 3 CLUB, 4 SPADE
        for (Carte carte : cartes)
        {
             face_valeur += carte.getValeur();
            // normal point
            if (carte.getColeur()==4 || carte.getColeur()==3)
            {
                jest_valeur += carte.getValeur();
            }

            if (carte.getColeur()==2)
            {
                jest_valeur -= carte.getValeur();
            }

            if (carte.getColeur()==0)
            {
                avecJoker = true;
            }
            if (carte.getColeur()==1)
                nb_heart++;
            if (carte.getValeur() != 1)
                nb_pas_ace++;
            if (carte.getValeur() == 1)
                nb_ace++;
            if (carte.getValeur() == 2)
                nb_2++;
            if (carte.getValeur() == 3)
                nb_3++;
            if (carte.getValeur() == 4)
                nb_4++;


        }

        // couleur: 0 JOKER, 1 HEART, 2 DIAM, 3 CLUB, 4 SPADE
        // Joker & Heart
        for (Carte carte : cartes)
        {
            if (avecJoker)
            {
                if (nb_heart == 0)  // sans heart
                {
                    jest_valeur += 4;
                    break;
                }
                else
                {
                    if (carte.getColeur()==1 && nb_heart < 4)
                    {
                        jest_valeur -= carte.getValeur();       // 1 2 3 heart avec joker
                    }
                    if (carte.getColeur()==1 && nb_heart == 4)
                    {
                        jest_valeur += carte.getValeur();       // 4 heart avec joker
                    }
                }
            }
        }
        // couleur: 0 JOKER, 1 HEART, 2 DIAM, 3 CLUB, 4 SPADE
        // paire noire
        for (Carte carte : cartes)
        {
            if (carte.getColeur()==4)
            {
                for (Carte carte1 : cartes)
                {
                    if (carte1.getColeur()==3 && carte1.getValeur() == carte.getValeur())
                    {
                        face_valeur += 2;
                        jest_valeur += 2;
                    }
                }
            }
        }
        // ACE
        if (nb_pas_ace == 0)
        {
            jest_valeur = 12;
            face_valeur += 4 * nb_ace;
        }


        Score score = new Score(face_valeur,jest_valeur,avecJoker,nb_2,nb_3,nb_4);
        joueur.setScore(score);
    }

}
