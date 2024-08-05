package visao;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import controle.DetaHospDAO;
import controle.ReservaDAO;
import modelo.DetalhesHospedagem;
import modelo.Usuarios;
import modelo.Reserva;

public class TelaFinalizar extends JFrame {

	private JPanel contentPane1;
	private JFormattedTextField txt_digiDataF;
	private JFormattedTextField txt_digiDataI;
	private static final long serialVersionUID = 1L;

	public TelaFinalizar(String tipo, Usuarios hosp, String cidade, String preco, String estado) {
		setTitle("Tela de finalizar reserva");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane1 = new JPanel();
		contentPane1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaQuarto telaQuarto = new TelaQuarto(tipo, hosp, cidade, estado);
				dispose();
				telaQuarto.setLocationRelativeTo(null);
				telaQuarto.setResizable(false);
				telaQuarto.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setBounds(983, 108, 90, 25);
		contentPane1.add(btnVoltar);

		JLabel lblR = new JLabel("R$" + preco + ".00");
		lblR.setHorizontalAlignment(SwingConstants.LEFT);
		lblR.setFont(new Font("Arial", Font.BOLD, 37));
		lblR.setBounds(983, 385, 473, 38);
		contentPane1.add(lblR);

		JLabel lblNewLabel = new JLabel("Finalizar Reserva");
		lblNewLabel.setBounds(983, 47, 402, 67);
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		contentPane1.add(lblNewLabel);

		JLabel lbl_dataI = new JLabel("Data de início da reserva");
		lbl_dataI.setBounds(983, 144, 422, 31);
		lbl_dataI.setFont(new Font("Corbel", Font.BOLD, 25));
		contentPane1.add(lbl_dataI);

		ButtonGroup grupoFormasPagamento = new ButtonGroup();
		JRadioButton radioPIX = new JRadioButton("PIX");
		radioPIX.setBounds(1094, 527, 97, 23);
		contentPane1.add(radioPIX);
		grupoFormasPagamento.add(radioPIX);

		JRadioButton radioBoleto = new JRadioButton("Boleto Parcelado");
		radioBoleto.setBounds(1094, 567, 129, 23);
		contentPane1.add(radioBoleto);
		grupoFormasPagamento.add(radioBoleto);

		JRadioButton radioCartao = new JRadioButton("Cartão de Crédito");
		radioCartao.setBounds(1094, 489, 160, 23);
		contentPane1.add(radioCartao);
		grupoFormasPagamento.add(radioCartao);

		try {
			MaskFormatter mascaraData = new MaskFormatter("##/##/####");
			txt_digiDataI = new JFormattedTextField(mascaraData);
			txt_digiDataI.setBounds(983, 186, 431, 25);
			txt_digiDataI.setFont(new Font("Corbel", Font.BOLD, 15));
			contentPane1.add(txt_digiDataI);
			txt_digiDataI.setColumns(10);

			txt_digiDataF = new JFormattedTextField(mascaraData);
			txt_digiDataF.setBounds(983, 287, 431, 25);
			txt_digiDataF.setFont(new Font("Corbel", Font.BOLD, 15));
			contentPane1.add(txt_digiDataF);
			txt_digiDataF.setColumns(10);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String formaPagamento = "";

				if (radioPIX.isSelected()) {
					formaPagamento = "PIX";
				} else if (radioBoleto.isSelected()) {
					formaPagamento = "Boleto Parcelado";
				} else if (radioCartao.isSelected()) {
					formaPagamento = "Cartão de Crédito";
				}

				Reserva reserva = new Reserva();

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

				String dataI = txt_digiDataI.getText();
				if (dataI.length() == 0) {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				String dataF = txt_digiDataF.getText();
				if (dataF.length() == 0) {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				LocalDate dtI;
				LocalDate dtF;
				try {
					dtI = LocalDate.parse(dataI, formatter);
					dtF = LocalDate.parse(dataF, formatter);
				} catch (DateTimeParseException ex) {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				if (validacaoData(dtI.toString()) || validacaoData(dtF.toString())) {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
					return;
				}

				reserva.setDataIn(dtI);
				reserva.setDataOut(dtF);
				reserva.setFormaPag(formaPagamento);
				reserva.setPreco(Integer.valueOf(preco));

				ReservaDAO dao = ReservaDAO.getInstancia();
				int idReserva = dao.inserirReserva(reserva);

				if (idReserva != Integer.MIN_VALUE) {
					DetalhesHospedagem detalhes = new DetalhesHospedagem();
					detalhes.setIdHospedagem(idReserva);
					detalhes.setIdUsuario(hosp.getIdUsuario());

					DetaHospDAO detalhesDAO = DetaHospDAO.getInstancia();
					int idDetalhes = detalhesDAO.inserirDetalhes(detalhes);

					if (idDetalhes != Integer.MIN_VALUE) {

						TelaQuarto telaQuarto = new TelaQuarto(tipo, hosp, cidade, estado);
						dispose();
						telaQuarto.setLocationRelativeTo(null);
						telaQuarto.setResizable(false);
						telaQuarto.setVisible(true);
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
				} else {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});

		btnNewButton_1.setBounds(923, 660, 491, 61);
		btnNewButton_1.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/btnFinalizar.png")));
		btnNewButton_1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane1.add(btnNewButton_1);

		JLabel lbl_dataF = new JLabel("Data de fim da reserva");
		lbl_dataF.setBounds(983, 245, 431, 31);
		lbl_dataF.setFont(new Font("Corbel", Font.BOLD, 25));
		contentPane1.add(lbl_dataF);

		JLabel lbl_forma = new JLabel("Formas de Pagamento");
		lbl_forma.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_forma.setBounds(983, 451, 431, 31);
		contentPane1.add(lbl_forma);

		JLabel lbl_preco = new JLabel("Preço:");
		lbl_preco.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_preco.setBounds(983, 344, 576, 31);
		contentPane1.add(lbl_preco);

		JPanel LadoJanela = new JPanel();
		LadoJanela.setBounds(0, 5, 1026, 850);
		contentPane1.add(LadoJanela);
		LadoJanela.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(-267, 0, 1283, 895);
		lblNewLabel_3.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/LadoA.png")));
		LadoJanela.add(lblNewLabel_3);
	}

	public static Boolean validacaoData(String strDate) {
		String dateFormat = "dd/MM/uuuu";

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat)
				.withResolverStyle(ResolverStyle.STRICT);
		try {
			LocalDate date = LocalDate.parse(strDate, dateTimeFormatter);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
