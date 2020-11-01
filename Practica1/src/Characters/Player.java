package Characters;

public class Player {
	private int monedas;
	
	public int getmon() {
		return this.monedas;
	}
	public int setMonedas(int monedas) {
		return this.monedas = this.monedas - monedas;
	}
	public void aniadirMondeas() {
		this.monedas = this.monedas + 10;
	}
}
