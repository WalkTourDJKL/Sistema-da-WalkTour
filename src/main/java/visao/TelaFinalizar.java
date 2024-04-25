package visao; 
 
import java.awt.EventQueue; 
import java.awt.Font;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory; 
import javax.swing.ImageIcon; 
import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JTextField; 
import javax.swing.border.EmptyBorder;

import controle.HospedesDAO;
import modelo.hospedes;
import controle.ReservaDAO;
import modelo.reserva;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent; 
import javax.swing.JCheckBox; 
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.util.*;
import java.sql.*;
 
public class TelaFinalizar extends JFrame { 
	 
	private JPanel contentPane1; 
    private JTextField txt_digiDataF; 
    private JTextField txt_digiDataI; 
    private JTextField txt_digiFormas; 
 
 
 
	private static final long serialVersionUID = 1L; 
	private JPanel contentPane;
	protected AbstractButton txtDigiteSeuNomeSocial;
	protected AbstractButton txtDigiteSeuNome;
	protected AbstractButton txtDigiteSeuCpf;
	protected AbstractButton formattedTextFieldDataNascimento; 
 
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
         
        JLabel lbl_dataI = new JLabel("Data Inicio"); 
        lbl_dataI.setBounds(1036, 132, 422, 31); 
        lbl_dataI.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_dataI); 
 
        txt_digiDataI = new JTextField(); 
        txt_digiDataI.setBounds(1036, 174, 576, 25); 
        txt_digiDataI.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiDataI.setText(" "); 
        contentPane1.add(txt_digiDataI); 
        txt_digiDataI.setColumns(10); 
        
 
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String dataInicio = txt_digiDataI.getText();
                String dataFim = txt_digiDataI.getText();
                AbstractButton txt_digiPreco = null;
				String preco = txt_digiPreco.getText();
                String formaPagamento = txt_digiFormas.getText();
                

                reserva reserva = new reserva();

                try {
                    SimpleDateFormat formatador = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date dataInicioFormatadaUtil = formatador.parse(dataInicio);
                    java.sql.Date dataInicioFormatadaSql = new java.sql.Date(dataInicioFormatadaUtil.getTime());
                    reserva.setDataIn(dataInicioFormatadaSql);

                    java.util.Date dataFimFormatadaUtil = formatador.parse(dataFim);
                    java.sql.Date dataFimFormatadaSql = new java.sql.Date(dataFimFormatadaUtil.getTime());
                    reserva.setDataOut(dataFimFormatadaSql);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                reserva.setPreco(Float.parseFloat(preco));
                reserva.setFormaPag(formaPagamento);

                ReservaDAO dao = ReservaDAO.getInstancia();
                dao.inserirReserva(reserva);
            }
        });
        btnNewButton_1.setBounds(1036, 607, 576, 61);
        btnNewButton_1.setIcon(new ImageIcon(TelaFinalizar.class.getResource("/imgs/btnFinalizar.png")));
        btnNewButton_1.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
        contentPane1.add(btnNewButton_1);

 
        JLabel lbl_dataF = new JLabel("Data Fim"); 
        lbl_dataF.setBounds(1036, 233, 576, 31); 
        lbl_dataF.setFont(new Font("Corbel", Font.BOLD, 25)); 
        contentPane1.add(lbl_dataF); 
 
        txt_digiDataF = new JTextField(); 
        txt_digiDataF.setBounds(1036, 275, 576, 25); 
        txt_digiDataF.setFont(new Font("Corbel", Font.BOLD, 15)); 
        txt_digiDataF.setText(" "); 
        contentPane1.add(txt_digiDataF); 
        txt_digiDataF.setColumns(10);
         
         
        ButtonGroup grupoFormasPagamento = new ButtonGroup();
        JRadioButton radioPIX = new JRadioButton("PIX");
        radioPIX.setBounds(1147, 515, 97, 23);
        contentPane1.add(radioPIX);
        grupoFormasPagamento.add(radioPIX);

        JRadioButton radioBoleto = new JRadioButton("Boleto Parcelado");
        radioBoleto.setBounds(1147, 555, 129, 23);
        contentPane1.add(radioBoleto);
        grupoFormasPagamento.add(radioBoleto);

        JRadioButton radioCartao = new JRadioButton("Cartão de Crédito");
        radioCartao.setBounds(1147, 477, 160, 23);
        contentPane1.add(radioCartao);
        grupoFormasPagamento.add(radioCartao);
        
        JLabel lbl_forma = new JLabel("Formas de Pagamento");
        lbl_forma.setFont(new Font("Corbel", Font.BOLD, 25));
        lbl_forma.setBounds(1036, 439, 576, 31);
        contentPane1.add(lbl_forma);
                
        JLabel lbl_preco = new JLabel("Preço");
        lbl_preco.setFont(new Font("Corbel", Font.BOLD, 25));
        lbl_preco.setBounds(1036, 332, 576, 31);
        contentPane1.add(lbl_preco);
	} 
}
