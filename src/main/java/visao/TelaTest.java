package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.Conexao;
import controle.HospedesDAO;
import modelo.hospedes;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaTest extends JFrame {

    private JTable table;

    public TelaTest() {
        super("Lista de Hóspedes");

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        
        JButton btnNewButton = new JButton("Atualizar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		atualizarTabela();
        	}
        });
        scrollPane.setRowHeaderView(btnNewButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        atualizarTabela();
    }

    private void atualizarTabela() {
        Conexao conexao = Conexao.getConexao();
        
        Connection conDB = conexao.conectar();

        HospedesDAO dao = HospedesDAO.getInstancia();
        ArrayList<hospedes> listaHospedes = dao.listarHopesdes();

        conexao.fecharConexao();

        String[] colunas = {"ID", "Nome", "Nome Social", "Data de Nascimento", "CPF"};
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (hospedes h : listaHospedes) {
            Object[] rowData = {
                    h.getIdHospede(),
                    h.getNome(),
                    h.getNomeSocial(),
                    h.getDtNasc(),
                    h.getCpf()
            };
            model.addRow(rowData);
        }

        table.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaTest tela = new TelaTest();
            tela.setVisible(true);
        });
    }

}
