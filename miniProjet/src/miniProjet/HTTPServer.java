package miniProjet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class HTTPServer {
	public static void main(String[] args) throws Exception {
	    int port = 8000;
	    ServerSocket serverSocket = new ServerSocket(port);
	    serverSocket.setReuseAddress(true);
	    System.out.println("Serveur démarré");

	    System.out.println(serverSocket.getLocalSocketAddress());
	    while (true) {
	        Socket clientSocket = serverSocket.accept();
	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
	        String line = in.readLine();            
            String[] getOutput = line.split(" ");
            System.out.println(getOutput[1]);
            String[] outGetSlash = getOutput[1].split("/");
            System.out.println(outGetSlash[1]);

	        out.write("HTTP/1.0 200 OK\r\n");
	        out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
	        out.write("Server: Apache/0.8.4\r\n");
	        out.write("Content-Type: text/html\r\n");
	        out.write("Content-Length: 59000000\r\n");
	        out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
	        out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
	        out.write("\r\n");
	        
//	        if(outGetSlash[1] == "index" || outGetSlash[1] == "") {
//	        	ParseurXML parse = new ParseurXML();
//	        
//	        	parse.parseXML("source/baliseXML.xml");
//	        	out.write(parse.getPage());
//	        }
	        
	        ParseurXML parse = new ParseurXML();
	        switch(outGetSlash[1]){
	        	 case "index":
	     	        
	 	        	parse.parseXML("source/baliseXML.xml");
	 	        	out.write(parse.getPage());
	 	        	break;
	        	 case "detail":
	        		 String id = outGetSlash[2];
	        		 parse.parseXMLID("source/detailXML.xml", id);
	        		 out.write(parse.getPage());
	        }
	        out.close();
	        in.close();
	        clientSocket.close();
	    }
	}
}
