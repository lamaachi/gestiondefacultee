package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "PersonnelServlet", value = "/PersonnelServlet")
public class PersonnelServlet extends HttpServlet {
//    private PersonnelDao personnelDao;

    @Override
    public void init() throws ServletException {
        super.init();
//        personnelDao = new PersonnelDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String action = request.getParameter("action");
//        Personnel personnel = null;
//
//        if (idParam != null && !idParam.isEmpty()) {
//            Long id = Long.parseLong(idParam);
//            if ("delete".equals(action)) {
//                personnelDao.delete(id);
//                response.getWriter().println("Personnel with ID " + id + " deleted successfully.");
//            } else {
//                personnel = personnelDao.getById(id);
//            }
//        }
//
//        List<Personnel> personnelList = personnelDao.getAll();
//        request.setAttribute("personnel", personnel);
//        request.setAttribute("personnels", personnelList);
        request.getRequestDispatcher("/Template/personnel.jsp").forward(request, response);

    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String fonction = request.getParameter("fonction").toLowerCase();
//        System.out.println(fonction);
//        PersonnelFactory personnelFactory;
//        Personnel newPersonnel;
//
//        switch (fonction) {
//            case "enseignant":
//                personnelFactory = new EnseignantFactory();
//                break;
//            case "doyen":
//                personnelFactory = new DoyenFactory();
//                break;
//            case "administrateur":
//                personnelFactory = new AdministarteurFactory();
//                break;
//            case "chefdepartement":
//                personnelFactory = new ChefDepartementFactory();
//                break;
//            default:
//                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//                response.getWriter().println("Invalid personnel type.");
//                return;
//        }
//
//        newPersonnel = personnelFactory.CreatePersonnel();
//        newPersonnel.setNom(nom);
//        newPersonnel.setPrenom(prenom);
//        personnelDao.save(newPersonnel);
//
//        List<Personnel> personnelList = personnelDao.getAll();
//        request.setAttribute("personnels", personnelList);
//        request.getRequestDispatcher("/views/Personnel.jsp").forward(request, response);
//    }
}
