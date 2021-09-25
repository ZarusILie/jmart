package LazaruslieJmartKD;


/**
 * class Store
 *
 * @author (Lazaruslie Karsono)
 * 
 */
public class Store extends Recognizable
{
    public String name;
    public String address;
    public String phoneNumber;
    
    public Store(int accountId, String name, String address, String phoneNumber){
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        
     }
     
     public Store(Account account, String name, String address, String phoneNumber){
         super(account.id);
         this.name = name;
         this.address = address;
         this.phoneNumber = phoneNumber;
     }
     
     
     public boolean read(String content){
         return false;
        }
    
}
