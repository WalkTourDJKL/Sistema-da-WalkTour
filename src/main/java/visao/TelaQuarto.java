package visao;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaQuarto extends JFrame {
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage frame = new HomePage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaQuarto() {
        setTitle("Walktour");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1920, 1090);
        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblTitulo = new JLabel("");
        lblTitulo.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\titulo.png"));
        lblTitulo.setBounds(10, 11, 1063, 250);
        contentPane.add(lblTitulo);
        
        JLabel lblIcon = new JLabel("");
        lblIcon.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\target\\classes\\imgs\\perfil.png"));
        lblIcon.setBounds(1772, 35, 99, 95);
        contentPane.add(lblIcon);
        
        JLabel lblNewLabel = new JLabel("User10637");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(1685, 76, 100, 14);
        contentPane.add(lblNewLabel);
        
        JLabel lblImgQuarto = new JLabel("New label");
        lblImgQuarto.setBounds(419, 420, 46, 14);
        contentPane.add(lblImgQuarto);
        
        JLabel lblDescricao = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        lblDescricao.setBounds(312, 754, 365, 21);
        contentPane.add(lblDescricao);
        
        JLabel lblNomeHotel = new JLabel("Titulo");
        lblNomeHotel.setFont(new Font("Arial", Font.BOLD, 37));
        lblNomeHotel.setBounds(1068, 355, 120, 56);
        contentPane.add(lblNomeHotel);
        
        JLabel lblWifi = new JLabel("Wifi Gratuito");
        lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblWifi.setBounds(907, 498, 98, 18);
        contentPane.add(lblWifi);
        
        JLabel lblChave = new JLabel("Chave Digital");
        lblChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblChave.setBounds(1124, 503, 115, 25);
        contentPane.add(lblChave);
        
        JLabel lblArCon = new JLabel("Ar-Condicionado");
        lblArCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblArCon.setBounds(1330, 511, 198, 18);
        contentPane.add(lblArCon);
        
        JLabel lblMaquinaCafe = new JLabel("Máquina de Café");
        lblMaquinaCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMaquinaCafe.setBounds(1564, 516, 154, 18);
        contentPane.add(lblMaquinaCafe);
    }
}
