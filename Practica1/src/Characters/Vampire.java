package Characters;

import java.util.Random;

import logic.Game;
import logic.Level;

public class Vampire {
	private int x, y;
	
	private int resistencia = 3;
	private static int danio;
	private static int remainingVampires;
	private static int vampiresOnTheBoard;
	private static Game game = new Game(level,rand);
	
	public Vampire(int x, int y, int resist ) {
		remainingVampires--;
		vampiresOnTheBoard++;
		this.x = x;
		this.y = y;
		this.resistencia = resist;
	}
	public static void init(Level l, int y) {
		remainingVampires = l.getNumberOfVampires();
		vampiresOnTheBoard = 0;	
	}
	public static int getVampTableros() {
		return vampiresOnTheBoard;
	}
	public static int setVampTableros() {
		return vampiresOnTheBoard--;
	}
	public static int getVampLista() {
		return remainingVampires;
	}
	public static int getTotales() {
		return remainingVampires + vampiresOnTheBoard;
	}
	public String tostring() {
		return "V"+ "["+this.resistencia+"]";
	}
	public int getx() {
		return this.x;
	}
	public int setX() {
		return this.x+1;
	}
	public int gety() {
		return this.y;
	}
	public int setY() {
		return this.y-1;
	}
	public int getresis() {
		return this.resistencia;
		}
	public int setresis() {
		return this.resistencia - 1;
	}
	public int getdanio() {
		return this.danio;
	}
}
