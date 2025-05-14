package tp1;

public class Acuerdo {
	
	private int idAcuerdo;
	private int idAdmin;
	private int idLibro;
	private double porcentajeAutor;
	private double procentajeLibreria;
	private String fechaAcuerdo;
	public Acuerdo(int idAcuerdo, int idAdmin, int idLibro, double porcentajeAutor, double procentajeLibreria,
			String fechaAcuerdo) {
		this.idAcuerdo = idAcuerdo;
		this.idAdmin = idAdmin;
		this.idLibro = idLibro;
		this.porcentajeAutor = porcentajeAutor;
		this.procentajeLibreria = procentajeLibreria;
		this.fechaAcuerdo = fechaAcuerdo;
	}
	public int getIdAcuerdo() {
		return idAcuerdo;
	}
	public void setIdAcuerdo(int idAcuerdo) {
		this.idAcuerdo = idAcuerdo;
	}
	public int getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}
	public int getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public double getPorcentajeAutor() {
		return porcentajeAutor;
	}
	public void setPorcentajeAutor(double porcentajeAutor) {
		this.porcentajeAutor = porcentajeAutor;
	}
	public double getProcentajeLibreria() {
		return procentajeLibreria;
	}
	public void setProcentajeLibreria(double procentajeLibreria) {
		this.procentajeLibreria = procentajeLibreria;
	}
	public String getFechaAcuerdo() {
		return fechaAcuerdo;
	}
	public void setFechaAcuerdo(String fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}
	@Override
	public String toString() {
		return "Acuerdo [idAcuerdo=" + idAcuerdo + ", idAdmin=" + idAdmin + ", idLibro=" + idLibro
				+ ", porcentajeAutor=" + porcentajeAutor + ", procentajeLibreria=" + procentajeLibreria
				+ ", fechaAcuerdo=" + fechaAcuerdo + "]";
	}
	

}
