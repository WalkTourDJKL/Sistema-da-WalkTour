package visao;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.pontosTurDAO;
import modelo.PontosTur;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.sql.Time;
import java.text.ParseException;

public class TelaPontosTur extends JFrame {

	private JPanel contentPane;
	private pontosTurDAO dao = pontosTurDAO.getInstancia();
	private JTable table;
	ArrayList<PontosTur> pontosTur = new ArrayList<>();
	private JTextField txtHoraAbre, txtHoraFecha, txtPreco, txtPontoId;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				TelaPontosTur frame = new TelaPontosTur();
				frame.setVisible(true);
				frame.setResizable(false);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public TelaPontosTur() {
		PontosTur pt = new PontosTur();
		setTitle("Gestão de Pontos Turísticos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				if (linha != -1) {
					preencherCampos(pontosTur.get(linha));
				}
			}
		});
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 489, 1374, 231);
		contentPane.add(scrollPane);

		txtPontoId = new JTextField();

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPontosTur.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lblHoraAbre = new JLabel("Hora de Abertura:");
		lblHoraAbre.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblHoraAbre.setBounds(40, 380, 250, 38);
		contentPane.add(lblHoraAbre);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			txtHoraAbre = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtHoraAbre.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtHoraAbre.setBounds(300, 380, 439, 38);
		contentPane.add(txtHoraAbre);

		JLabel lblHoraFecha = new JLabel("Hora de Fechamento:");
		lblHoraFecha.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblHoraFecha.setBounds(40, 440, 250, 38);
		contentPane.add(lblHoraFecha);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			txtHoraFecha = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtHoraFecha.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtHoraFecha.setBounds(300, 440, 439, 38);
		contentPane.add(txtHoraFecha);

		JLabel lblPreco = new JLabel("Preço:");
		lblPreco.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblPreco.setBounds(40, 320, 189, 38);
		contentPane.add(lblPreco);

		try {
			MaskFormatter mascara = new MaskFormatter("##.##");
			txtPreco = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtPreco.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPreco.setBounds(239, 320, 500, 38);
		contentPane.add(txtPreco);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						String preco = txtPreco.getText().replace(",", ".");
						String dataA = txtHoraAbre.getText() + ":00";
						String dataF = txtHoraFecha.getText() + ":00";
						pt.setHoraAbre(Time.valueOf(dataA));
						pt.setHoraFecha(Time.valueOf(dataF));
						pt.setPreco(Float.parseFloat(preco));
						int resultado = dao.inserirPontoTur(pt);
						if (resultado > 0) {
							TelaSucesso sucesso = new TelaSucesso();
							sucesso.setResizable(false);
							sucesso.setLocationRelativeTo(null);
							sucesso.setVisible(true);
							atualizarTabela();
							limparCampos();
						} else {
							TelaErro erro = new TelaErro();
							erro.setResizable(false);
							erro.setLocationRelativeTo(null);
							erro.setVisible(true);
						}
					} catch (NumberFormatException ex) {

					}
				} catch (Exception ex) {
				}

			}
		});
		btnInserir.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnInserir.setBounds(40, 755, 250, 35);
		contentPane.add(btnInserir);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int pontoId = Integer.parseInt(txtPontoId.getText());
					String preco = txtPreco.getText().replace(",", ".");
					String dataA = txtHoraAbre.getText() + ":00";
					String dataF = txtHoraFecha.getText() + ":00";
					pt.setHoraAbre(Time.valueOf(dataA));
					pt.setHoraFecha(Time.valueOf(dataF));
					pt.setPreco(Float.parseFloat(preco));
					pt.setPontoId(pontoId);
					int resultado = dao.atualizarPontosTur(pt);
					if (resultado > 0) {
						TelaSucesso sucesso = new TelaSucesso();
						sucesso.setResizable(false);
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);
						atualizarTabela();
						limparCampos();
					} else {
						TelaErro erro = new TelaErro();
						erro.setResizable(false);
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setBounds(372, 755, 250, 35);
		contentPane.add(btnAtualizar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int pontoId = Integer.parseInt(txtPontoId.getText());
					pt.setPontoId(pontoId);
					int resultado = dao.removerPontosTur(pt);
					if (resultado > 0) {
						TelaSucesso sucesso = new TelaSucesso();
						sucesso.setResizable(false);
						sucesso.setLocationRelativeTo(null);
						sucesso.setVisible(true);
						atualizarTabela();
						limparCampos();
					} else {
						TelaErro erro = new TelaErro();
						erro.setResizable(false);
						erro.setLocationRelativeTo(null);
						erro.setVisible(true);
					}
				} catch (Exception ex) {

				}

			}
		});
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDeletar.setBounds(702, 755, 250, 35);
		contentPane.add(btnDeletar);

		atualizarTabela();
	}

	private void atualizarTabela() {
		pontosTur = dao.listarPontoTur();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "Id", "Hora Abre", "Hora Fecha", "Preço" }, 0);
		for (PontosTur pt : pontosTur) {
			model.addRow(new Object[] { pt.getPontoId(), pt.getHoraAbre(), pt.getHoraFecha(), pt.getPreco() });
		}
		table.setModel(model);
	}

	private void limparCampos() {
		txtHoraAbre.setText("");
		txtHoraFecha.setText("");
		txtPreco.setText("");
	}

	private void preencherCampos(PontosTur pt) {
		txtHoraAbre.setText(pt.getHoraAbre().toString());
		txtHoraFecha.setText(pt.getHoraFecha().toString());
		txtPreco.setText(Float.toString(pt.getPreco()));
		txtPontoId.setText(String.valueOf(pt.getPontoId()));

	}
}
