package org.gstfac.gestionfactulte.controleur;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.modele.Beans.Etudiant;

import java.io.IOException;

@WebServlet("/SaisieEtudiant")
public class SaisieEtudiant extends HttpServlet {
	//Constantes
	private static final long serialVersionUID = 1L;
	private static final String FORMULAIRE = "vues/formulaire.jsp";
	private static final String RESULTAT = "/vues/resultat.jsp";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		afficherResultat(req, resp);
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupération à partir du formulaire		
		String msg;
		Etudiant etd= new Etudiant( );
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String CNE = req.getParameter("CNE");
		
	   //Vérifier des champs du formulaire
	    if (nom.trim().isEmpty() || prenom.trim().isEmpty() || CNE.trim().isEmpty()) {
		    msg = "Erreur - <a href=" + FORMULAIRE + ">Cliquez ici</a> pour accéder au formulaire de création d'un étudiant.";
	    } else {
	    	//Modifier l'objet Etudiant
		    etd.setNom(nom);
		    etd.setPrenom(prenom);
		    etd.setCNE(CNE);
			msg = "Etudiant créé avec succès !";
			}
	   // Modifier les valeurs des paraméres
	    req.setAttribute("etudiant", etd);
		req.setAttribute("message", msg);
		//Envoyer les infos vers resultat
		afficherResultat(req, resp);   
	}
	//Méthode qui permet la communication controleur-vue
	private void afficherResultat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(RESULTAT).forward(req, resp);
	}
	
}

