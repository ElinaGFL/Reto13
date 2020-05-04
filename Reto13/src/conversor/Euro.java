package conversor;

class Euro extends Moneda {
	
	//private static final double
	private final double tasa_compra = 0.0015;
	private final double tasa_venta = 655.96;
	
	Euro(String nombre) {
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
