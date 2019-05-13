
import java.io.*;
import java.util.*;
import java.net.*;


public class Server
{
	
	/*
	 * Member variables
	 */
	
	public static int port;
	private static String serverHost;
	boolean doRun = true;
	private static URL whatismyip;

	
	public static Scanner keyboard = new Scanner(System.in);
	
	
	/*
	 * main() method
	 * 
	 * 	
	 * 
	 */
	
	
	public static void main(String[] args) throws IOException
	{
		
		
		System.out.print("Enter a port to listen on: ");
		port = keyboard.nextInt();
		System.out.println();
		System.out.println("Attempting to start the DEATHSTAR server...");
		
		new Server().runServer();
		
		
	}
	
	
	/*
	 * 
	 * runServer() method
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	
	public void runServer() throws IOException
	{
		
		whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader whatismyipInput = new BufferedReader(new InputStreamReader(whatismyip.openStream()));


		String publicIpAddress = whatismyipInput.readLine();
		
		
		System.out.println("[The DEATHSTAR server has successfully started]");
		System.out.println("-------------------------------------------------");
		System.out.println("Public Internet Protocol Address: " + publicIpAddress);
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("The server is now waiting for connections...");
		System.out.println();
		
		
		while(doRun) //
		{
			
			Socket socket = serverSocket.accept();
			new ServerThread(socket).start();
			
		}
		
		
		
	}
	

}

