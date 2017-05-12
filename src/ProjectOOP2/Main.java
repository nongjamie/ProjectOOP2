package ProjectOOP2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[]args) throws IOException {
		MenuManager menuManager = new MenuManager("EngMenu.csv");
		ConsoleUI UI = new ConsoleUI( menuManager );
		UI.run();
	}
	
}
