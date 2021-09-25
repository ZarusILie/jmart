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
    public Object write();
    public static Object newInstance(String content){
        return null;
    }
}
