package jest.carte;

public enum CarteTypes {
    JOKER(0,"JOKER","BEST_JEST"),
    HEART5(1,"HEART5","JOKER"),HEART4(2,"HEART4","JOKER"),
    HEART3(3,"HEART3","JOKER"),HEART2(4,"HEART2","JOKER"),
    SPADE5(5,"SPADE5","HIGHEST"),SPADE4(6,"SPADE4","LOWEST"),
    SPADE3(7,"SPADE3","2CARDS"),SPADE2(8,"SPADE2","MAJORITY"),
    CLUB5(9,"CLUB5","HIGHEST"),CLUB4(10,"CLUB4","LOWEST"),
    CLUB3(11,"CLUB3","HIGHEST"),CLUB2(12,"CLUB2","LOWEST"),
    DIAM5(13,"DIAM5","4CARDS"),DIAM4(14,"DIAM4","BEST_JEST_NO_JOKER"),
    DIAM3(15,"DIAM3","LOWEST"),DIAM2(16,"DIAM2","HIGHEST")
//    ,REFER(17,"REFER",null)
    ;
    private Integer id;
    private String carteType;
    private String trophie;

    CarteTypes(Integer id, String carteType,String trophie) {
        this.id = id;
        this.carteType = carteType;
        this.trophie = trophie;
    }

    public Integer getId() {
        return id;
    }

    public String getCarteType() {
        return carteType;
    }

    public String getTrophie() {
        return trophie;
    }
}
