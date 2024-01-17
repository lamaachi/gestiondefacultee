<%@ page import="org.gstfac.gestionfactulte.modele.Beans.Personnel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <html>
  <head>
    <title>Success Page</title>
    <link rel="stylesheet" href="./webjars/bootstrap/5.3.0/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./webjars/font-awesome/6.5.1/css/all.min.css">
  </head>
  <body>
  <section class="vh-100">
    <div class="container-fluid h-custom">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
          <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">Login Successful!</h4>
            <% Personnel personnelAuth = (Personnel) request.getAttribute("personnelAuth"); %>
            <p>Welcome, <%= personnelAuth.getNom() %>!</p>
            <hr>
            <p class="mb-0">Here is some information about you:</p>
            <ul>
              <li><strong>ID:</strong> <%= personnelAuth.getID_Personnel()%></li>
              <li><strong>Function:</strong> <%= personnelAuth.getFonction() %></li>
              <li><strong>Email:</strong> <%= personnelAuth.getEmail() %></li>
              <!-- Add more attributes as needed -->
            </ul>
          </div>
        </div>
      </div>
    </div>
  </section>
  </body>
  </html>
