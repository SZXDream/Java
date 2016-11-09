package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

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
import javax.swing.text.TableView;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import cs2013.dao1.FlightMessageDaoForDBImp;
import cs2013.dao1.IBaseDao;
import cs2013.entry1.FlightMessage;
import cs2013.service1.FlightMessageImp;
import cs2013.service1.IFlightMessageService;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FlightMSGDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private int row = 0;
	IFlightMessageService flightservice = null;
	
	private static Logger logger = Logger.getLogger(FlightMSGDeleteFrame.class);

	// flightservice = new FlightMessageImp();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightMSGDeleteFrame frame = new FlightMSGDeleteFrame();
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
	public FlightMSGDeleteFrame() {
		setTitle("\u5220\u9664\u822A\u73ED\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 715, 310);
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

		JButton btnDelete = new JButton("\u5220\u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					deletetable();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请选择要删除的行！");
				}
				
			}
		});
		btnDelete.setBounds(346, 366, 93, 23);
		contentPane.add(btnDelete);

		JButton btnCancel4 = new JButton("\u53D6\u6D88");
		btnCancel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel4.setBounds(525, 366, 93, 23);
		contentPane.add(btnCancel4);

		flightservice = new FlightMessageImp();
		IBaseDao dao = new FlightMessageDaoForDBImp();

		flightservice.setDao(dao);

		initTable(flightservice.findAll());

	}

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
								row,
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

	public void deletetable() {
		int row = table.getSelectedRow();
		int selectedRow = table.getSelectedRow();// 获得选中行的索引
		int Fly_Id = (Integer) tableModel.getValueAt(row, 0);
		
		if (selectedRow != -1) // 存在选中行
		{
			tableModel.removeRow(selectedRow);// 删除行
			flightservice.delete(Fly_Id);
			logger.info("admin delete flightmessage！");
			JOptionPane.showMessageDialog(null, "删除成 功!");
		}

	}
}
