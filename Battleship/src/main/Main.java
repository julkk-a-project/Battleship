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
	        
	        
	        boolean connected = false;
	        while (!connected) {
	        	connected = server.connect();
	        }
	        
	        
	        
	        for (int i = 0; i < 10; i++) {
	        	hisTurn = true;
		        while(hisTurn){
		            hisTurn = server.run();
		        }
		        
		        /*
		        if(i == 0) {
			        client.connect();		        	
		        }
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Chek if cords point to a water tile on own map to avoid dumb shooting.
		        
		        client.run(cords);
		        */
	        }
	        

	        //client.disconnect();
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
		        client.connect();	        	
	        }
	        System.out.println("2");
	        
	        for (int i = 0; i < 10; i++) {

		        System.out.println("i+3");
	        	
		        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
		        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
		        int[] cords = {cordX, cordY};
		        
		        //Chek if cords point to a water tile on own map to avoid dumb shooting.
		        
		        client.run(cords);
		        /*
		        hisTurn = true;
		        if(i == 0) {
			        server.connect();
		        }
		        while(hisTurn){
		            hisTurn = server.run();
		        }*/
		        
	        }
	        client.disconnect();
	        //server.disconnect();
	        
	        
		}
		
		

	}

}
