package visao;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;

public class TelaPrincipal extends JFrame {
	private JPanel contentPane;
	public TelaPrincipal() {
		
		// Criar os dados para a tabela
		Object[][] data2 = {
				{ getImageIcon("Blumenau"), "Blumenau", "Santa Catarina", "Bento Goncalves", "Rio Grande do Sul" },
				{ getImageIcon("Canela"), "Canela", "Rio Grande do Sul", "Gramado", "Rio Grande do Sul" },
				{ getImageIcon("SaoFranciscoDoSul"), "Sao Francisco Do Sul", "Santa Catarina" } };

		// Criar os nomes das colunas
		String[] columnNames = { "", "", "", "" };

		// Criar o modelo da tabela
		DefaultTableModel model = new DefaultTableModel(data2, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Criar a JTable com o modelo
		JTable table = new JTable(model);
		table.setShowGrid(false);
		table.setRowHeight(100); // Altura

		// Configurar o renderizador para todas as colunas
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(new CustomPanelRenderer());
		}

		// Configurar o evento de clique para toda a célula
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaHotel hotel = new TelaHotel();
				hotel.setExtendedState(JFrame.MAXIMIZED_BOTH);
				hotel.setVisible(true);
				dispose(); // Fechar a tela atual
			}
		});

		// Adicionar a JTable a um JScrollPane para suportar rolagem
		JScrollPane scrollPane = new JScrollPane(table);

		// Configurar o JFrame
		setTitle("Tela principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920, 1090);
		setLocationRelativeTo(null);
		// Adicionar a JScrollPane (que contém a JTable) ao JFrame
		getContentPane().add(scrollPane);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[1700.00px][300.00][400.00]", "[209px]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 1063, 209);
		lblNewLabel.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/titulo.png")));
		panel.add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JLabel lblNewLabel2 = new JLabel("User10637");
        lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel2.setBounds(1673, 78, 100, 14);
        panel.add(lblNewLabel2);
        
		JLabel lbliconePerfil = new JLabel("");
        lbliconePerfil.setIcon(new ImageIcon(TelaHotel.class.getResource("/imgs/perfil.png")));
        lbliconePerfil.setBounds(1772, 35, 99, 95);
        panel.add(lbliconePerfil);
        
        

		// Exibir o JFrame
		setVisible(true);
	}

	// Método para carregar as imagens a partir dos nomes dos arquivos
	private ImageIcon getImageIcon(String url) {
		File directory = new File(".");
		Image img = null;
		String path = "";
		try {
			// Carrega a imagem a partir do caminho relativo
			path = directory.getCanonicalPath() + "/src/main/java/imgs/" + url + ".png";
			img = ImageIO.read(new File(path));
			System.out.println(path);
			return new ImageIcon(img);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	// Classe para renderizar os painéis personalizados na tabela
	class CustomPanelRenderer extends JPanel implements TableCellRenderer {
		private JLabel txtCidade;
		private JLabel txtEstado;

		public CustomPanelRenderer() {
			setLayout(new BorderLayout());
			setPreferredSize(new Dimension(300, 100));

			JLabel imageLabel = new JLabel();
			add(imageLabel, BorderLayout.CENTER);

			JPanel textPanel = new JPanel(new GridLayout(2, 1));
			txtCidade = new JLabel("");
			txtEstado = new JLabel("");
			textPanel.add(txtCidade);
			textPanel.add(txtEstado);
			add(textPanel, BorderLayout.SOUTH);
		}

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof String) {
				String cidade = (String) value;
				int nextColumn = column + 1;
				String estado = nextColumn < table.getColumnCount() ? (String) table.getValueAt(row, nextColumn) : "";
				txtCidade.setText(cidade);
				txtEstado.setText(estado);
			} else if (value instanceof ImageIcon) {
				((JLabel) getComponent(0)).setIcon((ImageIcon) value);
			}

			return this;
		}
	}

	public static void main(String[] args) {
		// Criar uma instância do JFrame
		new TelaPrincipal();
	}
}
