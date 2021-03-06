package ProjectOOP2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MenuBook {

	private InputStream inputStream;
	private BufferedReader buffReader;
	private String readLine;
	private List<Menu> list;
	private List<Integer> readID;
	private List<String> readMenu;
	private List<Integer> readPrice;
	private int capacity = 0;

	public MenuBook( String name ) throws IOException {
		list = new ArrayList<Menu>();
		readID = new ArrayList<Integer>();
		readMenu = new ArrayList<String>();
		readPrice = new ArrayList<Integer>();
		inputStream = new FileInputStream( name );
		buffReader = new BufferedReader( new InputStreamReader( inputStream ) );
		createMenu();
	}

	public void createMenu() throws IOException {
		readLine = buffReader.readLine();
		while( readLine!=null ) {
			String[] tempBox = readLine.split( "," );
			int id = Integer.parseInt( tempBox[0].trim() );
			String name = tempBox[1].substring( 1 , tempBox[1].length() );
			int price = Integer.parseInt( tempBox[2].trim() );
			readID.add( id );
			readMenu.add( name );
			readPrice.add( price );
			readLine = buffReader.readLine();
		}
		
		for( int i=0 ; i<readID.size() ; i++ ) {
			list.add( new Menu( readID.get(i) , readMenu.get(i) , readPrice.get(i) ) );
			capacity++;
		}
	}

	public List<Menu> getAllMenuList() {
		return list;
	}

	public int[] getIDArray() {
		int[] box = new int[ readID.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readID.get(i);
		}
		return box;
	}
	
	public String[] getMenuArray() {
		String[] box = new String[ readMenu.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readMenu.get(i);
		}
		return box;
	}
	
	public int[] getPriceArray() {
		int[] box = new int[ readPrice.size() ];
		for(int i=0;i<box.length;i++) {
			box[i] = readPrice.get(i);
		}
		return box;
	}
	
	public void printAllMenu() {
		for( Menu eachMenu : list ) {
			System.out.printf( "ID: %-3d , %-20s   %d Baht.\n" , eachMenu.getMenuID() , eachMenu.getMenuName() , eachMenu.getMenuCost() );
		}
	}

	public int getCapacity() {
		return capacity;
	}
	
	public void resetMenu() {
		for( int i=0 ; i<list.size() ; i++ ) {
			list.get(i).setAmount(0);
		}
	}
}
