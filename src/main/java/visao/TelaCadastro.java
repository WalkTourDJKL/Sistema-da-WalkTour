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

public class TelaCadastro extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		setTitle("Tela Login");
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
				btnNewButton.setIcon(new ImageIcon(TelaCadastro.class.getResource("/imgs/BotaoCadastrar.png")));
				btnNewButton.setForeground(new Color(255, 255, 128));
				btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 20));
				btnNewButton.setBounds(72, 360, 486, 61);
				contentPane.add(btnNewButton);
				
				JLabel lblNewLabel = new JLabel("Entrar");
				lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
				lblNewLabel.setBackground(Color.WHITE);
				lblNewLabel.setBounds(241, 140, 163, 67);
				contentPane.add(lblNewLabel);
				
				JLabel lbl_CPF = new JLabel("Nome Completo");
				lbl_CPF.setForeground(new Color(52, 64, 84));
				lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_CPF.setBounds(53, 197, 515, 25);
				contentPane.add(lbl_CPF);
				
				textField = new JTextField();
				textField.setToolTipText("Digite sua senha");
				textField.setText("Digite sua senha...");
				textField.setForeground(new Color(102, 112, 133));
				textField.setFont(new Font("Corbel", Font.BOLD, 15));
				textField.setColumns(10);
				textField.setBounds(53, 287, 515, 31);
				contentPane.add(textField);
				
				JLabel lbl_senha = new JLabel("Senha");
				lbl_senha.setForeground(new Color(52, 64, 84));
				lbl_senha.setFont(new Font("Corbel", Font.BOLD, 25));
				lbl_senha.setBounds(53, 263, 515, 25);
				contentPane.add(lbl_senha);
				
				textField_1 = new JTextField();
				textField_1.setToolTipText("Digite seu CPF");
				textField_1.setText("Digite seu CPF...");
				textField_1.setForeground(new Color(102, 112, 133));
				textField_1.setFont(new Font("Corbel", Font.BOLD, 15));
				textField_1.setColumns(10);
				textField_1.setBounds(53, 221, 515, 31);
				contentPane.add(textField_1);
				
				JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? cadastre-se");
				lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_1.setBounds(227, 462, 251, 14);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNewLabel_2 = new JLabel("Ao continuar com o acesso, \n\r\nvocê concorda com nossa \n\r\npolítica de privacidade ");
				lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
				lblNewLabel_2.setBounds(83, 487, 450, 40);
				contentPane.add(lblNewLabel_2);
	}
}
