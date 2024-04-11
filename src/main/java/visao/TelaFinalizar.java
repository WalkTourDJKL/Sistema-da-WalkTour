package visao; 
 
import java.awt.EventQueue; 
import java.awt.Font; 
 
import javax.swing.BorderFactory; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import javax.swing.border.EmptyBorder; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent; 
import javax.swing.JCheckBox; 
 
public class TelaFinalizar extends JFrame { 
	 
	private JPanel contentPane1; 
    private JTextField txt_digiNome; 
    private JTextField txt_digiTelefone; 
    private JTextField txt_digiEmail; 
    private JTextField txt_digiDocumento; 
    private JTextField txt_digiFormas; 
 
 
 
	private static final long serialVersionUID = 1L; 
	private JPanel contentPane; 
 
	/** 
	 * Launch the application. 
	 */ 
	public static void main(String[] args) { 
		EventQueue.invokeLater(new Runnable() { 
			public void run() { 
				try { 
					TelaFinalizar frame = new TelaFinalizar(); 
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
	public TelaFinalizar() { 
		setTitle("Walktour"); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setBounds(100, 100, 1920, 1090); 
        contentPane1 = new JPanel(); 
        contentPane1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); 
        setContentPane(contentPane1); 
        contentPane1.setLayout(null); 
         
        JPanel LadoJanela = new JPanel(); 
        LadoJanela.setBounds(0, 5, 1026, 850); 
        contentPane1.add(LadoJanela); 
        LadoJanela.setLayout(null); 
 
        JLabel lblNewLabel_3 = new JLabel(""); 
        lblNewLabel_3.setBounds(-257, 0, 1283, 895); 
        lblNewLabel_3.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/LadoA.png"))); 
        LadoJanela.add(lblNewLabel_3); 
         
        JLabel lblNewLabel = new JLabel("Finalizar Reserva"); 
        lblNewLabel.setBounds(1032, 54, 328, 67); 
        lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55)); 
        contentPane1.add(lblNewLabel); 
         
        JLabel lbl_nome = new JLabel("Nome"); 
        lbl_nome.setBounds(1036, 141, 422, 31); 
        lbl_nome.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_nome); 
 
        txt_digiNome = new JTextField(); 
        txt_digiNome.setBounds(1036, 179, 576, 25); 
        txt_digiNome.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiNome.setText("Digite seu nome..."); 
        contentPane1.add(txt_digiNome); 
        txt_digiNome.setColumns(10); 
         
        JLabel lbl_documento = new JLabel("Tipo e Número do Documento"); 
        lbl_documento.setBounds(1036, 227, 422, 31); 
        lbl_documento.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_documento); 
 
        txt_digiDocumento = new JTextField(); 
        txt_digiDocumento.setBounds(1036, 265, 576, 25); 
        txt_digiDocumento.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiDocumento.setText("Digite seu nome..."); 
        contentPane1.add(txt_digiDocumento); 
        txt_digiDocumento.setColumns(10); 
 
        JButton btnNewButton = new JButton(""); 
        btnNewButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        	} 
        }); 
        btnNewButton.setBounds(1036, 653, 576, 61); 
        btnNewButton.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/BotaoEntrar.png"))); 
        btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20)); 
        contentPane1.add(btnNewButton); 
 
        JLabel lbl_telefone = new JLabel("Telefone"); 
        lbl_telefone.setBounds(1036, 311, 576, 31); 
        lbl_telefone.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_telefone); 
 
        txt_digiTelefone = new JTextField(); 
        txt_digiTelefone.setBounds(1036, 343, 576, 25); 
        txt_digiTelefone.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiTelefone.setText("Digite seu telefone..."); 
        contentPane1.add(txt_digiTelefone); 
        txt_digiTelefone.setColumns(10); 
         
        JLabel lbl_email = new JLabel("Email"); 
        lbl_email.setBounds(1036, 394, 576, 31); 
        lbl_email.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_email); 
 
        txt_digiEmail = new JTextField(); 
        txt_digiEmail.setBounds(1036, 430, 576, 25); 
        txt_digiEmail.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiEmail.setText("Digite seu email..."); 
        contentPane1.add(txt_digiEmail); 
        txt_digiEmail.setColumns(10); 
         
        JLabel lbl_formas = new JLabel("Formas de Pagamento"); 
        lbl_formas.setBounds(1148, 486, 500, 31); 
        lbl_formas.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_formas); 
         
        JCheckBox checkBoxPix = new JCheckBox("PIX"); 
        checkBoxPix.setBounds(1148, 524, 97, 23); 
        contentPane1.add(checkBoxPix); 
         
        JCheckBox checkBoxBoleto = new JCheckBox("Boleto Parcelado"); 
        checkBoxBoleto.setBounds(1148, 561, 129, 23); 
        contentPane1.add(checkBoxBoleto); 
         
        JCheckBox checkBoxCartao = new JCheckBox("Cartão de Crédito"); 
        checkBoxCartao.setBounds(1149, 598, 160, 23); 
        contentPane1.add(checkBoxCartao); 
	} 
} 
