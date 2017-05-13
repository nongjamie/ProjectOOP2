package ProjectOOP2;

import javax.swing.JPanel;

public class StatusWindow {
	
	private JPanel myPanel;
	private MenuManager menuManager;
	
	public StatusWindow( MenuManager menuManager ) {
		this.menuManager = menuManager;
		myPanel = new JPanel();
	}
	
	public JPanel getPanel() {
		return myPanel;
	}
	
}