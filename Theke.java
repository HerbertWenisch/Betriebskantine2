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
    
    private boolean isFull(){
        return count == N;
    }

    private boolean isEmpty(){
        return count == 0;
    }

    
    public synchronized void ablegen(Tablett t){
        while(isFull()){ 
          try {wait();}
          catch (InterruptedException e) {}
        } 
        
        // not full:
        tabletts[count++] = t;
        if (count == 1) notifyAll(); // zuvor leer
    }
    

    public synchronized Tablett wegnehmen(){
        while(isEmpty()){
           try {wait();}
           catch (InterruptedException e) {} 
        }
        // not empty:
        Tablett tablett = tabletts[--count];
        if(count == N-1) notifyAll(); // zuvor voll
        return tablett;
    }
    
    
}