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
            <h2>Add or Update Filiere</h2>
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
                <input type="submit" value="Save" class="btn btn-primary">
            </form>
        </div>
    </div>

    <aside class="mt-5">
        <h2>Filieres List</h2>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
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
                <td><%= filiere.getId() %></td>
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
                <td colspan="4"><h1>No data found</h1></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </aside>
</main>
<%@ include file="../Template/scripts.jsp" %>
</body>
</html>
