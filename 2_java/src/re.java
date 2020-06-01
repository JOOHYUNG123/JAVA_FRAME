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
	String column[] = { "주소", "인허가번호", "대표자명", "업종", "업소명" };
	String column2[] = { "주소", "위반내용", "위반일자", "처분확정일자", "위반법령", "처분내용", "처분유형", "처분시작일", "처분종료일" };

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
		setTitle("식품행정처분결과");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 755);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("식품행정처분결과");
		lblNewLabel.setBounds(147, 20, 321, 44);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("문체부 쓰기 정체", Font.PLAIN, 35));
		lblNewLabel.setForeground(new Color(50, 205, 50));
		contentPane.add(lblNewLabel);
		contentPane.setVisible(true);

		JComboBox comboBox = new JComboBox();
		comboBox.setRequestFocusEnabled(false);
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setFont(new Font("문체부 돋음체", Font.PLAIN, 12));
		comboBox.setBorder(new LineBorder(new Color(154, 205, 50), 1, true));
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "강원도", "경기도","서울특별시","인천광역시","충청북도",
				"충청남도","경상북도","경상남도","전라북도","전라남도","대구광역시","울산광역시","대전광역시","부산광역시","제주특별자치도",
				"세종특별자치시" }));
		comboBox.setBounds(108, 100, 130, 32);
		contentPane.add(comboBox);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("문체부 돋음체", Font.PLAIN, 12));
		comboBox_2.setBorder(new LineBorder(new Color(154, 205, 50), 1, true));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(271, 100, 130, 32);
		contentPane.add(comboBox_2);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object address = comboBox.getSelectedItem();
				if (address == "강원도") {
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "춘천시", "원주시", "강릉시", "동해시", "태백시", "속초시", "삼척시",
									"홍천군", "횡성군", "영월군", "평창군", "정선군", "철원군", "화천군", "양구군", "인제군", "고성군", "양양군" }));
				} else if (address == "경기도") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "수원시", "성남시", "의정부시", "안양시", "부천시", "광명시", "평택시", "동두천시", "안산시", "고양시",
									"과천시", "구리시", "남양주시", "오산시", "시흥시", "군포시", "의왕시", "하남시", "용인시", "파주시", "이천시", "안성시",
									"김포시", "화성시", "광주시", "양주시", "포천시", "여주시", "연천군", "가평군", "양평군" }));
				} else if (address == "서울특별시") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "종로구", "중구", "용산구", "성동구", "광진구",
							"동대문구", "중랑구", "성북구", "강북구", "도봉구", "노원구", "은평구", "서대문구", "마포구", "양천구", "강서구", "구로구", "금천구",
							"영등포구", "동작구", "관악구", "서초구", "강남구", "송파구", "강동구" }));
				} else if (address == "인천광역시") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "중구", "동구", "미추홀구", "연수구", "남동구", "부평구", "계양구", "서구", "강화군", "옹진군" }));
				} else if (address == "충청북도") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "청주시", "충주시", "제천시", "보은군", "옥천군",
							"영동군", "증평군", "진천군", "괴산군", "음성군", "단양군" }));
				} else if (address == "충청남도") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "천안시", "공주시", "보령시", "아산시", "서산시",
							"논산시", "계룡시", "당진시", "금산군", "부여군", "서천군", "청양군", "홍성군", "예산군", "태안군" }));
				} else if (address == "경상북도") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "포항시", "경주시", "김천시", "안동시", "구미시",
							"영주시", "영천시", "상주시", "문경시", "경산시", "군위군", "의성군", "청송군", "영양군", "영덕군", "청도군", "고령군", "성주군",
							"칠곡군", "예천군", "봉화군", "울진군", "울릉군" }));
				} else if (address == "경상남도") {
					comboBox_2.setModel(
							new DefaultComboBoxModel(new String[] { "창원시", "진주시", "통영시", "사천시", "김해시", "밀양시", "거제시",
									"양산시", "의령군", "함안군", "창녕군", "고성군", "남해군", "하동군", "산청군", "함양군", "거창군", "합천군" }));
				} else if (address == "전라북도") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "전주시", "군산시", "익산시", "정읍시", "남원시",
							"김제시", "완주군", "진안군", "무주군", "장수군", "임실군", "순창군", "고창군", "부안군" }));
				} else if (address == "전라남도") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "목포시", "여수시", "순천시", "나주시", "광양시", "담양군", "곡성군", "구례군", "고흥군", "보성군", "화순군",
									"장흥군", "강진군", "해남군", "영암군", "무안군", "함평군", "영광군", "장성군", "완도군", "진도군", "신안군" }));
				} else if (address == "대구광역시") {
					comboBox_2.setModel(new DefaultComboBoxModel(
							new String[] { "중구", "동구", "서구", "남구", "북구", "수성구", "달서구", "달성군" }));
				} else if (address == "울산광역시") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "중구", "남구", "동구", "북구", "울주군" }));
				} else if (address == "대전광역시") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "동구", "중구", "서구", "유성구", "대덕구" }));
				} else if (address == "부산광역시") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "중구", "서구", "동구", "영도구", "부산진구", "동래구",
							"남구", "북구", "해운대구", "사하구", "금정구", "강서구", "연제구", "수영구", "사상구", "기장군" }));
				} else if (address == "제주특별자치도") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "제주시", "서귀포시" }));
				} else if (address == "세종특별자치시") {
					comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "반곡동", "소담동", "보람동", "대평동", "가람동",
							"한솔동", "나성동", "새롬동", "다정동", "어진동", "종촌동", "고운동", "아름동", "도담동", "조치원읍", "연기면", "연동면", "부강면",
							"금남면", "장군면", "연서면", "전의면", "전동면", "소정면" }));
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
		btnNewButton.setFont(new Font("문체부 돋음체", Font.PLAIN, 10));
		btnNewButton.setBounds(460, 682, 85, 24);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\uC138\uBD80\uC0AC\uD56D\uC740 \uC8FC\uC18C\uB97C \uB204\uB974\uACE0 \uBC84\uD2BC\uC744 \uC120\uD0DD\uD574\uC8FC\uC138\uC694.");
		label.setBounds(179, 681, 280, 24);
		contentPane.add(label);
		

		class newWindow extends JFrame {
			newWindow() {
				JPanel contentPane_n;
				setTitle("식품행정처분 자세히보기");
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
					con = DriverManager.getConnection(dbURL, "root", "1234"); // JDBC연결
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
						lblNewLabel.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel);
						
						JLabel lblNewLabel_1 = new JLabel(column2[1] +  ":"  + row_ad[1]);
						lblNewLabel_1.setBounds(5, 30, 417, 25);
						lblNewLabel_1.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_1);
						
						JLabel lblNewLabel_2 = new JLabel(column2[2] +  ":"  + row_ad[2]);
						lblNewLabel_2.setBounds(5, 65, 417, 25);
						lblNewLabel_2.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_2);
						
						JLabel lblNewLabel_3 = new JLabel(column2[3] +  ":"  + row_ad[3]);
						lblNewLabel_3.setBounds(5, 100, 417, 25);
						lblNewLabel_3.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_3);
						
						JLabel lblNewLabel_4 = new JLabel(column2[4] +  ":"  + row_ad[4]);
						lblNewLabel_4.setBounds(5, 135, 417, 25);
						lblNewLabel_4.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_4);
						
						JLabel lblNewLabel_5 = new JLabel(column2[5] +  ":"  + row_ad[5]);
						lblNewLabel_5.setBounds(5, 170, 417, 30);
						lblNewLabel_5.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_5);
						
						JLabel lblNewLabel_6 = new JLabel(column2[6] +  ":"  + row_ad[6]);
						lblNewLabel_6.setBounds(5, 212, 417, 25);
						lblNewLabel_6.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_6);
						
						JLabel lblNewLabel_7 = new JLabel(column2[7] +  ":"  + row_ad[7]);
						lblNewLabel_7.setBounds(5, 247, 429, 25);
						lblNewLabel_7.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_7);
						
						JLabel lblNewLabel_8 = new JLabel(column2[8] +  ":"  + row_ad[8]);
						lblNewLabel_8.setBounds(5, 282, 417, 25);
						lblNewLabel_8.setFont(new Font("휴먼편지체", Font.PLAIN, 15));
						NewWindowContainer.add(lblNewLabel_8);
						
						setSize(400, 400);
						setVisible(true);
					}

				} catch (SQLException e1) {
					System.out.println("선택 오류: " + e1.getMessage());
				} catch (ClassNotFoundException e1) {
					System.out.println("선택 오류: " + e1.getMessage());
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
					con = DriverManager.getConnection(dbURL, "root", "1234"); // JDBC연결
					System.out.println("Successed");
					String SQL = "SELECT * FROM 1801585_db.restaurant where ADDR_sido ='" + address
							+ "' and ADDR_gusi= '" + add_si + "'; ";// 시와 행정구역에 맞게 SELECT해줌

					stmt = con.prepareStatement(SQL);
					rs = stmt.executeQuery();

					model.setNumRows(0); // 테이블 초기화

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