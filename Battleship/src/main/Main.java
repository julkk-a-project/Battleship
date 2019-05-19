package main;

import controller.Controller;
import controller.ShipPlacer;
import matrix.Matrix;
import model.Model;
import window.Tile;
import window.Window;

public class Main {

	
	public static Model model;
	
	
	
	public static Matrix myMatrix;
	public static Matrix itMatrix;
	public static Tile tile;
	public static boolean windowOpened = false;
	public static Controller controller;
	public static String gameMode; //ALSO USED FOR IP
	
	private static boolean lost = false;
	private static boolean won = false;
	public static boolean vertical;
	private static String logBuffer;
	private static boolean hasBuffer;
	
	
	
	
	
	
	
	
	public static void main(String[] args) {

		model = new Model();
		controller = new Controller();

		//initializes default water matrixes, to avoid search in empty matrix.
        myMatrix = new Matrix(10,10,controller);
        itMatrix = new Matrix(10,10,controller);

        new Thread() {
        	
        	public void run() {
        		
        		
        		won = false;
        		lost = false;
        		/*
        		System.out.println("before waiter");
        		Controller.waiter();
        		System.out.println("after waiter");
        		*/
				
				//host or join
        		while(true) {
            		System.out.println("before waiter");
        			Controller.waiter();
            		System.out.println("after waiter");
        			
        			if (gameMode == "0"){
            			System.out.println("INSERT AI GAME MODE HERE AHAHAHA ÄKSDEE");
            		}
            		else if (gameMode == "1") {
    					controller.host();
    				}
            		else if(gameMode == "2") {
            			System.out.println("Entered shipBuilding Mode");
            			ShipPlacer.shipPlacer();
            		}
    				else {
    					//check if IP inPutted
    					controller.join(gameMode);
    				}
        		}
        		
        	}
        }.start();

        //start javaFX thread that notify all to make code above happen (after wait)
        new Thread() {

        	public void run() {
                window.Window.launch(Window.class, args);                
        	}
        }.start();
	}




	public static void addToBuffer(String string) {
		logBuffer += string + "\n";
		hasBuffer = true;
		
	}




	public static boolean hasBuffer() {
		return hasBuffer;
	}




	public static String getBuffer() {
		String temp = logBuffer;
		logBuffer = "";
		hasBuffer = false;
		return temp;
	}
}
