import java.io.BufferedReader;
import java.io.InputStreamReader;


public class menu extends eShop{
    private BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
		menu Menu = new menu();
		Menu.loginDisplay();
	}
    
    public void loginDisplay() throws Exception{
        super.loginPage();
}
}