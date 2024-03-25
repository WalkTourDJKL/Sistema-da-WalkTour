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
import javax.swing.JButton;

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
        
        JLabel lblNewLabel = new JLabel("User10637");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(1673, 78, 100, 14);
        contentPane.add(lblNewLabel);
        
        JComboBox SobreOhotel = new JComboBox();
        SobreOhotel.setBounds(890, 839, 530, 30);
        contentPane.add(SobreOhotel);
        
        SobreOhotel.addItem("Sobre o Hotel");
        
        JComboBox Comodidades = new JComboBox();
        Comodidades.setBounds(890, 880, 530, 30);
        contentPane.add(Comodidades);
        
        Comodidades.addItem("Comodidades");

        
        JComboBox QuartosMaisReservados = new JComboBox();
        QuartosMaisReservados.setBounds(890, 922, 530, 30);
        contentPane.add(QuartosMaisReservados);
        
        QuartosMaisReservados.addItem("Quartos Mais Reservados");

        
        JComboBox Especificações = new JComboBox();
        Especificações.setBounds(890, 963, 530, 30);
        contentPane.add(Especificações);
 
        Especificações.addItem("Especificações e Regulamentações da Reserva");
        
        JButton btnProcurarQuarto = new JButton("Procurar Quarto para Reservar");
        btnProcurarQuarto.setBounds(1500, 271, 253, 35);
        contentPane.add(btnProcurarQuarto);
        
        JLabel lblUser = new JLabel("");
        lblUser.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\perfil.png"));
        lblUser.setBounds(1781, 50, 110, 96);
        contentPane.add(lblUser);
        
        JLabel lblImgMaior = new JLabel("New label");
        lblImgMaior.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\hotel.png"));
        lblImgMaior.setBounds(250, 354, 600, 500);
        contentPane.add(lblImgMaior);
        
        JLabel lblAcademia = new JLabel("");
        lblAcademia.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\academia.png"));
        lblAcademia.setBounds(250, 855, 200, 120);
        contentPane.add(lblAcademia);
        
        JLabel lblEntrada = new JLabel("");
        lblEntrada.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\entrada.png"));
        lblEntrada.setBounds(450, 855, 200, 120);
        contentPane.add(lblEntrada);
        
        JLabel lblQuarto = new JLabel("");
        lblQuarto.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\cama.png"));
        lblQuarto.setBounds(649, 855, 200, 120);
        contentPane.add(lblQuarto);
        
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(260, 976, 17, 48);
        contentPane.add(scrollBar);
        
        JLabel lblCheckIn = new JLabel("Check-In: ");
        lblCheckIn.setFont(new Font("Arial", Font.PLAIN, 28));
        lblCheckIn.setBounds(124, 281, 135, 22);
        contentPane.add(lblCheckIn);
        
        JLabel lblCheckOut = new JLabel("Check-Out:");
        lblCheckOut.setFont(new Font("Arial", Font.PLAIN, 28));
        lblCheckOut.setBounds(550, 281, 145, 22);
        contentPane.add(lblCheckOut);
        
        JLabel lblCalenCheckOut = new JLabel("");
        lblCalenCheckOut.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\CalendarMinus.png"));
        lblCalenCheckOut.setBounds(700, 271, 65, 45);
        contentPane.add(lblCalenCheckOut);
        
        JLabel lblAdulto = new JLabel("Adulto:");
        lblAdulto.setFont(new Font("Arial", Font.PLAIN, 28));
        lblAdulto.setBounds(960, 281, 95, 22);
        contentPane.add(lblAdulto);
        
        JLabel lblIconAdulto = new JLabel("");
        lblIconAdulto.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\Vector.png"));
        lblIconAdulto.setBounds(1065, 271, 54, 45);
        contentPane.add(lblIconAdulto);
        
        JLabel lblCrianca = new JLabel("Criança:");
        lblCrianca.setFont(new Font("Arial", Font.PLAIN, 28));
        lblCrianca.setBounds(1276, 281, 112, 22);
        contentPane.add(lblCrianca);
        
        JLabel lblCalenCheckIn = new JLabel("");
        lblCalenCheckIn.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\CalendarMinus.png"));
        lblCalenCheckIn.setBounds(250, 271, 65, 45);
        contentPane.add(lblCalenCheckIn);
        
        JLabel lblQtdAdult = new JLabel("");
        lblQtdAdult.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\pessoa.png"));
        lblQtdAdult.setBounds(1065, 265, 55, 50);
        contentPane.add(lblQtdAdult);
        
        JLabel lblQtdCri = new JLabel("");
        lblQtdCri.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\resources\\imgs\\pessoa.png"));
        lblQtdCri.setBounds(1398, 271, 54, 45);
        contentPane.add(lblQtdCri);

        
    }
}
