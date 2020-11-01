package control;

import java.util.Scanner;

import logic.Game;

public class Controller {
	
	
	
	public final String prompt = "Command > ";
	public static final String helpMsg = String.format(
			"Available commands:%n" +
			"[a]dd <x> <y>: add a slayer in position x, y%n" +
			"[h]elp: show this help%n" + 
			"[r]eset: reset game%n" + 
			"[e]xit: exit game%n"+ 
			"[n]one | []: update%n");
	
	public static final String unknownCommandMsg = String.format("Unknown command");
	public static final String invalidCommandMsg = String.format("Invalid command");
	public static final String invalidPositionMsg = String.format("Invalid position");

    private Game game;
    private Scanner scanner;
    private boolean pasaTurno;
    
    public Controller(Game game, Scanner scanner) {
	    this.game = game;
	    this.scanner = scanner;
    }
    
    public void  printGame() {
   	 System.out.println(game);
   }
    
    public void run() {
    	int x = 0;
    	int y = 0;
    	boolean pasaTurno = true;
    	boolean instruccion = false;
    	while(instruccion == false) {
    		String line = scanner.nextLine();
        	String[] words = line.toLowerCase().trim().split("\\s+");
        	if(words[0].equals("add") || words[0].equals("a")){ 
        		x = Integer.parseInt(words[1]);
        		y = Integer.parseInt(words[2]);
        		game.addSlayer(x, y);
        		pasaTurno = false;
        		instruccion = true;
        	}
        	else if(words[0].equals("help") || words[0].equals("h")) {
    			System.out.println(helpMsg);
    		}
        	else if(words[0].equals("noone") || words[0].equals("n") || words[0].equals(" ") ) {
        		instruccion = true;
        	}
        	else if(words[0].equals("reset") || words[0].equals("r")) {
        		instruccion = true;
        	}
        	else if(words[0].equals("exit") || words[0].equals("e")) {
        		instruccion = true;
        	}
        			
    	}	
    	
    }

}

