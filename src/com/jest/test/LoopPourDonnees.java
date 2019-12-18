package com.jest.test;

import com.jest.Controller.Controller;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.joueurVirtuel.JoueurVirtuel;
import com.jest.strategy.DonneeStrategy;
import com.jest.strategy.RandomStrategy;
import com.jest.strategy.Strategy;

import java.util.ArrayList;

public class LoopPourDonnees {
    public static void main(String[] args) {
        int n = 0;
        Strategy randomStrategy = new RandomStrategy();
        Strategy donneeStrategy = new DonneeStrategy();

        Controller controller = Controller.getInstance();
        int noteSum = 0;
        while (n<1)
        {
            n++;

            controller.initJoueurVirtuel("jv1",donneeStrategy, 100, 200);
            controller.initJoueurVirtuel("jv2",randomStrategy, 200, 300);
            controller.initJoueurVirtuel("jv3",randomStrategy, 300, 400);
            controller.initJoueurVirtuel("jv4",randomStrategy, 400, 500);

            ArrayList<Carte> trophie = new ArrayList<>();
            trophie.add(controller.tirerCarteDessus(0,0,0));
//            trophie.add(controller.tirerCarteDessus(0));

            controller.setTrophies(trophie);
            int round = 1;

            while(controller.getCartes().size()-1>0)     // il y a cartes restants dans le paquet
            {
                System.out.println("------TOUR "+ round+"-------");

                if(round == 1)  // le 1er tour    deal cards
                {
                    for(Joueur joueur : controller.getJoueurs())
                    {
                        joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId(),joueur.getPositionJoueurX(), joueur.getPositionJoueurY()));
                        joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId(),joueur.getPositionJoueurX() + 100, joueur.getPositionJoueurY()));
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
            noteSum += controller.getNoteMax();

            controller.initTous();
        }
        double noteMoyenne = (noteSum+0.0)/n;
        System.out.println("note moyenne: " + noteMoyenne);
        controller.getFoisGagne();



    }
}

























