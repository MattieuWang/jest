package com.jest.carte;

public class Carte {
    private Integer id;
    private int coleur;
    private String trophie;
    private Integer valeur;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, int carteType,Integer valeur,String trophie, String imageLocation) {
        this.id = id;
        this.coleur = carteType;
        this.trophie = trophie;
        this.valeur = valeur;
        this.joueurId = 0;
        this.imageLocation = imageLocation;
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
        if (valeur != 0)
        {
            msg += " "+valeur;
        }
        
        if (coleur == 4)
            msg += " de Pique";
        if (coleur == 3)
            msg += " de Trêfle";
        if (coleur == 2)
            msg += " de Carreau";
        if (coleur == 1)
            msg += " de Coeur";
        if (coleur == 0)
            msg += "JOKER";
        
        msg += " avec le trophée " + trophie;

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

    public String getImageLocation() {
		return imageLocation;
	}

	public void setImageLocation(String imageLocation) {
		this.imageLocation = imageLocation;
	}

	public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }
}
