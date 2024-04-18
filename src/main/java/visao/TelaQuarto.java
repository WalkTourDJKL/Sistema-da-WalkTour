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
        
        JLabel lblImgQuarto = new JLabel("");
        lblImgQuarto.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\quarto.png"));
        lblImgQuarto.setBounds(120, 294, 654, 545);
        contentPane.add(lblImgQuarto);
        
        JLabel lblDescricao = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        lblDescricao.setBounds(312, 754, 365, 21);
        contentPane.add(lblDescricao);
        
        JLabel lblNomeHotel = new JLabel("Quarto Casal Plus ");
        lblNomeHotel.setFont(new Font("Arial", Font.BOLD, 37));
        lblNomeHotel.setBounds(1068, 355, 345, 56);
        contentPane.add(lblNomeHotel);
        
        JLabel lblWifi = new JLabel("");
        lblWifi.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\WifiIcon.png"));
        lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblWifi.setBounds(1136, 498, 65, 32);
        contentPane.add(lblWifi);
        
        JLabel lblChave = new JLabel("");
        lblChave.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\Key.png"));
        lblChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblChave.setBounds(1300, 498, 98, 45);
        contentPane.add(lblChave);
        
        JLabel lblArCon = new JLabel("");
        lblArCon.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\ArCondicionado.png"));
        lblArCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblArCon.setBounds(1498, 498, 98, 68);
        contentPane.add(lblArCon);
        
        JLabel lblMaquinaCafe = new JLabel("");
        lblMaquinaCafe.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\MaquinaCafe.png"));
        lblMaquinaCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblMaquinaCafe.setBounds(1698, 478, 78, 72);
        contentPane.add(lblMaquinaCafe);
        
        JLabel lblCafe = new JLabel("");
        lblCafe.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\cafeIcon.png"));
        lblCafe.setBounds(1136, 647, 65, 78);
        contentPane.add(lblCafe);
        
        JLabel lblTv = new JLabel("");
        lblTv.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\Tv.png"));
        lblTv.setBounds(1300, 658, 78, 72);
        contentPane.add(lblTv);
        
        JLabel lblComputador = new JLabel("");
        lblComputador.setIcon(new ImageIcon("C:\\Users\\Aluno\\Desktop\\Sistema-da-WalkTour\\src\\main\\java\\imgs\\PcDisplay.png"));
        lblComputador.setBounds(1515, 645, 76, 89);
        contentPane.add(lblComputador);
        
        JLabel lblWifiGra = new JLabel("Wifi Grátis ");
        lblWifiGra.setFont(new Font("Arial", Font.PLAIN, 14));
        lblWifiGra.setBounds(1128, 577, 78, 14);
        contentPane.add(lblWifiGra);
        
        JLabel lblNewLabel_1 = new JLabel("Chave Digital");
        lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(1300, 577, 89, 25);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblArcondi = new JLabel("Ar-Condicional ");
        lblArcondi.setFont(new Font("Arial", Font.PLAIN, 14));
        lblArcondi.setBounds(1500, 577, 99, 25);
        contentPane.add(lblArcondi);
        
        JLabel lblCafé = new JLabel("Máquina de Café ");
        lblCafé.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCafé.setBounds(1685, 583, 115, 14);
        contentPane.add(lblCafé);
        
        JLabel lblCafeManha = new JLabel("Café da Manhã ");
        lblCafeManha.setFont(new Font("Arial", Font.PLAIN, 14));
        lblCafeManha.setBounds(1117, 735, 115, 21);
        contentPane.add(lblCafeManha);
        
        JLabel lblGratu = new JLabel("Gratuito");
        lblGratu.setFont(new Font("Arial", Font.PLAIN, 14));
        lblGratu.setBounds(1136, 757, 65, 14);
        contentPane.add(lblGratu);
    }
}
