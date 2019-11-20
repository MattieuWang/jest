package com.jest.carte;

public class Carte {
    private Integer id;
    private String carteType;
    private String trophie;
    private Integer joueurId;
    //////
    private String imageLocation;

    public Carte(Integer id, String carteType,String trophie) {
        this.id = id;
        this.carteType = carteType;
        this.trophie = trophie;
        this.joueurId = 0;
    }


    @Override
    public String toString() {
        return "Carte{" +
                "id=" + id +
                ", carteType='" + carteType + '\'' +
                ", trophie='" + trophie + '\'' +
                ", joueurId=" + joueurId +
                ", imageLocation='" + imageLocation + '\'' +
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

    public String getCarteType() {
        return carteType;
    }

    public void setCarteType(String carteType) {
        this.carteType = carteType;
    }

    public Integer getJoueurId() {
        return joueurId;
    }

    public void setJoueurId(Integer joueurId) {
        this.joueurId = joueurId;
    }
}
