package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.security.Provider.Service;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import cs2013.dao1.FlightMessageDaoForDBImp;
import cs2013.dao1.IBaseDao;
import cs2013.entry1.FlightMessage;
import cs2013.entry1.User;
import cs2013.service1.FlightMessageImp;
import cs2013.service1.IFlightMessageService;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import com.eltima.components.ui.DatePicker;
import javax.swing.JLabel;

public class FlightMSGQueryFrame extends JFrame {

	
	private DatePicker datepick;
	private static final String DefaultFormat = "yyyy-MM-dd HH:mm:ss"; // 鏃ユ湡鏍煎紡
	private Date date = new Date();
	private Font font = new Font("Times New Roman", Font.BOLD, 14);
	private Dimension dimension = new Dimension(177, 24);
	private int[] hilightDays = { 1, 3, 5, 7 };
	private int[] disabledDays = { 4, 6, 5, 9 };
	// 日期显示

	private DefaultTableModel tableModel;

	private JPanel contentPane;
	private JTable table;
	int row = 0;

	IFlightMessageService flightservice = null;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightMSGQueryFrame frame = new FlightMSGQueryFrame();
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
	public FlightMSGQueryFrame() {

		setTitle("\u822A\u73ED\u4FE1\u606F\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.WHITE); //
		setBounds(100, 100, 971, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		datepick = new DatePicker(date, DefaultFormat, font, dimension);
		datepick.setBounds(126, 22, 177, 24);
		datepick.setLocale(Locale.CHINA);// 璁剧疆鍥藉
		datepick.setTimePanleVisible(true);// 璁剧疆鏃堕挓闈㈡澘鍙
		getContentPane().add(datepick);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 56, 880, 333);
		contentPane.add(scrollPane);

		String[] column = { "飞机ID", "航班号", "出发时间", "到达时间", "出发地点", "到达地点",
				"票价", "总票数", "余票" };

		// table.setModel(new DefaultTableModel(
		Object[][] tableValues = {
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null } };

		tableModel = new DefaultTableModel(tableValues, column);
		table = new JTable(tableModel);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		scrollPane.setViewportView(table);

		JButton btnCloseinsert = new JButton("\u5173\u95ED");
		btnCloseinsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCloseinsert.setBounds(657, 331, 93, 23);
		contentPane.add(btnCloseinsert);

		JLabel lblQuery = new JLabel("\u8BF7\u9009\u62E9\u65E5\u671F\uFF1A");
		lblQuery.setForeground(Color.RED);
		lblQuery.setFont(new Font("宋体", Font.PLAIN, 14));
		lblQuery.setBounds(23, 22, 93, 24);
		contentPane.add(lblQuery);

		JButton btnQuery = new JButton("\u67E5\u8BE2");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectDepartTime();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请选择有效信息！");
				}
				

			}
		});

		btnQuery.setForeground(Color.RED);
		btnQuery.setBounds(346, 23, 93, 23);
		contentPane.add(btnQuery);

		txtid = new JTextField();
		txtid.setBounds(591, 25, 161, 21);
		contentPane.add(txtid);
		txtid.setColumns(10);

		JButton btnid = new JButton("\u67E5\u8BE2");
		btnid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					selectid();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息！");
				}
				
			}
		});
		btnid.setBounds(808, 23, 93, 23);
		contentPane.add(btnid);

		JLabel label = new JLabel("\u8BF7\u8F93\u5165\u822A\u73ED\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setForeground(Color.RED);
		label.setBackground(Color.RED);
		label.setBounds(479, 22, 102, 24);
		contentPane.add(label);

		JButton button = new JButton("\u53D6\u6D88");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(808, 419, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\u4E00\u952E\u67E5\u8BE2");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				initTable(flightservice.findAll());
			}
		});
		button_1.setBounds(674, 419, 93, 23);
		contentPane.add(button_1);
		flightservice = new FlightMessageImp();
		IBaseDao dao = new FlightMessageDaoForDBImp();
		flightservice.setDao(dao);
	}

	// // table 初始化
	public void initTable(List<FlightMessage> flightslist) {

		for (FlightMessage flight : flightslist) {
			if (flight == null) {
				break;
			}

			int countRow = table.getRowCount();
			if (row < countRow) {
				table.setValueAt(flight.getFly_id(), row, 0);
				table.setValueAt(flight.getFly_number(), row, 1);
				table.setValueAt(flight.getDeparture_time(), row, 2);
				table.setValueAt(flight.getArrvival_time(), row, 3);
				table.setValueAt(flight.getOff_place(), row, 4);
				table.setValueAt(flight.getArrivival_place(), row, 5);
				table.setValueAt(flight.getTicket_price(), row, 6);
				table.setValueAt(flight.getTiceket_number(), row, 7);
				table.setValueAt(flight.getRemanent_ticket(), row, 8);
			} else {
				((javax.swing.table.DefaultTableModel) table.getModel())
						.insertRow(
								countRow,
								new Object[] { flight.getFly_id(),
										flight.getFly_number(),
										flight.getDeparture_time(),
										flight.getArrvival_time(),
										flight.getOff_place(),
										flight.getArrivival_place(),
										flight.getTicket_price(),
										flight.getTiceket_number(),
										flight.getRemanent_ticket() });
			}
			row++;
		}
	}

	public void selectDepartTime() {
		Date date = (Date) datepick.getValue();
		Timestamp ts = new Timestamp(date.getTime());

		try {
			date = ts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<FlightMessage> list = new ArrayList<FlightMessage>();
		FlightMessage flight = (FlightMessage) flightservice
				.findByDeparture_Time(date);
		list.add(flight);
		if (flight != null) {
			for(FlightMessage fl : list) {
				int countRow = table.getRowCount();
				if (row < countRow) {
					table.setValueAt(flight.getFly_id(), row, 0);
					table.setValueAt(flight.getFly_number(), row, 1);
					table.setValueAt(flight.getDeparture_time(), row, 2);
					table.setValueAt(flight.getArrvival_time(), row, 3);
					table.setValueAt(flight.getOff_place(), row, 4);
					table.setValueAt(flight.getArrivival_place(), row, 5);
					table.setValueAt(flight.getTicket_price(), row, 6);
					table.setValueAt(flight.getTiceket_number(), row, 7);
					table.setValueAt(flight.getRemanent_ticket(), row, 8);
				} else {
					((javax.swing.table.DefaultTableModel) table.getModel())
							.insertRow(
									countRow,
									new Object[] { flight.getFly_id(),
											flight.getFly_number(),
											flight.getDeparture_time(),
											flight.getArrvival_time(),
											flight.getOff_place(),
											flight.getArrivival_place(),
											flight.getTicket_price(),
											flight.getTiceket_number(),
											flight.getRemanent_ticket() });
				}
				row++;
			}
		}
	}

	public void selectid() {
		int id = Integer.parseInt(txtid.getText());
		if (id != 0) {
			FlightMessage flight = null;
			flight = (FlightMessage) flightservice.findByFly_Id(id);
			// int countR = table.getRowCount();
			ArrayList list = new ArrayList<FlightMessage>();
			list.add(flight);
			table.setValueAt(flight.getFly_id(), row, 0);
			table.setValueAt(flight.getFly_number(), row, 1);
			table.setValueAt(flight.getDeparture_time(), row, 2);
			table.setValueAt(flight.getArrvival_time(), row, 3);
			table.setValueAt(flight.getOff_place(), row, 4);
			table.setValueAt(flight.getArrivival_place(), row, 5);
			table.setValueAt(flight.getTicket_price(), row, 6);
			table.setValueAt(flight.getTiceket_number(), row, 7);
			table.setValueAt(flight.getRemanent_ticket(), row, 8);
			if (table.getRowCount() > 0) {
				tableModel = (DefaultTableModel) table.getModel(); // 清除表格
				tableModel.setRowCount(0);
			}
			initTable(list);
		}
	}
}
