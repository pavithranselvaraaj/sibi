package jdbc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class employee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employee frame = new employee();
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
	public employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		textField = new JTextField();
		textField.setBounds(140, 47, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 47, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(140, 91, 96, 19);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(140, 130, 96, 19);
		contentPane.add(textField_3);
		
		JLabel id = new JLabel("id");
		id.setBounds(80, 10, 109, 27);
		contentPane.add(id);
		
		JLabel location = new JLabel("location");
		location.setBounds(80, 116, 45, 13);
		contentPane.add(location);
		
		JLabel name = new JLabel("name");
		name.setBounds(80, 76, 45, 13);
		contentPane.add(name);
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String url = "jdbc:mysql://localhost:3306/db_example";
					String username = "sa";
					String password = "joker";
			     	//Load and Register the Driver	
				     	//Load and Register the Driver	
					Class.forName("com.mysql.jdbc.Driver");
					//Establish the Connection
					Connection con = DriverManager.getConnection(url, username, password);
					//Create the Statment
					Statement st = con.createStatement();
					//Execute the query
					ResultSet rs = st.executeQuery("select * from users");
					
					//Process ResultSet
				
					while(rs.next())
					{
						System.out.println("Id:"+rs.getInt(1)+" Name:"+rs.getString(3));
					}
					
					//Close Connection
					st.close();
					con.close();
				}

			}
		});
		button.setBounds(61, 201, 85, 21);
		contentPane.add(button);
	}
}
