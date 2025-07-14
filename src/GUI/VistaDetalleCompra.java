package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import BLL.Venta;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class VistaDetalleCompra extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	
	public VistaDetalleCompra(Venta venta, Libro libro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 553, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel Titulo = new JLabel("Detalle de compra");
		Titulo.setFont(new Font("Courier New", Font.PLAIN, 30));
		Titulo.setBounds(122, 11, 365, 34);
		contentPane.add(Titulo);

		JLabel LibroTitulo = new JLabel("Título: " + libro.getTitulo());
		LibroTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		LibroTitulo.setBounds(10, 67, 517, 14);
		contentPane.add(LibroTitulo);

		JLabel GeneroLibro = new JLabel("Género: " + libro.getGenero());
		GeneroLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GeneroLibro.setBounds(10, 99, 517, 14);
		contentPane.add(GeneroLibro);

		JLabel CantidadCompra = new JLabel("Cantidad comprada: " + venta.getCantidad());
		CantidadCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		CantidadCompra.setBounds(10, 124, 517, 30);
		contentPane.add(CantidadCompra);

		JLabel PrecioTotalCompra = new JLabel("Precio total: $" + venta.getPrecioTotal());
		PrecioTotalCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		PrecioTotalCompra.setBounds(10, 165, 517, 14);
		contentPane.add(PrecioTotalCompra);

		JLabel FechaCompra = new JLabel("Fecha de compra: " + venta.getFechaVenta());
		FechaCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		FechaCompra.setBounds(10, 204, 517, 14);
		contentPane.add(FechaCompra);

		JLabel DescripcionLibroCompra = new JLabel("Descripción: " + libro.getDescripcion());
		DescripcionLibroCompra.setFont(new Font("Tahoma", Font.PLAIN, 14));
		DescripcionLibroCompra.setVerticalAlignment(SwingConstants.TOP);
		DescripcionLibroCompra.setBounds(10, 240, 517, 128);
		contentPane.add(DescripcionLibroCompra);
	}
}
