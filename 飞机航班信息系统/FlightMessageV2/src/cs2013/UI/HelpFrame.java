package cs2013.UI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class HelpFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelpFrame frame = new HelpFrame();
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
	public HelpFrame() {
		setBackground(SystemColor.textText);
		setTitle("\u5E2E\u52A9");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBackground(SystemColor.text);
		textArea.setForeground(SystemColor.controlDkShadow);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		textArea.setText("1.\u672C\u7CFB\u7EDF\u53EA\u6709\u7BA1\u7406\u5458\u624D\u6709\u6DFB\u52A0\u3001\u4FEE\u6539\u3001\u66F4\u65B0\r\n  \u822A\u73ED\u4FE1\u606F\uFF1B\r\n2.\u7BA1\u7406\u5458\u5177\u5907\u6DFB\u52A0\u6DFB\u52A0\u666E\u901A\u7528\u6237\u548C\u7BA1\u7406\u5458\u7528\u6237\r\n  \u7684\u6743\u5229\uFF1B\r\n3.\u66F4\u65B0\u822A\u73ED\u4FE1\u606F\u9700\u8981\u8F93\u5165\u98DE\u673A\u7684ID\uFF08ps:\u6839\u636E\r\n \u98DE\u673AID\u8FDB\u884C\u5404\u79CD\u4FEE\u6539\uFF09\uFF1B\r\n4.\u586B\u5199\u5404\u79CD\u4FE1\u606F\u662F\u4E0D\u5F97\u4E3A\u7A7A\uFF0C\u5982\u8DF3\u51FA\u63D0\u9192\u4FE1\u606F\r\n  \u8BF7\u6839\u636E\u63D0\u793A\u4FE1\u606F\u8FDB\u884C\u64CD\u4F5C\uFF1B");
		textArea.setBounds(0, 0, 434, 261);
		contentPane.add(textArea);
	}

}
