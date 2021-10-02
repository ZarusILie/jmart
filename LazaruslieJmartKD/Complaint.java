package LazaruslieJmartKD;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * class Complaint.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;

    
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = new Date();
        System.out.println(date);
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
