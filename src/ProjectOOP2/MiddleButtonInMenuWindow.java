package ProjectOOP2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class MiddleButtonInMenuWindow extends JButton {

	private int buttonID;
	private MenuBook menuBook;
	private ConsoleUI UI;
	
	public MiddleButtonInMenuWindow( ConsoleUI UI , MenuBook menuBook , int buttonID ) {
		this.UI = UI;
		this.menuBook = menuBook;
		this.buttonID = buttonID;
		this.setText( menuBook.getAllMenuList().get( buttonID ).getMenuCost()+" Baht."  );
		ButtonListener action = new ButtonListener();
		this.addActionListener( action );
	}
	
	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Menu menu = menuBook.getAllMenuList().get( buttonID );
			List<Menu> orderList = UI.getOrderList();
			if( orderList.contains( menu ) ) {
				menu.addAmountByOne();
				UI.AddToOrderList( menu );
			}
			else {
				UI.AddToOrderList( menu );
			}
		}
		
	}
	
}
