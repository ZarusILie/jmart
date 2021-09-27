package LazaruslieJmartKD;


/**
 * interface FileParser
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public interface FileParser
{
    public boolean read(String content);
    default Object write(){
        return null;
    }
    public static Object newInstance(String content){
        return null;
    }
}
