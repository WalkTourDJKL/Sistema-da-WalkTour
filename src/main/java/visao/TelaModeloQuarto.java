package visao; 
 
import java.awt.EventQueue; 
 
import javax.swing.JFrame; 
import javax.swing.JPanel; 
import javax.swing.border.EmptyBorder; 
import javax.swing.table.DefaultTableModel; 
 
import controle.ModeloQuartoDAO; 
import modelo.ModeloQuarto; 
 
import javax.swing.JLabel; 
import javax.swing.JOptionPane; 
import javax.swing.ImageIcon; 
import java.awt.Font; 
import java.awt.Color; 
import javax.swing.JTextField; 
import javax.swing.JButton; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import java.awt.event.ActionListener; 
import java.awt.event.MouseAdapter; 
import java.awt.event.MouseEvent; 
import java.util.ArrayList; 
import java.awt.event.ActionEvent; 
 
public class TelaModeloQuarto extends JFrame { 
 
    private JPanel contentPane; 
    private ModeloQuartoDAO dao = ModeloQuartoDAO.getInstancia(); 
    private JTable table; 
    private JTextField txtId; 
    private JTextField txtNomeModelo; 
    private JTextField txtQtdBanheiro; 
    private JTextField txtQtdCamas; 
    private JTextField txtFrigobar; 
    private JTextField txtServicoQuarto; 
    private JTextField txtPreco; 
    private ArrayList<ModeloQuarto> modelos = new ArrayList<>(); 
 
    public static void main(String[] args) { 
        EventQueue.invokeLater(new Runnable() { 
            public void run() { 
                try { 
                    TelaModeloQuarto frame = new TelaModeloQuarto(); 
                    frame.setVisible(true); 
                    frame.setResizable(false); 
                } catch (Exception e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
    } 
 
    public TelaModeloQuarto() { 
        setTitle("Tabela Modelo de Quarto"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 1402, 693); 
        contentPane = new JPanel(); 
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); 
        setContentPane(contentPane); 
        contentPane.setLayout(null); 
        
        txtId = new JTextField();
 
        table = new JTable(); 
        table.addMouseListener(new MouseAdapter() { 
            @Override 
            public void mouseClicked(MouseEvent e) { 
                int linha = table.getSelectedRow(); 
                if (linha != -1) { 
                    ModeloQuarto modelo = modelos.get(linha); 
                    preencherCampos(modelo); 
                } 
            } 
        }); 
        atualizarTabela(); 
        JScrollPane scrollPane = new JScrollPane(table); 
        scrollPane.setBounds(648, 270, 701, 318); 
        contentPane.add(scrollPane); 
 
        JLabel lblTitle = new JLabel(""); 
        lblTitle.setIcon(new ImageIcon(TelaModeloQuarto.class.getResource("/imgs/title.png"))); 
        lblTitle.setBounds(0, 0, 1370, 248); 
        contentPane.add(lblTitle); 
         
        JLabel lblNomeModelo = new JLabel("Nome do Modelo:"); 
        lblNomeModelo.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblNomeModelo.setBounds(10, 286, 150, 20); 
        contentPane.add(lblNomeModelo); 
 
        txtNomeModelo = new JTextField(); 
        txtNomeModelo.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtNomeModelo.setBounds(238, 284, 200, 25); 
        contentPane.add(txtNomeModelo); 
        txtNomeModelo.setColumns(10); 
 
        JLabel lblQtdBanheiro = new JLabel("Quantidade de Banheiros:"); 
        lblQtdBanheiro.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblQtdBanheiro.setBounds(10, 328, 226, 20); 
        contentPane.add(lblQtdBanheiro); 
 
        txtQtdBanheiro = new JTextField(); 
        txtQtdBanheiro.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtQtdBanheiro.setColumns(10); 
        txtQtdBanheiro.setBounds(238, 326, 100, 25); 
        contentPane.add(txtQtdBanheiro); 
 
        JLabel lblQtdCamas = new JLabel("Quantidade de Camas:"); 
        lblQtdCamas.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblQtdCamas.setBounds(10, 370, 220, 20); 
        contentPane.add(lblQtdCamas); 
 
        txtQtdCamas = new JTextField(); 
        txtQtdCamas.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtQtdCamas.setColumns(10); 
        txtQtdCamas.setBounds(238, 373, 100, 25); 
        contentPane.add(txtQtdCamas); 
 
        JLabel lblFrigobar = new JLabel("Frigobar:"); 
        lblFrigobar.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblFrigobar.setBounds(10, 412, 90, 23); 
        contentPane.add(lblFrigobar); 
 
        txtFrigobar = new JTextField(); 
        txtFrigobar.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtFrigobar.setColumns(10); 
        txtFrigobar.setBounds(238, 415, 200, 25); 
        contentPane.add(txtFrigobar); 
 
        JLabel lblServicoQuarto = new JLabel("Serviço de Quarto:"); 
        lblServicoQuarto.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblServicoQuarto.setBounds(10, 457, 160, 25); 
        contentPane.add(lblServicoQuarto); 
 
        txtServicoQuarto = new JTextField(); 
        txtServicoQuarto.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtServicoQuarto.setColumns(10); 
        txtServicoQuarto.setBounds(238, 457, 200, 25); 
        contentPane.add(txtServicoQuarto); 
 
        JLabel lblPreco = new JLabel("Preço:"); 
        lblPreco.setFont(new Font("Krona One", Font.PLAIN, 18)); 
        lblPreco.setBounds(10, 500, 90, 23); 
        contentPane.add(lblPreco); 
 
        txtPreco = new JTextField(); 
        txtPreco.setFont(new Font("Dialog", Font.PLAIN, 16)); 
        txtPreco.setColumns(10); 
        txtPreco.setBounds(238, 503, 200, 25); 
        contentPane.add(txtPreco); 
 
      
 
        JButton btnInserir = new JButton("Inserir"); 
        btnInserir.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                inserirModeloQuarto(); 
            } 
        }); 
        btnInserir.setForeground(Color.BLACK); 
        btnInserir.setFont(new Font("Krona One", Font.PLAIN, 16)); 
        btnInserir.setFocusPainted(false); 
        btnInserir.setBackground(new Color(240, 240, 240)); 
        btnInserir.setBounds(10, 554, 132, 35); 
        contentPane.add(btnInserir); 
 
        JButton btnAtualizar = new JButton("Atualizar"); 
        btnAtualizar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                atualizarModeloQuarto(); 
            } 
        }); 
        btnAtualizar.setForeground(Color.BLACK); 
        btnAtualizar.setFont(new Font("Krona One", Font.PLAIN, 16)); 
        btnAtualizar.setFocusPainted(false); 
        btnAtualizar.setBackground(new Color(240, 240, 240)); 
        btnAtualizar.setBounds(166, 554, 132, 35); 
        contentPane.add(btnAtualizar); 
 
        JButton btnDeletar = new JButton("Deletar"); 
        btnDeletar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                deletarModeloQuarto(); 
            } 
        }); 
        btnDeletar.setForeground(Color.BLACK); 
        btnDeletar.setFont(new Font("Krona One", Font.PLAIN, 16)); 
        btnDeletar.setFocusPainted(false); 
        btnDeletar.setBackground(new Color(240, 240, 240)); 
        btnDeletar.setBounds(325, 554, 132, 35); 
        contentPane.add(btnDeletar); 
 
        JButton btnLimpar = new JButton("Limpar"); 
        btnLimpar.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                limparCampos(); 
            } 
        }); 
        btnLimpar.setForeground(Color.BLACK); 
        btnLimpar.setFont(new Font("Krona One", Font.PLAIN, 16)); 
        btnLimpar.setFocusPainted(false); 
        btnLimpar.setBackground(new Color(240, 240, 240)); 
        btnLimpar.setBounds(479, 554, 150, 35); 
        contentPane.add(btnLimpar); 
    } 
 
    private void atualizarTabela() { 
        modelos = dao.listarModeloQuarto(); 
        DefaultTableModel model = new DefaultTableModel(new Object[]{"ID", "Nome do Modelo", "Quantidade de Banheiros",  
        		"Quantidade de Camas", "Frigobar", "Serviço de Quarto", "Preço"}, 0) { 
            public boolean isCellEditable(int row, int column) { 
                return false; 
            } 
        }; 
 
        for (ModeloQuarto modelo : modelos) { 
            model.addRow(new Object[]{modelo.getTipoId(), modelo.getNomeModelo(), modelo.getQtdBanheiro(),  
            		modelo.getQtdCamas(), modelo.isFrigobar(), modelo.isServicoQuarto(), modelo.getPreco()}); 
        } 
 
        table.setModel(model); 
    } 
 
    public void limparCampos() { 
        txtId.setText(""); 
        txtNomeModelo.setText(""); 
        txtQtdBanheiro.setText(""); 
        txtQtdCamas.setText(""); 
        txtFrigobar.setText(""); 
        txtServicoQuarto.setText(""); 
        txtPreco.setText(""); 
    } 
 
    public void preencherCampos(ModeloQuarto modelo) { 
        txtId.setText(String.valueOf(modelo.getTipoId())); 
        txtNomeModelo.setText(modelo.getNomeModelo()); 
        txtQtdBanheiro.setText(String.valueOf(modelo.getQtdBanheiro())); 
        txtQtdCamas.setText(String.valueOf(modelo.getQtdCamas())); 
        txtFrigobar.setText(String.valueOf(modelo.isFrigobar())); 
        txtServicoQuarto.setText(String.valueOf(modelo.isServicoQuarto())); 
        txtPreco.setText(modelo.getPreco()); 
    } 
 
    public void inserirModeloQuarto() { 
        try { 
            ModeloQuarto modelo = new ModeloQuarto(); 
            modelo.setNomeModelo(txtNomeModelo.getText()); 
            modelo.setQtdBanheiro(Integer.parseInt(txtQtdBanheiro.getText())); 
            modelo.setQtdCamas(Integer.parseInt(txtQtdCamas.getText())); 
            modelo.setFrigobar(Boolean.parseBoolean(txtFrigobar.getText())); 
            modelo.setServicoQuarto(Boolean.parseBoolean(txtServicoQuarto.getText())); 
            modelo.setPreco(txtPreco.getText()); 
 
            int resultado = dao.inserirModeloQuarto(modelo); 
            if (resultado > 0) { 
                atualizarTabela(); 
                limparCampos(); 
                JOptionPane.showMessageDialog(null, "Modelo de Quarto inserido com sucesso!"); 
            } else { 
                JOptionPane.showMessageDialog(null, "Erro ao inserir Modelo de Quarto!"); 
            } 
        } catch (NumberFormatException ex) { 
            JOptionPane.showMessageDialog(null, "Por favor, preencha os campos corretamente."); 
        } 
    } 
 
    public void atualizarModeloQuarto() { 
        try { 
            ModeloQuarto modelo = new ModeloQuarto(); 
            modelo.setTipoId(Integer.parseInt(txtId.getText())); 
            modelo.setNomeModelo(txtNomeModelo.getText()); 
            modelo.setQtdBanheiro(Integer.parseInt(txtQtdBanheiro.getText())); 
            modelo.setQtdCamas(Integer.parseInt(txtQtdCamas.getText())); 
            modelo.setFrigobar(Boolean.parseBoolean(txtFrigobar.getText())); 
            modelo.setServicoQuarto(Boolean.parseBoolean(txtServicoQuarto.getText())); 
            modelo.setPreco(txtPreco.getText()); 
 
            boolean resultado = dao.atualizarModeloQuarto(modelo); 
            if (resultado) { 
                atualizarTabela(); 
                limparCampos(); 
                JOptionPane.showMessageDialog(null, "Modelo de Quarto atualizado com sucesso!"); 
            } else { 
                JOptionPane.showMessageDialog(null, "Erro ao atualizar Modelo de Quarto!"); 
            } 
        } catch (NumberFormatException ex) { 
            JOptionPane.showMessageDialog(null, "Por favor, preencha os campos corretamente."); 
        } 
    } 
 
    public void deletarModeloQuarto() { 
        try { 
            int tipoId = Integer.parseInt(txtId.getText()); 
            ModeloQuarto modelo = new ModeloQuarto(); 
            modelo.setTipoId(tipoId); 
 
            int resultado = dao.removerModeloQuarto(modelo); 
            if (resultado > 0) { 
                atualizarTabela(); 
                limparCampos(); 
                JOptionPane.showMessageDialog(null, "Modelo de Quarto deletado com sucesso!"); 
            } else { 
                JOptionPane.showMessageDialog(null, "Erro ao deletar Modelo de Quarto!"); 
            } 
        } catch (NumberFormatException ex) { 
            JOptionPane.showMessageDialog(null, "Por favor, selecione um Modelo de Quarto na tabela."); 
        } 
    } 
}