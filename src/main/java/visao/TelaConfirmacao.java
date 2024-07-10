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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaConfirmacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ReservaDAO reservaDAO = ReservaDAO.getInstancia();
	DetaHospDAO detalhesDAO = DetaHospDAO.getInstancia();
	TelaSucesso sucesso = new TelaSucesso();

	/**
	 * Create the frame.
	 * 
	 * @param coisa
	 * @param hospdao
	 * @param buttonEditor
	 * @param hops
	 */
	public TelaConfirmacao(String coisa, String tipo, Usuarios hosp, UsuariosDAO hospdao, JFrame frame) {
		setTitle("Tela de confirmacao de exclusao de " + coisa);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 234);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tem certeza que deseja");
		lblNewLabel.setBounds(38, 24, 373, 43);
		lblNewLabel.setForeground(new Color(102, 112, 122));
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 35));
		contentPane.add(lblNewLabel);

		JLabel lblExcluirSuaConta = new JLabel("excluir sua conta?");
		lblExcluirSuaConta.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluirSuaConta.setBounds(21, 69, 386, 43);
		lblExcluirSuaConta.setForeground(new Color(102, 112, 122));
		lblExcluirSuaConta.setFont(new Font("Corbel", Font.BOLD, 35));
		contentPane.add(lblExcluirSuaConta);

		JButton btnNewButton = new JButton("Sim");
		btnNewButton.setBackground(new Color(0, 255, 0));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(75, 137, 77, 33);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (coisa.equals("conta")) {
					detalhesDAO.removerDetalhesTodos(hosp);
					hospdao.removerUsuarios(hosp);
					frame.dispose();
					setVisible(false);
					dispose();
					TelaLogin telaLogin = new TelaLogin();
					telaLogin.setResizable(false);
					telaLogin.setVisible(true);
				}
				if (coisa.equals("conta")) {

				}
			}
		});

		btnNewButton.setFont(new Font("Corbel", Font.PLAIN, 20));
		contentPane.add(btnNewButton);

		JButton btnNao = new JButton("Nao");
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNao.setBackground(new Color(255, 0, 0));
		btnNao.setFont(new Font("Corbel", Font.PLAIN, 20));
		btnNao.setBounds(284, 137, 77, 33);
		contentPane.add(btnNao);
	}
}
