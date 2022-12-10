public class User {
    public String username,eMail;
    public User(){
        username="";
        eMail="";
    }
    public User(final String Username, final String Mail){
        this.username=Username;
        this.eMail=Mail;
    }
    
    public void setUsername(String Username){
        username=Username;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void seteMail(String Mail){
        eMail=Mail;
    }
    
    public String geteMail(){
        return this.eMail;
    }
    
}
