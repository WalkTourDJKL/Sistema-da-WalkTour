package visao;
import java.awt.*;
import javax.swing.*;
public class TelaFinalizarReservas extends JFrame {
    private JPanel contentPane;
    private JTextField txt_digiCPF;
    private JTextField txt_digiSenha;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaFinalizarReservas frame = new TelaFinalizarReservas();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaFinalizarReservas() {
        setTitle("Walktour");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1090);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel LadoJanela = new JPanel();
        LadoJanela.setBounds(0, 5, 1026, 850);
        contentPane.add(LadoJanela);
        LadoJanela.setLayout(null);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setBounds(-257, 0, 1283, 895);
        lblNewLabel_3.setIcon(new ImageIcon(TelaFinalizarReservas.class.getResource("/imgs/LadoA.png")));
        LadoJanela.add(lblNewLabel_3);

        JLabel lblNewLabel = new JLabel("Entrar");
        lblNewLabel.setBounds(1031, 129, 149, 67);
        lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 55));
        contentPane.add(lblNewLabel);

        JLabel lbl_CPF = new JLabel("CPF");
        lbl_CPF.setBounds(1185, 165, 422, 31);
        lbl_CPF.setFont(new Font("Corbel", Font.BOLD, 25));
        contentPane.add(lbl_CPF);

        txt_digiCPF = new JTextField();
        txt_digiCPF.setBounds(1031, 201, 576, 25);
        txt_digiCPF.setFont(new Font("Corbel", Font.BOLD, 15));
        txt_digiCPF.setText("Digite seu CPF...");
        contentPane.add(txt_digiCPF);
        txt_digiCPF.setColumns(10);

        JButton btnNewButton = new JButton("");
        btnNewButton.setBounds(1031, 374, 576, 61);
        btnNewButton.setIcon(new ImageIcon(TelaFinalizarReservas.class.getResource("/imgs/BotaoEntrar.png")));
        btnNewButton.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
        contentPane.add(btnNewButton);

        JLabel lbl_senha = new JLabel("Senha");
        lbl_senha.setBounds(1031, 268, 576, 31);
        lbl_senha.setFont(new Font("Corbel", Font.BOLD, 25));
        contentPane.add(lbl_senha);

        txt_digiSenha = new JTextField();
        txt_digiSenha.setBounds(1031, 304, 576, 25);
        txt_digiSenha.setFont(new Font("Corbel", Font.BOLD, 15));
        txt_digiSenha.setText("Digite sua senha...");
        contentPane.add(txt_digiSenha);
        txt_digiSenha.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Não tem cadastro? ");
        lblNewLabel_1.setBounds(1185, 444, 109, 18);
        lblNewLabel_1.setFont(new Font("Corbel", Font.ITALIC, 14));
        contentPane.add(lblNewLabel_1);

        JButton btnNewButton_1 = new JButton("cadastre-se");
        btnNewButton_1.setBounds(1299, 440, 97, 27);
        btnNewButton_1.setFont(new Font("Corbel", Font.ITALIC, 14));
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_2 = new JLabel("Ao continuar com o acesso, \n você concorda com nossa \n política de privacidade ");
        lblNewLabel_2.setBounds(1104, 472, 430, 18);
        lblNewLabel_2.setFont(new Font("Corbel", Font.ITALIC, 14));
        contentPane.add(lblNewLabel_2);
    }
}
