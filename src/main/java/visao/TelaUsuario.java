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

public class TelaUsuario extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNomeSc;
	private UsuariosDAO hospdao = UsuariosDAO.getInstancia();
	private pontosTurDAO dao = pontosTurDAO.getInstancia();
	private QuartoDAO dao2 = QuartoDAO.getInstancia();
	private JTextField txtDtNsc;
	private JTable table;
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
	public TelaUsuario(Usuarios hosp, String tipo, String cidade, int tVolt, String estado) {
		setTitle("Tela do usuario:" + hosp.getNome());

		Usuarios hops = new Usuarios();
		Usuarios h1 = hosp;
		Quarto quartos = new Quarto();
		hops = hospdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaUsuario.class.getResource("/imgs/Title.png")));
		lblNewLabel.setBounds(0, 0, 1435, 231);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("Nome do hospede:");
		lblUsurio.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblUsurio.setBounds(40, 320, 320, 38);
		contentPane.add(lblUsurio);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(370, 320, 500, 38);
		txtNome.setText(hops.getNome());
		contentPane.add(txtNome);

		JLabel lblDtNsc = new JLabel("Data de nascimento do hospede:");
		lblDtNsc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblDtNsc.setBounds(40, 440, 320, 38);
		contentPane.add(lblDtNsc);

		txtDtNsc = new JTextField();
		txtDtNsc.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtDtNsc.setColumns(10);
		txtDtNsc.setBounds(370, 440, 500, 38);
		txtDtNsc.setText(hops.getDtNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		contentPane.add(txtDtNsc);

		JLabel lblNomeSc = new JLabel("Nome social do hospede:");
		lblNomeSc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNomeSc.setBounds(40, 380, 320, 38);
		contentPane.add(lblNomeSc);

		txtNomeSc = new JTextField();
		txtNomeSc.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtNomeSc.setColumns(10);
		txtNomeSc.setBounds(370, 380, 500, 38);
		txtNomeSc.setText(hops.getNomeSocial());

		contentPane.add(txtNomeSc);
		JLabel lblCpf = new JLabel("CPF do hospede:");
		lblCpf.setFont(new Font("Dialog", Font.PLAIN, 24));
		lblCpf.setBounds(40, 500, 320, 38);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setText(String.valueOf(hops.getCpf()));
		txtCPF.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCPF.setColumns(10);
		txtCPF.setBounds(370, 500, 500, 38);
		contentPane.add(txtCPF);

		LocalDate dataNascimento = convertStringToDate(txtDtNsc.getText());

		JButton btnAtualizar = new JButton("Atualizar informa\u00E7\u00F5es");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LocalDate dataNascimento = convertStringToDate(txtDtNsc.getText());
				if (dataNascimento == null) {
					JOptionPane.showMessageDialog(null,
							"Data de nascimento inv�lida. Por favor, use o formato aaaa-mm-dd.");
					return;
				}

				hosp.setIdUsuario(hosp.getIdUsuario());
				hosp.setNome(txtNome.getText());
				hosp.setCpf(txtCPF.getText());
				hosp.setNomeSocial(txtNomeSc.getText());
				hosp.setDtNasc(dataNascimento);
				hospdao.atualizarUsuarios(hosp);
				atualizarTabela(hosp, h1);
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBackground(new Color(240, 240, 240));
		btnAtualizar.setBounds(40, 549, 250, 35);
		contentPane.add(btnAtualizar);

		JButton btnDeletar = new JButton("Deletar conta");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String coisa = "conta";
				TelaConfirmacao del = new TelaConfirmacao(coisa, tipo, hosp, hospdao, TelaUsuario.this);
				del.setResizable(false);
				del.setVisible(true);
			}
		});
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDeletar.setFocusPainted(false);
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setBounds(370, 549, 250, 35);
		contentPane.add(btnDeletar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tVolt == 1) {
					TelaPrincipal telaVolta = new TelaPrincipal(hosp);
					dispose();
					telaVolta.setResizable(false);
					telaVolta.setVisible(true);
				}
				if (tVolt == 2) {
					TelaHotel telaVolta = new TelaHotel(hosp, cidade, estado);
					dispose();
					telaVolta.setResizable(false);
					telaVolta.setVisible(true);
				}
				if (tVolt == 3) {
					TelaQuartos telaVolta = new TelaQuartos(hosp, cidade, estado);
					dispose();
					telaVolta.setResizable(false);
					telaVolta.setVisible(true);
				}
				if (tVolt == 4) {
					TelaQuarto telaVolta = new TelaQuarto(tipo, hosp, cidade, estado);
					dispose();
					telaVolta.setResizable(false);
					telaVolta.setVisible(true);
				}
				if (tVolt == 5) {
					TelaCidade telaVolta = new TelaCidade(hosp, cidade, estado);
					dispose();
					telaVolta.setResizable(false);
					telaVolta.setVisible(true);
				}

			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setBounds(40, 242, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblGestoDaConta = new JLabel("Gest\u00E3o da conta");
		lblGestoDaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestoDaConta.setFont(new Font("Dialog", Font.PLAIN, 32));
		lblGestoDaConta.setBounds(40, 277, 830, 32);
		contentPane.add(lblGestoDaConta);
		
		JButton btnSair = new JButton("Sair da Conta");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
				TelaLogin telaLogin = new TelaLogin();
				telaLogin.setResizable(false);
				telaLogin.setVisible(true);
			}
		});
		btnSair.setBounds(734, 277, 136, 32);
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Dialog", Font.BOLD, 14));
		btnSair.setFocusPainted(false);
		btnSair.setBackground(new Color(240, 240, 240));
		contentPane.add(btnSair);

		if (hosp.getTipoUser() == 1) {
			tableP = new JTable();
			tableP.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = tableP.getSelectedRow();
					editPonto(row);
				}
			});
			atualizarTabela();
			JScrollPane scrollPane = new JScrollPane(tableP);
			scrollPane.setBounds(40, 619, 584, 231);
			contentPane.add(scrollPane);

			tableQ = new JTable();
			tableQ.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int row = tableQ.getSelectedRow();
					editQuarto(row);
				}
			});
			atualizarTabelaQ();
			JScrollPane scrollPane3 = new JScrollPane(tableQ);
			scrollPane3.setBounds(630, 619, 240, 231);
			contentPane.add(scrollPane3);

			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(TelaUsuario.class.getResource("/imgs/ladoD.png")));
			lblNewLabel_1.setBounds(723, 0, 712, 1089);
			contentPane.add(lblNewLabel_1);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setBounds(32, 586, 848, 275);
			contentPane.add(panel);
			panel.setLayout(null);

			JLabel lblGestoDe = new JLabel("Gest\u00E3o de pontos turisticos");
			lblGestoDe.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestoDe.setBounds(10, 0, 578, 32);
			lblGestoDe.setFont(new Font("Dialog", Font.PLAIN, 24));
			panel.add(lblGestoDe);

			JLabel lblGestoDeQuartos = new JLabel("Gest\u00E3o de quartos");
			lblGestoDeQuartos.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestoDeQuartos.setFont(new Font("Dialog", Font.PLAIN, 24));
			lblGestoDeQuartos.setBounds(598, 0, 240, 32);
			panel.add(lblGestoDeQuartos);

		} else {
			table = new JTable();
			atualizarTabela(hosp, h1);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(40, 619, 584, 231);
			contentPane.add(scrollPane);
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(TelaUsuario.class.getResource("/imgs/ladoD.png")));
			lblNewLabel_1.setBounds(723, 0, 712, 1089);
			contentPane.add(lblNewLabel_1);

			JPanel panel = new JPanel();
			panel.setBackground(new Color(192, 192, 192));
			panel.setBounds(32, 586, 600, 275);
			contentPane.add(panel);
			panel.setLayout(null);

			JLabel lblGestoDe = new JLabel("Gest\u00E3o de suas reservas");
			lblGestoDe.setHorizontalAlignment(SwingConstants.CENTER);
			lblGestoDe.setBounds(10, 0, 578, 32);
			lblGestoDe.setFont(new Font("Dialog", Font.PLAIN, 24));
			panel.add(lblGestoDe);
		}

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

	private void atualizarTabela(Usuarios hops, Usuarios h1) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Conexao conexao = Conexao.getConexao();

		Connection conDB = conexao.conectar();

		ReservaDAO reservaDAO = ReservaDAO.getInstancia();
		ArrayList<Reserva> reserva = new ArrayList<Reserva>();

		String sql = "SELECT hospedagens.* FROM hospedagens INNER JOIN detalhes_hospedagem ON hospedagens.id_hospedagem = detalhes_hospedagem.id_hospedagem WHERE detalhes_hospedagem.id_usuario = ?";
		try {
			PreparedStatement stmt = conDB.prepareStatement(sql);
			stmt.setInt(1, hops.getIdUsuario());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Reserva r = new Reserva();
				r.setFormaPag(rs.getString("forma_pag"));
				r.setDataIn(rs.getDate("data_in").toLocalDate());
				r.setDataOut(rs.getDate("data_out").toLocalDate());
				r.setPreco(rs.getInt("preco"));
				r.setIdHospedagem(rs.getInt("id_hospedagem"));
				reserva.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		conexao.fecharConexao();

		String[] colunas = { "forma_pag", "data_in", "data_out", "preco", "Editar", "Excluir", "ID" };
		DefaultTableModel model = new DefaultTableModel(colunas, 0) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return column == 4 || column == 5;
			}
		};
		for (Reserva r : reserva) {
			Object[] rowData = { r.getFormaPag(), r.getDataIn().format(formatter), r.getDataOut().format(formatter),
					r.getPreco(), "Editar", "Excluir", r.getIdHospedagem() };
			model.addRow(rowData);
		}
		table.setModel(model);
		table.getColumnModel().getColumn(6).setMinWidth(0);
		table.getColumnModel().getColumn(6).setMaxWidth(0);
		table.getColumnModel().getColumn(6).setWidth(0);
		table.getColumn("Editar").setCellRenderer(new ButtonRenderer());
		table.getColumn("Editar").setCellEditor(new ButtonEditor(new JCheckBox(), "Editar", h1));
		table.getColumn("Excluir").setCellRenderer(new ButtonRenderer());
		table.getColumn("Excluir").setCellEditor(new ButtonEditor(new JCheckBox(), "Excluir", h1));

	}

	class ButtonRenderer extends JButton implements TableCellRenderer {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public ButtonRenderer() {
			setOpaque(true);
		}

		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			setText((value == null) ? "Acao" : value.toString());
			return this;
		}
	}

	class ButtonEditor extends DefaultCellEditor {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		protected JButton button;
		private String label;
		private boolean isPushed;
		private int row;
		private JTable table;
		private String action;
		private Usuarios hosp;

		public ButtonEditor(JCheckBox checkBox, String action, Usuarios hosp) {
			super(checkBox);
			this.hosp = hosp;
			this.action = action;
			button = new JButton();
			button.setOpaque(true);
			button.addActionListener(e -> {
				isPushed = true;
				fireEditingStopped();
			});
		}

		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
				int column) {
			this.table = table;
			this.row = row;
			if (isSelected) {
				button.setForeground(table.getSelectionForeground());
				button.setBackground(table.getSelectionBackground());
			} else {
				button.setForeground(table.getForeground());
				button.setBackground(table.getBackground());
			}
			label = (value == null) ? action : value.toString();
			button.setText(label);
			return button;
		}

		public Object getCellEditorValue() {
			if (isPushed) {
				if (action.equals("Editar")) {
					editarReserva(row);
				} else if (action.equals("Excluir")) {
					excluirReserva(row);
				}
			}
			isPushed = false;
			return label;
		}

		private void excluirReserva(int row) {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			int idHospedagem = (Integer) model.getValueAt(row, 6);
			int idDetalheHospedagem = (Integer) model.getValueAt(row, 6);

			ReservaDAO reservaDAO = ReservaDAO.getInstancia();
			DetaHospDAO detalhesDAO = DetaHospDAO.getInstancia();

			// Criar objeto DetalhesHospedagem
			DetalhesHospedagem detalhe = new DetalhesHospedagem();
			detalhe.setIdDetalheHospedagem(idDetalheHospedagem);

			// Remover detalhes espec�ficos
			detalhesDAO.removerDetalhes(detalhe);

			// Remover a reserva
			Reserva reserva = new Reserva();
			reserva.setIdHospedagem(idHospedagem);
			reservaDAO.removerReserva(reserva);

			System.out.println("Excluindo reserva e detalhes da hospedagem: ID Reserva " + idHospedagem
					+ ", ID Detalhe " + idDetalheHospedagem);
		}

	}

	private void editarReserva(int row) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		String formaPag = (String) model.getValueAt(row, 0);
		LocalDate dataIn = (LocalDate) model.getValueAt(row, 1);
		LocalDate dataOut = (LocalDate) model.getValueAt(row, 2);
		int preco = (Integer) model.getValueAt(row, 3);
		int idHospedagem = (Integer) model.getValueAt(row, 6);
		TelaEditReserva edit = new TelaEditReserva(formaPag, dataIn, dataOut, idHospedagem);
		edit.setResizable(false);
		edit.setVisible(true);
		System.out.println("Editando reserva: Forma Pag: " + formaPag + ", Data In�cio: " + dataIn + ", Data Fim: "
				+ dataOut + ", Pre�o: " + preco);
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