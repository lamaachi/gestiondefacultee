<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 20/01/2024
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.Beans.Etudiant" %>
<%@ page import="java.util.Iterator" %>

<%@ include file="../Template/Head.jsp" %>
<html>
<head>
    <title>Layout | Dash Ui - Bootstrap 5 Admin Dashboard Template</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div id="db-wrapper">
    <!-- navbar vertical -->
    <%@ include file="../Template/navbar-vertival.jsp" %>
    <!-- page content -->
    <div id="page-content">
        <%@ include file="../Template/Header.jsp" %>
        <!-- Container fluid -->
        <div class="container-fluid px-6 py-4">
            <!-- Dynamic content placeholder -->
            <div class="container mt-5">
                <a href="<%= request.getContextPath() %>/afficheEtd?action=viewAll" class="btn btn-primary mb-3">Afficher tous les étudiants</a>
                <!-- Ajouter le lien pour ajouter un nouvel étudiant -->
                <a href="<%= request.getContextPath() %>/addetudiant" class="btn btn-success mb-3">Ajouter un nouvel étudiant</a>

                <!-- Ajouter le formulaire de recherche -->
                <form action="<%= request.getContextPath() %>/afficheEtd?action=searchByCode" method="GET" class="mb-3">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Code étudiant" name="searchCode">
                        <button class="btn btn-primary" type="submit">Rechercher</button>
                    </div>
                </form>

                <h2>Liste des étudiants</h2>

                <table class="table table-bordered table-striped">
                    <thead class="thead-dark">
                    <tr>
                        <th>ID</th> <!-- Ajoutez cette ligne pour afficher la colonne ID -->
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Email</th>
                        <th>Code</th>
                        <th>CNE</th>
                        <th>Situation Scolaire</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
                        if (etudiants != null) {
                            for (Etudiant etudiant : etudiants) { %>
                    <tr>
                        <td><%= etudiant.getId_Etudiant() %></td> <!-- Ajoutez cette ligne pour afficher l'ID -->
                        <td><%= etudiant.getNom() %></td>
                        <td><%= etudiant.getPrenom() %></td>
                        <td><%= etudiant.getEmail() %></td>
                        <td><%= etudiant.getCode() %></td>
                        <td><%= etudiant.getCNE() %></td>
                        <td><%= etudiant.getSituationScolaire() %></td>
                        <td>
                            <a class="btn btn-danger" href="<%= request.getContextPath() %>/afficheEtd?action=delete&ID_Etudiant=<%= etudiant.getId_Etudiant() %>">Supprimer</a>
                            <a class="btn btn-warning" href="<%= request.getContextPath() %>/afficheEtd?action=edit&ID_Etudiant=<%= etudiant.getId_Etudiant() %>">Modifier</a>
                        </td>
                    </tr>
                    <% } } else {
                        out.println("Liste d'étudiants est nulle !");
                    }
                    %>
                    </tbody>
                </table>

            </div>
        </div>
    </div>
</div>
<%@ include file="../Template/scripts.jsp" %>
<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>






