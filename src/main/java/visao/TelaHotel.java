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
        
        JLabel lblTitulo = new JLabel("");
        lblTitulo.setBounds(12, 12, 1084, 211);
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\Group 32.png"));
        contentPane.add(lblTitulo);
        
        JLabel lblNewLabel = new JLabel("Check-in:");
        lblNewLabel.setBounds(89, 288, 45, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblNomeHotel = new JLabel("Walk Tour Gramado");
        lblNomeHotel.setBounds(850, 500, 440, 40);
        lblNomeHotel.setFont(new Font("Tahoma", Font.PLAIN, 46));
        contentPane.add(lblNomeHotel);
        
        JLabel lblEndereco = new JLabel("");
        lblEndereco.setIcon(new ImageIcon("C:\\Users\\Aluno\\Downloads\\endereço.png"));
        lblEndereco.setBounds(875, 584, 46, 14);
        contentPane.add(lblEndereco);
    }
}
