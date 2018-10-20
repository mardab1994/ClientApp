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
	private Socket s;		// my socket
	private String nick;	// user nick 
	private String msg;		// message to send
	private String line;	// received message
	
	private InputStream inStream = null;//(InputStream) s.getInputStream();
	private OutputStream outStream = null;//s.getOutputStream();
	private PrintWriter out = null;///new PrintWriter(outStream, true);
	private Scanner in=null;
	
	public Session( ) {
		System.out.println("Session contructor");
	}
	
	public String getMessage() {
		return line;
	}
	public void init() {
		try {
			s = new Socket("localhost",8199);
			inStream = (InputStream) s.getInputStream();
			outStream = s.getOutputStream();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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


			

