package visao;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.ImageIcon;
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

public class TelaHotel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaHotel frame = new TelaHotel();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaHotel() {
        setTitle("Walktour");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1090);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNomeHotel = new JLabel("Walk Tour Gramado");
        lblNomeHotel.setBounds(960, 460, 498, 40);
        lblNomeHotel.setFont(new Font("Tahoma", Font.BOLD, 46));
        contentPane.add(lblNomeHotel);
        
        JLabel lblTitulo = new JLabel("");
        lblTitulo.setBounds(10, 0, 1063, 209);
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\titulo.png"));
        contentPane.add(lblTitulo);
        
        JLabel lblEndereço = new JLabel("");
        lblEndereço.setBounds(890, 600, 45, 30);
        lblEndereço.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\endereço.png"));
        contentPane.add(lblEndereço);
        
        JLabel lblTelefone = new JLabel("");
        lblTelefone.setBounds(890, 679, 46, 30);
        lblTelefone.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\telefone.png"));
        contentPane.add(lblTelefone);
        
        JLabel lblEmail = new JLabel("");
        lblEmail.setBounds(890, 756, 46, 30);
        lblEmail.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\email.png"));
        contentPane.add(lblEmail);
        
        JLabel lblImagemMaior = new JLabel("");
        lblImagemMaior.setBounds(250, 354, 600, 561);
        lblImagemMaior.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\imagemMaior2.png"));
        contentPane.add(lblImagemMaior);
        
        JLabel lblAcademia = new JLabel("");
        lblAcademia.setBounds(250, 870, 200, 140);
        lblAcademia.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\academia.png"));
        contentPane.add(lblAcademia);
        
        JLabel lblEntrada = new JLabel("");
        lblEntrada.setBounds(448, 870, 200, 140);
        lblEntrada.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\entrada.png"));
        contentPane.add(lblEntrada);
        
        JLabel lblQuarto = new JLabel("");
        lblQuarto.setBounds(645, 870, 200, 140);
        lblQuarto.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\quarto.png"));
        contentPane.add(lblQuarto);
        
        JLabel lblEnd = new JLabel("Rua XXXX, Nº XXX");
        lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEnd.setBounds(989, 590, 256, 52);
        contentPane.add(lblEnd);
        
        JLabel lblTel = new JLabel("+55 (99) 99999999");
        lblTel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTel.setBounds(989, 685, 256, 14);
        contentPane.add(lblTel);
        
        JLabel lblEmail2 = new JLabel("XX@XX.com");
        lblEmail2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblEmail2.setBounds(989, 749, 256, 40);
        contentPane.add(lblEmail2);
        
        JLabel lbliconePerfil = new JLabel("");
        lbliconePerfil.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\perfil.png"));
        lbliconePerfil.setBounds(1772, 35, 99, 95);
        contentPane.add(lbliconePerfil);
        
        JLabel lblNewLabel = new JLabel("User10637");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(1673, 78, 100, 14);
        contentPane.add(lblNewLabel);
    }
}
