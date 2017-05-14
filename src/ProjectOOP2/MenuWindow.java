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

public class MenuWindow extends Observable implements Observer {
	
	// General
	private ConsoleUI UI;
	private JPanel totalPanel;
	
	// Left side
	private JPanel myPanelLeft;
	private JTextPane textAreaLeft;
	private SpinnerInMenuWindow spinner ;

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
	 * @param UI , ConsoleUI
	 */
	public MenuWindow( ConsoleUI UI ) {
		this.UI = UI;
		
		// Left side
		myPanelLeft = new JPanel();
		myPanelLeft.setLayout( new BoxLayout( myPanelLeft , BoxLayout.Y_AXIS ) );

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
		myPanelLeft.setPreferredSize( new Dimension( 380 , 400 ) );
		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setFont( new Font("TimesRoman", Font.BOLD, 40) );
		JPanel tempPanelLeft = new JPanel();
		tempPanelLeft.add( menuLabel , BorderLayout.CENTER );
		myPanelLeft.add( tempPanelLeft);
		for( int i = 0 ; i < UI.getCapacityOfMenu() ; i++ ) {
			JPanel miniPanel = new JPanel();
			miniPanel.setLayout( new BorderLayout() );
			Menu x = UI.getMenuBook().getAllMenuList().get(i);
			JLabel y = new JLabel( String.format( "ID: %-5d %s" , x.getMenuID() , x.getMenuName() ) );
			y.setFont( new Font("TimesRoman", Font.PLAIN, 15) );
			miniPanel.add( y , BorderLayout.WEST);
			JPanel miniPanel2 = new JPanel();
			miniPanel2.add( new MiddleButtonInMenuWindow( UI , UI.getMenuBook() ,  i ) , BorderLayout.WEST);
			spinner = new SpinnerInMenuWindow( UI  , i);
			this.addObserver( spinner );
			miniPanel2.add( spinner , BorderLayout.EAST);
			miniPanel.add( miniPanel2 , BorderLayout.EAST );
			myPanelLeft.add( miniPanel );
		}
		
		// Right
		paneRight.setPreferredSize( new Dimension( 420 , 270 ) );
		textAreaRight.setEnabled( false );
		JPanel tempPanelRight = new JPanel();
		textLabelRight.setFont( new Font("TimesRoman", Font.BOLD, 35 ) );
		tempPanelRight.add( textLabelRight , BorderLayout.CENTER );
		myPanelRight.add( tempPanelRight );
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
		setChanged();
		notifyObservers();
	}
	
}
