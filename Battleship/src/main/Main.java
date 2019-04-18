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

	        Provider3 server = new Provider3();
	        while(true){
	            server.run();
	        }
			
		}
		else {
			//Joiner

	        Requester3 client = new Requester3(); // an object wi
	        
	        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
	        
	        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
	        int[] cords = {cordX, cordY};
	        
	        client.run(cords);
		}
		
		

	}

}
