package main;

import javax.swing.JOptionPane;

import matrix.Matrix;
import network.Provider3;
import network.Requester3;
import window.Tile;
import window.Window;

public class Main {

	//public Window window;
	
	public static Matrix myMatrix;
	public static Matrix itMatrix;
	public static Tile tile;
	public static int[] cords;

	public static boolean windowOpened = false;
	private static WaiterRunner waiterRunner;
	public static boolean hisTurn;
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!!!!!!"); //i am not useful tbh

        Waiter waiter = new Waiter();
        waiterRunner = new WaiterRunner(waiter);
        
        
		//tempSystem for dev testing:	
		String host = JOptionPane.showInputDialog("host (y/n)");

		//Creates ur playingField
        myMatrix = new Matrix(10,10);
        
        //customize your ship layout here
        myMatrix.putHull(3);
        
        //creates empty "projection" of enemy field
        itMatrix = new Matrix(10,10);
        
        
        new Thread() {
        	
        	public void run() {
        		try {
					
        			waiter();
					
					//host or join
					if (host.equals("y")) {
						host();
					}
					else {
						join();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("RESTART plox");
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
	        /*
	        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
	        cords[0] = cordX;
	        cords[1] = cordY;
	        */
	        
	        waiter();
	        
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.
	        
	        server.run(cords);
	        draw();
        }
        

        server.disconnect();
		
	}
	
	
	
	public static void join() {

		//Joiner

        Requester3 client = new Requester3(); // an object wi
        
        

        //Connects
        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
        boolean connected = false;
        while (!connected) {
	        connected = client.connect();	        	
        }
        

        hisTurn = false;
        
        
        System.out.println("UR TURN");
        window.Window.appendLog("UR TURN");
        
        draw();
        
        for (int i = 0; i < 10; i++) {

        	/*
	        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));

	        cords[0] = cordX;
	        cords[1] = cordY;
	        */

	        waiter();
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.

	        
	        client.run(cords);
	        draw();
	        
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
	

}
