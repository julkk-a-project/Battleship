package main;

import controller.Controller;
import matrix.Matrix;
import window.Tile;
import window.Window;

public class Main {

	public static Matrix myMatrix;
	public static Matrix itMatrix;
	public static Tile tile;
	public static boolean windowOpened = false;
	public static Controller controller;
	public static String gameMode; //ALSO USED FOR IP
	
	private static boolean lost = false;
	private static boolean won = false;
	public static boolean vertical;
	
	
	
	
	
	public static void main(String[] args) {
		controller = new Controller();

		//initilaizes default water matrixes, to avoid search in empty matrix.
        myMatrix = new Matrix(10,10,controller);
        itMatrix = new Matrix(10,10,controller);

        new Thread() {
        	
        	public void run() {
        		
        		
        		won = false;
        		lost = false;
        		System.out.println("before waiter");
        		
        		System.out.println("after waiter");
				
				//host or join
        		while(true) {
        			controller.waiter();
        			
        			if (gameMode == "0"){
            			System.out.println("INSERT AI GAME MODE HERE AHAHAHA ÄKSDEE");
            		}
            		else if (gameMode == "1") {
    					controller.host();
    				}
            		else if(gameMode == "2") {
            			
            		}
    				else {
    					//check if IP inPutted
    					controller.join(gameMode);
    				}
        		}
        		
        	}
        }.start();

        //start javaFX thread that notifs all to make code above happen (after wait)
        new Thread() {

        	public void run() {
                window.Window.launch(Window.class, args);                
        	}
        }.start();
	}
}
