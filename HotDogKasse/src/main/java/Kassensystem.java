import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;


@Named
@ApplicationScoped
public class Kassensystem implements Serializable {

    // Attribute
    private static Kassensystem kassensystem = new Kassensystem();
    private Collection<Zutat> zutaten = new ArrayList<Zutat>();

    // Konstruktor
    public Kassensystem(){
        zutaten.add(new Zutat("Röstzwiebeln",0.5f,false));
        zutaten.add(new Zutat("Käse", 0.5F,false));
        zutaten.add(new Zutat("Tomaten", 0.5F,false));
        zutaten.add(new Zutat("Knoblauch", 0.5F,false));
        zutaten.add(new Zutat("Oliven", 0.5F,false));
        zutaten.add(new Zutat("Ketschup", 0.5F,false));
        zutaten.add(new Zutat("Majo", 0.5F,false));
        zutaten.add(new Zutat("Senf", 0.5F,false));
    }
    // Methoden
    public void resetKasse(){
        kassensystem = new Kassensystem();
        setZutaten(kassensystem.getZutaten());
    }
    // Getter und Setter
    public Collection<Zutat> getZutaten() {
        return  zutaten;
    }
    public void setZutaten(Collection<Zutat> zutaten) {
        this.zutaten = zutaten;
    }
}






