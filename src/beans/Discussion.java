package beans;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Discussion {
	public Integer id;
	public List<Message> messages;
	public String titre;
	public Utilisateur auteur;
	public DateTime dateCreation;
	public boolean statut;

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public String getTitre() {
		return titre;
	}

	public Utilisateur getAuteur() {
		return auteur;
	}

	public String getDateCreation() {
		org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");	
		return dtf.print(dateCreation);
	}

	public boolean isStatut() {
		return statut;
	}

	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	public Integer getId() {
		return id;
	}

	public Discussion(int id, String titre, Utilisateur auteur, DateTime dateCreation, boolean statut) {
		super();
		this.id = id;
		this.messages = new ArrayList<Message>();
		this.titre = titre;
		this.auteur = auteur;
		this.dateCreation = dateCreation;
		this.statut = statut;
	}
}
