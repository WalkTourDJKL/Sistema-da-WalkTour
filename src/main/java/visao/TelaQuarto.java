package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaQuarto extends JFrame {
	private JPanel contentPane;

	public TelaQuarto(String tipo) {
		setTitle("Walktour");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(10, 0, 1063, 209);
		lblTitulo.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1312, 7, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(tipo);
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(901, 44, 409, 23);
		contentPane.add(lblPerfil);

		JLabel lblImgQuarto = new JLabel("");
		lblImgQuarto.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/quarto.png")));
		lblImgQuarto.setBounds(27, 296, 654, 545);
		contentPane.add(lblImgQuarto);

		JLabel lblDescricao = new JLabel(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		lblDescricao.setBounds(312, 754, 365, 21);
		contentPane.add(lblDescricao);

		JLabel lblNomeHotel = new JLabel("Quarto Casal Plus ");
		lblNomeHotel.setFont(new Font("Arial", Font.BOLD, 37));
		lblNomeHotel.setBounds(750, 327, 345, 56);
		contentPane.add(lblNomeHotel);

		JLabel lblWifi = new JLabel("");
		lblWifi.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/WifiIcon.png")));
		lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWifi.setBounds(750, 465, 65, 32);
		contentPane.add(lblWifi);

		JLabel lblChave = new JLabel("");
		lblChave.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Key.png")));
		lblChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChave.setBounds(914, 465, 98, 45);
		contentPane.add(lblChave);

		JLabel lblArCon = new JLabel("");
		lblArCon.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/ArCondicionado.png")));
		lblArCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArCon.setBounds(1112, 465, 98, 68);
		contentPane.add(lblArCon);

		JLabel lblMaquinaCafe = new JLabel("");
		lblMaquinaCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/MaquinaCafe.png")));
		lblMaquinaCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaquinaCafe.setBounds(1312, 445, 78, 72);
		contentPane.add(lblMaquinaCafe);

		JLabel lblCafe = new JLabel("");
		lblCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/cafeIcon.png")));
		lblCafe.setBounds(750, 614, 65, 78);
		contentPane.add(lblCafe);

		JLabel lblTv = new JLabel("");
		lblTv.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Tv.png")));
		lblTv.setBounds(914, 625, 78, 72);
		contentPane.add(lblTv);

		JLabel lblComputador = new JLabel("");
		lblComputador.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/PcDisplay.png")));
		lblComputador.setBounds(1129, 612, 76, 89);
		contentPane.add(lblComputador);

		JLabel lblWifiGra = new JLabel("Wifi Gratis ");
		lblWifiGra.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWifiGra.setBounds(742, 544, 78, 14);
		contentPane.add(lblWifiGra);

		JLabel lblNewLabel_1 = new JLabel("Chave Digital");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(914, 544, 89, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblArcondi = new JLabel("Ar-Condicional ");
		lblArcondi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblArcondi.setBounds(1114, 544, 99, 25);
		contentPane.add(lblArcondi);

		JLabel lblCafeMaq = new JLabel("M�quina de Cafe");
		lblCafeMaq.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCafeMaq.setBounds(1299, 550, 115, 14);
		contentPane.add(lblCafeMaq);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaQuartos telaQuartos  = new TelaQuartos(lblPerfil.getText(), null);
				dispose(); 
				telaQuartos.setExtendedState(MAXIMIZED_BOTH);
				telaQuartos.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(40, 220, 90, 25);
		contentPane.add(btnVoltar);
		
		JButton btnReservar = new JButton("");
		btnReservar.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/btnReservar.png")));
		btnReservar.setBounds(860, 771, 463, 56);
		contentPane.add(btnReservar);
		
		JLabel lblCafeManha = new JLabel("Café da Manhã");
		lblCafeManha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCafeManha.setBounds(730, 708, 99, 14);
		contentPane.add(lblCafeManha);
		
		JLabel lblgratis = new JLabel("Gratuito ");
		lblgratis.setFont(new Font("Arial", Font.PLAIN, 14));
		lblgratis.setBounds(1142, 728, 71, 14);
		contentPane.add(lblgratis);
		
		JLabel lbltv = new JLabel("TV HD 39’’");
		lbltv.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltv.setBounds(924, 708, 78, 14);
		contentPane.add(lbltv);
		
		JLabel lblComputadorr = new JLabel("Computador ");
		lblComputadorr.setFont(new Font("Arial", Font.PLAIN, 14));
		lblComputadorr.setBounds(1129, 708, 89, 14);
		contentPane.add(lblComputadorr);
	}
}