package ProjectOOP2;
import java.io.IOException;
import java.util.*;
public class ConsoleUI extends Observable {

	private MenuBook menuBook;
	private List<Menu> orderList;

	public ConsoleUI( MenuBook menuBook ) {
		this.menuBook = menuBook;
		orderList = new ArrayList<Menu>();
	}

	public int getCapacityOfMenu() {
		return menuBook.getCapacity();
	}

	public MenuBook getMenuBook() {
		return menuBook;
	}

	public List<Menu> getOrderList() {
		return orderList;
	}

	public void AddToOrderList( Menu menu ) {
		if( orderList.contains( menu ) ) {
			orderList.remove( menu );
			orderList.add( menu );
		}
		else {
			orderList.add( menu );
		}
		Collections.sort( orderList , new Comparator<Menu>() {

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


		} );
		setChanged();
		notifyObservers();
		System.out.println( toStringFromOrderList() );
	}

	public String toStringFromOrderList() {
		String s = "";
		for( Menu x : orderList ) {
			s = s.concat( " "+x.toString()+"\n" );
		}
		return s;
	}

	public int getTotalCost() {
		int x = 0;
		for( Menu y : orderList) {
			x = x + (y.getMenuCost()*y.getAmount()) ;
		}
		return x;
	}

	public int getTotalAmount() {
		int x = 0;
		for( Menu y : orderList ) {
			x = x + y.getAmount();
		}
		return x;
	}

	public void setNewOrderList() {
		orderList.clear();
		menuBook.resetMenu();
		setChanged();
		notifyObservers();
	}

	public void setAmountMenuInOrderList( int ID , int amount ) {
		if( orderList.contains( menuBook.getAllMenuList().get( ID ) ) ) {
			int indexInOrderList = orderList.indexOf( menuBook.getAllMenuList().get( ID ) );
			orderList.get( indexInOrderList ).setAmount( amount );
		}
		else {
				orderList.add( menuBook.getAllMenuList().get( ID ) );				
		}
		setChanged();
		notifyObservers();
	}
	
	public void deleteMenuInOrderList( int ID ) {
		int indexDelete = orderList.indexOf( menuBook.getAllMenuList().get(ID) );
		orderList.remove( indexDelete );
		setChanged();
		notifyObservers();
	}

}


/**
 * -----------------------------------------------------------------------
 */

//package ProjectOOP2;
//import java.util.*;
//public class ConsoleUI {
//
//	private boolean controlOrder = true;
//	private MenuManager menuManager;
//	private List<Menu> orderList;
//
//	public ConsoleUI( MenuManager menuManager ) {
//		this.menuManager = menuManager;
//		orderList = new ArrayList<Menu>();
//		menuManager.printAllMenu();
//	}
//
//	public void run() {
//		while( controlOrder ) {
//			Scanner input = new Scanner( System.in );
//			System.out.print( "What menu do you want to eat? [Ex: 1,3,5][(C)onfirm / (Q)uit] : " );
//			String ans = input.nextLine();
//			if( ans.equalsIgnoreCase("c") || ans.equalsIgnoreCase("q") ) {
//				analyzeConfirm( orderList );
//			}
//			else {
//				analyzeOrder( ans );				
//			}
//		}
//	}
//
//	public void analyzeOrder(String ans) {
//		String[] ansSplit = ans.split(",");
//		for(int i=0;i<ansSplit.length;i++) {
//			try {
//				int num = Integer.parseInt( ansSplit[i].trim() );
//				if( num > menuManager.getCapacity() ) {
//					System.out.print( "!!! Input --> "+num );
//					System.out.println( " --> We have only "+menuManager.getCapacity()+" menu." );
//				}
//				else {
//					Menu order = menuManager.getAllMenuList().get(num-1);
//					System.out.printf( "Input --> %-3d" , num );
//					System.out.printf( " --> You ordered ... "+"ID: %-3d, Name: %-23s --> %5d Baht.\n" ,order.getMenuID(),order.getMenuName(),order.getMenuCost());
//					if( containMenu( order ) ) {
//						int indexOfOrder = orderList.indexOf( order );
//						orderList.get( indexOfOrder ).addAmountByOne();
//					}
//					else {
//						orderList.add( order );	
//					}
//				}
//			} catch( Exception ex ) {
//				System.out.println( "!!! Input --> "+ansSplit[i]+" --> Invalid input , please try again." );
//			}
//		}
//		System.out.println( "Your orders are : " );
//		Collections.sort( orderList , new Comparator<Menu>(){
//
//			@Override
//			public int compare(Menu o1, Menu o2) {
//				if( o1.getMenuID() > o2.getMenuID() ) {
//					return +1;
//				}
//				else if( o1.getMenuID() < o2.getMenuID() ) {
//					return -1;
//				}
//				else {
//					return 0;
//				}
//			}
//
//		});
//		for(int g=0; g<orderList.size() ;g++) {
//			System.out.println( orderList.get(g).toString() );
//		}
//	}
//
//	public void analyzeConfirm( List<Menu> orderList ) {
//		this.orderList = orderList;
//		if( orderList.size()==0 ) {
//			Scanner input = new Scanner( System.in );
//			System.out.print( "You haven't ordered anything. Do you want to order again? (Y)es / (N)o : " );
//			String ans = input.nextLine();
//			while( !ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("n") ) {
//				System.out.print( "Invalid input , Do you want to order again? (y)Yes / (n)No : " );
//				String ans2 = input.nextLine();
//				ans = ans2;
//			}
//			if( ans.equalsIgnoreCase("n") ) {
//				System.out.println( "Bye Bye ~" );
//				controlOrder = false;
//			}
//		}
//		else {
//			printAllOrder();
//			boolean controlConfirmOrder = true;
//			while( controlConfirmOrder ) {
//				Scanner input = new Scanner( System.in );
//				System.out.print( "(C)onfirm order , (E)dit , (Q)uit : " );
//				String ans = input.nextLine().trim();
//				if( ans.equalsIgnoreCase("c") ) {
//					System.out.println( "You have confirm ordered : " );
//					printAllOrder();
//					int totalCost = findTotalCost( orderList );
//					System.out.printf( "%43s    --> %3d Baht.\n" , "Total cost" , totalCost );
//					System.out.println( "We will cooked for you now..." );
//					controlConfirmOrder = false;
//					controlOrder = false;
//				}
//				else if( ans.equalsIgnoreCase("e") ) {
//					editMenu();
//				}
//				else if( ans.equalsIgnoreCase("q") ) {
//					System.out.println( "Bye Bye ~" );
//					controlConfirmOrder = false;
//					controlOrder = false;
//				}
//				else {
//					System.out.println( " Invalid input , please try again." );
//				}
//			}
//
//		}
//	}
//
//	private void editMenu() {
//		Scanner input = new Scanner( System.in );
//		System.out.print( "Which menu ID do you want to edit? : " );
//		String ans = input.nextLine().trim();
//		try {
//			int num = Integer.parseInt( ans );
//			if( num > menuManager.getCapacity() ) {
//				System.out.println( " We haven't got that menu ID , please try again." );
//			}
//			else if( !containMenu( menuManager.getAllMenuList().get(num-1) ) ) {
//				System.out.println( "Don't have this menu ID in your ordered list , please try again." );
//			}
//			else {
//				System.out.print( "(A)mount , (D)elete : " );
//				String choice = input.nextLine().trim();
//				if( choice.equalsIgnoreCase("A") ) {
//					System.out.print( "What amount do you want? : ");
//					int n = Integer.parseInt( input.next() );
//					if( n <= 0 ) {
//						Menu x = menuManager.getAllMenuList().get(num-1);
//						int index = orderList.indexOf( x );	
//						orderList.remove( index );
//						printAllOrder();
//					}
//					else {
//						Menu x = menuManager.getAllMenuList().get(num-1);
//						int index = orderList.indexOf( x );	
//						orderList.get(index).setAmount(n);
//						printAllOrder();
//					}
//				}
//				else if( choice.equalsIgnoreCase("D") ) {
//					Menu x = menuManager.getAllMenuList().get(num-1);
//					orderList.remove( x );
//					printAllOrder();
//				}
//				else {
//					System.out.println( "Invalid input , please try again." );
//				}
//			}
//		} catch( Exception ex ) {
//			System.out.println( "Invalid input , please try again." );
//		}
//	}
//
//	public boolean containMenu( Menu m ) {
//		for(int i=0;i<orderList.size();i++) {
//			if( orderList.get(i).getMenuID() == m.getMenuID() ) {
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public void printAllOrder() {
//		System.out.println( "You have ordered : " );
//		for(int i=0; i<orderList.size() ;i++) {
//			System.out.println( orderList.get(i).toString() );
//		}
//	}
//	
//	public int findTotalCost( List<Menu> list ) {
//		int total = 0;
//		for(int a=0;a<list.size();a++) {
//			total = total + list.get(a).getAmount()*list.get(a).getMenuCost();
//		}
//		return total;
//	}
//
//
//}
