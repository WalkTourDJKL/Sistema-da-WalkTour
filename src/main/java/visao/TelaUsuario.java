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

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	public static JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtNomeSc;
	private HospedesDAO hospdao = HospedesDAO.getInstancia();
	private JTextField textID;

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
		lblUsurio.setBounds(25, 314, 163, 38);
		contentPane.add(lblUsurio);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Krona One", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBounds(192, 319, 321, 38);
		txtNome.setText(hops.getNome());
		contentPane.add(txtNome);

		JLabel lblCpf = new JLabel("CPF do hospede:");
		lblCpf.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblCpf.setBounds(27, 373, 163, 38);
		contentPane.add(lblCpf);

		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Krona One", Font.PLAIN, 12));
		txtCPF.setColumns(10);
		txtCPF.setBounds(194, 373, 345, 38);
		txtCPF.setText(String.valueOf(hops.getCpf()));
		contentPane.add(txtCPF);

		JLabel lblNomeSc = new JLabel("Nome social do hospede:");
		lblNomeSc.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblNomeSc.setBounds(26, 492, 98, 38);
		contentPane.add(lblNomeSc);

		txtNomeSc = new JTextField();
		txtNomeSc.setFont(new Font("Krona One", Font.PLAIN, 12));
		txtNomeSc.setColumns(10);
		txtNomeSc.setBounds(193, 497, 675, 38);
		txtNomeSc.setText(hops.getNomeSocial());
		contentPane.add(txtNomeSc);
/*
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hospedes hosp = new hospedes();
				
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
		btnAtualizar.setBackground(new Color(255, 218, 70));
		btnAtualizar.setBounds(348, 576, 251, 35);
		contentPane.add(btnAtualizar);*/
		
		JLabel lblId = new JLabel("Id do hospede:");
		lblId.setFont(new Font("Krona One", Font.PLAIN, 24));
		lblId.setBounds(25, 242, 147, 38);
		contentPane.add(lblId);
		
		textID = new JTextField();
		textID.setEditable(false);
		textID.setText((String) null);
		textID.setFont(new Font("Krona One", Font.PLAIN, 12));
		textID.setColumns(10);
		textID.setBounds(192, 242, 321, 38);
		contentPane.add(textID);
		textID.setText(String.valueOf(hops.getIdHospede()));

	}
}
