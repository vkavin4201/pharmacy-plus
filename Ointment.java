package pharmacy_plus;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

public class Ointment {

	public JFrame frame;
	public static String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ointment window = new Ointment(name);
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
	public Ointment(String str) {
		name = str;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Pharmacy/User/Products/Oinment");
		frame.setBounds(100, 100, 1020, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("Pharmacy+");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial Black", Font.PLAIN, 24));
		label.setBounds(384, 11, 184, 44);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Kavin V\\Downloads\\grey-and-white-octagon-stockto.png"));
		label_1.setBounds(861, 11, 135, 135);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Copyrights owned by Pharmacy+ Inc.");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_2.setBounds(764, 649, 232, 23);
		frame.getContentPane().add(label_2);
		JLabel label_3 = new JLabel("User: " + name);
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		label_3.setBounds(10, 655, 232, 23);
		frame.getContentPane().add(label_3);

		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 167, 109, 23);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setHorizontalAlignment(SwingConstants.CENTER);
		lblDosage.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblDosage.setBounds(188, 167, 109, 23);
		frame.getContentPane().add(lblDosage);

		JLabel lblCost = new JLabel("Cost");
		lblCost.setHorizontalAlignment(SwingConstants.CENTER);
		lblCost.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblCost.setBounds(352, 167, 109, 23);
		frame.getContentPane().add(lblCost);

		JLabel lblManufacturingDate = new JLabel("Manufacturing date");
		lblManufacturingDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblManufacturingDate.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblManufacturingDate.setBounds(525, 167, 109, 23);
		frame.getContentPane().add(lblManufacturingDate);

		JLabel lblExpiryDate = new JLabel("Expiry date");
		lblExpiryDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblExpiryDate.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblExpiryDate.setBounds(699, 167, 109, 23);
		frame.getContentPane().add(lblExpiryDate);

		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuantity.setFont(new Font("Arial Narrow", Font.PLAIN, 14));
		lblQuantity.setBounds(844, 167, 109, 23);
		frame.getContentPane().add(lblQuantity);

		JTable table = new JTable();
		table.setFont(new Font("Arial Narrow", Font.PLAIN, 15));
		table.setBounds(36, 239, 772, 135);

		frame.getContentPane().add(table);

		JButton btnNewButton = new JButton("Show Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "select mname,dosage,cost,manufacture_date,expiry_date from medicine where variation='oinment'";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					Statement st = con.createStatement();
					ResultSet rs = st.executeQuery(query);
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}
			}
		});
		btnNewButton.setBounds(410, 123, 135, 23);
		frame.getContentPane().add(btnNewButton);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner.setBounds(818, 237, 109, 20);
		frame.getContentPane().add(spinner);

		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_1.setBounds(818, 259, 109, 20);
		frame.getContentPane().add(spinner_1);

		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_2.setBounds(818, 281, 109, 20);
		frame.getContentPane().add(spinner_2);

		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_3.setBounds(818, 306, 109, 20);
		frame.getContentPane().add(spinner_3);

		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		spinner_4.setBounds(818, 331, 109, 20);
		frame.getContentPane().add(spinner_4);

		JButton btnNewButton_1 = new JButton("Tablets");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tablet t = new Tablet(name);
				frame.dispose();
				t.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(72, 456, 89, 23);
		frame.getContentPane().add(btnNewButton_1);

		JLabel lblTablets = new JLabel("Oinment");
		lblTablets.setHorizontalAlignment(SwingConstants.CENTER);
		lblTablets.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblTablets.setBounds(384, 66, 184, 44);
		frame.getContentPane().add(lblTablets);

		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] qty = new int[5];
				qty[0] = (int) spinner.getValue();
				qty[1] = (int) spinner_1.getValue();
				qty[2] = (int) spinner_2.getValue();
				qty[3] = (int) spinner_3.getValue();
				qty[4] = (int) spinner_4.getValue();
				String url = "jdbc:mysql://localhost:3306/pharma?useTimezone=true&serverTimezone=UTC";
				String query = "insert into cart values (?,?,?,?)";
				try {

					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, "root", "");
					PreparedStatement st = con.prepareStatement(query);
					if (qty[0] > 0) {
						st.setString(1, name);

						st.setInt(2, 6);
						st.setInt(3, qty[0]);
						st.setInt(4, 300);
						int count = st.executeUpdate();
					}
					PreparedStatement st1 = con.prepareStatement(query);
					if (qty[1] > 0) {
						st1.setString(1, name);
						st1.setInt(2, 9);
						st1.setInt(3, qty[1]);
						st1.setInt(4, 100);
						int count1 = st1.executeUpdate();
					}
					PreparedStatement st2 = con.prepareStatement(query);
					if (qty[2] > 0) {
						st2.setString(1, name);
						st2.setInt(2, 11);
						st2.setInt(3, qty[2]);
						st2.setInt(4, 350);
						int count2 = st2.executeUpdate();
					}
					PreparedStatement st3 = con.prepareStatement(query);
					if (qty[3] > 0) {
						st3.setString(1, name);
						st3.setInt(2, 15);
						st3.setInt(3, qty[3]);
						st3.setInt(4, 200);
						int count3 = st3.executeUpdate();
					}
					PreparedStatement st4 = con.prepareStatement(query);
					if (qty[4] > 0) {
						st4.setString(1, name);
						st4.setInt(2, 16);
						st4.setInt(3, qty[4]);
						st4.setInt(4, 150);
						int count4 = st4.executeUpdate();
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Exception : " + e1);
				}

			}
		});
		btnAddToCart.setBounds(384, 456, 171, 23);
		frame.getContentPane().add(btnAddToCart);

		JButton btnOintment = new JButton("Syrup");
		btnOintment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Syrup s = new Syrup(name);
				frame.dispose();
				s.frame.setVisible(true);
			}
		});
		btnOintment.setBounds(714, 456, 89, 23);
		frame.getContentPane().add(btnOintment);

		JButton btnGoToCart = new JButton("Go to cart");
		btnGoToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cart c = new Cart(name);
				frame.dispose();
				c.frame.setVisible(true);
			}
		});
		btnGoToCart.setBounds(384, 556, 171, 23);
		frame.getContentPane().add(btnGoToCart);
		JButton btnNewButton_2 = new JButton("Home");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcome w = new welcome(name);
				frame.dispose();
				w.frmPharmacywelcome.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(433, 506, 89, 23);
		frame.getContentPane().add(btnNewButton_2);

	}

}
