package miniProjet;

import java.util.HashMap;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class XMLHandler extends DefaultHandler {
	
	String pageARenvoyer = " ";
	Boolean isEtudiantFile = false;
	HashMap<String,Etudiant> listeEtudiants = new HashMap<String,Etudiant>();
	public static Etudiant e = new Etudiant();

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(localName == "LesEtudiants")
		{
			isEtudiantFile = true;
		}
		if(isEtudiantFile) {
			switch(localName) {
			case "Id":
				e.setId(attributes.getValue("value"));
				break;
			case "Nom":
				e.setNom(attributes.getValue("value"));
				break;
			case "Prenom":
				e.setPrenom(attributes.getValue("value"));
				break;
			case "Groupe":
				e.setGroupe(attributes.getValue("value"));
				break;
			}
		}
		else
		{
			switch (localName) {
				case "LesBalises":
					pageARenvoyer = pageARenvoyer + "<html>";
					//System.out.println(getPageARenvoyer());
					//System.out.println(getPageARenvoyer());
					break;
				case "Corps":
					pageARenvoyer = pageARenvoyer + "<body>" + " " ;
					//System.out.println(getPageARenvoyer());
					break;
				case "Titre":
					pageARenvoyer = pageARenvoyer + "<h1>" + " " + attributes.getValue("valeur");
					//System.out.println(getPageARenvoyer());
					break;
				case "Collection":
					pageARenvoyer = pageARenvoyer + "<table border='1'> <thead><th>Id</th><th>Nom</th>";
					ParseurXML parseFichier = new ParseurXML();
					parseFichier.parseXML(attributes.getValue("fichier"));
					pageARenvoyer = pageARenvoyer.concat(parseFichier.getPage());
					
					break;
				case "Paragraphe":
					break;
					
			}
		}
		
	}

	public HashMap<String, Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(HashMap<String, Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(localName == "LesEtudiants")
		{
			System.out.println("Passerici");
			isEtudiantFile = false;
		}
		if(isEtudiantFile) {
			switch(localName) {
			case "Etudiant":
				//listeEtudiants.put(e.getId(), e);
				String id = e.getId();
				System.out.println(id);
				String nom = e.getNom();
				this.pageARenvoyer = this.pageARenvoyer + "<tr><td><a href='/" + id + ".html'>";
				pageARenvoyer = pageARenvoyer.concat(id);
				pageARenvoyer = pageARenvoyer + "</a></td><td><a href='/" + id + ".html'>";
				pageARenvoyer = pageARenvoyer.concat(nom);
				pageARenvoyer = pageARenvoyer + "</a></td></tr>";
				e = new Etudiant();
				break;
			case "Id":
				break;
			case "Nom":
				break;
			case "Prenom":
				break;
			case "Groupe":
				break;
			case "LesEtudiants":
				pageARenvoyer = pageARenvoyer + "</table>";
				break;
			}
		}
		else
		{
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
					pageARenvoyer = pageARenvoyer + "</table>";
					break;
				case "Paragraphe":
					break;
				
			}
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


