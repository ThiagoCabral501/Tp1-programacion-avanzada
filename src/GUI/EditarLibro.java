package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel ContentPane;
	private JTextField inpTituloLibro;
	private JTextField inpGeneroLibro;
	private JTextField inpDescripcionLibro;
	private JTextField inpArchivoLibro;
	private JTextField inpEstadoLibro;
	private JTextField inpStockLibro;
	private JTextField inpPrecioLibro;
	private JLabel lblInfo;


	public EditarLibro(Libro libro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 566);
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(ContentPane);
		ContentPane.setLayout(null);
		
		JLabel lblTituloLibro = new JLabel("Titulo");
		lblTituloLibro.setBounds(10, 53, 86, 14);
		ContentPane.add(lblTituloLibro);
		
		inpTituloLibro = new JTextField();
		inpTituloLibro.setBounds(10, 78, 198, 20);
		ContentPane.add(inpTituloLibro);
		inpTituloLibro.setColumns(10);
		inpTituloLibro.setText(libro.getTitulo());
		
		JLabel lblGeneroLibro = new JLabel("Genero");
		lblGeneroLibro.setBounds(10, 120, 86, 14);
		ContentPane.add(lblGeneroLibro);
		
		inpGeneroLibro = new JTextField();
		inpGeneroLibro.setColumns(10);
		inpGeneroLibro.setBounds(10, 145, 198, 20);
		ContentPane.add(inpGeneroLibro);
		inpGeneroLibro.setText(libro.getGenero());
		
		JLabel lblDescripcionLibro = new JLabel("Descripcion");
		lblDescripcionLibro.setBounds(10, 187, 86, 14);
		ContentPane.add(lblDescripcionLibro);
		
		inpDescripcionLibro = new JTextField();
		inpDescripcionLibro.setColumns(10);
		inpDescripcionLibro.setBounds(10, 212, 411, 79);
		ContentPane.add(inpDescripcionLibro);
		inpDescripcionLibro.setText(libro.getDescripcion());
		
		
		JLabel lblArchivoLibro = new JLabel("Archivo");
		lblArchivoLibro.setBounds(10, 316, 86, 14);
		ContentPane.add(lblArchivoLibro);
		
		inpArchivoLibro = new JTextField();
		inpArchivoLibro.setColumns(10);
		inpArchivoLibro.setBounds(10, 341, 198, 20);
		ContentPane.add(inpArchivoLibro);
		inpArchivoLibro.setText(libro.getArchivoLibro());
		
		JLabel lblEstadoLibro = new JLabel("Estado");
		lblEstadoLibro.setBounds(10, 390, 86, 14);
		ContentPane.add(lblEstadoLibro);
		
		inpEstadoLibro = new JTextField();
		inpEstadoLibro.setColumns(10);
		inpEstadoLibro.setBounds(10, 415, 198, 20);
		ContentPane.add(inpEstadoLibro);
		inpEstadoLibro.setText(libro.getEstado());
		
		JLabel lblStockLibro = new JLabel("Stock");
		lblStockLibro.setBounds(223, 53, 86, 14);
		ContentPane.add(lblStockLibro);
		
		inpStockLibro = new JTextField();
		inpStockLibro.setColumns(10);
		inpStockLibro.setBounds(223, 78, 198, 20);
		ContentPane.add(inpStockLibro);
		inpStockLibro.setText(String.valueOf(libro.getStock()));
		
		JLabel lblPrecioLibro = new JLabel("Precio");
		lblPrecioLibro.setBounds(226, 120, 86, 14);
		ContentPane.add(lblPrecioLibro);
		
		inpPrecioLibro = new JTextField();
		inpPrecioLibro.setColumns(10);
		inpPrecioLibro.setBounds(223, 145, 198, 20);
		ContentPane.add(inpPrecioLibro);
		inpPrecioLibro.setText(String.valueOf(libro.getPrecio()));
		
		JButton btnEditarLibro = new JButton("Editar");
		btnEditarLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				libro.setTitulo(inpTituloLibro.getText());
		        libro.setGenero(inpGeneroLibro.getText());
		        libro.setDescripcion(inpDescripcionLibro.getText());
		        libro.setArchivoLibro(inpArchivoLibro.getText());
		        libro.setEstado(inpEstadoLibro.getText());
		        libro.setStock(Integer.parseInt(inpStockLibro.getText()));
		        libro.setPrecio(Double.parseDouble(inpPrecioLibro.getText()));

		        lblInfo.setText(Libro.editarLibro(libro));
			}
		});
		btnEditarLibro.setBounds(119, 459, 89, 23);
		ContentPane.add(btnEditarLibro);
		
		JButton btnVolverLibro = new JButton("Volver");
		btnVolverLibro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VistaAdmin admin = new VistaAdmin();
			    admin.setVisible(true);
			    dispose();
			}
		});
		btnVolverLibro.setBounds(223, 459, 89, 23);
		ContentPane.add(btnVolverLibro);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(10, 491, 411, 14);
		ContentPane.add(lblInfo);
	}
}
