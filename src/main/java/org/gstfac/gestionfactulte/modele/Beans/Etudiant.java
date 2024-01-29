package org.gstfac.gestionfactulte.modele.Beans;

public class Etudiant {

	private String nom;
	private String prenom;
	private String CNE;
	private String code;
	private String situationScolaire;
	private String email; // Ajout de l'attribut email
	private int ID_Etudiant;

	public int getId_Etudiant() {
		return ID_Etudiant;
	}
	public void setId_Etudiant(int id) {
		this.ID_Etudiant = id;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cne) {
		this.CNE = cne;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getSituationScolaire() {
		return situationScolaire;
	}

	public void setSituationScolaire(String situationScolaire) {
		this.situationScolaire = situationScolaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setEmailtest(String email) {
		this.email = email;
	}

}
