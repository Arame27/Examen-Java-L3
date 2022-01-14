/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Antecedent;
import entities.Constante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author armem
 */
public class ConstanteDao implements IDao<Constante> {
    
    private final DataBase database = new DataBase();
    private final String SQL_BY_ID = "Select * from constante where id like ?";

    @Override
    public int insert(Constante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Constante t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Constante> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Constante findById(int id) {
        Constante constante = null;
        database.openConnection();
        database.initPreparedStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);
            if(rs.next()){
                constante = new Constante(rs.getString("libelle"),rs.getString("valeur"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConstanteDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        database.closeConnection();
        return constante;
    }

    
    
}
