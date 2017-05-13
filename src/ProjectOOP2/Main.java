package ProjectOOP2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[]args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		MenuManager menuManager = new MenuManager("EngMenu.csv");
		JamieGUI jamieGUI = new JamieGUI( menuManager );
		ConsoleUI UI = new ConsoleUI( menuManager );
		UI.run();
	}

}
