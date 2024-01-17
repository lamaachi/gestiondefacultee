package org.gstfac.gestionfactulte.modele.Beans;

public class Etudiant {

	private String nom;
	private String prenom;
	private String CNE;
	private String situationScolaire;

	public String getCNE() {
		return CNE;
	}

	public void setCNE(String codeEtudiant) {
		this.CNE = codeEtudiant;
	}

	public String getSituationScolaire() {
		return situationScolaire;
	}

	public void setSituationScolaire(String situationScolaire) {
		this.situationScolaire = situationScolaire;
	}

	public Etudiant() {	}

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

	@Override
	public String toString() {
		return "Etudiant [nom:" + nom + ", prenom:" + prenom + ", CNE:" + CNE + "]";
	}
	
}
