package com.jest.carte;

public class Carte {
    private Integer id;
    private int couleur;
    private String trophee;
    private Integer valeur;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, int carteType,Integer valeur,String trophee) {
        this.id = id;
        this.couleur = carteType;
        this.trophee = trophee;
        this.valeur = valeur;
        this.joueurId = 0;
    }

    public Carte(CarteTypes carteTypes)
    {
        this.couleur = carteTypes.getCouleur();
        this.valeur = carteTypes.getValeur();
        this.trophee = carteTypes.getTrophee();
        this.joueurId = 0;
        this.id = carteTypes.getId();
    }

    @Override
    public String toString() {
        return valeur +
        		" de " + 
        		couleur +
        		" trophee: " +
        		trophee;
    }

    public String getTrophee() {
        return trophee;
    }

    public void setTrophee(String trophee) {
        this.trophee = trophee;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
}
