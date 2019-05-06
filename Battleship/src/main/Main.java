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
	
	
	
	public static void main(String[] args) {
		System.out.println("Hello World!!!!!!"); //i am not useful tbh
		
		//tempSystem for dev testing:	
		String host = JOptionPane.showInputDialog("host (y/n)");

		//Creates ur playingField
        myMatrix = new Matrix(10,10);
        
        //customize your ship layout here
        myMatrix.putHull(3);
        
        //creates empty "projection" of enemy field
        itMatrix = new Matrix(10,10);
        
		//Launch game window here :) (aka typ: window = new window();)		
       
        new Thread() {
        	
        	public void run() {
        		try {
					wait(); //wait for window to load

					
					
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
        
        /*
        
        
        int waitTime = 0;
        while (!windowOpened) {
        	waitTime++;

            try {
    			Thread.sleep(100);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}        	
        }
		
    	System.out.println("wait time: "+waitTime*100+" timeUnits");
        */
		//JOptionPane.showMessageDialog(null, "wait a few sec plz");
        /*
		if (host.equals("y")) {
			host();
		}
		else {
			join();
		}
		*/
		//end of temp system
	}
	
	
	public static void host() {
		//Host

		//current model of thought says that this should be run when waiting for a response from the other player
		
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
        	window.Window.appendLog("HIS TURN");
        	hisTurn = true;
	        while(hisTurn){
	            hisTurn = server.run();
	        }
	        window.Window.draw();
	        
	        System.out.println("UR TURN");
	        window.Window.appendLog("UR TURN");
	        
	        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
	        cords[0] = cordX;
	        cords[1] = cordY;
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.
	        
	        server.run(cords);
	        window.Window.draw();
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
        

        boolean hisTurn = false;
        
        
        System.out.println("UR TURN");
        window.Window.appendLog("UR TURN");
        
        window.Window.draw();
        
        for (int i = 0; i < 10; i++) {

        	
	        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
	        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));

	        cords[0] = cordX;
	        cords[1] = cordY;
	        
	        //Check if cords point to a water tile on own map to avoid dumb shooting.

	        
	        client.run(cords);
	        
	        
	        System.out.println("HIS TURN");
	        window.Window.appendLog("HIS TURN");
	        
	        hisTurn = true;
	        
	        while(hisTurn){
	            hisTurn = client.run();
	        }
	        
	        window.Window.draw();
	        
	        System.out.println("UR TURN");
	        window.Window.appendLog("UR TURN");
	        
        }
        client.disconnect();
        
        
	}
	
	

}
