package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.DepartementDAOImpl;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.FillierDaoImpl;
import org.gstfac.gestionfactulte.modele.DAO.Departement_DAO;
import org.gstfac.gestionfactulte.modele.DAO.FillierDAO;
import org.gstfac.gestionfactulte.modele.entity.Departement;
import org.gstfac.gestionfactulte.modele.entity.Filiere;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "FiliereServlet", value = "/FiliereServlet")
public class FiliereServlet extends HttpServlet {
    private FillierDAO filiereDao;
    private Departement_DAO departementDao;
    @Override
    public void init() throws ServletException {
        super.init();
        filiereDao = new FillierDaoImpl();
        departementDao = new DepartementDAOImpl();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            if ("delete".equals(action)) {
                filiereDao.delete(id);
            } else {
                Filiere filiere = filiereDao.getById(id);
                request.setAttribute("filiere", filiere);
            }
        }
        List<Filiere> filieres = filiereDao.getAll();
        request.setAttribute("filieres", filieres);
        List<Departement> departments = departementDao.findAll();
        request.setAttribute("departements", departments);
        request.getRequestDispatcher("/pages/filiere.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String idDepartement = request.getParameter("departement_id");
        String nom = request.getParameter("nom");
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);
            int idDep = Integer.parseInt(idDepartement);
            Filiere existingFiliere = filiereDao.getById(id);
            Departement departement = departementDao.findByID(idDep);
            if (existingFiliere != null) {
                existingFiliere.setNom(nom);
                existingFiliere.setDepartement(departement);
                filiereDao.update(existingFiliere);
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
        } else {
            Filiere newFiliere = new Filiere();
            int idDep = Integer.parseInt(idDepartement);
            Departement departement = departementDao.findByID(idDep);
            newFiliere.setDepartement(departement);
            newFiliere.setNom(nom);
            filiereDao.save(newFiliere);
        }
        List<Filiere> filieres = filiereDao.getAll();
        request.setAttribute("filieres", filieres);
        List<Departement> departments = departementDao.findAll();
        request.setAttribute("departements", departments);
        request.getRequestDispatcher("/pages/filiere.jsp").forward(request, response);
    }
}
