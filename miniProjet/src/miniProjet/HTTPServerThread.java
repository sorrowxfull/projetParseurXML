package miniProjet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HTTPServerThread {
	private Socket s;
	public String page;
	public HTTPServerThread(Socket sock) {super(); this.s = sock;}
	
	public void run()
	{
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	        ParseurXML parse = new ParseurXML();
	        parse.parseXML("source/baliseXML.xml");
	        out.write(parse.getPage());
	        System.out.println("Coucou2");
		}
		catch(IOException e) {}
		
	}
}
