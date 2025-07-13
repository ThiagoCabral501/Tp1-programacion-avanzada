package BLL;

public class Venta {
	
	private int idVenta;
	private int idUsuario;
	private int idLibro;
	private String fechaVenta;
	private int cantidad;
	private double precioUnitario;
	private double precioTotal;
	
	//constructor sin idventa
	public Venta(int idUsuario, int idLibro, String fechaVenta, int cantidad, double precioUnitario, double precioTotal) {
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioTotal = precioTotal;
    }
	
	//constructor con idventa
	public Venta(int idVenta, int idUsuario, int idLibro, String fechaVenta, int cantidad, double precioUnitario, double precioTotal) {
		this.idVenta = idVenta;
		this.idUsuario = idUsuario;
		this.idLibro = idLibro;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.precioTotal = precioTotal;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

	public String getFechaVenta() {
		return fechaVenta;
	}

	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idLibro=" + idLibro + ", fechaVenta=" + fechaVenta + ", cantidad="
				+ cantidad + ", precioUnitario=" + precioUnitario + ", precioTotal=" + precioTotal + "]";
	}
	

}
