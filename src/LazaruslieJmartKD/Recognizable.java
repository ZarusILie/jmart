package LazaruslieJmartKD;


/**
 * Recognizable
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Recognizable
{
    public final int id;

    /**
     * Constructor for objects of class Recognizable
     */
    protected Recognizable(int id)
    {
       this.id = id;
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
}
