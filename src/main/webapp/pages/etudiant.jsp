<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 29/01/2024
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Etudiant" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Section" %>

<html>
<head>
    <title>Filiere</title>
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
        <h2>Ajouter ou faire une modification sur la liste des etudiants</h2>
        <form action="EtudiantServlet" method="post">
            <div class="mb-3">
<%--                <label for="id" class="form-label">ID:</label>--%>
                <input type="hidden" name="id" id="id"
                       value="<%= request.getAttribute("etudiant") != null ? ((Etudiant)request.getAttribute("etudiant")).getId() : "" %>">
            </div>
            <div class="mb-3">
                <label for="nom" class="form-label">Nom:</label>
                <input type="text" id="nom" name="nom" class="form-control" placeholder="Enter le nom ..." required
                       value="<%= request.getAttribute("etudiant") != null ? ((Etudiant)request.getAttribute("etudiant")).getNom() : "" %>">
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prenom:</label>
                <input type="text" id="prenom" name="prenom" class="form-control" placeholder="Enter le prenom ..." required
                       value="<%= request.getAttribute("etudiant") != null ? ((Etudiant)request.getAttribute("etudiant")).getPrenom() : "" %>">
            </div>
            <div class="mb-3">
                <label for="code" class="form-label">Code:</label>
                <input type="text" id="code" name="code" class="form-control" placeholder="Enter student code.." required
                       value="<%= request.getAttribute("etudiant") != null ? ((Etudiant)request.getAttribute("etudiant")).getCode() : "" %>">
            </div>
            <div class="mb-3">
                <label for="situationScolaire" class="form-label">Situation Scolaire:</label>
                <input type="text" id="situationScolaire" name="situationScolaire" class="form-control"
                       placeholder="Enter student situation scolaire.." required
                       value="<%= request.getAttribute("etudiant") != null ? ((Etudiant)request.getAttribute("etudiant")).getSituationScolaire() : "" %>">
            </div>
            <div class="mb-3">
                <label for="section" class="form-label">Section:</label>
                <select id="section" name="section_id" class="form-select">
                    <% List<Section> sections = (List<Section>) request.getAttribute("sections");
                        if (sections != null && !sections.isEmpty()) {
                            for (Section section : sections) { %>
                    <option value="<%= section.getId() %>"><%= section.getNom() %></option>
                    <% }} %>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

    <aside id="customers">
        <h2>La liste des etudiants</h2>
        <table class="table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Code</th>
                <th>Situation Scolaire</th>
                <th>Section</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
                if (etudiants != null && !etudiants.isEmpty()) {
                    for (Etudiant etudiant : etudiants) { %>
            <tr>
                <td><%= etudiant.getNom() %></td>
                <td><%= etudiant.getPrenom() %></td>
                <td><%= etudiant.getCode() %></td>
                <td><%= etudiant.getSituationScolaire() %></td>
                <td><%= etudiant.getSection().getNom() %></td>
                <td>
                    <a href="EtudiantServlet?id=<%= etudiant.getId() %>" class="btn btn-primary">Edit</a>
                    <a href="EtudiantServlet?action=delete&id=<%= etudiant.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <% }
            } else { %>
            <tr>
                <td colspan="7"><h1>Aucune etudiant trouvez</h1></td>
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

