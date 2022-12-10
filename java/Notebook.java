
public class Notebook extends Item{
    public int sections;
    
    Notebook(){
        sections=0;
    }

    Notebook(int id, int stock, double price, String name, String description, int sections, String category) {
        super(id, stock, price, name, description,category);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    void setSections(int Sections){
        sections=Sections;
    }
    
    public int getSections(){
        return this.sections;
    }
    
}
