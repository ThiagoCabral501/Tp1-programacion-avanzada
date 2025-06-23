package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAdmin frame = new VistaAdmin();
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
	public VistaAdmin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 456);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblTituloAdmin = new JLabel("Vista Administrador");
		LblTituloAdmin.setFont(new Font("Courier New", Font.PLAIN, 30));
		LblTituloAdmin.setBounds(156, 11, 356, 34);
		contentPane.add(LblTituloAdmin);
		
		JLabel LblBienvenidoAdmin = new JLabel("Bienvenido: ");
		LblBienvenidoAdmin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LblBienvenidoAdmin.setBounds(10, 68, 253, 25);
		contentPane.add(LblBienvenidoAdmin);
	}

}
