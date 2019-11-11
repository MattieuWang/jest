package com.jest.joueur;

import com.jest.carte.Carte;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private String name;
    private String webIp;
    private ArrayList<Carte> carteOffer;
    private Integer id;
    private Integer score;
    private ArrayList<Carte> jest;
    /////
    private String imageLocaiton;

    public Joueur(Integer id, String name, String webIp, ArrayList<Carte> cartes) {
        this.name = name;
        this.webIp = webIp;
        this.id = id;
        this.carteOffer = cartes;
        this.jest = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "name='" + name + '\'' +
                ", webIp='" + webIp + '\'' +
                ", carteOffer=" + carteOffer +
                ", id=" + id +
                ", score=" + score +
                ", jest=" + jest +
                '}'+"\n";
    }

    public void ajouterCarte(Carte carte)
    {
        carteOffer.add(carte);
    }

    public void dealCarte()
    {

    }

    public void makeOffer(int choix)
    {
        // mettre le cartesOffer
        // le premier carte "face-up", le seconde "face-down"
        if (choix == 1)     // si le joueur choit la 2eme, on change la position de deux cartes
        {
            Carte carte = carteOffer.get(0);
            carteOffer.set(0,carteOffer.get(1));
            carteOffer.set(1,carte);
        }
    }

    public void takeCartes(Carte newOfferCartes)
    {
        // ajouter un carte a jest
        System.out.println(newOfferCartes);
        jest.add(newOfferCartes);

    }


    public void clearCartesOffer()
    {
        carteOffer.clear();
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebIp() {
        return webIp;
    }

    public void setWebIp(String webIp) {
        this.webIp = webIp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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
}
