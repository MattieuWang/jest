package com.jest.models;

public class JoueurBref {
    private int type;   // 0 joueur physique, 1 joueur virtuel
    private String name;
    private int niveau;     // 0 joueur physique, 1 facile, 2 difficile

    public JoueurBref(int type, String name, int niveau) {
        this.type = type;
        this.name = name;
        this.niveau = niveau;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "JoueurBref{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", niveau=" + niveau +
                '}';
    }
}
