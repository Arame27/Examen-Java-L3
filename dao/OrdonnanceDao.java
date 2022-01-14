/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Ordonnance;
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
public class OrdonnanceDao implements IDao<Ordonnance>{
    
    private final DataBase database = new DataBase();
    private final String SQL_BY_ID = "select * from ordonnance where id = ?";
    private final String SQL_FIND_ALL_ORDONNANCE = "select * from ordonnance";
    private final ConsultationDao cdao= new ConsultationDao();
    private final String SQL_INSERT = "INSERT INTO ordonnance ( posologie) VALUES (?)";

    @Override
    public int insert(Ordonnance ordonnance) {
        int id = 0;
        database.openConnection();
        database.closeConnection();
        try {
            database.getPs().setString(1, "posologie");
            ResultSet rs = database.getPs().getGeneratedKeys();
            if(rs.next()){
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return id;
    }

    @Override
    public int update(Ordonnance t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Ordonnance> findAll() {
        List<Ordonnance> ords = new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_FIND_ALL_ORDONNANCE);
        try {
            ResultSet rs = database.executeSelect(SQL_FIND_ALL_ORDONNANCE);
            while(rs.next()){
                Ordonnance ordonnance = new Ordonnance(rs.getInt("id"),rs.getString("posologie"));
                ords.add(ordonnance);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnection();
        return ords;
    }

    @Override
    public Ordonnance findById(int id) {
        Ordonnance ordonnance = null;
        database.openConnection();
        database.initPreparedStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);
            if(rs.next()){
                ordonnance = new Ordonnance(rs.getString("posologie"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrdonnanceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnection();
        return ordonnance;
    }

    
    
}
