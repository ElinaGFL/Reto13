package conversor;

class FrancoSuizo extends Moneda {

	FrancoSuizo(String nombre) {
		super(nombre);
		this.setTasaCompra(0.0016);
		this.setTasaVenta(606.89);
	}

	protected double comprar(double xaf) {
		return xaf * this.getTasaCompra();
	}

	protected double vender(double xaf) {
		return xaf / this.getTasaVenta();
	}
}
