package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.LinkedList;

import BLL.Libro;
import BLL.Usuario;
import BLL.Venta;
import DLL.DLLLibro;
import DLL.DLLVenta;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaHistorialCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tablaVentas;
	private DefaultTableModel modelo;
	private Usuario usuario;

	public VistaHistorialCliente(Usuario usuario) {
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Historial de compras");
		lblTitulo.setFont(new Font("Courier New", Font.PLAIN, 30));
		lblTitulo.setBounds(135, 11, 437, 34);
		contentPane.add(lblTitulo);
		
		String[] columnas = { 
			    "Título", 
			    "Fecha", 
			    "Cantidad", 
			    "Precio Unitario", 
			    "Precio Total" 
			};

			modelo = new DefaultTableModel(null, columnas);
			tablaVentas = new JTable(modelo);
			
			JScrollPane scrollPane = new JScrollPane(tablaVentas);
			scrollPane.setBounds(30, 70, 570, 400);
			contentPane.add(scrollPane);
			
			JButton VerDetalleCompra = new JButton("Ver detalle de compra");
			VerDetalleCompra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Obtener la fila seleccionada
					int fila = tablaVentas.getSelectedRow();

			        if (fila == -1) {
			            JOptionPane.showMessageDialog(null, "Debe seleccionar una compra.");
			            return;
			        }

			        //Traer datos de la tabla
			        String titulo = modelo.getValueAt(fila, 0).toString();
			        String fecha = modelo.getValueAt(fila, 1).toString();
			        int cantidad = Integer.parseInt(modelo.getValueAt(fila, 2).toString());
			        double precioTotal = Double.parseDouble(modelo.getValueAt(fila, 4).toString());

			        // Buscar el libro por título
			        Libro libroEncontrado = null;
			        for (Libro l : DLLLibro.obtenerLibros()) {
			            if (l.getTitulo().equals(titulo)) {
			                libroEncontrado = l;
			                break;
			            }
			        }

			        if (libroEncontrado == null) {
			            JOptionPane.showMessageDialog(null, "No se encontró información del libro.");
			            return;
			        }

			        //Crear objeto Venta (para pasar datos)
			        Venta venta = new Venta(
			            usuario.getId(),
			            libroEncontrado.getIdLibro(),
			            fecha,
			            cantidad,
			            libroEncontrado.getPrecio(),
			            precioTotal
			        );

			        // Abrir la vista detalle
			        VistaDetalleCompra detalle = new VistaDetalleCompra(venta, libroEncontrado);
			        detalle.setVisible(true);
			        dispose();
			    }
			});
			VerDetalleCompra.setBounds(220, 491, 179, 23);
			contentPane.add(VerDetalleCompra);
			
			//cargar datos en la tabla
			cargarHistorial();
	}
	
	private void cargarHistorial() {
		// Obtener TODAS las ventas
		LinkedList<Venta> todasLasVentas = DLLVenta.obtenerVentas();

		//Limpiar la tabla antes de cargar
		modelo.setRowCount(0);

		//Recorrer todas las ventas
		for (Venta v : todasLasVentas) {
			// Filtrar solo las ventas de este usuario
			if (v.getIdUsuario() == usuario.getId()) {
				
				// Buscar el libro
				Libro libroEncontrado = DLLLibro.obtenerLibros().stream()
						.filter(l -> l.getIdLibro() == v.getIdLibro())
						.findFirst()
						.orElse(null);
				
				String titulo = (libroEncontrado != null) ? libroEncontrado.getTitulo() : "Desconocido";

				// Agregar fila a la tabla
				modelo.addRow(new Object[] {
					titulo,
					v.getFechaVenta(),
					v.getCantidad(),
					v.getPrecioUnitario(),
					v.getPrecioTotal()
				});
			}
		}
	}
}
