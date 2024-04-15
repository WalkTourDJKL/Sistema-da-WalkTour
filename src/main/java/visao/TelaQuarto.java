package visao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaQuarto extends JFrame {
	private JPanel contentPane;

	public TelaQuarto(String nome, String cpf) {
		setTitle("Walktour");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1920, 1090);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(10, 0, 1063, 209);
		lblTitulo.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaUsuario user = new TelaUsuario(cpf);
				dispose();
				user.setExtendedState(MAXIMIZED_BOTH);
				user.setVisible(true);

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1772, 35, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(nome);
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(1363, 68, 409, 23);
		contentPane.add(lblPerfil);

		JLabel lblImgQuarto = new JLabel("");
		lblImgQuarto.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/quarto.png")));
		lblImgQuarto.setBounds(120, 294, 654, 545);
		contentPane.add(lblImgQuarto);

		JLabel lblDescricao = new JLabel(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		lblDescricao.setBounds(312, 754, 365, 21);
		contentPane.add(lblDescricao);

		JLabel lblNomeHotel = new JLabel("Quarto Casal Plus ");
		lblNomeHotel.setFont(new Font("Arial", Font.BOLD, 37));
		lblNomeHotel.setBounds(1068, 355, 345, 56);
		contentPane.add(lblNomeHotel);

		JLabel lblWifi = new JLabel("");
		lblWifi.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/WifiIcon.png")));
		lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWifi.setBounds(1136, 498, 65, 32);
		contentPane.add(lblWifi);

		JLabel lblChave = new JLabel("");
		lblChave.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Key.png")));
		lblChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChave.setBounds(1300, 498, 98, 45);
		contentPane.add(lblChave);

		JLabel lblArCon = new JLabel("");
		lblArCon.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/ArCondicionado.png")));
		lblArCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArCon.setBounds(1498, 498, 98, 68);
		contentPane.add(lblArCon);

		JLabel lblMaquinaCafe = new JLabel("");
		lblMaquinaCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/MaquinaCafe.png")));
		lblMaquinaCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaquinaCafe.setBounds(1698, 478, 78, 72);
		contentPane.add(lblMaquinaCafe);

		JLabel lblCafe = new JLabel("");
		lblCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/cafeIcon.png")));
		lblCafe.setBounds(1136, 647, 65, 78);
		contentPane.add(lblCafe);

		JLabel lblTv = new JLabel("");
		lblTv.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Tv.png")));
		lblTv.setBounds(1300, 658, 78, 72);
		contentPane.add(lblTv);

		JLabel lblComputador = new JLabel("");
		lblComputador.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/PcDisplay.png")));
		lblComputador.setBounds(1515, 645, 76, 89);
		contentPane.add(lblComputador);

		JLabel lblWifiGra = new JLabel("Wifi Gratis ");
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

		JLabel lblCafeMaq = new JLabel("Máquina de Cafe");
		lblCafeMaq.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCafeMaq.setBounds(1685, 583, 115, 14);
		contentPane.add(lblCafeMaq);
	}
}
