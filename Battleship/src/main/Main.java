package main;

import javax.swing.JOptionPane;

import network.Provider3;
import network.Requester3;

public class Main {

	//public Window window;
	
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
	        Requester3 client = new Requester3(); // an object wi
	        

	        //Temporary because i'm lazy and don't know how to do it automatically
	        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        
	        
	        
	        for (int i = 0; i < 10; i++) {
	        	hisTurn = true;
		        while(hisTurn){
		            hisTurn = server.run();
		        }
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        client.run(cords);
		        
	        }
			
		}
		else {
			//Joiner

	        Provider3 server = new Provider3();
	        Requester3 client = new Requester3(); // an object wi
	        
	        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        
	        boolean hisTurn = false;
	        
	        
	        for (int i = 0; i < 10; i++) {
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        client.run(cords);
		        
		        hisTurn = true;
		        while(hisTurn){
		            hisTurn = server.run();
		        }
		        
	        }
		}
		
		

	}

}
