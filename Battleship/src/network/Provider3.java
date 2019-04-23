// allmänt tillgänglig på nätet, editerat från t.ex. http://zerioh.tripod.com/ressources/sockets.html

package network;

import java.io.*;
import java.net.*;

public class Provider3 {
    ServerSocket providerSocket;
    Socket connection = null;
    int port = 2004;
    String message;
    PrintWriter out;
    BufferedReader in;
	String [] ok = new String [50];    
	int i = 0;
	private boolean turnNotOver;
    
    public Provider3(){}
    
    
    public void connect() {
    	try{
            //1. creating a server socket
            providerSocket = new ServerSocket(port, 10);
            //2. Wait for connection
            System.out.println("Waiting for connection");
            connection = providerSocket.accept();
            System.out.println("Connection received from " + connection.getInetAddress().getHostName() + " and accepted on " + connection.getLocalSocketAddress() + " blahaa: " + connection.getOutputStream());
            //3. get Input and Output streams
            in = new BufferedReader (new InputStreamReader (connection.getInputStream()));
            out = new PrintWriter (new BufferedWriter ( new OutputStreamWriter(connection.getOutputStream())), true);
            sendMessage("Connection successful");
            //4. The two parts communicate via the input and output streams
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

    }
    
    public void disconnect() {

    	System.out.println("connection closing");
    	//4: Closing connection
    	try{
    		in.close();
    		out.close();
    		providerSocket.close();
    	}
    	catch(IOException ioException){
    		ioException.printStackTrace();
    	}
    }
    
    
    
    public boolean run() {

            turnNotOver = true;
        	
            do{
                try{
                	//System.out.println("kommit hit");
                    message = (String)in.readLine();
                    //add message handling here
                    System.out.println("client>" + message); //only shows message
                    
                    
                    //Waits untill message is a cordinate
                    if (isCordinate(message)) {
                    		sendMessage(cordinateHandler(message));
                        }
                    
  
                    
                    if (message.equals("copy")) {
                        turnNotOver = false;
                    }
                }
                catch(Exception classnot){
                    System.err.println("Data received in unknown format");
                }
            }while(!message.equals("copy"));
            turnNotOver = false;

        return turnNotOver;
    }
    
    
    
	void sendMessage(String msg){
        try{
            out.println(msg);
            out.flush();
            System.out.println("server>" + msg);
        }
        catch(Exception ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String args[]) {
        Provider3 server = new Provider3();
        while(true){
            server.run();
        }
    }
    
    ///////////////////
    //Personal edits://
    ///////////////////
    
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
     * use me to determen if a cordinate was sent
     */
    public boolean isCordinate(String message) {
    	try {
        	String[] cords = message.split(",", 2);
        	return true;
    	}catch(Exception e){
    		appendLog(e+"");
    		return false;
    	}
    }
    
    /*
     * use me to change what the matrixes look like, and return HitMiss, shipSunk and WinLoose message.
     */
    private String cordinateHandler(String message2) {
    	String string = "";
    	
    	//handle message here
    	
    	string += "1,1,0"; //Example
    	
    	
    	
    	
		return string;
	}
    
    
    
    
    
}