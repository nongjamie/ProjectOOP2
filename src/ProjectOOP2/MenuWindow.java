package ProjectOOP2;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MenuWindow {
	
	// General
	private MenuManager menuManager;
	private JPanel totalPanel;
	
	// Left side
	private JPanel myPanelLeft0;
	private JPanel myPanelLeft;
	private JTextPane textAreaLeft;

	// Middle
	private JPanel myPanelMiddle0;
	private JPanel myPanelMiddle;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	private JButton button7;
	private JButton button8;
	private JButton button9;
	private JButton button10;
	
	// Right side
	private JPanel myPanelRight;
	private JLabel textLabelRight;
	private DefaultListModel modelRight;
	private JList listRight;
	private JScrollPane paneRight;
	private JPanel buttonPanel;
	private JButton confirmButton;
	private JButton clearButton;
	private JButton reportButton;
	private JButton quitButton;
	
	
	public MenuWindow( MenuManager menuManager ) {
		this.menuManager = menuManager;
		
		// Left side
		myPanelLeft0 = new JPanel();
		myPanelLeft0.setLayout( new BorderLayout() );
		myPanelLeft = new JPanel();
		myPanelLeft.setLayout( new BoxLayout( myPanelLeft , BoxLayout.Y_AXIS ) );

		// Middle
		myPanelMiddle0 = new JPanel();
		myPanelMiddle0.setLayout( new BorderLayout() );
		myPanelMiddle = new JPanel( );
		myPanelMiddle.setLayout( new BoxLayout( myPanelMiddle , BoxLayout.Y_AXIS ) );
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		button10 = new JButton("10");
		
		// Right side
		myPanelRight = new JPanel();
		myPanelRight.setLayout( new BoxLayout( myPanelRight , BoxLayout.Y_AXIS) );
		textLabelRight = new JLabel( "Ordered List" );
		modelRight = new DefaultListModel();
		listRight = new JList( modelRight );
		paneRight = new JScrollPane( listRight );
		paneRight.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
		buttonPanel = new JPanel();
		buttonPanel.setLayout( new BoxLayout( buttonPanel , BoxLayout.X_AXIS) );
		confirmButton = new JButton( "Confirm" );
		clearButton = new JButton( "Clear" );
		reportButton = new JButton( "Report" );
		quitButton = new JButton( "Quit" );
		
		manageComponent();
	}
	
	public void manageComponent() {
		
		// Left side
		JLabel menuLabel = new JLabel("Menu");
		menuLabel.setFont( new Font("TimesRoman", Font.BOLD, 40) );
		myPanelLeft.add( menuLabel  );
		for(int i=0;i<menuManager.getCapacity();i++) {
			Menu x = menuManager.getAllMenuList().get(i);
			JLabel y = new JLabel( "ID: "+x.getMenuID()+"   "+x.getMenuName()+"   "+x.getMenuCost()+" Baht." );
			y.setFont( new Font("TimesRoman", Font.PLAIN, 15) );
			myPanelLeft.add( y );
		}
		myPanelLeft0.add( myPanelLeft , BorderLayout.NORTH );
		
		// Middle
		myPanelMiddle.add( button1 );
		myPanelMiddle.add( button2 );
		myPanelMiddle.add( button3 );
		myPanelMiddle.add( button4 );
		myPanelMiddle.add( button5 );
		myPanelMiddle.add( button6 );
		myPanelMiddle.add( button7 );
		myPanelMiddle.add( button8 );
		myPanelMiddle.add( button9 );
		myPanelMiddle.add( button10 );
		myPanelMiddle0.add( myPanelMiddle , BorderLayout.NORTH );
		
		// Right side
		paneRight.setPreferredSize( new Dimension( 300 , 400 ) );
		myPanelRight.add( textLabelRight );
		myPanelRight.add( paneRight );
		buttonPanel.add( confirmButton );
		buttonPanel.add( clearButton );
		buttonPanel.add( reportButton );
		buttonPanel.add( quitButton );
		myPanelRight.add( buttonPanel );
		
	}
	
	public JPanel getPanel() {
		totalPanel = new JPanel();
		totalPanel.add( myPanelLeft0 );
		totalPanel.add( myPanelMiddle0 );
		totalPanel.add( myPanelRight );
		return totalPanel;
	}

	
}
