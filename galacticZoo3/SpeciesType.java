
enum SpeciesType{
    MARTIAN("RED PLANET"),
    JOVIAL("GAS GIANT"),
    UNKNOWN("DEEP SPACE");

    private final String origin;
    
    private SpeciesType(String origin){
        this.origin = origin;
    }

    public String getOrigin(){
        return this.origin;
    }


}