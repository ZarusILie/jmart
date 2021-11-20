package com.LazaruslieJmartKD.dbjson;
import java.util.HashMap;

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
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
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
        return mapCounter.get(clazz);
    }

    public static <T extends Serializable> int setClosingId (Class<T> clazz, int id){
        return mapCounter.put(clazz, id);
    }

}
