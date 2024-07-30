package visao;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.EventoDAO;
import controle.pontosTurDAO;
import modelo.Evento;
import modelo.PontosTur;
import modelo.Usuarios;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JSplitPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextPane;
import javax.swing.JMenu;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSlider;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class TelaCidade extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private pontosTurDAO dao = pontosTurDAO.getInstancia();
	private EventoDAO dao2 = EventoDAO.getInstancia();
	ArrayList<PontosTur> pontosTur = new ArrayList<>();
	ArrayList<Evento> evento = new ArrayList<Evento>();

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param cidadehosp
	 * @param hosp
	 * @param cidade
	 * @param estado
	 */
	public TelaCidade(Usuarios hosp, String cidade, String estado) {
		setTitle("Tela de " + cidade);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1440, 900);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprincipal = new TelaPrincipal(hosp);
				dispose();
				telaprincipal.setResizable(false);
				telaprincipal.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnVoltar.setFocusPainted(false);
		btnVoltar.setBackground(new Color(240, 240, 240));
		btnVoltar.setBounds(10, 240, 90, 25);
		contentPane.add(btnVoltar);

		JLabel lblNomeCidade = new JLabel(cidade);
		lblNomeCidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCidade.setBounds(10, 276, 723, 40);
		lblNomeCidade.setFont(new Font("Tahoma", Font.BOLD, 46));
		contentPane.add(lblNomeCidade);

		JLabel lblTitulo = new JLabel("");
		lblTitulo.setBounds(0, 0, 1424, 229);
		lblTitulo.setIcon(new ImageIcon(TelaCidade.class.getResource("/imgs/Title.png")));
		contentPane.add(lblTitulo);

		JLabel lbliconePerfil = new JLabel("");
		lbliconePerfil.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int tVolt = 5;
				TelaUsuario user = new TelaUsuario(hosp, null, cidade, tVolt, estado);
				dispose();
				user.setResizable(false);
				user.setVisible(true);

			}
		});
		lbliconePerfil.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imgs/perfil.png")));
		lbliconePerfil.setBounds(1302, 11, 99, 95);
		contentPane.add(lbliconePerfil);

		JLabel lblPerfil = new JLabel(hosp.getNome());
		lblPerfil.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPerfil.setFont(new Font("Corbel", Font.PLAIN, 18));
		lblPerfil.setBounds(853, 64, 409, 23);
		contentPane.add(lblPerfil);

		JLabel lblImagemMaior = new JLabel("");
		lblImagemMaior.setBounds(10, 378, 1391, 323);

		// Carrega a imagem
		String cidadeS = cidade.replaceAll("\\s+", "");
		ImageIcon originalIcon = new ImageIcon(TelaCidade.class.getResource("/imgs/" + cidadeS + ".png"));

		// Redimensiona a imagem para caber no JLabel
		Image img = originalIcon.getImage();
		Image imgRedimensionada = img.getScaledInstance(lblImagemMaior.getWidth(), lblImagemMaior.getHeight(),
				Image.SCALE_SMOOTH);
		ImageIcon iconRedimensionado = new ImageIcon(imgRedimensionada);

		// Define o �cone redimensionado no JLabel
		lblImagemMaior.setIcon(iconRedimensionado);

		// Adiciona o JLabel ao contentPane
		contentPane.add(lblImagemMaior);

		JButton btnProcurarQuarto = new JButton("");
		btnProcurarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaHotel hotel = new TelaHotel(hosp, cidade, estado);
				dispose();
				hotel.setResizable(false);
				hotel.setVisible(true);
			}
		});
		btnProcurarQuarto.setIcon(new ImageIcon(TelaCidade.class.getResource("/imgs/btnBuscaQuarto.png")));
		btnProcurarQuarto.setBounds(974, 789, 427, 61);
		contentPane.add(btnProcurarQuarto);

		JLabel lblNomeCidade_1 = new JLabel(estado);
		lblNomeCidade_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCidade_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNomeCidade_1.setBounds(10, 338, 723, 40);
		contentPane.add(lblNomeCidade_1);

		JPanel panel = new JPanel();
		panel.setBounds(10, 695, 448, 155);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Informações sobre a cidade");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 428, 39);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(468, 695, 448, 155);
		contentPane.add(panel_1);

		JLabel lblEventosEPontos = new JLabel("Eventos e pontos turisticos na cidade");
		lblEventosEPontos.setHorizontalAlignment(SwingConstants.CENTER);
		lblEventosEPontos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEventosEPontos.setBounds(10, 11, 428, 39);
		panel_1.add(lblEventosEPontos);

		if (cidade == "Blumenau") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("Conhecida pelo Oktoberfest, um dos maiores festivais de cerveja do Brasil,");
			info1.addItem("que celebra a cultura germânica da cidade.");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Possui uma arquitetura de influência alemã, com diversos edifícios");
			info2.addItem("em estilo enxaimel, refletindo sua herança europeia.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
		if (cidade == "Sao Francisco do Sul") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("É uma das cidades mais antigas do Brasil, com um centro histórico que");
			info1.addItem("remonta ao período colonial e diversos edifícios preservados");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Possui um dos maiores portos pesqueiros do Brasil e é conhecida");
			info2.addItem("por suas belas praias e festas tradicionais.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
		if (cidade == "Balneario Camburiu") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("Famosa por suas praias urbanas e vida noturna vibrante, é um dos destinos");
			info1.addItem("turísticos mais populares do sul do Brasil.");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Possui o edifício residencial mais alto do Brasil, o One Tower,");
			info2.addItem("com 290  metros de altura.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
		if (cidade == "Canela") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("Localizada na Serra Gaúcha, é conhecida por seu charme de cidade pequena");
			info1.addItem("e sua arquitetura em estilo europeu.");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Abriga a Catedral de Pedra, um imponente edifício gótico que é um dos");
			info2.addItem("principais pontos turísticos da região.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
		if (cidade == "Gramado") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("É famosa pelo seu Festival de Cinema, o Festival de Cinema de Gramado,");
			info1.addItem("um dos mais importantes eventos do setor no Brasil.");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Oferece uma atmosfera de montanha e clima europeu, com uma grande");
			info2.addItem("variedade de atrações turísticas, como o Mini Mundo e o Snowland.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
		if (cidade == "Bento Goncalves") {
			JComboBox<String> info1 = new JComboBox<String>();
			info1.setBounds(10, 61, 430, 30);
			panel.add(info1);

			info1.addItem("Informação 1");
			info1.addItem("Considerada a capital do vinho do Brasil, é rodeada por vinícolas e");
			info1.addItem("oferece roteiros enológicos renomados.");
			info1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info1.getSelectedIndex() != 0) {
						info1.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info2 = new JComboBox<String>();
			info2.setBounds(10, 114, 430, 30);
			panel.add(info2);

			info2.addItem("Informação 2");
			info2.addItem("Tem um forte apelo cultural italiano, refletido na arquitetura");
			info2.addItem("e na culinária local, com festas como a Festa Nacional da Uva.");
			info2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info2.getSelectedIndex() != 0) {
						info2.setSelectedIndex(0);
					}
				}
			});

			JComboBox<String> info4 = new JComboBox<String>();
			info4.setBounds(10, 61, 430, 30);
			info4.addItem("Pontos turisticos ");
			ArrayList<PontosTur> pontosTur = dao.listarPontoTur();

			for (PontosTur ponto : pontosTur) {
				info4.addItem(ponto.getNomePontoTur());
			}
			info4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info4.getSelectedIndex() != 0) {
						info4.setSelectedIndex(0);
					}
				}
			});

			panel_1.add(info4);

			JComboBox<String> info5 = new JComboBox<String>();
			info5.setBounds(10, 114, 430, 30);
			panel_1.add(info5);

			info5.addItem("Eventos");
			ArrayList<Evento> eventos = dao2.listarEventos();

			for (Evento evento : eventos) {
				info5.addItem(evento.getNomeEvento());
			}
			info5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (info5.getSelectedIndex() != 0) {
						info5.setSelectedIndex(0);
					}
				}
			});
		}
	}

}
