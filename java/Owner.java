public class Owner extends User{
    boolean isAdmin = true; 
    
    Owner(){
       isAdmin=true; 
    }
    Owner(String username, String eMail, boolean isADmin){
        super(username,eMail);
        isAdmin=isADmin;
    }
    
    public void setAdminTrue(boolean isADmin){
        isAdmin=isADmin;
    }
    
    boolean getAdminTrue(){
        return this.isAdmin;
    }
        
}
