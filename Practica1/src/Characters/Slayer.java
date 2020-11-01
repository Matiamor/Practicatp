package Characters;
import logic.Game;

public class Slayer {
	
	private int x, y;
	private static int coste = 50;
	private int resistencia = 3;
	private int danio = 1;
	private Game game = new Game();
	
	public Slayer(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String tostring() {
		return "S"+ "["+this.resistencia+"]";
	}
	public int getx() {
		return this.x;
	}
	public int gety() {
		return this.y;
	}
	public static int getcoste() {
		return coste;
	}
	public int getresis() {
		return this.resistencia;
		}
	public int setResis() {
		return this.resistencia-1;
	}
	public int getdanio() {
		return this.danio;
	}
	
}
