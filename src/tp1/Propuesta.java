package tp1;

public class Propuesta {
	
	private int idPropuesta;
	private int idLibro;
	private int idAdmin;
	private String fechaPropuesta;
	private String estado;
	private String comentario;
	public Propuesta(int idPropuesta, int idLibro, int idAdmin, String fechaPropuesta, String estado,
			String comentario) {
		this.idPropuesta = idPropuesta;
		this.idLibro = idLibro;
		this.idAdmin = idAdmin;
		this.fechaPropuesta = fechaPropuesta;
		this.estado = estado;
		this.comentario = comentario;
	}
	public int getIdPropuesta() {
		return idPropuesta;
	}
	public void setIdPropuesta(int idPropuesta) {
		this.idPropuesta = idPropuesta;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public String getFechaPropuesta() {
		return fechaPropuesta;
	}
	public void setFechaPropuesta(String fechaPropuesta) {
		this.fechaPropuesta = fechaPropuesta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	@Override
	public String toString() {
		return "Propuesta [idPropuesta=" + idPropuesta + ", idLibro=" + idLibro + ", idAdmin=" + idAdmin
				+ ", fechaPropuesta=" + fechaPropuesta + ", estado=" + estado + ", comentario=" + comentario + "]";
	}
	

}
