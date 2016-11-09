package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

import cs2013.dao1.IBaseDao;
import cs2013.dao1.UserDaoForDBImp;
import cs2013.entry1.User;
import cs2013.service1.IUserService;
import cs2013.service1.UserServiceImp;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Window.Type;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JComboBox combauthority;
//	private String items[] = new String[] { "管理员", "普通用户" };
	IUserService service = null;
	private User user = null;
	JPasswordField password;

	//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setForeground(new Color(0, 255, 255));
		setFont(new Font("Dialog", Font.PLAIN, 17));
		setTitle("\u7528\u6237\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 464);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lblName.setFont(new Font("宋体", Font.PLAIN, 17));
		lblName.setBounds(141, 91, 97, 17);
		contentPane.add(lblName);

		txtID = new JTextField();
		txtID.setBounds(253, 91, 152, 25);
		contentPane.add(txtID);
		txtID.setColumns(10);

		JLabel lblPassword = new JLabel("\u5BC6  \u7801: ");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBackground(Color.LIGHT_GRAY);
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 17));
		lblPassword.setBounds(141, 162, 71, 21);
		contentPane.add(lblPassword);

		JLabel lblauthority = new JLabel("\u6743  \u9650\uFF1A");
		lblauthority.setFont(new Font("宋体", Font.PLAIN, 17));
		lblauthority.setBounds(141, 219, 71, 27);
		contentPane.add(lblauthority);

		combauthority = new JComboBox();
		combauthority.setModel(new DefaultComboBoxModel(new String[] {
				"\u7BA1\u7406\u5458", "\u666E\u901A\u7528\u6237" }));
		combauthority.setBounds(253, 223, 152, 21);
		contentPane.add(combauthority);

		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					login();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息");
				}
				
			}
		});
		btnLogin.setBounds(145, 292, 93, 23);
		contentPane.add(btnLogin);

		JButton btnregister = new JButton("\u6CE8\u518C");
		btnregister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				regsters();
			}
		});
		btnregister.setBounds(296, 292, 93, 23);
		contentPane.add(btnregister);

		password = new JPasswordField();
		password.setBounds(253, 163, 152, 21);
		contentPane.add(password);

		ImageIcon image = new ImageIcon("./src/img2.jpg");
		JLabel lblimg = new JLabel(image);
		lblimg.setBounds(40, 10, 500, 60);
		contentPane.add(lblimg);

		// //背景图片

		service = new UserServiceImp();
		IBaseDao dao = new UserDaoForDBImp();

		service.setDao(dao);
	}

	public String getUserName() {
		return txtID.getText();
	}

	public void setUserName() {
		txtID.setText(""); // 清除用户的输入
	}

	public String getPassword() {
		char[] pwd = password.getPassword();
		return new String(pwd);

	}

	public User getUser() {
		return new User(Integer.parseInt(txtID.getText()), new String(
				password.getPassword()), combauthority.getSelectedItem()
				.toString());
	}

	// 登录
	public void login() {
		user = getUser();
		if (service.login(user)) {

			SelectFrame se = new SelectFrame();
			se.setVisible(true);
			if (user.getUser_authority().equals("管理员")) {
				se.mntmDelete.setEnabled(true);
				se.mntmInsert.setEnabled(true);
				se.mntmUpdate.setEnabled(true);
				se.mntmregister11.setEnabled(true);
				se.menuItem_2.setEnabled(true);
				se.menu_1.setEnabled(true);
				JOptionPane.showMessageDialog(null, user.getUser_id()
						+ "   欢迎来到飞机航班信息管理系统！   ");
			} else {
				JOptionPane.showMessageDialog(null, user.getUser_id()
						+ "   欢迎来到飞机航班信息管理系统！   ");
			}

		} else {
			JOptionPane.showMessageDialog(null, "用户名或口令错误或权限选择错误，请重新输入！");
		}
	}

	public void regsters() {
		UserRegisterFrame ur = new UserRegisterFrame();
		ur.setVisible(true);
	}
}
