package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaAutor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaAutor frame = new VistaAutor();
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
	public VistaAutor() {
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
	}

}
