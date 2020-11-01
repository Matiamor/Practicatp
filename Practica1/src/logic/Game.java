package logic;

import java.util.Random;

import Characters.Player;
import Characters.Slayer;
import Characters.Vampire;
import view.GameObjBoard;
import view.GamePrinter;

public class Game {
	
	private int ciclos;
	private Random ran;
	private Level level;
	private Player player;
	private GamePrinter printer;
	private GameObjBoard board;
	
	public Game(Level l, long seed) {
		ran = new Random(seed);
	}
	private void init() {
		int y = level.getdimx()-1;
		ciclos = 0;
		Vampire.init(level,y);
	}
	public String info(){
		String text = "Number of cycles: " + ciclos + "\n" + "coins: " + player.getmon() +"\n" + "Remaining Vampires: "+ Vampire.getVampLista()+"\n" + "Vampires on the board: " + Vampire.getVampTableros() ;
		return text;
	}
	public String toString(){
		 String text = info() + printer.toString();
		 return text;
	}
	public String positionToString(int x, int y) {
		String posicion = " ";
		if(board.existeSlay(x, y)) {
			posicion = board.tostringS();
		}
		else if(board.existeVamp(x,y)) {
			posicion = board.tostringV();
		}
		return posicion;
	}
	public boolean addSlayer(int x, int y) {
		boolean add = false;
		if(player.getmon() >= Slayer.getcoste()) {
			if(x < level.getdimx() && y < level.getdimy()) {
				if(board.isCellEmpty(x, y)) {
					add = true;					
					board.addSla(new Slayer(x,y));
				}
			}
		}
		return add;
	}
	public boolean addVampire(int x, int y, int resistencia) {
		boolean add = false;
		double num = ran.nextDouble()%10;
		if(num >=0 && num <2) {
			if(x < level.getdimx() && y < level.getdimy()) {
				x = ran.nextInt()%level.getdimx();
				y = 0;
				if(board.isCellEmpty(x, y)) {
					if(!board.vaciaListVamp()) {
						add = true;
						board.addVampire(new Vampire(x,y,resistencia));
						board.setContSlayer();
					}
				}
			}
		}
		
		return add;
	}
	public void update() {
		float num;
		int i=0;
		num = ran.nextFloat()%10;
		if(num >= 0 && num < 5 ) {
			player.aniadirMondeas();		
		}
		if(ciclos%2 == 0) {
			while(i < Vampire.getVampTableros()) {
				if(!board.existeVamp(board.getObjV(i).getx(), board.getObjV(i).gety()-1) && !board.existeSlay(board.getObjV(i).getx(), board.getObjV(i).gety()-1) && board.getObjV(i).gety()-1 < level.getdimy()) {
					board.moverVamp(i);
				}
				i++;
			}
		}		
	}
	public void aplicarDanioAVamp() {
		int i = 0;
		int j = 1;
		boolean danio = false;
		while( i < board.getContSlayer()) {
			while(danio == false && board.getObjS(i).gety() + j < level.getdimy()) {
				if(board.existeVamp(board.getObjS(i).getx(),board.getObjS(i).gety() + j)) {
					danio = true;
					board.danioAvampiro(board.getObjS(i).getx(),board.getObjS(i).gety() + j);
					if(board.getObjV(i).getresis() == 0) {
						board.moverVamp(i);
					}
				}
				else {
					j++;
				}
			}
			j=1;
			i++;
		}
	}
	public void aplicarDanioASla() {
		int i = 0;
		int j = 1;
		while( i < board.getContSlayer()) {
			while(j < Vampire.getVampTableros()) {
				if(board.getObjS(i).gety() + 1 == board.getObjV(j).gety()) {
					board.danioASlayer(i);
				}
				j++;
			}
			j=1;
			i++;
		}
	}
	public void muereSlayer() {
		int i=0;
		while(i < board.getContSlayer()) {
			if(board.getObjS(i).getresis() == 0) {
				board.muereSlayer(i);
			}
			i++;
		}
	}
	public void muereVampiro() {
		int i=0;
		while(i < Vampire.getVampTableros()) {
			if(board.getObjS(i).getresis() == 0) {
				board.moverVamp(i);
			}
			i++;
		}
	}
}
	

