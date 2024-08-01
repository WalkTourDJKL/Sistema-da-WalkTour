package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.QuartoDAO;
import controle.ReservaDAO;
import controle.pontosTurDAO;
import modelo.PontosTur;
import modelo.Quarto;
import modelo.Reserva;
import modelo.Usuarios;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class TelaEditPontosTur extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomePT;
	private JTextField textHoraAbre;
	private JTextField textHoraFecha;
	private JTextField textPreco;

	/**
	 * Create the frame.
	 * 
	 * @param idPonto
	 * @param preco
	 * @param horaFecha
	 * @param horaAbre
	 * @param nome
	 * @param coisa
	 */
	public TelaEditPontosTur(String nome, Time horaAbre, Time horaFecha, int preco, int idPonto, String coisa) {
		setTitle("WalkTour - Editar ponto turístico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 607);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEditReserva.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lbl_NomePontoTur = new JLabel("Nome do ponto turístico:");
		lbl_NomePontoTur.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_NomePontoTur.setBounds(40, 320, 320, 38);
		contentPane.add(lbl_NomePontoTur);

		JLabel lbl_HoraAbre = new JLabel("Horário de abertura do ponto turístico:");
		lbl_HoraAbre.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_HoraAbre.setBounds(40, 369, 408, 38);
		contentPane.add(lbl_HoraAbre);

		JLabel lbl_HoraFecha = new JLabel("Horário de encerramento do ponto turístico:");
		lbl_HoraFecha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_HoraFecha.setBounds(40, 418, 471, 31);
		contentPane.add(lbl_HoraFecha);

		JLabel lbl_Preco = new JLabel("Preço do ponto turístico:");
		lbl_Preco.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_Preco.setBounds(40, 460, 471, 31);
		contentPane.add(lbl_Preco);

		textNomePT = new JTextField();
		textNomePT.setFont(new Font("Dialog", Font.PLAIN, 16));
		textNomePT.setHorizontalAlignment(SwingConstants.LEFT);
		textNomePT.setBounds(308, 325, 434, 38);
		textNomePT.setText(nome);
		contentPane.add(textNomePT);
		textNomePT.setColumns(10);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			textHoraAbre = new JFormattedTextField(mascara);

		} catch (Exception e) {

		}
		textHoraAbre.setFont(new Font("Dialog", Font.PLAIN, 16));
		textHoraAbre.setHorizontalAlignment(SwingConstants.LEFT);
		textHoraAbre.setBounds(458, 374, 284, 38);
		textHoraAbre.setText(String.valueOf(horaAbre));
		contentPane.add(textHoraAbre);
		textHoraAbre.setColumns(10);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			textHoraFecha = new JFormattedTextField(mascara);

		} catch (Exception e) {

		}
		textHoraFecha.setFont(new Font("Dialog", Font.PLAIN, 16));
		textHoraFecha.setHorizontalAlignment(SwingConstants.LEFT);
		textHoraFecha.setBounds(518, 419, 224, 38);
		textHoraFecha.setText(String.valueOf(horaFecha));
		contentPane.add(textHoraFecha);
		textHoraFecha.setColumns(10);

		try {
			MaskFormatter mascara = new MaskFormatter("##");
			textPreco = new JFormattedTextField(mascara);

		} catch (Exception e) {

		}
		textPreco.setFont(new Font("Dialog", Font.PLAIN, 16));
		textPreco.setHorizontalAlignment(SwingConstants.LEFT);
		textPreco.setBounds(308, 461, 434, 38);
		textPreco.setText(String.valueOf(preco));
		contentPane.add(textPreco);
		textPreco.setColumns(10);

		if (coisa.equals("insert")) {
			JButton btnInserir = new JButton("Inserir");
			btnInserir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String digNomePT = textNomePT.getText();
					String digHoraAbre = textHoraAbre.getText() + ":00";
					String digHoraFecha = textHoraFecha.getText() + ":00";
					String digPreco = textPreco.getText();

					PontosTur ponto = new PontosTur();

					ponto.setNomePontoTur(digNomePT);
					ponto.setHoraAbre(Time.valueOf(digHoraAbre));
					ponto.setHoraFecha(Time.valueOf(digHoraFecha));
					ponto.setPreco(Integer.valueOf(digPreco));

					pontosTurDAO dao = pontosTurDAO.getInstancia();
					int result = dao.inserirPontoTur(ponto);
					if (result > 0) {
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
			btnInserir.setForeground(Color.BLACK);
			btnInserir.setFocusPainted(false);
			btnInserir.setBackground(new Color(240, 240, 240));
			btnInserir.setFont(new Font("Dialog", Font.PLAIN, 18));
			btnInserir.setBounds(40, 502, 140, 35);
			contentPane.add(btnInserir);
		}
		if (coisa.equals("delete")) {
			JButton btnDeletar = new JButton("Deletar");
			btnDeletar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PontosTur ponto = new PontosTur();
					ponto.setPontoId(idPonto);
					pontosTurDAO pt = pontosTurDAO.getInstancia();
					pt.removerPontosTur(ponto);
					dispose();
				}
			});
			btnDeletar.setForeground(Color.BLACK);
			btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
			btnDeletar.setFocusPainted(false);
			btnDeletar.setBackground(new Color(240, 240, 240));
			btnDeletar.setBounds(414, 502, 140, 35);
			contentPane.add(btnDeletar);
		}

		if (coisa.equals("edit")) {
			JButton btnAtualizar = new JButton("Atualizar");
			btnAtualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String digNomePT = textNomePT.getText();
					String digHoraAbre = textHoraAbre.getText() + ":00";
					String digHoraFecha = textHoraFecha.getText() + ":00";
					String digPreco = textPreco.getText();

					PontosTur ponto = new PontosTur();

					ponto.setHoraAbre(Time.valueOf(digHoraAbre));
					ponto.setHoraFecha(Time.valueOf(digHoraFecha));
					ponto.setNomePontoTur(digNomePT);
					ponto.setPreco(Integer.valueOf(digPreco));
					ponto.setPontoId(idPonto);

					pontosTurDAO dao = pontosTurDAO.getInstancia();
					int result = dao.atualizarPontosTur(ponto);
					if (result > 0) {
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
			btnAtualizar.setFont(new Font("Dialog", Font.PLAIN, 18));
			btnAtualizar.setFocusPainted(false);
			btnAtualizar.setBackground(new Color(240, 240, 240));
			btnAtualizar.setBounds(224, 502, 140, 35);
			contentPane.add(btnAtualizar);
		}

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(602, 502, 140, 35);
		contentPane.add(btnCancelar);
	}
}
