package ProjectOOP2;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConfirmWindow implements Observer {
	
	private JPanel myPanel;
	private JTextArea textArea;
	private JTextArea textArea2;
	private ConsoleUI UI;
	
	public ConfirmWindow( ConsoleUI UI ) {
		this.UI = UI;
		myPanel = new JPanel();
		manageComponent();
	}
	
	public void manageComponent() {
		
	}
	
	public JPanel getPanel() {
		return myPanel;
	}

	@Override
	public void update(Observable o, Object arg) {
		
	}
	
}