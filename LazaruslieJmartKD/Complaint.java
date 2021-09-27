package LazaruslieJmartKD;


/**
 * class Complaint.
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Complaint extends Recognizable implements FileParser
{
    public String date;
    public String desc;

    
    public Complaint(int id, String desc)
    {
        super(id);
        this.desc = desc;
        this.date = "tanggal";
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
}
