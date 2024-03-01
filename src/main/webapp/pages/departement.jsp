<%@ page import="org.gstfac.gestionfactulte.modele.entity.Departement" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../Template/Head.jsp" %>
    <title>Departement</title>

    <!-- Bootstrap CSS link -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wyq8f8b3k9gi9vIbbVdID9eJ4meCJo"
          crossorigin="anonymous">
</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<div class="container mt-3">
    <h2>Ajouter ou faire une modification sur la liste des Departements</h2>
    <form action="DepartementServlet" method="post">
        <div class="form-group">
            <label for="nom">Department Name:</label>
            <input type="hidden" name="id" id="id"
                   value="<%= request.getAttribute("department") != null ? ((Departement)request.getAttribute("department")).getId() : "" %>"
                   class="form-control">
            <input type="text" id="nom" name="nom" placeholder="Enter department name.." required
                   value="<%= request.getAttribute("department") != null ? ((Departement)request.getAttribute("department")).getNom() : "" %>"
                   class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<aside class="container mt-3" id="customers">
    <h2>Liste des départements</h2>
    <table class="table">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% List<Departement> departments = (List<Departement>) request.getAttribute("departments");
            if (departments != null && !departments.isEmpty()) {
                for (Departement department : departments) { %>
        <tr>
            <td><%= department.getNom() %></td>
            <td>
                <a href="DepartementServlet?id=<%= department.getId() %>" class="btn btn-warning">Edit</a>
                <a href="DepartementServlet?action=delete&id=<%= department.getId() %>"
                   class="btn btn-danger">Delete</a>
            </td>
        </tr>
        <% }
        } else { %>
        <tr>
            <td colspan="3"><h1>Aucune donnees</h1></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</aside>

<!-- Bootstrap JS and Popper.js links -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVdID9eJ3n6wC"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
        integrity="sha384-g6rVRD5B6NU5BDDAnKCR6QnWUc6B93/BBSXjh1B/gI"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wyq8f8b3k9gi9vIbbVdID9eJ4meCJo"
        crossorigin="anonymous"></script>
</body>
</html>
