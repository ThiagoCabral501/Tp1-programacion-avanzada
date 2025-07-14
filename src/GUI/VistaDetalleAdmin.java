package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BLL.Libro;
import BLL.Usuario;
import BLL.Venta;
import DLL.DLLLibro;
import DLL.DLLUsuario;
import DLL.DLLVenta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

public class VistaDetalleAdmin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblIdVenta;
    private JLabel lblUsuario;
    private JLabel lblEmail;
    private JLabel lblTituloLibro;
    private JLabel lblFecha;
    private JLabel lblCantidad;
    private JLabel lblPrecioTotal;

    public VistaDetalleAdmin(int idVenta) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Detalle de Venta");
        lblTitulo.setFont(new Font("Courier New", Font.PLAIN, 30));
        lblTitulo.setBounds(80, 10, 350, 40);
        contentPane.add(lblTitulo);

        lblIdVenta = new JLabel("ID Venta:");
        lblIdVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblIdVenta.setBounds(30, 70, 400, 20);
        contentPane.add(lblIdVenta);

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuario.setBounds(30, 100, 400, 20);
        contentPane.add(lblUsuario);

        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setBounds(30, 130, 400, 20);
        contentPane.add(lblEmail);

        lblTituloLibro = new JLabel("Título Libro:");
        lblTituloLibro.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTituloLibro.setBounds(30, 160, 400, 20);
        contentPane.add(lblTituloLibro);

        lblFecha = new JLabel("Fecha de Venta:");
        lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblFecha.setBounds(30, 190, 400, 20);
        contentPane.add(lblFecha);

        lblCantidad = new JLabel("Cantidad:");
        lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCantidad.setBounds(30, 220, 400, 20);
        contentPane.add(lblCantidad);

        lblPrecioTotal = new JLabel("Precio Total:");
        lblPrecioTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblPrecioTotal.setBounds(30, 250, 400, 20);
        contentPane.add(lblPrecioTotal);

        // Cargar los datos dinámicamente
        cargarDatos(idVenta);
    }

    private void cargarDatos(int idVenta) {
        Venta venta = null;
        for (Venta v : DLLVenta.obtenerVentas()) {
            if (v.getIdVenta() == idVenta) {
                venta = v;
                break;
            }
        }

        if (venta != null) {
            // Buscar usuario
            Usuario usuario = null;
            for (Usuario u : DLLUsuario.mostrarUsuarios()) {
                if (u.getId() == venta.getIdUsuario()) {
                    usuario = u;
                    break;
                }
            }

            // Buscar libro
            Libro libro = null;
            for (Libro l : DLLLibro.obtenerLibros()) {
                if (l.getIdLibro() == venta.getIdLibro()) {
                    libro = l;
                    break;
                }
            }

            // Asignar textos a los labels
            lblIdVenta.setText("ID Venta: " + venta.getIdVenta());
            lblUsuario.setText("Usuario: " + (usuario != null ? usuario.getNombre() : "Desconocido"));
            lblEmail.setText("Email: " + (usuario != null ? usuario.getEmail() : "Desconocido"));
            lblTituloLibro.setText("Título Libro: " + (libro != null ? libro.getTitulo() : "Desconocido"));
            lblFecha.setText("Fecha de Venta: " + venta.getFechaVenta());
            lblCantidad.setText("Cantidad: " + venta.getCantidad());
            lblPrecioTotal.setText("Precio Total: $" + venta.getPrecioTotal());
        } else {
            JOptionPane.showMessageDialog(null,
                    "No se encontró la venta con ID: " + idVenta);
        }
    }
}