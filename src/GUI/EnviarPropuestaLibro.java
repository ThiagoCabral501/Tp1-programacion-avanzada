package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import BLL.Usuario;
import DLL.DLLLibro;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EnviarPropuestaLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpTituloLibro;
	private JTextField inpGeneroLibro;
	private JTextField inpNombreArchivo;
	private JTextField inpDescripcion;
	private JTextField inpFechaEnvio;

	/**
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnviarPropuestaLibro frame = new EnviarPropuestaLibro(autor);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	 * Create the frame.
	 */
	private Usuario autor;
	
	public EnviarPropuestaLibro(Usuario autor) {
		this.autor = autor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enviar propuesta de libro");
		lblNewLabel.setFont(new Font("Courier New", Font.PLAIN, 30));
		lblNewLabel.setBounds(10, 11, 465, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblTituloLibro = new JLabel("Titulo");
		lblTituloLibro.setBounds(115, 83, 250, 14);
		contentPane.add(lblTituloLibro);
		
		inpTituloLibro = new JTextField();
		inpTituloLibro.setBounds(115, 104, 250, 20);
		contentPane.add(inpTituloLibro);
		inpTituloLibro.setColumns(10);
		
		JLabel lblGeneroLibro = new JLabel("Genero");
		lblGeneroLibro.setBounds(115, 136, 250, 14);
		contentPane.add(lblGeneroLibro);
		
		inpGeneroLibro = new JTextField();
		inpGeneroLibro.setColumns(10);
		inpGeneroLibro.setBounds(115, 157, 250, 20);
		contentPane.add(inpGeneroLibro);
		
		JLabel lblNombreArchivo = new JLabel("Nombre del archivo");
		lblNombreArchivo.setBounds(115, 290, 250, 14);
		contentPane.add(lblNombreArchivo);
		
		inpNombreArchivo = new JTextField();
		inpNombreArchivo.setColumns(10);
		inpNombreArchivo.setBounds(115, 311, 250, 20);
		contentPane.add(inpNombreArchivo);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(115, 188, 250, 14);
		contentPane.add(lblDescripcion);
		
		inpDescripcion = new JTextField();
		inpDescripcion.setColumns(10);
		inpDescripcion.setBounds(115, 209, 250, 70);
		contentPane.add(inpDescripcion);
		
		JLabel lblFechaEnvio = new JLabel("Fecha de Envio (YYYY-MM-DD)");
		lblFechaEnvio.setBounds(115, 342, 250, 14);
		contentPane.add(lblFechaEnvio);
		
		inpFechaEnvio = new JTextField();
		inpFechaEnvio.setColumns(10);
		inpFechaEnvio.setBounds(115, 363, 250, 20);
		contentPane.add(inpFechaEnvio);
		
		JButton btnEnviarPropuestaLibro = new JButton("Enviar Propuesta");
		btnEnviarPropuestaLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String titulo = inpTituloLibro.getText();
			    String genero = inpGeneroLibro.getText();
			    String descripcion = inpDescripcion.getText();
			    String archivo = inpNombreArchivo.getText();
			    String fechaEnvio = inpFechaEnvio.getText();

			    String estado = "pendiente";
			    int stock = 0;
			    double precio = 0.0;

			    Libro nuevoLibro = new Libro(0, titulo, descripcion, genero, fechaEnvio, archivo, estado, autor.getId(), stock, precio);
			    DLLLibro.agregarLibro(nuevoLibro);

			    JOptionPane.showMessageDialog(null, "Propuesta enviada con éxito.");
			    dispose();
			    new VistaAutor(autor).setVisible(true);
			}
		});
		btnEnviarPropuestaLibro.setBounds(115, 411, 119, 23);
		contentPane.add(btnEnviarPropuestaLibro);
		
		JButton btnVolverVistaAutor = new JButton("Volver");
		btnVolverVistaAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAutor vistaAutor = new VistaAutor(autor); // Usamos el mismo autor
		        vistaAutor.setVisible(true);
		        dispose();
			}
		});
		btnVolverVistaAutor.setBounds(246, 411, 119, 23);
		contentPane.add(btnVolverVistaAutor);
	}
}
