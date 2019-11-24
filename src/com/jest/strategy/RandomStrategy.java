package com.jest.strategy;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;

public class RandomStrategy implements Strategy {
    public Carte makeOffer(Joueur joueur,ArrayList<Carte> carteOffer) {
        System.out.println(joueur.getName() + " choit le face up carte: ");
        listerCartes(carteOffer);
        int choix = (int)(Math.random() * 2);
        int out = choix + 1;
        System.out.println(joueur.getName() + "choit "+ out);
        if (choix == 1)     // si le joueur choit la 2eme, on change la position de deux cartes
        {
            Carte carte = carteOffer.get(0);
            carteOffer.set(0,carteOffer.get(1));
            carteOffer.set(1,carte);
        }
        joueur.addPileTest(carteOffer.get(0));    // la carte face-up
        System.out.println();
        return carteOffer.get(1);       // renenvoie la carte face-down
    }

    public int takeCartes(Joueur joueur,ArrayList<Carte> cartes) {
        System.out.println(joueur.getName()+" recupere une carte");
        listerCartes(cartes);
        int choix = (int)(Math.random() * cartes.size());
        int out = choix + 1;
        System.out.println("Joueur Virtuel choit "+out);
        joueur.recupererCarte(cartes.get(choix));
        return choix;
    }

    public void listerCartes(ArrayList<Carte> cartes)       // lister tous les carte de parametre
    {
        for(int i=0;i<cartes.size();i++)
        {
            System.out.print(i+1 + " ");
            System.out.println(cartes.get(i));
        }
    }
}
