package org.gstfac.gestionfactulte.modele.DAO.DAOImplimentation;

import org.gstfac.gestionfactulte.modele.Beans.Batiment;
import org.gstfac.gestionfactulte.modele.DAO.Batiment_DAO;
import org.gstfac.gestionfactulte.modele.DAO.JDBC_Connexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Batiment_DAO_JDBC implements Batiment_DAO {
    private Connection conn;

    public  Batiment_DAO_JDBC(){
        this.conn = JDBC_Connexion.getConnetion();
    }

    @Override
    public ArrayList<Batiment> findAll() {
        ArrayList<Batiment> batiments = new ArrayList<Batiment>();
        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from Batiments");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    @Override
    public Batiment findByID(int ID_Batiment) {
        return null;
    }

    @Override
    public void insert(Batiment batiment) {

    }

    @Override
    public void update(Batiment batiment) {

    }

    @Override
    public void deleteByID(int ID_Batiment) {

    }
}
