/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Medecin;
import entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author armem
 */
public class MedecinDao implements IDao<Medecin> {

    private final DataBase database= new DataBase();
    private final String SQL_BY_ID = "select * from user where role like ROLE_MEDECIN and  id = ?";
    private final String SQL_SELECT_ALL = "select * from user where role like ROLE_MEDECIN";
    
    @Override
    public int insert(Medecin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Medecin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medecin> findAll() {
        List<Medecin> meds=new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_SELECT_ALL);
        try {
            ResultSet rs= database.executeSelect(SQL_SELECT_ALL);
            while(rs.next()){
                Medecin med=new Medecin(rs.getString("statut"),rs.getString("disponibilite"));
                med.setId(rs.getInt("id"));
                med.setNom(rs.getString("nomComplet"));
                meds.add(med);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return meds;
    }

    @Override
    public Medecin findById(int id) {
        Medecin medecin = null;
        database.openConnection();
        database.initPreparedStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);
            if(rs.next()){
                medecin= new Medecin(rs.getString("statut"),rs.getString("disponibilite"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MedecinDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return medecin;
    }
    
    
    
}
