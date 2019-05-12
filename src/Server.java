
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.Random;


public class Server 
{
	
	/*
	 * 
	 * DEATHSTAR Server
	 * 
	 * Description: (to be written)
	 * 
	 * 
	 * 
	 */
	
	static int[] C;
	
	public static void main(String[] args)
	{
		
		final String build = "1.0.0";
		int bufferID = 0;
		Queue<String> TestQueue; //what to do?
		
		Scanner keyboardInput = new Scanner(System.in); 
		
		System.out.println("DEATHSTAR - Server " + build);
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("Enter the port number for the DEATHSTAR Server to listen on: " );
		int portNumber = keyboardInput.nextInt();
		
		try
		{
			
			//Create a ServerSocket and bind it to the port 3301.
			ServerSocket serverSocket = new ServerSocket(portNumber);
		
			
			//Terminal Output.
			
			System.out.println("DEATHSTAR is waiting for an incoming connection on " + InetAddress.getLocalHost() + ":" + serverSocket.getLocalPort());
			System.out.println();
			System.out.println("Server Hostname:" + InetAddress.getLocalHost().getCanonicalHostName());
			
			//Create a Socket.
			
			Socket socket = serverSocket.accept();
			
			//After the connection has been accepted, start reading and writing from socket.
			
			BufferedReader connectionInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintStream connectionOutput = new PrintStream(socket.getOutputStream());
			
			//Read data from the input stream as a buffer.
			
			String buffer = connectionInput.readLine();
			
			
			//If we receive data from the input stream, print it out and send a message back to the client.
			
			if (buffer != null)
			{
				System.out.print("Server Read:       " + buffer);
				connectionOutput.print("buffer with ID=" + bufferID++ + " Received." );
			}
			
			//closeSocket(socket);
			//closeServerSocket(serverSocket);
			
			
			
			
		}
		catch (IOException socketBindException)
		{
			
			System.out.println();
			socketBindException.printStackTrace();
			
			System.out.println();
			System.out.println();
			System.out.println("Server Error!");
			System.out.println();
			System.out.println("DEATHSTAR Server failed to start...");
			System.out.println("Socket failed to bind. It's probably already in use.");
			System.out.println();
			System.out.println();
			System.out.println("Useful Information Below"); //lol yeah right m8
			System.out.println("--------------------------------------------------------------------");
			System.out.println("Build Version: " + build);
			//System.out.println(socket);
		}
		
		
	}
	//end of main method
	
	protected static void closeServerSocket(ServerSocket serverSocket)
	{
		
		//Terminates serverSocket and exits
		
		try
		{

			serverSocket.close();
		    
		} 
		catch (IOException closeServerSocketException)
		{
		
			System.out.println("Error while closing the Server Socket.");
			System.exit(-1);
		    
		}
		
	}
	//end method closeServerSocket
	
	protected static void closeSocket(Socket inputSocket)
	{
		
		//Terminates the input Socket...
		
		try
		{
			
			inputSocket.close();
			
		}
		catch (IOException closeSocketException)
		{
			
			System.out.println("Error while closing the Socket: " + inputSocket);
			System.exit(-1);
			
		}
		
		
		
		
	}
	//end method closeSocket
	
	protected static void MergeSort(int[] A, int Left, int Right)
	{
		
		int Mid;
		
		if (Left == Right)
		{
			return;
		}
		
		Mid = (Left + Right)/2;
		
		MergeSort(A, Left, Mid);
		MergeSort(A, Mid + 1, Right);
		
		Merge(A, Left, Mid, Right);
		
		
	}
	//end method MergeSort
	
	public static void QuickSort(int[] A, int Left, int Right)
	{
		
		int i, j, v, temp;
		
		if (Left >= Right)
		{
			
			return;
		
		}
		
		v = A[Right];
		i = Left;
		j = Right - 1;
		
		for(;;)
		{
			
			while(A[i] < v)
			{
				
				i++;
				
			}
			
			if (i>= j)
			{
				
				break;
				
			}
			
			temp = A[i];
			A[i] = A[j];
			A[j] = temp;
			i++;
			j--;
			
		}
		
		temp = A[i];
		A[i] = A[Right];
		A[Right] = temp;
		
		if (Left < i-1)
		{
			
			QuickSort(A, Left, i-1);
			
		}
		
		if (Right > i+1)
		{
			
			QuickSort(A, i+1, Right);
			
		}
		
		
	}
	//end of QuickSort method
	
	protected static void Merge(int[] A, int Left, int Mid, int Right)
	{
		
		int p, q, r;
		
		p = Left;
		q = Mid + 1;
		r = Left;
		
		while (p <= Mid && q <= Right)
	      {
			
	         if (A[p] <= A[q])
	         {
	        	 
	        	 C[r] = A[p++];

	         }
	         else
	         {
	        	 
	            C[r] = A[q++];
	            
	         }

	         r++;
	         
	      }  

	      while (p <= Mid)
	      {
	    	  
	    	  C[r++] = A[p++];
	      
	      }

	      while (q <= Right)
	      {
	    	  
	         C[r++] = A[q++];
	      
	      }

	      for (r = Left; r <= Right; r++)
	      {
	    	  
	         A[r] = C[r];
	         
	      }
	}
	//end method Merge
	
	
	//Not sure why I added this...
	private static long Binomial(int m, int n)
	{
		
		if (m== n || n == 0)
		{
			
			return 1;
		
		}
		else if (n == 1)
		{
		
			return m;
		
		}
		else
		{
			
			return Binomial(m-1,n) + Binomial(m - 1, n - 1);
		
		}
		
		
	}
	//end method Binomial
	
	

}

