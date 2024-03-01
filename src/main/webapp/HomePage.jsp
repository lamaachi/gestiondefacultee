<%--
  Created by IntelliJ IDEA.
  User: zertyuiop
  Date: 03/02/2024
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bienvenue à la Gestion de la Faculté</title>
    <%@ include file="./Template/Head.jsp" %>
    <style>
        .logo-faculte {
            max-width: 200px;
            height: auto;
        }
        /* Ajouter un style pour les cartes */
        .card {
            margin-bottom: 20px; /* Espacement entre les cartes */
            border-radius: 15px; /* Arrondir les coins des cartes */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* Ombre douce pour les cartes */
        }
        .card-body {
            padding: 20px; /* Ajouter de l'espace à l'intérieur des cartes */
        }
        .card-title {
            font-size: 1.5rem; /* Taille de police pour le titre de la carte */
        }
        .card-text {
            font-size: 1rem; /* Taille de police pour le texte de la carte */
        }
    </style>
    <!-- Inclure Bootstrap via le CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0-alpha1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+Knujsl5+CBj2m/Q5csr7RjuFScJjEUKJrFtZnf4yoCyt3B" crossorigin="anonymous">
</head>
<body>
<header>
    <%@ include file="./Template/Header.jsp" %>
</header>
<main class="container mt-5">
    <div class="text-center mb-5">
        <h1>Bienvenue à notre système de gestion de faculté</h1>
        <p>Cette application vise à simplifier la gestion des bâtiments, des salles, et des événements au sein de notre faculté.</p>
    </div>
    <div class="row">

        <!-- UCD -->
        <div class="col-md-4">
            <div class="card">
                <img src="Logo_UCD.png" class="card-img-top" alt="Logo du ucd">
                <div class="card-body">
                    <h5 class="card-title">Université Chouaib Doukkali</h5>
                    <p class="card-text">Créée en 1985 au cœur de la ville d'El Jadida dans la région de Doukkala-Abda, l'Université Chouaïb Doukkali a vu le jour avec deux établissements universitaires, la Faculté des Sciences et la Faculté des Lettres et des Sciences Humaines. Aujourd'hui, l'Université se compose de huit établissements universitaires.</p>
                </div>
            </div>
        </div>
        <!-- Faculté 1 -->
        <div class="col-md-4">
            <div class="card">
                <img src="logo_dokkali.png" class="card-img-top" alt="Logo Faculté 1">
                <div class="card-body">
                    <h5 class="card-title">Faculté des Sciences</h5>
                    <p class="card-text">La Faculté des Sciences offre un cadre propice à l'étude et à la recherche dans les divers domaines scientifiques.</p>
                </div>
            </div>
        </div>
        <!-- APP -->
        <div class="col-md-4">
            <div class="card">
                <img src="logo_logo.jpg" style="height: 250px" class="card-img-top" alt="Logo de app">
                <div class="card-body">
                    <h5 class="card-title">Faculté des Sciences</h5>
                    <p class="card-text">Cette application web est conçue pour faciliter la gestion quotidienne de notre faculté.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="text-center mt-5">
        <h2>À propos de l'application</h2>
        <p>Cette application web est conçue pour faciliter la gestion quotidienne de notre faculté, en permettant aux administrateurs et au personnel d'accéder facilement à des informations mises à jour sur les infrastructures et les événements. Grâce à son interface intuitive, elle contribue à l'amélioration continue de notre environnement académique.</p>
    </div>
</main>
<!-- Inclure Bootstrap JavaScript via le CDN -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0-alpha1/js/bootstrap.bundle.min.js" integrity="sha384-X5Xgi5ka3ZvhEXGwz3ZKDEPzkO0F+f8ZbYz/NTozn7BK8z2ThA2vY0LKbMlzsFSe" crossorigin="anonymous"></script>
</body>
</html>






