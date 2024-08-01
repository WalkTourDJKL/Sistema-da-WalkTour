package visao;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import controle.MusicPlayer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

import modelo.Usuarios;
import javax.swing.JButton;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * 
	 * @param nome
	 * @param cpf
	 */
	public TelaPrincipal(Usuarios hosp) {

		setTitle("WalkTour - Principal");
		// MusicPlayer tocar = new MusicPlayer("/music/WalktourTheme.wav");
		// tocar.play();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1516, 229);
		lblTitulo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 1;
				TelaUsuario user = new TelaUsuario(hosp, null, null, tVolt, null);
				dispose();
				user.setResizable(false);
				user.setVisible(true);
				// tocar.stop();

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1262, 31, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(hosp.getNome());
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(853, 64, 409, 23);
		contentPane.add(lblPerfil);

		JPanel panel = new JPanel();

		JLabel lblImageCidade = new JLabel("");
		lblImageCidade.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/Blumenau.png")));
		lblImageCidade.setBounds(10, 11, 280, 225);
		panel.add(lblImageCidade);

		JLabel lblCidade = new JLabel("Blumenau");
		lblCidade.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade.setBackground(new Color(240, 240, 240));
		lblCidade.setBounds(10, 240, 117, 31);
		panel.add(lblCidade);

		JLabel lblEstado = new JLabel("Santa Catarina");
		lblEstado.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado.setBackground(UIManager.getColor("Button.background"));
		lblEstado.setBounds(10, 269, 160, 31);
		panel.add(lblEstado);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade.getText();
				String estado = lblEstado.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();

			}
		});
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(208, 232, 300, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();

		JLabel lblImageCidade_1 = new JLabel("");
		lblImageCidade_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/SaoFranciscoDoSul.png")));
		lblImageCidade_1.setBounds(10, 11, 280, 225);
		panel_1.add(lblImageCidade_1);

		JLabel lblCidade_1 = new JLabel("Sao Francisco do Sul");
		lblCidade_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade_1.setBackground(UIManager.getColor("Button.background"));
		lblCidade_1.setBounds(10, 240, 229, 31);
		panel_1.add(lblCidade_1);

		JLabel lblEstado_1 = new JLabel("Santa Catarina");
		lblEstado_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado_1.setBackground(UIManager.getColor("Button.background"));
		lblEstado_1.setBounds(10, 269, 160, 31);
		panel_1.add(lblEstado_1);

		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade_1.getText();
				String estado = lblEstado_1.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();
			}
		});
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(549, 232, 300, 300);
		contentPane.add(panel_1);

		JPanel panel_1_1 = new JPanel();

		JLabel lblImageCidade_1_1 = new JLabel("");
		lblImageCidade_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/BalnearioCamburiu.png")));
		lblImageCidade_1_1.setBounds(10, 11, 280, 225);
		panel_1_1.add(lblImageCidade_1_1);

		JLabel lblCidade_1_1 = new JLabel("Balneario Camburiu");
		lblCidade_1_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade_1_1.setBackground(UIManager.getColor("Button.background"));
		lblCidade_1_1.setBounds(10, 240, 229, 31);
		panel_1_1.add(lblCidade_1_1);

		JLabel lblEstado_1_1 = new JLabel("Santa Catarina");
		lblEstado_1_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado_1_1.setBackground(UIManager.getColor("Button.background"));
		lblEstado_1_1.setBounds(10, 269, 193, 31);
		panel_1_1.add(lblEstado_1_1);

		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade_1_1.getText();
				String estado = lblEstado_1_1.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();
			}
		});
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(896, 232, 300, 300);
		contentPane.add(panel_1_1);

		JPanel panel_1_1_1 = new JPanel();

		JLabel lblImageCidade_1_1_1 = new JLabel("");
		lblImageCidade_1_1_1.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/Canela.png")));
		lblImageCidade_1_1_1.setBounds(10, 11, 280, 225);
		panel_1_1_1.add(lblImageCidade_1_1_1);

		JLabel lblCidade_1_1_1 = new JLabel("Canela");
		lblCidade_1_1_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade_1_1_1.setBackground(UIManager.getColor("Button.background"));
		lblCidade_1_1_1.setBounds(10, 240, 229, 31);
		panel_1_1_1.add(lblCidade_1_1_1);

		JLabel lblEstado_1_1_1 = new JLabel("Rio Grande do Sul");
		lblEstado_1_1_1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado_1_1_1.setBackground(UIManager.getColor("Button.background"));
		lblEstado_1_1_1.setBounds(10, 269, 193, 31);
		panel_1_1_1.add(lblEstado_1_1_1);

		panel_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade_1_1_1.getText();
				String estado = lblEstado_1_1_1.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();
			}
		});
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_1.setBounds(208, 561, 300, 300);
		contentPane.add(panel_1_1_1);

		JPanel panel_1_1_2 = new JPanel();

		JLabel lblImageCidade_1_1_2 = new JLabel("");
		lblImageCidade_1_1_2.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/Gramado.png")));
		lblImageCidade_1_1_2.setBounds(10, 11, 280, 225);
		panel_1_1_2.add(lblImageCidade_1_1_2);

		JLabel lblCidade_1_1_2 = new JLabel("Gramado");
		lblCidade_1_1_2.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade_1_1_2.setBackground(UIManager.getColor("Button.background"));
		lblCidade_1_1_2.setBounds(10, 240, 229, 31);
		panel_1_1_2.add(lblCidade_1_1_2);

		JLabel lblEstado_1_1_2 = new JLabel("Rio Grande do Sul");
		lblEstado_1_1_2.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado_1_1_2.setBackground(UIManager.getColor("Button.background"));
		lblEstado_1_1_2.setBounds(10, 269, 193, 31);
		panel_1_1_2.add(lblEstado_1_1_2);
		panel_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade_1_1_2.getText();
				String estado = lblEstado_1_1_2.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();
			}
		});
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_2.setBounds(549, 561, 300, 300);
		contentPane.add(panel_1_1_2);

		JPanel panel_1_1_3 = new JPanel();

		JLabel lblImageCidade_1_1_3 = new JLabel("");
		lblImageCidade_1_1_3.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/BentoGoncalves.png")));
		lblImageCidade_1_1_3.setBounds(10, 11, 280, 225);
		panel_1_1_3.add(lblImageCidade_1_1_3);

		JLabel lblCidade_1_1_3 = new JLabel("Bento Goncalves");
		lblCidade_1_1_3.setFont(new Font("Corbel", Font.BOLD, 25));
		lblCidade_1_1_3.setBackground(UIManager.getColor("Button.background"));
		lblCidade_1_1_3.setBounds(10, 240, 229, 31);
		panel_1_1_3.add(lblCidade_1_1_3);

		JLabel lblEstado_1_1_3 = new JLabel("Rio Grande do Sul");
		lblEstado_1_1_3.setFont(new Font("Corbel", Font.BOLD, 25));
		lblEstado_1_1_3.setBackground(UIManager.getColor("Button.background"));
		lblEstado_1_1_3.setBounds(10, 269, 193, 31);
		panel_1_1_3.add(lblEstado_1_1_3);

		panel_1_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidade = lblCidade_1_1_3.getText();
				String estado = lblEstado_1_1_3.getText();
				TelaCidade hotel = new TelaCidade(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
				// tocar.stop();
			}
		});
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1_3.setBounds(896, 561, 300, 300);
		contentPane.add(panel_1_1_3);

		if (hosp.getTipoUser() == 1) {
			JButton btnRealizarAGesto = new JButton("Realizar a gest\u00E3o");
			btnRealizarAGesto.setForeground(Color.BLACK);
			btnRealizarAGesto.setFont(new Font("Krona One", Font.PLAIN, 18));
			btnRealizarAGesto.setFocusPainted(false);
			btnRealizarAGesto.setBackground(new Color(240, 240, 240));
			btnRealizarAGesto.setBounds(853, 52, 250, 35);
			btnRealizarAGesto.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int tVolt = 1;
					TelaGestao user = new TelaGestao(hosp, null, null, tVolt, null);
					dispose();
					user.setResizable(false);
					user.setVisible(true);
					// tocar.stop();

				}
			});
			contentPane.add(btnRealizarAGesto);
		}else {}

	}
}
