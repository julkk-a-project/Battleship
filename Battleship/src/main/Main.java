package main;

import javax.swing.JOptionPane;

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
	
	
	public static void main(String[] args) {
		controller = new Controller();

		//initilaizes default water matrixes, to avoid search in empty matrix.
        myMatrix = new Matrix(10,10,controller);
        itMatrix = new Matrix(10,10,controller);
        
        
        
		//tempSystem for dev testing:	
		//String host = JOptionPane.showInputDialog("host (y/n)");

        new Thread() {
        	
        	public void run() {
        		
        		
        		won = false;
        		lost = false;
        		System.out.println("before waiter");
        		controller.waiter();
        		System.out.println("after waiter");
				
				//host or join
        		if (gameMode == "0"){
        			System.out.println("INSERT AI GAME MODE HERE AHAHAHA �KSDEE");
        		}
        		else if (gameMode == "1") {
					controller.host();
				}
				else {
					//chek if IP inputted
					controller.join(gameMode);
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
	
	/* 
	 /////////////////////////////////////
	 //	Everything moved to controller:	//
	 /////////////////////////////////////	 
	
	
	public static void host() {
		//Host
		//current model of thought says that this should be run when waiting for a response from the other player
		
		hisTurn = true;
        Provider3 server = new Provider3();
        //Requester3 client = new Requester3();

        //We'll see if this is even needed now :)))
        	//Temporary because i'm lazy and don't know how to do it automatically
        	//server.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
                
        boolean connected = false;
        while (!connected) {
        	connected = server.connect();
        }
        
        for (int i = 0; i < 10; i++) {
        	System.out.println("HIS TURN");
        	window.Window.appendLog("HIS TURN");
        	hisTurn = true;
	        while(hisTurn){
	            hisTurn = server.run();
	        }
	        draw();
	        
	        System.out.println("UR TURN");
	        window.Window.appendLog("UR TURN");
	        
	        //int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        //int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
	        //cords[0] = cordX;
	        //cords[1] = cordY;
	        
        	giveCords = true;
	        waiter();    
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.
	        server.run(cords);
	        draw();
        	giveCords = false;
        }

        server.disconnect();		
	}
	
	
	
	public static void join(String ip) {

		//Joiner
        Requester3 client = new Requester3(); // an object wi

        //Connects
        client.setServer(ip); //IP to connect to
        boolean connected = false;
        while (!connected) {
	        connected = client.connect();	        	
        }
        
        hisTurn = false;
  
        System.out.println("UR TURN");
        window.Window.appendLog("UR TURN");
        
        draw();
        
        for (int i = 0; i < 10; i++) {
        	
	        //int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        //int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));

	        //cords[0] = cordX;
	        //cords[1] = cordY;
	        
        	giveCords = true;
	        waiter();
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.
	        client.run(cords);
	        draw();
        	giveCords = false;
        	
	        System.out.println("HIS TURN");
	        window.Window.appendLog("HIS TURN");
	        
	        hisTurn = true;
	        
	        while(hisTurn){
	            hisTurn = client.run();
	        }
	        draw();
	        
	        System.out.println("UR TURN");
	        window.Window.appendLog("UR TURN");
	        
        }
        client.disconnect();
	}
	
	
	
	private static void draw() {
        window.Window.draw();
	}

	public static void waiter() {
		waiterRunner.run();
	}
	
	public static void waker() {
		waiterRunner.runWaker();
	}
	public static boolean canCord() {
    	return giveCords;
	}
	public static void loose() {
		System.out.println("DEVHELP: LOST CALLED");
		lost = true;
	}
	public static boolean hasLost() {
		return lost;
	}
	public static void win() {
		System.out.println("DEVHELP: WIN CALLED");
		won = true;
	}
	public static boolean hasWon() {
		return won;
	}
*/	

}
