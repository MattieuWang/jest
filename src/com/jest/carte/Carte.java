package com.jest.carte;

public class Carte {
    private Integer id;
    private int coleur;
    private String trophie;
    private Integer valeur;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, int carteType,Integer valeur,String trophie) {
        this.id = id;
        this.coleur = carteType;
        this.trophie = trophie;
        this.valeur = valeur;
        this.joueurId = 0;
    }

    public Carte(CarteTypes carteTypes)
    {
        this.coleur = carteTypes.getCouleur();
        this.valeur = carteTypes.getValeur();
        this.trophie = carteTypes.getTrophie();
        this.joueurId = 0;
        this.id = carteTypes.getId();
    }

    @Override
    public String toString() {
        String msg = "";
        if (coleur == 4)
            msg += "SPADE";
        if (coleur == 3)
            msg += "CLUB";
        if (coleur == 2)
            msg += "DIAMOND";
        if (coleur == 1)
            msg += "HEART";
        if (coleur == 0)
            msg += "JOKER";

        if (valeur != 0)
        {
            msg += " "+valeur;
        }

        msg += " "+trophie;

        return msg;

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

    public int getColeur() {
        return coleur;
    }

    public void setColeur(int coleur) {
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
