package com.jest.joueurVirtuel;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;

public class JoueurVirtuel extends Joueur {

    public JoueurVirtuel(Integer id, String name, String webIp, ArrayList<Carte> cartes) {
        super(id, name, webIp, cartes);
    }
}
