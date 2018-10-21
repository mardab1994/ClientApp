package connection.pack;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javafx.scene.control.TextField;

public class Session {
	private Socket s;						// my socket
	private InputStream inStream = null;	// input stream to read message from server
	private OutputStream outStream = null;	// output stream to write to server
	private PrintWriter out = null;			
	private Scanner in = null;
	
	public Session( ) {
		System.out.println("Session contructor");
	}
	
	public void init() {
		try {
			s = new Socket("localhost",8199);
			inStream = (InputStream) s.getInputStream();
			outStream = s.getOutputStream();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 out = new PrintWriter(outStream, true);
		 in = new Scanner(inStream);
		 out.println("Hello I am new Client");	//say hello to other clients
	}
	
	public void sendMessage(String message) {
		out.println(message);
	}
	
	public String communication() {
		if(in.hasNextLine()) {
			return in.nextLine();
		}
		return "";
	}
}


			

