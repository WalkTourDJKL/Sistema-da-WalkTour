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
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{1033, 149, 78, 308, 0};
		gbl_contentPane.rowHeights = new int[]{196, 25, 37, 31, 25, 40, 61, 27, 383, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
						JPanel LadoJanela = new JPanel();
						GridBagConstraints gbc_LadoJanela = new GridBagConstraints();
						gbc_LadoJanela.fill = GridBagConstraints.BOTH;
						gbc_LadoJanela.insets = new Insets(0, 0, 0, 5);
						gbc_LadoJanela.gridheight = 9;
						gbc_LadoJanela.gridx = 0;
						gbc_LadoJanela.gridy = 0;
						contentPane.add(LadoJanela, gbc_LadoJanela);
						LadoJanela.setLayout(null);
						
								JLabel lblNewLabel_3 = new JLabel("");
								lblNewLabel_3.setBounds(-257, 0, 1309, 895);
								lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/LadoA.png")));
								LadoJanela.add(lblNewLabel_3);
								
										JLabel lblNewLabel = new JLabel("Entrar");
										lblNewLabel.setBackground(new Color(255, 255, 255));
										lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
										GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
										gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
										gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
										gbc_lblNewLabel.gridx = 1;
										gbc_lblNewLabel.gridy = 0;
										contentPane.add(lblNewLabel, gbc_lblNewLabel);
						
								JLabel lbl_CPF = new JLabel("CPF");
								GridBagConstraints gbc_lbl_CPF = new GridBagConstraints();
								gbc_lbl_CPF.anchor = GridBagConstraints.SOUTH;
								gbc_lbl_CPF.fill = GridBagConstraints.HORIZONTAL;
								gbc_lbl_CPF.insets = new Insets(0, 0, 5, 0);
								gbc_lbl_CPF.gridwidth = 2;
								gbc_lbl_CPF.gridx = 2;
								gbc_lbl_CPF.gridy = 0;
								contentPane.add(lbl_CPF, gbc_lbl_CPF);
								lbl_CPF.setForeground(new Color(52, 64, 84));
								lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));
				
						txt_digiCPF = new JTextField();
						GridBagConstraints gbc_txt_digiCPF = new GridBagConstraints();
						gbc_txt_digiCPF.fill = GridBagConstraints.BOTH;
						gbc_txt_digiCPF.insets = new Insets(0, 0, 5, 0);
						gbc_txt_digiCPF.gridwidth = 3;
						gbc_txt_digiCPF.gridx = 1;
						gbc_txt_digiCPF.gridy = 1;
						contentPane.add(txt_digiCPF, gbc_txt_digiCPF);
						txt_digiCPF.setToolTipText("Digite seu CPF");
						txt_digiCPF.setForeground(new Color(102, 112, 133));
						txt_digiCPF.setFont(new Font("Corbel", Font.BOLD, 15));
						txt_digiCPF.setText("Digite seu CPF...");
						txt_digiCPF.setColumns(10);
				
						JButton btnNewButton = new JButton("");
						btnNewButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								HomePage homePage = new HomePage();
								homePage.setVisible(true);
							}
						});
						
								JLabel lbl_senha = new JLabel("Senha");
								GridBagConstraints gbc_lbl_senha = new GridBagConstraints();
								gbc_lbl_senha.fill = GridBagConstraints.BOTH;
								gbc_lbl_senha.insets = new Insets(0, 0, 5, 0);
								gbc_lbl_senha.gridwidth = 3;
								gbc_lbl_senha.gridx = 1;
								gbc_lbl_senha.gridy = 3;
								contentPane.add(lbl_senha, gbc_lbl_senha);
								lbl_senha.setForeground(new Color(52, 64, 84));
								lbl_senha.setFont(new Font("Corbel", Font.BOLD, 25));
						
								txt_digiSenha = new JTextField();
								GridBagConstraints gbc_txt_digiSenha = new GridBagConstraints();
								gbc_txt_digiSenha.fill = GridBagConstraints.BOTH;
								gbc_txt_digiSenha.insets = new Insets(0, 0, 5, 0);
								gbc_txt_digiSenha.gridwidth = 3;
								gbc_txt_digiSenha.gridx = 1;
								gbc_txt_digiSenha.gridy = 4;
								contentPane.add(txt_digiSenha, gbc_txt_digiSenha);
								txt_digiSenha.setToolTipText("Digite sua senha");
								txt_digiSenha.setText("Digite sua senha...");
								txt_digiSenha.setForeground(new Color(102, 112, 133));
								txt_digiSenha.setFont(new Font("Corbel", Font.BOLD, 15));
								txt_digiSenha.setColumns(10);
						btnNewButton.setForeground(new Color(255, 255, 128));
						btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/BotaoEntrar.png")));
						btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
						GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
						gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
						gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
						gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
						gbc_btnNewButton.gridwidth = 3;
						gbc_btnNewButton.gridx = 1;
						gbc_btnNewButton.gridy = 6;
						contentPane.add(btnNewButton, gbc_btnNewButton);
				
						JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? ");
						lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
						GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
						gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
						gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
						gbc_lblNewLabel_1.gridx = 2;
						gbc_lblNewLabel_1.gridy = 7;
						contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
				
				JButton btnNewButton_1 = new JButton("cadastre-se");
				btnNewButton_1.setForeground(Color.BLACK);
				btnNewButton_1.setFont(new Font("Corbel", Font.ITALIC, 14));
				btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
				GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
				gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
				gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewButton_1.gridx = 3;
				gbc_btnNewButton_1.gridy = 7;
				contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
				JLabel lblNewLabel_2 = new JLabel(
						"Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
				lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.NORTH;
				gbc_lblNewLabel_2.gridwidth = 3;
				gbc_lblNewLabel_2.gridx = 1;
				gbc_lblNewLabel_2.gridy = 8;
				contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
	}
}
