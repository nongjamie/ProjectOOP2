package ProjectOOP2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class RightButtonInMenuWindow extends JButton {

	private int ID;
	private String buttonName;
	private ConsoleUI UI;
	
	public RightButtonInMenuWindow( ConsoleUI UI , int ID ) {
		this.UI = UI;
		this.ID = ID;
		switch( ID ) {
		case 0:
			buttonName = "Confirm";
			break;
		case 1:
			buttonName = "Clear";
			break;
		case 2:
			buttonName = "Report";
			break;
		case 3:
			buttonName = "Quit";
			break;
		}
		this.setText( buttonName );
		ButtonListener action = new ButtonListener();
		this.addActionListener( action );
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			switch( ID ) {
			case 0:
				break;
			case 1:
				UI.setNewOrderList();
				break;
			case 2:
				break;
			case 3:
				UI.setNewOrderList();
				System.exit( 0 );
				break;
			}
		}
		
	}
	
}
