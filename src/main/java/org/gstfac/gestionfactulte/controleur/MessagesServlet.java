package org.gstfac.gestionfactulte.controleur;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MessagesServlet", value = "/MessagesServlet")
public class MessagesServlet extends HttpServlet {
//    private ChefDepartementMediator mediator;
//    private PersonnelDao personnelDao;

    @Override
    public void init() throws ServletException {
        super.init();
//        mediator = new ChefDepartementMediatorImpl();
//        personnelDao = new PersonnelDaoImpl();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<Message> messages = mediator.receiveMessages();
//        List<ChefDepartement> chefDepartements = mediator.getChefsDepartement();
//
//        request.setAttribute("messages", messages);
//        request.setAttribute("chefDepartements", chefDepartements);
        request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
    }

//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String senderIdParam = request.getParameter("sender");
//        String content = request.getParameter("content");
//
//        if (senderIdParam != null && !senderIdParam.isEmpty() && content != null && !content.isEmpty()) {
//            Long senderId = Long.parseLong(senderIdParam);
//            ChefDepartement sender = (ChefDepartement) personnelDao.getById(senderId);
//            Message message = new Message();
//            message.setSender(sender);
//            message.setContent(content);
//            mediator.sendMessage(message);
//        }
//            List<Message> messages = mediator.receiveMessages();
//            List<ChefDepartement> chefDepartements = mediator.getChefsDepartement();
//            request.setAttribute("chefDepartements", chefDepartements);
//            request.setAttribute("messages", messages);
//            request.getRequestDispatcher("/views/messages.jsp").forward(request, response);
//    }
}
