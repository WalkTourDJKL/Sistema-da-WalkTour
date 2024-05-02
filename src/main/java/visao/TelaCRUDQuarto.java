package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.QuartoDAO;
import modelo.Quarto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaCRUDQuarto extends JFrame {

	private JPanel contentPane;
	private QuartoDAO dao = QuartoDAO.getInstancia();
	private JTable table;
	ArrayList<Quarto> quarto = new ArrayList<Quarto>();
	private JTextField txtId;
	private JTextField txthLimp;
	private JTextField txtModel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCRUDQuarto frame = new TelaCRUDQuarto();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCRUDQuarto() {

		Quarto quartos = new Quarto();
		setTitle("Tela de gestão quartos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int linha = table.getSelectedRow();
				Quarto quartoSelecionada = quarto.get(linha);
				if (linha != -1) {
					preencherCampos(quartoSelecionada);
				}
			}
		});
		atualizarTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 489, 1374, 231);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaCRUDQuarto.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("hora limpeza");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(40, 320, 189, 38);
		contentPane.add(lblUsurio);

		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			txthLimp = new JFormattedTextField(mascara);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txthLimp.setFont(new Font("Dialog", Font.PLAIN, 16));
		txthLimp.setColumns(10);
		txthLimp.setBounds(239, 323, 500, 38);
		contentPane.add(txthLimp);

		JLabel lblNomeSc = new JLabel("Tipo do quarto");
		lblNomeSc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNomeSc.setBounds(40, 380, 189, 38);
		contentPane.add(lblNomeSc);

		txtId = new JTextField();

		txtModel = new JTextField();
		txtModel.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtModel.setColumns(10);
		txtModel.setBounds(239, 383, 500, 38);
		contentPane.add(txtModel);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String model = txtModel.getText();
					String hrlimp = txthLimp.getText();
					Time horaLimpeza = Time.valueOf(hrlimp + ":00");
					quartos.setHoraLimpeza(horaLimpeza);
					quartos.setTipoId(Integer.parseInt(model));
					int resultado = dao.inserirQuarto(quartos);
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
			}
		});

		btnInserir.setForeground(Color.BLACK);
		btnInserir.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnInserir.setFocusPainted(false);
		btnInserir.setBackground(new Color(240, 240, 240));
		btnInserir.setBounds(40, 755, 250, 35);
		contentPane.add(btnInserir);

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(txtId.getText());
					String Model = txtModel.getText();
					String hrlimp = txthLimp.getText();
					Time horaLimpeza = Time.valueOf(hrlimp + ":00");
					quartos.setHoraLimpeza(horaLimpeza);
					quartos.setNumQuarto(num);
					quartos.setTipoId(Integer.parseInt(Model));

					int resultado = dao.atualizarQuarto(quartos);
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
			}
		});

		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBackground(new Color(240, 240, 240));
		btnAtualizar.setBounds(372, 755, 250, 35);
		contentPane.add(btnAtualizar);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int num = Integer.parseInt(txtId.getText());
					quartos.setNumQuarto(num);
					int resultado = dao.removerQuarto(quartos);
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

			}
		});
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDeletar.setFocusPainted(false);
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setBounds(702, 755, 250, 35);
		contentPane.add(btnDeletar);
	}

	private void atualizarTabela() {
		quarto = dao.listarQuartos();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "num_quarto", "hora_limpeza", "tipo_id" }, 0) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Quarto e : quarto) {
			model.addRow(new Object[] { e.getNumQuarto(), e.getHoraLimpeza(), e.getTipoId() });
		}

		table.setModel(model);
	}

	public void limparCampos() {
		txthLimp.setText("");
		txtModel.setText("");
		txtId.setText("");
	}

	public void preencherCampos(Quarto quarto) {
		txtId.setText(String.valueOf(quarto.getNumQuarto()));
		txthLimp.setText(String.valueOf(quarto.getHoraLimpeza()));
		txtModel.setText(String.valueOf(quarto.getTipoId()));

	}

}