package miniProjet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPServer2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetSocketAddress sa = new InetSocketAddress("100.100.100.100",Integer.parseInt("4500"));
		ServerSocket ss = null;
		try
		{
			ss = new ServerSocket(4500);
			System.out.println(ss.getLocalSocketAddress());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Coucou");
		while (true)
		{
			try
			{
				Socket sock = ss.accept();
				HTTPServerThread serv = new HTTPServerThread(sock);
				serv.run();
				System.out.println("Echo3");
				ss.close();
				
			} catch (IOException e) {
				//System.out.println(e.getMessage());
			}
		}
	}

}
