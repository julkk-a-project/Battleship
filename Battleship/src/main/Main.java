package main;

import javax.swing.JOptionPane;

import matrix.Matrix;
import network.Provider3;
import network.Requester3;

public class Main {

	//public Window window;
	
	public static Matrix myMatrix;
	public static Matrix itMatrix;

	public static void main(String[] args) {
		System.out.println("Hello World!!!!!!"); //i am not useful tbh
		
		//Launch game window here :) (aka typ: window = new window();)
		
		
		//tempSystem for dev testing:
		
		String host = JOptionPane.showInputDialog("host (y/n)");
		

		//Creates ur playingfield
        myMatrix = new Matrix(10,10);
        myMatrix.putHull();
		
		
		if (host.equals("y")) {
			//Hoster

			//current model of thougth says that this should be run when waiting for a resposne from the other player
			
			boolean hisTurn = true;
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
	        	hisTurn = true;
		        while(hisTurn){
		            hisTurn = server.run();
		        }
		        System.out.println("UR TURN");
		        
		        
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Check if cords point to a water tile on own map to avoid dumb shooting.
		        
		        server.run(cords);
	        }
	        

	        server.disconnect();
			
		}
		else {
			//Joiner

	        Requester3 client = new Requester3(); // an object wi
	        
	        

	        //Connects
	        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        boolean connected = false;
	        while (!connected) {
		        connected = client.connect();	        	
	        }
	        

	        boolean hisTurn = false;
	        
	        
	        System.out.println("UR TURN");
	        for (int i = 0; i < 10; i++) {

	        	
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Chek if cords point to a water tile on own map to avoid dumb shooting.

		        
		        client.run(cords);
		        
		        
		        System.out.println("HIS TURN");
		        hisTurn = true;
		        while(hisTurn){
		            hisTurn = client.run();
		        }
		        System.out.println("UR TURN");
		        
	        }
	        client.disconnect();
	        
	        
		}
		
		

	}

}
