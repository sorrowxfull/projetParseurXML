package miniProjet;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object;
import java.util.HashMap;

import javax.xml.parsers.SAXParser;
import javax.xml.stream.events.StartElement;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class ParseurXML extends DefaultHandler{
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
			System.out.println("Analyse du document terminée");
		}
		catch(SAXException e) {
			System.err.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.err.println("Erreur lors de l'analyse du document");
			System.exit(1);
		}
		
	}
	public HashMap<String,Etudiant> parseXMLListe(String nomFichier) {
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
			return xHand.getListeEtudiants();
			
		}
		catch(SAXException e) {
			System.err.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.err.println("Erreur lors de l'analyse du document");
			System.exit(1);
		}
		return null;
		
	}
	public void parseXMLID(String nomFichier, String id) {
		XMLReader parser = null;
		try {
			parser = XMLReaderFactory.createXMLReader();
			}
		catch (SAXException e) {
			System.err.println("Impossible d'instancier l'analyseur");
			System.exit(1);
		};
		try {
			FileReader fileR1 = new FileReader("source/xml1.xml");
			InputSource is1 = new InputSource(fileR1);
			LecteurXMLEtudiants xHand1 = new LecteurXMLEtudiants(id);
			parser.setContentHandler(xHand1);
			parser.parse(is1);
//			Etudiant e1 = xHand1.e;
//			System.out.println(e1.getGroupe());
			FileReader fileR = new FileReader(nomFichier);
			InputSource is = new InputSource(fileR);
			XMLHandler xHand = new XMLHandler();
			xHand.id = id;
//			xHand.e = e1;
			parser.setContentHandler(xHand);
			parser.parse(is);
			page = xHand.getPageARenvoyer();
			System.out.println("Analyse du document terminée");
		}
		catch(SAXException e) {
			System.err.println(e.getMessage());
		}
		catch(IOException e){
			System.out.println(e.getMessage());
			System.err.println("Erreur lors de l'analyse du document");
			System.exit(1);
		}
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	
}
