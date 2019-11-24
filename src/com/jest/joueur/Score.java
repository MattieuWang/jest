package com.jest.joueur;

public class Score {
    private int face_valeur;
    private int jest_valeur;
    private boolean avecJoker;
    private int nb_2;
    private int nb_3;
    private int nb_4;

    public Score() {
        face_valeur = 0;
        jest_valeur = 0;
        avecJoker = false;
        nb_2 = 0;
        nb_3 = 0;
        nb_4 = 0;

    }


    public Score(int face_valeur, int jest_valeur, boolean avecJoker, int nb_2, int nb_3, int nb_4) {
        this.face_valeur = face_valeur;
        this.jest_valeur = jest_valeur;
        this.avecJoker = avecJoker;
        this.nb_2 = nb_2;
        this.nb_3 = nb_3;
        this.nb_4 = nb_4;
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



    @Override
    public String toString() {
        return "Score{" +
                "face_valeur=" + face_valeur +
                ", jest_valeur=" + jest_valeur +
                ", avecJoker=" + avecJoker +
                '}';
    }
}
