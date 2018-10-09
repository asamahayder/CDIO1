public class Spiller {

    //Opretter String
    private String navn;

    //Opretter int
    private int point;

    public int HentsidstePoint;

    //Tilføjer spiller navnet
    public Spiller(String navn){
        this.navn = navn;
    }

    //Henter Strengen "navn"
    public String fåNavn(){
        return this.navn;
    }

    //Henter Strengen "point"
    public int fåPoint(){
        return this.point;
    }

    //Plusser det nye antal point med det totale for den enkelte spiller
    public void tilføjPoint(int antalpoint) {
        this.point = this.point + antalpoint;
    }

    public int genstartScore() {
        this.point = 0;
        return this.point;
    }

    //Hænger sammen med når en spiller slår et par og ligger de nye point til spilleren der har slået et par
    public void brugsidstePoint(int point) {
        this.HentsidstePoint = point;
    }


}

