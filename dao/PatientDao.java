/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Patient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author armem
 */
public class PatientDao implements IDao<Patient>{
    
    private final DataBase database = new DataBase();
    private final String SQL_SELECT_BY_ID = "select * from user where role like ROLE_PATIENT and id = ?";

    @Override
    public int insert(Patient t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Patient t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Patient> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Patient findById(int id) {
        Patient patient = null;
        database.openConnection();
        database.initPreparedStatement(SQL_SELECT_BY_ID);
        try {
            database.getPs().setInt(1,id);
            ResultSet rs = database.executeSelect(SQL_SELECT_BY_ID);
            if(rs.next()){
                patient = new Patient(rs.getString("code"));
                patient.setId(id);
                patient.setNom(rs.getString("nomComplet"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PatientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnection();
        return patient;
    }
    
    
    
}
