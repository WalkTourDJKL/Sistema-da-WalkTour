package visao;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controle.Conexao;
import controle.UsuariosDAO;
import modelo.Usuarios;
import java.sql.Connection;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

// Importa��es para reprodu��o de �udio
import javax.sound.sampled.*;

public class TelaVerificacao extends JFrame {

    private JTable table;
    private Thread musicThread;

    public TelaVerificacao() {
        super("Tela de vericficacao no banco de dados");
        getContentPane().setLayout(null);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 0, 584, 361);
        getContentPane().add(scrollPane);

        JPanel panel = new JPanel();
        panel.setBounds(0, 360, 584, 142);
        getContentPane().add(panel);
        panel.setLayout(null);

        JButton btnNewButton = new JButton("Atualizar");
        btnNewButton.setBounds(0, 5, 297, 137);
        panel.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                atualizarTabela();
            }
        });

        JButton btnParar = new JButton("Parar");
        btnParar.setBounds(302, 74, 282, 68);
        panel.add(btnParar);
        btnParar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pararMusica();
            }
        });

        JButton btnTocar = new JButton("Tocar");
        btnTocar.setBounds(302, 5, 282, 68);
        panel.add(btnTocar);
        btnTocar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (musicThread == null || !musicThread.isAlive()) {
                    musicThread = new Thread(() -> reproduzirMusica());
                    musicThread.start();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 541);
        setLocationRelativeTo(null);

        atualizarTabela();
    }

    private void atualizarTabela() {
        Conexao conexao = Conexao.getConexao();

        Connection conDB = conexao.conectar();

        UsuariosDAO dao = UsuariosDAO.getInstancia();
        ArrayList<Usuarios> listaUsers = dao.listarUsuarios();

        conexao.fecharConexao();

        String[] colunas = {"Nome", "Nome Social", "Data de Nascimento", "CPF", "Login", "Senha", "Tipo" };
        DefaultTableModel model = new DefaultTableModel(colunas, 0);

        for (Usuarios u : listaUsers) {
            Object[] rowData = { u.getNome(), u.getNomeSocial(), u.getDtNasc(), u.getCpf(), u.getLogin(), u.getSenha(), u.getTipoUser() };
            model.addRow(rowData);
        }

        table.setModel(model);
    }

    // M�todo para reproduzir a m�sica
    private void reproduzirMusica() {
        try {
            AudioInputStream audioInputStream = AudioSystem
                    .getAudioInputStream(TelaVerificacao.class.getResource("/imgs/Audio1.wav"));

            AudioFormat format = audioInputStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);

            line.open(format);
            line.start();

            int bufferSize = (int) format.getSampleRate() * format.getFrameSize();
            byte[] buffer = new byte[bufferSize];
            int bytesRead = 0;

            while ((bytesRead = audioInputStream.read(buffer, 0, buffer.length)) != -1) {
                line.write(buffer, 0, bytesRead);
            }

            line.drain();
            line.close();
            audioInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pararMusica() {
        if (musicThread != null && musicThread.isAlive()) {
            musicThread.interrupt();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaVerificacao tela = new TelaVerificacao();
            tela.setVisible(true);
        });
    }
}
