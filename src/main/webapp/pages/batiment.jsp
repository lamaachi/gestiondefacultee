<%@ page import="org.gstfac.gestionfactulte.emuns.Fonctionnalite" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Batiment" %>
<%@ page import="org.gstfac.gestionfactulte.Adapter.FeteAdapter" %>
<%@ page import="org.gstfac.gestionfactulte.Adapter.SoutenanceAdapter" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Salle" %>
<%@ page import="java.util.List" %>
<%@ page import="org.gstfac.gestionfactulte.modele.entity.Amphi" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <%@ include file="../Template/Head.jsp" %>
    <title>Title</title>

</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<main class="container mt-5">
    <div>
        <h2>Add or Update Batiment</h2>
        <form action="BatimentServlet" method="post">
            <input type="hidden" name="id" id="id"
                   value="<%= request.getAttribute("batiment") != null ? ((Batiment)request.getAttribute("batiment")).getId() : "" %>">
            <div class="form-group">
                <label for="emplacement">Emplacement:</label>
                <input type="text" class="form-control" id="emplacement" name="emplacement" placeholder="Enter emplacement.." required
                       value="<%= request.getAttribute("batiment") != null ? ((Batiment)request.getAttribute("batiment")).getEmplacement() : "" %>">
            </div>

            <div class="form-group">
                <label for="taille">Taille:</label>
                <input type="number" class="form-control" id="taille" name="taille" placeholder="Enter taille.." required
                       value="<%= request.getAttribute("batiment") != null ? ((Batiment)request.getAttribute("batiment")).getTaille() : "" %>">
            </div>

            <div class="form-group">
                <label for="fonctionnalite">Fonctionnalite:</label>
                <select class="form-control" id="fonctionnalite" name="fonctionnalite">
                    <option value="<%=Fonctionnalite.AMPHI.name()%>">Amphi</option>
                    <option value="<%=Fonctionnalite.SALLE.name()%>">Salle</option>
                </select>
            </div>

            <div class="form-group">
                <label for="description">Description:</label>
                <input type="text" class="form-control" id="description" name="description" placeholder="Enter description.."
                       value="<%= request.getAttribute("batiment") != null ? ((Batiment)request.getAttribute("batiment")).getDescription() : "" %>">
            </div>

            <input type="submit" class="btn btn-primary" value="Save">
        </form>

        <h2>Adapter</h2>
        <div>
            <% FeteAdapter adapteFete = (FeteAdapter) request.getAttribute("adapteFete");
                SoutenanceAdapter adapteSoutenance = (SoutenanceAdapter) request.getAttribute("adapteSoutenance");
                if (adapteFete != null) { %>
            <p class="alert alert-success">Adapted to Fete Events</p>
            <% } else if (adapteSoutenance != null) { %>
            <p class="alert alert-dark-info">Adapted Soutenance</p>
            <% } else { %>
            <p class="alert alert-danger">No adaptation selected.</p>
            <% } %>
        </div>
    </div>

    <aside id="customers" class="mt-5">
        <h2>Batiments</h2>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Emplacement</th>
                <th>Taille</th>
                <th>Fonctionnalite</th>
                <th>Description</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <% List<Salle> salles = (List<Salle>) request.getAttribute("salles");
                if (salles != null && !salles.isEmpty()) {
                    for (Salle salle : salles) { %>
            <tr>
                <td><%= salle.getId() %></td>
                <td><%= salle.getEmplacement() %></td>
                <td><%= salle.getTaille() %></td>
                <td><%= salle.getFonctionnalite() %></td>
                <td><%= salle.getDescription() %></td>
                <td>
                    <a href="BatimentServlet?&action=adapt&id=<%= salle.getId() %>" class="btn btn-info">Adapt</a>
                    <a href="BatimentServlet?&action=delete&id=<%= salle.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <% }
            } %>

            <% List<Amphi> amphis = (List<Amphi>) request.getAttribute("amphis");
                if (amphis != null && !amphis.isEmpty()) {
                    for (Amphi amphi : amphis) { %>
            <tr>
                <td><%= amphi.getId() %></td>
                <td><%= amphi.getEmplacement() %></td>
                <td><%= amphi.getTaille() %></td>
                <td><%= amphi.getFonctionnalite() %></td>
                <td><%= amphi.getDescription() %></td>
                <td>
                    <a href="BatimentServlet?&action=adapt&id=<%= amphi.getId() %>" class="btn btn-info">Adapt</a>
                    <a href="BatimentServlet?&action=delete&id=<%= amphi.getId() %>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
            <% }
            } %>
            </tbody>
        </table>
    </aside>
</main>
<%@ include file="../Template/scripts.jsp" %>



