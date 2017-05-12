package ProjectOOP2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuManager {

	private List<Menu> list;
	private int capacity = 0;
	
	public MenuManager() {
		list = new ArrayList<Menu>();
		createMenu();
	}
	
	public void createMenu() {
		Menu m1= new Menu( 1 , "Kao Man Kai" , 100);
		Menu m2= new Menu( 2 , "Kao Pat" , 200);
		Menu m3= new Menu( 3 , "Kai Tod" , 300);
		Menu m4= new Menu( 4 , "Moo Ping" , 400);
		Menu m5= new Menu( 5 , "Salapao" , 500);
		Menu[] menuArray = {m1, m2, m3, m4, m5};
		for( Menu x : menuArray) {
			list.add( x );
			capacity++;
		}
	}
	
	public List<Menu> getAllMenuList() {
		return list;
	}
	
	public void printAllMenu() {
		for( Menu eachMenu : list ) {
			System.out.println( eachMenu );
		}
	}
	
	public int getCapacity() {
		return capacity;
	}
}
