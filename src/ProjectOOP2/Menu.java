package ProjectOOP2;

public class Menu {

	private String menuName;
	private int menuCost;
	private int menuId;
	private int amount;
	
	public Menu( int inputMenuNum , String inputName , int inputPrice ) {
		menuId = inputMenuNum;
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
	
	public int getMenuID() {
		return menuId;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public void setAmount( int n ) {
		amount = n;
	}
	
	public void addAmountByOne() {
		amount = amount + 1;
	}
	
	public String toString() {
		return ( "ID: "+menuId+", "+menuName+", Amount: "+amount+", --> "+amount*menuCost+" Baht." );
	}
	
}
