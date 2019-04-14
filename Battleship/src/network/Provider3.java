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
    
    Provider3(){}
    void run()
    {
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
            do{
                try{
                	System.out.println("kommit hit");
                    message = (String)in.readLine();
                    System.out.println("client>" + message);
                    while (message.equals("add")) {
                    		sendMessage("du angav addition");                        
                    		double x, y;
                    		message = (String)in.readLine();
                    		System.out.println("läst in x ");
                    		x = Double.parseDouble(message);
                    		sendMessage("läste in " + x);
                    		message = (String)in.readLine();
                    		y = Double.parseDouble(message);
                    		System.out.println("läst in y ");
                    		sendMessage("läste in " + y);
                    		sendMessage("Summan av " + x + " + "+ y + " är " + (x+y));
                        }
  
                    if (message.equals("bye")) sendMessage("Hejdå, det här gick ju bra");
                }
                catch(Exception classnot){
                    System.err.println("Data received in unknown format");
                }
            }while(!message.equals("bye"));
        }
        catch(IOException ioException){
            ioException.printStackTrace();
        }

        finally{
        	System.out.println("kommit hit2");
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
    }
    void sendMessage(String msg)
    {
        try{
            out.println(msg);
            out.flush();
            System.out.println("server>" + msg);
        }
        catch(Exception ioException){
            ioException.printStackTrace();
        }
    }
    public static void main(String args[])
    {
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
}