package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.Beans.Personnel;
import org.gstfac.gestionfactulte.modele.DAO.JDBC_Connexion;
import org.gstfac.gestionfactulte.modele.DAO.Personnel_DAO;

import java.sql.*;
import java.util.ArrayList;

public class Personnel_DAO_JDBC implements Personnel_DAO {
    private final Connection conn;

    // Constantes pour les requêtes SQL
    private static final String SELECT_PERSONNEL_BY_EMAIL_PASSWORD = "SELECT * FROM personnel WHERE email=? AND password=?";
    private static final String INSERT_PERSONNEL = "INSERT INTO personnel(nom, prenom, fonction, identifiant, email, password) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_PERSONNEL = "SELECT * FROM personnel ORDER BY ID_Personnel";
    private static final String SELECT_PERSONNEL_BY_ID = "SELECT * FROM personnel WHERE ID_Personnel=?";
    private static final String UPDATE_PERSONNEL = "UPDATE personnel SET nom=?, prenom=?, fonction=?, identifiant=?, email=?, password=? WHERE ID_Personnel=?";
    private static final String DELETE_PERSONNEL_BY_ID = "DELETE FROM personnel WHERE ID_Personnel=?";


    public Personnel_DAO_JDBC() {
        this.conn = JDBC_Connexion.getConnetion();
    }
    @Override
    public Personnel Login(String email, String password) {
        Personnel personnel = null;

        try (PreparedStatement pst = conn.prepareStatement("SELECT * FROM personnel WHERE email=? AND password=?")) {
            pst.setString(1, email);
            pst.setString(2, password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    personnel = new Personnel();
                    personnel.setID_Personnel(rs.getInt("ID_Personnel"));
                    personnel.setNom(rs.getString("nom"));
                    personnel.setPrenom(rs.getString("prenom"));
                    personnel.setFonction(rs.getString("fonction"));
                    personnel.setIdentifiant(rs.getString("identifiant"));
                    personnel.setEmail(rs.getString("email"));
                    personnel.setPassword(rs.getString("password"));

                    System.out.println("Connexion réussie!");
                } else {
                    System.out.println("Identifiant ou mot de passe incorrect!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personnel;
    }

        @Override
        public Personnel Register(Personnel personnel) {
            try (PreparedStatement pst = conn.prepareStatement(INSERT_PERSONNEL, Statement.RETURN_GENERATED_KEYS)) {
                pst.setString(1, personnel.getNom());
                pst.setString(2, personnel.getPrenom());
                pst.setString(3, personnel.getFonction());
                pst.setString(4, personnel.getIdentifiant());
                pst.setString(5, personnel.getEmail());
                pst.setString(6, personnel.getPassword());

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Inscription réussie!");
                    try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            personnel.setID_Personnel(generatedKeys.getInt(1));
                        }
                    }
                } else {
                    System.out.println("Échec de l'inscription!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return personnel;
        }

        @Override
        public ArrayList<Personnel> findAll() {
            ArrayList<Personnel> listePersonnel = new ArrayList<>();
            try (Statement st = conn.createStatement();
                 ResultSet rs = st.executeQuery(SELECT_ALL_PERSONNEL)) {
                while (rs.next()) {
                    Personnel personnel = new Personnel();
                    personnel.setID_Personnel(rs.getInt("ID_Personnel"));
                    personnel.setNom(rs.getString("nom"));
                    personnel.setPrenom(rs.getString("prenom"));
                    personnel.setFonction(rs.getString("fonction"));
                    personnel.setIdentifiant(rs.getString("identifiant"));
                    personnel.setEmail(rs.getString("email"));
                    personnel.setPassword(rs.getString("password"));

                    listePersonnel.add(personnel);
                }
                if (!listePersonnel.isEmpty()) {
                    System.out.println("Recherche terminée!");
                } else {
                    System.out.println("Table vide!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return listePersonnel;
        }

        @Override
        public Personnel findByID(int ID_Personnel) {
            Personnel personnel = new Personnel();
            try (PreparedStatement pst = conn.prepareStatement(SELECT_PERSONNEL_BY_ID)) {
                pst.setInt(1, ID_Personnel);

                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        personnel.setID_Personnel(rs.getInt("ID_Personnel"));
                        personnel.setNom(rs.getString("nom"));
                        personnel.setPrenom(rs.getString("prenom"));
                        personnel.setFonction(rs.getString("fonction"));
                        personnel.setIdentifiant(rs.getString("identifiant"));
                        personnel.setEmail(rs.getString("email"));
                        personnel.setPassword(rs.getString("password"));
                    }
                }
                if (personnel.getID_Personnel() != 0) {
                    System.out.println("Recherche terminée!");
                } else {
                    System.out.println("ID_Personnel non valide!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return personnel;
        }

    @Override
    public void insert(Personnel personnel) {
        try (PreparedStatement pst = conn.prepareStatement(INSERT_PERSONNEL)) {
            pst.setString(1, personnel.getNom());
            pst.setString(2, personnel.getPrenom());
            pst.setString(3, personnel.getFonction());
            pst.setString(4, personnel.getIdentifiant());
            pst.setString(5, personnel.getEmail());
            pst.setString(6, personnel.getPassword());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Personnel inséré avec succès!");
            } else {
                System.out.println("Échec de l'insertion du personnel!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
        public void update(Personnel personnel) {
            try (PreparedStatement pst = conn.prepareStatement(UPDATE_PERSONNEL)) {
                pst.setString(1, personnel.getNom());
                pst.setString(2, personnel.getPrenom());
                pst.setString(3, personnel.getFonction());
                pst.setString(4, personnel.getIdentifiant());
                pst.setString(5, personnel.getEmail());
                pst.setString(6, personnel.getPassword());
                pst.setInt(7, personnel.getID_Personnel());
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Personnel modifié avec succès!");
                } else {
                    System.out.println("Échec de la modification du personnel!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void deleteByID(int ID_Personnel) {
            try (PreparedStatement pst = conn.prepareStatement(DELETE_PERSONNEL_BY_ID)) {
                pst.setInt(1, ID_Personnel);

                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Personnel supprimé avec succès!");
                } else {
                    System.out.println("Échec de la suppression du personnel!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}

