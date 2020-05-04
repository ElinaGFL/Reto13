package conversor;

abstract class Moneda {
	
	private String nombre;
	private double tasa_venta, tasa_compra;
	
	Moneda(String nombre) {
		this.nombre = nombre;
	}
	
	String getNombre() {
		return this.nombre;
	}
	
	double getTasaVenta() {
		return this.tasa_venta;
	}
	
	double getTasaCompra() {
		return this.tasa_compra;
	}

	protected abstract double comprar(double xaf);
	
	protected abstract double vender(double xaf);

}
