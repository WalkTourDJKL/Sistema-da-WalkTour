package visao;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import controle.Conexao;
import controle.DetaHospDAO;
import controle.QuartoDAO;
import controle.UsuariosDAO;
import controle.pontosTurDAO;
import controle.ReservaDAO;
import modelo.DetalhesHospedagem;
import modelo.PontosTur;
import modelo.Quarto;
import modelo.Usuarios;
import modelo.Reserva;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TelaGestao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private pontosTurDAO dao = pontosTurDAO.getInstancia();
	private QuartoDAO dao2 = QuartoDAO.getInstancia();
	private JTextField txtDtNsc;
	private JTable tableP;
	private JTable tableQ;
	ArrayList<PontosTur> pontosTur = new ArrayList<>();

	/**
	 * Create the frame.
	 * 
	 * @param hosp
	 * @param tipo
	 * @param cidade
	 * @param tVolt
	 * @param estado
	 * 
	 */
	public TelaGestao(Usuarios hosp, String tipo, String cidade, int tVolt, String estado) {
		setTitle("Tela de gestao:" + hosp.getNome());
		Usuarios hops = new Usuarios();
		Usuarios h1 = hosp;
		Quarto quartos = new Quarto();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaGestao.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaVolta = new TelaPrincipal(hosp);
				dispose();
				telaVolta.setResizable(false);
				telaVolta.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setBounds(40, 242, 89, 23);
		contentPane.add(btnVoltar);
		tableP = new JTable();
		tableP.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableP.getSelectedRow();
				editPonto(row);
			}
		});
		atualizarTabela();
		JScrollPane scrollPane = new JScrollPane(tableP);
		scrollPane.setBounds(55, 619, 577, 231);
		contentPane.add(scrollPane);
		tableQ = new JTable();
		tableQ.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int row = tableQ.getSelectedRow();
				editQuarto(row);
			}
		});
		JScrollPane scrollPane3 = new JScrollPane(tableQ);
		scrollPane3.setBounds(23, 33, 578, 231);
		contentPane.add(scrollPane3);
		atualizarTabelaQ();

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaGestao.class.getResource("/imgs/ladoD.png")));
		lblNewLabel_1.setBounds(723, 0, 712, 1089);
		contentPane.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(32, 586, 743, 275);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblGestoDe = new JLabel("Gest\u00E3o de pontos turisticos");
		lblGestoDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestoDe.setBounds(0, 0, 626, 32);
		lblGestoDe.setFont(new Font("Dialog", Font.PLAIN, 24));
		panel.add(lblGestoDe);
		
				JButton btnInserirPT = new JButton("Inserir");
				btnInserirPT.setBounds(604, 43, 129, 35);
				panel.add(btnInserirPT);
				btnInserirPT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String coisa = "insert";
						TelaEditPontosTur edit = new TelaEditPontosTur(null, null, null, 0, 0, coisa);
						edit.setResizable(false);
						edit.setVisible(true);

					}
				});
				btnInserirPT.setForeground(Color.BLACK);
				btnInserirPT.setFont(new Font("Dialog", Font.PLAIN, 18));
				btnInserirPT.setFocusPainted(false);
				btnInserirPT.setBackground(new Color(240, 240, 240));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(32, 300, 743, 275);
		contentPane.add(panel_1);
		
		JLabel lblGestoDeQuartos_1 = new JLabel("Gest\u00E3o de quartos");
		lblGestoDeQuartos_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestoDeQuartos_1.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblGestoDeQuartos_1.setBounds(0, 0, 626, 32);
		panel_1.add(lblGestoDeQuartos_1);
				
				JButton btnInserirQ = new JButton("Inserir");
				btnInserirQ.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//TelaEditPontosTur
					}
				});
				btnInserirQ.setForeground(Color.BLACK);
				btnInserirQ.setFont(new Font("Dialog", Font.PLAIN, 18));
				btnInserirQ.setFocusPainted(false);
				btnInserirQ.setBackground(UIManager.getColor("Button.background"));
				btnInserirQ.setBounds(604, 43, 129, 35);
				panel_1.add(btnInserirQ);

	}

	public LocalDate convertStringToDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			return LocalDate.parse(dateString, formatter);
		} catch (DateTimeParseException e) {
			JOptionPane.showMessageDialog(null, "Formato de data inv�lido. Use o formato dd/MM/yyyy.");
			return null;
		}
	}

	private void atualizarTabela() {

		pontosTur = dao.listarPontoTur();
		DefaultTableModel model2 = new DefaultTableModel(
				new Object[] { "Id", "Nome", "Hora Abre", "Hora Fecha", "Pre�o" }, 0) {
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		for (PontosTur pt : pontosTur) {
			model2.addRow(new Object[] { pt.getPontoId(), pt.getNomePontoTur(), pt.getHoraAbre(), pt.getHoraFecha(),
					pt.getPreco() });
		}
		tableP.setModel(model2);

	}

	private void atualizarTabelaQ() {
		ArrayList<Quarto> quarto = new ArrayList<Quarto>();

		quarto = dao2.listarQuartos();
		DefaultTableModel model = new DefaultTableModel(new Object[] { "num_quarto", "hora_limpeza", "tipo_id" }, 0) {

			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		for (Quarto e : quarto) {
			model.addRow(new Object[] { e.getNumQuarto(), e.getHoraLimpeza(), e.getTipoId() });
		}

		tableQ.setModel(model);
	}

	private void editPonto(int row) {
		DefaultTableModel model2 = (DefaultTableModel) tableP.getModel();

		int idPonto = (Integer) model2.getValueAt(row, 0);
		String nome = (String) model2.getValueAt(row, 1);
		Time horaAbre = (Time) model2.getValueAt(row, 2);
		Time horaFecha = (Time) model2.getValueAt(row, 3);
		int preco = (Integer) model2.getValueAt(row, 4);
		String coisa = "ponto turistico";
		TelaIseriEdita edit = new TelaIseriEdita(nome, horaAbre, horaFecha, preco, idPonto, preco, horaFecha, preco,
				coisa);
		edit.setResizable(false);
		edit.setVisible(true);
		System.out.println("Editando ponto: Nome do ponto: " + nome + ",horaAbre: " + horaAbre + ", horaFecha: "
				+ horaFecha + ", Pre�o: " + preco + ", ID: " + idPonto);
	}

	private void editQuarto(int row) {
		DefaultTableModel model2 = (DefaultTableModel) tableQ.getModel();

		int idQuarto = (Integer) model2.getValueAt(row, 0);
		Time horaLimpeza = (Time) model2.getValueAt(row, 1);
		int TipoId = (Integer) model2.getValueAt(row, 2);
		String coisa = "quarto";
		TelaIseriEdita edit = new TelaIseriEdita(coisa, horaLimpeza, horaLimpeza, TipoId, TipoId, TipoId, horaLimpeza,
				idQuarto, coisa);
		edit.setResizable(false);
		edit.setVisible(true);
	}
}