package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Table;

import controle.Conexao;
import controle.HospedesDAO;
import modelo.Hospedes;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNomeSc;
	private HospedesDAO hospdao = HospedesDAO.getInstancia();

	/**
	 * Create the frame.
	 * @param cpf 
	 */
	public TelaUsuario(String cpf) {
		Hospedes hops = new Hospedes();

		hops = hospdao.passaLogado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1700, 700);
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

		JLabel lblCpf = new JLabel("CPF do hospede:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf.setBounds(40, 440, 320, 38);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Dialog", Font.PLAIN, 16));
		txtCPF.setColumns(10);
		txtCPF.setBounds(370, 440, 350, 38);
		txtCPF.setText(String.valueOf(hops.getCpf()));
		contentPane.add(txtCPF);

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

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospedes hosp = new Hospedes();
				
				hosp.setIdHospede(ABORT);
				hosp.setNome(txtNome.getText());
				hosp.setCpf(txtCPF.getText());
				hosp.setNomeSocial(txtNome.getText());
				hospdao.atualizarHopesdes(hosp);
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBackground(new Color(240, 240, 240));
		btnAtualizar.setBounds(40, 500, 250, 35);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDeletar.setFocusPainted(false);
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setBounds(370, 500, 250, 35);
		contentPane.add(btnDeletar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprincipal = new TelaPrincipal(txtNome.getText(), cpf);
				dispose();
				telaprincipal.setResizable(false);
				telaprincipal.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(40, 242, 89, 23);
		contentPane.add(btnVoltar);

	}
}
