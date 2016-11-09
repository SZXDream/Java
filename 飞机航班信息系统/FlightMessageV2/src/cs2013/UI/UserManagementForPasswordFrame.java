package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.JobAttributes;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

import cs2013.dao1.IBaseDao;
import cs2013.dao1.UserDaoForDBImp;
import cs2013.entry1.User;
import cs2013.service1.IUserService;
import cs2013.service1.UserServiceImp;
import javax.swing.JPasswordField;

import org.apache.log4j.Logger;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class UserManagementForPasswordFrame extends JFrame {

	private JPanel contentPane;
	IUserService service = null;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JButton btnConfirm2;
	private JTextField txtNam;
	private JLabel lblMsg;
	private static Logger logger = Logger.getLogger(UserManagementForPasswordFrame.class);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagementForPasswordFrame frame = new UserManagementForPasswordFrame();
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
	public UserManagementForPasswordFrame() {
		setTitle("\u7528\u6237\u540E\u53F0\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 248);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblEverPassword = new JLabel("\u539F \u5BC6 \u7801\uFF1A");
		lblEverPassword.setFont(new Font("宋体", Font.PLAIN, 14));
		lblEverPassword.setBounds(30, 60, 75, 25);
		contentPane.add(lblEverPassword);

		JLabel lblNewPassword = new JLabel("\u65B0 \u5BC6 \u7801\uFF1A");
		lblNewPassword.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewPassword.setBounds(30, 114, 75, 25);
		contentPane.add(lblNewPassword);

		JLabel lblConfrimPassword = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblConfrimPassword.setFont(new Font("宋体", Font.PLAIN, 14));
		lblConfrimPassword.setBounds(30, 163, 86, 25);
		contentPane.add(lblConfrimPassword);

		btnConfirm2 = new JButton("\u786E\u5B9A");
		btnConfirm2.setEnabled(false);
		btnConfirm2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					updatepassword();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入正确信息！");
				}
				
			}
		});
		btnConfirm2.setBounds(346, 115, 93, 23);
		contentPane.add(btnConfirm2);

		JButton btnCancel2 = new JButton("\u53D6\u6D88");
		btnCancel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel2.setBounds(346, 164, 93, 23);
		contentPane.add(btnCancel2);

		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					User user = getUser();
					User user1 = (User) service.findById(user.getUser_id());
					if (user.getUser_password().equals(user1.getUser_password())) {
						passwordField_1.setEditable(true);
						passwordField_2.setEditable(true);
						btnConfirm2.setEnabled(true);
						lblMsg.setText("");
					} else {

						lblMsg.setText("用户名与密码不匹配！！");

					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息！");
				}
				
			}
		});

		passwordField.setBounds(127, 62, 141, 21);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.setEditable(false);
		passwordField_1.setBounds(127, 116, 141, 21);
		contentPane.add(passwordField_1);

		passwordField_2 = new JPasswordField();
		passwordField_2.setEditable(false);
		passwordField_2.setBounds(126, 165, 142, 21);
		contentPane.add(passwordField_2);

		lblMsg = new JLabel("");
		lblMsg.setBounds(278, 10, 149, 20);
		contentPane.add(lblMsg);

		JLabel lblId = new JLabel("\u7528 \u6237 ID\uFF1A");
		lblId.setFont(new Font("宋体", Font.PLAIN, 14));
		lblId.setBounds(30, 10, 75, 25);
		contentPane.add(lblId);

		txtNam = new JTextField();
		txtNam.setBounds(127, 12, 141, 21);
		contentPane.add(txtNam);
		txtNam.setColumns(10);

		service = new UserServiceImp();
		IBaseDao dao = new UserDaoForDBImp();

		service.setDao(dao);

	}

	// 获取原密码
	public User getUser() {
		return new User(Integer.parseInt(txtNam.getText()), new String(
				passwordField.getPassword()));
	}

	public User getUser1() {
		return new User(Integer.parseInt(txtNam.getText()), new String(
				passwordField_1.getPassword()));
	}

	// 获取新输入的密码
	public void updatepassword() {
		User user = getUser1();
		try {
			if (service.update(user)) {
				if ((new String(passwordField_1.getPassword())).equals((new String(
						passwordField_2.getPassword())))) {
					logger.info(user.getUser_id() + " update a password");
					JOptionPane.showMessageDialog(null, "密码修改 成 功！");
				} else {
					JOptionPane.showMessageDialog(null, "密码不匹配 ！");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "请输入有效信息！");
		}
	

	}
}
