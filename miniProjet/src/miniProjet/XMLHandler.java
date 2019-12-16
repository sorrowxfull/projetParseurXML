package miniProjet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {
	
	boolean inElement = false;

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName == "Id") {
			System.out.println("Id : " + attributes.getValue("value"));
		}
		if(localName == "Nom") {
			System.out.println("Nom : " + attributes.getValue("value"));
		}
		if(localName == "Prenom")
		{
			System.out.println("Prénom : " + attributes.getValue("value"));
		}
		if(localName == "Groupe") {
			System.out.println("Groupe : " + attributes.getValue("value"));
		}
		//System.out.println(uri + "/" + localName + "/" + qName + "/" + attributes.getType(0));
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		
	}
}


