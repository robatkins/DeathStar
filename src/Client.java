import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client 
{
	
	private int sessionID;
	private String Build = "1.0.0";
	
	
	
	/*
	 * 
	 * DEATHSTAR Client
	 * 
	 * 
	 * 
	 */
	
	
	
	/*
	 * @param args
	 */
	
	public static void main(String[] args)
	{
		
		String host;
		int portNumber;
		
		if(args.length == 0)
		{
			
			host = "66.191.191.139"; //Change to the IP of the Server the Client should connect to.
			portNumber = 3302; //This should reflect the port that the Server is listening on.
			
		}
		else
		{
			
			host = args[0];
			String portStr = args[1];
			
			try
			{
				
				portNumber = Integer.parseInt(portStr);
				
			}
			catch (NumberFormatException numberFormatException)
			{
				
				System.out.println("Error assigning port number. Defaulting to port 3301.");
				portNumber = 3302; //As above.
				
			}
			
			
		}
		
		try
		{
			
			System.out.println("Attempting to connect to the Server: " + host + ":" + portNumber);
			Socket socket = new Socket(host, portNumber);
			
			//Establish input and output streams using BufferedReader and PrintStream respectively.
			BufferedReader connectionInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream connectionOutput = new PrintStream(socket.getOutputStream());
			
			//Send a greeting from the Client to the Server.
			connectionOutput.println("Initial Client greeting to Server.");
		
			//We establish a "buffer" for receiving input from the Server.
			String buffer = connectionInput.readLine();
		
			if(buffer != null)
			{
				
				//Send acknowledgement of receiving communication to server.
				System.out.println("Client received [\"" + buffer + "\"] from the Server: " + host);
				
			}
			
			//Need to close the socket...
			//socket.close(); but need to handle exceptions
			System.out.println("Client is exiting.");
		
		}
		catch (IOException givenException)
		{
			
			givenException.printStackTrace();
			System.out.println();
			System.out.println("Error:Client failed to connect to Server...");
		
		}
		
		
		
	}

}