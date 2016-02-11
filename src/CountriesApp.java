import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JMenuBar;

public class CountriesApp {

	private JFrame frame;
	private JTextField textField;
	static String countryList="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CountriesApp window = new CountriesApp();
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
	public CountriesApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 790, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(303, 305, 167, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CountriesTextFile.addCountry(countryList, textField.getText());
				textField.setText("");
			}
		});
		btnAdd.setBounds(367, 362, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnICantTake = new JButton("I can't take anymore!");
		btnICantTake.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnICantTake.setBounds(559, 389, 201, 25);
		frame.getContentPane().add(btnICantTake);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(57, 47, 234, 289);
		frame.getContentPane().add(textPane);
		
		JButton btnLoad = new JButton("load");
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				countryList = CountriesTextFile.loadCountries();
				textPane.setText(countryList);
			}
		});
		btnLoad.setBounds(194, 362, 97, 25);
		frame.getContentPane().add(btnLoad);
		
		JLabel lblClickLoadTo = DefaultComponentFactory.getInstance().createTitle("Click Load to View a List of Countries");
		lblClickLoadTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblClickLoadTo.setFont(new Font("Verdana", Font.PLAIN, 16));
		lblClickLoadTo.setBackground(Color.YELLOW);
		lblClickLoadTo.setBounds(86, 13, 600, 16);
		frame.getContentPane().add(lblClickLoadTo);
	
	}
}
