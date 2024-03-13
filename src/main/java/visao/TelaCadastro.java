package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.hospedes;
import controle.HospedesDAO;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Date;
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
	private JTextField txtDigiteSeuCpf;
	private JFormattedTextField formattedTextFieldDataNascimento;

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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		setTitle("Tela Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1090);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel LadoJanela = new JPanel();
		LadoJanela.setBounds(568, 0, 1036, 881);
		contentPane.add(LadoJanela);
		LadoJanela.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-58, 0, 1309, 895);
		LadoJanela.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LadoB.png")));

		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(193, 21, 264, 67);
		contentPane.add(lblNewLabel);

		JLabel lbl_Nome = new JLabel("Nome Completo");
		lbl_Nome.setForeground(new Color(52, 64, 84));
		lbl_Nome.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_Nome.setBounds(53, 97, 515, 25);
		contentPane.add(lbl_Nome);

		txtDigiteSeuNomeSocial = new JTextField();
		txtDigiteSeuNomeSocial.setText("Não possui");
		txtDigiteSeuNomeSocial.setToolTipText("Digite seu Nome Social");
		txtDigiteSeuNomeSocial.setForeground(new Color(102, 112, 133));
		txtDigiteSeuNomeSocial.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuNomeSocial.setColumns(10);
		txtDigiteSeuNomeSocial.setBounds(53, 187, 515, 31);
		contentPane.add(txtDigiteSeuNomeSocial);

		JLabel lbl_nomeSC = new JLabel("Nome Social");
		lbl_nomeSC.setForeground(new Color(52, 64, 84));
		lbl_nomeSC.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_nomeSC.setBounds(53, 163, 515, 25);
		contentPane.add(lbl_nomeSC);

		txtDigiteSeuNome = new JTextField();
		txtDigiteSeuNome.setToolTipText("Digite seu Nome");
		txtDigiteSeuNome.setForeground(new Color(102, 112, 133));
		txtDigiteSeuNome.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuNome.setColumns(10);
		txtDigiteSeuNome.setBounds(53, 121, 515, 31);
		contentPane.add(txtDigiteSeuNome);

		JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? cadastre-se");
		lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(220, 980, 251, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
		lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
		lblNewLabel_2.setBounds(95, 1000, 480, 40);
		contentPane.add(lblNewLabel_2);

		JLabel lbl_DNasc = new JLabel("Data de Nascimento");
		lbl_DNasc.setForeground(new Color(52, 64, 84));
		lbl_DNasc.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_DNasc.setBounds(53, 230, 251, 30);
		contentPane.add(lbl_DNasc);

		JLabel lbl_CPF = new JLabel("CPF");
		lbl_CPF.setForeground(new Color(52, 64, 84));
		lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_CPF.setBounds(53, 294, 60, 30);
		contentPane.add(lbl_CPF);

		txtDigiteSeuCpf = new JTextField();
		txtDigiteSeuCpf.setToolTipText("Digite seu CPF...");
		txtDigiteSeuCpf.setForeground(new Color(102, 112, 133));
		txtDigiteSeuCpf.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuCpf.setBounds(53, 323, 515, 31);
		contentPane.add(txtDigiteSeuCpf);
		txtDigiteSeuCpf.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtDigiteSeuNome.getText();
				String nomeSc = txtDigiteSeuNomeSocial.getText();
				String cpf = txtDigiteSeuCpf.getText();
				String dataNascimento = formattedTextFieldDataNascimento.getText();

				if (nome.isEmpty() || nomeSc.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
					TelaErro erro = new TelaErro();
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {

					hospedes end = new hospedes();

					end.setNome(nome);
					end.setNomeSocial(nomeSc);
					end.setCpf(cpf);

					try {
						SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date dataFormatadaUtil = formatador.parse(dataNascimento);
						java.sql.Date dataFormatadaSql = new java.sql.Date(dataFormatadaUtil.getTime());
						end.setDtNasc(dataFormatadaSql);
					} catch (ParseException ex) {
						ex.printStackTrace();
					}

					HospedesDAO dao = HospedesDAO.getInstancia();

					int retorno = dao.inserirHopesdes(end);

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
						telalogin.setExtendedState(MAXIMIZED_BOTH);
						telalogin.setVisible(true);
					}

				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BotaoCadastrar.png")));
		btnNewButton_1.setForeground(new Color(255, 255, 128));
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnNewButton_1.setBounds(53, 809, 486, 61);
		contentPane.add(btnNewButton_1);

		try {
			MaskFormatter formatter = new MaskFormatter("####-##-##");
			formatter.setPlaceholderCharacter('_'); // Define um caractere de espaço reservado
			formattedTextFieldDataNascimento = new JFormattedTextField(formatter);
			formattedTextFieldDataNascimento.setBounds(53, 258, 515, 31); // Ajuste conforme necessário
			contentPane.add(formattedTextFieldDataNascimento);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
