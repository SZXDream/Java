package cs2013.UI;

import java.awt.BorderLayout;
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

import cs2013.dao1.IBaseDao;
import cs2013.dao1.UserDaoForDBImp;
import cs2013.entry1.User;
import cs2013.service1.IUserService;
import cs2013.service1.UserServiceImp;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JTextArea;

import org.apache.log4j.Logger;

public class UserRegisterFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtUserName;
	IUserService service = null;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private static Logger logger = Logger.getLogger(UserRegisterFrame.class);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegisterFrame frame = new UserRegisterFrame();
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
	public UserRegisterFrame() {
		setTitle("\u7528\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblId = new JLabel("\u7528\u6237ID \uFF1A");
		lblId.setFont(new Font("宋体", Font.PLAIN, 17));
		lblId.setBounds(102, 22, 79, 20);
		contentPane.add(lblId);

		JLabel lblUserName = new JLabel("\u7528 \u6237 \u540D\uFF1A");
		lblUserName.setFont(new Font("宋体", Font.PLAIN, 17));
		lblUserName.setBounds(102, 78, 95, 20);
		contentPane.add(lblUserName);

		JLabel lblPassword = new JLabel("\u5BC6  \u7801\uFF1A");
		lblPassword.setFont(new Font("宋体", Font.PLAIN, 17));
		lblPassword.setBounds(102, 138, 79, 20);
		contentPane.add(lblPassword);

		txtId = new JTextField();
		txtId.setBounds(225, 23, 156, 22);
		contentPane.add(txtId);
		txtId.setColumns(10);

		txtUserName = new JTextField();
		txtUserName.setBounds(225, 79, 156, 22);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);

		JLabel lblConfirmPassword = new JLabel("\u786E\u8BA4\u5BC6\u7801\uFF1A");
		lblConfirmPassword.setFont(new Font("宋体", Font.PLAIN, 17));
		lblConfirmPassword.setBounds(102, 192, 95, 20);
		contentPane.add(lblConfirmPassword);

		JLabel lblMSG = new JLabel("");
		lblMSG.setBounds(402, 78, 194, 19);
		contentPane.add(lblMSG);

		JButton btnConfirm = new JButton("\u786E\u5B9A\u4FE1\u606F");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StringBuffer sb = new StringBuffer();
				sb.append("用户ID　：\t" + txtId.getText());
				sb.append("\t用户名:" + txtUserName.getText());
				sb.append("\n");
				sb.append("密码 ：\t" + new String(passwordField.getPassword()));
				sb.append("\t权限:" + "普通用户");
				sb.append("\n");
				textArea.setText(sb.toString());
			}
		});
		btnConfirm.setFont(new Font("宋体", Font.PLAIN, 17));
		btnConfirm.setBounds(432, 130, 105, 37);
		contentPane.add(btnConfirm);

		JButton btnCancel = new JButton("\u53D6 \u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("宋体", Font.PLAIN, 17));
		btnCancel.setBounds(432, 307, 105, 37);
		contentPane.add(btnCancel);

		JButton btnRegister = new JButton("\u6CE8 \u518C");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					userRegister();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入有效信息！");
				}
				
			}
		});
		btnRegister.setFont(new Font("宋体", Font.PLAIN, 17));
		btnRegister.setBounds(432, 222, 105, 37);
		contentPane.add(btnRegister);

		passwordField = new JPasswordField();
		passwordField.setBounds(225, 139, 156, 21);
		contentPane.add(passwordField);

		passwordField_1 = new JPasswordField();
		passwordField_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				if ((new String(passwordField.getPassword()))
						.equals((new String(passwordField_1.getPassword())))) {
					lblNewLabel.setText("");
				} else {
					lblNewLabel.setText("您输入的两次密码不匹配，请重新输入！");
				}
			}
		});
		passwordField_1.setBounds(225, 193, 156, 21);
		contentPane.add(passwordField_1);

		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(417, 26, 166, 19);
		contentPane.add(lblNewLabel);

		textArea = new JTextArea();
		textArea.setBounds(105, 249, 276, 144);
		contentPane.add(textArea);

		service = new UserServiceImp();
		IBaseDao dao = new UserDaoForDBImp();

		service.setDao(dao);
	}

	public User getUser() {
		return new User(Integer.parseInt(txtId.getText()),
				txtUserName.getText(), new String(passwordField.getPassword()),
				"普通用户");

	}

	public void userRegister() {
		User user = getUser();
		if (service.register(user)) {
			logger.info(user.getUser_id() + " join us!(Public)");
			JOptionPane.showMessageDialog(null, "添 加 成 功！");

		} else {
			JOptionPane.showMessageDialog(null, "添 加 失败！");
		}
	}
}
