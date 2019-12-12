package com.jest.joueur;

public class Score {
    private int face_valeur;
    private int jest_valeur;
    private boolean avecJoker;
    private int nb_2;
    private int nb_3;
    private int nb_4;
    private int value_heart;
    private int value_diam;
    private int value_spade;
    private int value_club;

    public Score() {
        face_valeur = 0;
        jest_valeur = 0;
        avecJoker = false;
        nb_2 = 0;
        nb_3 = 0;
        nb_4 = 0;
        value_club = 0;
        value_diam = 0;
        value_heart = 0;
        value_spade = 0;

    }


    public Score(int face_valeur, int jest_valeur, boolean avecJoker, int nb_2, int nb_3, int nb_4, int value_heart, int value_diam, int value_spade, int value_club) {
        this.face_valeur = face_valeur;
        this.jest_valeur = jest_valeur;
        this.avecJoker = avecJoker;
        this.nb_2 = nb_2;
        this.nb_3 = nb_3;
        this.nb_4 = nb_4;
        this.value_heart = value_heart;
        this.value_diam = value_diam;
        this.value_spade = value_spade;
        this.value_club = value_club;
    }

    public int getFace_valeur() {
        return face_valeur;
    }

    public void setFace_valeur(int face_valeur) {
        this.face_valeur = face_valeur;
    }

    public int getJest_valeur() {
        return jest_valeur;
    }

    public void setJest_valeur(int jest_valeur) {
        this.jest_valeur = jest_valeur;
    }

    public boolean isAvecJoker() {
        return avecJoker;
    }

    public void setAvecJoker(boolean avecJoker) {
        this.avecJoker = avecJoker;
    }

    public int getNb_2() {
        return nb_2;
    }

    public void setNb_2(int nb_2) {
        this.nb_2 = nb_2;
    }

    public int getNb_3() {
        return nb_3;
    }

    public void setNb_3(int nb_3) {
        this.nb_3 = nb_3;
    }

    public int getNb_4() {
        return nb_4;
    }

    public void setNb_4(int nb_4) {
        this.nb_4 = nb_4;
    }

    public int getValue_heart() {
        return value_heart;
    }

    public void setValue_heart(int value_heart) {
        this.value_heart = value_heart;
    }

    public int getValue_diam() {
        return value_diam;
    }

    public void setValue_diam(int value_diam) {
        this.value_diam = value_diam;
    }

    public int getValue_spade() {
        return value_spade;
    }

    public void setValue_spade(int value_spade) {
        this.value_spade = value_spade;
    }

    public int getValue_club() {
        return value_club;
    }

    public void setValue_club(int value_club) {
        this.value_club = value_club;
    }

    @Override
    public String toString() {
        return "Score{" +
                "jest_valeur=" + jest_valeur +
                ", avecJoker=" + avecJoker +
                ", nb_2=" + nb_2 +
                ", nb_3=" + nb_3 +
                ", nb_4=" + nb_4 +
                ", value_heart=" + value_heart +
                ", value_diam=" + value_diam +
                ", value_spade=" + value_spade +
                ", value_club=" + value_club +
                '}';
    }
}
