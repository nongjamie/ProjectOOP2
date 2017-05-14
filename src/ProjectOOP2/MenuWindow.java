package ProjectOOP2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuWindow implements Observer {
	
	// General
	private ConsoleUI UI;
	private JPanel totalPanel;
	
	// Left side
	private JPanel myPanelLeft;
	private JTextPane textAreaLeft;

	// Middle
	private JPanel myPanelMiddle;
	
	// Right side
	private JPanel myPanelRight;
	private JLabel textLabelRight;
	private JTextArea textAreaRight;
	private JScrollPane paneRight;
	private JPanel statusPanel;
	private JButton amountShow;
	private JButton totalShow;
	private JPanel buttonPanel;
	
	/**
	 * This is the constuctor.
	 * @param UI
	 */
	public MenuWindow( ConsoleUI UI ) {
		this.UI = UI;
		
		// Left side
		myPanelLeft = new JPanel();
		myPanelLeft.setLayout( new BoxLayout( myPanelLeft , BoxLayout.Y_AXIS ) );

		// Middle
		myPanelMiddle = new JPanel( );
		myPanelMiddle.setLayout( new BoxLayout( myPanelMiddle , BoxLayout.Y_AXIS ) );
		
		// Right side
		myPanelRight = new JPanel();
		myPanelRight.setLayout( new BoxLayout( myPanelRight , BoxLayout.Y_AXIS) );
		
		textLabelRight = new JLabel( "Ordered List" );
		
		textAreaRight = new JTextArea();
		paneRight = new JScrollPane( textAreaRight );
		paneRight.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		
		statusPanel = new JPanel();
		statusPanel.setLayout( new BoxLayout( statusPanel , BoxLayout.X_AXIS ) );
		amountShow = new JButton( "Amount = 0.");
		totalShow = new JButton( "Total 0 Baht." );
		amountShow.setEnabled( false );
		totalShow.setEnabled( false );
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new BoxLayout( buttonPanel , BoxLayout.X_AXIS) );
		
		manageComponent();
	}
	
	/**
	 * Manage components and take them into panel.
	 */
	public void manageComponent() {
		
		// Left
		myPanelLeft.setPreferredSize( new Dimension( 220 , 400 ) );
		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setFont( new Font("TimesRoman", Font.BOLD, 40) );
		myPanelLeft.add( menuLabel  );
		for( int i = 0 ; i < UI.getCapacityOfMenu() ; i++ ) {
			Menu x = UI.getMenuBook().getAllMenuList().get(i);
			JLabel y = new JLabel( String.format( "ID: %-5d %s" , x.getMenuID() , x.getMenuName() ) );
			y.setFont( new Font("TimesRoman", Font.PLAIN, 15) );
			myPanelLeft.add( y );
		}
		
		// Middle
		myPanelMiddle.setPreferredSize( new Dimension( 130 , 400 ) );
		for( int a = 0 ; a < UI.getCapacityOfMenu() ; a++ ) {
			myPanelMiddle.add( new MiddleButtonInMenuWindow( UI , UI.getMenuBook() ,  a ) );
		}
		
		// Right
		paneRight.setPreferredSize( new Dimension( 400 , 350 ) );
		textAreaRight.setEnabled( false );
		myPanelRight.add( textLabelRight );
		myPanelRight.add( paneRight );
		statusPanel.add( amountShow );
		statusPanel.add( totalShow );
		myPanelRight.add( statusPanel );
		for( int i = 0 ; i < 4 ; i++) {
			buttonPanel.add( new RightButtonInMenuWindow( UI , i ) );
		}
		myPanelRight.add( buttonPanel );
		
	}
	
	/**
	 * Send Menu content.
	 * @return totalPanel , all panel of this part.
	 */
	public JPanel getPanel() {
		totalPanel = new JPanel();
		totalPanel.add( myPanelLeft );
		totalPanel.add( myPanelMiddle );
		totalPanel.add( myPanelRight );
		return totalPanel;
	}

	/**
	 * Use Observer pattern.
	 */
	@Override
	public void update(Observable o, Object arg) {
		textAreaRight.setText( UI.toStringFromOrderList() );
		totalShow.setText( "Total "+UI.getTotalCost()+" Baht." );
		amountShow.setText( "Amount = "+UI.getTotalAmount()+"." );
	}
	
}
