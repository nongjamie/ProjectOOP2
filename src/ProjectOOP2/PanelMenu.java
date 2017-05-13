package ProjectOOP2;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class PanelMenu {

	private JPanel myPanel;
	private JTextArea text;
	private Menu m;
	
	public PanelMenu( Menu m ) {
		this.m = m;
		myPanel = new JPanel();
		text = new JTextArea();		
		text.setText( "ID: "+m.getMenuID()+" , "+m.getMenuName()+" Price: "+m.getMenuCost()+" Baht." );
		myPanel.add( text );
	}
	
	public JPanel getPanelMenu() {
		return myPanel;
	}
	
}
