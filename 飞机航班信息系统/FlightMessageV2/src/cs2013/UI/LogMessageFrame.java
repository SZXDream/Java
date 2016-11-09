package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;

import cs2013.entry1.FlightMessage;
import cs2013.entry1.LogMessage;
import cs2013.utilV1.DBUtilities;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogMessageFrame extends JFrame {

	private JPanel contentPane;
	private static Logger logger = Logger.getLogger(LogMessageFrame.class);
	private JTable table;
	private DefaultTableModel tableModel;
	private int row = 0;
	final String configFile = "jdbc.conf"; // 配置文件

	private Connection conn = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogMessageFrame frame = new LogMessageFrame();
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
	public LogMessageFrame() {
		setTitle("\u65E5\u5FD7\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 715, 366);
		contentPane.add(scrollPane);
		String[] column = { "ID", "LogLevel", "UseTime", "MSG"};
		Object[][] tableValues = {
				{ null, null, null, null},
				{ null, null, null, null },
				{ null, null, null, null},
				{ null, null, null, null},
				{ null, null, null, null },
				{ null, null, null, null },
				{ null, null, null, null},
				{ null, null, null, null },
				{ null, null, null, null},
				{ null, null, null, null},
				{ null, null, null, null},
				{ null, null, null, null},};

		tableModel = new DefaultTableModel(tableValues, column);
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null},
				{null, null, null, null},{null, null, null, null}
			},
			new String[] {
				"ID", "LogLevel", "UseTime", "MSG"
			}
		));
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
		table.setRowSorter(sorter);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					initTable();
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(519, 417, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u5173\u95ED");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		button.setBounds(638, 417, 93, 23);
		contentPane.add(button);
	}
	
	


	private void getConnection() {
		// 获得数据库连接
		// 取得配置文件存储的路径,此外约定文件是存放在项目的“根”下
		String strFile = this.getClass().getResource("/").getPath();
		conn = DBUtilities.connect(strFile + configFile);
	}
	
	public List<LogMessage> findAll() {
		List list = null;

		// 1.判断数据库的连接是否已经获取
		if (conn == null) {
			getConnection();
		}

		if (conn != null) {
			// 2.创建SQL语句对象：
			String sql = "Select * from logtable ";

			PreparedStatement pst = null;
			ResultSet rs = null;
			try {
				pst = conn.prepareStatement(sql);

				// 3.执行SQL语句
				rs = pst.executeQuery();
				// 4.处理执行结果，并返回
				if (rs != null) {
					// list = new ArrayList<FlightMessage>();
					list = new ArrayList<FlightMessage>();
					while (rs.next()) {
						LogMessage lg = new LogMessage(
								rs.getInt("id"),
								rs.getString("LogLevel"),
								rs.getString("UseTime"),
								rs.getString("MSG"));

						list.add(lg);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					rs.close();
					pst.close();
				} catch (SQLException e) {
				}
			}
		}

		return list;
	}
	
	public void initTable() {
		for (LogMessage lg : findAll()) {
			if (lg == null) {
				break;
			}

			int countRow = table.getRowCount();
			if (row < countRow) {
				table.setValueAt(lg.getId(), row, 0);
				table.setValueAt(lg.getLogLevel(), row, 1);
				table.setValueAt(lg.getUseTime(), row, 2);
				table.setValueAt(lg.getMsg(), row, 3);
			} else {
				((javax.swing.table.DefaultTableModel) table.getModel())
						.insertRow(
								countRow,
								new Object[] {lg.getId(),
										lg.getLogLevel(),
										lg.getUseTime(),
										lg.getMsg()});
			}
			row++;
		}
	}
	

}
