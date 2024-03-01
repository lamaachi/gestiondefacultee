<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 29/01/2024
  Time: 18:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Personnel" %>
<html>
<head>
    <title>Personnels</title>
    <%@ include file="../Template/Head.jsp" %>
    <!-- Ajouter les liens vers les fichiers CSS de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-pzE8Fy3qzvlJy3+J1mwpp5lt5By+e9/zWX+g+C8gRn/DxXry6U5UkdjHVXut2zHp" crossorigin="anonymous">
</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<main>
    <div class="container">
        <h2>Ajouter ou faire une modification sur la liste des personnels</h2>
        <!-- Utilisation des classes de Bootstrap pour le formulaire -->
        <form class="row g-3" action="PersonnelServlet" method="post">
            <input type="hidden" name="id" id="id"
                   value="<%= request.getAttribute("personnel") != null ? ((Personnel)request.getAttribute("personnel")).getId() : "" %>">
            <div class="col-md-6">
                <label for="nom" class="form-label">Nom:</label>
                <input type="text" id="nom" name="nom" class="form-control" placeholder="Enter personnel name.." required
                       value="<%= request.getAttribute("personnel") != null ? ((Personnel)request.getAttribute("personnel")).getNom() : "" %>">
            </div>
            <div class="col-md-6">
                <label for="prenom" class="form-label">Prenom:</label>
                <input type="text" id="prenom" name="prenom" class="form-control" placeholder="Enter personnel name.." required
                       value="<%= request.getAttribute("personnel") != null ? ((Personnel)request.getAttribute("personnel")).getPrenom() : "" %>">
            </div>
            <div class="col-md-6">
                <label for="fonction" class="form-label">Fonction:</label>
                <select id="fonction" name="fonction" class="form-select">
                    <option value="enseignant">
                        Enseignant
                    </option>
                    <option value="administrateur">
                        Administrateur
                    </option>
                    <option value="doyen">
                        Doyen
                    </option>
                    <option value="chefdepartement">
                        Chef de departement
                    </option>
                </select>
            </div>
            <div class="col-md-12">
                <input type="submit" value="Submit" class="btn btn-primary">
            </div>
        </form>
    </div>

    <div class="container mt-4">
        <h2>La liste des personnels</h2>
        <!-- Utilisation des classes de Bootstrap pour la table -->
        <table class="table">
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prenom</th>
                <th>Fonction</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% List<Personnel> personnelList = (List<Personnel>) request.getAttribute("personnels");
                if (personnelList != null && !personnelList.isEmpty()) {
                    for (Personnel personnel : personnelList) { %>
            <tr>
                <td><%= personnel.getNom() %></td>
                <td><%= personnel.getPrenom() %></td>
                <td><%= personnel.getFonction() %></td>
                <td>
                    <a href="PersonnelServlet?id=<%= personnel.getId() %>" class="btn btn-primary">Edit</a>
                    <a href="PersonnelServlet?action=delete&id=<%= personnel.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <% }
            } else { %>
            <tr>
                <td colspan="5"><h1>Aucune personnel trouvez</h1></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</main>
<!-- Ajouter le lien vers le fichier JavaScript de Bootstrap -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-7A7FSqOG1GwWt0G7G4Ax6KO2t7ACx5PiKtd8Fut/xJguVvmf1VrJSjq1TKyA9nKo" crossorigin="anonymous"></script>
</body>
</html>
