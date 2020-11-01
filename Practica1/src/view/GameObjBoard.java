package view;

import Characters.Slayer;
import Characters.SlayerList;
import Characters.Vampire;
import Characters.VampireList;

public class GameObjBoard {
	
	private VampireList vampire;
	private SlayerList slayer;
	
	public boolean existeVamp(int x, int y){
		return vampire.isVampireHere(x, y);
	}
	public boolean existeSlay(int x, int y){
		return slayer.isSlayerHere(x, y);
	}
	public String tostringV() {
		return vampire.toString();
	}
	public String tostringS() {
		return slayer.toString();
	}
	public void addSla(Slayer s) {
		slayer.insertar(s);
	}
	public boolean vaciaListVamp() {
		return vampire.vacia();
	}
	public boolean isCellEmpty(int x, int y) {
		boolean empty = true;
		if(vampire.isVampireHere(x, y) && slayer.isSlayerHere(x, y)) {
			empty = false;
		}
		return empty;
	}
	public void muereVampiro(int i) {
		vampire.borrar(i);
	}
	public void muereSlayer(int i) {
		slayer.borrar(i);
	}
	public void danioAvampiro(int x, int y) {
		vampire.recibeDanioVamp(x,y);
	}
	public void danioASlayer(int i) {
		slayer.recibeDanioSla(i);
	}
	public int getContSlayer() {
		return slayer.getCont();
	}
	public int setContSlayer() {
		return slayer.setCont();
	}
	public Vampire getObjV(int pos) {
		return vampire.get(pos);
	}
	public Slayer getObjS(int pos) {
		return slayer.get(pos);
	}
	public void moverVamp(int i) {
		vampire.avanzar(i);
	}
	public void addVampire(Vampire v) {
		vampire.insertar(v);
	}
	

}
