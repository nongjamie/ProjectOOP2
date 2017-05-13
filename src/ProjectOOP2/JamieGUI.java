package ProjectOOP2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextArea;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class JamieGUI {
	
	// General
	private JFrame frame;
	private MenuManager menuManager;
	
	// Top section
	private JTabbedPane mainTab;
	private JPanel topPanel;
	
	// Buttom section
	private JPanel buttomPanel;
	private JLabel textLabel;
	
	public JamieGUI( MenuManager menuManager ) {
		this.menuManager = menuManager;
		frame = new JFrame("SKE14 Restaurant");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		initComponent();
		addAllComponent();
		run();
	}
	
	public void run() {
		frame.setVisible( true );
//		frame.setSize( 900 , 610 );
		frame.pack();
	}
	
	public void initComponent() {
		
		// Top section
		topPanel = new JPanel();
		mainTab = new JTabbedPane();
		mainTab.setTabLayoutPolicy( JTabbedPane.SCROLL_TAB_LAYOUT );
		MenuWindow menuWindow = new MenuWindow( menuManager );
		ConfirmWindow confirmWindow = new ConfirmWindow( menuManager );
		StatusWindow statusWindow = new StatusWindow( menuManager );
		mainTab.add( "Menu" , menuWindow.getPanel() );
		mainTab.add( "Confirm" , confirmWindow.getPanel() );
		mainTab.add( "Status" , statusWindow.getPanel() );
		
		// Buttom section
		buttomPanel = new JPanel();
		textLabel = new JLabel();
		textLabel.setText( "--> SKE14 Restaurant <--" );
		
	}
	
	public void addAllComponent() {
		
		// Top section
		topPanel.add( mainTab );
		
		// Buttom section
		buttomPanel.add( textLabel );
		
		// Add into the frame
		frame.add( topPanel , BorderLayout.NORTH);
		frame.add( buttomPanel , BorderLayout.SOUTH );
	}
	
}


