public class Terning {
    //Opretter int 'øjne' på terningen
    private int øjne;

    //Sætter maximum mængde af 'int øjne' til 6
    private final int MAX = 6;

    //Laver terning
    public Terning() {
        øjne = 1;
    }

    //Beregner matematikken bag terningen ved at gange et tilfældigt tal 1-6 med terningen med 1 øje
    public void kast() {
        øjne = (int) (Math.random() * MAX) + 1;
    }

    //Henter antallet af øjne
    public int fåØjne() {
        return øjne;
    }
}
