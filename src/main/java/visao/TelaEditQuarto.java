package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.text.MaskFormatter;

import controle.ReservaDAO;
import controle.QuartoDAO;
import modelo.Reserva;
import modelo.Usuarios;
import modelo.Quarto;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;

public class TelaEditQuarto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textHoraLimpeza;
	private JTextField textTipoId;

	/**
	 * Create the frame.
	 * @param horaLimpeza 
	 * @param TipoId
	 */
	public TelaEditQuarto(int TipoId, Time horaLimpeza, int idQuarto) {
			setTitle("Tela de edicao do quarto");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 768, 607);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(TelaEditReserva.class.getResource("/imgs/Title.png")));
			lblNewLabel.setBounds(0, 0, 1435, 231);
			contentPane.add(lblNewLabel);
		
		
		
		JLabel lbl_HoraLimpeza = new JLabel("Horário de limpeza do quarto:");
		lbl_HoraLimpeza.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_HoraLimpeza.setBounds(40, 307, 375, 38);
		contentPane.add(lbl_HoraLimpeza);
		
		JLabel lbl_TipoId = new JLabel("Tipo id do quarto:");
		lbl_TipoId.setFont(new Font("Krona One", Font.PLAIN, 24));
		lbl_TipoId.setBounds(40, 377, 218, 31);
		contentPane.add(lbl_TipoId);
		
		try {
			MaskFormatter mascara = new MaskFormatter("##:##");
			textHoraLimpeza = new JFormattedTextField(mascara);

		}catch (Exception e) {
			
		}
		textHoraLimpeza.setFont(new Font("Dialog", Font.PLAIN, 16));
		textHoraLimpeza.setHorizontalAlignment(SwingConstants.LEFT);
		textHoraLimpeza.setBounds(366, 310, 284, 38);
		textHoraLimpeza.setText(String.valueOf(horaLimpeza));
		contentPane.add(textHoraLimpeza);
		textHoraLimpeza.setColumns(10);
		try {
			MaskFormatter mascara = new MaskFormatter("#");
			textTipoId = new JFormattedTextField(mascara);

		}catch (Exception e) {
			
		}
		textTipoId.setFont(new Font("Dialog", Font.PLAIN, 16));
		textTipoId.setHorizontalAlignment(SwingConstants.LEFT);
		textTipoId.setBounds(291, 376, 359, 38);
		textTipoId.setText(String.valueOf(TipoId));
		contentPane.add(textTipoId);
		textTipoId.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String digHoraLimpeza = textHoraLimpeza.getText()+":00";
				String digTipoId = textTipoId.getText();

				Quarto quartos = new Quarto();
				quartos.setNumQuarto(idQuarto);
				quartos.setHoraLimpeza(Time.valueOf(digHoraLimpeza));
				quartos.setTipoId(Integer.valueOf(digTipoId));
				QuartoDAO dao = QuartoDAO.getInstancia();
				int result = dao.atualizarQuarto(quartos);
				if ( result > 0) {
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setResizable(false);
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
					dispose();
				} else {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});
		btnAtualizar.setForeground(Color.BLACK);
		btnAtualizar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setBackground(new Color(240, 240, 240));
		btnAtualizar.setBounds(224, 502, 140, 35);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quarto quartos = new Quarto();
				quartos.setNumQuarto(idQuarto);
				QuartoDAO pt = QuartoDAO.getInstancia();
				pt.removerQuarto(quartos);
				dispose();
			}
		});
		btnDeletar.setForeground(Color.BLACK);
		btnDeletar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnDeletar.setFocusPainted(false);
		btnDeletar.setBackground(new Color(240, 240, 240));
		btnDeletar.setBounds(414, 502, 140, 35);
		contentPane.add(btnDeletar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(255, 0, 0));
		btnCancelar.setBounds(602, 502, 140, 35);
		contentPane.add(btnCancelar);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String digHoraLimpeza = textHoraLimpeza.getText()+":00";
				String digTipoId = textTipoId.getText();


				Quarto quartos = new Quarto();
				
				quartos.setHoraLimpeza(Time.valueOf(digHoraLimpeza));
				quartos.setTipoId(Integer.valueOf(digTipoId));

				QuartoDAO dao = QuartoDAO.getInstancia();
				int result = dao.inserirQuarto(quartos);
				if ( result > 0) {
					TelaSucesso sucesso = new TelaSucesso();
					sucesso.setResizable(false);
					sucesso.setLocationRelativeTo(null);
					sucesso.setVisible(true);
					dispose();
				} else {
					TelaErro erro = new TelaErro();
					erro.setResizable(false);
					erro.setLocationRelativeTo(null);
					erro.setVisible(true);
				}
			}
		});
		btnInserir.setForeground(Color.BLACK);
		btnInserir.setFocusPainted(false);
		btnInserir.setBackground(new Color(240, 240, 240));
		btnInserir.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnInserir.setBounds(40, 502, 140, 35);
		contentPane.add(btnInserir);
		
		
	}
}
 	