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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
 
public class TelaFinalizar extends JFrame { 
	 
	private JPanel contentPane1; 
    private JTextField txt_digiQuarto; 
    private JTextField txt_digiDataF; 
    private JTextField txt_digiQdtP; 
    private JTextField txt_digiDataI; 
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
        lblNewLabel.setBounds(1032, 54, 386, 67); 
        lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55)); 
        contentPane1.add(lblNewLabel); 
         
        JLabel lbl_quarto = new JLabel("Quarto Selecionado"); 
        lbl_quarto.setBounds(1036, 141, 422, 31); 
        lbl_quarto.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_quarto); 
 
        txt_digiQuarto = new JTextField(); 
        txt_digiQuarto.setBounds(1036, 179, 576, 25); 
        txt_digiQuarto.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiQuarto.setText(" "); 
        contentPane1.add(txt_digiQuarto); 
        txt_digiQuarto.setColumns(10); 
         
        JLabel lbl_dataI = new JLabel("Data Inicio"); 
        lbl_dataI.setBounds(1036, 227, 422, 31); 
        lbl_dataI.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_dataI); 
 
        txt_digiDataI = new JTextField(); 
        txt_digiDataI.setBounds(1036, 265, 576, 25); 
        txt_digiDataI.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiDataI.setText(" "); 
        contentPane1.add(txt_digiDataI); 
        txt_digiDataI.setColumns(10); 
        
        
 
        JButton btnNewButton = new JButton(""); 
        btnNewButton.addActionListener(new ActionListener() { 
        	public void actionPerformed(ActionEvent e) { 
        	} 
        }); 
        btnNewButton.setBounds(1036, 653, 576, 61); 
        btnNewButton.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/btnEntrar.png"))); 
        btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20)); 
        contentPane1.add(btnNewButton); 
        
        
 
        JLabel lbl_dataF = new JLabel("Data Fim"); 
        lbl_dataF.setBounds(1036, 311, 576, 31); 
        lbl_dataF.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_dataF); 
 
        txt_digiDataF = new JTextField(); 
        txt_digiDataF.setBounds(1036, 343, 576, 25); 
        txt_digiDataF.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiDataF.setText(" "); 
        contentPane1.add(txt_digiDataF); 
        txt_digiDataF.setColumns(10); 
        
        
         
        JLabel lbl_qtdP = new JLabel("Quantidade de Pessoas"); 
        lbl_qtdP.setBounds(1036, 394, 576, 31); 
        lbl_qtdP.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_qtdP); 
        
        String[] opcoesQuantidade = {"1", "2", "3"};
        JComboBox<String> comboBoxQuantidade = new JComboBox<>(opcoesQuantidade);
        comboBoxQuantidade.setBounds(1036,430, 576, 25);
        contentPane1.add(comboBoxQuantidade);
 
         
        
        ButtonGroup grupoFormasPagamento = new ButtonGroup();

        JRadioButton radioPIX = new JRadioButton("PIX");
        radioPIX.setBounds(1148, 524, 97, 23);
        contentPane1.add(radioPIX);
        grupoFormasPagamento.add(radioPIX);

        JRadioButton radioBoleto = new JRadioButton("Boleto Parcelado");
        radioBoleto.setBounds(1148, 561, 129, 23);
        contentPane1.add(radioBoleto);
        grupoFormasPagamento.add(radioBoleto);

        JRadioButton radioCartao = new JRadioButton("Cartão de Crédito");
        radioCartao.setBounds(1149, 598, 160, 23);
        contentPane1.add(radioCartao);
        grupoFormasPagamento.add(radioCartao);
	} 
} 
