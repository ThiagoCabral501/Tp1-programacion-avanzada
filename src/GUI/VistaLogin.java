package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import BLL.Usuario;

public class VistaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombre;
	private JPasswordField inpContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
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
	public VistaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 465);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Iniciar sesion");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 30));
		lblNewLabel.setBounds(201, 11, 260, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(98, 241, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		inpNombre = new JTextField();
		inpNombre.setBounds(98, 260, 211, 37);
		contentPane.add(inpNombre);
		inpNombre.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setBounds(356, 241, 78, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnLogin = new JButton("Iniciar sesion");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = inpNombre.getText();
				String contrasenia = new String(inpContrasenia.getPassword());

				if (nombre.isEmpty() || contrasenia.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
					return;
				}

				Usuario user = Usuario.login(nombre, contrasenia);

				if (user != null && user.getId() != 0) {
					JOptionPane.showMessageDialog(null, "Bienvenido " + user.getNombre());

					if (user.getTipo().equalsIgnoreCase("admin")) {
						VistaAdmin admin = new VistaAdmin();
						admin.setVisible(true);
					} else if (user.getTipo().equalsIgnoreCase("autor")) {
						VistaAutor autor = new VistaAutor(user);
						autor.setVisible(true);
					} else if (user.getTipo().equalsIgnoreCase("cliente")) {
						VistaCliente cliente = new VistaCliente(user);
						cliente.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Tipo de usuario no reconocido.");
					}

					dispose(); // Cierra la vista de login
				} else {
					JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
				}
			}
		});
		btnLogin.setBounds(266, 331, 117, 28);
		contentPane.add(btnLogin);
		
		inpContrasenia = new JPasswordField();
		inpContrasenia.setBounds(356, 260, 211, 37);
		contentPane.add(inpContrasenia);
	}
}
