package ProjectOOP2;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerInMenuWindow extends JSpinner implements Observer {

	private int ID;
	private ConsoleUI UI;
	private int currentNum;
	private SpinnerNumberModel x;
	
	public SpinnerInMenuWindow( ConsoleUI UI , int ID) {
		this.UI = UI;
		this.ID = ID;
		x = new SpinnerNumberModel( 0 , 0 , 100 , 1 );
		this.setModel( x );
		((JSpinner.DefaultEditor) this.getEditor()).getTextField().setEditable(false);
		SpinnerListener action = new SpinnerListener();
		this.addChangeListener( action );
		
	}

	@Override
	public void update(Observable o, Object arg) {
		int index = UI.getOrderList().indexOf( UI.getMenuBook().getAllMenuList().get( ID ) );
		if( index != -1 ) {
			x.setValue( UI.getOrderList().get(index).getAmount() );
		}
		else {
			x.setValue( 0 );
		}
	}
	
	class SpinnerListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if( (int)x.getValue()!=0 ) {
				int newAmount = (int) x.getValue();
				UI.setAmountMenuInOrderList( ID , newAmount );								
			}
			else {
				if( UI.getOrderList().contains( UI.getMenuBook().getAllMenuList().get(ID) ) ) {
	
					UI.deleteMenuInOrderList( ID );					
				}
			}
		}
		
	}
	
}
