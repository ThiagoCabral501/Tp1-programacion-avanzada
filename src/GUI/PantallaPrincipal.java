package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPrincipal frame = new PantallaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblTitulo = new JLabel("SISTEMA LIBRERIA");
		LblTitulo.setBounds(171, 11, 288, 34);
		LblTitulo.setFont(new Font("Courier New", Font.PLAIN, 30));
		contentPane.add(LblTitulo);
		
		JButton btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaLogin login = new VistaLogin();
		        login.setVisible(true);
		        dispose(); // Cierra la pantalla actual
			}
		});
		btnIniciarSesion.setBounds(33, 132, 122, 34);
		contentPane.add(btnIniciarSesion);
		
		JButton btnRegistrarsePP = new JButton("Registrarse");
		btnRegistrarsePP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaRegistro registro = new VistaRegistro();
		        registro.setVisible(true);
		        dispose();
			}
		});
		btnRegistrarsePP.setBounds(33, 204, 122, 34);
		contentPane.add(btnRegistrarsePP);
	}

}
