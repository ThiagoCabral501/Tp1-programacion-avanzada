package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import BLL.Usuario;
import BLL.Venta;
import DLL.DLLLibro;
import DLL.DLLVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.awt.event.ActionEvent;

public class VistaComprarLibro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField inpCantidad;
	private Libro libro;
	private Usuario usuario;
	private JLabel lblPrecioTotal;

	
	public VistaComprarLibro(Libro libro, Usuario usuario) {
		this.libro = libro;
		this.usuario = usuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloCompra = new JLabel("Compra");
		lblTituloCompra.setFont(new Font("Century Gothic", Font.PLAIN, 30));
		lblTituloCompra.setBounds(167, 11, 146, 32);
		contentPane.add(lblTituloCompra);
		
		JLabel lblTituloLibro = new JLabel("Libro: " + libro.getTitulo());
		lblTituloLibro.setBounds(87, 82, 335, 14);
		contentPane.add(lblTituloLibro);
		
		JLabel lblPrecio = new JLabel("Precio por unidad: $" + libro.getPrecio());
		lblPrecio.setBounds(87, 121, 373, 14);
		contentPane.add(lblPrecio);
		
		JLabel lblStockDisponible = new JLabel("Stock Disponible: " + libro.getStock());
		lblStockDisponible.setBounds(87, 157, 313, 14);
		contentPane.add(lblStockDisponible);
		
		JLabel lblCantidadLibro = new JLabel("Cantidad");
		lblCantidadLibro.setBounds(87, 193, 176, 14);
		contentPane.add(lblCantidadLibro);
		
		inpCantidad = new JTextField();
		inpCantidad.setBounds(87, 218, 86, 20);
		contentPane.add(inpCantidad);
		inpCantidad.setColumns(10);
		
		JButton btnCalcularTotal = new JButton("Calcular Total");
		btnCalcularTotal.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            int cantidad = Integer.parseInt(inpCantidad.getText());

		            if (cantidad <= 0) {
		                JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
		                return;
		            }

		            double precioUnitario = libro.getPrecio();
		            double precioTotal = cantidad * precioUnitario;

		            lblPrecioTotal.setText("Precio Total: $" + precioTotal);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.");
		        }
		    }
		});
		btnCalcularTotal.setBounds(200, 218, 160, 25);
		contentPane.add(btnCalcularTotal);
		
		lblPrecioTotal = new JLabel("Precio Total: $0.0");
		lblPrecioTotal.setBounds(87, 245, 300, 20);
		contentPane.add(lblPrecioTotal);
		
		JButton btnConfirmarCompra = new JButton("Confirmar Compra");
		btnConfirmarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int cantidad = Integer.parseInt(inpCantidad.getText());

					if (cantidad <= 0) {
						JOptionPane.showMessageDialog(null, "La cantidad debe ser mayor a 0.");
						return;
					}

					if (cantidad > libro.getStock()) {
						JOptionPane.showMessageDialog(null, "No hay suficiente stock disponible.");
						return;
					}
					
					double precioUnitario = libro.getPrecio();
                    double precioTotal = cantidad * precioUnitario;
                    String fechaHoy = LocalDate.now().toString();
                    
                    Venta venta = new Venta(
                        usuario.getId(),            // idUsuario
                        libro.getIdLibro(),         // idLibro
                        fechaHoy,                   // fechaVenta
                        cantidad,                   // cantidad
                        precioUnitario,             // precioUnitario
                        precioTotal                 // precioTotal
                    );
                    
                    DLLVenta.registrarVenta(venta);

					DLLLibro.actualizarStock(libro.getIdLibro(), cantidad);
					JOptionPane.showMessageDialog(null, "¡Compra realizada con éxito!");

					dispose();
					new VistaCliente(usuario).setVisible(true);

				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.");
				}
			}
		});
		btnConfirmarCompra.setBounds(87, 266, 165, 37);
		contentPane.add(btnConfirmarCompra);
	}

}
