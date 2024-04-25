package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.ReservaDAO;
import modelo.Reserva;

public class TelaFinalizar extends JFrame {

	private JPanel contentPane1;
	private JFormattedTextField txt_digiDataF;
	private JFormattedTextField txt_digiDataI;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public TelaFinalizar() {
		setTitle("Walktour");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane1 = new JPanel();
		contentPane1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Finalizar Reserva");
		lblNewLabel.setBounds(983, 47, 402, 67);
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
		contentPane1.add(lblNewLabel);

		JLabel lbl_dataI = new JLabel("Data Inicio");
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
			MaskFormatter mascaraData = new MaskFormatter("####-##-##");
			txt_digiDataI = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txt_digiDataI.setBounds(983, 186, 431, 25);
		txt_digiDataI.setFont(new Font("Corbel", Font.BOLD, 15));
		contentPane1.add(txt_digiDataI);
		txt_digiDataI.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataInicio = txt_digiDataI.getText();
				String dataFim = txt_digiDataF.getText();
				String formaPagamento = "";

				if (radioPIX.isSelected()) {
					formaPagamento = "PIX";
				} else if (radioBoleto.isSelected()) {
					formaPagamento = "Boleto Parcelado";
				} else if (radioCartao.isSelected()) {
					formaPagamento = "Cartão de Crédito";
				}

				Reserva reserva = new Reserva();

				SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date dataFormatadaUtil = formatador.parse(dataInicio);
					java.sql.Date dataFormatadaSql = new java.sql.Date(dataFormatadaUtil.getTime());
					reserva.setDataIn(dataFormatadaSql);

					dataFormatadaUtil = formatador.parse(dataFim);
					java.sql.Date dataFormatada2Sql = new java.sql.Date(dataFormatadaUtil.getTime());
					reserva.setDataOut(dataFormatada2Sql);

				} catch (ParseException ex) {
					ex.printStackTrace();
				}

				reserva.setFormaPag(formaPagamento);

				ReservaDAO dao = ReservaDAO.getInstancia();
				dao.inserirReserva(reserva);
			}
		});
		btnNewButton_1.setBounds(923, 660, 491, 61);
		btnNewButton_1.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/btnFinalizar.png")));
		btnNewButton_1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		contentPane1.add(btnNewButton_1);

		JLabel lbl_dataF = new JLabel("Data Fim");
		lbl_dataF.setBounds(983, 245, 576, 31);
		lbl_dataF.setFont(new Font("Corbel", Font.BOLD, 25));
		contentPane1.add(lbl_dataF);

		try {
			MaskFormatter mascaraData = new MaskFormatter("####-##-##");
			txt_digiDataF = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txt_digiDataF.setBounds(983, 287, 431, 25);
		txt_digiDataF.setFont(new Font("Corbel", Font.BOLD, 15));
		contentPane1.add(txt_digiDataF);
		txt_digiDataF.setColumns(10);

		JLabel lbl_forma = new JLabel("Formas de Pagamento");
		lbl_forma.setFont(new Font("Corbel", Font.BOLD, 25));
		lbl_forma.setBounds(983, 451, 576, 31);
		contentPane1.add(lbl_forma);

		JLabel lbl_preco = new JLabel("Preço");
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
}
