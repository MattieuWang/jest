package com.jest.Controller;

import com.jest.carte.Carte;
import com.jest.carte.CarteTypes;
import com.jest.joueur.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Controller {
    private ArrayList<Carte> cartes;
    private ArrayList<Carte> cartesOffer;
    private ArrayList<Joueur> joueurs;
    private ArrayList<Carte> trophies;
    public Controller()
    {
        cartes = new ArrayList<Carte>();
        joueurs = new ArrayList<Joueur>();
        trophies = new ArrayList<Carte>();
        initCartes();
        trophies.add(giveRandomCard());     //SET-UP TROPHIES
        trophies.add(giveRandomCard());
    }

    private void initCartes()
    {
        for(CarteTypes c : CarteTypes.values())
        {
            cartes.add(new Carte(c.getId(),c.getCarteType(),c.getTrophie()));
        }
    }

    private Carte giveRandomCard()
    {
        Random random = new Random();
        int randomId = random.nextInt(cartes.size()-1)+1;
        Carte carte = cartes.get(randomId);
        cartes.remove(randomId);
        System.out.println(cartes.size());
        return carte;
    }

    public void initJoueur(String joueurName, String webIp)
    {
        ArrayList<Carte> c = new ArrayList<>();
        c.add(giveRandomCard());
        c.add(giveRandomCard());
        joueurs.add(new Joueur(joueurs.size(),joueurName,webIp,c));
    }

    public void dealCartes()
    {
        // recuperer les cartes "face-up"
        for (Joueur joueur : joueurs)
        {
            cartes.add(joueur.getCarteOffer().get(0));
            joueur.clearCartesOffer();
        }

        // diffuser 2 cartes a chaque joueur
        for (Joueur joueur : joueurs)
        {
            ArrayList<Carte> ctmp = new ArrayList<>();
            ctmp.add(giveRandomCard());
            ctmp.add(giveRandomCard());
            joueur.setCarteOffer(ctmp);
        }
    }

    public void makeOffers()
    {
        for (Joueur joueur : joueurs)
        {
            joueur.makeOffer();
        }
    }
    public void takeCartes()
    {

    }

    public void comparerFaceupCarte()
    {
        //  mettre la sequence de joueurs pour takeCarte
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
