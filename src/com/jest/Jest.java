package com.jest;

import com.jest.Controller.Controller;
import com.jest.Controller.ViewController;
import com.jest.carte.Carte;
import com.jest.joueur.Joueur;
import com.jest.models.JoueurBref;
import com.jest.strategy.DonneeStrategy;
import com.jest.strategy.RandomStrategy;
import com.jest.strategy.Strategy;
import java.util.ArrayList;

public class Jest {
    public static void main(String[] args) throws Throwable {
        Strategy strategyDonnee = new DonneeStrategy();
        Strategy strategyRandom = new RandomStrategy();
        Controller controller = Controller.getInstance();
        ViewController viewController = ViewController.getInstance();

        while (true) {
            int nbJoueur = 1;
            int round = 1;
            ArrayList<Carte> trophie = new ArrayList<>();
//        String choix_str = "";
//        do {
//            System.out.print("Entrez le nombre de joueur virtuel (2 ou 3): ");
//            choix_str = scanner.nextLine().trim();
//        }while (!choix_str.equals("2")&&!choix_str.equals("3"));
//        nbJoueur = Integer.parseInt(choix_str);

            viewController.doStartRequire();
            while (nbJoueur <= 1) {
                nbJoueur = viewController.getNbJoueurs();
//            System.out.println(nbJoueur);
                System.out.print("");
            }

            viewController.doChoixView();


            if (nbJoueur == 2) {
                trophie.add(controller.tirerCarteDessus(0));
                trophie.add(controller.tirerCarteDessus(0));
//
//                controller.initJoueur("joueur1");
//                controller.initJoueurVirtuel("jv1", strategy);
//                controller.initJoueurVirtuel("jv2", strategy1);
            } else if (nbJoueur == 3) {
                trophie.add(controller.tirerCarteDessus(0));
//                controller.initJoueur("joueur1");
//                controller.initJoueurVirtuel("jv1", strategy);
//                controller.initJoueurVirtuel("jv2", strategy1);
//                controller.initJoueurVirtuel("jv3", strategy1);
            }

            controller.setTrophies(trophie);

            for (JoueurBref j : viewController.getJoueurChoix())
            {
                if (j.getType() == 0)
                {
                    controller.initJoueur(j.getName());
                }
                else if (j.getType() == 1)
                {
                    if (j.getNiveau() == 1)
                        controller.initJoueurVirtuel(j.getName(),strategyRandom);
                    else
                        controller.initJoueurVirtuel(j.getName(),strategyDonnee);
                }
            }

            ViewController.afficherTrophie(trophie);

//        System.out.println(Arrays.toString(trophie));


            while (controller.getCartes().size() - 1 > 0)     // il y a cartes restants dans le paquet
            {
                System.out.println("------TOUR " + round + "-------");

                if (round == 1)  // le 1er tour    deal cards
                {
                    for (Joueur joueur : controller.getJoueurs()) {
                        joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId()));
                        joueur.ajouterCarte(controller.tirerCarteDessus(joueur.getId()));



                    }
//                    viewController.doMakeOfferView(controller.getJoueurs());
                } else {
                    controller.dealCartes();
                }
                for (Joueur joueur : controller.getJoueurs())
                {
                    ViewController.afficherCarteDeJoueur(joueur);
                }
                ViewController.afficherNomJoueur(controller.getJoueurs());

                round++;

                System.out.println("paquet de cartes: " + controller.getCartes().size());

                controller.listerCarteDeJoueur();


                //make offer
                controller.makeOffers();
//                viewController.doMakeOfferView(controller.getJoueurs());

                //take cards
                controller.takeCartes();



                ViewController.afficherJest(controller.getJoueurs());

                controller.listerJestDeJoueur();
                System.out.println("paquet de cartes: " + controller.getCartes().size());
            }

            // fin de joue
            controller.finDeJoue();
            ViewController.afficherJestFinal(controller.getJoueurs());

            viewController.doFinDeJeu(controller.getResultat());
        }
    }
}
