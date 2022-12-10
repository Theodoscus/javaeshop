public class Pen extends Item{
    public String color;
    public double tipSize;
    

    Pen(int id, int stock, double price, String name, String description, String color, double tipSize, String category) {
        super(id, stock, price,name,description,category);
 
    
    }


    
    void setColor(String Color){
        this.color=Color; 
    }
    
    void setTipSize(double TipSize){
        this.tipSize=TipSize;
    }
    
    public String getColor(){
        return color;
    }
    
    public double getTipSize(){
        return tipSize;
    }
    

    

}
