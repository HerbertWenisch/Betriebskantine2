/**
 * Abi 2012 III 2 Übung
 *
 * @author (HerbertWenisch)
 * @version (19.11.22)
 */

public class Theke {
    private final int N = 10;
    private Tablett[] tabletts = new Tablett[N];
    private int count = 0;  // erster freier Platz im Array

    public boolean ablegen(Tablett t){
        return true;
    }
    

    public Tablett wegnehmen(){
        return tabletts[0];
    }
    
    
}