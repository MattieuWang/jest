package com.jest.carte;

public enum CarteTypes {

    // couleur: 0 JOKER, 1 HEART, 2 DIAM, 3 CLUB, 4 SPADE
    //


    JOKER(0,0,0,"BEST_JEST","src/images/Joker.PNG"),
    HEART1(1,1,1,"JOKER","src/images/5Co.PNG"),HEART4(2,1,4,"JOKER","src/images/4Co.PNG"),
    HEART3(3,1,3,"JOKER","src/images/3Co.PNG"),HEART2(4,1,2,"JOKER","src/images/2Co.PNG"),
    SPADE1(5,4,1,"HIGHESTCLUB","src/images/5P.PNG"),SPADE4(6,4,4,"LOWESTCLUB","src/images/4P.PNG"),
    SPADE3(7,4,3,"2","src/images/3P.PNG"),SPADE2(8,4,2,"3","src/images/2P.PNG"),
    CLUB1(9,3,1,"HIGHESTSPADE","src/images/5T.PNG"),CLUB4(10,3,4,"LOWESTSPADE","src/images/4T.PNG"),
    CLUB3(11,3,3,"HIGHESTSPADE","src/images/3T.PNG"),CLUB2(12,3,2,"LOWESTSPADE", "src/images/2T.PNG"),
    DIAM1(13,2,1,"4","src/images/5C.PNG"),DIAM4(14,2,4,"BEST_JEST_NO_JOKER","src/images/4C.PNG"),
    DIAM3(15,2,3,"LOWESTDIAM","src/images/3C.PNG"),DIAM2(16,2,2,"HIGHESTDIAM","src/images/2C.PNG")//    ,REFER(17,"REFER",null)
    ;
    private Integer id;
    private int couleur;
    private String trophie;
    private Integer valeur;
    private String imageLocation;
//    public static final String HEART = "HEART";
//    public static final String CLUB = "CLUB";
//    public static final String DIAM = "DIAM";
//    public static final String SPADE = "SPADE";
//    public static final String JOKE = "JOKER";

    CarteTypes(Integer id, int couleur,Integer valeur, String trophie, String location) {
        this.id = id;
        this.couleur = couleur;
        this.trophie = trophie;
        this.valeur = valeur;
        this.imageLocation = location;
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

    public String getImageLocation() {
        return imageLocation;
    }
}
