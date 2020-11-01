package Characters;

import logic.Level;

public class VampireList {
	
	private int cont;
	private Vampire[] vampires;
	
	public VampireList() {
		vampires = new Vampire[Vampire.getTotales()];
	}
	public boolean isVampireHere(int x, int y) {
		boolean esta = false;
		int i = 0;
		while(i < this.cont && esta == false) {
			if(vampires[i].getx() == x && vampires[i].gety() == y) {
				esta = true;
			}
			else {
				esta = false;
			}
			i++;
		}
		return esta;
	}
	public void recibeDanioVamp(int x, int y) {
		int i = 0 ;
		while(i < this.cont) {
			if(vampires[i].getx() == x && vampires[i].gety() == y) {
				vampires[i].setresis();
			}	
			i++;
		}
	}
	public void avanzar(int i) {
		if(vampires[i].gety() >= 0) {
			vampires[i].setY();
		}
	}
	public boolean llena() {
		return this.cont == Vampire.getTotales();
	}
	public boolean vacia() {
		return this.cont == 0;
	}
	public int length() {
		return this.cont;
	}
	public boolean insertar(Vampire v) {
		boolean inser = false;
		if(!llena()) {
			vampires[this.cont] = v;
			this.cont++;
			inser = true;
		}
		return inser;
	}
	public boolean borrar(int pos){
		boolean delete = false;
		if(pos < 1 || pos > this.cont) {
			delete = false;
		}
		else {
			for(int i = pos; i < this.cont -1 ; i++) {
				vampires[i] = vampires[i+1]; 
			}
			Vampire.setVampTableros();
		}
		return delete;
	}
	public Vampire get(int pos) {
		if((pos < 1) || (pos > this.cont)) {
			return null;
		}
		else {
			return vampires[pos];
		}
	}
	public String toString() {
		String cad = String.format("Elemntos de la lista: %n%n");
		for(int i = 0; i< this.cont; i++) {
			cad = cad + String.format("%s%n",vampires[i]);
		}
		return cad;
	}

}
