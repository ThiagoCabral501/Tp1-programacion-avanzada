package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Usuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaAutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario autor;

	public VistaAutor(Usuario autor) {
		this.autor = autor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblTituloAutor = new JLabel("Vista Autor");
		LblTituloAutor.setFont(new Font("Courier New", Font.PLAIN, 30));
		LblTituloAutor.setBounds(230, 11, 208, 34);
		contentPane.add(LblTituloAutor);
		
		JLabel LblBienvenidoAutor = new JLabel("Bienvenido: ");
		LblBienvenidoAutor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LblBienvenidoAutor.setBounds(10, 56, 234, 17);
		contentPane.add(LblBienvenidoAutor);
		
		JButton btnEnviarPropuesta = new JButton("Enviar propuesta de libro");
		btnEnviarPropuesta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EnviarPropuestaLibro propuesta = new EnviarPropuestaLibro(VistaAutor.this.autor);
				propuesta.setVisible(true);
				dispose();
			}
		});
		btnEnviarPropuesta.setBounds(10, 148, 166, 34);
		contentPane.add(btnEnviarPropuesta);
		
		JButton btnNewButton = new JButton("Ver estado de propuestas");
		btnNewButton.setBounds(10, 225, 166, 34);
		contentPane.add(btnNewButton);
	}
}
