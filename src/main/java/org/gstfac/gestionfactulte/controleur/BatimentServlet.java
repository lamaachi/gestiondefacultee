package org.gstfac.gestionfactulte.controleur;

import com.master.universite.adapter.FeteAdapter;
import com.master.universite.adapter.SoutenanceAdapter;
import com.master.universite.dao.AmphiDao;
import com.master.universite.dao.SalleDao;
import com.master.universite.dao.impl.AmphiDaoImpl;
import com.master.universite.dao.impl.SalleDaoImpl;
import com.master.universite.entity.Amphi;
import com.master.universite.entity.Batiment;
import com.master.universite.entity.Salle;
import com.master.universite.enums.Fonctionnalite;
import com.master.universite.factory.AmphiFactory;
import com.master.universite.factory.BatimentFactory;
import com.master.universite.factory.SalleFactory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "BatimentServlet", value = "/BatimentServlet")
public class BatimentServlet extends HttpServlet {
//    private SalleDao salleDao;
//    private AmphiDao amphiDao;
//    private FeteAdapter feteAdapter;
//    private SoutenanceAdapter soutenanceAdapter;

    @Override
    public void init() throws ServletException {
        super.init();
//        salleDao = new SalleDaoImpl();
//        amphiDao = new AmphiDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String action = request.getParameter("action");
//        Batiment batiment = null;
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//
//            if ("delete".equals(action)) {
//                Salle salleToDelete = salleDao.getById(id);
//                Amphi amphiToDelete = amphiDao.getById(id);
//                if (salleToDelete != null) {
//                    salleDao.delete(id);
//                } else if (amphiToDelete != null) {
//                    amphiDao.delete(id);
//                } else {
//                    response.getWriter().println("Batiment with ID " + id + " not found.");
//                }
//
//            }
//            if ("adapt".equals(action)) {
//                Salle salleToAdapt = salleDao.getById(id);
//                Amphi amphiToToadapt = amphiDao.getById(id);
//                if (salleToAdapt != null) {
//                    FeteAdapter feteAdapter = new FeteAdapter(salleToAdapt);
//                    request.setAttribute("adapteFete", feteAdapter);
//                } else if (amphiToToadapt != null) {
//                    SoutenanceAdapter soutenanceAdapter = new SoutenanceAdapter(amphiToToadapt);
//                    request.setAttribute("adapteSoutenance", soutenanceAdapter);
//                } else {
//                    response.getWriter().println("Batiment with ID " + id + " not found.");
//                }
//
//            } else {
//                Salle salle = salleDao.getById(id);
//                Amphi amphi = amphiDao.getById(id);
//                if (salle != null) {
//                    batiment = salle;
//                } else if (amphi != null) {
//                    batiment = amphi;
//                } else {
//                    response.getWriter().println("Batiment with ID " + id + " not found.");
//                }
//            }
//        }
//        List<Salle> salles = salleDao.getAll();
//        List<Amphi> amphis = amphiDao.getAll();
//        request.setAttribute("batiment", batiment);
//        request.setAttribute("salles", salles);
//        request.setAttribute("amphis", amphis);
        request.getRequestDispatcher("/Template/batiment.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String emplacement = request.getParameter("emplacement");
//        String tailleStr = request.getParameter("taille");
//        int taille = Integer.parseInt(tailleStr);
//        String fonctionnalite = request.getParameter("fonctionnalite").toLowerCase();
//        String description = request.getParameter("description");
//
//        BatimentFactory batimentFactory;
//        Batiment batiment;
//
//        switch (fonctionnalite) {
//            case "salle":
//                batimentFactory = new SalleFactory();
//                break;
//            case "amphi":
//                batimentFactory = new AmphiFactory();
//                break;
//            default:
//                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                response.getWriter().println("Invalid batiment type.");
//                return;
//        }
//        batiment = batimentFactory.createBatiment();
//        batiment.setEmplacement(emplacement);
//        batiment.setTaille(taille);
//        batiment.setDescription(description);
//
//        if ("salle".equals(fonctionnalite)) {
//            salleDao.save((Salle) batiment);
//        } else if ("amphi".equals(fonctionnalite)) {
//            amphiDao.save((Amphi) batiment);
//        }
//        List<Salle> salles = salleDao.getAll();
//        List<Amphi> amphis = amphiDao.getAll();
//        request.setAttribute("salles", salles);
//        request.setAttribute("amphis", amphis);
//        request.getRequestDispatcher("/views/Batiment.jsp").forward(request, response);
//        request.getRequestDispatcher("/views/Batiment.jsp").forward(request, response);
//    }
}
