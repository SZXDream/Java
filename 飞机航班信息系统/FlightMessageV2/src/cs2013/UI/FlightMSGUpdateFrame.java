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
import java.sql.Timestamp;
import java.util.Date;
import java.util.Locale;

import javax.swing.JTextArea;

import org.apache.log4j.Logger;

import com.eltima.components.ui.DatePicker;

import cs2013.dao1.FlightMessageDaoForDBImp;
import cs2013.dao1.IBaseDao;
import cs2013.entry1.FlightMessage;
import cs2013.service1.FlightMessageImp;
import cs2013.service1.IFlightMessageService;

public class FlightMSGUpdateFrame extends JFrame {
	private JPanel contentPane;
	private JTextField txtId5;
	private JTextField txtFlyNumber5;
	private JTextField txtOffPlace5;
	private JTextField txtArrivivalPlace5;
	private JTextField txtTicketPrice5;
	private JTextField txtNumberTicket5;
	private JTextField txtRemanentTicket;
	private JButton btnUpdate5;
	IFlightMessageService flightservice = null;
	private static Logger logger = Logger.getLogger(FlightMSGUpdateFrame.class);

	//
	private DatePicker datepick2;
	private DatePicker datepick3;
	private static final String DefaultFormat = "yyyy-MM-dd"; // 鏃ユ湡鏍煎紡
	private Date date = new Date();
	private Font font = new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension = new Dimension(177, 24);
	private int[] hilightDays = { 1, 3, 5, 7 };
	private int[] disabledDays = { 4, 6, 5, 9 };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightMSGUpdateFrame frame = new FlightMSGUpdateFrame();
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
	public FlightMSGUpdateFrame() {
		setTitle("\u4FEE\u6539\u822A\u73ED\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId5 = new JLabel("\u98DE \u673AID \uFF1A");
		lblId5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblId5.setBounds(55, 38, 95, 20);
		contentPane.add(lblId5);

		JLabel lblFlyNumber5 = new JLabel("\u822A \u73ED \u53F7\uFF1A");
		lblFlyNumber5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblFlyNumber5.setBounds(402, 38, 95, 20);
		contentPane.add(lblFlyNumber5);

		JLabel lblDepartmentTime5 = new JLabel("\u51FA\u53D1\u65F6\u95F4\uFF1A");
		lblDepartmentTime5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblDepartmentTime5.setBounds(55, 89, 95, 20);
		contentPane.add(lblDepartmentTime5);

		txtId5 = new JTextField();
		txtId5.setBounds(160, 39, 156, 22);
		contentPane.add(txtId5);
		txtId5.setColumns(10);

		txtFlyNumber5 = new JTextField();
		txtFlyNumber5.setBounds(504, 39, 156, 22);
		contentPane.add(txtFlyNumber5);
		txtFlyNumber5.setColumns(10);

		JLabel lblArrvivalTime5 = new JLabel("\u5230\u8FBE\u65F6\u95F4\uFF1A");
		lblArrvivalTime5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblArrvivalTime5.setBounds(402, 89, 95, 20);
		contentPane.add(lblArrvivalTime5);

		datepick2 = new DatePicker(date, DefaultFormat, font, dimension);
		datepick2.setBounds(160, 89, 156, 22);
		datepick2.setLocale(Locale.CHINA);// 璁剧疆鍥藉
		datepick2.setTimePanleVisible(true);// 璁剧疆鏃堕挓闈㈡澘鍙
		getContentPane().add(datepick2);

		datepick3 = new DatePicker(date, DefaultFormat, font, dimension);
		datepick3.setBounds(504, 89, 156, 21);
		datepick3.setLocale(Locale.CHINA);// 璁剧疆鍥藉
		datepick3.setTimePanleVisible(true);// 璁剧疆鏃堕挓闈㈡澘鍙
		getContentPane().add(datepick3);

		JLabel lblMSG = new JLabel("");
		lblMSG.setBounds(402, 78, 194, 19);
		contentPane.add(lblMSG);

		JButton btnCancel5 = new JButton("\u53D6 \u6D88");
		btnCancel5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel5.setFont(new Font("宋体", Font.PLAIN, 17));
		btnCancel5.setBounds(536, 491, 105, 37);
		contentPane.add(btnCancel5);

		JLabel lblOfflPlace5 = new JLabel("\u51FA\u53D1\u5730\u70B9\uFF1A");
		lblOfflPlace5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblOfflPlace5.setBounds(55, 149, 95, 20);
		contentPane.add(lblOfflPlace5);

		JLabel lblArrivivalPlace5 = new JLabel("\u5230\u8FBE\u5730\u70B9\uFF1A");
		lblArrivivalPlace5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblArrivivalPlace5.setBounds(402, 149, 95, 20);
		contentPane.add(lblArrivivalPlace5);

		JLabel lblTicketPrice5 = new JLabel("\u7968  \u4EF7\uFF1A");
		lblTicketPrice5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblTicketPrice5.setBounds(55, 219, 95, 20);
		contentPane.add(lblTicketPrice5);

		JLabel lblNumberTicket5 = new JLabel("\u603B\u7968\u6570\uFF1A");
		lblNumberTicket5.setFont(new Font("宋体", Font.PLAIN, 17));
		lblNumberTicket5.setBounds(402, 219, 95, 20);
		contentPane.add(lblNumberTicket5);

		JLabel lbRemanentTicket = new JLabel("\u4F59  \u7968\uFF1A");
		lbRemanentTicket.setFont(new Font("宋体", Font.PLAIN, 17));
		lbRemanentTicket.setBounds(55, 291, 95, 20);
		contentPane.add(lbRemanentTicket);

		txtOffPlace5 = new JTextField();
		txtOffPlace5.setColumns(10);
		txtOffPlace5.setBounds(160, 150, 156, 21);
		contentPane.add(txtOffPlace5);

		txtArrivivalPlace5 = new JTextField();
		txtArrivivalPlace5.setColumns(10);
		txtArrivivalPlace5.setBounds(504, 150, 156, 21);
		contentPane.add(txtArrivivalPlace5);

		txtTicketPrice5 = new JTextField();
		txtTicketPrice5.setColumns(10);
		txtTicketPrice5.setBounds(160, 220, 156, 21);
		contentPane.add(txtTicketPrice5);

		txtNumberTicket5 = new JTextField();
		txtNumberTicket5.setColumns(10);
		txtNumberTicket5.setBounds(504, 220, 156, 21);
		contentPane.add(txtNumberTicket5);

		txtRemanentTicket = new JTextField();
		txtRemanentTicket.setColumns(10);
		txtRemanentTicket.setBounds(160, 292, 156, 21);
		contentPane.add(txtRemanentTicket);

		btnUpdate5 = new JButton("\u66F4\u65B0\u4FE1\u606F");
		btnUpdate5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updateTable();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息！");
				}
				
			}
		});
		btnUpdate5.setFont(new Font("宋体", Font.PLAIN, 17));
		btnUpdate5.setBounds(403, 491, 105, 37);
		contentPane.add(btnUpdate5);

		JLabel label_5 = new JLabel("");
		label_5.setFont(new Font("宋体", Font.PLAIN, 17));
		label_5.setBounds(670, 22, 123, 20);
		contentPane.add(label_5);
		flightservice = new FlightMessageImp();
		IBaseDao dao = new FlightMessageDaoForDBImp();

		flightservice.setDao(dao);
	}

	public FlightMessage getFlightMessage() {

		// 时间格式转换
		Date date = (Date) datepick2.getValue();
		Timestamp ts2 = new Timestamp(date.getTime());

		try {
			date = ts2;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		Date date1 = (Date) datepick3.getValue();
		Timestamp ts3 = new Timestamp(date1.getTime());

		try {
			date1 = ts3;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		FlightMessage flight = new FlightMessage(Integer.parseInt(txtId5
				.getText()), txtFlyNumber5.getText(), ts2, ts3,
				txtOffPlace5.getText(), txtArrivivalPlace5.getText(),
				Integer.parseInt(txtTicketPrice5.getText()),
				Integer.parseInt(txtNumberTicket5.getText()),
				Integer.parseInt(txtRemanentTicket.getText()));
		return flight;
	}

	public void updateTable() {
		FlightMessage flight = getFlightMessage();
		if (flightservice.update(flight)) {
			logger.info("Admin Update a flight Message,it is " + flight.getFly_id());
			JOptionPane.showMessageDialog(null, "修改 成 功！");
		} else {
			JOptionPane.showMessageDialog(null, "修改 失败！");
		}
	}
}
