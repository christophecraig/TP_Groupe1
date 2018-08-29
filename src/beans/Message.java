package beans;

import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class Message {
	public Integer id;
	public String texte;
	public DateTime date;
	public Utilisateur auteur;
	public Integer idSujet;
	public String discussion;
	
	public String getTexte() {
		return texte;
	}
	public void setTexte(String texte) {
		this.texte = texte;
	}
	public String getDate() {
		org.joda.time.format.DateTimeFormatter dtf = DateTimeFormat.forPattern("MM/dd/yyyy");	
		return dtf.print(date);	
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public void setAuteur(Utilisateur auteur) {
		this.auteur = auteur;
	}
	public Integer getIdSujet() {
		return idSujet;
	}
	
	public String getDiscussion() {
		return discussion;
	}

	public Message(Integer id, String texte, DateTime date, Utilisateur auteur, Integer idSujet, String discussion) {
		super();
		this.id = id;
		this.texte = texte;
		this.date = date;
		this.auteur = auteur;
		this.idSujet = idSujet;
		this.discussion = discussion;
	}
}
