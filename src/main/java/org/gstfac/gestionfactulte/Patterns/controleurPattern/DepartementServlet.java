package org.gstfac.gestionfactulte.Patterns.controleurPattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.Patterns.compositPattern.CompositeDepartment;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.DepartementDAOImpl;
import org.gstfac.gestionfactulte.modele.DAO.Departement_DAO; // Correction du nom du package
import org.gstfac.gestionfactulte.modele.entity.Departement; // Importation de la classe Departement

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartementServlet", value = "/DepartementServlet")
public class DepartementServlet extends HttpServlet {
    private Departement_DAO departementDAO; // Utilisation du nom de variable en minuscules conformément aux conventions Java
    private CompositeDepartment compositeDepartment;

    @Override
    public void init() throws ServletException {
        super.init();
        departementDAO = new DepartementDAOImpl();
        List<Departement> departments = departementDAO.findAll();
        compositeDepartment = new CompositeDepartment();
        for (Departement department : departments) {
            compositeDepartment.addDepartment(department);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            if ("delete".equals(action)) {
                Departement deletedDepartment = departementDAO.findByID(id); // Utilisation du nom de variable en minuscules conformément aux conventions Java
                departementDAO.deleteByID(id);
                compositeDepartment.removeDepartment(deletedDepartment); // Utilisation du nom de variable en minuscules conformément aux conventions Java
            } else {
                Departement departement = departementDAO.findByID(id);
                request.setAttribute("departement", departement);
            }
        }
        request.setAttribute("departments", compositeDepartment.getAllDepartments());
        request.getRequestDispatcher("/pages/departement.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String nom = request.getParameter("nom");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            Departement existingDepartement = departementDAO.findByID(id);
            if (existingDepartement != null) {
                existingDepartement.setNom(nom);
                departementDAO.update(existingDepartement);
                compositeDepartment.updateDepartment(existingDepartement, existingDepartement);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        } else {
            Departement newDepartement = new Departement();
            newDepartement.setNom(nom);
            departementDAO.insert(newDepartement);
            compositeDepartment.addDepartment(newDepartement);
        }
        request.setAttribute("departments", compositeDepartment.getAllDepartments());
        request.getRequestDispatcher("/pages/departement.jsp").forward(request, response);
    }
}
