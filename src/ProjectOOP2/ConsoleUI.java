package ProjectOOP2;
import java.util.*;
public class ConsoleUI {

	private boolean controlOrder = true;
	private MenuManager menuManager;
	private List<Menu> orderList;

	public ConsoleUI( MenuManager menuManager ) {
		this.menuManager = menuManager;
		orderList = new ArrayList<Menu>();
		menuManager.printAllMenu();
	}

	public void run() {
		while( controlOrder ) {
			Scanner input = new Scanner( System.in );
			System.out.print( "What menu do you want to eat? [Ex: 1 , 3][Confrim : confirm][Exit : quit] : " );
			String ans = input.nextLine();
			if( ans.equalsIgnoreCase("confirm") ) {
				analyzeConfirm( orderList );
			}
			else {
				analyzeOrder( ans );				
			}
		}
	}

	public void analyzeOrder(String ans) {
		String[] ansSplit = ans.split(",");
		for(int i=0;i<ansSplit.length;i++) {
			//			ansSplit[i] = ansSplit[i].trim();
			try {
				int num = Integer.parseInt( ansSplit[i].trim() );
				if( num > menuManager.getCapacity() ) {
					System.out.print( "!!! Input --> "+num );
					System.out.println( " --> We have only "+menuManager.getCapacity()+" menu." );
				}
				else {
					Menu order = menuManager.getAllMenuList().get(num-1);
					System.out.print( "Input --> "+num );
					System.out.println( " --> You ordered ... "+"ID: "+order.getMenuID()+", Name: "+order.getMenuName()+" --> "+order.getMenuCost()+" Baht." );
					if( containMenu( order ) ) {
						int indexOfOrder = orderList.indexOf( order );
						orderList.get( indexOfOrder ).addAmountByOne();
					}
					else {
						orderList.add( order );	
					}
				}
			} catch( Exception ex ) {
				System.out.println( "!!! Input --> "+ansSplit[i]+" --> Invalid input , please try again." );
				//				System.out.println( ex.getMessage() );
			}
		}
		System.out.println( "Your orders are : " );
		Collections.sort( orderList , new Comparator<Menu>(){

			@Override
			public int compare(Menu o1, Menu o2) {
				if( o1.getMenuID() > o2.getMenuID() ) {
					return +1;
				}
				else if( o1.getMenuID() < o2.getMenuID() ) {
					return -1;
				}
				else {
					return 0;
				}
			}

		});
		for(int g=0; g<orderList.size() ;g++) {
			System.out.println( orderList.get(g).toString() );
		}
	}

	public void analyzeConfirm( List<Menu> orderList ) {
		this.orderList = orderList;
		if( orderList.size()==0 ) {
			Scanner input = new Scanner( System.in );
			System.out.print( "You haven't ordered anything. Do you want to order again? (Y)es / (N)o : " );
			String ans = input.nextLine();
			while( !ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n") ) {
				System.out.print( "Invalid input , Do you want to order again? (y)Yes / (n)No : " );
				String ans2 = input.nextLine();
				ans = ans2;
			}
			if( ans.equalsIgnoreCase("n") ) {
				System.out.println( "Bye Bye ~" );
				controlOrder = false;
			}
		}
		else {
			System.out.println( "You have ordered : " );
			for(int i=0; i<orderList.size() ;i++) {
				System.out.println( orderList.get(i).toString() );
			}
			boolean controlConfirmOrder = true;
			while( controlConfirmOrder ) {
				Scanner input = new Scanner( System.in );
				System.out.print( "(C)onfirm order , (E)dit : " );
				String ans = input.nextLine().trim();
				if( ans.equalsIgnoreCase("c") ) {
					System.out.println( "You have confirm ordered : " );
					for(int i=0; i<orderList.size() ;i++) {
						System.out.println( orderList.get(i).toString() );
					}
					int totalCost = findTotalCost( orderList );
					System.out.println( "Total cost = "+totalCost+" Baht." );
					System.out.println( "We will cooked for you now..." );
					controlConfirmOrder = false;
					controlOrder = false;
				}
				else if( ans.equalsIgnoreCase("e") ) {
					editMenu();
				}
				else {
					System.out.println( " Invalid input , please try again." );
				}
			}

		}
	}

	private void editMenu() {
		Scanner input = new Scanner( System.in );
		System.out.print( "Which menu ID do you want to edit? : " );
		String ans = input.nextLine().trim();
		try {
			int num = Integer.parseInt( ans );
			if( num > menuManager.getCapacity() ) {
				System.out.println( " We haven't got that menu ID , please try again." );
			}
			else if( !containMenu( menuManager.getAllMenuList().get(num-1) ) ) {
				System.out.println( "Don't have this menu ID in your ordered list , please try again." );
			}
			else {
				System.out.print( "(A)mount , (D)elete : " );
				String choice = input.nextLine().trim();
				if( choice.equalsIgnoreCase("A") ) {
					System.out.print( "What amount do you want? : ");
					int n = Integer.parseInt( input.next() );
					if( n <= 0 ) {
						Menu x = menuManager.getAllMenuList().get(num-1);
						int index = orderList.indexOf( x );	
						orderList.remove( index );
						System.out.println( "You have ordered : " );
						for(int i=0; i<orderList.size() ;i++) {
							System.out.println( orderList.get(i).toString() );
						}
					}
					else {
						Menu x = menuManager.getAllMenuList().get(num-1);
						int index = orderList.indexOf( x );	
						orderList.get(index).setAmount(n);
						System.out.println( "You have ordered : " );
						for(int i=0; i<orderList.size() ;i++) {
							System.out.println( orderList.get(i).toString() );
						}
					}
				}
				else if( choice.equalsIgnoreCase("D") ) {
					Menu x = menuManager.getAllMenuList().get(num-1);
					orderList.remove( x );
					System.out.println( "You have ordered : " );
					for(int i=0; i<orderList.size() ;i++) {
						System.out.println( orderList.get(i).toString() );
					}
				}
				else {
					System.out.println( "Invalid input , please try again." );
				}
			}
		} catch( Exception ex ) {
			System.out.println( "Invalid input , please try again." );
		}
	}

	public boolean containMenu( Menu m ) {
		for(int i=0;i<orderList.size();i++) {
			if( orderList.get(i).getMenuID() == m.getMenuID() ) {
				return true;
			}
		}
		return false;
	}
	
	public int findTotalCost( List<Menu> list ) {
		int total = 0;
		for(int a=0;a<list.size();a++) {
			total = total + list.get(a).getAmount()*list.get(a).getMenuCost();
		}
		return total;
	}


}
