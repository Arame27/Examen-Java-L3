/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Rdv;
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
public class RdvDao implements IDao<Rdv>{

    private final DataBase database= new DataBase();
    private final String SQL_ALL_BY_PATIENT="SELECT * FROM rdv WHERE id_patient= ?";
    
    @Override
    public int insert(Rdv t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Rdv t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rdv> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rdv findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Rdv> findAllByPatient(int id){
        List<Rdv> rdvs=new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_PATIENT);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs= database.executeSelect(SQL_ALL_BY_PATIENT);
            while(rs.next()){
                Rdv rdv=new Rdv(rs.getString("date"),rs.getInt("id"), rs.getString("type"));
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return rdvs;
    }
    
}
