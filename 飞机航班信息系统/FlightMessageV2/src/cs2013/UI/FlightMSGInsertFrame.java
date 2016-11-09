package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import cs2013.dao1.FlightMessageDaoForDBImp;
import cs2013.dao1.IBaseDao;
import cs2013.entry1.FlightMessage;
import cs2013.service1.FlightMessageImp;
import cs2013.service1.IFlightMessageService;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.apache.log4j.Logger;

import com.eltima.components.ui.DatePicker;

public class FlightMSGInsertFrame extends JFrame {
	private JTextArea textArea;
	private JPanel contentPane;
	private JTextField txtId1;
	private JTextField txtFlyNumber;
	private JTextField txtOffPlace;
	private JTextField txtArrivivalPlace;
	private JTextField txtTicketPrice;
	private JTextField txtNumberTicket;
	private JTextField txtRemanentTicket;
	private JButton btnInsert3;

	private DatePicker datepick;
	private DatePicker datepick1;
	private static final String DefaultFormat = "yyyy-MM-dd"; // 鏃ユ湡鏍煎紡
	private Date date = new Date();
	private Font font = new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension = new Dimension(177, 24);
	private int[] hilightDays = { 1, 3, 5, 7 };
	private int[] disabledDays = { 4, 6, 5, 9 };
	IFlightMessageService flightservice = null;
	private static Logger logger = Logger.getLogger(FlightMSGInsertFrame.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightMSGInsertFrame frame = new FlightMSGInsertFrame();
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
	public FlightMSGInsertFrame() {
		setBackground(UIManager
				.getColor("CheckBoxMenuItem.selectionBackground"));
		setTitle("\u822A\u73ED\u4FE1\u606F\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 577);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblId1 = new JLabel("\u98DE \u673AID \uFF1A");
		lblId1.setBounds(55, 22, 95, 20);
		lblId1.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblFlyNumber = new JLabel("\u822A \u73ED \u53F7\uFF1A");
		lblFlyNumber.setBounds(402, 22, 95, 20);
		lblFlyNumber.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblDepartmentTime = new JLabel("\u51FA\u53D1\u65F6\u95F4\uFF1A");
		lblDepartmentTime.setBounds(55, 89, 95, 20);
		lblDepartmentTime.setFont(new Font("宋体", Font.PLAIN, 17));

		datepick = new DatePicker(date, DefaultFormat, font, dimension);
		datepick.setBounds(160, 89, 156, 22);
		datepick.setLocale(Locale.CHINA);// 璁剧疆鍥藉
		datepick.setTimePanleVisible(true);// 璁剧疆鏃堕挓闈㈡澘鍙
		getContentPane().add(datepick);

		datepick1 = new DatePicker(date, DefaultFormat, font, dimension);
		datepick1.setBounds(504, 89, 156, 21);
		datepick1.setLocale(Locale.CHINA);// 璁剧疆鍥藉
		datepick1.setTimePanleVisible(true);// 璁剧疆鏃堕挓闈㈡澘鍙
		getContentPane().add(datepick1);

		txtId1 = new JTextField();
		txtId1.setBounds(160, 23, 156, 22);
		txtId1.setColumns(10);

		txtFlyNumber = new JTextField();
		txtFlyNumber.setBounds(504, 23, 156, 22);
		txtFlyNumber.setColumns(10);

		JLabel lblArrvivalTime = new JLabel("\u5230\u8FBE\u65F6\u95F4\uFF1A");
		lblArrvivalTime.setBounds(402, 89, 95, 20);
		lblArrvivalTime.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblMSG = new JLabel("");
		lblMSG.setBounds(402, 78, 194, 19);

		JButton btnCancel3 = new JButton("\u53D6 \u6D88");
		btnCancel3.setBounds(289, 486, 105, 37);
		btnCancel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel3.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblOfflPlace = new JLabel("\u51FA\u53D1\u5730\u70B9\uFF1A");
		lblOfflPlace.setBounds(55, 149, 95, 20);
		lblOfflPlace.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblArrivivalPlace = new JLabel("\u5230\u8FBE\u5730\u70B9\uFF1A");
		lblArrivivalPlace.setBounds(402, 149, 95, 20);
		lblArrivivalPlace.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblTicketPrice = new JLabel("\u7968  \u4EF7\uFF1A");
		lblTicketPrice.setBounds(55, 219, 87, 20);
		lblTicketPrice.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lblNumberTicket = new JLabel("\u603B\u7968\u6570\uFF1A");
		lblNumberTicket.setBounds(55, 278, 68, 20);
		lblNumberTicket.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel lbRemanentTicket = new JLabel("\u4F59  \u7968\uFF1A");
		lbRemanentTicket.setBounds(55, 352, 95, 20);
		lbRemanentTicket.setFont(new Font("宋体", Font.PLAIN, 17));

		txtOffPlace = new JTextField();
		txtOffPlace.setBounds(160, 150, 156, 21);
		txtOffPlace.setColumns(10);

		txtArrivivalPlace = new JTextField();
		txtArrivivalPlace.setBounds(504, 150, 156, 21);
		txtArrivivalPlace.setColumns(10);

		txtTicketPrice = new JTextField();
		txtTicketPrice.setBounds(160, 220, 156, 21);
		txtTicketPrice.setColumns(10);

		txtNumberTicket = new JTextField();
		txtNumberTicket.setBounds(160, 279, 156, 21);
		txtNumberTicket.setColumns(10);

		txtRemanentTicket = new JTextField();
		txtRemanentTicket.setBounds(160, 353, 156, 21);
		txtRemanentTicket.setColumns(10);

		btnInsert3 = new JButton("\u6DFB\u52A0\u4FE1\u606F");
		btnInsert3.setBounds(166, 486, 105, 37);
		btnInsert3.setEnabled(false);
		btnInsert3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					insertTable();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息！");
				}
				
			}
		});
		btnInsert3.setFont(new Font("宋体", Font.PLAIN, 17));

		JButton btnConfirm3 = new JButton("\u786E\u8BA4\u4FE1\u606F");
		btnConfirm3.setBounds(55, 486, 105, 37);
		btnConfirm3.setBackground(UIManager
				.getColor("ColorChooser.swatchesDefaultRecentColor"));
		btnConfirm3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuffer sb = new StringBuffer();
				sb.append("飞机ID　：\t" + txtId1.getText());
				sb.append("\t航班号:\t" + txtFlyNumber.getText());
				sb.append("\n");

				sb.append("出发时间　：" + datepick.getValue().toString());
				sb.append("\n");
				sb.append("到达时间:" + datepick1.getValue().toString());
				sb.append("\n");
				sb.append("出发地点　：\t" + txtOffPlace.getText());
				sb.append("\t到达地点:\t" + txtArrivivalPlace.getText());
				sb.append("\n");
				sb.append("票价　：\t" + txtTicketPrice.getText());
				sb.append("\t总票数:\t" + txtNumberTicket.getText());
				sb.append("\n");
				sb.append("余票数　：\t" + txtRemanentTicket.getText());
				textArea.setText(sb.toString());
				if (!"".equals(txtId1.getText())
						&& !"".equals(txtFlyNumber.getText())
						&& !"".equals(txtOffPlace.getText())
						&& !"".equals(txtArrivivalPlace.getText())
						&& !"".equals(txtTicketPrice.getText())
						&& !"".equals(txtNumberTicket.getText())
						&& !"".equals(txtRemanentTicket.getText())) {
					btnInsert3.setEnabled(true);
				}

			}
		});
		btnConfirm3.setFont(new Font("宋体", Font.PLAIN, 17));

		JLabel label_5 = new JLabel("");
		label_5.setBounds(670, 22, 123, 20);
		label_5.setFont(new Font("宋体", Font.PLAIN, 17));

		textArea = new JTextArea();
		textArea.setBounds(412, 278, 363, 235);

		JLabel label = new JLabel("\u5143");
		label.setBounds(334, 220, 53, 19);
		label.setFont(new Font("宋体", Font.PLAIN, 17));
		contentPane.setLayout(null);
		contentPane.add(lblId1);
		contentPane.add(lblFlyNumber);
		contentPane.add(lblDepartmentTime);
		contentPane.add(txtId1);
		contentPane.add(txtFlyNumber);
		contentPane.add(lblArrvivalTime);
		contentPane.add(lblMSG);
		contentPane.add(btnCancel3);
		contentPane.add(lblOfflPlace);
		contentPane.add(lblArrivivalPlace);
		contentPane.add(lblTicketPrice);
		contentPane.add(lblNumberTicket);
		contentPane.add(lbRemanentTicket);
		contentPane.add(txtOffPlace);
		contentPane.add(txtArrivivalPlace);
		contentPane.add(txtTicketPrice);
		contentPane.add(txtNumberTicket);
		contentPane.add(txtRemanentTicket);
		contentPane.add(btnInsert3);
		contentPane.add(btnConfirm3);
		contentPane.add(label_5);
		contentPane.add(textArea);
		contentPane.add(label);
		flightservice = new FlightMessageImp();
		IBaseDao dao = new FlightMessageDaoForDBImp();

		flightservice.setDao(dao);
	}

	public FlightMessage getFlightMessage() {
		Date date = (Date) datepick.getValue();
		Timestamp ts = new Timestamp(date.getTime());

		try {
			date = ts;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Date date1 = (Date) datepick1.getValue();
		Timestamp ts1 = new Timestamp(date1.getTime());

		try {
			date1 = ts1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		FlightMessage flight = new FlightMessage(Integer.parseInt(txtId1
				.getText()), txtFlyNumber.getText(), ts, ts1,
				txtOffPlace.getText(), txtArrivivalPlace.getText(),
				Integer.parseInt(txtTicketPrice.getText()),
				Integer.parseInt(txtNumberTicket.getText()),
				Integer.parseInt(txtRemanentTicket.getText()));
		return flight;
	}

	public void insertTable() {
		FlightMessage flight = getFlightMessage();
		if (flightservice.findByFly_Id(flight.getFly_id()) == null) {
			if (flightservice.add(flight)) {
				logger.info("Admin insert a flight message!");
				JOptionPane.showMessageDialog(null, "添 加 成 功！");
			} else {
				JOptionPane.showMessageDialog(null, "添 加 失败！");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "该航班已存在！");
		}
	}
}
