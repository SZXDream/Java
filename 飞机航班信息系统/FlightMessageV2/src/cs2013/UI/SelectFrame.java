package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectFrame extends JFrame {

	private JPanel contentPane;
	JMenuItem mntmDelete;
	JMenuItem mntmregister;
	JMenuItem mntmUpdate;
	JMenuItem mntmInsert;
	JMenuItem mntmregister11;
	JMenuItem menuItem_2;
	JMenu menu_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectFrame frame = new SelectFrame();
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
	public SelectFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 447);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.textHighlight);
		setJMenuBar(menuBar);

		JMenu menuUser = new JMenu("\u7528\u6237\u7BA1\u7406");
		menuBar.add(menuUser);

		JMenuItem mntmupdate = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserManagementForPasswordFrame pa = new UserManagementForPasswordFrame();
				pa.setVisible(true);
			}
		});
		mntmupdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.CTRL_MASK));
		menuUser.add(mntmupdate);

		JMenuItem mntmquit = new JMenuItem("\u9000\u51FA");
		mntmquit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});

		mntmregister11 = new JMenuItem("\u6CE8\u518C\u7528\u6237");
		mntmregister11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserRegisterAdminFrame useradmin = new UserRegisterAdminFrame();
				useradmin.setVisible(true);
			}
		});
		mntmregister11.setEnabled(false);
		mntmregister11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				InputEvent.CTRL_MASK));
		menuUser.add(mntmregister11);

		menuItem_2 = new JMenuItem("\u5220\u9664\u7528\u6237");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserDeleteFrame userdelete = new UserDeleteFrame();
				userdelete.setVisible(true);
			}
		});
		menuItem_2.setEnabled(false);
		menuUser.add(menuItem_2);
		mntmquit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
				InputEvent.CTRL_MASK));
		menuUser.add(mntmquit);

		JMenu menuflightManagement = new JMenu(
				"\u822A\u73ED\u4FE1\u606F\u7BA1\u7406");
		menuBar.add(menuflightManagement);

		JMenuItem mntmQuery = new JMenuItem(
				"\u67E5\u8BE2\u822A\u73ED\u4FE1\u606F");
		mntmQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightMSGQueryFrame flightquery = new FlightMSGQueryFrame();
				flightquery.setVisible(true);
			}
		});
		mntmQuery.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
				InputEvent.CTRL_MASK));
		mntmQuery.setActionCommand("\u67E5\u8BE2\u822A\u73ED\u4FE1\u606F");
		menuflightManagement.add(mntmQuery);

		mntmUpdate = new JMenuItem("\u4FEE\u6539\u822A\u73ED\u4FE1\u606F");
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightMSGUpdateFrame flightupadate = new FlightMSGUpdateFrame();
				flightupadate.setVisible(true);
			}
		});
		mntmUpdate.setEnabled(false);
		mntmUpdate.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,
				InputEvent.ALT_MASK));
		menuflightManagement.add(mntmUpdate);

		mntmInsert = new JMenuItem("\u6DFB\u52A0\u822A\u73ED\u4FE1\u606F");
		mntmInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightMSGInsertFrame flightinsert = new FlightMSGInsertFrame();
				flightinsert.setVisible(true);
			}
		});
		mntmInsert.setEnabled(false);
		mntmInsert.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I,
				InputEvent.CTRL_MASK));
		menuflightManagement.add(mntmInsert);

		mntmDelete = new JMenuItem("\u5220\u9664\u822A\u73ED\u4FE1\u606F");
		mntmDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FlightMSGDeleteFrame flightdelete = new FlightMSGDeleteFrame();
				flightdelete.setVisible(true);
			}
		});
		mntmDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
				InputEvent.CTRL_MASK));
		mntmDelete.setEnabled(false);
		menuflightManagement.add(mntmDelete);
		
		menu_1 = new JMenu("\u65E5\u5FD7");
		menu_1.setEnabled(false);
		menuBar.add(menu_1);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5173\u4E8E");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LogMessageFrame lf = new LogMessageFrame();
				lf.setVisible(true);
			}
		});
		menuItem_3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		menu_1.add(menuItem_3);

		JMenu menuHelp = new JMenu("\u5E2E\u52A9");
		menuBar.add(menuHelp);

		JMenuItem menuItem = new JMenuItem("\u5173\u4E8E");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HelpFrame help = new HelpFrame();
				help.setVisible(true);
			}
		});
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,
				InputEvent.CTRL_MASK));
		menuHelp.add(menuItem);

		JMenu menu = new JMenu("\u9000\u51FA\u7CFB\u7EDF");
		menuBar.add(menu);

		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA");
		menuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						dispose();
			}
		});
		menu.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
