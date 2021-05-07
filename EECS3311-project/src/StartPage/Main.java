package StartPage;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Accounts.AdminPage;
import Accounts.CustomerPage;
import Accounts.EnforcerPage;
import Other.Bookings;
import Other.Card;
import Other.DataBase;
import Other.ParkingSpot;
import User.Customer;
import User.ParkingEnforcer;
import User.SystemAdmin;
import User.User;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTree;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextPane;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.ScrollPaneConstants;
import java.awt.List;

public class Main {

	
	DataBase db = new DataBase();
	AdminPage adminPage;
	CustomerPage cusPage;
	EnforcerPage officerPage;
	
	private JFrame frame;
	private JPasswordField passwordField;
	private JTextField regFirstName;
	private JTextField regLastName;
	private JTextField regEmail;
	private JTextField regPass;
	private JLayeredPane layeredPane;
	private JTextField userField;
	private JTextField signInMessageBox;
	private JTextField signUpMessageBox;
	private JTextField officerName;
	private JTextField officerLast;
	private JTextField officerEmail;
	private JTextField officerPass;
	private JTextField adminAddMessage;
	private JTextField officerEmail2;
	private JTextField adminRmvMessage;
	private JTextField cusBookMssg;
	private JTextField spotIdField;
	private JTextField bookIdMssg;
	private JTextField licensePlate;
	private JTextField cusViewMssg;
	private JTextField cusCancelMssg;
	private JTextField bookingId;
	private JTextPane bookingDetails;
	private JTextField payMssg1;
	private JTextField pay2Mssg;
	private JTextField cardFirst;
	private JTextField cardNum;
	private JTextField cardCVV;
	private JTextField cardLast;
	private JTextField mngPymntMssg;
	private JTextField mngSpotMssg;
	private JTextField spotId;
	private JTextField addSpotMssg;
	private JTextField spotId2;
	private JTextField rmvMssg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 852, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 11, 816, 419);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		
		//Panels
		//===========================================
		JPanel signUp = new JPanel();
		JPanel adminAddOfficer = new JPanel();
		JPanel signIn = new JPanel();
		JPanel adminMain = new JPanel();
		JPanel StartPage = new JPanel();
		JPanel adminRmvOfficer = new JPanel();
		JPanel cusMain = new JPanel();
		JPanel cusAddBook = new JPanel();
		JPanel cusViewBook = new JPanel();
		JPanel cusCancelBook = new JPanel();
		JPanel cusPay1 = new JPanel();
		JPanel cusPay2 = new JPanel();
		JPanel adminMngPymnt = new JPanel();
		JPanel officerMain = new JPanel();
		JPanel officerMngSpot = new JPanel();
		JPanel officerAddSpot = new JPanel();
		JPanel officerRmvSpot = new JPanel();
		//===========================================
		
		//Other
		//===========================================
		JList<String> viewList = new JList<String>();
		JList<String> payList = new JList<String>();
		JList<String> pendingList = new JList<String>();
		bookingDetails = new JTextPane();
		JTextPane bookingDetails3 = new JTextPane();
		JTextPane officerDetails = new JTextPane();
		JSpinner expMonth = new JSpinner();
		JSpinner expYear = new JSpinner();
		JTextPane bookingDetails2 = new JTextPane();
		JList spotList = new JList();
		JScrollPane spotListScroll = new JScrollPane (spotList);
		//===========================================
		
		signIn.setBackground(new Color(224, 255, 255));
		layeredPane.add(signIn, "name_94736068091500");
		signIn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SIGN IN");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 55));
		lblNewLabel.setBounds(310, 11, 209, 64);
		signIn.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(299, 146, 53, 31);
		signIn.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Pass:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(299, 188, 53, 31);
		signIn.add(lblNewLabel_1_1);
		
		signInMessageBox = new JTextField();
		signInMessageBox.setEditable(false);
		signInMessageBox.setHorizontalAlignment(SwingConstants.CENTER);
		signInMessageBox.setBackground(new Color(224, 255, 255));
		signInMessageBox.setForeground(Color.BLACK);
		signInMessageBox.setBounds(310, 86, 209, 40);
		signIn.add(signInMessageBox);
		signInMessageBox.setColumns(10);
		
		JButton btnNewButton = new JButton("Sign In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = db.signIn(userField.getText(), String.valueOf(passwordField.getPassword()));

				if (user!=null)
				{
	
					if (user instanceof Customer)
					{
						cusPage = new CustomerPage ((Customer)user, db);
						userField.setText("");passwordField.setText("");
						userField.update(userField.getGraphics());
						passwordField.update(passwordField.getGraphics());
						setTextBox(signInMessageBox, "", "Black");
						switchPanels(cusMain);
					}
					else if (user instanceof SystemAdmin)
					{
						adminPage = new AdminPage (db);
						userField.setText("");passwordField.setText("");
						userField.update(userField.getGraphics());
						passwordField.update(passwordField.getGraphics());
						setTextBox(signInMessageBox, "", "Black");
						switchPanels(adminMain);
						
					}
					else if (user instanceof ParkingEnforcer)
					{
						officerPage = new EnforcerPage ((ParkingEnforcer)user, db);
						setTextBox(userField, "", "BLACK");
						setTextBox(passwordField, "", "BLACK");
						setTextBox(signInMessageBox, "", "Black");
						switchPanels(officerMain);
					}
				
				}
				else
				{
					setTextBox(signInMessageBox, "Account Not Found", "RED");
						
				}
				db.writeAll();
			}
			
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(362, 227, 104, 35);
		signIn.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(250, 250, 210));
		passwordField.setBounds(362, 185, 157, 31);
		signIn.add(passwordField);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signInMessageBox.setText("");
				signInMessageBox.update(signInMessageBox.getGraphics());
				switchPanels (signUp);
				db.writeAll();
			}
		});
		btnRegister.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegister.setBounds(362, 326, 104, 35);
		signIn.add(btnRegister);
		
		userField = new JTextField();
		userField.setBackground(new Color(255, 239, 213));
		userField.setColumns(10);
		userField.setBounds(361, 149, 158, 28);
		signIn.add(userField);
		
		
		
		signUp.setBackground(new Color(224, 255, 255));
		layeredPane.add(signUp, "name_94736082629300");
		signUp.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("SIGN UP");
		lblNewLabel_2.setBounds(306, 5, 226, 64);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 55));
		signUp.add(lblNewLabel_2);
		
		regFirstName = new JTextField();
		regFirstName.setBounds(374, 135, 158, 28);
		signUp.add(regFirstName);
		regFirstName.setColumns(10);
		
		regLastName = new JTextField();
		regLastName.setColumns(10);
		regLastName.setBounds(374, 173, 158, 28);
		signUp.add(regLastName);
		
		regEmail = new JTextField();
		regEmail.setColumns(10);
		regEmail.setBounds(374, 211, 158, 28);
		signUp.add(regEmail);
		
		regPass = new JTextField();
		regPass.setColumns(10);
		regPass.setBounds(374, 249, 158, 28);
		signUp.add(regPass);
		
		JLabel lblNewLabel_3 = new JLabel("First Name");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(302, 138, 72, 21);
		signUp.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Last Name");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(302, 176, 72, 21);
		signUp.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("E-Mail");
		lblNewLabel_3_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(302, 214, 72, 21);
		signUp.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("Password");
		lblNewLabel_3_3.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(302, 252, 72, 21);
		signUp.add(lblNewLabel_3_3);
		
		JButton btnRegister_1 = new JButton("Register");
		btnRegister_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (regFirstName.getText().length() > 1 && regLastName.getText().length()>1 && 
							regEmail.getText().length() > 1 && regPass.getText().length()>1 && regEmail.getText().contains("@"))
					{
						Customer cus = new Customer (regFirstName.getText(),regLastName.getText(),regEmail.getText(),
								regPass.getText());
						if (db.addCustomer(cus))
						{
							signUpMessageBox.setText("You Have Registered Succesfully");
							signUpMessageBox.update(signUpMessageBox.getGraphics());
						}
						else
						{
							signUpMessageBox.setText("Sign Up Failed Please Try Again");
							signUpMessageBox.update(signUpMessageBox.getGraphics());
						}
						
					}
					else
					{
						signUpMessageBox.setText("Sign Up Failed Please Try Again");
						signUpMessageBox.update(signUpMessageBox.getGraphics());
					}
					
					regFirstName.setText("");regLastName.setText("");regEmail.setText("");
					regPass.setText("");
					regFirstName.update(regFirstName.getGraphics());
					regLastName.update(regLastName.getGraphics());
					regEmail.update(regEmail.getGraphics());
					regPass.update(regPass.getGraphics());
					
					db.writeAll();
			}
			
		});
		btnRegister_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRegister_1.setBounds(384, 294, 104, 35);
		signUp.add(btnRegister_1);
		
		JButton regSignIn = new JButton("Sign In");
		regSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUpMessageBox.setText("");
				signUpMessageBox.update(signUpMessageBox.getGraphics());
				switchPanels (signIn);
				db.writeAll();
			}
		});
		regSignIn.setFont(new Font("Arial", Font.PLAIN, 15));
		regSignIn.setBounds(384, 373, 104, 35);
		signUp.add(regSignIn);
		
		signUpMessageBox = new JTextField();
		signUpMessageBox.setHorizontalAlignment(SwingConstants.CENTER);
		signUpMessageBox.setForeground(Color.BLACK);
		signUpMessageBox.setEditable(false);
		signUpMessageBox.setColumns(10);
		signUpMessageBox.setBackground(new Color(224, 255, 255));
		signUpMessageBox.setBounds(316, 80, 209, 40);
		signUp.add(signUpMessageBox);
		
		
		StartPage.setLayout(null);
		StartPage.setBackground(new Color(224, 255, 255));
		layeredPane.add(StartPage, "name_11136198403500");
		
		JLabel WelcomeMessage = new JLabel("Welcome to City of Toronto Parking Application");
		WelcomeMessage.setFont(new Font("Arial", Font.BOLD, 20));
		WelcomeMessage.setBounds(180, 77, 450, 24);
		StartPage.add(WelcomeMessage);
		
		JButton login = new JButton("Sign In");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(signIn);
				
				db.writeAll();
			}
		});
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		login.setBounds(180, 218, 96, 43);
		StartPage.add(login);
		
		JButton register = new JButton("Sign Up");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(signUp);
				
				db.writeAll();
			}
		});
		register.setFont(new Font("Tahoma", Font.BOLD, 15));
		register.setBounds(534, 218, 96, 43);
		StartPage.add(register);
		
		switchPanels(StartPage);
		
		
		adminMain.setLayout(null);
		adminMain.setBackground(new Color(224, 255, 255));
		layeredPane.add(adminMain, "name_71708346755000");
		
		JLabel lblNewLabel_4 = new JLabel("System Administrator");
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4.setBounds(245, 11, 322, 36);
		adminMain.add(lblNewLabel_4);
		
		JButton addOfficer = new JButton("Add Parking Enforcer");
		addOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(adminAddOfficer);
				
				db.writeAll();
			}
		});
		addOfficer.setFont(new Font("Arial", Font.BOLD, 11));
		addOfficer.setBounds(308, 176, 181, 44);
		adminMain.add(addOfficer);
		
		JButton removeOfficer = new JButton("Remove Parking Enforcer");
		removeOfficer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(adminRmvOfficer);
				
				db.writeAll();
				
			}
		});
		removeOfficer.setFont(new Font("Arial", Font.BOLD, 11));
		removeOfficer.setBounds(308, 237, 181, 44);
		adminMain.add(removeOfficer);
		
		JButton mngPayment = new JButton("Manage Payments");
		mngPayment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels (adminMngPymnt);
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				
				for (int i = 0; i < db.getBookings().size(); i ++)
				{	
					if (db.getBookings().get(i).isPaid() && !db.getBookings().get(i).isApproved())
					{
						listModel.addElement(db.getBookings().get(i).getBookingId());
					}
					
				}
				
				pendingList.setModel(listModel);		
				
				db.writeAll();
				
				
			}
		});
		mngPayment.setFont(new Font("Arial", Font.BOLD, 11));
		mngPayment.setBounds(308, 297, 181, 44);
		adminMain.add(mngPayment);
		
		JButton logout1 = new JButton("Logout");
		logout1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels (StartPage);
				adminPage = null;
				db.writeAll();
			}
		});
		logout1.setBounds(700, 385, 89, 23);
		adminMain.add(logout1);
		
		JLabel lblNewLabel_4_1_1_1_2_2 = new JLabel("Main Menu");
		lblNewLabel_4_1_1_1_2_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_2_2.setBounds(320, 58, 158, 36);
		adminMain.add(lblNewLabel_4_1_1_1_2_2);
		
		
		adminAddOfficer.setLayout(null);
		adminAddOfficer.setBackground(new Color(224, 255, 255));
		layeredPane.add(adminAddOfficer, "name_72513675267200");
		
		JLabel lblNewLabel_4_1 = new JLabel("System Administrator");
		lblNewLabel_4_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1.setBounds(245, 11, 322, 36);
		adminAddOfficer.add(lblNewLabel_4_1);
		
		officerName = new JTextField();
		officerName.setColumns(10);
		officerName.setBounds(362, 124, 158, 28);
		adminAddOfficer.add(officerName);
		
		JLabel lblNewLabel_3_4 = new JLabel("First Name");
		lblNewLabel_3_4.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(290, 127, 72, 21);
		adminAddOfficer.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Last Name");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_1_1.setBounds(290, 165, 72, 21);
		adminAddOfficer.add(lblNewLabel_3_1_1);
		
		officerLast = new JTextField();
		officerLast.setColumns(10);
		officerLast.setBounds(362, 162, 158, 28);
		adminAddOfficer.add(officerLast);
		
		officerEmail = new JTextField();
		officerEmail.setColumns(10);
		officerEmail.setBounds(362, 200, 158, 28);
		adminAddOfficer.add(officerEmail);
		
		JLabel lblNewLabel_3_2_1 = new JLabel("E-Mail");
		lblNewLabel_3_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2_1.setBounds(290, 203, 72, 21);
		adminAddOfficer.add(lblNewLabel_3_2_1);
		
		JLabel lblNewLabel_3_3_1 = new JLabel("Password");
		lblNewLabel_3_3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_3_1.setBounds(290, 241, 72, 21);
		adminAddOfficer.add(lblNewLabel_3_3_1);
		
		officerPass = new JTextField();
		officerPass.setColumns(10);
		officerPass.setBounds(362, 238, 158, 28);
		adminAddOfficer.add(officerPass);
		
		adminAddMessage = new JTextField();
		adminAddMessage.setHorizontalAlignment(SwingConstants.CENTER);
		adminAddMessage.setForeground(Color.BLACK);
		adminAddMessage.setEditable(false);
		adminAddMessage.setColumns(10);
		adminAddMessage.setBackground(new Color(224, 255, 255));
		adminAddMessage.setBounds(245, 75, 322, 40);
		adminAddOfficer.add(adminAddMessage);
		
		JButton addEnforcer = new JButton("Add Officer");
		addEnforcer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (officerName.getText().length() > 1 && officerLast.getText().length()>1 && 
						officerEmail.getText().length() > 1 && officerPass.getText().length()>1 && officerEmail.getText().contains("@"))
				{
					ParkingEnforcer officer = new ParkingEnforcer (officerName.getText(), officerLast.getText(), 
							officerEmail.getText(), officerPass.getText());
					if (adminPage.addOfficer(officer))
					{

						setTextBox(adminAddMessage, "Officer Registered Succesfully", "green");
					}
					else
					{
						
						setTextBox(adminAddMessage, "Account Already Exists", "RED");
					}
				
				}
				else
				{
					setTextBox(adminAddMessage, "Registration Failed Please Check Information", "RED");
				}
				
				officerName.setText("");officerLast.setText("");officerEmail.setText("");
				officerPass.setText("");
				
				officerName.update(officerName.getGraphics());
				officerLast.update(officerLast.getGraphics());
				officerEmail.update(officerEmail.getGraphics());
				officerPass.update(officerPass.getGraphics());
				db.writeAll();
			}
		});
		addEnforcer.setFont(new Font("Arial", Font.PLAIN, 15));
		addEnforcer.setBounds(362, 287, 121, 35);
		adminAddOfficer.add(addEnforcer);
		
		JButton bckMenu1 = new JButton("Previous Menu");
		bckMenu1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerName.setText("");officerLast.setText("");officerEmail.setText("");
				officerPass.setText("");
				
				officerName.update(officerName.getGraphics());
				officerLast.update(officerLast.getGraphics());
				officerEmail.update(officerEmail.getGraphics());
				officerPass.update(officerPass.getGraphics());
				setTextBox(adminAddMessage, "", "BLACK");
				
				switchPanels(adminMain);
				
				db.writeAll();
			}
		});
		bckMenu1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu1.setBounds(10, 11, 136, 35);
		adminAddOfficer.add(bckMenu1);
		
		
		adminRmvOfficer.setLayout(null);
		adminRmvOfficer.setBackground(new Color(224, 255, 255));
		layeredPane.add(adminRmvOfficer, "name_154732051490000");
		
		JLabel lblNewLabel_4_1_1 = new JLabel("System Administrator");
		lblNewLabel_4_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1.setBounds(245, 11, 322, 36);
		adminRmvOfficer.add(lblNewLabel_4_1_1);
		
		officerEmail2 = new JTextField();
		officerEmail2.setColumns(10);
		officerEmail2.setBounds(363, 192, 158, 28);
		adminRmvOfficer.add(officerEmail2);
		
		JLabel lblNewLabel_3_2_1_1 = new JLabel("E-Mail");
		lblNewLabel_3_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_2_1_1.setBounds(291, 195, 72, 21);
		adminRmvOfficer.add(lblNewLabel_3_2_1_1);
		
		adminRmvMessage = new JTextField();
		adminRmvMessage.setHorizontalAlignment(SwingConstants.CENTER);
		adminRmvMessage.setForeground(Color.BLACK);
		adminRmvMessage.setEditable(false);
		adminRmvMessage.setColumns(10);
		adminRmvMessage.setBackground(new Color(224, 255, 255));
		adminRmvMessage.setBounds(223, 141, 354, 40);
		adminRmvOfficer.add(adminRmvMessage);
		
		JButton RmvEnforcer = new JButton("Remove Officer");
		RmvEnforcer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (adminPage.removeOfficer(officerEmail2.getText()))
				{
					setTextBox(adminRmvMessage, "Parking Enforcer Officer Removed Succesfully", "green");
				}
				else
				{
					setTextBox(adminRmvMessage, "Parking Enforcer Not Found", "red");
				}
				db.writeAll();
			}
		});
		RmvEnforcer.setFont(new Font("Arial", Font.PLAIN, 15));
		RmvEnforcer.setBounds(324, 231, 158, 35);
		adminRmvOfficer.add(RmvEnforcer);
		
		JButton bckMenu2 = new JButton("Previous Menu");
		bckMenu2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextBox (officerEmail2,"","black");
				setTextBox(adminRmvMessage, "", "black");
			
				switchPanels(adminMain);
				
				
				db.writeAll();
			}
		});
		bckMenu2.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu2.setBounds(10, 11, 136, 35);
		adminRmvOfficer.add(bckMenu2);
		
		JLabel lblNewLabel_6 = new JLabel("Please Enter the Email Address of An Existing Officer");
		lblNewLabel_6.setFont(new Font("Arial", Font.BOLD, 15));
		lblNewLabel_6.setBounds(213, 109, 381, 21);
		adminRmvOfficer.add(lblNewLabel_6);
		
		
		cusMain.setLayout(null);
		cusMain.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusMain, "name_158851857927400");
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("Main Menu");
		lblNewLabel_4_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1.setBounds(339, 18, 158, 36);
		cusMain.add(lblNewLabel_4_1_1_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusPage = null;
				switchPanels (StartPage);
				db.writeAll();
			}
		});
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout.setBounds(692, 373, 114, 35);
		cusMain.add(btnLogout);
		
		JButton mainBookSpot = new JButton("Book Parking Spot");
		mainBookSpot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switchPanels(cusAddBook);
				db.writeAll();
			}
		});
		mainBookSpot.setBounds(339, 116, 145, 36);
		cusMain.add(mainBookSpot);
		
		JButton viewBookings = new JButton("View Bookings");
		viewBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cusViewBook);
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				if (cusPage.getCustomer().getSpotsReserved().size() == 0)
				{
					cusViewMssg.setText("You Currently Have No Bookings");
					cusViewMssg.update(cusViewMssg.getGraphics());
					viewList.clearSelection();
					viewList.setModel(listModel);
					
				}
				else
				{
					
						for (int i = 0; i < cusPage.getCustomer().getSpotsReserved().size(); i ++)
						{
							listModel.addElement(cusPage.getCustomer().getSpotsReserved().get(i));
						}
						
						viewList.setModel(listModel);

				}
				db.writeAll();
				
			}
		});
		viewBookings.setBounds(339, 163, 145, 36);
		cusMain.add(viewBookings);
		
		JButton btnCancelBookings = new JButton("Cancel Bookings");
		btnCancelBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(cusCancelBook);
				db.writeAll();
			}
		});
		btnCancelBookings.setBounds(339, 210, 145, 36);
		cusMain.add(btnCancelBookings);
		
		JButton btnPayForBookings = new JButton("Pay for Bookings");
		btnPayForBookings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switchPanels (cusPay1);
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				if (cusPage.getCustomer().getSpotsReserved().size() == 0)
				{
					setTextBox(payMssg1, "You Currently Have No Bookings or No Granted Access", "RED");
					payList.clearSelection();
					payList.setModel(listModel);
					
				}
				else
				{
					Bookings booking;
					
						for (int i = 0; i < cusPage.getCustomer().getSpotsReserved().size(); i ++)
						{
							booking = db.findBooking(cusPage.getCustomer().getSpotsReserved().get(i));
							if (!booking.isPaid() && booking.isGranted())
							{
								listModel.addElement(cusPage.getCustomer().getSpotsReserved().get(i));
							}
						}
						
						payList.setModel(listModel);

				}
				db.writeAll();
			}
		});
		btnPayForBookings.setBounds(339, 257, 145, 36);
		cusMain.add(btnPayForBookings);
		
		
		cusAddBook.setLayout(null);
		cusAddBook.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusAddBook, "name_344603055923200");
		
		JLabel lblNewLabel_4_1_1_1_1 = new JLabel("Book Parking");
		lblNewLabel_4_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_1.setBounds(317, 18, 192, 36);
		cusAddBook.add(lblNewLabel_4_1_1_1_1);
		
		cusBookMssg = new JTextField();
		cusBookMssg.setHorizontalAlignment(SwingConstants.CENTER);
		cusBookMssg.setForeground(Color.BLACK);
		cusBookMssg.setEditable(false);
		cusBookMssg.setColumns(10);
		cusBookMssg.setBackground(new Color(224, 255, 255));
		cusBookMssg.setBounds(262, 65, 313, 40);
		cusAddBook.add(cusBookMssg);
		
		JButton btnLogout_1 = new JButton("Logout");
		btnLogout_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cusPage = null;
				switchPanels(StartPage);
				db.writeAll();
			}
		});
		btnLogout_1.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout_1.setBounds(692, 373, 114, 35);
		cusAddBook.add(btnLogout_1);
		
		JButton bckMenu3 = new JButton("Previous Menu");
		bckMenu3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setTextBox(cusBookMssg, "", "RED");
				setTextBox(bookIdMssg, "", "RED");
				setTextBox(spotIdField, "", "black");
				setTextBox(licensePlate, "", "black");
				switchPanels (cusMain);
				
				db.writeAll();
			}
		});
		bckMenu3.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu3.setBounds(10, 11, 136, 35);
		cusAddBook.add(bckMenu3);
		
		spotIdField = new JTextField();
		spotIdField.setColumns(10);
		spotIdField.setText("");
		spotIdField.setBounds(378, 153, 158, 28);
		cusAddBook.add(spotIdField);
		
		JLabel lblNewLabel_3_5 = new JLabel("Spot Number");
		lblNewLabel_3_5.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_5.setBounds(290, 156, 86, 21);
		cusAddBook.add(lblNewLabel_3_5);
		
		JSpinner durationCounterHr = new JSpinner();
		durationCounterHr.setModel(new SpinnerNumberModel(0, 0, 12, 1));
		durationCounterHr.setFont(new Font("Tahoma", Font.PLAIN, 20));
		durationCounterHr.setBounds(388, 192, 45, 28);
		cusAddBook.add(durationCounterHr);
		
		JLabel lblNewLabel_3_5_1 = new JLabel("Duration");
		lblNewLabel_3_5_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3_5_1.setBounds(290, 199, 54, 21);
		cusAddBook.add(lblNewLabel_3_5_1);
		
		JSpinner durationCounterMin = new JSpinner();
		durationCounterMin.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		durationCounterMin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		durationCounterMin.setBounds(470, 192, 45, 28);
		cusAddBook.add(durationCounterMin);
		
		JLabel lblNewLabel_7 = new JLabel(":");
		lblNewLabel_7.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_7.setBounds(450, 188, 7, 36);
		cusAddBook.add(lblNewLabel_7);
		
		JButton confBooking = new JButton("Book");
		confBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				if ((spotIdField.getText().isEmpty() ) || (licensePlate.getText().isEmpty()) || !isNumber(spotIdField.getText()))
				{
					setTextBox(cusBookMssg, "Please Enter Valid Spot ID/License Plate", "RED");
				}
				else if ((int)durationCounterHr.getValue() == 0 && (int)durationCounterMin.getValue() == 0)
				{
					setTextBox(cusBookMssg, "Please Enter Valid Duration Time", "RED");
				}
				else
				{
					long time = (((int)durationCounterHr.getValue()*60)+(int)durationCounterMin.getValue());
					Bookings booking = cusPage.bookSpot(Integer.parseInt(spotIdField.getText()), licensePlate.getText(),time);
					if (booking == null)
					{
						setTextBox(bookIdMssg, "Booking Failed Spots Already Exists/Max Bookings reached", "RED");
						
					}
					else
					{
						
						setTextBox(bookIdMssg, "Booking Succesful! Your Booking ID is: " + booking.getBookingId(), "green");
					}
				}
				
				
				setTextBox(spotIdField, "", "black");
				setTextBox(licensePlate, "", "black");
				
				durationCounterHr.setValue((int)0);
				durationCounterMin.setValue((int)0);
				
				db.writeAll();
			}
		});
		confBooking.setFont(new Font("Arial", Font.PLAIN, 20));
		confBooking.setBounds(365, 255, 105, 36);
		cusAddBook.add(confBooking);
		
		bookIdMssg = new JTextField();
		bookIdMssg.setHorizontalAlignment(SwingConstants.CENTER);
		bookIdMssg.setForeground(Color.BLACK);
		bookIdMssg.setEditable(false);
		bookIdMssg.setColumns(10);
		bookIdMssg.setBackground(new Color(224, 255, 255));
		bookIdMssg.setBounds(178, 302, 481, 40);
		cusAddBook.add(bookIdMssg);
		
		licensePlate = new JTextField();
		licensePlate.setText("");
		licensePlate.setColumns(10);
		licensePlate.setBounds(378, 117, 158, 28);
		cusAddBook.add(licensePlate);
		
		JLabel lblNewLabel_3_5_2 = new JLabel("License Plate");
		lblNewLabel_3_5_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_5_2.setBounds(282, 120, 94, 21);
		cusAddBook.add(lblNewLabel_3_5_2);
		
		
		cusViewBook.setLayout(null);
		cusViewBook.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusViewBook, "name_414132999480100");
		
		JLabel lblNewLabel_4_1_1_1_1_1 = new JLabel("View Bookings");
		lblNewLabel_4_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_1_1.setBounds(308, 18, 219, 36);
		cusViewBook.add(lblNewLabel_4_1_1_1_1_1);
		
		cusViewMssg = new JTextField();
		cusViewMssg.setHorizontalAlignment(SwingConstants.CENTER);
		cusViewMssg.setForeground(Color.BLACK);
		cusViewMssg.setEditable(false);
		cusViewMssg.setColumns(10);
		cusViewMssg.setBackground(new Color(224, 255, 255));
		cusViewMssg.setBounds(262, 65, 313, 40);
		cusViewBook.add(cusViewMssg);
		
		JButton bckMenu4 = new JButton("Previous Menu");
		bckMenu4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				cusViewMssg.setText("");
				cusViewMssg.update(cusViewMssg.getGraphics());
				
				bookingDetails.setText("");
				bookingDetails.update(bookingDetails.getGraphics());
				
			
			
				
				switchPanels (cusMain);
				db.writeAll();
				
			}
		});
		bckMenu4.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu4.setBounds(10, 11, 136, 35);
		cusViewBook.add(bckMenu4);
		
		
		viewList.setFont(new Font("Arial", Font.PLAIN, 20));
		
		viewList.setBackground(new Color(255, 248, 220));
		viewList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		viewList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		viewList.setBounds(112, 140, 147, 183);
		
		cusViewBook.add(viewList);
		
		JButton viewDetail1 = new JButton("View Details");
		viewDetail1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.writeAll();
				String idSelected = viewList.getSelectedValue();
				Bookings booking = cusPage.getBooking(idSelected);
				if (viewList.getSelectedIndex() != -1)
				{
					String details = "";
					details = details + "Booking ID: " + idSelected + ",   Parking Spot: " + booking.getSpot().getSpotId()+"\n\n";
					details = details + "Booking Duration: "+booking.getDuration()+" Minutes \n\n";
					details = details + "Payment Confirmed: " + booking.isPaid() + "  Payment Approved: " + booking.isApproved()+ "\nSpot Granted: " + booking.isGranted() + "\n\n";
					if (booking.isPaid())
					{
						details = details + "Booking Expiary: " + booking.getExpTime().getYear()+"/"+booking.getExpTime().getMonthValue()
								+"/"+booking.getExpTime().getDayOfMonth()+" " + booking.getExpTime().getHour()+":"+booking.getExpTime().getMinute();
					}
					else
					{
						details = details + "Booking Expiary: N/A";
					}
					
					
					bookingDetails.setText(details);
					bookingDetails.update(bookingDetails.getGraphics());
				}
				db.writeAll();
			}
			
			
		});
		viewDetail1.setBounds(133, 334, 109, 36);
		cusViewBook.add(viewDetail1);
		bookingDetails.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		bookingDetails.setEditable(false);
		bookingDetails.setBackground(new Color(224, 255, 255));
		bookingDetails.setBounds(262, 165, 430, 156);
		cusViewBook.add(bookingDetails);
		
		
		cusCancelBook.setLayout(null);
		cusCancelBook.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusCancelBook, "name_425143454763800");
		
		JLabel lblNewLabel_4_1_1_1_1_2 = new JLabel("Cancel Booking");
		lblNewLabel_4_1_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_1_2.setBounds(304, 18, 225, 36);
		cusCancelBook.add(lblNewLabel_4_1_1_1_1_2);
		
		cusCancelMssg = new JTextField();
		cusCancelMssg.setHorizontalAlignment(SwingConstants.CENTER);
		cusCancelMssg.setForeground(Color.BLACK);
		cusCancelMssg.setEditable(false);
		cusCancelMssg.setColumns(10);
		cusCancelMssg.setBackground(new Color(224, 255, 255));
		cusCancelMssg.setBounds(262, 65, 313, 40);
		cusCancelBook.add(cusCancelMssg);
		
		JButton bckMenu3_1 = new JButton("Previous Menu");
		bckMenu3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextBox(cusCancelMssg, "", "BLACK");
				switchPanels (cusMain);
				
				
				db.writeAll();
			}
		});
		bckMenu3_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu3_1.setBounds(10, 11, 136, 35);
		cusCancelBook.add(bckMenu3_1);
		
		JButton cancelBooking = new JButton("Cancel");
		cancelBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cusPage.cancelBooking(bookingId.getText()))
				{
					cusCancelMssg.setText("Cancellation Succesful");
					cusCancelMssg.setForeground(Color.GREEN);
					cusCancelMssg.update(cusCancelMssg.getGraphics());
				}
				else
				{
					cusCancelMssg.setText("Cancellation Failed, Please Try Again");
					cusCancelMssg.setForeground(Color.RED);
					cusCancelMssg.update(cusCancelMssg.getGraphics());
				}
				
				bookingId.setText("");
				bookingId.update(bookingId.getGraphics());
				db.writeAll();
			}
			
		});
		cancelBooking.setFont(new Font("Arial", Font.PLAIN, 20));
		cancelBooking.setBounds(362, 181, 105, 36);
		cusCancelBook.add(cancelBooking);
		
		bookingId = new JTextField();
		bookingId.setText("");
		bookingId.setColumns(10);
		bookingId.setBounds(378, 117, 158, 28);
		cusCancelBook.add(bookingId);
		
		JLabel lblNewLabel_3_5_2_1 = new JLabel("Booking ID");
		lblNewLabel_3_5_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_5_2_1.setBounds(291, 120, 77, 21);
		cusCancelBook.add(lblNewLabel_3_5_2_1);
		
		
		cusPay1.setLayout(null);
		cusPay1.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusPay1, "name_428612314681400");
		
		JLabel lblNewLabel_4_1_1_1_1_1_1 = new JLabel("Pay for Bookings");
		lblNewLabel_4_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_1_1_1.setBounds(290, 18, 250, 36);
		cusPay1.add(lblNewLabel_4_1_1_1_1_1_1);
		
		payMssg1 = new JTextField();
		payMssg1.setHorizontalAlignment(SwingConstants.CENTER);
		payMssg1.setForeground(Color.BLACK);
		payMssg1.setEditable(false);
		payMssg1.setColumns(10);
		payMssg1.setBackground(new Color(224, 255, 255));
		payMssg1.setBounds(262, 65, 313, 40);
		cusPay1.add(payMssg1);
		
		JButton bckMenu4_1 = new JButton("Previous Menu");
		bckMenu4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payMssg1.setText("");
				payMssg1.update(payMssg1.getGraphics());
				
				switchPanels(cusMain);
				db.writeAll();
			}
		});
		bckMenu4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu4_1.setBounds(10, 11, 136, 35);
		cusPay1.add(bckMenu4_1);
		
		
		payList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		payList.setFont(new Font("Arial", Font.PLAIN, 20));
		payList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		payList.setBackground(new Color(255, 248, 220));
		payList.setBounds(279, 161, 147, 158);
		cusPay1.add(payList);
		
		JButton Pay = new JButton("Pay");
		Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (payList.getSelectedIndex()==-1)
				{
					payMssg1.setText("Please Select a Booking");
					payMssg1.update(payMssg1.getGraphics());
				}
				else
				{
					String bookId = payList.getSelectedValue();
					Bookings booking = cusPage.getBooking(bookId);
					payMssg1.setText("");
					payMssg1.update(payMssg1.getGraphics());
					String details = "";
					details = details + "Booking ID: " + bookId + ",   Parking Spot: " + booking.getSpot().getSpotId()+"\n\n";
					details = details + "Booking Duration: "+booking.getDuration()+" Minutes \n\n";
					details = details + "Payment Confirmed: " + booking.isPaid() + "  Payment Approved: " + booking.isApproved()+ "\nSpot Granted: " + booking.isGranted() + "\n\n";
					details = details + "Total Amount: $" + ((booking.getDuration()/30)*2);
					
					switchPanels(cusPay2);
					bookingDetails2.setText(details);
					bookingDetails2.update(bookingDetails2.getGraphics());
					
					
				}
				db.writeAll();
			}
		});
		Pay.setFont(new Font("Tahoma", Font.BOLD, 15));
		Pay.setBounds(451, 220, 109, 36);
		cusPay1.add(Pay);
		
		
		cusPay2.setLayout(null);
		cusPay2.setBackground(new Color(224, 255, 255));
		layeredPane.add(cusPay2, "name_431463771708500");
		
		JLabel lblNewLabel_4_1_1_1_1_1_1_1 = new JLabel("Pay for Bookings");
		lblNewLabel_4_1_1_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_1_1_1_1.setBounds(290, 18, 250, 36);
		cusPay2.add(lblNewLabel_4_1_1_1_1_1_1_1);
		
		pay2Mssg = new JTextField();
		pay2Mssg.setHorizontalAlignment(SwingConstants.CENTER);
		pay2Mssg.setForeground(Color.BLACK);
		pay2Mssg.setEditable(false);
		pay2Mssg.setColumns(10);
		pay2Mssg.setBackground(new Color(224, 255, 255));
		pay2Mssg.setBounds(262, 65, 313, 40);
		cusPay2.add(pay2Mssg);
		
		JButton bckMenu4_1_1 = new JButton("Previous Menu");
		bckMenu4_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pay2Mssg.setText("");
				pay2Mssg.update(pay2Mssg.getGraphics());
				
				cardFirst.setText("");
				cardFirst.update(cardFirst.getGraphics());
				
				cardLast.setText("");
				cardLast.update(cardLast.getGraphics());
				
				cardNum.setText("");
				cardNum.update(cardNum.getGraphics());
				
				cardCVV.setText("");
				cardCVV.update(cardCVV.getGraphics());
				
				expMonth.setValue((int)1);
				expYear.setValue((int)21);
				
				switchPanels (cusPay1);
				db.writeAll();
			}
		});
		bckMenu4_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu4_1_1.setBounds(10, 11, 136, 35);
		cusPay2.add(bckMenu4_1_1);
		
		JButton Pay2 = new JButton("Pay");
		Pay2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookId = payList.getSelectedValue();
				Bookings booking = cusPage.getBooking(bookId);
				
				
				
				if (cardFirst.getText().length() > 1 && cardLast.getText().length() > 1 && Long.parseLong(cardNum.getText()) > 1
						&&  isNumber(cardCVV.getText()) && Integer.parseInt(cardCVV.getText()) > 1)
				{
						Card payment = new Card (Long.parseLong(cardNum.getText()), (int)expMonth.getValue(),
								(int)expYear.getValue(),Integer.parseInt( cardCVV.getText()), cardFirst.getText(), cardLast.getText());
						if (cusPage.paySpot(payment, payList.getSelectedValue()))
						{
							pay2Mssg.setText("Payment Succesfull");
							pay2Mssg.update(pay2Mssg.getGraphics());
						}
						else
						{
							pay2Mssg.setText("Payment Failed");
							pay2Mssg.update(pay2Mssg.getGraphics());
						}
						
				
				}
				
		
				
				cardFirst.setText("");
				cardFirst.update(cardFirst.getGraphics());
				
				cardLast.setText("");
				cardLast.update(cardLast.getGraphics());
				
				cardNum.setText("");
				cardNum.update(cardNum.getGraphics());
				
				cardCVV.setText("");
				cardCVV.update(cardCVV.getGraphics());
				
				expMonth.setValue((int)1);
				expYear.setValue((int)21);
				db.writeAll();
			}
		});
		Pay2.setFont(new Font("Tahoma", Font.BOLD, 15));
		Pay2.setBounds(189, 245, 109, 36);
		cusPay2.add(Pay2);
		
		
		bookingDetails2.setFont(new Font("Arial", Font.BOLD, 15));
		bookingDetails2.setEditable(false);
		bookingDetails2.setBackground(new Color(224, 255, 255));
		bookingDetails2.setBounds(451, 116, 355, 277);
		cusPay2.add(bookingDetails2);
		
		cardFirst = new JTextField();
		cardFirst.setColumns(10);
		cardFirst.setBounds(128, 116, 90, 28);
		cusPay2.add(cardFirst);
		
		cardNum = new JTextField();
		cardNum.setColumns(10);
		cardNum.setBounds(202, 153, 211, 28);
		cusPay2.add(cardNum);
		
		cardCVV = new JTextField();
		cardCVV.setColumns(10);
		cardCVV.setBounds(351, 192, 60, 28);
		cusPay2.add(cardCVV);
		
		JLabel lblNewLabel_3_6 = new JLabel("First Name");
		lblNewLabel_3_6.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6.setBounds(48, 119, 72, 21);
		cusPay2.add(lblNewLabel_3_6);
		
		cardLast = new JTextField();
		cardLast.setColumns(10);
		cardLast.setBounds(304, 116, 109, 28);
		cusPay2.add(cardLast);
		
		JLabel lblNewLabel_3_6_1 = new JLabel("Last Name");
		lblNewLabel_3_6_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6_1.setBounds(228, 119, 72, 21);
		cusPay2.add(lblNewLabel_3_6_1);
		
		JLabel lblNewLabel_3_6_2 = new JLabel("Card Number");
		lblNewLabel_3_6_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6_2.setBounds(102, 156, 90, 21);
		cusPay2.add(lblNewLabel_3_6_2);
		
		JLabel lblNewLabel_3_6_2_1 = new JLabel("Exp Month");
		lblNewLabel_3_6_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6_2_1.setBounds(48, 194, 68, 21);
		cusPay2.add(lblNewLabel_3_6_2_1);
		
		JLabel lblNewLabel_3_6_2_1_1 = new JLabel("Exp Year");
		lblNewLabel_3_6_2_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6_2_1_1.setBounds(182, 195, 68, 21);
		cusPay2.add(lblNewLabel_3_6_2_1_1);
		
		
		expMonth.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		expMonth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		expMonth.setBounds(127, 192, 45, 28);
		cusPay2.add(expMonth);
		
		
		expYear.setModel(new SpinnerNumberModel(new Integer(21), new Integer(21), null, new Integer(1)));
		expYear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		expYear.setBounds(253, 192, 45, 28);
		cusPay2.add(expYear);
		
		JLabel lblNewLabel_3_6_2_1_1_1 = new JLabel("CVV");
		lblNewLabel_3_6_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_6_2_1_1_1.setBounds(308, 195, 34, 21);
		cusPay2.add(lblNewLabel_3_6_2_1_1_1);
		
		
		officerMain.setLayout(null);
		officerMain.setBackground(new Color(224, 255, 255));
		layeredPane.add(officerMain, "name_538265674903100");
		
		JLabel lblNewLabel_4_1_1_1_2 = new JLabel("Main Menu");
		lblNewLabel_4_1_1_1_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_2.setBounds(339, 49, 158, 36);
		officerMain.add(lblNewLabel_4_1_1_1_2);
		
		JButton btnLogout_2 = new JButton("Logout");
		btnLogout_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerPage = null;
				switchPanels (StartPage);
				db.writeAll();
			}
		});
		btnLogout_2.setFont(new Font("Arial", Font.PLAIN, 15));
		btnLogout_2.setBounds(692, 373, 114, 35);
		officerMain.add(btnLogout_2);
		
		JButton manageSpots = new JButton("Manage Parking");
		manageSpots.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels (officerMngSpot);
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				
				for (int i = 0; i < db.getCitySpots().size(); i ++)
				{	
					if (!db.getCitySpots().get(i).getBookingId().isEmpty())
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId() + " - " + db.getCitySpots().get(i).getBookingId());
					}
						
					else
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId());
					}
				}
				
				spotList.setModel(listModel);		
				
				db.writeAll();
				
				
			}
		});
		manageSpots.setFont(new Font("Tahoma", Font.PLAIN, 15));
		manageSpots.setBounds(312, 194, 195, 59);
		officerMain.add(manageSpots);
		
		JLabel lblNewLabel_4_1_1_1_2_1 = new JLabel("Parking Enforcer");
		lblNewLabel_4_1_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_2_1.setBounds(292, 11, 256, 36);
		officerMain.add(lblNewLabel_4_1_1_1_2_1);
		
		
		adminMngPymnt.setLayout(null);
		adminMngPymnt.setBackground(new Color(224, 255, 255));
		layeredPane.add(adminMngPymnt, "name_139566757540900");
		
		JLabel lblNewLabel_4_1_2 = new JLabel("System Administrator");
		lblNewLabel_4_1_2.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_2.setBounds(249, 11, 322, 36);
		adminMngPymnt.add(lblNewLabel_4_1_2);
		
		JButton bckMenu5 = new JButton("Previous Menu");
		bckMenu5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bookingDetails3.setText("");
				bookingDetails3.update(bookingDetails3.getGraphics());
				
				mngPymntMssg.setText("");
				mngPymntMssg.update(mngPymntMssg.getGraphics());
				
				switchPanels (adminMain);
				db.writeAll();
				
			}
		});
		bckMenu5.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu5.setBounds(10, 11, 136, 35);
		adminMngPymnt.add(bckMenu5);
		
		
		pendingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pendingList.setFont(new Font("Arial", Font.PLAIN, 20));
		pendingList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pendingList.setBackground(new Color(255, 248, 220));
		pendingList.setBounds(106, 102, 185, 264);
		pendingList.setVisible(true);
		JScrollPane scrollPane = new JScrollPane (pendingList);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(106, 102, 185, 260);
		adminMngPymnt.add(scrollPane);
		
		
		bookingDetails3.setFont(new Font("Arial", Font.BOLD, 15));
		bookingDetails3.setEditable(false);
		bookingDetails3.setBackground(new Color(224, 255, 255));
		bookingDetails3.setBounds(301, 102, 505, 260);
		adminMngPymnt.add(bookingDetails3);
		
		JButton viewDetail = new JButton("View Details");
		viewDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (pendingList.getSelectedIndex()==-1)
				{		
					setTextBox(mngPymntMssg, "Please Select a Booking", "red");
				}
				else
				{
					String bookId = pendingList.getSelectedValue();
					Bookings booking = db.findBooking(bookId);
					
					setTextBox(mngPymntMssg, "", "black");
					
					String details = "";
					details = details + "Name: " + booking.getCustomer().getFirstName() + " " + booking.getCustomer().getLastName() + "\n";
					details = details + "Booking ID: " + bookId + ",   Parking Spot: " + booking.getSpot().getSpotId()+"\n\n";
					details = details + "Booking Duration: "+booking.getDuration()+" Minutes    ";
					details = details + "Booking Expiary: " + booking.getExpTime().getYear()+"/"+booking.getExpTime().getMonthValue()
							+"/"+booking.getExpTime().getDayOfMonth()+" " + booking.getExpTime().getHour()+":"+booking.getExpTime().getMinute() + "\n\n";
					details = details + "Payment Confirmed: " + booking.isPaid() + "\n\n";
					details = details + "Name on Card: " + booking.getPayment().getFirst() + " " + booking.getPayment().getLast()+  "	Card Number: " + booking.getPayment().getCardNum();
					details = details + "\nCard Exp: " + booking.getPayment().getExpMonth() + "/" + booking.getPayment().getExpYear();
					details = details + "	Card CVV: " + booking.getPayment().getCVV();
					details = details + "\n\nTotal Amount: $" + ((booking.getDuration()/30)*2);
					
					
					bookingDetails3.setText(details);
					bookingDetails3.update(bookingDetails3.getGraphics());
					
					
				}
				
				db.writeAll();
				
			}
		});
		viewDetail.setBounds(145, 373, 115, 36);
		adminMngPymnt.add(viewDetail);
		
		mngPymntMssg = new JTextField();
		mngPymntMssg.setHorizontalAlignment(SwingConstants.CENTER);
		mngPymntMssg.setForeground(Color.BLACK);
		mngPymntMssg.setEditable(false);
		mngPymntMssg.setColumns(10);
		mngPymntMssg.setBackground(new Color(224, 255, 255));
		mngPymntMssg.setBounds(249, 51, 313, 40);
		adminMngPymnt.add(mngPymntMssg);
		
		JButton confPayment1 = new JButton("Confirm Payment");
		confPayment1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (pendingList.getSelectedIndex()==-1)
				{
					setTextBox(mngPymntMssg, "Please Select a Booking", "red");
				}
				else
				{
					String bookId = pendingList.getSelectedValue();
					Bookings booking = db.findBooking(bookId);
					
					setTextBox(mngPymntMssg, "", "black");
					
					
					booking.setApproved(true);
					
					
					setTextBox(mngPymntMssg, "Payment Approved", "green");
				
					
				}
				
				db.writeAll();
			}
		});
		confPayment1.setBounds(468, 373, 146, 36);
		adminMngPymnt.add(confPayment1);
		officerMngSpot.setBackground(new Color(224, 255, 255));
		layeredPane.add(officerMngSpot, "name_45651590698000");
		officerMngSpot.setLayout(null);
		
		JLabel lblNewLabel_4_1_1_1_2_1_1 = new JLabel("Parking Enforcer");
		lblNewLabel_4_1_1_1_2_1_1.setBounds(292, 0, 256, 36);
		lblNewLabel_4_1_1_1_2_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		officerMngSpot.add(lblNewLabel_4_1_1_1_2_1_1);
		
		
		spotList.setBackground(new Color(255, 235, 205));
		spotList.setBounds(29, 60, 235, 348);
		
		
		spotListScroll.setBounds(27, 90, 256, 276);
		spotListScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		officerMngSpot.add(spotListScroll);
		
		JButton bckMenu4_1_1_1 = new JButton("Previous Menu");
		bckMenu4_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				spotList.clearSelection();
				spotList.setModel(listModel);
				setTextBox(mngSpotMssg, "", "black");
				
				switchPanels (officerMain);
				
			}
		});
		bckMenu4_1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu4_1_1_1.setBounds(10, 0, 136, 35);
		officerMngSpot.add(bckMenu4_1_1_1);
		
		JButton add_Spot = new JButton("Add Spot");
		add_Spot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				setTextBox(mngSpotMssg,"","BLACK");
				switchPanels(officerAddSpot);
				
				
			}
		});
		add_Spot.setBounds(292, 372, 111, 36);
		officerMngSpot.add(add_Spot);
		
		JButton add_Spot_1 = new JButton("Remove Spot");
		add_Spot_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				setTextBox(mngSpotMssg,"","BLACK");
				switchPanels(officerRmvSpot);
				
				
			}
		});
		add_Spot_1.setBounds(422, 372, 111, 36);
		officerMngSpot.add(add_Spot_1);
		
		JButton add_Spot_1_1 = new JButton("Grant Request");
		add_Spot_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spotList.getSelectedIndex()==-1)
				{
					setTextBox(mngSpotMssg, "Please Select a Booking", "RED");
				}
				else
				{
					int spot = spotList.getSelectedIndex();
					ParkingSpot spotFound = db.findSpot((spot+1));
					Bookings booking = db.findBooking(spotFound.getBookingId());
					if (!booking.isGranted())
					{
						booking.setGranted(true);
						setTextBox(mngSpotMssg, "Booking Request Granted", "GREEN");
					}
					else
					{
						setTextBox(mngSpotMssg, "Request Has Already Been Granted", "RED");
					}
					
				}
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				db.writeAll();
				
			}
		});
		add_Spot_1_1.setBounds(551, 372, 122, 36);
		officerMngSpot.add(add_Spot_1_1);
		
		JButton add_Spot_1_1_1 = new JButton("Decline Request");
		add_Spot_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (spotList.getSelectedIndex()==-1)
				{
					setTextBox(mngSpotMssg, "Please Select a Booking", "RED");
				}
				else
				{
					int spot = spotList.getSelectedIndex();
					ParkingSpot spotFound = db.findSpot(spot+1);
					Bookings booking = db.findBooking(spotFound.getBookingId());
					if (!booking.isGranted())
					{
						db.clearBooking(booking);
						setTextBox(mngSpotMssg, "Booking Request Declined", "GREEN");
					}
					else
					{
						setTextBox(mngSpotMssg, "Unable to Decline", "RED");
					}
					
				}
				
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				db.writeAll();
			}
		});
		add_Spot_1_1_1.setBounds(683, 372, 133, 36);
		officerMngSpot.add(add_Spot_1_1_1);
		
		JButton officerViewDetail = new JButton("View Detail");
		officerViewDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				officerDetails.setText("");
				officerDetails.update(officerDetails.getGraphics());
				if (spotList.getSelectedIndex()==-1)
				{
					setTextBox(mngSpotMssg, "Please Select a Booking", "BLACK");
				}
				else
				{
					int spot = spotList.getSelectedIndex();
					ParkingSpot spotFound = db.findSpot((spot + 1));
					if (spotFound.getBookingId().isEmpty())
					{
						
						setTextBox(mngSpotMssg, "This Spot Has No Bookings", "RED");
					}
					else
					{
						
						Bookings booking = db.findBooking(spotFound.getBookingId());
						if (booking != null)
						{
							String details = "";
							details = details + "Booking ID: " + booking.getBookingId() + ",   Parking Spot: " + booking.getSpot().getSpotId()+"\n\n";
							details = details + "Booking Duration: "+booking.getDuration()+" Minutes \n\n";
							details = details + "Spot Granted: " + booking.isGranted() + "\n\n";
							details = details + "Total Amount: $" + ((booking.getDuration()/30)*2);
							officerDetails.setText(details);
							officerDetails.update(officerDetails.getGraphics());
						}
						else {
							setTextBox(mngSpotMssg, "This Spot Has No Bookings", "RED");
						}
						
					}
					
				}
				db.writeAll();
				
				
			}
		});
		officerViewDetail.setBounds(98, 372, 111, 36);
		officerMngSpot.add(officerViewDetail);
		
		
		officerDetails.setFont(new Font("Arial", Font.BOLD, 15));
		officerDetails.setEditable(false);
		officerDetails.setBackground(new Color(224, 255, 255));
		officerDetails.setBounds(292, 90, 502, 276);
		officerMngSpot.add(officerDetails);
		
		mngSpotMssg = new JTextField();
		mngSpotMssg.setHorizontalAlignment(SwingConstants.CENTER);
		mngSpotMssg.setForeground(Color.BLACK);
		mngSpotMssg.setEditable(false);
		mngSpotMssg.setColumns(10);
		mngSpotMssg.setBackground(new Color(224, 255, 255));
		mngSpotMssg.setBounds(249, 39, 313, 40);
		officerMngSpot.add(mngSpotMssg);
		
		
		officerAddSpot.setLayout(null);
		officerAddSpot.setBackground(new Color(224, 255, 255));
		layeredPane.add(officerAddSpot, "name_63809075442800");
		
		spotId = new JTextField();
		spotId.setColumns(10);
		spotId.setBounds(362, 124, 158, 28);
		officerAddSpot.add(spotId);
		
		JLabel lblNewLabel_3_4_1 = new JLabel("Spot ID");
		lblNewLabel_3_4_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_4_1.setBounds(290, 127, 72, 21);
		officerAddSpot.add(lblNewLabel_3_4_1);
		
		addSpotMssg = new JTextField();
		addSpotMssg.setHorizontalAlignment(SwingConstants.CENTER);
		addSpotMssg.setForeground(Color.BLACK);
		addSpotMssg.setEditable(false);
		addSpotMssg.setColumns(10);
		addSpotMssg.setBackground(new Color(224, 255, 255));
		addSpotMssg.setBounds(275, 47, 271, 40);
		officerAddSpot.add(addSpotMssg);
		
		JButton btnAddParkingSpot = new JButton("Add Parking Spot");
		btnAddParkingSpot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!spotId.getText().isEmpty() && spotId.getText().length() > 0 && isNumber(spotId.getText()))
				{
					if (officerPage.addParkingSpot(Integer.parseInt(spotId.getText())))
					{
						setTextBox(addSpotMssg, "Parking Spot Added", "GREEN");
					}
					else
					{
						setTextBox(addSpotMssg, "Parking Spot Not Added", "RED");
					}
				}
				else
				{
					setTextBox(addSpotMssg, "Invalid Input", "RED");
				}
				db.writeAll();
				
			}
		});
		btnAddParkingSpot.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAddParkingSpot.setBounds(327, 181, 170, 35);
		officerAddSpot.add(btnAddParkingSpot);
		
		JButton bckMenu1_1 = new JButton("Previous Menu");
		bckMenu1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTextBox(addSpotMssg, "", "BLACK");
				spotId.setText("");
				switchPanels (officerMngSpot);
				
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				
				for (int i = 0; i < db.getCitySpots().size(); i ++)
				{	
					if (!db.getCitySpots().get(i).getBookingId().isEmpty())
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId() + " - " + db.getCitySpots().get(i).getBookingId());
					}
						
					else
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId());
					}
				}
				
				spotList.setModel(listModel);		
				
				db.writeAll();
				
			}
		});
		bckMenu1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu1_1.setBounds(10, 11, 136, 35);
		officerAddSpot.add(bckMenu1_1);
		
		JLabel lblNewLabel_4_1_1_1_2_1_1_1 = new JLabel("Parking Enforcer");
		lblNewLabel_4_1_1_1_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_2_1_1_1.setBounds(290, 0, 256, 36);
		officerAddSpot.add(lblNewLabel_4_1_1_1_2_1_1_1);
		
		
		officerRmvSpot.setLayout(null);
		officerRmvSpot.setBackground(new Color(224, 255, 255));
		layeredPane.add(officerRmvSpot, "name_64770192436800");
		
		spotId2 = new JTextField();
		spotId2.setColumns(10);
		spotId2.setBounds(362, 124, 158, 28);
		officerRmvSpot.add(spotId2);
		
		JLabel lblNewLabel_3_4_1_1 = new JLabel("Spot ID");
		lblNewLabel_3_4_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_3_4_1_1.setBounds(290, 127, 72, 21);
		officerRmvSpot.add(lblNewLabel_3_4_1_1);
		
		rmvMssg = new JTextField();
		rmvMssg.setHorizontalAlignment(SwingConstants.CENTER);
		rmvMssg.setForeground(Color.BLACK);
		rmvMssg.setEditable(false);
		rmvMssg.setColumns(10);
		rmvMssg.setBackground(new Color(224, 255, 255));
		rmvMssg.setBounds(265, 47, 291, 40);
		officerRmvSpot.add(rmvMssg);
		
		JButton btnRemoveParkingSpot = new JButton("Remove Parking Spot");
		btnRemoveParkingSpot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!spotId2.getText().isEmpty() && spotId2.getText().length() > 0 && isNumber(spotId2.getText()))
				{
					if (officerPage.removeParkingSpot(Integer.parseInt(spotId2.getText())))
					{
						setTextBox(rmvMssg, "Parking Spot Removed", "GREEN");
					}
					else
					{
						setTextBox(rmvMssg, "Parking Spot Not Removed", "RED");
					}
				}
				else
				{
					setTextBox(rmvMssg, "Invalid Input", "RED");
				}
				
				db.writeAll();
			}
		});
		btnRemoveParkingSpot.setFont(new Font("Arial", Font.PLAIN, 15));
		btnRemoveParkingSpot.setBounds(340, 181, 180, 35);
		officerRmvSpot.add(btnRemoveParkingSpot);
		
		JButton bckMenu1_1_1 = new JButton("Previous Menu");
		bckMenu1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				spotId.setText("");
				setTextBox(rmvMssg, "", "BLACK");
				switchPanels (officerMngSpot);
				
				DefaultListModel<String> listModel = new DefaultListModel<String>();
				
				for (int i = 0; i < db.getCitySpots().size(); i ++)
				{	
					if (!db.getCitySpots().get(i).getBookingId().isEmpty())
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId() + " - " + db.getCitySpots().get(i).getBookingId());
					}
						
					else
					{
						listModel.addElement("Spot: " + db.getCitySpots().get(i).getSpotId());
					}
				}
				
				spotList.setModel(listModel);		
				
				db.writeAll();
			}
		});
		bckMenu1_1_1.setFont(new Font("Arial", Font.PLAIN, 15));
		bckMenu1_1_1.setBounds(10, 11, 136, 35);
		officerRmvSpot.add(bckMenu1_1_1);
		
		JLabel lblNewLabel_4_1_1_1_2_1_1_1_1 = new JLabel("Parking Enforcer");
		lblNewLabel_4_1_1_1_2_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel_4_1_1_1_2_1_1_1_1.setBounds(290, 0, 256, 36);
		officerRmvSpot.add(lblNewLabel_4_1_1_1_2_1_1_1_1);
	}
	
	public void switchPanels (JPanel panel)
	{
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void setTextBox (JTextField textField, String newText, String color)
	{
		textField.setText(newText);
		if (color.equalsIgnoreCase("green"))
		{
			textField.setForeground(Color.GREEN);
		}
		else if (color.equalsIgnoreCase("red"))
		{
			textField.setForeground(Color.RED);
		}
		else if (color.equalsIgnoreCase("black"))
		{
			textField.setForeground(Color.BLACK);
		}
		textField.update(textField.getGraphics());
	}
	
	public boolean isNumber (String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if (!(str.charAt(i) >= 48 && str.charAt(i) <= 57))
			{
				return false;
			}
		}
		
		return true;
	}
}
