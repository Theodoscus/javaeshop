

public class Pencil extends Item{
    public double tipSize;
    String[] type = {"H", "B", "HB"};
    
    Pencil(){
        tipSize=0;
    }
    

    Pencil(int id, int stock, double price, String name, String description, double tipSize, String category) {
        super(id, stock, price, name, description, category);
    }


    
    void setTipSize(double TipSize){
        this.tipSize=TipSize;
    }
    
    void setType(String[] Type){
        this.type=Type;
        
    }
    
    public double getTipSize(){
        return this.tipSize;
    }
    
    public String[] getType(){
        return this.type;
    }
    
}
