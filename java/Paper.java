public class Paper extends Item {
    public int weight;
    public int pages;
    
    Paper(){
        weight=0;
        pages=0;
    }

    Paper(int id, int stock, double price, String name, String description, int weight, int pages, String category) {
        super(id, stock, price,name,description,category);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
    void setWeight(int Weight){
        weight=Weight;
    }
    
    void setPages(int Pages){
        pages=Pages;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public int getPages(){
        return this.pages;
    }
    
    
}
