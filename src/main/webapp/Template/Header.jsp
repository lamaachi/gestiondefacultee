<style>
    .logo-app-web {
        max-width: 60px; /* ou toute autre taille souhaitée */
        height: auto;
    }
</style>
<div class="header @@classList">
    <!-- navbar -->
    <nav class="navbar-classic navbar navbar-expand-lg">
        <!-- Navbar nav -->
        <a class="navbar-brand" href="/gestionFactulte_war_exploded/HomePage.jsp">
            <img src="logo_logo.jpg" alt="Logo Faculté 1" class="logo-app-web rounded-circle">
            Gestion Faculte
        </a>

        <ul class="navbar-nav navbar-right-wrap ms-auto d-flex nav-top-wrap">
            <!-- List -->
            <!-- Add Batiments Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/BatimentServlet">Batiment</a>
            </li>

            <!-- Add Departement Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/DepartementServlet">Departement</a>
            </li>

            <!-- Add Etudiants Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/EtudiantServlet">Etudiant</a>
            </li>

            <!-- Add Personnel Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/PersonnelServlet">Personne</a>
            </li>

            <!-- Add Section Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/SectionServlet">Section</a>
            </li>

            <!-- Add Fillier Button -->
            <li class="nav-item">
                <a class="nav-link" href="/gestionFactulte_war_exploded/FiliereServlet">Filiere</a>
            </li>

<%--            <!-- Add Messages Button -->--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="/gestionFactulte_war_exploded/MessagesServlet">Messages</a>--%>
<%--            </li>--%>

            <!-- User Dropdown -->
            <li class="dropdown ms-2">
                <a class="rounded-circle" href="#" role="button" id="dropdownUser"
                   data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <div class="avatar avatar-md avatar-indicators avatar-online">
                        <img alt="avatar" src="./Images/avatar.png"
                             class="rounded-circle" />
                    </div>
                </a>
                <!-- User Dropdown Menu -->
                <div class="dropdown-menu dropdown-menu-end"
                     aria-labelledby="dropdownUser">
                    <div class="px-4 pb-0 pt-2">
                        <div class="lh-1">
                            <h5 class="mb-1">Administrateur</h5>
                            <a href="#" class="text-inherit fs-6">View my profile</a>
                        </div>
                        <div class="dropdown-divider mt-3 mb-2"></div>
                    </div>
                    <!-- User Dropdown Items -->
                    <ul class="list-unstyled">
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="me-2 icon-xxs dropdown-item-icon" data-feather="user"></i>Edit
                                Profile
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="me-2 icon-xxs dropdown-item-icon" data-feather="activity"></i>Activity Log
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item text-primary" href="#">
                                <i class="me-2 icon-xxs text-primary dropdown-item-icon" data-feather="star"></i>Go Pro
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="me-2 icon-xxs dropdown-item-icon" data-feather="settings"></i>Account Settings
                            </a>
                        </li>
                        <li>
                            <a class="dropdown-item" href="#">
                                <i class="me-2 icon-xxs dropdown-item-icon" data-feather="power"></i>Sign Out
                            </a>
                        </li>
                    </ul>
                </div>
            </li>
        </ul>
    </nav>
</div>
