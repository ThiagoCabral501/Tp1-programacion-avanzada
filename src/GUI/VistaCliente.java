package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.LinkedList;
import java.util.Comparator;
import java.util.stream.Collectors;

import BLL.Libro;
import DLL.DLLLibro;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VistaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLibros;
	private DefaultTableModel modelo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCliente frame = new VistaCliente();
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
	public VistaCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel LbltituloCliente = new JLabel("Vista Cliente");
		LbltituloCliente.setFont(new Font("Courier New", Font.PLAIN, 30));
		LbltituloCliente.setBounds(218, 11, 257, 34);
		contentPane.add(LbltituloCliente);
		
		JLabel LblBienvenidoCliente = new JLabel("Bienvenido : ");
		LblBienvenidoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LblBienvenidoCliente.setBounds(10, 56, 239, 17);
		contentPane.add(LblBienvenidoCliente);
		
		String[] columnas = { "ID", "Título", "Género", "Precio", "Stock" };
		modelo = new DefaultTableModel(null, columnas);
		tablaLibros = new JTable(modelo);
		
		JScrollPane scrollPane = new JScrollPane(tablaLibros);
		scrollPane.setBounds(10, 100, 617, 200);
		contentPane.add(scrollPane);
		
		JLabel lblDescripcionCliente = new JLabel("Seleccione un libro haciendole click ");
		lblDescripcionCliente.setBounds(227, 75, 275, 14);
		contentPane.add(lblDescripcionCliente);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filaSeleccionada = tablaLibros.getSelectedRow();

			    if (filaSeleccionada != -1) {
			        int idLibro = (int) modelo.getValueAt(filaSeleccionada, 0);
			        Libro libroSeleccionado = DLLLibro.obtenerLibros().stream()
			            .filter(libro -> libro.getIdLibro() == idLibro)
			            .findFirst()
			            .orElse(null);

			        if (libroSeleccionado != null) {
			            VistaComprarLibro ventanaCompra = new VistaComprarLibro(libroSeleccionado);
			            ventanaCompra.setVisible(true);
			            dispose();
			        } else {
			            JOptionPane.showMessageDialog(null, "No se encontró el libro seleccionado.");
			        }
			    } else {
			        JOptionPane.showMessageDialog(null, "Debe seleccionar un libro primero.");
			    }
			}
		});
		btnComprar.setBounds(260, 327, 128, 44);
		contentPane.add(btnComprar);
		
		cargarTabla();
	}
	
	private void cargarTabla() {
	    LinkedList<Libro> librosOrdenados = DLLLibro.obtenerLibros().stream()
	    	.filter(libro -> "publicado".equalsIgnoreCase(libro.getEstado())) //Filtrar por solo libros publicados
	        .sorted(Comparator.comparingInt(Libro::getIdLibro).reversed()) // Orden descendente por ID
	        .collect(Collectors.toCollection(LinkedList::new));

	    modelo.setRowCount(0); // Limpiar tabla antes de cargar

	    for (Libro l : librosOrdenados) {
	        modelo.addRow(new Object[]{
	            l.getIdLibro(),          // ID
	            l.getTitulo(),      // Título
	            l.getGenero(),      // Género
	            l.getPrecio(),      // Precio
	            l.getStock()        // Stock
	        });
	    }
	}
}
