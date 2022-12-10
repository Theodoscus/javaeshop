public class ItemOrdered {
public Item item;
public int quantity,id0;
public String buyerEmail;
public ItemOrdered(){
    quantity=0;
    buyerEmail="";
    id0=0;
}

public ItemOrdered(int quantity, Item item, String buyerEmail, int id0){
    this.quantity=quantity;
    this.item=item;
    this.buyerEmail=buyerEmail;
    this.id0=id0;
}

public int getQuantity(){
    return quantity;
}

public Item getItem(){
    return item;
}

public String getBuyerEmail(){
    return buyerEmail;
}
public void setQuantity(int quantity){
    this.quantity=quantity;
}
public void setBuyerEmail(String buyerEmail){
    this.buyerEmail=buyerEmail;
}
public void setProduct(Item item){
    this.item=item;
}


public int getId0(){
    return this.id0;
}
public String getItemOrdered(){
    return "Name: " + item.getName() + ", ID: " + item.getId() + ", Quantity: " + quantity + ", Buyer's eMail: " + getBuyerEmail() + ", Order ID: ";
}
}

