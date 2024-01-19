package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.Etudiant_DAO_JDBC;
import org.gstfac.gestionfactulte.modele.DAO.Etudiant_DAO;

import java.io.IOException;

@WebServlet("/addetudiant")
public class EtudiantServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/pages/addetudiant.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Retrieve form data
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String CNE = request.getParameter("CNE");
        String situationScolaire = request.getParameter("situationScolaire");

        // Create an Etudiant object
        Etudiant etudiant = new Etudiant();
        etudiant.setNom(nom);
        etudiant.setPrenom(prenom);
        etudiant.setEmail(email);
        etudiant.setCode(code);
        etudiant.setCNE(CNE);
        etudiant.setSituationScolaire(situationScolaire);

        // Assuming you have an EtudiantDAO class to handle database operations
        Etudiant_DAO etudiantDAO = new Etudiant_DAO_JDBC();
        etudiantDAO.insertEtd(etudiant);

        // Redirect to a success page or show a success message
        request.getRequestDispatcher("/pages/addetudiant.jsp").forward(request, response);
    }
}
