package tp1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

public class Libro {
	private int idLibro;
	private String titulo;
	private String descripcion;
	private String genero;
	private String fechaEnvio;
	private String archivoLibro;
	private String estado;
	private int idAutor;
	
    private static Connection con = Conexion.getInstance().getConnection();
	
	public Libro(int idLibro, String titulo, String descripcion, String genero, String fechaEnvio, String archivoLibro,
			String estado, int idAutor) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.genero = genero;
		this.fechaEnvio = fechaEnvio;
		this.archivoLibro = archivoLibro;
		this.estado = estado;
		this.idAutor = idAutor;
	}
	
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFechaEnvio() {
		return fechaEnvio;
	}
	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	public String getArchivoLibro() {
		return archivoLibro;
	}
	public void setArchivoLibro(String archivoLibro) {
		this.archivoLibro = archivoLibro;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", descripcion=" + descripcion + ", genero="
				+ genero + ", fechaEnvio=" + fechaEnvio + ", archivoLibro=" + archivoLibro + ", estado=" + estado
				+ ", idAutor=" + idAutor + "]";
	}
	
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

                libros.add(new Libro(id, titulo, descripcion, genero, fechaEnvio, archivoLibro, estado, idAutor));
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
                "SELECT * FROM libro WHERE id = ?"
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

                libro = new Libro(id, titulo, descripcion, genero, fechaEnvio, archivoLibro, estado, idAutor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libro;
    }

}
