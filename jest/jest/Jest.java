package com.jest;

import com.jest.Controller.Controller;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;

import java.util.Scanner;

public class Jest {
    public static void main(String[] args) throws Throwable {
        int nbJoueur = 1;
        int round = 1;
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        String ordre = "";


        controller.initJoueur("aaa","a");
        controller.initJoueur("bbb","b");
        controller.initJoueur("ccc","c");
        Carte c1 = controller.giveRandomCard(0);
        Carte c2 = controller.giveRandomCard(0);



        while(controller.getCartes().size()-1>0)     // il y a cartes restants dans le paquet
        {
            System.out.println("------TOUR "+ round+"-------");

            if(round == 1)  // le 1er tour    deal cards
            {
                for(Joueur joueur : controller.getJoueurs())
                {
                    joueur.ajouterCarte(controller.giveRandomCard(joueur.getId()));
                    joueur.ajouterCarte(controller.giveRandomCard(joueur.getId()));
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
