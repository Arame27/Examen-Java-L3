/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Antecedent;
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
public class AntecedentDao implements IDao<Antecedent> {
    
    private final DataBase database = new DataBase();
    private final String SQL_BY_ID = "Select * from antecedent where id = ?";
    private final String SQL_SELECT_ALL = "select * from anteccedent";

    @Override
    public int insert(Antecedent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Antecedent t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Antecedent> findAll() {
        List<Antecedent> ants=new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_SELECT_ALL);
        try {
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL);
            while(rs.next()){
                Antecedent ant=new Antecedent(rs.getInt("id"),rs.getString("libelle"));
                ants.add(ant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AntecedentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnection();
        return ants;
    }

    @Override
    public Antecedent findById(int id) {
        Antecedent antecedent = null;
        database.openConnection();
        database.initPreparedStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1,id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);
            if(rs.next()){
                antecedent = new Antecedent(rs.getInt("id"),rs.getString("libelle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AntecedentDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return antecedent;
    }
    

    
}
