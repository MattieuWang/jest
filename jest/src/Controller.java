package com.jest.Controller;

import com.jest.carte.Carte;
import com.jest.carte.CarteTypes;
import com.jest.joueur.Joueur;
import com.jest.joueurVirtuel.JoueurVirtuel;

import java.util.*;


public class Controller {
    private LinkedList<Carte> cartes;        // cartes dans le paquet
    private ArrayList<Carte> cartesOffer;       // cartes a offre
    private ArrayList<Joueur> joueurs;
    private ArrayList<Carte> trophies;
    private Scanner scanner = new Scanner(System.in);
    public Controller()
    {
        cartes = new LinkedList<Carte>();
        joueurs = new ArrayList<Joueur>();
        trophies = new ArrayList<Carte>();
        cartesOffer = new ArrayList<>();
        initCartes();
//        trophies.add(tirerCarteDessus());     //SET-UP TROPHIES
//        trophies.add(tirerCarteDessus());
    }

    private void initCartes()
    {
        for(CarteTypes c : CarteTypes.values())
        {
            cartes.add(new Carte(c.getId(),c.getCouleur(),c.getValeur(),c.getTrophie()));
        }
    }

    public Carte tirerCarteDessus(int joueurId)
    {
        Collections.shuffle(cartes);
        Carte carte = cartes.poll();
        carte.setJoueurId(joueurId);
        return carte;
    }

    public void initJoueur(String joueurName, String webIp)
    {
        ArrayList<Carte> c = new ArrayList<>();
        joueurs.add(new Joueur(joueurs.size()+1,joueurName,webIp,c));
    }

    public void initJoueurVirtuel(String joueurName)
    {
        ArrayList<Carte> c = new ArrayList<>();
        joueurs.add(new JoueurVirtuel(joueurs.size()+1,joueurName,c));
    }

    public void dealCartes()
    {
        // recuperer les cartes "face-up"
        // mettre le face-up carte dans le paquet
        for (Joueur joueur : joueurs)
        {
            cartes.add(joueur.getCarteOffer().get(0));      // supprose que le 1er carte dans carteOffer est "face up"
            joueur.clearCartesOffer();                      // enleve tous les cartes dans cartesOffer, 1er est "faceup" 2eme est met comme jest
        }

        // diffuser 2 cartes a chaque joueur
        for (Joueur joueur : joueurs)
        {
            ArrayList<Carte> ctmp = new ArrayList<>();      // cartes temporelles
            ctmp.add(tirerCarteDessus(joueur.getId()));
            ctmp.add(tirerCarteDessus(joueur.getId()));
            joueur.setCarteOffer(ctmp);
        }
    }

    public void makeOffers()
    {
        for (Joueur joueur : joueurs)
        {
//            System.out.print(joueur.getName()+" ");
//            System.out.println("choisir un carte deviens face-up: ");
//            listerCartes(joueur.getCarteOffer());
//            int choix_carte;
//            do {
//                System.out.print("entrez votre choix: ");
//                choix_carte = scanner.nextInt();
//            }while (choix_carte != 1 && choix_carte != 2 );
//
//            joueur.makeOffer(choix_carte-1);
//            cartesOffer.add(joueur.getCarteOffer().get(1));     // ajoute la face-up carte au paquet de cartes à offre
            cartesOffer.add(joueur.makeOffer());
        }
    }


    public void listerCartes(ArrayList<Carte> cartes)       // lister tous les carte de parametre
    {
        for(int i=0;i<cartes.size();i++)
        {
            System.out.print(i+1 + " ");
            System.out.println(cartes.get(i));
        }
    }


    public void takeCartes()
    {
        System.out.println("--------DEMANDER LA CARTE--------");
        for (Joueur joueur : joueurs)
        {
//            int carte_choix=0;
//            boolean flag = false;
//            while(!flag)
//            {
//                listerCartes(cartesOffer);
//                System.out.print(joueur.getName()+", ");
//                System.out.print("Choisissez une carte comme votre carte de Jest: ");
//                carte_choix = scanner.nextInt();
//                if(carte_choix>=1 && carte_choix<= cartesOffer.size())
//                {
//                    if(cartesOffer.get(carte_choix-1).getJoueurId() == joueur.getId() && cartesOffer.size()>1)
//                    {
//                        flag = false;
//                        System.out.println("Desolez, vous ne pouviez pas choisir votre carte");
//                    }
//                    else
//                    {
//                        flag = true;
//                    }
//                }
//            }

            int choix = joueur.takeCartes(cartesOffer);
            cartesOffer.remove(choix-1);
            System.out.println();

        }
    }

    public void listerJestDeJoueur()
    {
        System.out.println("--------JEST--------");
        for(Joueur joueur : joueurs)
        {
            System.out.println(joueur.getName());
            listerCartes(joueur.getJest());
        }
    }



    public void finDeJoue(ArrayList<Carte>trophie)
    {
        listerCartes(trophie);
        System.out.println("fin de joue");
    }

    private void comparerFaceupCarte()
    {
        //  mettre la sequence de joueurs pour takeCarte
    }


    public void listerCarteDeJoueur()
    {
        for (Joueur joueur : joueurs)
        {
            System.out.println(joueur.getName()+": "+joueur.getCarteOffer());
        }
        System.out.println();
    }

    public ArrayList<Joueur> getJoueurs() {
        return joueurs;
    }

    public List<Carte> getCartes() {
        return cartes;
    }

    public ArrayList<Carte> getTrophies() {
        return trophies;
    }

}
