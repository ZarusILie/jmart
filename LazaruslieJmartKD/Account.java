package LazaruslieJmartKD;


/**
 * class Account
 *
 * @author (Lazaruslie Karsono)
 * @version (a version number or a date)
 */
public class Account extends Recognizable implements FileParser
{
    public String name;
    public String email;
    public String password;

    
    public Account(int id, String name, String email, String password)
    {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    @Override
    public boolean read(String content){
        return false;
    }
    
    public Object write(){
        return null;
    }
}