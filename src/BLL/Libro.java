package BLL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

import DLL.Conexion;
import DLL.DLLLibro;

public class Libro {
	private int idLibro;
	private String titulo;
	private String descripcion;
	private String genero;
	private String fechaEnvio;
	private String archivoLibro;
	private String estado;
	private int idAutor;
	private int stock;
	private double precio;
	
	
	public Libro(int idLibro, String titulo, String descripcion, String genero, String fechaEnvio, String archivoLibro,
			String estado, int idAutor, int stock, double precio) {
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.genero = genero;
		this.fechaEnvio = fechaEnvio;
		this.archivoLibro = archivoLibro;
		this.estado = estado;
		this.idAutor = idAutor;
		this.stock = stock;
		this.precio = precio;
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
	public int getStock() {
	    return stock;
	}
	public void setStock(int stock) {
	    this.stock = stock;
	}
	public double getPrecio() {
	    return precio;
	}
	public void setPrecio(double precio) {
	    this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", descripcion=" + descripcion + ", genero="
				+ genero + ", fechaEnvio=" + fechaEnvio + ", archivoLibro=" + archivoLibro + ", estado=" + estado
				+ ", idAutor=" + idAutor + ", stock=" + stock + ", precio=" + "]";
	}
	
	public static String editarLibro(Libro libro) {
	    if (libro.getTitulo().isEmpty() ||
	        libro.getGenero().isEmpty() ||
	        libro.getDescripcion().isEmpty() ||
	        libro.getArchivoLibro().isEmpty() ||
	        libro.getEstado().isEmpty() ||
	        libro.getStock() < 0 ||
	        libro.getPrecio() < 0) {
	        
	        return "Datos inválidos, verifique los campos.";
	    } else {
	        return DLLLibro.editarLibro(libro);
	    }
	}

}
