package visao;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSlider;
import java.awt.TextArea;
import java.awt.Canvas;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import modelo.Usuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class TelaQuartos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param hosp 
	 * @param cidade 
	 * @param estado 
	 * 
	 * @param nome
	 * @param cpf
	 */

	public TelaQuartos(Usuarios hosp, String cidade, String estado) {
		setTitle("Tela de selecao de quartos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1516, 229);
		lblTitulo.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 3;
				TelaUsuario user = new TelaUsuario(hosp, null, cidade, tVolt, estado);
				dispose();
				user.setResizable(false);
				user.setVisible(true);
			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1772, 35, 99, 95);
		contentPane.add(lbliconePerfil);

		JPanel panel = new JPanel();

		JLabel lblImageQuarto1 = new JLabel("");
		lblImageQuarto1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/quartoStandardMini.png")));
		lblImageQuarto1.setBounds(10, 11, 280, 225);
		panel.add(lblImageQuarto1);

		JLabel lblQuarto1 = new JLabel("Quarto");
		lblQuarto1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblQuarto1.setBackground(new Color(240, 240, 240));
		lblQuarto1.setBounds(10, 240, 117, 31);
		panel.add(lblQuarto1);

		JLabel lblTipoQuarto1 = new JLabel("Standard");
		lblTipoQuarto1.setFont(new Font("Corbel", Font.BOLD, 25));
		lblTipoQuarto1.setBackground(UIManager.getColor("Button.background"));
		lblTipoQuarto1.setBounds(10, 269, 160, 31);
		panel.add(lblTipoQuarto1);

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tipo = lblTipoQuarto1.getText();
				TelaQuarto quarto = new TelaQuarto(tipo, hosp, cidade,estado);
				dispose();
				quarto.setResizable(false);
				quarto.setVisible(true);
				System.out.println(tipo);
				System.out.println();

			}
		});
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(135, 314, 300, 300);
		contentPane.add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();

		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(570, 314, 300, 300);
		contentPane.add(panel_1);

		JLabel lblImageCidade_1 = new JLabel("");
		lblImageCidade_1.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/quartoSuite ExecutivaMini.png")));
		lblImageCidade_1.setBounds(10, 11, 280, 225);
		panel_1.add(lblImageCidade_1);

		JLabel lblQuarto2 = new JLabel("Quarto");
		lblQuarto2.setFont(new Font("Corbel", Font.BOLD, 25));
		lblQuarto2.setBackground(UIManager.getColor("Button.background"));
		lblQuarto2.setBounds(10, 240, 229, 31);
		panel_1.add(lblQuarto2);

		JLabel lblTipoQuarto2 = new JLabel("Suite Executiva");
		lblTipoQuarto2.setFont(new Font("Corbel", Font.BOLD, 25));
		lblTipoQuarto2.setBackground(UIManager.getColor("Button.background"));
		lblTipoQuarto2.setBounds(10, 269, 180, 31);
		panel_1.add(lblTipoQuarto2);

		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tipo = lblTipoQuarto2.getText();
				TelaQuarto quarto = new TelaQuarto(tipo, hosp, cidade, estado);
				dispose();
				quarto.setResizable(false);
				quarto.setVisible(true);
				System.out.println(tipo);
			}

		});

		JPanel panel_1_1 = new JPanel();

		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1_1.setBounds(1005, 314, 300, 300);
		contentPane.add(panel_1_1);

		JLabel lblImageQuarto3 = new JLabel("");
		lblImageQuarto3.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/quartoDeluxeMini.png")));
		lblImageQuarto3.setBounds(10, 11, 280, 225);
		panel_1_1.add(lblImageQuarto3);

		JLabel lblQuarto3 = new JLabel("Quarto");
		lblQuarto3.setFont(new Font("Corbel", Font.BOLD, 25));
		lblQuarto3.setBackground(UIManager.getColor("Button.background"));
		lblQuarto3.setBounds(10, 240, 229, 31);
		panel_1_1.add(lblQuarto3);

		JLabel lblTipoQuarto3 = new JLabel("Deluxe");
		lblTipoQuarto3.setFont(new Font("Corbel", Font.BOLD, 25));
		lblTipoQuarto3.setBackground(UIManager.getColor("Button.background"));
		lblTipoQuarto3.setBounds(10, 269, 193, 31);
		panel_1_1.add(lblTipoQuarto3);
		panel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String tipo = lblTipoQuarto3.getText();
				TelaQuarto quarto = new TelaQuarto(tipo, hosp, cidade, estado);
				dispose();
				quarto.setResizable(false);
				quarto.setVisible(true);
				System.out.println(tipo);
			}
		});
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHotel telahotel = new TelaHotel(hosp, cidade, estado);
				dispose();
				telahotel.setResizable(false);
				telahotel.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(40, 242, 89, 23);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaQuartos.class.getResource("/imgs/Baixo.png")));
		lblNewLabel.setBounds(-16, 458, 1440, 418);
		contentPane.add(lblNewLabel);
	}
}