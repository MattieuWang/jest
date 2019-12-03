package com.jest.Controller;

import com.jest.carte.Carte;
import com.jest.carte.CarteTypes;
import com.jest.comparateur.Comparateur;
import com.jest.joueur.Joueur;
import com.jest.joueurVirtuel.JoueurVirtuel;
import com.jest.strategy.Strategy;
import com.jest.visitor.JoueurVisitor;

import java.io.*;
import java.util.*;


public class Controller {
    private LinkedList<Carte> cartes;        // cartes dans le paquet
    private ArrayList<Carte> cartesOffer;       // cartes a offre
    private ArrayList<Joueur> joueurs;
    private ArrayList<Carte> trophees;
    private int noteMax = 0;
    private static int foisGagne[] = new int[3];

    private JoueurVisitor visitor = new JoueurVisitor();
    private Comparateur comparateur = new Comparateur();

    public Controller()
    {
        cartes = new LinkedList<Carte>();
        joueurs = new ArrayList<Joueur>();
        trophees = new ArrayList<Carte>();
        cartesOffer = new ArrayList<>();
        initCartes();
//        trophees.add(tirerCarteDessus());     //SET-UP tropheeS
//        trophees.add(tirerCarteDessus());
    }

    public void initTous()
    {
        cartes.clear();
        joueurs.clear();
        trophees.clear();
        cartesOffer.clear();
        initCartes();
    }

    private void initCartes()
    {
        for(CarteTypes c : CarteTypes.values())
        {
            cartes.add(new Carte(c.getId(),c.getCouleur(),c.getValeur(),c.getTrophee()));
        }
    }

    public Carte tirerCarteDessus(int joueurId)
    {
        Collections.shuffle(cartes);
        Carte carte = cartes.poll();
//        listerCartes(cartes);
        carte.setJoueurId(joueurId);
        return carte;
    }

    public void initJoueur(String joueurName, String webIp)
    {
        ArrayList<Carte> c = new ArrayList<>();
        joueurs.add(new Joueur(joueurs.size()+1,joueurName,webIp,c));
    }

    public void initJoueurVirtuel(String joueurName, Strategy strategy)
    {
        ArrayList<Carte> c = new ArrayList<>();
        joueurs.add(new JoueurVirtuel(joueurs.size()+1,joueurName,c,strategy));
    }

    public void dealCartes()
    {
        // recuperer les cartes "face-up"
        // mettre le face-up carte dans le paquet
        for (Joueur joueur : joueurs)
        {
            cartes.add(joueur.getCarteOffer().get(0));      // supprose que le 1er carte dans carteOffer est "face up"
//            System.out.println("recycle face up carte-------"+joueur.getCarteOffer().get(0));
            joueur.enleverCartesOffer();                      // enleve tous les cartes dans cartesOffer, 1er est "faceup" 2eme est met comme jest
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

    public void listerCartes(LinkedList<Carte> cartes)       // lister tous les carte de parametre
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
        joueurs = comparateur.comparerFaceupValue(joueurs);
        for (Joueur joueur : joueurs)
        {
            int choix = joueur.takeCartes(cartesOffer);
            cartesOffer.remove(choix);
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



    public void finDeJoue() {
        listerCartes(trophees);

        for (Joueur joueur : joueurs)
        {
            joueur.accept(visitor);
            System.out.println(joueur.getScore());
        }
        System.out.println("Donner les trophees");
        comparateur.comparertrophee(joueurs,trophees);

        System.out.println();
        System.out.println("Apres les trophees");
        for (Joueur joueur : joueurs)
        {
            joueur.accept(visitor);
            System.out.println(joueur.getScore());
        }



        Joueur j_note_max = joueurs.get(0);

        for (Joueur joueur : joueurs)
        {
            if(joueur.getScore().getJest_valeur() > j_note_max.getScore().getJest_valeur())
            {
                j_note_max = joueur;
            }
        }

        System.out.println("fin de joue");
        System.out.println(j_note_max);
        noteMax = j_note_max.getScore().getJest_valeur();
        j_note_max.addGagne();
        foisGagne[j_note_max.getId()-1]++;

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resultat.csv",true)));

            for (Carte c : j_note_max.getJest())
            {
                writer.write(c.getId()+"");
                writer.write(",");
            }
            if (j_note_max.getJest().size() == 4)
            {

                writer.write("-1,");
                writer.write("-1,");
            }
            if (j_note_max.getJest().size() == 5)
                writer.write("-1,");
            for (Carte c : j_note_max.getPileTest())
            {
                writer.write(c.getId()+"");
                writer.write(",");
            }
            writer.write(j_note_max.getScore().getFace_valeur()+"");
            writer.write("\n");
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Joueur joueur:joueurs)
        {
            System.out.println(joueur.getName()+" "+joueur.getGagne());
        }

    }


    public int getNoteMax(){return noteMax;}


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

    public ArrayList<Carte> getTrophees() {
        return trophees;
    }

    public void setTrophees(ArrayList<Carte> trophees) {
        this.trophees = trophees;
    }

    public void getFoisGagne()
    {
        for (int i = 0;i<foisGagne.length;i++)
        {
            System.out.println(foisGagne[i]);
        }
    }
}
