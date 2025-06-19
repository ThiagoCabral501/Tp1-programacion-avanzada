package DLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import BLL.Libro;

public class DLLLibro {

    private static Connection con = Conexion.getInstance().getConnection();
    
	//Pruebas
		public static void agregarLibro(Libro libro) {
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	            		"INSERT INTO libro (titulo, descripcion, genero, fechaEnvio, archivoLibro, estado, idAutor) VALUES (?, ?, ?, ?, ?, ?, ?)"
	            );
	            stmt.setString(1, libro.getTitulo());
	            stmt.setString(2, libro.getDescripcion());
	            stmt.setString(3, libro.getGenero());
	            stmt.setString(4, libro.getFechaEnvio());
	            stmt.setString(5, libro.getArchivoLibro());
	            stmt.setString(6, libro.getEstado());
	            stmt.setInt(7, libro.getIdAutor());

	            stmt.executeUpdate();
	            System.out.println("Libro agregado correctamente.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static LinkedList<Libro> obtenerLibrosPorAutor(int idAutor) {
	        LinkedList<Libro> libros = new LinkedList<>();
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM libro WHERE idAutor = ?"
	            );
	            stmt.setInt(1, idAutor);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int id = rs.getInt("idLibro");
	                String titulo = rs.getString("titulo");
	                String descripcion = rs.getString("descripcion");
	                String genero = rs.getString("genero");
	                String fechaEnvio = rs.getString("fechaEnvio");
	                String archivoLibro = rs.getString("archivoLibro");
	                String estado = rs.getString("estado");
	                int stock = rs.getInt("stock");

	                libros.add(new Libro(id, titulo, descripcion, genero, fechaEnvio, archivoLibro, estado, idAutor, stock));
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return libros;
	    }
	    public static Libro obtenerLibrosPorID(int id) {
	    	Libro libro = null;
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "SELECT * FROM libro WHERE idLibro = ?"
	            );
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();

	            if(rs.next()) {
	            	String titulo = rs.getString("titulo");
	                String descripcion = rs.getString("descripcion");
	                String genero = rs.getString("genero");
	                String fechaEnvio = rs.getString("fechaEnvio");
	                String archivoLibro = rs.getString("archivoLibro");
	                String estado = rs.getString("estado");
	                int idAutor = rs.getInt("idAutor");
	                int stock = rs.getInt("stock");

	                libro = new Libro(id, titulo, descripcion, genero, fechaEnvio, archivoLibro, estado, idAutor, stock);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return libro;
	    }
	    
	    public static void actualizarStock(int idLibro, int cantidadComprada) {
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "UPDATE libro SET stock = stock - ? WHERE idLibro = ? AND stock >= ?"
	            );
	            stmt.setInt(1, cantidadComprada);
	            stmt.setInt(2, idLibro);
	            stmt.setInt(3, cantidadComprada); // Para evitar stock negativo
	            int filasAfectadas = stmt.executeUpdate();
	            if (filasAfectadas == 0) {
	                JOptionPane.showMessageDialog(null, "No hay suficiente stock.");
	            } else {
	                JOptionPane.showMessageDialog(null, "Compra realizada con éxito.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    
	    public static void aumentarStock(int idLibro, int cantidad) {
	        try {
	            PreparedStatement stmt = con.prepareStatement(
	                "UPDATE libro SET stock = stock + ? WHERE idLibro = ?"
	            );
	            stmt.setInt(1, cantidad);
	            stmt.setInt(2, idLibro);
	            int filasAfectadas = stmt.executeUpdate();
	            if (filasAfectadas > 0) {
	                JOptionPane.showMessageDialog(null, "Stock actualizado correctamente.");
	            } else {
	                JOptionPane.showMessageDialog(null, "No se encontró el libro.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	
}
