package visao;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Usuarios;

import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param cidade
	 * @param hosp
	 * @param cidade
	 * @param estado 
	 */
	public TelaHotel(Usuarios hosp, String cidade, String estado) {
		setTitle("Tela Hotel de " + cidade);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCidade telaprincipal = new TelaCidade(hosp, cidade, estado);
				dispose();
				telaprincipal.setResizable(false);
				telaprincipal.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 240, 90, 25);
		contentPane.add(btnVoltar);

		JLabel lblNomeHotel = new JLabel("Walk Tour " + cidade);
		lblNomeHotel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeHotel.setBounds(701, 297, 723, 40);
		lblNomeHotel.setFont(new Font("Tahoma", Font.BOLD, 46));
		contentPane.add(lblNomeHotel);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1424, 229);
		lblTitulo.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 2; 
				TelaUsuario user = new TelaUsuario(hosp,null ,cidade,tVolt, estado);
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

		JLabel lblEndereco = new JLabel("");
		lblEndereco.setBounds(701, 440, 45, 30);
		lblEndereco.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/endereco.png")));
		contentPane.add(lblEndereco);

		JLabel lblTelefone = new JLabel("");
		lblTelefone.setBounds(701, 519, 46, 30);
		lblTelefone.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/telefone.png")));
		contentPane.add(lblTelefone);

		JLabel lblEmail = new JLabel("");
		lblEmail.setBounds(701, 596, 46, 30);
		lblEmail.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/email.png")));
		contentPane.add(lblEmail);

		JLabel lblImagemMaior = new JLabel("");
		lblImagemMaior.setBounds(60, 217, 600, 561);
		lblImagemMaior.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/imagemMaior.png")));
		contentPane.add(lblImagemMaior);

		JLabel lblAcademia = new JLabel("");
		lblAcademia.setBounds(60, 733, 200, 140);
		lblAcademia.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/academia.png")));
		contentPane.add(lblAcademia);

		JLabel lblEntrada = new JLabel("");
		lblEntrada.setBounds(258, 733, 200, 140);
		lblEntrada.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/entrada.png")));
		contentPane.add(lblEntrada);

		JLabel lblEnd = new JLabel("Rua XXXX, NÂº XXX");
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEnd.setBounds(800, 430, 256, 52);
		contentPane.add(lblEnd);

		JLabel lblTel = new JLabel("+55 (99) 99999999");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTel.setBounds(800, 525, 256, 14);
		contentPane.add(lblTel);

		JLabel lblEmail2 = new JLabel("XX@XX.com");
		lblEmail2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail2.setBounds(800, 589, 256, 40);
		contentPane.add(lblEmail2);

		JLabel lblQuadra = new JLabel("");
		lblQuadra.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/Group 57.png")));
		lblQuadra.setBounds(456, 751, 190, 106);
		contentPane.add(lblQuadra);

		JButton btnProcurarQuarto = new JButton("");
		btnProcurarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaQuartos telaquartos = new TelaQuartos(hosp, cidade,estado);
				dispose();
				telaquartos.setResizable(false);
				telaquartos.setVisible(true);
			}
		});
		btnProcurarQuarto.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/btnBuscaQuarto.png")));
		btnProcurarQuarto.setBounds(842, 715, 427, 61);
		contentPane.add(btnProcurarQuarto);
		
        
        JComboBox SobreOhotel = new JComboBox();
        SobreOhotel.setBounds(971, 440, 430, 30);
        contentPane.add(SobreOhotel);
        
        SobreOhotel.addItem("Sobre o Hotel");
        
        JComboBox Comodidades = new JComboBox();
        Comodidades.setBounds(971, 493, 430, 30);
        contentPane.add(Comodidades);
        
        Comodidades.addItem("Comodidades");

        
        JComboBox QuartosMaisReservados = new JComboBox();
        QuartosMaisReservados.setBounds(971, 548, 430, 30);
        contentPane.add(QuartosMaisReservados);
        
        QuartosMaisReservados.addItem("Quartos Mais Reservados");

        
        JComboBox Especificações = new JComboBox();
        Especificações.setBounds(971, 602, 430, 30);
        contentPane.add(Especificações);
 
        Especificações.addItem("Especificações e Regulamentações da Reserva");
	}
}
