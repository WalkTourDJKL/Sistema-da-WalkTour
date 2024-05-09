package visao;

import javax.swing.*;

import controle.ModeloQuartoDAO;
import modelo.Usuarios;
import modelo.ModeloQuarto;
import modelo.Quarto;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaQuarto extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private ModeloQuartoDAO modeqdao = ModeloQuartoDAO.getInstancia();

	public TelaQuarto(String tipo, Usuarios hosp, String cidade) {
		setTitle("Tela do quarto de " + cidade);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1424, 234);
		lblTitulo.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 4;
				TelaUsuario user = new TelaUsuario(hosp, tipo, cidade, tVolt);
				dispose();
				user.setResizable(false);
				user.setVisible(true);

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1312, 7, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(hosp.getNome());
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(901, 44, 409, 23);
		contentPane.add(lblPerfil);

		JLabel lblImgQuarto = new JLabel("");
		lblImgQuarto.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/quarto" + tipo + ".png")));
		lblImgQuarto.setBounds(55, 305, 654, 545);
		contentPane.add(lblImgQuarto);

		JLabel lblDescricao = new JLabel(
				"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
		lblDescricao.setBounds(312, 754, 365, 21);
		contentPane.add(lblDescricao);

		JLabel lblNomeHotel = new JLabel("Quarto " + tipo);
		lblNomeHotel.setFont(new Font("Arial", Font.BOLD, 37));
		lblNomeHotel.setBounds(750, 327, 583, 56);
		contentPane.add(lblNomeHotel);

		JLabel lblWifi = new JLabel("");
		lblWifi.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/WifiIcon.png")));
		lblWifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWifi.setBounds(780, 389, 65, 32);
		contentPane.add(lblWifi);

		JLabel lblChave = new JLabel("");
		lblChave.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Key.png")));
		lblChave.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblChave.setBounds(944, 389, 98, 45);
		contentPane.add(lblChave);

		JLabel lblArCon = new JLabel("");
		lblArCon.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/ArCondicionado.png")));
		lblArCon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblArCon.setBounds(1112, 389, 98, 68);
		contentPane.add(lblArCon);

		JLabel lblMaquinaCafe = new JLabel("");
		lblMaquinaCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/MaquinaCafe.png")));
		lblMaquinaCafe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMaquinaCafe.setBounds(1312, 369, 78, 72);
		contentPane.add(lblMaquinaCafe);

		JLabel lblCafe = new JLabel("");
		lblCafe.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/cafeIcon.png")));
		lblCafe.setBounds(780, 538, 65, 78);
		contentPane.add(lblCafe);

		JLabel lblTv = new JLabel("");
		lblTv.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/Tv.png")));
		lblTv.setBounds(944, 549, 78, 72);
		contentPane.add(lblTv);

		JLabel lblComputador = new JLabel("");
		lblComputador.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/PcDisplay.png")));
		lblComputador.setBounds(1129, 536, 76, 89);
		contentPane.add(lblComputador);

		JLabel lblWifiGra = new JLabel("Wifi Gratis ");
		lblWifiGra.setFont(new Font("Arial", Font.PLAIN, 14));
		lblWifiGra.setBounds(772, 468, 78, 14);
		contentPane.add(lblWifiGra);

		JLabel lblNewLabel_1 = new JLabel("Chave Digital");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(944, 468, 89, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblArcondi = new JLabel("Ar-Condicional ");
		lblArcondi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblArcondi.setBounds(1114, 468, 99, 25);
		contentPane.add(lblArcondi);

		JLabel lblCafeMaq = new JLabel("Maquina de Cafe");
		lblCafeMaq.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCafeMaq.setBounds(1299, 474, 115, 14);
		contentPane.add(lblCafeMaq);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaQuartos telaQuartos = new TelaQuartos(hosp, cidade);
				dispose();
				telaQuartos.setResizable(false);
				telaQuartos.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVoltar.setBounds(10, 241, 90, 25);
		contentPane.add(btnVoltar);

		JLabel lblComputadorr = new JLabel("Computador ");
		lblComputadorr.setFont(new Font("Arial", Font.PLAIN, 14));
		lblComputadorr.setBounds(1129, 632, 89, 14);
		contentPane.add(lblComputadorr);

		ModeloQuarto modeloQuarto = new ModeloQuarto();
		modeloQuarto.setNomeModelo(tipo);
		ModeloQuarto modeloQuartoComPreco = modeqdao.buscPreco(modeloQuarto);
		String preco = modeloQuartoComPreco.getPreco();

		JLabel lblUsurio = new JLabel("Preco do quarto: R$" + preco + ".00");
		lblUsurio.setFont(new Font("Arial", Font.BOLD, 37));
		lblUsurio.setBounds(860, 722, 473, 38);
		contentPane.add(lblUsurio);

		JButton btnReservar = new JButton("");
		btnReservar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFinalizar telaFinalizar = new TelaFinalizar(tipo, hosp, cidade, preco);
				dispose();
				telaFinalizar.setResizable(false);
				telaFinalizar.setVisible(true);
			}
		});
		btnReservar.setIcon(new ImageIcon(TelaQuarto.class.getResource("/imgs/btnReservar.png")));
		btnReservar.setBounds(860, 771, 463, 56);
		contentPane.add(btnReservar);

		JLabel lblCafeManha = new JLabel("Cafe da Manha");
		lblCafeManha.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCafeManha.setBounds(760, 632, 99, 14);
		contentPane.add(lblCafeManha);

		JLabel lblgratis = new JLabel("Gratuito ");
		lblgratis.setFont(new Font("Arial", Font.PLAIN, 14));
		lblgratis.setBounds(1142, 652, 71, 14);
		contentPane.add(lblgratis);

		JLabel lbltv = new JLabel("TV HD");
		lbltv.setFont(new Font("Arial", Font.PLAIN, 14));
		lbltv.setBounds(954, 632, 78, 14);
		contentPane.add(lbltv);

	}
}