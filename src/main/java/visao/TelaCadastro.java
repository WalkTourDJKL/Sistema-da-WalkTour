package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import modelo.Hospedes;
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
		txtDigiteSeuNomeSocial.setToolTipText("Digite seu Nome Social se você tiver");
		txtDigiteSeuNomeSocial.setForeground(new Color(102, 112, 133));
		txtDigiteSeuNomeSocial.setFont(new Font("Corbel", Font.ITALIC, 15));
		txtDigiteSeuNomeSocial.setColumns(10);
		txtDigiteSeuNomeSocial.setBounds(10, 284, 458, 35);
		contentPane.add(txtDigiteSeuNomeSocial);

		JLabel lbl_nomeSC = new JLabel("Nome Social");
		lbl_nomeSC.setForeground(new Color(52, 64, 84));
		lbl_nomeSC.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_nomeSC.setBounds(10, 244, 515, 50);
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
		lbl_DNasc.setBounds(10, 384, 500, 50);
		contentPane.add(lbl_DNasc);

		JLabel lbl_CPF = new JLabel("CPF");
		lbl_CPF.setForeground(new Color(52, 64, 84));
		lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 35));
		lbl_CPF.setBounds(10, 531, 100, 50);
		contentPane.add(lbl_CPF);

		try {
			MaskFormatter formatterCPF = new MaskFormatter("###.###.###-##");
			formatterCPF.setPlaceholder("_");
			formattedTextFieldCPF = new JFormattedTextField(formatterCPF);
			formattedTextFieldCPF.setToolTipText("Digite seu CPF...");
			formattedTextFieldCPF.setForeground(new Color(102, 112, 133));
			formattedTextFieldCPF.setFont(new Font("Corbel", Font.ITALIC, 15));
			formattedTextFieldCPF.setBounds(10, 564, 458, 35);
			contentPane.add(formattedTextFieldCPF);
		} catch (Exception e) {
			e.printStackTrace();
		}
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = txtDigiteSeuNome.getText();
				String nomeSc = txtDigiteSeuNomeSocial.getText();
				String cpf = formattedTextFieldCPF.getText();
				String dataNascimento = formattedTextFieldDataNascimento.getText();

				if (nome.isEmpty() || cpf.isEmpty() || dataNascimento.isEmpty()) {
					TelaErro erro = new TelaErro();
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				} else {

					Hospedes end = new Hospedes();

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
			MaskFormatter formatter = new MaskFormatter("####-##-##");
			formatter.setPlaceholderCharacter('_'); // Define um caractere de espaço reservado
			formattedTextFieldDataNascimento = new JFormattedTextField(formatter);
			formattedTextFieldDataNascimento.setBounds(10, 424, 458, 35); // Ajuste conforme necessário
			contentPane.add(formattedTextFieldDataNascimento);

			JLabel lblNewLabel_1 = new JLabel("Ja tem Cadastro?");
			lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
			lblNewLabel_1.setBounds(131, 765, 120, 14);
			contentPane.add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel(
					"Ao continuar com o acesso, voce concorda com nossa politica de privacidade ");
			lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
			lblNewLabel_2.setBounds(26, 785, 480, 40);
			contentPane.add(lblNewLabel_2);

			JButton btnNewButton = new JButton("Faça Login");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}