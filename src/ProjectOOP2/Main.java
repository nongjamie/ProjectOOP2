package ProjectOOP2;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[]args) {
		MenuManager menuManager = new MenuManager();
		ConsoleUI UI = new ConsoleUI( menuManager );
		UI.run();
	}
	
}
