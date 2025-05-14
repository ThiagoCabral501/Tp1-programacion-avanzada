package tp1;

public class Libro {
	private int idLibro;
	private String titulo;
	private String descripcion;
	private String genero;
	private String fechaEnvio;
	private String archivoLibro;
	private String estado;
	private int idAutor;
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
	

}
