package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SectionServlet", value = "/SectionServlet")
public class SectionServlet extends HttpServlet {
//    private SectionDao sectionDao;
//    private FiliereDao filiereDao;

    @Override
    public void init() throws ServletException {
        super.init();
//        sectionDao = new SectionDaoImpl();
//        filiereDao = new FiliereDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        String idParam = request.getParameter("id");
//
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//
//            if ("delete".equals(action)) {
//                sectionDao.delete(id);
//            } else {
//                Section section = sectionDao.getById(id);
//                request.setAttribute("section", section);
//            }
//        }
//        List<Filiere> filieres = filiereDao.getAll();
//        List<Section> sections = sectionDao.getAll();
//        request.setAttribute("sections", sections);
//        request.setAttribute("filieres", filieres);
        request.getRequestDispatcher("/pages/section.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String nom = request.getParameter("nom");
//        String filiereId = request.getParameter("filiere_id"); // Assuming you have a filiere dropdown in your form
//        int id_filere = Integer.parseInt(filiereId);
//        Filiere filiere = filiereDao.getById(id_filere);
//
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//            Section existingSection = sectionDao.getById(id);
//            if (existingSection != null) {
//                existingSection.setNom(nom);
//                existingSection.setFiliere(filiere);
//                sectionDao.update(existingSection);
//            } else {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                return;
//            }
//        } else {
//            Section newSection = new Section();
//            newSection.setNom(nom);
//            newSection.setFiliere(filiere);
//            sectionDao.save(newSection);
//        }
//        List<Filiere> filieres = filiereDao.getAll();
//        List<Section> sections = sectionDao.getAll();
//        request.setAttribute("sections", sections);
//        request.setAttribute("filieres", filieres);
//        request.getRequestDispatcher("/views/section.jsp").forward(request, response);
//    }
}
