package miniProjet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class HTTPServer {
	public static void main(String[] args) throws Exception {
	    int port = 80;
	    ServerSocket serverSocket = new ServerSocket(port);
	    System.out.println("Serveur démarré");

	    while (true) {
	        Socket clientSocket = serverSocket.accept();


	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

	        String s;
	        while ((s = in.readLine()) != null) {
	            System.out.println(s);
	            if (s.isEmpty()) {
	                break;
	            }
	        }

	        out.write("HTTP/1.0 200 OK\r\n");
	        out.write("Date: Fri, 31 Dec 1999 23:59:59 GMT\r\n");
	        out.write("Server: Apache/0.8.4\r\n");
	        out.write("Content-Type: text/html\r\n");
	        out.write("Content-Length: 59000000\r\n");
	        out.write("Expires: Sat, 01 Jan 2000 00:59:59 GMT\r\n");
	        out.write("Last-modified: Fri, 09 Aug 1996 14:21:40 GMT\r\n");
	        out.write("\r\n");

	        out.write("<TITLE>Exemple</TITLE>");
	        out.write("<P>Ceci est une page d'exemple kdjfhkjqsdh.</P>");

	        out.close();
	        in.close();
	        clientSocket.close();
	    }
	}
}
