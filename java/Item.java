public  class Item
{
    public String name, description,category;
    public double price;
    public int stock,id;
    
    public Item()
    {
        id=0;
        price=0;
        stock=0;
        name="";
        description="";
        category="";
    }
    
    public Item(int Id, int Stock,  double Price, String Name, String Description, String Category)
    {
        this.id=Id;
        this.stock=Stock;
        this.price=Price;
        this.name=Name;
        this.description=Description;
        this.category=Category;
        
    }

    

void setId(int Id){
     this.id = Id;
}

void setName(String Name){
    this.name= Name;
}

void setPrice(double Price){
    this.price = Price;
}

void setDescription(String Description){
    this.description = Description;
}

void setStock(int Stock){
    this.stock = Stock;
}

void setCategory(String Category){
    this.category=Category;
}
public int getId() {
    return id;
	}

public String getName() {
    return name;
}

public String getDescription() {
    return description;
}

public double getPrice() {
    return price;
}

public int getStock(){
    return stock;
}

public String getCategory(){
    return category;
}

public String getBasicInfo(){
    return "Name:" + name + " ,Description:" + description + " ,Price:" + price + " ,Stock:" + stock + " ,Category:" + category + " ,ID:" + id;
}



    

}
