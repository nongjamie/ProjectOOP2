package ProjectOOP2;

import javax.swing.JPanel;

public class StatusWindow {
	
	private JPanel myPanel;
	private ConsoleUI UI;
	
	public StatusWindow( ConsoleUI UI ) {
		this.UI = UI;
		myPanel = new JPanel();
	}
	
	public JPanel getPanel() {
		return myPanel;
	}
	
}