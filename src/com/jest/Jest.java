package com.jest;

import com.jest.Controller.Controller;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.strategy.DonneeStrategy;
import com.jest.strategy.Strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Jest {
    public static void main(String[] args) throws Throwable {
        Strategy strategy = new DonneeStrategy();
        int nbJoueur = 1;
        int round = 1;
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String ordre = "";
        ArrayList<Carte> trophie = new ArrayList<>();
        trophie.add(controller.tirerCarteDessus(0));
        trophie.add(controller.tirerCarteDessus(0));

        controller.initJoueur("aaa","a");
        controller.initJoueur("bbb","b");
//        controller.initJoueur("ccc","c");
        controller.initJoueurVirtuel("ddd",strategy);
        controller.setTrophies(trophie);

//        System.out.println(Arrays.toString(trophie));



        while(controller.getCartes().size()-1>0)     // il y a cartes restants dans le paquet
        {
            System.out.println("------TOUR "+ round+"-------");

            if(round == 1)  // le 1er tour    deal cards
            {
                for(Joueur joueur : controller.getJoueurs())
                {
                    joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId()));
                    joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId()));
                }
            }
            else
            {
                controller.dealCartes();
            }
            round ++;

            System.out.println("paquet de cartes: " + controller.getCartes().size());

            controller.listerCarteDeJoueur();


            //make offer
            controller.makeOffers();

            //take cards
            controller.takeCartes();

            controller.listerJestDeJoueur();
            System.out.println("paquet de cartes: " + controller.getCartes().size());
        }

        // fin de joue
        controller.finDeJoue();

    }
}
