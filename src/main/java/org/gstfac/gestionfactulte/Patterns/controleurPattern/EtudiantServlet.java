package org.gstfac.gestionfactulte.Patterns.controleurPattern;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "EtudiantServlet", value = "/EtudiantServlet")
public class EtudiantServlet extends HttpServlet {

//    private EtudiantDao etudiantDao;
//    private SectionDao sectionDao;

    @Override
    public void init() throws ServletException {
        super.init();
//        etudiantDao = new EtudiantDaoImpl();
//        sectionDao = new SectionDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        String idParam = request.getParameter("id");
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String code = request.getParameter("code");
//        String situationScolaire = request.getParameter("situationScolaire");
//        if (idParam != null && !idParam.isEmpty()) {
//            Long id = Long.parseLong(idParam);
//
//            if ("delete".equals(action)) {
//                etudiantDao.delete(id);
//            } else {
//                Etudiant etudiant = etudiantDao.getById(id);
//                request.setAttribute("etudiant", etudiant);
//            }
//        }
//        List<Section> sections = sectionDao.getAll();
//        List<Etudiant> etudiants = etudiantDao.getAll();
//        request.setAttribute("sections", sections);
//        request.setAttribute("etudiants", etudiants);
        request.getRequestDispatcher("/pages/etudiant.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String nom = request.getParameter("nom");
//        String prenom = request.getParameter("prenom");
//        String code = request.getParameter("code");
//        String situationScolaire = request.getParameter("situationScolaire");
//        String sectionId = request.getParameter("section_id");
//        int id_section = Integer.parseInt(sectionId);
//        Section section = sectionDao.getById(id_section);
//
//        if (idParam != null && !idParam.isEmpty()) {
//            Long id = Long.parseLong(idParam);
//            Etudiant existingEtudiant = etudiantDao.getById(id);
//            if (existingEtudiant != null) {
//                existingEtudiant.setNom(nom);
//                existingEtudiant.setPrenom(prenom);
//                existingEtudiant.setCode(code);
//                existingEtudiant.setSituationScolaire(situationScolaire);
//                existingEtudiant.setSection(section);
//                etudiantDao.update(existingEtudiant);
//            } else {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                return;
//            }
//        } else {
//            Etudiant newEtudiant = new Etudiant();
//            newEtudiant.setNom(nom);
//            newEtudiant.setPrenom(prenom);
//            newEtudiant.setCode(code);
//            newEtudiant.setSituationScolaire(situationScolaire);
//            newEtudiant.setSection(section);
//            etudiantDao.save(newEtudiant);
//        }
//
//        List<Section> sections = sectionDao.getAll();
//        List<Etudiant> etudiants = etudiantDao.getAll();
//        request.setAttribute("sections", sections);
//        request.setAttribute("etudiants", etudiants);
//        request.getRequestDispatcher("/views/etudiant.jsp").forward(request, response);
//    }
}
