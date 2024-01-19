package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.DAO.Etudiant_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBC_Connexion;

import java.sql.*;
import java.util.ArrayList;

public class Etudiant_DAO_JDBC implements Etudiant_DAO {
	private Connection conn;

	public Etudiant_DAO_JDBC() {
		this.conn = JDBC_Connexion.getConnetion();
	}

	@Override
	public void insertEtd(Etudiant etd) {
		try (PreparedStatement pst = conn.prepareStatement("INSERT INTO etudiants(nom, prenom, email, code, CNE, situationScolaire) VALUES (?, ?, ?, ?, ?, ?)")) {
			pst.setString(1, etd.getNom());
			pst.setString(2, etd.getPrenom());
			pst.setString(3, etd.getEmail());
			pst.setString(4, etd.getCode());  // Correction de l'index
			pst.setString(5, etd.getCNE());
			pst.setString(6, etd.getSituationScolaire());  // Correction de l'index

			int rowsAffected = pst.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("Étudiant inséré avec succès!");
			} else {
				System.out.println("Échec de l'insertion de l'étudiant!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void update(Etudiant etd, int ID_Etudiant) {
		try (PreparedStatement pst = conn.prepareStatement("UPDATE etudiants SET nom=?, prenom=?, email=?, code=?, CNE=?, situationScolaire=? WHERE ID_Etudiant=?")) {
			pst.setInt(7, ID_Etudiant);
			pst.setString(1, etd.getNom());
			pst.setString(2, etd.getPrenom());
			pst.setString(3, etd.getEmail());
			pst.setString(4, etd.getCode());
			pst.setString(5, etd.getCNE());
			pst.setString(6, etd.getSituationScolaire());
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
	public void deleteByID(int id) {
		try (PreparedStatement pst = conn.prepareStatement("DELETE FROM etudiants WHERE ID_Etudiant=?")) {
			pst.setInt(1, id);
			int rowsAffected = pst.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Étudiant supprimé avec succès!");
				conn.commit();
			} else {
				System.out.println("Aucune ligne n'a été supprimée. Vérifiez si l'étudiant existe.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur SQL: " + e.getMessage());
		}
	}

	@Override
	public ArrayList<Etudiant> findAll() {
		ArrayList<Etudiant> listetd = new ArrayList<>();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM etudiants ORDER BY ID_Etudiant");

			while (rs.next()) {
				Etudiant etd = new Etudiant();
				etd.setId_Etudiant(rs.getInt("ID_Etudiant"));
				etd.setNom(rs.getString("nom"));
				etd.setPrenom(rs.getString("prenom"));
				etd.setEmail(rs.getString("email"));
				etd.setCode(rs.getString("code")); // Correction ici
				etd.setCNE(rs.getString("CNE"));
				etd.setSituationScolaire(rs.getString("situationScolaire"));
				listetd.add(etd);
			}

			if (!listetd.isEmpty()) {
				System.out.println("Recherche terminée! Nombre d'étudiants récupérés : " + listetd.size());
			} else {
				System.out.println("Table vide!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur SQL : " + e.getMessage());
		}
		return listetd;
	}


	@Override
	public Etudiant findByCode(String code) {
		Etudiant etd = new Etudiant();

		try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM etudiants WHERE code=?")) {
			pst.setString(1, code); // Utilisez setString pour une chaîne

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					etd.setNom(rs.getString("nom"));
					etd.setPrenom(rs.getString("prenom"));
					etd.setEmail(rs.getString("email"));
					etd.setCode(rs.getString("code"));
					etd.setCNE(rs.getString("CNE"));
					etd.setSituationScolaire(rs.getString("situationScolaire"));
				}
			}
			if (etd.getCNE() != null) {
				System.out.println("Recherche terminée!");
			} else {
				System.out.println("ID non valide!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etd;
	}
	public Etudiant findByID(int id) {
		Etudiant etd = new Etudiant();

		try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM etudiants WHERE ID_Etudiant=?")) {
			pst.setInt(1, id);

			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					etd.setNom(rs.getString("nom"));
					etd.setPrenom(rs.getString("prenom"));
					etd.setEmail(rs.getString("email"));
					etd.setCode(rs.getString("code"));
					etd.setCNE(rs.getString("CNE"));
					etd.setSituationScolaire(rs.getString("situationScolaire"));
				}
			}
			if (etd.getCNE() != null) {
				System.out.println("Recherche terminée!");
			} else {
				System.out.println("ID non valide!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return etd;
	}
}
