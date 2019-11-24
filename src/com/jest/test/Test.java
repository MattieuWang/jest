package com.jest.test;

import com.jest.carte.Carte;
import com.jest.carte.CarteTypes;
import com.jest.joueur.Joueur;
import com.jest.joueurVirtuel.JoueurVirtuel;
import com.jest.visitor.JoueurVisitor;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        JoueurVisitor visitor = new JoueurVisitor();
        Joueur j1 = new Joueur();
        System.out.println("--------TEST---------");

        // JOKER AVEC 4 COEURS
        j1.recupererCarte(new Carte(CarteTypes.JOKER));
        j1.recupererCarte(new Carte(CarteTypes.HEART1));
        j1.recupererCarte(new Carte(CarteTypes.HEART2));
        j1.recupererCarte(new Carte(CarteTypes.HEART3));
        j1.recupererCarte(new Carte(CarteTypes.HEART4));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 10
        j1.enleverCarte();

        // JOKER AVEC 3 COEURS
        j1.recupererCarte(new Carte(CarteTypes.JOKER));
        j1.recupererCarte(new Carte(CarteTypes.HEART1));
        j1.recupererCarte(new Carte(CarteTypes.HEART2));
        j1.recupererCarte(new Carte(CarteTypes.HEART3));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // -6
        j1.enleverCarte();

        // JOKER SANS COEUR
        j1.recupererCarte(new Carte(CarteTypes.JOKER));
        j1.recupererCarte(new Carte(CarteTypes.SPADE1));
        j1.recupererCarte(new Carte(CarteTypes.SPADE2));
        j1.recupererCarte(new Carte(CarteTypes.DIAM1));
        j1.recupererCarte(new Carte(CarteTypes.DIAM2));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 4
        j1.enleverCarte();

        // SEULEMENT ACE
        j1.recupererCarte(new Carte(CarteTypes.CLUB1));
        j1.recupererCarte(new Carte(CarteTypes.SPADE1));
        j1.recupererCarte(new Carte(CarteTypes.DIAM1));
        j1.recupererCarte(new Carte(CarteTypes.HEART1));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 12
        j1.enleverCarte();

        // paire noire
        j1.recupererCarte(new Carte(CarteTypes.SPADE1));
        j1.recupererCarte(new Carte(CarteTypes.SPADE2));
        j1.recupererCarte(new Carte(CarteTypes.CLUB1));
        j1.recupererCarte(new Carte(CarteTypes.CLUB2));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 4
        j1.enleverCarte();

        // LE NOTE PLUS IMPORTANT
        j1.recupererCarte(new Carte(CarteTypes.CLUB2));
        j1.recupererCarte(new Carte(CarteTypes.SPADE3));
        j1.recupererCarte(new Carte(CarteTypes.SPADE4));
        j1.recupererCarte(new Carte(CarteTypes.CLUB4));
        j1.recupererCarte(new Carte(CarteTypes.CLUB3));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 20
        j1.enleverCarte();

        // LE NOTE PLUS IMPORTANT
        j1.recupererCarte(new Carte(CarteTypes.JOKER));
        j1.recupererCarte(new Carte(CarteTypes.HEART2));
        j1.recupererCarte(new Carte(CarteTypes.HEART1));
        j1.recupererCarte(new Carte(CarteTypes.CLUB4));
        visitor.visit(j1);
        System.out.println(j1.getScore());  // 20
        j1.enleverCarte();


    }
}
