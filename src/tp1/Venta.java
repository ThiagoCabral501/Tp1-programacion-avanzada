package tp1;

public class Venta {
	
	private int idVenta;
	private int idLibro;
	private String fechaVenta;
	private int cantidad;
	private double precio;
	
	public Venta(int idVenta, int idLibro, String fechaVenta, int cantidad, double precio) {
		this.idVenta = idVenta;
		this.idLibro = idLibro;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
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

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", idLibro=" + idLibro + ", fechaVenta=" + fechaVenta + ", cantidad="
				+ cantidad + ", precio=" + precio + "]";
	}
	

}
