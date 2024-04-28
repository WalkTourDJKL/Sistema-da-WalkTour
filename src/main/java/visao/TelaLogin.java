package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.HospedesDAO;
import modelo.Hospedes;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.sound.midi.SysexMessage;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.text.ParseException;
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
	private JTextField txt_digiNome;
	private JTextField txt_digiCPF;
	private HospedesDAO hospdao = HospedesDAO.getInstancia();
	private MaskFormatter formatterCPF;
	private JFormattedTextField formattedTextFieldCPF;

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
					/* Não deixa ser redimensionado a tela */
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setTitle("Tela Login");
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

		JLabel lbl_nome = new JLabel("Nome");
		lbl_nome.setBounds(950, 158, 464, 50);
		contentPane.add(lbl_nome);
		lbl_nome.setForeground(new Color(52, 64, 84));
		lbl_nome.setFont(new Font("Corbel", Font.BOLD, 35));

		txt_digiNome = new JTextField();
		txt_digiNome.setBounds(950, 203, 464, 35);
		contentPane.add(txt_digiNome);
		txt_digiNome.setToolTipText("Digite seu Nome");
		txt_digiNome.setForeground(new Color(102, 112, 133));
		txt_digiNome.setFont(new Font("Corbel", Font.ITALIC, 15));
		txt_digiNome.setColumns(10);

		JLabel lbl_cpf = new JLabel("CPF");
		lbl_cpf.setBounds(950, 283, 464, 50);
		contentPane.add(lbl_cpf);
		lbl_cpf.setForeground(new Color(52, 64, 84));
		lbl_cpf.setFont(new Font("Corbel", Font.BOLD, 35));

		try {
			MaskFormatter formatterCPF = new MaskFormatter("###.###.###-##");
			formattedTextFieldCPF = new JFormattedTextField(formatterCPF);
			formattedTextFieldCPF.setToolTipText("Digite seu CPF...");
			formattedTextFieldCPF.setForeground(new Color(102, 112, 133));
			formattedTextFieldCPF.setFont(new Font("Corbel", Font.ITALIC, 15));
			formattedTextFieldCPF.setBounds(950, 328, 464, 35);
			contentPane.add(formattedTextFieldCPF);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnNewButton = new JButton("");
		btnNewButton.setBounds(909, 611, 515, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String nome = txt_digiNome.getText();

				String cpf = formattedTextFieldCPF.getText();

				if (cpf.isEmpty() || nome.isEmpty()) {
					txt_digiNome.setText(null);
					formattedTextFieldCPF.setText(null);
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);

				} else {
					// Cria obj Hóspede para atribuir login e senha
					Hospedes testelogin = new Hospedes();
					testelogin.setNome(nome);
					testelogin.setNomeSocial(nome);
					testelogin.setCpf(cpf);
					;

					// Cria uma variavel boolean login1 que verifica se há o usuário no banco
					Hospedes hospTesteLogin = hospdao.login(testelogin);

					// Se o valor retornado pela função ser true
					if (hospTesteLogin != null) {
						// Passa para a proxima tela
						TelaSucesso sucesso = new TelaSucesso();
						TelaPrincipal homepage = new TelaPrincipal(hospTesteLogin);
						sucesso.setResizable(false);
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);
						dispose();
						homepage.setResizable(false);
						homepage.setVisible(true);

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
