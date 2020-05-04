package conversor;

class FrancoSuizo extends Moneda {
	
	private final double tasa_compra = 0.0016;
	private final double tasa_venta = 606.89;

	FrancoSuizo(String nombre) {
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
