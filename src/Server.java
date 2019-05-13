
import java.io.*;
import java.util.*;
import java.net.*;
import java.net.InetAddress;


public class Server
{
	
	/*
	 * Member variables
	 */
	
	public static int port;
	private String serverHost;

	boolean doRun = true;
	private static URL whatismyip;
	

	
	public static Scanner keyboard = new Scanner(System.in);
	
	
	/*
	 * main() method
	 * 
	 */
	
	public static void main(String[] args) throws IOException
	{
		
		
		portPrompt();
		System.out.println();
		System.out.println("Attempting to start the DEATHSTAR server...");
		
		new Server().runServer();
		
		
	}
	
	// prompt the user for the port the Server needs to listen on for connections
	
	public static void portPrompt()
	{
		
		System.out.print("Enter a port to listen on: ");
		port = keyboard.nextInt();
		
	}
	
	/*
	 * 
	 * runServer() method
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
		System.out.println("Private Internet Protocol Address: " + InetAddress.getLocalHost().getHostAddress());
		System.out.println("DEATHSTAR is listening for communications on port: " + port);
		
		try
		{
		ServerSocket serverSocket = new ServerSocket(port);
		System.out.println("The server is now waiting for connections...");
		System.out.println();
			
			while(doRun) //WHILE THE SERVER IS RUNNING DO THIS LOOP
			{
			
				
				Socket socket = serverSocket.accept();
				new ServerThread(socket).start();
				//System.out.print("DEATHSTAR CMD SHELL: ");
				//String userCommandBuffer = keyboard.next();
				//System.out.println(userCommandBuffer);
			
			}
		
		}	
		catch (Exception e) 
		{
			System.out.println("The server failed to bind to the port");
		}
		
		
		
		
		
	}
	

}

