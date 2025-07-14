package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import BLL.Venta;

public class DLLVenta {
	
	private static Connection con = Conexion.getInstance().getConnection();
		
		public static void registrarVenta(Venta venta) {
			try {
				PreparedStatement stmt = con.prepareStatement(
						"INSERT INTO venta (idUsuario, idLibro, fechaVenta, cantidad, precioUnitario, precioTotal) VALUES (?, ?, ?, ?, ?, ?)"
				);
				
				stmt.setInt(1, venta.getIdUsuario());
				stmt.setInt(2, venta.getIdLibro());
				stmt.setString(3, venta.getFechaVenta());
				stmt.setInt(4, venta.getCantidad());
				stmt.setDouble(5, venta.getPrecioUnitario());
				stmt.setDouble(6, venta.getPrecioTotal());
				
				stmt.executeUpdate();
				System.out.println("Venta registrada correctamente.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public static LinkedList<Venta> obtenerVentas() {
		    LinkedList<Venta> lista = new LinkedList<>();
		    try {
		        PreparedStatement stmt = con.prepareStatement("SELECT * FROM venta");
		        ResultSet rs = stmt.executeQuery(); //Ejecuta el SELECT y guarda el resultado en un ResultSet
		        
		        while (rs.next()) { //recorre cada fila del ResultSet
		            Venta v = new Venta( // Crea un objeto Venta con los datos de la fila actual
		            	rs.getInt("idVenta"),
		                rs.getInt("idUsuario"),
		                rs.getInt("idLibro"),
		                rs.getString("fechaVenta"),
		                rs.getInt("cantidad"),
		                rs.getDouble("precioUnitario"),
		                rs.getDouble("precioTotal")
		            );
		            lista.add(v); // Agrega el objeto Venta a la lista
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return lista;
		}
		
}
