<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 20/01/2024
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <h2>Modifier l'étudiant</h2>

                <form action="afficheEtd" method="post">
                    <div class="mb-3">
                        <label for="nom" class="form-label">Nom:</label>
                        <input type="text" class="form-control" name="nom" value="${etudiant.nom}" required>
                    </div>
                    <div class="mb-3">
                        <label for="prenom" class="form-label">Prénom:</label>
                        <input type="text" class="form-control" name="prenom" value="${etudiant.prenom}" required>
                    </div>
                    <div class="mb-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" class="form-control" name="email" value="${etudiant.email}" required>
                    </div>
                    <div class="mb-3">
                        <label for="code" class="form-label">Code:</label>
                        <input type="text" class="form-control" name="code" value="${etudiant.code}" required>
                    </div>
                    <div class="mb-3">
                        <label for="CNE" class="form-label">CNE:</label>
                        <input type="text" class="form-control" name="CNE" value="${etudiant.CNE}" required>
                    </div>
                    <div class="mb-3">
                        <label for="situationScolaire" class="form-label">Situation Scolaire:</label>
                        <input type="text" class="form-control" name="situationScolaire" value="${etudiant.situationScolaire}" required>
                    </div>
                    <div class="mb-3">
                        <input type="hidden" name="action" value="update">
                        <button type="submit" class="btn btn-primary">Enregistrer</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<%@ include file="../Template/scripts.jsp" %>
<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

