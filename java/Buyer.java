

public class Buyer extends User{
    public double bonus;
    public String buyersCategory;
    
    public Buyer(){
        bonus=0;
        buyersCategory="";
    }
    public Buyer(String name, String eMail, double bonus, String buyersCategory) {
        super(name, eMail);
        
        }
    
    
    
    public void setBonus(double bonus){
        this.bonus=bonus;
    }
    
    public void setBuyersCategory(String buyersCategory){
        this.buyersCategory=buyersCategory;
    }
    
    public double getBonus(){
        return bonus;
    }
    
    public String getBuyersCategory(){
        return buyersCategory;
    }
    
     
   
}
