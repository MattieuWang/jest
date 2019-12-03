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
        ArrayList<Carte> trophee = new ArrayList<>();
        trophee.add(controller.tirerCarteDessus(0));
        trophee.add(controller.tirerCarteDessus(0));
        trophee.add(controller.tirerCarteDessus(0));

        controller.initJoueur("Joueur 1","a");
        controller.initJoueur("Joueur 2","b");
//        controller.initJoueur("Joueur3","c");
        controller.initJoueurVirtuel("JoueurV1",strategy);
        controller.setTrophees(trophee);

        System.out.println(trophee);



        while(controller.getCartes().size()-1>0)     // tant qu'il y a des cartes dans le paquet
        {
            System.out.println("------TOUR "+ round+"-------");

            if(round == 1)  // 1er tour    Distribution des cartes
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

            System.out.println("Nombre de cartes dans le paquet: " + controller.getCartes().size());

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
