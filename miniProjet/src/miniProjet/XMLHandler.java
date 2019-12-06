package miniProjet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName == "Etudiant") {
			System.out.println("L'étudiant s'appelle");
		}
		if(localName == "Nom") {
			System.out.println(qName);
		}
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		
	}
}


