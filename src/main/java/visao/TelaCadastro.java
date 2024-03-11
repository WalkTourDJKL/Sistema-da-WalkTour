package visao;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class TelaCadastro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtDigiteSeuNome;
	private JTextField txtDigiteSeuCpf;

	/**
	 * Create the frame.
	 * 
	 * @param table
	 * @param listaEventos
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaCadastro() {
		setTitle("Tela Cadastro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1090);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel LadoJanela = new JPanel();
		LadoJanela.setBounds(568, 0, 1036, 881);
		contentPane.add(LadoJanela);
		LadoJanela.setLayout(null);
		
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setBounds(-58, 0, 1309, 895);
				LadoJanela.add(lblNewLabel_3);
				lblNewLabel_3.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/LadoB.png")));
				
				JButton btnNewButton = new JButton("");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnNewButton.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BotaoCadastrar.png")));
				btnNewButton.setForeground(new Color(255, 255, 128));
				btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
				btnNewButton.setBounds(65, 900, 486, 61);
				contentPane.add(btnNewButton);
				
				JLabel lblNewLabel = new JLabel("Cadastrar");
				lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel.setBounds(193, 21, 264, 67);
				contentPane.add(lblNewLabel);
				
				JLabel lbl_Nome = new JLabel("Nome Completo");
				lbl_Nome.setForeground(new Color(52, 64, 84));
				lbl_Nome.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_Nome.setBounds(53, 97, 515, 25);
				contentPane.add(lbl_Nome);
				
				textField = new JTextField();
				textField.setToolTipText("Digite sua senha");
				textField.setText("Digite sua senha...");
				textField.setForeground(new Color(102, 112, 133));
				textField.setFont(new Font("Corbel", Font.ITALIC, 15));
				textField.setColumns(10);
				textField.setBounds(53, 187, 515, 31);
				contentPane.add(textField);
				
				JLabel lbl_senha = new JLabel("Senha");
				lbl_senha.setForeground(new Color(52, 64, 84));
				lbl_senha.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_senha.setBounds(53, 163, 515, 25);
				contentPane.add(lbl_senha);
				
				txtDigiteSeuNome = new JTextField();
				txtDigiteSeuNome.setToolTipText("Digite seu CPF");
				txtDigiteSeuNome.setText("Digite seu Nome...");
				txtDigiteSeuNome.setForeground(new Color(102, 112, 133));
				txtDigiteSeuNome.setFont(new Font("Corbel", Font.ITALIC, 15));
				txtDigiteSeuNome.setColumns(10);
				txtDigiteSeuNome.setBounds(53, 121, 515, 31);
				contentPane.add(txtDigiteSeuNome);
				
				JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? cadastre-se");
				lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_1.setBounds(220, 980, 251, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
				lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_2.setBounds(95, 1000, 480, 40);
				contentPane.add(lblNewLabel_2);
				
				JLabel lbl_Genero = new JLabel("Gênero");
				lbl_Genero.setForeground(new Color(52, 64, 84));
				lbl_Genero.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_Genero.setBounds(53, 229, 125, 30);
				contentPane.add(lbl_Genero);
				
				JRadioButton rdbtnMas = new JRadioButton("Masculino");
				rdbtnMas.setFont(new Font("Corbel", Font.PLAIN, 13));
				rdbtnMas.setBounds(53, 254, 109, 23);
				contentPane.add(rdbtnMas);
				
				JRadioButton rdbtnFem = new JRadioButton("Feminino");
				rdbtnFem.setFont(new Font("Corbel", Font.PLAIN, 13));
				rdbtnFem.setBounds(184, 254, 109, 23);
				contentPane.add(rdbtnFem);
				
				JRadioButton rdbtnNInf = new JRadioButton("Não Informar");
				rdbtnNInf.setFont(new Font("Corbel", Font.PLAIN, 13));
				rdbtnNInf.setBounds(315, 254, 109, 23);
				contentPane.add(rdbtnNInf);
				
				JLabel lbl_DNasc = new JLabel("Data de Nascimento");
				lbl_DNasc.setForeground(new Color(52, 64, 84));
				lbl_DNasc.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_DNasc.setBounds(53, 284, 251, 30);
				contentPane.add(lbl_DNasc);
				
				JComboBox comboBoxDia = new JComboBox();
				comboBoxDia.setBounds(53, 312, 30, 22);
				contentPane.add(comboBoxDia);
				
				JComboBox comboBoxMes = new JComboBox();
				comboBoxMes.setBounds(184, 312, 30, 22);
				contentPane.add(comboBoxMes);
				
				JComboBox comboBoxAno = new JComboBox();
				comboBoxAno.setBounds(309, 312, 30, 22);
				contentPane.add(comboBoxAno);
				
				JLabel lbl_CPF = new JLabel("CPF");
				lbl_CPF.setForeground(new Color(52, 64, 84));
				lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_CPF.setBounds(53, 348, 60, 30);
				contentPane.add(lbl_CPF);
				
				txtDigiteSeuCpf = new JTextField();
				txtDigiteSeuCpf.setForeground(new Color(102, 112, 133));
				txtDigiteSeuCpf.setFont(new Font("Corbel", Font.ITALIC, 15));
				txtDigiteSeuCpf.setText("Digite seu CPF...");
				txtDigiteSeuCpf.setBounds(53, 377, 515, 31);
				contentPane.add(txtDigiteSeuCpf);
				txtDigiteSeuCpf.setColumns(10);
	}
}
