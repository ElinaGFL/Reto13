package conversor;

class Euro extends Moneda {
	
	Euro(String nombre) {
		super(nombre);
		this.setTasaCompra(0.0015);
		this.setTasaVenta(655.96);
	}

	protected double comprar(double xaf) {
		return xaf * this.getTasaCompra();
	}

	protected double vender(double xaf) {
		return xaf / this.getTasaVenta();
	}
}
