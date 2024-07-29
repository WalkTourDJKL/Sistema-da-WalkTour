package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.DetaHospDAO;
import controle.UsuariosDAO;
import controle.ReservaDAO;
import modelo.Usuarios;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Time;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaIseriEdita extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ReservaDAO reservaDAO = ReservaDAO.getInstancia();
	DetaHospDAO detalhesDAO = DetaHospDAO.getInstancia();
	TelaSucesso sucesso = new TelaSucesso();

	/**
	 * Create the frame.
	 * @param idPonto 
	 * @param preco 
	 * @param horaFecha 
	 * @param horaAbre 
	 * @param nome 
	 * 
	 * @param coisa
	 * @param preco
	 * @param coisa 
	 * @param buttonEditor
	 * @param hops
	 */
	public TelaIseriEdita(String nome, Time horaAbre, Time horaFecha, int preco, int idPonto,int tipoId, Time horaLimpeza, int idQuarto, String coisa) {
		setTitle("Tela de escolha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Voc\u00EA deseja inserir um "+coisa+"");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 24, 564, 43);
		lblNewLabel.setForeground(new Color(102, 112, 122));
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 35));
		contentPane.add(lblNewLabel);

		JLabel lblExcluirSuaConta = new JLabel("ou editar um "+coisa+"?");
		lblExcluirSuaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirSuaConta.setBounds(21, 69, 537, 43);
		lblExcluirSuaConta.setForeground(new Color(102, 112, 122));
		lblExcluirSuaConta.setFont(new Font("Corbel", Font.BOLD, 35));
		contentPane.add(lblExcluirSuaConta);

		JButton btnInserir = new JButton("Deletar");
		btnInserir.setFocusPainted(false);
		btnInserir.setBackground(new Color(240, 240, 240));
		btnInserir.setForeground(new Color(0, 0, 0));
		btnInserir.setBounds(102, 137, 100, 33);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coisa.equals("ponto turistico")) {
					String coisa = "delete";
					TelaEditPontosTur edit = new TelaEditPontosTur(nome, horaAbre, horaFecha, preco, idPonto,coisa);
					edit.setResizable(false);
					edit.setVisible(true);
					dispose();
				}
				if (coisa.equals("quarto")) {
					String coisa = "delete";
					TelaEditQuarto edit = new TelaEditQuarto(tipoId,horaLimpeza,idQuarto,coisa);
					edit.setResizable(false);
					edit.setVisible(true);
					dispose();
				}
			}
		});

		btnInserir.setFont(new Font("Corbel", Font.PLAIN, 20));
		contentPane.add(btnInserir);

		JButton btnNao = new JButton("Editar");
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coisa.equals("ponto turistico")) {
					String coisa = "edit";
					TelaEditPontosTur edit = new TelaEditPontosTur(nome, horaAbre, horaFecha, preco, idPonto,coisa);
					edit.setResizable(false);
					edit.setVisible(true);
					dispose();
				}
				if (coisa.equals("quarto")) {
					String coisa = "edit";
					TelaEditQuarto edit = new TelaEditQuarto(tipoId,horaLimpeza,idQuarto,coisa);
					edit.setResizable(false);
					edit.setVisible(true);
					dispose();
				}
			}
		});
		btnNao.setFont(new Font("Corbel", Font.PLAIN, 20));
		btnNao.setBounds(251, 137, 100, 33);
		btnNao.setFocusPainted(false);
		btnNao.setBackground(new Color(240, 240, 240));
		contentPane.add(btnNao);
		

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
		btnCancelar.setBounds(406, 133, 140, 33);
		contentPane.add(btnCancelar);
	}
}
