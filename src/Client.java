import java.net.*;
import java.net.URL;
import java.io.*;
import java.util.Scanner;
import java.util.Random;


public class Client
{

	private int sessionID;
	private int bufferID;
	private static String build = "1.0.0";
	private static int serverPort;
	private static String serverHost;
	private static Socket socket;
	private static BufferedReader connectionInput;
	private static PrintStream connectionOutput;
	private static URL whatismyip;



	public static void main(String[] args)
	{

		Queue<String> signalQueue = new Queue();

		Scanner keyboard = new Scanner(System.in);

		if(args.length == 0)
		{

			serverHost = "192.168.1.164";
			serverPort = 3306;

		}
		else
		{

			serverHost = args[0];
			String portString = args[1];

			try
			{

				serverPort = Integer.parseInt(portString);

			}
			catch (NumberFormatException portError)
			{

				System.out.println("Error assigning port: " + portString);

			}




		}

		try
		{   System.out.println("                    ");
			System.out.println("  -----|              ");
			System.out.println("_______|____  |         ");
			System.out.println("BORG Client|---               ");
			System.out.println("___________|__________________      ");
			System.out.println("//////////////               |   ");
			System.out.println("Build Version: " + build + " |");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("Attempting to connect to the Server: " + serverHost + ":" + serverPort);

			//Socket socket = new Socket(serverHost, serverPort);

			listenSocket();

			System.out.println();
			System.out.println("Success: Bound to the socket...");
			System.out.println();




			//Establish input and output streams using BufferedReader and PrintStream respectively.
			connectionInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			connectionOutput = new PrintStream(socket.getOutputStream());

			System.out.println("Success: Input and output Streams established...");
			System.out.println();
			System.out.println("Successfully connected to the Server.");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------");




			//Send a greeting from the Client to the Server.
			connectionOutput.println("Initial Client greeting to Server.");
			connectionOutput.flush();
			System.out.println();
			System.out.println("Client sent greeting signal to the Server: " + serverHost);

			//We establish a "buffer" for receiving input from the Server.














			String signalbuffer;
			String publicIpAddress = null;



			while(true)
			{

				signalQueue.Enqueue(connectionInput.readLine());



					if(signalQueue != null)
					{

						//Send acknowledgement of receiving communication to server.
						System.out.println("Client received the signal [\"" + signalQueue.GetLastItem() + "\"] from the Server: " + serverHost);
						System.out.println();
						System.out.println("Queue Length: " + signalQueue.LengthQueue());
						System.out.println();

						signalbuffer = signalQueue.GetFirstItem();

					    //if the buffer is something specific
						if(signalbuffer.equals("Acknowledgement of Client greeting from Server."))
						{

							signalQueue.Dequeue();
							connectionOutput.println("Client received acknowledgement. Establishing connection.");
							connectionOutput.flush();
							connectionOutput.println("Client can now receive input data from Server.");
							connectionOutput.flush();


						}

						if(signalbuffer.contains("buffer with ID="))
						{

							signalQueue.Dequeue();

						}

						if(signalbuffer.equals("Server is now accepting data from Client."))
						{

							signalQueue.Dequeue();

						}

						if(signalbuffer.equals("Close connection request from Server."))
						{

							signalQueue.Dequeue();
							connectionOutput.println("Client is closing the connection.");
							connectionOutput.flush();
							socket.close();



						}



						//Logic for when the Server requests a scan of the Clients internal network.
						if(signalbuffer.equals("scan internal network"))
						{

							signalQueue.Dequeue();



							int timeout=100;

							try
							{



								whatismyip = new URL("http://checkip.amazonaws.com");
								BufferedReader whatismyipInput = new BufferedReader(new InputStreamReader(whatismyip.openStream()));


								publicIpAddress = whatismyipInput.readLine();
								System.out.println("Public IP Address of this machine: " + publicIpAddress);
								System.out.println();
								connectionOutput.println("Client has a public IP Address of: " + publicIpAddress);
								connectionOutput.flush();
								connectionOutput.println("Client Operating System is: " + System.getProperty("os.name"));
								connectionOutput.flush();
								connectionOutput.println("Client has an internal IP Address of: " + InetAddress.getLocalHost() );
								connectionOutput.flush();
								//connectionOutput.println("Client MAC Address: " + pIP);
								//connectionOutput.flush();

								connectionOutput.println("Client is sending the Server a survey of its internal network.");
								connectionOutput.flush();


							} catch (MalformedURLException exception)
							{
								exception.printStackTrace();
							}

							for (int i=1;i<255;i++) //change to 255 for full range.
								{

								   String host="192.168.1." + i;

								   System.out.println("Scanning IP Address: " + host);

							       if (InetAddress.getByName(host).isReachable(timeout)){

							    	   System.out.println(host + " is up and running on the network: " + publicIpAddress);
							    	   connectionOutput.println(host + " is up and running on the network: " + publicIpAddress);
							           connectionOutput.flush();

							       }





							   }










						}



					}

				}




		}
		catch (IOException givenException)
		{

			givenException.printStackTrace();
			System.out.println();
			System.out.println("Error:Client failed to connect to Server...");

		}




	}

	public void setServerHost(String inputString)
	{

		serverHost = inputString;

	}

	public void setServerPort(int inputInt)
	{

		serverPort = inputInt;

	}

	public static void listenSocket()
	{
		//Try to create a socket connection
		try
		{

			socket = new Socket(serverHost, serverPort);

			connectionInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			connectionOutput = new PrintStream(socket.getOutputStream());


		}
		catch(IOException exception)
		{

		}
	}





}
