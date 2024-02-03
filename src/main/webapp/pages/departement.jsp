<%@ page import="org.gstfac.gestionfactulte.modele.entity.Departement" %>
<%--
  Created by IntelliJ IDEA.
  User: Tarik
  Date: 29/01/2024
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="../Template/Head.jsp" %>
    <title>Title</title>
</head>
<body>
<header>
    <%@ include file="../Template/Header.jsp" %>
</header>
<div>
    <h2>Add or Update Department</h2>
    <form action="DepartementServlet" method="post">
        <label for="nom">Department Name:</label>
        <input type="hidden" name="id" id="id"
               value="<%= request.getAttribute("department") != null ? ((Departement)request.getAttribute("department")).getId() : "" %>">
        <input type="text" id="nom" name="nom" placeholder="Enter department name.." required
               value="<%= request.getAttribute("department") != null ? ((Departement)request.getAttribute("department")).getNom() : "" %>">
        <input type="submit" value="Submit">
    </form>
</div>

<aside id="customers">
    <h2>Liste des département</h2>
    <table style="width: 100%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% List<Departement> departments = (List<Departement>) request.getAttribute("departments");
            if (departments != null && !departments.isEmpty()) {
                for (Departement department : departments) { %>
        <tr>
            <td><%= department.getId() %>
            </td>
            <td><%= department.getNom() %>
            </td>
            <td><a href="DepartementServlet?id=<%= department.getId() %>">
                <button class="button button1">Edit</button>
            </a>
                <a href="DepartementServlet?action=delete&id=<%= department.getId() %>">
                    <button class="button button3">Delete</button>
                </a>
            </td>
        </tr>
        <% }
        } else { %>
        <tr>
            <td colspan="3"><h1>No data found</h1></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</aside>
</main>
</body>
</html>
