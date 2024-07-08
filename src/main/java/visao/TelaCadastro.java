package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.Usuarios;
import controle.UsuariosDAO;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TelaCadastro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDigiteSeuNomeSocial;
	private JTextField txtDigiteSeuNome;
	private JTextField txtDigitDtNasc;
	private JFormattedTextField formattedTextFieldCPF;
	private JTextField txtSenha;
	private JTextField txtLogin;

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
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
					/* Não deixa ser redimensionado a tela */
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		setTitle("Tela Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setForeground(new Color(52, 64, 84));
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(150, 41, 264, 67);
		contentPane.add(lblNewLabel);

		JLabel lbl_Nome = new JLabel("Nome Completo");
		lbl_Nome.setForeground(new Color(52, 64, 84));
		lbl_Nome.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_Nome.setBounds(10, 104, 515, 50);
		contentPane.add(lbl_Nome);

		txtDigiteSeuNomeSocial = new JTextField();
		txtDigiteSeuNomeSocial.setToolTipText("Digite seu Nome Social se voce tiver");
		txtDigiteSeuNomeSocial.setForeground(new Color(102, 112, 133));
		txtDigiteSeuNomeSocial.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuNomeSocial.setColumns(10);
		txtDigiteSeuNomeSocial.setBounds(10, 230, 458, 35);
		contentPane.add(txtDigiteSeuNomeSocial);

		JLabel lbl_nomeSC = new JLabel("Nome Social");
		lbl_nomeSC.setForeground(new Color(52, 64, 84));
		lbl_nomeSC.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_nomeSC.setBounds(10, 190, 515, 50);
		contentPane.add(lbl_nomeSC);

		txtDigiteSeuNome = new JTextField();
		txtDigiteSeuNome.setToolTipText("Digite seu Nome");
		txtDigiteSeuNome.setForeground(new Color(102, 112, 133));
		txtDigiteSeuNome.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuNome.setColumns(10);
		txtDigiteSeuNome.setBounds(10, 144, 458, 35);
		contentPane.add(txtDigiteSeuNome);

		JLabel lbl_DNasc = new JLabel("Data de Nascimento");
		lbl_DNasc.setForeground(new Color(52, 64, 84));
		lbl_DNasc.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_DNasc.setBounds(10, 276, 500, 50);
		contentPane.add(lbl_DNasc);
		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			txtDigitDtNasc = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtDigitDtNasc.setBounds(10, 321, 458, 35);
		txtDigitDtNasc.setFont(new Font("Corbel", Font.BOLD, 15));
		contentPane.add(txtDigitDtNasc);
		txtDigitDtNasc.setColumns(10);

		JLabel lbl_CPF = new JLabel("CPF");
		lbl_CPF.setForeground(new Color(52, 64, 84));
		lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_CPF.setBounds(10, 362, 100, 50);
		contentPane.add(lbl_CPF);

		try {
			MaskFormatter formatterCPF = new MaskFormatter("###.###.###-##");
			formatterCPF.setPlaceholder("_");
			formattedTextFieldCPF = new JFormattedTextField(formatterCPF);
			formattedTextFieldCPF.setToolTipText("Digite seu CPF...");
			formattedTextFieldCPF.setForeground(new Color(102, 112, 133));
			formattedTextFieldCPF.setFont(new Font("Corbel", Font.ITALIC, 15));
			formattedTextFieldCPF.setBounds(10, 395, 458, 35);
			contentPane.add(formattedTextFieldCPF);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

				String nome = txtDigiteSeuNome.getText();
				String nomeSc = txtDigiteSeuNomeSocial.getText();
				String cpf = formattedTextFieldCPF.getText();
				String dataNascimento = txtDigitDtNasc.getText();
				String login = txtLogin.getText();
				String senha = txtSenha.getText();
				int tipo = 0;

				if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
					TelaErro erro = new TelaErro();
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {

					Usuarios end = new Usuarios();
					if (dataNascimento.length() == 0) {
						JOptionPane.showMessageDialog(null, "Campo Data de Entrada obrigatório!");
						return;
					}
					if (validacaoData(dataNascimento) == false) {
						JOptionPane.showMessageDialog(null, "Data de nascimetno inválida.");
						return;
					}
					

					MaskFormatter mascaradataI = null;
					try {
						mascaradataI = new MaskFormatter("##/##/####");
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					txtDigitDtNasc = new JFormattedTextField(mascaradataI);
					contentPane.add(txtDigitDtNasc);
					txtDigitDtNasc.setColumns(10);

					LocalDate dtnsc = LocalDate.parse(dataNascimento, formatter);
					
					end.setNome(nome);
					end.setNomeSocial(nomeSc);
					end.setDtNasc(dtnsc);
					end.setCpf(cpf);
					end.setLogin(login);
					end.setSenha(senha);
					end.setTipoUser(0);

					UsuariosDAO dao = UsuariosDAO.getInstancia();

					int retorno = dao.inserirUsuarios(end);

					if (retorno == 0) {
						TelaErro erro = new TelaErro();
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
					} else {
						TelaSucesso sucesso = new TelaSucesso();
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);
						TelaLogin telalogin = new TelaLogin();
						dispose();
						telalogin.setResizable(false);
						telalogin.setVisible(true);
					}

				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/btnCadastrar.png")));
		btnNewButton_1.setForeground(new Color(255, 255, 128));
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNewButton_1.setBounds(26, 666, 486, 61);
		contentPane.add(btnNewButton_1);

		try {

			JLabel lblNewLabel_1 = new JLabel("Ja tem Cadastro?");
			lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
			lblNewLabel_1.setBounds(131, 765, 120, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel(
					"Ao continuar com o acesso, voce concorda com nossa politica de privacidade ");
			lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
			lblNewLabel_2.setBounds(26, 785, 480, 40);
			contentPane.add(lblNewLabel_2);

			JButton btnNewButton = new JButton("Faca Login");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					TelaLogin log = new TelaLogin();
					dispose();
					log.setResizable(false);
					log.setVisible(true);
				}
			});
			btnNewButton.setBounds(253, 759, 110, 23);
			contentPane.add(btnNewButton);

			JPanel LadoJanela = new JPanel();
			LadoJanela.setBounds(446, 0, 1354, 1054);
			contentPane.add(LadoJanela);
			LadoJanela.setLayout(null);

			JLabel lblNewLabel_3 = new JLabel("");
			lblNewLabel_3.setBounds(-82, -99, 1126, 1080);
			LadoJanela.add(lblNewLabel_3);
			lblNewLabel_3.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LadoB.png")));

			txtSenha = new JTextField();
			txtSenha.setToolTipText("Digite sua Senha");
			txtSenha.setForeground(new Color(102, 112, 133));
			txtSenha.setFont(new Font("Corbel", Font.ITALIC, 15));
			txtSenha.setColumns(10);
			txtSenha.setBounds(10, 567, 458, 35);
			contentPane.add(txtSenha);

			JLabel lbl_nomeSC_1 = new JLabel("Senha");
			lbl_nomeSC_1.setForeground(new Color(52, 64, 84));
			lbl_nomeSC_1.setFont(new Font("Corbel", Font.BOLD, 35));
			lbl_nomeSC_1.setBounds(10, 527, 515, 50);
			contentPane.add(lbl_nomeSC_1);

			txtLogin = new JTextField();
			txtLogin.setToolTipText("Digite seu Login");
			txtLogin.setForeground(new Color(102, 112, 133));
			txtLogin.setFont(new Font("Corbel", Font.ITALIC, 15));
			txtLogin.setColumns(10);
			txtLogin.setBounds(10, 481, 458, 35);
			contentPane.add(txtLogin);

			JLabel lbl_Nome_1 = new JLabel("Login");
			lbl_Nome_1.setForeground(new Color(52, 64, 84));
			lbl_Nome_1.setFont(new Font("Corbel", Font.BOLD, 35));
			lbl_Nome_1.setBounds(10, 441, 515, 50);
			contentPane.add(lbl_Nome_1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Boolean validacaoData(String strDate) {
	    String dateFormat = "dd/MM/uuuu";

	    DateTimeFormatter dateTimeFormatter = DateTimeFormatter
	    .ofPattern(dateFormat)
	    .withResolverStyle(ResolverStyle.STRICT);
	    try {
	        LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
	        return true;
	    } catch (DateTimeParseException e) {
	       return false;
	    } 
	}
}
