package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.modele.Beans.Etudiant;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.Etudiant_DAO_JDBC;
import org.gstfac.gestionfactulte.modele.DAO.Etudiant_DAO;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/afficheEtd")
public class GereretudiantServlet extends HttpServlet {

    private Etudiant_DAO etudiantDAO = new Etudiant_DAO_JDBC();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("viewAll".equals(action)) {
            // Logique pour afficher tous les étudiants
            try {
                List<Etudiant> etudiants = etudiantDAO.findAll();
                request.setAttribute("etudiants", etudiants);
                request.getRequestDispatcher("/pages/afficheEtd.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la récupération des étudiants.");
                request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
            }
        } else if ("searchByCode".equals(action)) {
            // Logique pour rechercher un étudiant par code
            String searchCode = request.getParameter("searchCode");
            try {
                Etudiant etudiant = etudiantDAO.findByCode(searchCode);
                List<Etudiant> searchResult = new ArrayList<>();
                if (etudiant != null) {
                    searchResult.add(etudiant);
                }
                request.setAttribute("etudiants", searchResult);
                request.getRequestDispatcher(request.getContextPath() + "/afficheEtd?action=viewAll").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Une erreur s'est produite lors de la recherche par code.");
                request.getRequestDispatcher("/pages/error.jsp").forward(request, response);
            }
            }// Dans votre servlet
        else if ("delete".equals(action)) {
            int id = convertToInteger(request.getParameter("ID_Etudiant"));
            System.out.println(id);
            etudiantDAO.deleteByID(id);
            response.sendRedirect(request.getContextPath() + "/afficheEtd?action=viewAll");
        } else if ("edit".equals(action)) {
            int id = convertToInteger(request.getParameter("ID_Etudiant"));
            Etudiant etudiant = etudiantDAO.findByID(id);
            request.setAttribute("etudiant", etudiant);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/editEtd.jsp");
            dispatcher.forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/pages/afficheEtd.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("update".equals(action)) {
            int id = convertToInteger(request.getParameter("ID_Etudiant"));

            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            String email = request.getParameter("email");
            String code = request.getParameter("code");
            String CNE = request.getParameter("CNE");
            String situationScolaire = request.getParameter("situationScolaire");

            Etudiant etudiant = new Etudiant();
            etudiant.setNom(nom);
            etudiant.setPrenom(prenom);
            etudiant.setEmail(email);
            etudiant.setCode(code);
            etudiant.setCNE(CNE);
            etudiant.setSituationScolaire(situationScolaire);

            etudiantDAO.update(etudiant, id);
            response.sendRedirect(request.getContextPath() + "/afficheEtd?action=viewAll");
        } else {
            response.sendRedirect(request.getContextPath() + "/pages/about.jsp");
        }
    }

    private int convertToInteger(String parameter) {
        try {
            return Integer.parseInt(parameter);
        } catch (NumberFormatException e) {
            return 0; // Valeur par défaut
        }
    }
}
