package ProjectOOP2;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class StatusWindow implements Observer {
	
	private JPanel myPanel;
	private ConsoleUI UI;
	
	public StatusWindow( ConsoleUI UI ) {
		this.UI = UI;
		myPanel = new JPanel();
	}
	
	public JPanel getPanel() {
		return myPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}