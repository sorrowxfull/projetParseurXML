package miniProjet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {
	
	String pageARenvoyer = " ";

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//		if(localName == "LesBalises") {
//			System.out.println("Id : " + attributes.getValue("value"));
//		}
//		if(localName == "Nom") {
//			System.out.println("Nom : " + attributes.getValue("value"));
//		}
//		if(localName == "Prenom")
//		{
//			System.out.println("Prénom : " + attributes.getValue("value"));
//		}
//		if(localName == "Groupe") {
//			System.out.println("Groupe : " + attributes.getValue("value"));
//		}
		switch (localName) {
			case "LesBalises":
				pageARenvoyer = pageARenvoyer + "<html>";
				System.out.println(getPageARenvoyer());
				System.out.println(getPageARenvoyer());
				break;
			case "Corps":
				pageARenvoyer = pageARenvoyer + "<body>" + " " ;
				System.out.println(getPageARenvoyer());
				break;
			case "Titre":
				pageARenvoyer = pageARenvoyer + "<h1>" + " " + attributes.getValue("valeur");
				System.out.println(getPageARenvoyer());
				break;
			case "Collection":
				pageARenvoyer = pageARenvoyer + "<p>" + attributes.getValue("fichier");
				break;
			case "Paragraphe":
				break;
				
		}
		
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (localName) {
			case "LesBalises":
				pageARenvoyer = pageARenvoyer + "</html>";
				System.out.println(getPageARenvoyer());
				break;
			case "Corps":
				pageARenvoyer = pageARenvoyer + "</body>";
				System.out.println(getPageARenvoyer());
				break;
			case "Titre":
				pageARenvoyer = pageARenvoyer + "</h1>";
				System.out.println(getPageARenvoyer());
				break;
			case "Collection":
				pageARenvoyer = pageARenvoyer + "</p>";
				break;
			case "Paragraphe":
				break;
			
		}
	}

	public void characters(char ch[], int start, int length) throws SAXException {
		
	}

	public String getPageARenvoyer() {
		return pageARenvoyer;
	}

	public void setPageARenvoyer(String pageARenvoyer) {
		this.pageARenvoyer = pageARenvoyer;
	}
}


