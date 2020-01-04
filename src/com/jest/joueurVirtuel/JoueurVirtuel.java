package com.jest.joueurVirtuel;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.strategy.DonneeStrategy;
import com.jest.strategy.RandomStrategy;
import com.jest.strategy.Strategy;

import java.util.ArrayList;

public class JoueurVirtuel extends Joueur {
    
//    private Strategy strategy = new RandomStrategy();
//    private Strategy strategy = new DonneeStrategy();
    private Strategy strategy;

    public JoueurVirtuel(Integer id, String name,  ArrayList<Carte> cartes,Strategy strategy) {
        super(id, name, cartes);
        this.strategy = strategy;
    }

    public Carte makeOffer()
    {
        return strategy.makeOffer(this,carteOffer);
    }

    public int takeCartes(ArrayList<Carte> cartes)
    {
        return strategy.takeCartes(this,cartes);
    }


}
