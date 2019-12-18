package miniProjet;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.events.StartElement;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;


public class ParseurXML{
	String page;
//	public static void main(String args[]){
//		XMLReader parser = null;
//		
//		try {
//			parser = XMLReaderFactory.createXMLReader();
//			}
//		catch (SAXException e) {
//			System.err.println("Impossible d'instancier l'analyseur");
//			System.exit(1);
//		};
//		try {
//			FileReader fileR = new FileReader("source/xml1.xml");
//			InputSource is = new InputSource(fileR);
//			XMLHandler xHand = new XMLHandler();
//			parser.setContentHandler(xHand);
//			parser.parse(is);
//		}
//		catch(SAXException e) {
//			System.err.println(e.getMessage());
//		}
//		catch(IOException e){
//			System.out.println(e.getMessage());
//			System.err.println("Erreur lors de l'analyse du document");
//			System.exit(1);
//		}
//		System.out.println("Analyse du document terminée");
//	}
	public void parseXML(String nomFichier) {
		XMLReader parser = null;
		try {
			parser = XMLReaderFactory.createXMLReader();
			}
		catch (SAXException e) {
			System.err.println("Impossible d'instancier l'analyseur");
			System.exit(1);
		};
		try {
			FileReader fileR = new FileReader(nomFichier);
			InputSource is = new InputSource(fileR);
			XMLHandler xHand = new XMLHandler();
			parser.setContentHandler(xHand);
			parser.parse(is);
			this.setPage(xHand.getPageARenvoyer());
		}
		catch(SAXException e) {
			System.err.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.err.println("Erreur lors de l'analyse du document");
			System.exit(1);
		}
		System.out.println("Analyse du document terminée");
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	
}
