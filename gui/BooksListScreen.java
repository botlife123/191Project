package gui;
/*
 * Lead Author(s):
 * @author Zalma Farah
 * @author Joshua Bernardi
 * * <<add additional lead authors here, with a full first and last name>>
 * 
 *  Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * <<add more references here>>
 * 
 * Version/date: 12/2/2024
 * Responsibilities of class: This class displays a list of books in the system with options 
 * 
 */
import java.awt.BorderLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Book;
import model.Database;
import model.FileDatabase;

/**
 * This screen shows all books in the system
 */
@SuppressWarnings("serial")
public class BooksListScreen extends JFrame
{
	/**
	 * database reference
	 */
	private FileDatabase database;
	
	/**
	 * reference to main screen
	 */
	private MainScreen mainScreen;
	
	/**
	 * constructor
	 */
	public BooksListScreen(MainScreen mainScreen) {
		
		this.mainScreen = mainScreen;
		
		setTitle("Library System - List all books");
		setSize(1000, 800);
		setLocationRelativeTo(null); //center the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		database = FileDatabase.getDB();
		
		//show books
		showBooks();
		
		//show control
		showControl();
	}
	
	/**
	 * show control panel
	 */
	private void showControl() {
		
		JButton btnBack = new JButton("Back");
		JPanel bottomPanel = new JPanel();
		bottomPanel.add(btnBack);
		
		add(bottomPanel, BorderLayout.SOUTH);
		
		//set action for button
		btnBack.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				setVisible(false);
				mainScreen.setVisible(true);
			}
		});
	}
	
	/**
	 * show books on the screen
	 */
	public void showBooks() {
		
		setLayout(new BorderLayout());
		
		List<Book> books = database.getBooks();
		
		BookTableModel model = new BookTableModel(books);
		JTable bookTable = new JTable(model);
		
		//create panel to contain the table
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportView(bookTable);;
		
		//put as the center
		add(centerPanel, BorderLayout.CENTER);
	}

}
