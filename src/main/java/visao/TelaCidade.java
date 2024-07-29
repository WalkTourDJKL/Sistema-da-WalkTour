package visao;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuarios;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSlider;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaCidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param cidadehosp
	 * @param hosp
	 * @param cidade
	 * @param estado
	 */
	public TelaCidade(Usuarios hosp, String cidade, String estado) {
		setTitle("Tela de " + cidade);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprincipal = new TelaPrincipal(hosp);
				dispose();
				telaprincipal.setResizable(false);
				telaprincipal.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setBounds(10, 240, 90, 25);
		contentPane.add(btnVoltar);

		JLabel lblNomeCidade = new JLabel(cidade);
		lblNomeCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCidade.setBounds(10, 276, 723, 40);
		lblNomeCidade.setFont(new Font("Tahoma", Font.BOLD, 46));
		contentPane.add(lblNomeCidade);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1424, 229);
		lblTitulo.setIcon(new ImageIcon(TelaCidade.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 5;
				TelaUsuario user = new TelaUsuario(hosp, null, cidade, tVolt, estado);
				dispose();
				user.setResizable(false);
				user.setVisible(true);

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1302, 11, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(hosp.getNome());
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(853, 64, 409, 23);
		contentPane.add(lblPerfil);

		JLabel lblImagemMaior = new JLabel("");
		lblImagemMaior.setBounds(10, 378, 1391, 323);

		// Carrega a imagem
		String cidadeS = cidade.replaceAll("\\s+", "");
		ImageIcon originalIcon = new ImageIcon(TelaCidade.class.getResource("/imgs/" + cidadeS + ".png"));

		// Redimensiona a imagem para caber no JLabel
		Image img = originalIcon.getImage();
		Image imgRedimensionada = img.getScaledInstance(lblImagemMaior.getWidth(), lblImagemMaior.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);

		// Define o �cone redimensionado no JLabel
		lblImagemMaior.setIcon(iconRedimensionado);

		// Adiciona o JLabel ao contentPane
		contentPane.add(lblImagemMaior);

		JButton btnProcurarQuarto = new JButton("");
		btnProcurarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHotel hotel = new TelaHotel(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
			}
		});
		btnProcurarQuarto.setIcon(new ImageIcon(TelaCidade.class.getResource("/imgs/btnBuscaQuarto.png")));
		btnProcurarQuarto.setBounds(974, 789, 427, 61);
		contentPane.add(btnProcurarQuarto);

		JLabel lblNomeCidade_1 = new JLabel(estado);
		lblNomeCidade_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCidade_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomeCidade_1.setBounds(10, 338, 723, 40);
		contentPane.add(lblNomeCidade_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 695, 448, 155);
		contentPane.add(panel);
		panel.setLayout(null);

		JComboBox<String> info1 = new JComboBox<String>();
		info1.setBounds(10, 11, 430, 30);
		panel.add(info1);

		info1.addItem("Informaca 1");
		info1.addItem("Localizado no Litoral catarinense, o One Tower é oficialmente o edifício");
		info1.addItem("mais alto do Brasil, segundo Council on Tall Buildings and Urban Habitat");

		JComboBox<String> info2 = new JComboBox<String>();
		info2.setBounds(10, 64, 430, 30);
		panel.add(info2);

		info2.addItem("Informaca 2");

		JComboBox<String> info3 = new JComboBox<String>();
		info3.setBounds(10, 119, 430, 30);
		panel.add(info3);

		info3.addItem("Informaca 3");
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(468, 695, 448, 155);
		contentPane.add(panel_1);

		JComboBox<String> info1_1 = new JComboBox<String>();
		info1_1.setBounds(10, 11, 430, 30);
		panel_1.add(info1_1);
		info1_1.addItem("Informaca 1");

		JComboBox<String> info2_1 = new JComboBox<String>();
		info2_1.setBounds(10, 64, 430, 30);
		panel_1.add(info2_1);
		info2_1.addItem("Informaca 2");

		JComboBox<String> info3_1 = new JComboBox<String>();
		info3_1.setBounds(10, 119, 430, 30);
		panel_1.add(info3_1);
		info3_1.addItem("Informaca 3");
	}
}
