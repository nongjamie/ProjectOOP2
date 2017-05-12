package ProjectOOP2;

public class Menu {

	private String menuName;
	private int menuCost;
	private int menuNum;
	private int amount;
	
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		menuNum = inputMenuNum;
		menuName = inputName;
		menuCost = inputPrice;
		amount = 1;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	public int getMenuCost() {
		return menuCost;
	}
	
	public int getMenuNum() {
		return menuNum;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount( int n ) {
		amount = n;
	}
	
	public String toString() {
		return ( menuNum+". "+menuName+", Amount: "+amount+" -> "+amount*menuCost+" Baht." );
	}
	
}
