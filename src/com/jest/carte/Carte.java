package com.jest.carte;

public class Carte {
    private Integer id;
    private int couleur;
    private String trophee;
    private Integer valeur;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, int carteType,Integer valeur,String trophie, String imageLocation) {
        this.id = id;
        this.couleur = carteType;
        this.trophee = trophee;
        this.valeur = valeur;
        this.joueurId = 0;
        this.imageLocation = imageLocation;
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
        String msg = "";
        if (valeur != 0)
        {
            msg += " "+valeur;
        }
        
        if (coleur == 4)
            msg += " de Pique";
        if (coleur == 3)
            msg += " de Tr�fle";
        if (coleur == 2)
            msg += " de Carreau";
        if (coleur == 1)
            msg += " de Coeur";
        if (coleur == 0)
            msg += "JOKER";
        
        msg += " avec le troph�e " + trophie;

        return msg;

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
