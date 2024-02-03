package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DepartementServlet", value = "/DepartementServlet")
public class DepartementServlet extends HttpServlet {
//    private DepartementDao departementDao;
//    private CompositeDepartment compositeDepartment;

    @Override
    public void init() throws ServletException {
        super.init();
//        departementDao = new DepartementDaoImpl();
//        List<Departement> departments = departementDao.getAll();
//        compositeDepartment = new CompositeDepartment();
//        for (Departement department : departments) {
//            compositeDepartment.addDepartment(department);
//        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String action = request.getParameter("action");
//        String idParam = request.getParameter("id");
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//            if ("delete".equals(action)) {
//                Departement deletedDepartment = departementDao.getById(id);
//                departementDao.delete(id);
//                compositeDepartment.removeDepartment(deletedDepartment);
//            } else {
//                Departement department = departementDao.getById(id);
//                request.setAttribute("department", department);
//            }
//        }
//        request.setAttribute("departments",compositeDepartment.getAllDepartments() );
        request.getRequestDispatcher("/pages/departement.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String idParam = request.getParameter("id");
//        String nom = request.getParameter("nom");
//        if (idParam != null && !idParam.isEmpty()) {
//            int id = Integer.parseInt(idParam);
//            Departement existingDepartement = departementDao.getById(id);
//            if (existingDepartement != null) {
//                existingDepartement.setNom(nom);
//                Departement updatedDepartment = departementDao.getById(id);
//                departementDao.update(existingDepartement);
//                compositeDepartment.updateDepartment(existingDepartement,updatedDepartment);
//            } else {
//                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//                return;
//            }
//        } else {
//            Departement newDepartement = new Departement();
//            newDepartement.setNom(nom);
//            departementDao.save(newDepartement);
//            compositeDepartment.addDepartment(newDepartement );
//        }
//        request.setAttribute("departments", compositeDepartment.getAllDepartments());
//        request.getRequestDispatcher("/views/Departement.jsp").forward(request, response);
//    }
}

