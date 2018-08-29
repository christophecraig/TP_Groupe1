package beans;

import java.util.ArrayList;
import java.util.List;

import servlets.Discussion;

public class Sujet {
	public Integer id;
	public List<Discussion> discussions;
	public String titre;
	public Utilisateur auteur;
	
	public List<Discussion> getDiscussions() {
		return discussions;
	}
	public void setDiscussions(List<Discussion> discussions) {
		this.discussions = discussions;
	}	
	public String getTitre() {
		return titre;
	}
	public Utilisateur getAuteur() {
		return auteur;
	}
	public Sujet(Integer id, String titre, Utilisateur auteur) {
		super();
		this.id = id;
		this.discussions = new ArrayList<Discussion>();
		this.titre = titre;
		this.auteur = auteur;
	}
	public Integer getId() {
		return id;
	}
	
	
}
