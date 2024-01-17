package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.gstfac.gestionfactulte.modele.Beans.Personnel;

import java.io.IOException;

@WebServlet(urlPatterns = "/home",name = "home")
public class HomeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ServletException, IOException {
        // Your processing logic here

        // Assuming you want to forward to Success.jsp after processing

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        // Forward the request to the Success.jsp
        RequestDispatcher dispatcher = req.getRequestDispatcher("/layout.jsp");
        dispatcher.forward(req, resp);
    }


    // Other methods as needed
}