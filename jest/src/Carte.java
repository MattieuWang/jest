package com.jest.carte;

public class Carte {
    private Integer id;
    private String coleur;
    private String trophie;
    private Integer valeur;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, String carteType,Integer valeur,String trophie) {
        this.id = id;
        this.coleur = carteType;
        this.trophie = trophie;
        this.valeur = valeur;
        this.joueurId = 0;
    }

    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", coleur='" + coleur + '\'' +
                ", trophie='" + trophie + '\'' +
                ", valeur=" + valeur +
                ", joueurId=" + joueurId +
                '}';
    }

    public String getTrophie() {
        return trophie;
    }

    public void setTrophie(String trophie) {
        this.trophie = trophie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColeur() {
        return coleur;
    }

    public void setColeur(String coleur) {
        this.coleur = coleur;
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
