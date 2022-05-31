public class Zutat {

    // Attribute
    private String zutat;
    private float preis;
    private boolean auswahl;

    //Konstruktoren
    public Zutat() {
    }

    public Zutat( String zutat, float preis, boolean auswahl) {
        this.zutat = zutat;
        this.preis = preis;
        this.auswahl = false;
    }


    //Getter und Setter
    public String getZutat() {
        return zutat;
    }

    public void setZutat(String zutat) {
        this.zutat = zutat;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public boolean isAuswahl() {
        return auswahl;
    }

    public void setAuswahl(boolean auswahl) {
        this.auswahl = auswahl;
    }
}



