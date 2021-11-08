package LazaruslieJmartKD;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * class Account
 *
 * @author (Lazaruslie Karsono)
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    public String name;
    public String email;
    public String password;
    public static final String REGEX_EMAIL = "^\\w+([\\.&_*~]?\\w+)*@\\w+([\\.\\-]?\\w+)*(\\.\\w{2,3})+$";
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
    
    public Account(int id, String name, String email, String password)
    {

        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public boolean validate(String content){
        Pattern email_Pattern = Pattern.compile(REGEX_EMAIL);
        Pattern password_Pattern = Pattern.compile(REGEX_PASSWORD);
        Matcher email_Matcher = email_Pattern.matcher(this.email);
        Matcher password_Matcher = password_Pattern.matcher(this.password);
        if (email_Matcher.find() && password_Matcher.find()) {
            return true;
        }
        return false;
    }
    

    public boolean read(String content){
        return false;
    }
    

    public String toString(){
        return("name:" + name + "\nemail:" + email + "\npassword" + password);
    }
}
