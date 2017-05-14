package ProjectOOP2;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

	public static void main(String[]args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
//		UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		MenuBook menuBook = new MenuBook("EngMenu.csv");
		ConsoleUI UI = new ConsoleUI( menuBook );
		JamieGUI jamieGUI = new JamieGUI( UI );
		UI.addObserver( jamieGUI );
	}

}
