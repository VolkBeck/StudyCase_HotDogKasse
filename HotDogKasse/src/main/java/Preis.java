import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named
@ApplicationScoped
public class Preis implements Serializable {

    //  Attribute
    private int gewählteArtikel;
    private ArrayList<Zutat> zusammenstellungHotDog= new ArrayList<Zutat>();

    // Methoden
    // Fügt eine Zutat der WunschHotDog zusammenstellung hinzu
    public void zusammenstellung(){
        FacesContext context = FacesContext.getCurrentInstance();
        Zutat zutat = context.getApplication().evaluateExpressionGet(context,"#{zutat}",Zutat.class);
        if (zutat.isAuswahl()){
            getZusammenstellungHotDog().add(zutat);
            gewählteArtikel ++;
        }else{
            getZusammenstellungHotDog().remove(zutat);
            gewählteArtikel --;
        }
    }

    // Berechnung des Hot Dog Preises
    public float hotDogPreis(){
        float preis = 2.0f;

        for (Zutat z : zusammenstellungHotDog) {
            preis = preis + z.getPreis();
        }
        if (gewählteArtikel > 1 && gewählteArtikel <= 5 ){
            preis = preis - (preis * (gewählteArtikel - 1) /10);
        }
        if (gewählteArtikel > 5){
            preis = preis * 0.5f;
        }
        return preis;
    }

    // setzt gewählte artikel und zusammengestellten hot Dog zurück
    public void reset(){
        gewählteArtikel = 0;
        zusammenstellungHotDog.removeAll(getZusammenstellungHotDog());
    }

    // Getter und Setter

    public int getGewählteArtikel() {
        return gewählteArtikel;
    }

    public void setGewählteArtikel(int gewählteArtikel) {
        this.gewählteArtikel = gewählteArtikel;
    }

    public ArrayList<Zutat> getZusammenstellungHotDog() {
        return zusammenstellungHotDog;
    }

    public void setZusammenstellungHotDog(ArrayList<Zutat> zusammenstellungHotDog) {
        this.zusammenstellungHotDog = zusammenstellungHotDog;
    }
}
