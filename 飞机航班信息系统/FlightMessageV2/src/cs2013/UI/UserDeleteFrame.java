package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;

import cs2013.dao1.FlightMessageDaoForDBImp;
import cs2013.dao1.IBaseDao;
import cs2013.dao1.UserDaoForDBImp;
import cs2013.entry1.FlightMessage;
import cs2013.entry1.User;
import cs2013.service1.FlightMessageImp;
import cs2013.service1.IUserService;
import cs2013.service1.UserServiceImp;

public class UserDeleteFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel tableModel;
	private int row = 0;
	IUserService service = null;
	private static Logger logger = Logger.getLogger(UserDeleteFrame.class);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserDeleteFrame frame = new UserDeleteFrame();
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
	public UserDeleteFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		setTitle("\u5220\u9664\u822A\u73ED\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 698, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 23, 634, 310);
		contentPane.add(scrollPane);
		String[] column = { "用户ID", "用户名", "密码", "权限" };

		// table.setModel(new DefaultTableModel(
		Object[][] tableValues = { { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null },
				{ null, null, null, null }, { null, null, null, null } };

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
					JOptionPane.showMessageDialog(null, "请选择要删除的用户！");
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

		service = new UserServiceImp();

		IBaseDao dao = new UserDaoForDBImp();

		service.setDao(dao);

		initTable(service.findAll());

	}

	public void initTable(List<User> userslist) {
		for (User user : userslist) {
			if (user == null) {
				break;
			}
			int countRow = table.getRowCount();
			if (row < countRow) {
				table.setValueAt(user.getUser_id(), row, 0);
				table.setValueAt(user.getUser_name(), row, 1);
				table.setValueAt(user.getUser_password(), row, 2);
				table.setValueAt(user.getUser_authority(), row, 3);
			} else {
				((javax.swing.table.DefaultTableModel) table.getModel())
						.insertRow(
								row,
								new Object[] { user.getUser_id(),
										user.getUser_name(),
										user.getUser_password(),
										user.getUser_authority() });
			}
			row++;
		}
	}

	public void deletetable() {
		int row = table.getSelectedRow();
		int selectedRow = table.getSelectedRow();// 获得选中行的索引
		int user_Id = (Integer) tableModel.getValueAt(row, 0);

		if (selectedRow != -1) // 存在选中行
		{
			tableModel.removeRow(selectedRow);// 删除行
			service.delete(user_Id);
			logger.info("Admin delete a user,he is "+ user_Id);
			JOptionPane.showMessageDialog(null, "删除成 功!");
		}

	}

}
