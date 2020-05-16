package conversor;

 class Moneda {
	
	private String nombre;
	private double tasaVenta, tasaCompra;

	Moneda(String nombre, double tasaCompra, double tasaVenta) {
		this.nombre = nombre;
		this.tasaCompra = tasaCompra;
		this.tasaVenta = tasaVenta;
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

	protected double comprar(double xaf) {
		return xaf * this.getTasaCompra();
	}

	protected double vender(double xaf) {
		return xaf / this.getTasaVenta();
	}
}
