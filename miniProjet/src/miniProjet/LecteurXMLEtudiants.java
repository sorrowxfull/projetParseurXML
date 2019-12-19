package miniProjet;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LecteurXMLEtudiants extends DefaultHandler{
	
	private Boolean selectedOne = false;
	private String id;
	public Etudiant e = new Etudiant();
	
	public LecteurXMLEtudiants(String id) {
		this.id = id;
	}
	
	public Boolean getSelectedOne() {
		return selectedOne;
	}
	public void setSelectedOne(Boolean selectedOne) {
		this.selectedOne = selectedOne;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(localName) {
			case "Id":
				if(attributes.getValue("value") == id) {
					System.out.println("Coucou");
					selectedOne = true;
				}
				if(selectedOne) {
					e.setId(attributes.getValue("value"));
				}
				break;
			case "Nom":
				if(selectedOne) {
					e.setNom(attributes.getValue("value"));
				}
				break;
			case "Prénom":
				if(selectedOne) {
					e.setPrenom(attributes.getValue("value"));
				}
				break;
			case "Groupe":
				if(selectedOne) {
					e.setGroupe(attributes.getValue("value"));
				}
				break;
		}
	}
	public void endElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch(localName) {
		case "Id":
			break;
		case "Nom":
			break;
		case "Prénom":
			break;
		case "Groupe":
			selectedOne = false;
			break;
	}
	}

}
