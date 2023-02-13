package userinterface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {	      
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBackground(Color.DARK_GRAY);
		leftPanel.setBounds(0, -17, 400, 489);
		contentPane.add(leftPanel);
		
		JLabel mvLogo = new JLabel("");
		leftPanel.add(mvLogo);
		mvLogo.setIcon(new ImageIcon(Login.class.getResource("/images/mv-logo-white-with-text-no-bg.png")));
		mvLogo.setForeground(Color.WHITE);
		
		JLabel successPrompt = new JLabel("");
		contentPane.add(successPrompt);
		
		usernameField = new JTextField();
		usernameField.setBorder(new LineBorder(new Color(0, 0, 0)));
		usernameField.setFont(new Font("Arial", Font.PLAIN, 13));
		usernameField.setBounds(437, 124, 325, 30);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(437, 96, 77, 16);
		contentPane.add(usernameLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setBounds(437, 229, 325, 30);
		contentPane.add(passwordField);
		
		JLabel passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(437, 201, 77, 16);
		contentPane.add(passwordLabel);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBorder(new LineBorder(Color.BLACK, 1, true));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				
				if (username.equals("USERNAME") && password.equals("PASSWORD")) {
					successPrompt.setForeground(new Color(52, 200, 15));
					successPrompt.setBounds(543, 343, 110, 16);
					successPrompt.setText("Login successful!");
				} else {
					successPrompt.setForeground(Color.RED);
					successPrompt.setBounds(480, 343, 250, 16);
					successPrompt.setText("Invalid username/password. Try again.");
				}
			}
		});
		loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton.setBackground(Color.WHITE);
		loginButton.setBounds(528, 303, 137, 29);
		contentPane.add(loginButton);
		
		JLabel textPrompt = new JLabel("Don't have an account?");
		textPrompt.setBounds(498, 412, 151, 16);
		contentPane.add(textPrompt);
		
		JButton signUpPrompt = new JButton("<HTML><U>Sign Up</U></HTML>");
		signUpPrompt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpPrompt.setForeground(Color.BLUE);
		signUpPrompt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		signUpPrompt.setBorder(null);
		signUpPrompt.setBounds(643, 409, 57, 23);
		contentPane.add(signUpPrompt);
	}
}