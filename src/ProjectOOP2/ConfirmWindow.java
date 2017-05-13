package ProjectOOP2;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConfirmWindow {
	
	private JPanel myPanel;
	private JTextArea textArea;
	private JTextArea textArea2;
	private MenuManager menuManager;
	
	public ConfirmWindow( MenuManager menuManager ) {
		this.menuManager = menuManager;
		myPanel = new JPanel();
		textArea = new JTextArea();
		textArea2 = new JTextArea();
		manageComponent();
	}
	
	public void manageComponent() {
		textArea.setPreferredSize( new Dimension( 580 , 500 ) );
		textArea2.setText( "$$$ SKE14 Restaurant $$$" );
		myPanel.add( textArea );
		myPanel.add( textArea2 );
	}
	
	public JPanel getPanel() {
		return myPanel;
	}
	
}