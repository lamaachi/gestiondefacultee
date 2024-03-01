<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 30/01/2024
  Time: 14:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Filiere" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Departement" %>

<html>
<head>
    <title>Filiere</title>
    <%@ include file="../Template/Head.jsp" %>
</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<main class="container mt-5">
    <div class="row">
        <div class="col-md-6">
            <h2>Ajouter ou modifier un Filiere</h2>
            <form action="FiliereServlet" method="post">
                <div class="form-group">
                    <label for="nom">Filiere Name:</label>
                    <input type="hidden" name="id" id="id"
                           value="<%= request.getAttribute("filiere") != null ? ((Filiere)request.getAttribute("filiere")).getId() : "" %>"
                           class="form-control">
                    <input type="text" id="nom" name="nom" placeholder="Enter filiere name.." required
                           value="<%= request.getAttribute("filiere") != null ? ((Filiere)request.getAttribute("filiere")).getNom() : "" %>"
                           class="form-control">
                </div>
                <div class="form-group">
                    <label for="departement">Departement</label>
                    <select id="departement" name="departement_id" class="form-control">
                        <% List<Departement> departements = (List<Departement>) request.getAttribute("departements");
                            if (departements != null && !departements.isEmpty()) {
                                for (Departement departement : departements) { %>
                        <option value="<%=departement.getId()%>"><%=departement.getNom()%></option>
                        <% }
                        } %>
                    </select>
                </div>
                <input type="submit" value="Submit" class="btn btn-primary">
            </form>
        </div>
    </div>

    <aside class="mt-5">
        <h2>La liste des filieres</h2>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>Nom</th>
                <th>Departement</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% List<Filiere> filieres = (List<Filiere>) request.getAttribute("filieres");
                if (filieres != null && !filieres.isEmpty()) {
                    for (Filiere filiere : filieres) { %>
            <tr>
                <td><%= filiere.getNom() %></td>
                <td><%= filiere.getDepartement().getNom() %></td>
                <td>
                    <a href="FiliereServlet?id=<%= filiere.getId() %>" class="btn btn-info">Edit</a>
                    <a href="FiliereServlet?action=delete&id=<%= filiere.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <% }
            } else { %>
            <tr>
                <td colspan="4"><h1>Aucune donnees</h1></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </aside>
</main>
<%@ include file="../Template/scripts.jsp" %>
</body>
</html>
