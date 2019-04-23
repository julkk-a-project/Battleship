// allm�nt tillg�nglig p� n�tet, editerat fr�n t.ex. http://zerioh.tripod.com/ressources/sockets.html

package network;

import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

public class Requester3 {
    Socket requestSocket; 	// skapar en referens till requestSocket av typen Socket i klassen java.net
    private String server = "mymachine.abo.fi";
    private int port = 2004;
    String message, sistaHalsning;   
    PrintWriter output;
	BufferedReader input;
	BufferedReader konsolInlast;


	
	public Requester3 () {
	    	// tomt object requester med instansvariabler 
    }
	   
	
	//used for testing
public static void main(String args[]) {
        Requester3 client = new Requester3(); // an object wi
        
        client.setServer(JOptionPane.showInputDialog("IP to connect to")); //IP to connect to
        
        int cordX = Integer.parseInt(JOptionPane.showInputDialog("cord X"));
        int cordY = Integer.parseInt(JOptionPane.showInputDialog("cord Y"));
        int[] cords = {cordX, cordY};
        
        client.run(cords);
    }



	public boolean connect() {
		 try{
			 System.out.println("A");
	            // Skapar en socket via vilken ett f�rs�k att koppla till servern sker som ligger p� mymachine... och port 2004
			 
			 System.out.println(server+","+port);
	            requestSocket = new Socket(server, port); // �ndra detta till n�gon av dina maskiner
	            System.out.println("Connected to "+ server +" on port "+ port +" on " + requestSocket.getLocalPort());
	            // Skapar sockets f�r input och outputstr�mmarna 
	            
	            // m�rk!! en bufferedReader f�r instr�m, en Printwriter f�r utstr�m och en bufferedreader f�r inl�sning
	        	input = new BufferedReader (new InputStreamReader (requestSocket.getInputStream()));
	        	output = new PrintWriter(new BufferedWriter (new OutputStreamWriter (requestSocket.getOutputStream())), true);
	      	  	konsolInlast = new BufferedReader (new InputStreamReader (System.in));

	            // Skapar en input socket lokalt p� klientmaskinen
	      	  	return true;
	        }
	        catch(UnknownHostException unknownHost){
				 System.out.println("B");
	            System.err.println("You are trying to connect to an unknown host!");
	            return false;
	        }
	        catch(IOException ioException){
	   			 System.out.println("C");
	            ioException.printStackTrace();
	            return false;
	        }
	}
	

	public void disconnect() {
		try{
			input.close(); // st�nger in socketen
			output.close(); // st�nger out socketen
			requestSocket.close(); // avslutar referensen 
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}

	}

	    
    public void run(int[] cords)
    {
    	do {
    		try{
    			//message = (String)JOptionPane.showInputDialog("Send info to client");
    			message = (String)input.readLine(); // l�ser in vad servern skickat
    			System.out.println("server>" + message); 

    			System.out.println("Sending cords "+cords[0]+","+cords[1]);
    			message = cords[0]+","+cords[1];
    			sendMessage(message); // skickar meddelandet add till metoden sendMessage 

    			message = (String)input.readLine(); // l�ser in vad servern skickat
    			System.out.println("server>" + message);

    			message = "copy";  
    			sendMessage(message); // skickar bye till metoden sendMessage

    			sistaHalsning = input.readLine(); // l�ser svaret
    			System.out.println(sistaHalsning);
    		}
    		catch(Exception e){
    			System.err.println("data received in unknown format");
    		}
    	} while(!message.equals("copy"));
    }
    void sendMessage(String msg)
    {
        try{
        	output.println(msg); // skriver p� utkanalen meddelandet
        	System.out.flush();
            System.out.println("client>" + msg); // skriver ut vad klienten skickat
        }
        catch(Exception ioException){
            ioException.printStackTrace();
        }
    }
    
    
    ///////////////////
    //Personal edits://
    ///////////////////
    
    
    /*
     * sets IP to what you want to connect to.
     */
    public void setServer(String ip) {
    	this.server = ip;
    }
    
    /*
     * use me to get server address from memory
     */
    public String getServer() {
    	return server;
    }
    
    /*
     * sets port to what you want to connect to.
     */
    public void setPort(int port) {
    	this.port = port;
    }
    
    /*
     * use me to get port from memory
     */
    public int getPort() {
    	return port;
    }

    /*
     * use me to send stuff to log
     */
    public void appendLog(String string) {
    	//add stuff that makes this add stuff to log
    }
    
    /*
     * i am used to see if game is lost
     */
    public boolean isLost(String message) {
    	return false;
    }
    
    
    
}