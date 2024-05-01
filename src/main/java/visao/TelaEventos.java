package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controle.EnderecoDAO;
import modelo.Endereco;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaEventos extends JFrame {

	private JPanel contentPane;
	private EnderecoDAO dao = EnderecoDAO.getInstancia();
	private JTable table;
	ArrayList<Endereco> enderecos = new ArrayList<Endereco>();
	private JTextField txtId;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JTextField txtPais;
	private JTextField txtCep;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEventos frame = new TelaEventos();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaEventos() {

		Endereco endereco = new Endereco();
		setTitle("Tela de Eventos");
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
				Endereco enderecoSelecionada = enderecos.get(linha);
				if (linha != -1) {
					preencherCampos(enderecoSelecionada);
				}
			}
		});
		atualizarTabela();
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(40, 489, 1374, 231);
		contentPane.add(scrollPane);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaEventos.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("Cidade");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(40, 320, 189, 38);
		contentPane.add(lblUsurio);

		JLabel lblCepDoEndereco = new JLabel("Cep do endereco");
		lblCepDoEndereco.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblCepDoEndereco.setBounds(40, 263, 189, 38);
		contentPane.add(lblCepDoEndereco);

		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCidade.setColumns(10);
		txtCidade.setBounds(239, 323, 500, 38);
		contentPane.add(txtCidade);

		JLabel lblDtNsc = new JLabel("Pais");
		lblDtNsc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblDtNsc.setBounds(40, 440, 189, 38);
		contentPane.add(lblDtNsc);

		txtPais = new JTextField();
		txtPais.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtPais.setColumns(10);
		txtPais.setBounds(239, 440, 500, 38);
		contentPane.add(txtPais);

		JLabel lblNomeSc = new JLabel("Estado");
		lblNomeSc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNomeSc.setBounds(40, 380, 189, 38);
		contentPane.add(lblNomeSc);

		txtId = new JTextField();

		txtEstado = new JTextField();
		txtEstado.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtEstado.setColumns(10);
		txtEstado.setBounds(239, 383, 500, 38);
		contentPane.add(txtEstado);

		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String cep = txtCep.getText();
					String cidade = txtCidade.getText();
					String estado = txtEstado.getText();
					String pais = txtPais.getText();
					endereco.setCep(cep);
					endereco.setCidade(cidade);
					endereco.setEstado(estado);
					endereco.setPais(pais);

					int resultado = dao.inserirEndereco(endereco);
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
					int enderecoId = Integer.parseInt(txtId.getText());
					String cep = txtCep.getText();
					String cidade = txtCidade.getText();
					String estado = txtEstado.getText();
					String pais = txtPais.getText();
					endereco.setEnderecoId(enderecoId);
					endereco.setCep(cep);
					endereco.setCidade(cidade);
					endereco.setEstado(estado);
					endereco.setPais(pais);

					int resultado = dao.atualizarEndereco(endereco);
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
					int enderecoId = Integer.parseInt(txtId.getText());
					endereco.setEnderecoId(enderecoId);
					int resultado = dao.removerEndereco(endereco);
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

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaEventos.class.getResource("/imgs/ladoD.png")));
		lblNewLabel_1.setBounds(723, 0, 712, 1089);
		contentPane.add(lblNewLabel_1);

		txtCep = new JTextField();
		txtCep.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCep.setColumns(10);
		txtCep.setBounds(239, 263, 500, 38);
		contentPane.add(txtCep);

	}

	private void atualizarTabela() {
		enderecos = dao.listarEndereco();
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "cep", "cidade", "estado", "pais", "endereco_id" }, 0) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Endereco e : enderecos) {
			model.addRow(new Object[] { e.getCep(), e.getCidade(), e.getEstado(), e.getPais(), e.getEnderecoId() });
		}

		table.setModel(model);
	}

	public void limparCampos() {
		txtCep.setText("");
		txtCidade.setText("");
		txtEstado.setText("");
		txtPais.setText("");
		txtId.setText("");
	}

	public void preencherCampos(Endereco endereco) {
		txtCep.setText(endereco.getCep());
		txtCidade.setText(endereco.getCidade());
		txtEstado.setText(endereco.getEstado());
		txtPais.setText(endereco.getPais());
		txtId.setText(String.valueOf(endereco.getEnderecoId()));
	}

}