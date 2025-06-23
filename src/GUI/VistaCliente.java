package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.util.LinkedList;
import java.util.Comparator;
import java.util.stream.Collectors;

import BLL.Libro;
import DLL.DLLLibro;


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
		
		cargarTabla();
	}
	
	private void cargarTabla() {
	    LinkedList<Libro> librosOrdenados = DLLLibro.obtenerLibros().stream()
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
