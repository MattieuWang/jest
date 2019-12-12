package com.jest.carte;

public enum CarteTypes {

    // couleur: 0 JOKER, 1 HEART, 2 DIAM, 3 CLUB, 4 SPADE
    //


    JOKER(0,0,0,"BEST_JEST"),
    HEART1(1,1,1,"JOKER"),HEART4(2,1,4,"JOKER"),
    HEART3(3,1,3,"JOKER"),HEART2(4,1,2,"JOKER"),
    SPADE1(5,4,1,"HIGHESTCLUB"),SPADE4(6,4,4,"LOWESTCLUB"),
    SPADE3(7,4,3,"2"),SPADE2(8,4,2,"3"),
    CLUB1(9,3,1,"HIGHESTSPADE"),CLUB4(10,3,4,"LOWESTSPADE"),
    CLUB3(11,3,3,"HIGHESTSPADE"),CLUB2(12,3,2,"LOWESTSPADE"),
    DIAM1(13,2,1,"4"),DIAM4(14,2,4,"BEST_JEST_NO_JOKER"),
    DIAM3(15,2,3,"LOWESTDIAM"),DIAM2(16,2,2,"HIGHESTDIAM")
//    ,REFER(17,"REFER",null)
    ;
    private Integer id;
    private int couleur;
    private String trophie;
    private Integer valeur;
//    public static final String HEART = "HEART";
//    public static final String CLUB = "CLUB";
//    public static final String DIAM = "DIAM";
//    public static final String SPADE = "SPADE";
//    public static final String JOKE = "JOKER";

    CarteTypes(Integer id, int couleur,Integer valeur, String trophie) {
        this.id = id;
        this.couleur = couleur;
        this.trophie = trophie;
        this.valeur = valeur;
    }

    public Integer getId() {
        return id;
    }

    public int getCouleur() {
        return couleur;
    }

    public String getTrophie() {
        return trophie;
    }

    public Integer getValeur() {
        return valeur;
    }
}
