package org.gstfac.gestionfactulte.Patterns.controleurPattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.Patterns.AdapterPattern.Fete_Adapter;
import org.gstfac.gestionfactulte.Patterns.AdapterPattern.Soutenance_Adapter;
import org.gstfac.gestionfactulte.Patterns.FactoryPattern.AmphiFactory;
import org.gstfac.gestionfactulte.Patterns.FactoryPattern.Batimentfactory;
import org.gstfac.gestionfactulte.Patterns.FactoryPattern.SalleFactory;
import org.gstfac.gestionfactulte.modele.DAO.AmphiDAO;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.AmphiDAOImpl;
import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.SalleDaoImp;
import org.gstfac.gestionfactulte.modele.DAO.SalleDAO;
import org.gstfac.gestionfactulte.modele.entity.Amphi;
import org.gstfac.gestionfactulte.modele.entity.Batiment;
import org.gstfac.gestionfactulte.modele.entity.Salle;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BatimentServlet", value = "/BatimentServlet")
public class BatimentServlet extends HttpServlet {
    private SalleDAO salleDao;
    private AmphiDAO amphiDao;
    private Fete_Adapter feteAdapter;
    private Soutenance_Adapter soutenanceAdapter;

    @Override
    public void init() throws ServletException {
        super.init();

        salleDao = new SalleDaoImp();
        amphiDao = new AmphiDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idParam = request.getParameter("id");
        String action = request.getParameter("action");
        Batiment batiment = null;
        if (idParam != null && !idParam.isEmpty()) {
            int id = Integer.parseInt(idParam);

            if ("delete".equals(action)) {
                Salle salleToDelete = salleDao.getById(id);
                Amphi amphiToDelete = amphiDao.getById(id);
                if (salleToDelete != null) {
                    salleDao.delete(id);
                } else if (amphiToDelete != null) {
                    amphiDao.delete(id);
                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }
            }
            if ("adapt".equals(action)) {
                Salle salleToAdapt = salleDao.getById(id);
                Amphi amphiToToadapt = amphiDao.getById(id);
                if (salleToAdapt != null) {
                    Fete_Adapter feteAdapter = new Fete_Adapter(salleToAdapt);
                    request.setAttribute("adapteFete", feteAdapter);
                } else if (amphiToToadapt != null) {
                    Soutenance_Adapter soutenanceAdapter = new Soutenance_Adapter(amphiToToadapt);
                    request.setAttribute("adapteSoutenance", soutenanceAdapter);
                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }

            } else {
                Salle salle = salleDao.getById(id);
                Amphi amphi = amphiDao.getById(id);
                if (salle != null) {
                    batiment = salle;
                } else if (amphi != null) {
                    batiment = amphi;
                } else {
                    response.getWriter().println("Batiment with ID " + id + " not found.");
                }
            }
        }
        List<Salle> salles = salleDao.getAll();
        List<Amphi> amphis = amphiDao.getAll();
        request.setAttribute("batiment", batiment);
        request.setAttribute("salles", salles);
        request.setAttribute("amphis", amphis);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/batiment.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String emplacement = request.getParameter("emplacement");
        String tailleStr = request.getParameter("taille");
        int taille = Integer.parseInt(tailleStr);
        String fonctionnalite = request.getParameter("fonctionnalite").toLowerCase();
        String description = request.getParameter("description");

        Batimentfactory batimentFactory;
        Batiment batiment;

        switch (fonctionnalite) {
            case "salle":
                batimentFactory = new SalleFactory();
                break;
            case "amphi":
                batimentFactory = new AmphiFactory();
                break;
            default:
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().println("Invalid batiment type.");
                return;
        }
        batiment = batimentFactory.createBatiment();
        batiment.setEmplacement(emplacement);
        batiment.setTaille(taille);
        batiment.setDescription(description);

        if ("salle".equals(fonctionnalite)) {
            salleDao.save((Salle) batiment);
        } else if ("amphi".equals(fonctionnalite)) {
            amphiDao.save((Amphi) batiment);
        }
        List<Salle> salles = salleDao.getAll();
        List<Amphi> amphis = amphiDao.getAll();
        request.setAttribute("salles", salles);
        request.setAttribute("amphis", amphis);
        request.getRequestDispatcher("/pages/batiment.jsp").forward(request, response);
//        request.getRequestDispatcher("/pages/batiment.jsp").forward(request, response);
    }
}
