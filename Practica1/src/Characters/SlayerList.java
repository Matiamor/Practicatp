package Characters;

public class SlayerList {
	private final static int MAX = 100;
	private Slayer []slayer;
	private Slayer s;
	private int cont;
	
	public SlayerList() {
		slayer = new Slayer[MAX];
	}
	public boolean isSlayerHere(int x, int y) {
		
		boolean esta = false;
		int i = 0;
		while(i < this.cont && esta == false) {
			if(slayer[i].getx() == x && slayer[i].gety() == y) {
				esta = true;
			}
			else {
				esta = false;
			}
			i++;
		}
		return esta;
	}
	public boolean llena() {
		return this.cont == MAX;
	}
	public boolean vacia() {
		return this.cont == 0;
	}
	public int length() {
		return this.cont;
	}
	public boolean insertar(Slayer s) {
		boolean inser = false;
		if(!llena()) {
			slayer[this.cont] = s;
			this.cont++;
			inser = true;
		}
		return inser;
	}
	public void recibeDanioSla(int i) {
		slayer[i].setResis();
	}
	public int getCont() {
		return this.cont;
	}
	public int setCont() {
		return this.cont++;
	}
	public boolean borrar(int pos){
		boolean delete = false;
		if(pos < 1 || pos > this.cont) {
			delete = false;
		}
		else {
			for(int i = pos; i < this.cont -1 ; i++) {
				slayer[i] = slayer[i+1]; 
			}
			this.cont--;
		}
		return delete;
	}
	public Slayer get(int pos) {
		if((pos < 1) || (pos > this.cont)) {
			return null;
		}
		else {
			return slayer[pos];
		}
	}
	public String toString() {
		String cad = String.format("Elemtnos de la lista: %n%n");
		for(int i = 0; i< this.cont; i++) {
			cad = cad + String.format("%s%n",slayer[i]);
		}
		return cad;
	}
	
}
