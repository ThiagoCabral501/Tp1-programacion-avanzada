package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.stream.Collectors;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import BLL.Libro;
import DLL.DLLLibro;
import javax.swing.JButton;

public class VistaAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaLibros;
	private DefaultTableModel model;
	private Libro libroSeleccionado;

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
		
		model = new DefaultTableModel(new String[]{
				"ID", "Título", "Descripción", "Género", "Fecha Envío", "Archivo",
	            "Estado", "IdAutor", "Stock", "Precio"
			}, 0);

			tablaLibros = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(tablaLibros);
			scrollPane.setBounds(10, 100, 620, 200);
			contentPane.add(scrollPane);
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.setBounds(262, 327, 116, 39);
			contentPane.add(btnEditar);
			
			tablaLibros.getSelectionModel().addListSelectionListener(e -> {
			    if (!e.getValueIsAdjusting()) {
			        int row = tablaLibros.getSelectedRow();
			        if (row != -1) {
			            libroSeleccionado = new Libro(
			            		(int) model.getValueAt(row, 0),       // ID
		                        (String) model.getValueAt(row, 1),    // Título
		                        (String) model.getValueAt(row, 2),    // Descripción
		                        (String) model.getValueAt(row, 3),    // Género
		                        (String) model.getValueAt(row, 4),    // Fecha Envío
		                        (String) model.getValueAt(row, 5),    // Archivo
		                        (String) model.getValueAt(row, 6),    // Estado
		                        (int) model.getValueAt(row, 7),       // IdAutor
		                        (int) model.getValueAt(row, 8),       // Stock
		                        (double) model.getValueAt(row, 9)     // Precio
			            );
			        }
			    }
			});
			cargarTabla();
			
			btnEditar.addActionListener(e -> {
			    if (libroSeleccionado != null) {
			        EditarLibro editar = new EditarLibro(libroSeleccionado);
			        editar.setVisible(true);
			        dispose();
			    } else {
			        JOptionPane.showMessageDialog(null, "Seleccione un libro primero.");
			    }
			});
			
	}
	
	private void cargarTabla() {
	    LinkedList<Libro> todos = DLLLibro.obtenerLibros(); // este método lo crearemos si no existe
	    LinkedList<Libro> ordenados = todos.stream()
	        .sorted(Comparator.comparingInt(Libro::getIdLibro).reversed())
	        .collect(Collectors.toCollection(LinkedList::new));

	    model.setRowCount(0);
	    for (Libro l : ordenados) {
	        model.addRow(new Object[]{
	        		l.getIdLibro(),
	                l.getTitulo(),
	                l.getDescripcion(),
	                l.getGenero(),
	                l.getFechaEnvio(),
	                l.getArchivoLibro(),
	                l.getEstado(),
	                l.getIdAutor(),
	                l.getStock(),
	                l.getPrecio()
	        });
	    }
	}

}
