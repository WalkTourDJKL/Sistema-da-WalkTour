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
	private JTextField txtDigiteSeuEmail;
	private JTextField txtDigiteSeuTelefone;

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
		LadoJanela.setBounds(760, 0, 1335, 1055);
		contentPane.add(LadoJanela);
		LadoJanela.setLayout(null);
		
				JLabel lblNewLabel_3 = new JLabel("");
				lblNewLabel_3.setBounds(5, 0, 1380, 1050);
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
				btnNewButton.setBounds(159, 861, 486, 61);
				contentPane.add(btnNewButton);
				
				JLabel lblNewLabel = new JLabel("Cadastrar");
				lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 65));
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel.setBounds(293, 35, 320, 94);
				contentPane.add(lblNewLabel);
				
				JLabel lbl_Nome = new JLabel("Nome Completo");
				lbl_Nome.setForeground(new Color(52, 64, 84));
				lbl_Nome.setFont(new Font("Corbel", Font.BOLD, 35));
				lbl_Nome.setBounds(145, 148, 515, 44);
				contentPane.add(lbl_Nome);
				
				textField = new JTextField();
				textField.setToolTipText("Digite sua senha");
				textField.setText("Digite sua senha...");
				textField.setForeground(new Color(102, 112, 133));
				textField.setFont(new Font("Corbel", Font.ITALIC, 17));
				textField.setColumns(10);
				textField.setBounds(145, 286, 515, 39);
				contentPane.add(textField);
				
				JLabel lbl_senha = new JLabel("Senha");
				lbl_senha.setForeground(new Color(52, 64, 84));
				lbl_senha.setFont(new Font("Corbel", Font.BOLD, 35));
				lbl_senha.setBounds(145, 253, 515, 37);
				contentPane.add(lbl_senha);
				
				txtDigiteSeuNome = new JTextField();
				txtDigiteSeuNome.setToolTipText("Digite seu Nome...");
				txtDigiteSeuNome.setText("Digite seu Nome...");
				txtDigiteSeuNome.setForeground(new Color(102, 112, 133));
				txtDigiteSeuNome.setFont(new Font("Corbel", Font.ITALIC, 17));
				txtDigiteSeuNome.setColumns(10);
				txtDigiteSeuNome.setBounds(145, 189, 515, 39);
				contentPane.add(txtDigiteSeuNome);
				
				JLabel lblNewLabel_1 = new JLabel("Já é Cadastrado? Faça Login");
				lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_1.setBounds(322, 944, 180, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
				lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_2.setBounds(188, 961, 480, 40);
				contentPane.add(lblNewLabel_2);
				
				JLabel lbl_Genero = new JLabel("Gênero");
				lbl_Genero.setForeground(new Color(52, 64, 84));
				lbl_Genero.setFont(new Font("Corbel", Font.BOLD, 35));
				lbl_Genero.setBounds(145, 344, 125, 44);
				contentPane.add(lbl_Genero);
				
				JRadioButton rdbtnMas = new JRadioButton("Masculino");
				rdbtnMas.setFont(new Font("Corbel", Font.PLAIN, 16));
				rdbtnMas.setBounds(145, 384, 109, 23);
				contentPane.add(rdbtnMas);
				
				JRadioButton rdbtnFem = new JRadioButton("Feminino");
				rdbtnFem.setFont(new Font("Corbel", Font.PLAIN, 16));
				rdbtnFem.setBounds(276, 384, 109, 23);
				contentPane.add(rdbtnFem);
				
				JRadioButton rdbtnNInf = new JRadioButton("Não Informar");
				rdbtnNInf.setFont(new Font("Corbel", Font.PLAIN, 16));
				rdbtnNInf.setBounds(407, 384, 136, 23);
				contentPane.add(rdbtnNInf);
				
				JLabel lbl_DNasc = new JLabel("Data de Nascimento");
				lbl_DNasc.setForeground(new Color(52, 64, 84));
				lbl_DNasc.setFont(new Font("Corbel", Font.BOLD, 35));
				lbl_DNasc.setBounds(145, 423, 344, 44);
				contentPane.add(lbl_DNasc);
				
				JComboBox comboBoxDia = new JComboBox();
				comboBoxDia.setBounds(145, 464, 30, 22);
				contentPane.add(comboBoxDia);
				
				JComboBox comboBoxMes = new JComboBox();
				comboBoxMes.setBounds(276, 464, 30, 22);
				contentPane.add(comboBoxMes);
				
				JComboBox comboBoxAno = new JComboBox();
				comboBoxAno.setBounds(407, 464, 30, 22);
				contentPane.add(comboBoxAno);
				
				JLabel lbl_CPF = new JLabel("CPF");
				lbl_CPF.setForeground(new Color(52, 64, 84));
				lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 35));
				lbl_CPF.setBounds(145, 506, 80, 50);
				contentPane.add(lbl_CPF);
				
				txtDigiteSeuCpf = new JTextField();
				txtDigiteSeuCpf.setForeground(new Color(102, 112, 133));
				txtDigiteSeuCpf.setFont(new Font("Corbel", Font.ITALIC, 17));
				txtDigiteSeuCpf.setText("Digite seu CPF...");
				txtDigiteSeuCpf.setBounds(145, 547, 515, 39);
				contentPane.add(txtDigiteSeuCpf);
				txtDigiteSeuCpf.setColumns(10);
				
				JLabel lblNewLabel_4 = new JLabel("E-mail");
				lblNewLabel_4.setForeground(new Color(52, 64, 84));
				lblNewLabel_4.setFont(new Font("Corbel", Font.BOLD, 35));
				lblNewLabel_4.setBounds(145, 609, 120, 50);
				contentPane.add(lblNewLabel_4);
				
				txtDigiteSeuEmail = new JTextField();
				txtDigiteSeuEmail.setForeground(new Color(102, 112, 133));
				txtDigiteSeuEmail.setFont(new Font("Corbel", Font.ITALIC, 17));
				txtDigiteSeuEmail.setText("Digite seu E-mail...");
				txtDigiteSeuEmail.setBounds(145, 653, 515, 39);
				contentPane.add(txtDigiteSeuEmail);
				txtDigiteSeuEmail.setColumns(10);
				
				JLabel lblNewLabel_5 = new JLabel("Telefone");
				lblNewLabel_5.setForeground(new Color(52, 64, 84));
				lblNewLabel_5.setFont(new Font("Corbel", Font.BOLD, 35));
				lblNewLabel_5.setBounds(145, 711, 160, 50);
				contentPane.add(lblNewLabel_5);
				
				txtDigiteSeuTelefone = new JTextField();
				txtDigiteSeuTelefone.setForeground(new Color(102, 112, 133));
				txtDigiteSeuTelefone.setText("Digite seu Telefone...");
				txtDigiteSeuTelefone.setFont(new Font("Corbel", Font.ITALIC, 17));
				txtDigiteSeuTelefone.setBounds(145, 754, 515, 39);
				contentPane.add(txtDigiteSeuTelefone);
				txtDigiteSeuTelefone.setColumns(10);
	}
}
