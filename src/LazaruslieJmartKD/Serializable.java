package LazaruslieJmartKD;
import java.util.HashMap;
import java.util.Map;

/**
 * Serializable
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Serializable implements Comparable<Serializable>
{
    public final int id;

    private static HashMap<Class<?>,Integer> mapCounter = new HashMap<>();

    /**
     * Constructor for objects of class Serializable
     */
    protected Serializable() {
       int counter = mapCounter.get(getClass());
       if (counter == 0) {
           counter = 0;
       } else {
           counter = counter + 1;
       }
       mapCounter.put(getClass(), counter);
       this.id = counter;
    }

    @Override
    public int compareTo(Serializable other) {
        if (this.id == other.id){
            return 1;
        }
        return 0;
    }
    
    public boolean equals(Object other){
        if (other instanceof Serializable){
            Serializable co = (Serializable) other;
            if (this.id == co.id){
                return true;
            }
                return false;
        }
        else{
            return false;
        }
    }
    
    public boolean equals(Serializable other){
        if(this.id == other.id){
            return true;
        }
        else{
            return false;
        }
    }

    public static <T extends Serializable> int getClosingId (Class<T> clazz){
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> int setClosingID (Class<T> clazz, int id){
        mapCounter.replace(clazz, id);
        return mapCounter.get(clazz);
    }

}
