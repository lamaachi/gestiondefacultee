//package org.gstfac.gestionfactulte.controleur;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation.PersonnelDaoImpl;
//import org.gstfac.gestionfactulte.modele.entity.Personnel;
//
//import java.io.IOException;
//
//@WebServlet(name = "login", urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//    private PersonnelDaoImpl personnelDao;
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        personnelDao = new PersonnelDaoImpl();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/");
//        dispatcher.forward(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String email = req.getParameter("email");
//        String password = req.getParameter("password");
//
//        Personnel personnelAuth = personnelDao.login(email, password);
//
//        if (personnelAuth != null) {
//            req.setAttribute("personnelAuth", personnelAuth);
//            // Forward the request to the Success.jsp
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/Template/Success.jsp");
//            dispatcher.forward(req, resp);
//        } else {
//            // Authentication failed, you can redirect to a login page with an error message
//            resp.sendRedirect("index.jsp?error=authentication_failed");
//        }
//    }
//}
