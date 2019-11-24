package com.jest.strategy;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;

public interface Strategy {
    public Carte makeOffer(Joueur joueur,ArrayList<Carte>carteOffer);
    public int takeCartes(Joueur joueur,ArrayList<Carte>cartes);
}
