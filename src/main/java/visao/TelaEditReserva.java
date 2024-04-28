package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

import com.mysql.cj.xdevapi.Table;

import controle.Conexao;
import controle.DetaHospDAO;
import controle.HospedesDAO;
import controle.ReservaDAO;
import modelo.DetalhesHospedagem;
import modelo.Hospedes;
import modelo.Reserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;

public class TelaEditReserva extends JFrame {

	private JPanel contentPane;
	public JFormattedTextField txt_digiDataI;
	private JFormattedTextField txt_digiDataF;
	private HospedesDAO hospdao = HospedesDAO.getInstancia();

	/**
	 * Create the frame.
	 * 
	 * @param idHospedagem
	 * @param dataOut
	 * @param dataIn
	 * @param formaPag
	 */
	public TelaEditReserva(String formaPag, Date dataIn, Date dataOut, int idHospedagem) {
		Hospedes hops = new Hospedes();
		hops = hospdao.passaLogado();
		setTitle("Tela de edicao de reserva");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEditReserva.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lbl_dataI = new JLabel("Data de incio da reserva:");
		lbl_dataI.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_dataI.setBounds(40, 320, 320, 38);
		contentPane.add(lbl_dataI);

		try {
			MaskFormatter mascaraData = new MaskFormatter("####-##-##");
			txt_digiDataI = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txt_digiDataI.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_digiDataI.setColumns(10);
		txt_digiDataI.setBounds(370, 320, 500, 38);
		txt_digiDataI.setText(String.valueOf(dataIn));
		contentPane.add(txt_digiDataI);

		JLabel lbl_dataF = new JLabel("Data de fim da reserva:");
		lbl_dataF.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_dataF.setBounds(40, 369, 320, 38);
		contentPane.add(lbl_dataF);

		try {
			MaskFormatter mascaraData = new MaskFormatter("####-##-##");
			txt_digiDataF = new JFormattedTextField(mascaraData);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txt_digiDataF.setFont(new Font("Dialog", Font.PLAIN, 16));
		txt_digiDataF.setColumns(10);
		txt_digiDataF.setBounds(370, 369, 500, 38);
		txt_digiDataF.setText(String.valueOf(dataOut));
		contentPane.add(txt_digiDataF);

		JLabel lbl_forma = new JLabel("Formas de Pagamento");
		lbl_forma.setFont(new Font("Corbel", Font.PLAIN, 25));
		lbl_forma.setBounds(40, 418, 250, 31);
		contentPane.add(lbl_forma);

		ButtonGroup grupoFormasPagamento = new ButtonGroup();

		JRadioButton radioPIX = new JRadioButton("PIX");
		radioPIX.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioPIX.setBounds(521, 420, 49, 23);
		contentPane.add(radioPIX);
		grupoFormasPagamento.add(radioPIX);

		JRadioButton radioBoleto = new JRadioButton("Boleto Parcelado");
		radioBoleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioBoleto.setBounds(572, 420, 143, 23);
		contentPane.add(radioBoleto);
		grupoFormasPagamento.add(radioBoleto);

		JRadioButton radioCartao = new JRadioButton("Cartao de Credito");
		radioCartao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		radioCartao.setBounds(370, 418, 149, 23);
		contentPane.add(radioCartao);
		grupoFormasPagamento.add(radioCartao);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String dataInicio = txt_digiDataI.getText();
				String dataFim = txt_digiDataF.getText();
				String formaPagamento = "";

				if (radioPIX.isSelected()) {
					formaPagamento = "PIX";
				} else if (radioBoleto.isSelected()) {
					formaPagamento = "Boleto Parcelado";
				} else if (radioCartao.isSelected()) {
					formaPagamento = "Cartao de Credito";
				}

				Reserva reserva = new Reserva();
				reserva.setFormaPag(formaPagamento);
				reserva.setIdHospedagem(idHospedagem);

				SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
				try {
					java.util.Date dataFormatadaInicio = formatador.parse(dataInicio);
					reserva.setDataIn(new java.sql.Date(dataFormatadaInicio.getTime()));

					java.util.Date dataFormatadaFim = formatador.parse(dataFim);
					reserva.setDataOut(new java.sql.Date(dataFormatadaFim.getTime()));
				} catch (ParseException ex) {
					ex.printStackTrace();
				}

				ReservaDAO dao = ReservaDAO.getInstancia();
				if (dao.atualizarReserva(reserva) > 0) {
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setResizable(false);
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
					dispose();
				} else {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBackground(new Color(240, 240, 240));
		btnAtualizar.setBounds(40, 472, 250, 35);
		contentPane.add(btnAtualizar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(240, 240, 240));
		btnCancelar.setBounds(370, 472, 250, 35);
		contentPane.add(btnCancelar);

	}

	public Date convertStringToDate(String dateString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			java.util.Date date = formatter.parse(dateString);
			return new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Formato de data inválido. Use o formato yyyy-MM-dd.");
			return null;
		}
	}
}