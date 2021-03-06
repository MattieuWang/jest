package com.jest.joueur;

import com.jest.Controller.ViewController;
import com.jest.carte.Carte;
import com.jest.visitor.Visitor;

import javax.swing.text.View;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Joueur {
    protected String name;
    protected ArrayList<Carte> carteOffer;
    protected Integer id;
    protected ArrayList<Carte> jest;
    protected Score score;
    protected ArrayList<Carte> faceup;
    protected int gagne;
    protected int type;     // 0 joueur P   1 joueur V
    /////
    private String imageLocaiton;

    public Joueur(Integer id, String name, ArrayList<Carte> cartes,int type) {
        this.name = name;
        this.id = id;
        this.carteOffer = cartes;
        this.jest = new ArrayList<>();
        this.score = new Score();
        this.faceup = new ArrayList<>();
        this.gagne = 0;
        this.type = type;
    }

    public Joueur() {
        name = "test";
        id = 0;
        jest = new ArrayList<>();
        score = new Score();
    }

    public void accept(Visitor visitor)
    {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", score=" + score +
                ", carteOffer="+ carteOffer+
                ", jest=" + jest +
                ", faceup=" + faceup +
                ", type=" + type +
                '}';
    }

    public void ajouterCarte(Carte carte)
    {
        carteOffer.add(carte);
    }

    public void dealCarte()
    {

    }


    public Carte makeOffer()
    {
        int choix_carte = 0;
//        Scanner scanner = new Scanner(System.in);
//        System.out.print(name+" ");
//        System.out.println("choisir un carte deviens face-up: ");
//        listerCartes(carteOffer);
//        String choix_str = "";
//            do {
//                System.out.print("entrez votre choix: ");
//                choix_str = scanner.nextLine().trim();
//            } while (!choix_str.equals("1") && !choix_str.equals("2"));
//            choix_carte = Integer.parseInt(choix_str);
        ViewController.doMakeOfferView(this);
        choix_carte = ViewController.getChoixDeJoueur(this);
            choix_carte--;             // on suppose que le 1er carte est le face-up carte
        if (choix_carte == 1)     // si le joueur choit la 2eme, on change la position de deux cartes
        {
            Carte carte = carteOffer.get(0);
            carteOffer.set(0,carteOffer.get(1));
            carteOffer.set(1,carte);
        }
        carteOffer.get(0).setVisible(true);////////////////////
        faceup.add(carteOffer.get(0));
        return carteOffer.get(1);
    }


//    public void takeCartes(Carte newOfferCartes)
//    {
//        // ajouter un carte a jest
//        System.out.println(newOfferCartes);
//        jest.add(newOfferCartes);
//
//    }


    public int takeCartes(ArrayList<Carte> cartes)
    {
        Scanner scanner = new Scanner(System.in);
        int carte_choix=0;
        boolean flag = false;
//        while(!flag)
//        {
//                listerCartes(cartes);
//                String choix_str = "";
//                do {
//                    System.out.print(name+", ");
//                    System.out.print("Choisissez une carte comme votre carte de Jest: ");
//                    choix_str = scanner.nextLine().trim();
//                }while (!choix_str.equals("1")&&!choix_str.equals("2")&&!choix_str.equals("3")&&!choix_str.equals("4"));    ///////////////////
//                carte_choix = Integer.parseInt(choix_str);
//                if(carte_choix>=1 && carte_choix<= cartes.size())
//                {
//                    if(cartes.get(carte_choix-1).getJoueurId() == id && cartes.size()>1)
//                    {
//                        flag = false;
//                        System.out.println("Desolez, vous ne pouviez pas choisir votre carte");
//                    }
//                    else
//                    {
//                        flag = true;
//                    }
//                }
//                else
//                    flag = false;
//        }


        ViewController.doTakeCardView(this,cartes);
        carte_choix = ViewController.getTakeCardChoix();
        jest.add(cartes.get(carte_choix));



        return carte_choix;
    }

    public void listerCartes(ArrayList<Carte> cartes)       // lister tous les carte de parametre
    {
        for(int i=0;i<cartes.size();i++)
        {
            System.out.print(i+1 + " ");
            System.out.println(cartes.get(i));
        }
    }

    public void recupererCarte(Carte carte)
    {
        jest.add(carte);
    }
    public void enleverCarte()
    {
        jest.clear();
    }
    public void enleverCartesOffer()
    {
        carteOffer.clear();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public ArrayList<Carte> getCartes() {
        return jest;
    }

    public void setCartes(ArrayList<Carte> cartes) {
        this.jest = cartes;
    }

    public ArrayList<Carte> getCarteOffer() {
        return carteOffer;
    }

    public void setCarteOffer(ArrayList<Carte> carteOffer) {
        this.carteOffer = carteOffer;
    }

    public ArrayList<Carte> getJest() {
        return jest;
    }

    public void setJest(ArrayList<Carte> jest) {
        this.jest = jest;
    }

    public ArrayList<Carte> getFaceup() {
        return faceup;
    }

    public void setFaceup(ArrayList<Carte> faceup) {
        this.faceup = faceup;
    }
    public void addPileTest(Carte carte){
        faceup.add(carte);}

    public int getGagne() {
        return gagne;
    }

    public void addGagne() {
        this.gagne ++;
    }

    public int getType() {
        return type;
    }
}
