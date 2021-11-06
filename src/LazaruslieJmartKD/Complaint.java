package LazaruslieJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * class Complaint.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Complaint extends Serializable implements FileParser
{
    public Date date;
    public String desc;

    
    public Complaint(int id, String desc)
    {

        this.desc = desc;
        this.date = new Date();
        System.out.println(date);
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy");
        String format = FORMAT.format(this.date);
        return ("Complaint{date=" + format + ", desc='" +this.desc+ "'}");
    }
}
