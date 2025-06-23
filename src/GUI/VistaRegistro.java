package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import BLL.Usuario;
import javax.swing.JOptionPane;

public class VistaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpNombreRegistro;
	private JPasswordField inpContraseniaRegistro;
	private JTextField inpEmailRegistro;
	private JTextField inpTipoUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaRegistro frame = new VistaRegistro();
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
	public VistaRegistro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LblNewLabel = new JLabel("Registrarse");
		LblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 30));
		LblNewLabel.setBounds(223, 11, 204, 41);
		contentPane.add(LblNewLabel);
		
		JLabel LblNombreRegistro1 = new JLabel("Nombre");
		LblNombreRegistro1.setBounds(89, 175, 46, 14);
		contentPane.add(LblNombreRegistro1);
		
		inpNombreRegistro = new JTextField();
		inpNombreRegistro.setBounds(89, 193, 183, 32);
		contentPane.add(inpNombreRegistro);
		inpNombreRegistro.setColumns(10);
		
		JLabel lblContraseñaRegistro = new JLabel("Contraseña");
		lblContraseñaRegistro.setBounds(89, 236, 65, 14);
		contentPane.add(lblContraseñaRegistro);
		
		inpContraseniaRegistro = new JPasswordField();
		inpContraseniaRegistro.setBounds(89, 255, 183, 32);
		contentPane.add(inpContraseniaRegistro);
		
		JLabel LblEmailRegistro = new JLabel("Email");
		LblEmailRegistro.setBounds(351, 175, 46, 14);
		contentPane.add(LblEmailRegistro);
		
		inpEmailRegistro = new JTextField();
		inpEmailRegistro.setBounds(351, 193, 204, 32);
		contentPane.add(inpEmailRegistro);
		inpEmailRegistro.setColumns(10);
		
		JLabel LblTipoRegistrarse = new JLabel("Tipo de usuario (admin, autor, cliente)");
		LblTipoRegistrarse.setBounds(351, 236, 235, 14);
		contentPane.add(LblTipoRegistrarse);
		
		inpTipoUsuario = new JTextField();
		inpTipoUsuario.setBounds(351, 255, 204, 32);
		contentPane.add(inpTipoUsuario);
		inpTipoUsuario.setColumns(10);
		
		JButton btnRegistrarseCompleto = new JButton("Registrarse");
		btnRegistrarseCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = inpNombreRegistro.getText();
			    String email = inpEmailRegistro.getText();
			    String tipo = inpTipoUsuario.getText().toLowerCase();
			    String contrasenia = new String(inpContraseniaRegistro.getPassword());

			    if (nombre.isEmpty() || email.isEmpty() || tipo.isEmpty() || contrasenia.isEmpty()) {
			        JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.");
			        return;
			    }

			    // Crear el usuario
			    Usuario nuevo = new Usuario(0, nombre, email, tipo, contrasenia);

			    // Registrar
			    Usuario.RegistrarUsuario(nuevo);

			    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");

			    // Volver a la pantalla principal (opcional)
			    PantallaPrincipal volver = new PantallaPrincipal();
			    volver.setVisible(true);
			    dispose();
			}
		});
		btnRegistrarseCompleto.setBounds(251, 314, 128, 32);
		contentPane.add(btnRegistrarseCompleto);
	}

}
