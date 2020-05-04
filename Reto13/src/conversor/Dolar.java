package conversor;

class Dolar extends Moneda {
	
	//private static final double
	private final double tasa_compra = 0.0017;
	private final double tasa_venta = 589.01;

	Dolar(String nombre) {
		super(nombre);
	}

	protected double comprar(double xaf) {
		return xaf * tasa_compra;
	}

	protected double vender(double xaf) {
		return xaf / tasa_venta;
	}
	
	double getTasaVenta() {
		return this.tasa_venta;
	}
	
	double getTasaCompra() {
		return this.tasa_compra;
	}

}
