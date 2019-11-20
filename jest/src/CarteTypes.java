package com.jest.carte;

public enum CarteTypes {
    JOKER(0,"JOKER",0,"BEST_JEST"),
    HEART5(1,"HEART",5,"JOKER"),HEART4(2,"HEART",4,"JOKER"),
    HEART3(3,"HEART",3,"JOKER"),HEART2(4,"HEART",2,"JOKER"),
    SPADE5(5,"SPADE",5,"HIGHEST"),SPADE4(6,"SPADE",4,"LOWEST"),
    SPADE3(7,"SPADE",3,"2CARDS"),SPADE2(8,"SPADE",2,"MAJORITY"),
    CLUB5(9,"CLUB",5,"HIGHEST"),CLUB4(10,"CLUB",4,"LOWEST"),
    CLUB3(11,"CLUB",3,"HIGHEST"),CLUB2(12,"CLUB",2,"LOWEST"),
    DIAM5(13,"DIAM",5,"4CARDS"),DIAM4(14,"DIAM",4,"BEST_JEST_NO_JOKER"),
    DIAM3(15,"DIAM",3,"LOWEST"),DIAM2(16,"DIAM",2,"HIGHEST")
//    ,REFER(17,"REFER",null)
    ;
    private Integer id;
    private String couleur;
    private String trophie;
    private Integer valeur;

    CarteTypes(Integer id, String couleur,Integer valeur, String trophie) {
        this.id = id;
        this.couleur = couleur;
        this.trophie = trophie;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public String getCouleur() {
        return couleur;
    }

    public String getTrophie() {
        return trophie;
    }

    public Integer getValeur() {
        return valeur;
    }
}
