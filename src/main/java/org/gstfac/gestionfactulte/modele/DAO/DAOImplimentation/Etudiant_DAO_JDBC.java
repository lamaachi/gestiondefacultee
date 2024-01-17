package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.DAO.Etudiant_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBC_Connexion;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Etudiant_DAO_JDBC implements Etudiant_DAO {
	private Connection conn;
	public Etudiant_DAO_JDBC() {
		this.conn = JDBC_Connexion.getConnetion(); // Corrected typo in method name
	}
	@Override
	public void insert(Etudiant etd) {
		try (PreparedStatement pst = conn.prepareStatement("INSERT INTO etudiants(nom, prenom, cne,Situation_Scolaire) VALUES (?, ?, ?,?)")) {
			pst.setString(1, etd.getNom());
			pst.setString(2, etd.getPrenom());
			pst.setString(3, etd.getCNE());
			pst.setString(4,etd.getSituationScolaire());
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Etudiant inséré avec succès!");
			} else {
				System.out.println("Échec de l'insertion de l'étudiant!");

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(Etudiant etd, String CNE) {
		try (PreparedStatement pst = conn.prepareStatement("UPDATE etudiants SET nom=?, prenom=?, cne=? WHERE cne=?")) {
			pst.setString(1, etd.getNom());
			pst.setString(2, etd.getPrenom());
			pst.setString(3, etd.getCNE());
			pst.setString(4, CNE);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Étudiant modifié avec succès!");
			} else {
				System.out.println("Échec de la modification de l'étudiant!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void deleteByCNE(String CNE) {
		try (PreparedStatement pst = conn.prepareStatement("DELETE FROM etudiants WHERE cne=?")) {
			pst.setString(1, CNE);
			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Étudiant supprimé avec succès!");
			} else {
				System.out.println("Échec de la suppression de l'étudiant!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<Etudiant> findAll() {
		ArrayList<Etudiant> listetd = new ArrayList<>();
		try (Statement st = conn.createStatement();
			 ResultSet rs = st.executeQuery("SELECT * FROM etudiants ORDER BY CNE")) {
			while (rs.next()) {
				Etudiant etd = new Etudiant();
				etd.setNom(rs.getString("nom"));
				etd.setPrenom(rs.getString("prenom"));
				etd.setCNE(rs.getString("cne"));
				listetd.add(etd);
			}
			if (!listetd.isEmpty()) {
				System.out.println("Recherche terminée!");
			} else {
				System.out.println("Table vide!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listetd;
	}
	@Override
	public Etudiant findByCNE(String CNE) {
		Etudiant etd = new Etudiant();

		try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM etudiants WHERE cne=?")) {
			pst.setString(1, CNE);

			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					etd.setNom(rs.getString("nom"));
					etd.setPrenom(rs.getString("prenom"));
					etd.setCNE(rs.getString("cne"));
				}
			}
			if (etd.getCNE() != null) {
				System.out.println("Recherche terminée!");
			} else {
				System.out.println("CNE non valide!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etd;
	}
}
