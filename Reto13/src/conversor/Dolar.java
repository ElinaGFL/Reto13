package conversor;

class Dolar extends Moneda {

	Dolar(String nombre) {
		super(nombre);
		this.setTasaCompra(0.0017);
		this.setTasaVenta(589.01);
	}

	protected double comprar(double xaf) {
		return xaf * this.getTasaCompra();
	}

	protected double vender(double xaf) {
		return xaf / this.getTasaVenta();
	}
}
