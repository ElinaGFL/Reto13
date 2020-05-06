package conversor;

abstract class Moneda {
	
	private String nombre;
	private double tasaVenta, tasaCompra;

	Moneda(String nombre) {
		this.nombre = nombre;
	}
	
	String getNombre() {
		return this.nombre;
	}
	
	double getTasaVenta() {
		return tasaVenta;
	}

	void setTasaVenta(double tasa_venta) {
		this.tasaVenta = tasa_venta;
	}

	double getTasaCompra() {
		return tasaCompra;
	}

	void setTasaCompra(double tasa_compra) {
		this.tasaCompra = tasa_compra;
	}

	protected abstract double comprar(double xaf);
	
	protected abstract double vender(double xaf);
	
}
