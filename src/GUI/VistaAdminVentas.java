package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BLL.Venta;
import DLL.DLLVenta;

import java.awt.Font;
import java.util.LinkedList;

public class VistaAdminVentas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable tablaVentas;
    private DefaultTableModel modelo;

    public VistaAdminVentas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblTitulo = new JLabel("Ventas Registradas");
        lblTitulo.setFont(new Font("Courier New", Font.PLAIN, 30));
        lblTitulo.setBounds(167, 11, 400, 40);
        contentPane.add(lblTitulo);

        String[] columnas = {
            "idVenta",
            "idUsuario",
            "idLibro",
            "Fecha Venta",
            "Cantidad",
            "Precio Unitario",
            "Precio Total"
        };

        modelo = new DefaultTableModel(null, columnas);
        tablaVentas = new JTable(modelo);

        JScrollPane scrollPane = new JScrollPane(tablaVentas);
        scrollPane.setBounds(30, 70, 580, 350);
        contentPane.add(scrollPane);
        
        JButton btnVerDetalle = new JButton("Ver detalle");
        btnVerDetalle.setBounds(245, 427, 150, 23);
        contentPane.add(btnVerDetalle);

        btnVerDetalle.addActionListener(e -> {
            int filaSeleccionada = tablaVentas.getSelectedRow();

            if (filaSeleccionada == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione una venta de la tabla.");
                return;
            }

            int idVenta = (int) modelo.getValueAt(filaSeleccionada, 0);

            // Llamamos a la vista detalle, pasándole el idVenta
            VistaDetalleAdmin vistaDetalle = new VistaDetalleAdmin(idVenta);
            vistaDetalle.setVisible(true);
        });

        // Cargar datos
        cargarVentas();
    }

    private void cargarVentas() {
        LinkedList<Venta> ventas = DLLVenta.obtenerVentas();

        modelo.setRowCount(0);

        for (Venta v : ventas) {
            modelo.addRow(new Object[]{
                v.getIdVenta(),
                v.getIdUsuario(),
                v.getIdLibro(),
                v.getFechaVenta(),
                v.getCantidad(),
                v.getPrecioUnitario(),
                v.getPrecioTotal()
            });
        }
    }
}
