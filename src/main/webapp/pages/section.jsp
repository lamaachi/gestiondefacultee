<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 05/02/2024
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Enseignant" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Filiere" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Section" %>

<html>
<head>
    <title>Section</title>
    <%@ include file="../Template/Head.jsp" %>
    <!-- Ajouter les liens vers les fichiers CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzE8Fy3qzvlJy3+J1mwpp5lt5By+e9/zWX+g+C8gRn/DxXry6U5UkdjHVXut2zHp" crossorigin="anonymous">
</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<main class="container mt-5">
    <div>
        <h2>Ajouter ou faire une modification sur la liste des Sections</h2>
        <form action="SectionServlet" method="post">
            <div class="mb-3">
                <label for="filiere" class="form-label">Filiere:</label>
                <select id="filiere" name="filiere_id" class="form-select">
                    <% List<Filiere> filieres = (List<Filiere>) request.getAttribute("filieres");
                        if (filieres != null && !filieres.isEmpty()) {
                            for (Filiere filiere : filieres) { %>
                    <option value="<%= filiere.getId() %>"><%= filiere.getNom() %></option>
                    <% }} %>
                </select>
            </div>
            <input type="hidden" name="id" id="id"
                   value="<%= request.getAttribute("section") != null ? ((Section)request.getAttribute("section")).getId() : "" %>">
            <div class="mb-3">
                <label for="nom" class="form-label">Section Name:</label>
                <input type="text" id="nom" name="nom" class="form-control" placeholder="Enter section name.." required
                       value="<%= request.getAttribute("section") != null ? ((Section)request.getAttribute("section")).getNom() : "" %>">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <aside id="customers">
        <h2>La liste des Sections</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Filiere</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% List<Section> sections = (List<Section>) request.getAttribute("sections");
                if (sections != null && !sections.isEmpty()) {
                    for (Section section : sections) { %>
            <tr>
                <td><%= section.getNom() %></td>
                <td><%= section.getFiliere().getNom() %></td>
                <td>
                    <a href="SectionServlet?id=<%= section.getId() %>" class="btn btn-primary">Edit</a>
                    <a href="SectionServlet?action=delete&id=<%= section.getId() %>" class="btn btn-danger">Delete</a>
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
<!-- Ajouter le lien vers le fichier JavaScript de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-7A7FSqOG1GwWt0G7G4Ax6KO2t7ACx5PiKtd8Fut/xJguVvmf1VrJSjq1TKyA9nKo" crossorigin="anonymous"></script>
</body>
</html>

