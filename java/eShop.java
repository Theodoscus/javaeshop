
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Iterator;

public class eShop {
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public List<Item> itemsList = new ArrayList<Item>();
    public List<Buyer> buyersList = new ArrayList<Buyer>();
    public List<ItemOrdered> orderList = new ArrayList<ItemOrdered>();
    public int id=1;
    public int id0=1;
    Owner owner = new Owner("admin","admin", true);
    public String eMail;
    public void addItem() throws Exception{
        while (true) {
            System.out.println("===============================");
            System.out.println("The product you want to add is:");
            System.out.println("1. Pen");
            System.out.println("2. Pencil");
            System.out.println("3. Notebook");
            System.out.println("4. Paper");
            System.out.println("5. Back");
            System.out.println("Enter your choice:");
            int choice = Integer.parseInt(input.readLine());
            
        switch (choice) {
            case 1 -> {
                try{
                String category="Pen";
                
                System.out.println("Enter pen's stock:");
                int stock = Integer.parseInt(input.readLine());
                System.out.println("Enter pen's price:");
                double price = Double.parseDouble(input.readLine());
                System.out.println("Enter pen's tip size:");
                double tipSize = Double.parseDouble(input.readLine());
                System.out.println("Enter pen's name:");
                String name = input.readLine();
                System.out.println("Enter pen's description:");
                String description = input.readLine();
                System.out.println("Enter pen's color:");
                String color = input.readLine();
               
        
                Pen item = new Pen(id, stock, price, name, description, color, tipSize, category);
                itemsList.add(item);
                id++; 
                System.out.println("Added new product:" + item.getBasicInfo());
                }
            
            catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
        }
    
            
            
            
        
        
            case 2 -> {
                try{
                String category="Pencil";
                System.out.println("Enter pencil's name:");
                String name = input.readLine();
                System.out.println("Enter pencil's stock:");
                int stock = Integer.parseInt(input.readLine());
                System.out.println("Enter pencil's description:");
                String description = input.readLine();
                System.out.println("Enter pencil's price:");
                double price = Double.parseDouble(input.readLine());
                System.out.println("Enter pencil's tip size:");
                double tipSize = Double.parseDouble(input.readLine());
        
                Pencil item = new Pencil(id, stock, price, name, description, tipSize, category);
                itemsList.add(item);
                id++; 
                System.out.println("Added new product:" + item.getBasicInfo());
                }
                catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
                }
            case 3 -> {
                try{
                String category = "Notebook";
                System.out.println("Enter notebook's name:");
                String name = input.readLine();
                System.out.println("Enter notebook's stock:");
                int stock = Integer.parseInt(input.readLine());
                System.out.println("Enter notebook's description:");
                String description = input.readLine();
                System.out.println("Enter notebook's price:");
                double price = Double.parseDouble(input.readLine());
                System.out.println("Enter notebook's color:");
                int sections = Integer.parseInt(input.readLine());
                
                Notebook item = new Notebook(id, stock, price, name, description, sections, category);
                itemsList.add(item);
                id++; 
                System.out.println("Added new product:" + item.getBasicInfo());
                }
                catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
                }
            case 4 -> {
                try{
                String category = "Paper";
                System.out.println("Enter paper's name:");
                String name = input.readLine();
                System.out.println("Enter paper's stock:");
                int stock = Integer.parseInt(input.readLine());
                System.out.println("Enter paper's description:");
                String description = input.readLine();
                System.out.println("Enter paper's price:");
                double price = Double.parseDouble(input.readLine());
                System.out.println("Enter paper's weight in mm:");
                int weight = Integer.parseInt(input.readLine());
                System.out.println("Enter pen's pages:");
                int pages = Integer.parseInt(input.readLine());
        
                Paper item = new Paper(id, stock, price, name, description, weight, pages, category);
                itemsList.add(item);
                id++; 
                System.out.println("Added new product:" + item.getBasicInfo());
                }
                catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
            }
            case 5 -> {
                menuPageOwner();
            }
            default -> System.out.println("Your choice is not in range (1-5)");
                
        }
        }
        
    }
    
    public void addItemOrdered() throws Exception{
        try{
        System.out.println("=================");
        System.out.println("Enter product id:");
        int id2 = Integer.parseInt(input.readLine());
        boolean key8=false;

        for (Item item : itemsList){
            if (item.getId()==id2){
                System.out.println("Product found.");
                System.out.println("Do you want to add the product in your Basket? (y/n)");
                String answer = input.readLine();
                
                if (null == answer){ System.out.println("Not an acceptable answer.");
                }
                    else switch (answer) {
                    case "y" -> {
                        System.out.println("Enter the quantity for this item:");
                        int quantity = Integer.parseInt(input.readLine());
                        if (item.getStock()>=quantity){
                            String eMail5=eMail;
                            item.setStock(item.getStock()-quantity);
                            ItemOrdered order = new ItemOrdered(quantity, item, eMail5, id0);
                            orderList.add(order);
                            System.out.println("Product added in your basket.");
                            id0++;
                            menuPageBuyer();
                            key8=true;
                        }
                        else { System.out.println("There is no available stock for this product.");
                        menuPageBuyer();}
                    }
                    case "n" -> menuPageBuyer();
                    default -> System.out.println("Not an acceptable answer.");
                }
            }
            
            
        }
        if (key8==false){
            System.out.println("Product not found.");
            menuPageBuyer();
        }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    
    
    public void checkout() throws Exception{
        try{
        System.out.println("==============");
        System.out.println("Shopping Cart:");
        boolean key=false;
        for (ItemOrdered order : orderList){
            if (order.getBuyerEmail().equals(eMail)){
                key=true;
                System.out.println(order.getItemOrdered() + order.getId0());
            }
          
        }
        if(key==false){
            System.out.println("No products in your Basket.");
        } 
        boolean key3=false;
        double total=0;
        for (ItemOrdered order : orderList){
            if (order.getBuyerEmail().equals(eMail)){
                key3=true;
                Item item = order.getItem();
                double price=item.getPrice();
                int quantity=order.getQuantity();
                total=total+(price*quantity);
            }
          
        }
        if(key3==true){
            System.out.println("Total price is:" + total);
        } 
        else{
            System.out.println("Your basket is empty");
        }
        boolean key8=false;
        double total1=0;
        double totalc=0;
        for (ItemOrdered order : orderList){
            if (order.getBuyerEmail().equals(eMail)){
                key8=true;
                Item item = order.getItem();
                double price=item.getPrice();
                int quantity=order.getQuantity();
                total1=total1+(price*quantity);
                
            }
          
        }
        
        for(Buyer buyer : buyersList){
            if(buyer.geteMail().equals(eMail)){
                if(buyer.getBuyersCategory().equals("Bronze")){
                    totalc=3+0.02*total1;
                }
                else if(buyer.getBuyersCategory().equals("Silver")){
                    totalc=(3+(0.02*total1))*0.5;
                }
                else if(buyer.getBuyersCategory().equals("Gold")){
                    totalc=0;
                }
            }
        }
        if(key8==true){
            System.out.println("Courier cost is:" + totalc);
            System.out.println("Total cost is:" + (totalc + total));
        } 
        else{
            System.out.println("Your basket is empty");
        }
        System.out.println("Do you wish to purchase these products? (y/n)");
        String choice = input.readLine();
        boolean key5=false;
        double bonus1=0;
        switch(choice){
            case "y"->{
                bonus1=total*0.1;
                for(Buyer buyer : buyersList){
                    if(buyer.geteMail().equals(eMail)){
                        buyer.setBonus(bonus1);
                        if (buyer.getBonus()<100){
                            buyer.setBuyersCategory("Bronze");
                        }
                        else if(buyer.getBonus()>=100 && buyer.getBonus()<200){
                            buyer.setBuyersCategory("Silver");
                        }
                        else if(buyer.getBonus()>=200){
                            buyer.setBuyersCategory("Gold");
                        }
                    }
                }
                Iterator itr = orderList.iterator();
                while (itr.hasNext()) 
        { 
            ItemOrdered order = (ItemOrdered)itr.next(); 
            if (order.getBuyerEmail().equals(eMail)) 
                itr.remove(); 
                key5 = true;
        } 
            
                    
                
            }
            case "n"->{
                menuPageBuyer();
            }
            default->{
            System.out.println("Not an acceptable answer.");
                menuPageBuyer();
            }
            }
        if (key5==false){
            System.out.println("Basket is empty. Can't make a purchase.");
            menuPageBuyer();
        }
        else if (key5==true){
            System.out.println("Purchase succesful.");
            menuPageBuyer();
        }
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    
    
    
    public void removeItemOrdered() throws Exception{
        try{
        System.out.println("Enter order id:");
        int id7 = Integer.parseInt(input.readLine());
        boolean key2 = false;
        for (ItemOrdered order : orderList){
            if (order.getId0()==id7 && order.getBuyerEmail().equals(eMail)){
                int quantity=order.getQuantity();
                Item item=order.getItem();
                item.setStock(quantity+item.getStock());
                orderList.remove(order);
                System.out.println("Order removed.");
                key2=true;
                menuPageBuyer();
            }
            
            
        }
       
        if (key2==true){
            System.out.println("Product removed.");
            menuPageBuyer();
        }
        else {
            System.out.println("Product not found.");
            menuPageBuyer();
        }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    public void viewCart() throws Exception{
        System.out.println("Shopping Cart:");
        boolean key=false;
        for (ItemOrdered order : orderList){
            if (order.getBuyerEmail().equals(eMail)){
                key=true;
                System.out.println(order.getItemOrdered() + order.getId0());
            }
          
        }
        if(key==false){
            System.out.println("No products in your Basket.");
        } 
        menuPageBuyer();
    }
    
    public void removeAllItemsOrdered() throws Exception{
        try{
        System.out.println("Remove all items from your basket? (y/n)");
        String choice = input.readLine();
        boolean key1 = false;
        int quantity23=0;
        switch (choice) {
            case "y" -> {
                Iterator itr = orderList.iterator();
                while (itr.hasNext()) 
        { 
            ItemOrdered order = (ItemOrdered)itr.next(); 
            if (order.getBuyerEmail().equals(eMail)) 
                quantity23=order.getQuantity();
                Item item=order.getItem();
                item.setStock(quantity23+item.getStock());
                itr.remove(); 
                key1 = true;
        } 
                    
                
            }
            case "n" -> {menuPageBuyer();}
            default -> {
                System.out.println("Not an acceptable answer.");
                menuPageBuyer();
            }
        }
        if (key1==false){
            System.out.println("Basket is already empty.");
            menuPageBuyer();
        }
        else if (key1==true){
            System.out.println("Basket is empty.");
            menuPageBuyer();
        }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    public void removeItem() throws Exception{
        try{
        System.out.println("=================");
        System.out.println("Enter product id:");
        int id1 = Integer.parseInt(input.readLine());
        
        int productIndex = -1;
        for (int i = 0; i < itemsList.size(); i++){
            Item item = itemsList.get(i);
            if (item.getId() == id1){
                productIndex = i;
                break;
            }
        }
        
        if (productIndex == -1) {
            System.out.println("Product with given id not found.");
        } else {
            itemsList.remove(productIndex);
            System.out.println("Product removed.");
        }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    public void addBuyer() throws Exception{
        try{
            System.out.println("Enter buyer's name:");
            String name = input.readLine();
            System.out.println("Enter buyer's eMail:");
            String eMail3 = input.readLine();
            int bonus=0;
            String buyersCategory1="Bronze";
            Buyer buyer = new Buyer(name, eMail3, bonus, buyersCategory1);
            buyersList.add(buyer);
            buyer.setBuyersCategory("Bronze");
            System.out.println("Added new buyer:");
            System.out.println("Name: " + buyer.getUsername());
            System.out.println("eMail: " + buyer.geteMail());
            System.out.println("Bonus:" + buyer.getBonus());
            System.out.println("Buyer's category:" + buyer.getBuyersCategory());
               
        
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    public void removeBuyer() throws Exception{
        
        System.out.println("Enter buyer's username:");
        String name = input.readLine();
        
        int buyersIndex=-1;
        for (int i = 0; i < buyersList.size(); i++) {
            Buyer buyer = buyersList.get(i);
            
            if (buyer.getUsername().equals(name)){
               buyersIndex=i;
               break;
            }
        }
        if (buyersIndex == -1){
            System.out.println("Buyer with given username not found.");
        }
        else {
            buyersList.remove(buyersIndex);
            System.out.println("Buyer removed.");
        }
    }
    
    
    public void updateItemStock() throws Exception{
        try{
        System.out.println("Enter product id: ");
        int id1 = Integer.parseInt(input.readLine());
        boolean key76 = false;
        for (Item item : itemsList){
            if (item.getId() == id1){
                System.out.println("Product found.");
                System.out.println("Enter stock for this product:");
                int stock = Integer.parseInt(input.readLine());
                item.setStock(stock);
                System.out.println("Product's stock is updated.");
                key76 = true;
            }
            
        }
        if (key76==false){
            System.out.println("Product not found.");
            menuPageOwner();
        }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    public void showCategories() throws Exception{
        try{
        while (true){
            System.out.println("====================");
            System.out.println("Products Categories:");
            System.out.println("1. Pens");
            System.out.println("2. Pencils");
            System.out.println("3. Notebooks");
            System.out.println("4. Paper");
            System.out.println("5. Back");
            System.out.println("Enter your choice(1-5):");
            int choice = Integer.parseInt(input.readLine());
            
            switch (choice) {
		case 1 ->{
                System.out.println("Products in pens category:");
                for (Item item : itemsList) {
                if ("Pen".equals(item.getCategory())){
                
                System.out.println(item.getBasicInfo());
                
                }
                }
		}
                case 2 ->{
                System.out.println("Products in pencils category:");
                for (Item item : itemsList) {
                if ("Pencil".equals(item.getCategory())) {
                        
			System.out.println(item.getBasicInfo());
				   
                }
                }
                }
                case 3 ->{
                System.out.println("Products in notebooks category:");
                        for (Item item : itemsList) {
                        if ("Notebook".equals(item.getCategory())) {
                        
			System.out.println(item.getBasicInfo());
				break;
                }
                }
                }
                case 4->{
                System.out.println("Products in paper category:");
                        for (Item item : itemsList) {
                        if ("Paper".equals(item.getCategory())) {
                        
			System.out.println(item.getBasicInfo());
				  
                        
                }
                }
                }
                case 5->{
                    menuPageBuyer();
                }
                
                default->{
                    System.out.println("Your choice is not in range (1-5), try again.");
                       }
            }                   
}
        }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
        
}
    public void showProduct() throws Exception{
        try{
                System.out.println("==================");
                System.out.println("Enter product id: ");
		int id1 = Integer.parseInt(input.readLine());
                boolean key9=false;
                for (Item item : itemsList) {
                    if (item.getId() == id1){
                        System.out.println("Product found.");
                        System.out.println(item.getBasicInfo());
                        key9=true;
}
                    
                        }
                if (key9==false){
                    System.out.println("Product not found.");
                    menuPageBuyer();
                }
                else if (key9==true){
                    menuPageBuyer();
                }
                
}
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
        
    
    
    public void checkStatus(){
		System.out.println("Buyers:");
                int i=1;
                for (Buyer buyer : buyersList) {
                    
                    System.out.println("Client number " + i);
                    System.out.println("Name:" + buyer.getUsername());
                    System.out.println("E-mail:" + buyer.geteMail());
                    System.out.println("Bonus:" + buyer.getBonus());
                    System.out.println("Buyer's Category:" + buyer.getBuyersCategory());
                    i++;
        }
}
    public void loginPageBuyer() throws Exception{
        eMail="";
        System.out.println("Enter username:");
        String name = input.readLine();
        System.out.println("Enter eMail:");
        String eMail1 = input.readLine();
        eMail=eMail1;
        buyersList.forEach(buyer -> {
            if (buyer.getUsername().equals(name) && buyer.geteMail().equals(eMail1)){
                System.out.println("Login successful.");
                eMail=eMail1;
                try {
                    menuPageBuyer();
                } catch (Exception ex) {
                    Logger.getLogger(eShop.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else {
                System.out.println("Wrong username or eMail.");
            }
        });
    }
    
    public void menuPageBuyer() throws Exception{
        try{
        System.out.println("==========BUYER=========");
        System.out.println("WELCOME TO YOUR ACCOUNT!");
        System.out.println("1.Browse store.");
        System.out.println("2.Search for a product with id.");
        System.out.println("3.Add a product in your basket.");
        System.out.println("4.Remove a product from your basket.");
        System.out.println("5.View Cart.");
        System.out.println("6.Remove all products from basket.");
        System.out.println("7.Checkout.");
        System.out.println("8.Logout.");
        System.out.println("Enter your choice(1-9):");
        int choice = Integer.parseInt(input.readLine());
        
        switch(choice){
            case 1 ->{
                showCategories();
            }
            case 2->{
                showProduct();
            }
            
            case 3->{
                addItemOrdered();
            }
            case 4->{
                removeItemOrdered();
            }
            case 5->{
                viewCart();
            }
            case 6->{
                removeAllItemsOrdered();
            }
            case 7->{
                checkout();
            }
            case 8->{
                eMail="";
                loginPage();
            }
            
            default->{
                System.out.println("Your choice is not in range (1-8), try again.");
            }
        }
        
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
    }
    
    public void loginPageOwner() throws Exception{
        System.out.println("Enter owner's username:");
        String username = input.readLine();
        System.out.println("Enter owner's eMail:");
        String eMail4 = input.readLine();
        
        if (owner.getUsername().equals(username) && owner.geteMail().equals(eMail4)){
            System.out.println("Login successful!");
            menuPageOwner();
        }
        else {
            System.out.println("Wrong username or eMail!");
        }
          
        
        
    }
    
    public void loginPage() throws Exception{
        try{
        while (true) {
        System.out.println("Welcome to eShop!");
        System.out.println("Login as:");
        System.out.println("1. Buyer");
        System.out.println("2. Admin");
        System.out.println("3. Exit.");
        System.out.println("Enter your choice(1-3):");
        int choice = Integer.parseInt(input.readLine());
        
        switch(choice){
            case 1: {
                loginPageBuyer();
                break;
            }
            
            case 2: {
                loginPageOwner();
                break;
            }
            
            case 3: {
                System.exit(0);
            }
            default:  {
                System.out.println("Please enter a number in range(1-3).");
                break;
            }
        }
        
    }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
            loginPage();
        }
    }
    
    
    public void menuPageOwner() throws Exception{
        try{
        while(true){
        System.out.println("=========ADMIN==========");
        System.out.println("WELCOME TO YOUR ACCOUNT!");
        System.out.println("1.Add a client to the store.");
        System.out.println("2.Remove a client from the store.");
        System.out.println("3.List all the clients.");
        System.out.println("4.Add a new product.");
        System.out.println("5.Remove a product.");
        System.out.println("6.Update item stock.");
        System.out.println("7.Logout.");
        System.out.println("8.Exit program.");
        System.out.println("Enter your choice(1-8):");
        System.out.println("========================");
        int choice = Integer.parseInt(input.readLine());
        
        switch(choice){
            case 1 -> {
                addBuyer();
            }
            
            case 2 -> {
                removeBuyer();
            }
            
            case 3 -> {
                checkStatus();
            }
            case 4 -> {
                addItem();
            }
            case 5 -> {
                removeItem();
            }
            case 6-> {
                updateItemStock();
            }
            case 7 -> {
                loginPage();
            }
            case 8 -> {
                System.exit(0);
            }
            default -> {
                System.out.println("Your choice is not in range (1-8).");
            }
        }
    }
    }
        catch(NumberFormatException e){
            System.out.println("Please enter a valid answer.");
        }
        
}
}

        
    
    
    
    
