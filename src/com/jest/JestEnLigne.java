package com.jest;

import com.jest.Controller.Controller;
import com.jest.Controller.ViewController;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.strategy.DonneeStrategy;
import com.jest.strategy.RandomStrategy;
import com.jest.strategy.Strategy;

import java.util.ArrayList;
import java.util.Scanner;

public class JestEnLigne {
    /*
    public static void main(String[] args) throws Throwable {
        Strategy strategy = new DonneeStrategy();
        Strategy strategy1 = new RandomStrategy();
        int nbJoueur = 1;
        int round = 1;
        Scanner scanner = new Scanner(System.in);
        Controller controller = Controller.getInstance();
        ViewController viewController = new ViewController();
        String ordre = "";
        ArrayList<Carte> trophie = new ArrayList<>();

        String choix_str = "";
        do {
            System.out.print("Entrez le nombre de joueur virtuel (2 ou 3): ");
            choix_str = scanner.nextLine().trim();
        }while (!choix_str.equals("2")&&!choix_str.equals("3"));
        nbJoueur = Integer.parseInt(choix_str);


        if (nbJoueur == 2)
        {
            trophie.add(controller.tirerCarteDessus(0));
            trophie.add(controller.tirerCarteDessus(0));

            controller.initJoueur("joueur1","a");
            controller.initJoueurVirtuel("jv1",strategy);
            controller.initJoueurVirtuel("jv2",strategy1);
        }
        else if (nbJoueur == 3)
        {
            trophie.add(controller.tirerCarteDessus(0));
            controller.initJoueur("joueur1","a");
            controller.initJoueurVirtuel("jv1",strategy);
            controller.initJoueurVirtuel("jv2",strategy1);
            controller.initJoueurVirtuel("jv3",strategy1);
        }

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

     */
}
