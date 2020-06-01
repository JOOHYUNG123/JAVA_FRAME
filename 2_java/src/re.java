import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class re extends JFrame {

	private JPanel contentPane;
	String column[] = { "�ּ�", "���㰡��ȣ", "��ǥ�ڸ�", "����", "���Ҹ�" };
	String column2[] = { "�ּ�", "���ݳ���", "��������", "ó��Ȯ������", "���ݹ���", "ó�г���", "ó������", "ó�н�����", "ó��������" };

	DefaultTableModel model = new DefaultTableModel(column, 0);

	JTable table_1 = new JTable(model);
	JScrollPane scroll_table = new JScrollPane(table_1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					re frame = new re();
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
	public re() {
		setTitle("��ǰ����ó�а��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("��ǰ����ó�а��");
		lblNewLabel.setBounds(147, 20, 321, 44);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("��ü�� ���� ��ü", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(50, 205, 50));
		contentPane.add(lblNewLabel);
		contentPane.setVisible(true);

		JComboBox comboBox = new JComboBox();
		comboBox.setRequestFocusEnabled(false);
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("��ü�� ����ü", Font.PLAIN, 12));
		comboBox.setBorder(new LineBorder(new Color(154, 205, 50), 1, true));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "������", "��⵵","����Ư����","��õ������","��û�ϵ�",
				"��û����","���ϵ�","��󳲵�","����ϵ�","���󳲵�","�뱸������","��걤����","����������","�λ걤����","����Ư����ġ��",
				"����Ư����ġ��" }));
		comboBox.setBounds(108, 100, 130, 32);
		contentPane.add(comboBox);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("��ü�� ����ü", Font.PLAIN, 12));
		comboBox_2.setBorder(new LineBorder(new Color(154, 205, 50), 1, true));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(271, 100, 130, 32);
		contentPane.add(comboBox_2);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object address = comboBox.getSelectedItem();
				if (address == "������") {
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "��õ��", "���ֽ�", "������", "���ؽ�", "�¹��", "���ʽ�", "��ô��",
									"ȫõ��", "Ⱦ����", "������", "��â��", "������", "ö����", "ȭõ��", "�籸��", "������", "����", "��籺" }));
				} else if (address == "��⵵") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "������", "������", "�����ν�", "�Ⱦ��", "��õ��", "�����", "���ý�", "����õ��", "�Ȼ��", "����",
									"��õ��", "������", "�����ֽ�", "�����", "�����", "������", "�ǿս�", "�ϳ���", "���ν�", "���ֽ�", "��õ��", "�ȼ���",
									"������", "ȭ����", "���ֽ�", "���ֽ�", "��õ��", "���ֽ�", "��õ��", "����", "����" }));
				} else if (address == "����Ư����") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "���α�", "�߱�", "��걸", "������", "������",
							"���빮��", "�߶���", "���ϱ�", "���ϱ�", "������", "�����", "����", "���빮��", "������", "��õ��", "������", "���α�", "��õ��",
							"��������", "���۱�", "���Ǳ�", "���ʱ�", "������", "���ı�", "������" }));
				} else if (address == "��õ������") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "�߱�", "����", "����Ȧ��", "������", "������", "����", "��籸", "����", "��ȭ��", "������" }));
				} else if (address == "��û�ϵ�") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "û�ֽ�", "���ֽ�", "��õ��", "������", "��õ��",
							"������", "����", "��õ��", "���걺", "������", "�ܾ籺" }));
				} else if (address == "��û����") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "õ�Ƚ�", "���ֽ�", "���ɽ�", "�ƻ��", "�����",
							"����", "����", "������", "�ݻ걺", "�ο���", "��õ��", "û�籺", "ȫ����", "���걺", "�¾ȱ�" }));
				} else if (address == "���ϵ�") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "���׽�", "���ֽ�", "��õ��", "�ȵ���", "���̽�",
							"���ֽ�", "��õ��", "���ֽ�", "�����", "����", "������", "�Ǽ���", "û�۱�", "���籺", "������", "û����", "��ɱ�", "���ֱ�",
							"ĥ�", "��õ��", "��ȭ��", "������", "�︪��" }));
				} else if (address == "��󳲵�") {
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "â����", "���ֽ�", "�뿵��", "��õ��", "���ؽ�", "�о��", "������",
									"����", "�Ƿɱ�", "�Ծȱ�", "â�籺", "����", "���ر�", "�ϵ���", "��û��", "�Ծ籺", "��â��", "��õ��" }));
				} else if (address == "����ϵ�") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "���ֽ�", "�����", "�ͻ��", "������", "������",
							"������", "���ֱ�", "���ȱ�", "���ֱ�", "�����", "�ӽǱ�", "��â��", "��â��", "�ξȱ�" }));
				} else if (address == "���󳲵�") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "������", "������", "��õ��", "���ֽ�", "�����", "��籺", "���", "���ʱ�", "���ﱺ", "������", "ȭ����",
									"���ﱺ", "������", "�س���", "���ϱ�", "���ȱ�", "����", "������", "�强��", "�ϵ���", "������", "�žȱ�" }));
				} else if (address == "�뱸������") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "�߱�", "����", "����", "����", "�ϱ�", "������", "�޼���", "�޼���" }));
				} else if (address == "��걤����") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "�߱�", "����", "����", "�ϱ�", "���ֱ�" }));
				} else if (address == "����������") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "����", "�߱�", "����", "������", "�����" }));
				} else if (address == "�λ걤����") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "�߱�", "����", "����", "������", "�λ�����", "������",
							"����", "�ϱ�", "�ؿ�뱸", "���ϱ�", "������", "������", "������", "������", "���", "���屺" }));
				} else if (address == "����Ư����ġ��") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "���ֽ�", "��������" }));
				} else if (address == "����Ư����ġ��") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "�ݰ", "�Ҵ㵿", "������", "����", "������",
							"�Ѽֵ�", "������", "���ҵ�", "������", "������", "���̵�", "��", "�Ƹ���", "���㵿", "��ġ����", "�����", "������", "�ΰ���",
							"�ݳ���", "�屺��", "������", "���Ǹ�", "������", "������" }));
				}
			}
		});

		JButton button = new JButton(new ImageIcon("images/loupe.png"));
		button.setBorderPainted(false);
		button.setFocusable(false);
		button.setFocusPainted(false);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setSize(30, 30);
		button.setBounds(413, 88, 76, 53);
		contentPane.add(button);

		JButton btnNewButton = new JButton("\uC790\uC138\uD788\uBCF4\uAE30");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(new LineBorder(new Color(154, 205, 50), 2, true));
		btnNewButton.setFont(new Font("��ü�� ����ü", Font.PLAIN, 10));
		btnNewButton.setBounds(460, 682, 85, 24);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\uC138\uBD80\uC0AC\uD56D\uC740 \uC8FC\uC18C\uB97C \uB204\uB974\uACE0 \uBC84\uD2BC\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		label.setBounds(179, 681, 280, 24);
		contentPane.add(label);
		

		class newWindow extends JFrame {
			newWindow() {
				JPanel contentPane_n;
				setTitle("��ǰ����ó�� �ڼ�������");
				JPanel NewWindowContainer = new JPanel();
				NewWindowContainer.setBackground(new Color(255, 255, 255));
				setBounds(100, 100, 573, 755);
				setContentPane(NewWindowContainer);

				NewWindowContainer.setLayout(null);

				Connection con;
				PreparedStatement stmt = null;
				String driverName = "com.mysql.jdbc.Driver";
				String dbURL = "jdbc:mysql://localhost:3306/1801585_db";
				ResultSet rs = null;

				int row1 = table_1.getSelectedRow();
				int col1 = table_1.getSelectedColumn();

				Object value = table_1.getValueAt(row1, col1);
				System.out.println(value);

				try {
					Class.forName(driverName);
					con = DriverManager.getConnection(dbURL, "root", "1234"); // JDBC����
					String SQL1 = "SELECT * FROM 1801585_db.administrative where ADDR LIKE '" + value + "';";
					stmt = con.prepareStatement(SQL1);
					rs = stmt.executeQuery();

					while (rs.next()) {
						String[] row_ad = new String[9];
						row_ad[0] = rs.getString("ADDR");
						row_ad[1] = rs.getString("VILTCN");
						row_ad[2] = rs.getString("VILTCN_DATE");
						row_ad[3] = rs.getString("DSPS_DCSNDT");
						row_ad[4] = rs.getString("LAWORD_CD_NM");
						row_ad[5] = rs.getString("DSPSCN");
						row_ad[6] = rs.getString("DSPS_TYPECD_NM");
						row_ad[7] = rs.getString("DSPS_BGNDT");
						row_ad[8] = rs.getString("DSPS_ENDDT");
						
					
						JLabel lblNewLabel = new JLabel(column2[0] +  ":"  + row_ad[0]);
						lblNewLabel.setBounds(5, 5, 424, 15);
						lblNewLabel.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel(column2[1] +  ":"  + row_ad[1]);
						lblNewLabel_1.setBounds(5, 30, 417, 25);
						lblNewLabel_1.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_1);
						
						JLabel lblNewLabel_2 = new JLabel(column2[2] +  ":"  + row_ad[2]);
						lblNewLabel_2.setBounds(5, 65, 417, 25);
						lblNewLabel_2.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_2);
						
						JLabel lblNewLabel_3 = new JLabel(column2[3] +  ":"  + row_ad[3]);
						lblNewLabel_3.setBounds(5, 100, 417, 25);
						lblNewLabel_3.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_3);
						
						JLabel lblNewLabel_4 = new JLabel(column2[4] +  ":"  + row_ad[4]);
						lblNewLabel_4.setBounds(5, 135, 417, 25);
						lblNewLabel_4.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_4);
						
						JLabel lblNewLabel_5 = new JLabel(column2[5] +  ":"  + row_ad[5]);
						lblNewLabel_5.setBounds(5, 170, 417, 30);
						lblNewLabel_5.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_5);
						
						JLabel lblNewLabel_6 = new JLabel(column2[6] +  ":"  + row_ad[6]);
						lblNewLabel_6.setBounds(5, 212, 417, 25);
						lblNewLabel_6.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_6);
						
						JLabel lblNewLabel_7 = new JLabel(column2[7] +  ":"  + row_ad[7]);
						lblNewLabel_7.setBounds(5, 247, 429, 25);
						lblNewLabel_7.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_7);
						
						JLabel lblNewLabel_8 = new JLabel(column2[8] +  ":"  + row_ad[8]);
						lblNewLabel_8.setBounds(5, 282, 417, 25);
						lblNewLabel_8.setFont(new Font("�޸�����ü", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_8);
						
						setSize(400, 400);
						setVisible(true);
					}

				} catch (SQLException e1) {
					System.out.println("���� ����: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.out.println("���� ����: " + e1.getMessage());
				}
			}
		}

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con;
				PreparedStatement stmt = null;
				String driverName = "com.mysql.jdbc.Driver";
				String dbURL = "jdbc:mysql://localhost:3306/1801585_db";
				ResultSet rs = null;
				Object address = comboBox.getSelectedItem();
				Object add_si = comboBox_2.getSelectedItem();

				try {
					Class.forName(driverName);
					con = DriverManager.getConnection(dbURL, "root", "1234"); // JDBC����
					System.out.println("Successed");
					String SQL = "SELECT * FROM 1801585_db.restaurant where ADDR_sido ='" + address
							+ "' and ADDR_gusi= '" + add_si + "'; ";// �ÿ� ���������� �°� SELECT����

					stmt = con.prepareStatement(SQL);
					rs = stmt.executeQuery();

					model.setNumRows(0); // ���̺� �ʱ�ȭ

					while (rs.next()) {
						String[] row = new String[5];
						row[0] = rs.getString("ADDR");
						row[1] = rs.getString("LCNS_NO");
						row[2] = rs.getString("PRSDNT_NM");
						row[3] = rs.getString("INDUTY_CD_NM");
						row[4] = rs.getString("PRCSCITYPOINT_BSSHNM");

						model.addRow(row);

						scroll_table.setBounds(28, 154, 500, 508);
						contentPane.add(scroll_table);
						setVisible(true);

					}
				} catch (Exception e1) {
					System.out.println("Error: " + e1.getMessage());
				}

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new newWindow();

			}
		});

	}
}