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
		
		if (host.equals("y")) {
			//Hoster

			//current model of thougth says that this should be run when waiting for a resposne from the other player
			
			boolean hisTurn = true;
	        Provider3 server = new Provider3();
	        //Requester3 client = new Requester3();
	        

	        
	        
	        //We'll see if this is even needed now :)))
	        	//Temporary because i'm lazy and don't know how to do it automatically
	        	//server.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        
	        
	        myMatrix = new Matrix(10,10);
	        myMatrix.putHull();
	        
	        
	        boolean connected = false;
	        while (!connected) {
	        	connected = server.connect();
	        }
	        /*
	        connected = false;
        	while(!connected) {
        		System.out.println("123");
		        connected = client.connect();
        		System.out.println("312");
        	}
        	*/
	        
	        for (int i = 0; i < 10; i++) {
	        	hisTurn = true;
		        while(hisTurn){
		            hisTurn = server.run();
		        }
		        
		        if(i == 0) {	
		        }
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Chek if cords point to a water tile on own map to avoid dumb shooting.
		        
		        server.run(cords);
	        }
	        

	        server.disconnect();
			
		}
		else {
			//Joiner

	        //Provider3 server = new Provider3();
	        Requester3 client = new Requester3(); // an object wi
	        
	        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        
	        boolean hisTurn = false;
	        
	        System.out.println("1");
	        boolean connected = false;
	        while (!connected) {
		        connected = client.connect();	        	
	        }
	        
	        
	        
	        System.out.println("2");
	        
	        for (int i = 0; i < 10; i++) {

		        System.out.println(i+3);
	        	
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Chek if cords point to a water tile on own map to avoid dumb shooting.
		        
		        client.run(cords);
		        hisTurn = true;
		        if(i == 0) {
			        client.connect();
		        }
		        while(hisTurn){
		            hisTurn = client.run();
		        }
		        
	        }
	        client.disconnect();
	        
	        
		}
		
		

	}

}
