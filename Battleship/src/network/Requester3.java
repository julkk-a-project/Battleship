// allmänt tillgänglig på nätet, editerat från t.ex. http://zerioh.tripod.com/ressources/sockets.html

package network;

import java.io.*;
import java.net.*;

public class Requester3 {
    Socket requestSocket; 	// skapar en referens till requestSocket av typen Socket i klassen java.net
    String server = "mymachine.abo.fi";
    int port = 2004;
    String message, sistaHalsning;   
    PrintWriter output;
	BufferedReader input;
	BufferedReader konsolInlast;


	
	Requester3 () {
	    	// tomt object requester med instansvariabler 
    }
	   
public static void main(String args[]) {
        Requester3 client = new Requester3(); // an object wi
        client.run();
    }
	    
    void run()
    {
        try{
            // Skapar en socket via vilken ett försök att koppla till servern sker som ligger på mymachine... och port 2004
            requestSocket = new Socket(server, port); // ändra detta till någon av dina maskiner
            System.out.println("Connected to mymachine.abo.fi on port 2004 on " + requestSocket.getLocalPort());
            // Skapar sockets för input och outputströmmarna 
            
            // märk!! en bufferedReader för inström, en Printwriter för utström och en bufferedreader för inläsning
        	input = new BufferedReader (new InputStreamReader (requestSocket.getInputStream()));
        	output = new PrintWriter(new BufferedWriter (new OutputStreamWriter (requestSocket.getOutputStream())), true);
      	  	konsolInlast = new BufferedReader (new InputStreamReader (System.in));

            // Skapar en input socket lokalt på klientmaskinen
            do {
                try{
                    message = (String)input.readLine(); // läser in vad servern skickat
                    System.out.println("server>" + message); 

                    System.out.println("ange vad du vill göra (skriv alltså 'add') ");
                    message = konsolInlast.readLine();
                    sendMessage(message); // skickar meddelandet add till metoden sendMessage 
                    
                    message = (String)input.readLine(); // läser in vad servern skickat
                    System.out.println("server>" + message);
                    
                    System.out.println("ange första heltalet:");
                    message = "42";
                    sendMessage(message); // message till metoden sendMessage 

                    message = (String)input.readLine(); // läser in vad servern skickat
                    System.out.println("server>" + message);
                    
                    System.out.println("ange andra heltalet:");
                    message = konsolInlast.readLine();
                    sendMessage(message); // message till metoden sendMessage
                    
                    message = (String)input.readLine(); // läser in vad servern skickat
                    System.out.println("server>" + message);
                    
                    message = input.readLine(); // läser svaret
                    System.out.println(message);

                    message = "bye";  
                    sendMessage(message); // skickar bye till metoden sendMessage
                    
                    sistaHalsning = input.readLine(); // läser svaret
                    System.out.println(sistaHalsning);
                }
                catch(Exception e){
                    System.err.println("data received in unknown format");
                }
            } while(!message.equals("bye"));
        }
        catch(UnknownHostException unknownHost){
            System.err.println("You are trying to connect to an unknown host!");
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }
        finally{
            // Stänger av kommunikationen
            try{
                input.close(); // stänger in socketen
                output.close(); // stänger out socketen
                requestSocket.close(); // avslutar referensen 
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }
        }
    }
    void sendMessage(String msg)
    {
        try{
        	output.println(msg); // skriver på utkanalen meddelandet
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
    public void setServer(String server) {
    	this.server = server;
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
    
    
    
    
    
    
}