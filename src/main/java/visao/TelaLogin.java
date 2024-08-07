package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.UsuariosDAO;
import modelo.Usuarios;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class TelaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txt_digiLogin;
	private JTextField txt_digiSenha;
	private UsuariosDAO hospdao = UsuariosDAO.getInstancia();
	private MaskFormatter formatterCPF;

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
					frame.setLocationRelativeTo(null);
					controle.CriacaoDB.main(args);
					/* Não deixa ser redimensionado a tela */
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLogin.class.getResource("/imgs/Icon2.png")));
		setTitle("WalkTour - Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Entrar");
		lblNewLabel.setForeground(new Color(52, 64, 84));
		lblNewLabel.setBounds(1118, 51, 149, 67);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		contentPane.add(lblNewLabel);

		JLabel lbl_Login = new JLabel("Login");
		lbl_Login.setBounds(950, 158, 464, 50);
		contentPane.add(lbl_Login);
		lbl_Login.setForeground(new Color(52, 64, 84));
		lbl_Login.setFont(new Font("Corbel", Font.BOLD, 35));

		txt_digiLogin = new JTextField();
		txt_digiLogin.setText("");
		txt_digiLogin.setBounds(950, 203, 464, 35);
		contentPane.add(txt_digiLogin);
		txt_digiLogin.setToolTipText("Digite seu login");
		txt_digiLogin.setForeground(new Color(102, 112, 133));
		txt_digiLogin.setFont(new Font("Corbel", Font.ITALIC, 15));
		txt_digiLogin.setColumns(10);

		JLabel lbl_cpf = new JLabel("Senha");
		lbl_cpf.setBounds(950, 283, 464, 50);
		contentPane.add(lbl_cpf);
		lbl_cpf.setForeground(new Color(52, 64, 84));
		lbl_cpf.setFont(new Font("Corbel", Font.BOLD, 35));

		txt_digiSenha = new JTextField();
		txt_digiSenha.setText("");
		txt_digiSenha.setBounds(950, 328, 464, 35);
		contentPane.add(txt_digiSenha);
		txt_digiSenha.setToolTipText("Digite sua senha");
		txt_digiSenha.setForeground(new Color(102, 112, 133));
		txt_digiSenha.setFont(new Font("Corbel", Font.ITALIC, 15));
		txt_digiSenha.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(909, 611, 515, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Login = txt_digiLogin.getText();

				String senha = txt_digiSenha.getText();

				if (senha.isEmpty() || Login.isEmpty()) {
					txt_digiLogin.setText(null);
					txt_digiSenha.setText(null);
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);

				} else {
					// Cria obj Hóspede para atribuir login e senha
					Usuarios testelogin = new Usuarios();
					testelogin.setLogin(Login);
					testelogin.setSenha(senha);
					;

					// Cria uma variavel boolean login1 que verifica se há o usuário no banco
					Usuarios hospTesteLogin = hospdao.login(testelogin);

					// Se o valor retornado pela função ser true
					if (hospTesteLogin != null) {
						// Passa para a proxima tela
						
						dispose();
						TelaPrincipal homepage = new TelaPrincipal(hospTesteLogin);
						homepage.setLocationRelativeTo(null);
						homepage.setResizable(false);
						homepage.setVisible(true);
						TelaSucesso sucesso = new TelaSucesso();
						sucesso.setResizable(false);
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);

					} else {
						TelaErro erro = new TelaErro();
						erro.setResizable(false);
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
					}

				}

			}
		});

		btnNewButton.setForeground(new Color(255, 255, 128));
		btnNewButton.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/btnEntrar.png")));
		btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("Nao tem cadastro? ");
		lblNewLabel_1.setBounds(1075, 525, 109, 18);
		lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_1);

		JButton btnNewButton_1 = new JButton("cadastre-se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro cad = new TelaCadastro();
				dispose();
				cad.setLocationRelativeTo(null);
				cad.setResizable(false);
				cad.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(1196, 521, 120, 25);
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Corbel", Font.ITALIC, 14));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		contentPane.add(btnNewButton_1);

		JLabel lblNewLabel_2 = new JLabel(
				"Ao continuar com o acesso, voce concorda com nossa politica de privacidade ");
		lblNewLabel_2.setBounds(984, 570, 430, 18);
		lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
		contentPane.add(lblNewLabel_2);

		JPanel LadoJanela = new JPanel();
		LadoJanela.setBounds(0, 0, 1033, 1051);
		contentPane.add(LadoJanela);
		LadoJanela.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-254, -74, 1309, 1051);
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/imgs/LadoA.png")));
		LadoJanela.add(lblNewLabel_3);

	}

	public MaskFormatter getFormatterCPF() {
		return formatterCPF;
	}

	public void setFormatterCPF(MaskFormatter formatterCPF) {
		this.formatterCPF = formatterCPF;
	}
}
