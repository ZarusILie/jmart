package com.LazaruslieJmartKD;
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

    private static HashMap<Class<?>,Integer> mapCounter = new HashMap<Class<?>, Integer>();

    /**
     * Constructor for objects of class Serializable
     */
    protected Serializable() {
        Class<?> getC = getClass();
        if(mapCounter.get(getC) == null){
            mapCounter.put(getC,0);
        }

        else{
            mapCounter.put(getC, mapCounter.get(getC) + 1);
        }

        this.id =mapCounter.get(getC);
    }

    @Override
    public int compareTo(Serializable other){
        return Integer.compare(this.id, other.id);
    }
    
    public boolean equals(Object other){
        if(other instanceof Serializable){
            Serializable recognizable = (Serializable) other;
            if(recognizable.id == this.id){
                return true;
            }
            else {
                return false;
            }

        }
        return false;
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
        return mapCounter.get(clazz.getClass());
    }

    public static <T extends Serializable> int setClosingID (Class<T> clazz, int id){
        mapCounter.replace(clazz.getClass(), id);
        return mapCounter.get(clazz.getClass());
    }

}
