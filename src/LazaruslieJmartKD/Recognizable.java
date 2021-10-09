package LazaruslieJmartKD;


/**
 * Recognizable
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;

    /**
     * Constructor for objects of class Recognizable
     */
    protected Recognizable(int id)
    {
       this.id = id;
    }

    @Override
    public int compareTo(Recognizable others) {
        if (this.id == others.id){
            return 1;
        }
        return 0;
    }
    
    public boolean equals(Object re){
        if (re instanceof Recognizable){
            Recognizable co = (Recognizable) re;
            if (this.id == co.id){
                return true;
            }
                return false;
        }
        else{
            return false;
        }
    }
    
    public boolean equals(Recognizable ni){
        if(this.id == ni.id){
            return true;
        }
        else{
            return false;
        }
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
        return 0;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz) {
        return 0;
    }

}
