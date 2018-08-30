package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import beans.Discussion;
import beans.Message;
import beans.Sujet;
import beans.Utilisateur;

public class Dal {
	public static Connection con = null;
	public static org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");

	public static Connection seConnecter() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/?databaseName=bddforum&user=root&password=azerty/123&useLegacyDatetimeCode=false&serverTimezone=UTC");
			
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static Utilisateur getUtilisateur(int idUser) {
		if (con == null) {
			con = seConnecter();
		}
		try {
			PreparedStatement psP = con.prepareStatement("SELECT * FROM bddforum.utilisateur where id=?;");
			psP.setInt(1, idUser);
			ResultSet result = psP.executeQuery();
			if (result.next()) {
				return new Utilisateur(idUser, result.getString("login"), result.getString("nom"),
						result.getString("prenom"), result.getString("mail"));
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public static List<Sujet> getSujet() {
		if (con == null) {
			con = seConnecter();
		}
		try {
			List<beans.Sujet> sujets = new ArrayList<beans.Sujet>();
			PreparedStatement psP = con.prepareStatement("select * from bddforum.sujet");
			ResultSet result = psP.executeQuery();

			while (result.next()) {
				sujets.add(new beans.Sujet((Integer) result.getInt("id"), result.getString("titre"),
						getUtilisateur(result.getInt("idUtilisateur"))));
			}
			return sujets;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<Message> getMessage(int idDiscussion) {
		if (con == null) {
			con = seConnecter();
		}
		try {
			List<beans.Message> messages = new ArrayList<beans.Message>();
			PreparedStatement psP = con.prepareStatement("select bddforum.message.*, bddforum.discussion.idSujet "
					+ "from bddforum.message inner join bddforum.discussion "
					+ "on bddforum.discussion.id = bddforum.message.idDiscussion where bddforum.message.idDiscussion = ? ");
			psP.setInt(1, idDiscussion);
			ResultSet result = psP.executeQuery();

			while (result.next()) {
				messages.add(new beans.Message(result.getInt("id"), result.getString("texte"),
						formatter.parseDateTime(result.getString("date")),
						getUtilisateur(result.getInt("idUtilisateur")), result.getInt("idSujet"),
						result.getInt("idDiscussion"), getDiscussion(idDiscussion).getTitre()));
			}
			return messages;
		} catch (SQLException e) {
			return null;
		}
	}

	public static List<Discussion> getDiscussions(int id) {
		if (con == null) {
			con = seConnecter();
		}
		try {
			List<beans.Discussion> discussions = new ArrayList<beans.Discussion>();
			PreparedStatement psP = con.prepareStatement("select * from bddforum.discussion where idSujet = " + id);
			ResultSet result = psP.executeQuery();

			while (result.next()) {
				discussions.add(new beans.Discussion((Integer) result.getInt("id"), result.getString("titre"),
						getUtilisateur(result.getInt("idUtilisateur")), formatter.parseDateTime(result.getString("dateCreate")),
						result.getBoolean("statut")));
			}
			return discussions;
		} catch (Exception e) {
			return null;
		}
	}
	
	public static beans.Discussion getDiscussion(int id) {
		if (con == null) {
			con = seConnecter();
		}
		beans.Discussion d=null;
		try {
			
			PreparedStatement psP = con.prepareStatement("select * from bddforum.discussion where id = " + id);
			ResultSet result = psP.executeQuery();

			while (result.next()) {
				d = new Discussion(result.getInt("id"), result.getString("titre"), getUtilisateur(result.getInt("idUtilisateur")), formatter.parseDateTime(result.getString("dateCreate")), result.getBoolean("statut"));
			}
			return d;
		} catch (Exception e) {
			return d;
		}
	}
	
	public static List<Message> addMessage(Utilisateur auteur, Integer idDiscussion, String texte, DateTime date) {
		if (con == null) {
			con = seConnecter();
		}
		try {
			PreparedStatement psP = con.prepareStatement("insert into bddforum.message (texte, date, idUtilisateur, idDiscussion) "
					+ "values ('" + texte + "', CURRENT_DATE, '" + auteur.id + "', '" + idDiscussion + "');");
			psP.executeUpdate();
			return getMessage(idDiscussion);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static Utilisateur addUtilisateur(String login, String mail) {
		if (con == null) {
			con = seConnecter();
		}
		try {
			PreparedStatement psP = con.prepareStatement("insert into bddforum.utilisateur (login, mail) "
					+ "values ('" + login + "', '" + mail + "');", Statement.RETURN_GENERATED_KEYS);
			psP.executeUpdate();
			ResultSet rs = psP.getGeneratedKeys();
			if (rs.next()) {
				int newId = rs.getInt(1);
				return getUtilisateur(newId);
			}
			return null;
		} catch (SQLException e) {
			 return null;
		}
	}
}
