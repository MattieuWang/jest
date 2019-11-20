package com.jest.joueurVirtuel;

import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class JoueurVirtuel extends Joueur {

    public JoueurVirtuel(Integer id, String name,  ArrayList<Carte> cartes) {
        super(id, name, "", cartes);
    }

    public Carte makeOffer()
    {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(name+" ");
//        System.out.println("choisir un carte deviens face-up: ");
//        System.out.println(carteOffer);
//        int choix_carte = 0;
//        do {
//            System.out.print("entrez votre choix: ");
//            choix_carte = scanner.nextInt();
//        }while (choix_carte != 1 && choix_carte != 2 );
//        choix_carte --;
//        if (choix_carte == 1)     // si le joueur choit la 2eme, on change la position de deux cartes
//        {
//            Carte carte = carteOffer.get(0);
//            carteOffer.set(0,carteOffer.get(1));
//            carteOffer.set(1,carte);
//        }
        listerCartes(carteOffer);
        System.out.println("Joueur virtuel choix 2");
        return carteOffer.get(1);
    }

    public int takeCartes(ArrayList<Carte> cartes)
    {
        listerCartes(cartes);
        System.out.println("Joueur Virtuel choit 1");
        jest.add(cartes.get(0));
        return 1;
    }


}
