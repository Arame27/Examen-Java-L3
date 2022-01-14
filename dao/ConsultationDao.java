/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Consultation;
import entities.Medecin;
import entities.Ordonnance;
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
public class ConsultationDao implements IDao<Consultation>{
    
    private final DataBase database = new DataBase();
    private final String SQL_BY_ID = "select * from rdv where type like 'CONSULTATION' and id = ?";
    private final PatientDao pdao= new PatientDao();
    private final MedecinDao mdao= new MedecinDao();
    private final OrdonnanceDao Odao= new OrdonnanceDao();
    
    @Override
    public int insert(Consultation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Consultation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Consultation> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Consultation findById(int id) {
        Consultation consultation = null;
        database.openConnection();
        database.initPreparedStatement(SQL_BY_ID);
        try {
            database.getPs().setInt(1,id);
            ResultSet rs = database.executeSelect(SQL_BY_ID);
            if(rs.next()){
                consultation = new Consultation();
                if(rs.getInt("id_medecin")!=0){
                    Medecin medecin = mdao.findById(rs.getInt("id_medecin"));
                    consultation.setMedecin(medecin);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    consultation.setOrdonnance(ordonnance);
                }
                 if(rs.getInt("id_patient")!=0){
                    Patient patient = pdao.findById(rs.getInt("id_patient"));
                    consultation.setPatient(patient);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsultationDao.class.getName()).log(Level.SEVERE, null, ex);
        }
      database.closeConnection();
      return consultation;
    }
    
}
