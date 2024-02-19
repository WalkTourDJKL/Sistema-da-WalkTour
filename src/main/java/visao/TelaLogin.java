package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;

public class TelaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_digiCPF;
	private JTextField txt_digiSenha;

	/**
	 * Create the frame.
	 * 
	 * @param table
	 * @param listaEventos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setTitle("Tela Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1090);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel LadoJanela = new JPanel();
		LadoJanela.setBounds(-2, 0, 1030, 1068);
		contentPane.add(LadoJanela);
		LadoJanela.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-214, 0, 1255, 1057);
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/LadoA.png")));
		LadoJanela.add(lblNewLabel_3);

		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setBounds(1400, 129, 149, 67);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		contentPane.add(lblNewLabel);

		JLabel lbl_CPF = new JLabel("CPF");
		lbl_CPF.setBounds(1192, 165, 422, 31);
		contentPane.add(lbl_CPF);
		lbl_CPF.setForeground(new Color(52, 64, 84));
		lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));

		txt_digiCPF = new JTextField();
		txt_digiCPF.setBounds(1038, 201, 576, 25);
		contentPane.add(txt_digiCPF);
		txt_digiCPF.setToolTipText("Digite seu CPF");
		txt_digiCPF.setForeground(new Color(102, 112, 133));
		txt_digiCPF.setFont(new Font("Corbel", Font.BOLD, 15));
		txt_digiCPF.setText("Digite seu CPF...");
		txt_digiCPF.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(1038, 374, 576, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
			}
		});

		JLabel lbl_senha = new JLabel("Senha");
		lbl_senha.setBounds(1038, 268, 576, 31);
		contentPane.add(lbl_senha);
		lbl_senha.setForeground(new Color(52, 64, 84));
		lbl_senha.setFont(new Font("Corbel", Font.BOLD, 25));

		txt_digiSenha = new JTextField();
		txt_digiSenha.setBounds(1038, 304, 576, 25);
		contentPane.add(txt_digiSenha);
		txt_digiSenha.setToolTipText("Digite sua senha");
		txt_digiSenha.setText("Digite sua senha...");
		txt_digiSenha.setForeground(new Color(102, 112, 133));
		txt_digiSenha.setFont(new Font("Corbel", Font.BOLD, 15));
		txt_digiSenha.setColumns(10);
		btnNewButton.setForeground(new Color(255, 255, 128));
		btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BotaoEntrar.png")));
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? ");
		lblNewLabel_1.setBounds(1192, 444, 109, 18);
		lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("cadastre-se");
		btnNewButton_1.setBounds(1306, 440, 97, 27);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Corbel", Font.ITALIC, 14));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel(
				"Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
		lblNewLabel_2.setBounds(1111, 472, 430, 18);
		lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2);
	}
}
