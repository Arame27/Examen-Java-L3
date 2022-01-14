/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.RdvDto;
import entities.Patient;
import entities.Medecin;
import entities.Ordonnance;
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
public class RdvDao implements IDao<RdvDto>{

    private final DataBase database= new DataBase();
    private final PatientDao pdao= new PatientDao();
    private final MedecinDao mdao= new MedecinDao();
    private final OrdonnanceDao Odao= new OrdonnanceDao();
    private final String SQL_ALL_BY_PATIENT="SELECT * FROM rdv WHERE id_patient= ?";
    private final String SQL_ALL_BY_TYPE="select * from rdv where type like ?";
    private final String SQL_SELECT_ALL = "select * from rdv";
    private final String SQL_ALL_BY_DATE = "Select * from rdv where date like ?";
    private final String SQL_ALL_BY_DATE_AND_MEDECIN = "Select * from rdv where date like ? and id_medecin like ?";
    private final String SQL_ALL_BY_DATE_AND_PATIENT = "Select * from rdv where date like ? and id_patient like ?";
    private final String SQL_INSERT = "INSERT INTO rdv  ( type, date, id_patient, id_medecin, id_ordonnance,libelle) VALUES ( ?, ?, ? , ?, ?, ?)";
    private final String SQL_DELETE = "delete * from rdv where id = ?";
    private final String SQL_UPDATE="UPDATE rdv SET id_medecin = ? WHERE id = ?";
    private final String SQL_UPDATE_BY_ORDONNANCE="UPDATE rdv SET id_ordonnance = ? WHERE id = ?";
    
    
    @Override
    public int insert(RdvDto rdv) {
        int id = 0;
        database.openConnection();
        database.closeConnection();
        try {
            database.getPs().setString(1,rdv.getType());
            database.getPs().setString(2, rdv.getDate());
            database.getPs().setInt(3,rdv.getPatient().getId());
            database.getPs().setInt(4, rdv.getMedecin().getId());
            database.getPs().setInt(5, rdv.getOrdonnance().getId());
            database.getPs().setString(6, rdv.getLibelle());
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
    public int update(RdvDto rdv) {
        int nbrLigne=0;
        database.openConnection();
        database.initPreparedStatement(SQL_UPDATE);
        try {
            database.getPs().setInt(1, rdv.getMedecin().getId());
            database.getPs().setInt(2, rdv.getId());
            nbrLigne=database.executeUpdate(SQL_UPDATE);         
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return nbrLigne;
    }

    @Override
    public int delete(int id) {
        int nbreligne = 0;
        database.openConnection();
        database.initPreparedStatement(SQL_DELETE);
        try {
            database.getPs().setInt(1, id);
            nbreligne = database.executeUpdate(SQL_DELETE);
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        database.closeConnection();
        return nbreligne;
    }

    @Override
    public List<RdvDto> findAll() {
        List<RdvDto> rdvs = new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_SELECT_ALL);
        try {
            ResultSet rs = database.executeSelect(SQL_SELECT_ALL);
            while(rs.next()){
                RdvDto rdv = new RdvDto();
                rdv.setId(rs.getInt("id"));
                rdv.setDate(rs.getString("date"));
                if(rs.getString("type").equals("PRESTATION")){
                    rdv.setLibelle(rs.getString("libelle"));
                }
                if(rs.getInt("id_patient")!=0){
                    Patient patient= pdao.findById(rs.getInt("id_patient"));
                    rdv.setPatient(patient);
                }
                if(rs.getInt("id_medecin")!=0){
                    Medecin med= mdao.findById(rs.getInt("id_medecin"));
                    rdv.setMedecin(med);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
{
        
        
    }
        
        database.closeConnection();
        return rdvs;
    }

    @Override
    public RdvDto findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<RdvDto> findAllByPatient(int id){
        List<RdvDto> rdvs=new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_PATIENT);
        try {
            database.getPs().setInt(1, id);
            ResultSet rs= database.executeSelect(SQL_ALL_BY_PATIENT);
            while(rs.next()){
                RdvDto rdv=new RdvDto(rs.getString("date"),rs.getInt("id"), rs.getString("type"));
                if(rs.getString("type").equals("PRESTATION")){
                    rdv.setLibelle(rs.getString("libelle"));
                }
                if(rs.getInt("id_patient")!=0){
                    Patient patient= pdao.findById(rs.getInt("id_patient"));
                    rdv.setPatient(patient);
                }
                if(rs.getInt("id_medecin")!=0){
                    Medecin med= mdao.findById(rs.getInt("id_medecin"));
                    rdv.setMedecin(med);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return rdvs;
    }
    
    public List<RdvDto> findAllByType(String type){
        List<RdvDto> rdvs=new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_TYPE);
        try {
            database.getPs().setString(1, type);
            ResultSet rs= database.executeSelect(SQL_ALL_BY_TYPE);
            while(rs.next()){
                RdvDto rdv=new RdvDto(rs.getString("date"),rs.getInt("id"), rs.getString("type"));
                if(type.equals("PRESTATION")){
                    rdv.setLibelle(rs.getString("libelle"));
                }
                if(rs.getInt("id_patient")!=0){
                    Patient patient= pdao.findById(rs.getInt("id_patient"));
                    rdv.setPatient(patient);
                }
                if(rs.getInt("id_medecin")!=0){
                    Medecin med= mdao.findById(rs.getInt("id_medecin"));
                    rdv.setMedecin(med);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return rdvs;
    }
    
    
    public List<RdvDto> filtrerParDate(String date){
        List<RdvDto> rdvs = new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_DATE);
        try {
            database.getPs().setString(1, date);
            ResultSet rs = database.executeSelect(SQL_ALL_BY_DATE);
            while(rs.next()){
                RdvDto rdv = new RdvDto(rs.getString("date"),rs.getInt("id"),rs.getString("type"));
                if(rs.getString("type").equals("PRESTATION")){
                    rdv.setLibelle(rs.getString("libelle"));
                }
                if(rs.getInt("id_patient")!=0){
                    Patient patient = pdao.findById(rs.getInt("id_patient"));
                    rdv.setPatient(patient);
                }
                if(rs.getInt("id_medecin")!=0){
                    Medecin med = mdao.findById(rs.getInt("id_medecin"));
                    rdv.setMedecin(med);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return rdvs;
    }    
    
    public List<RdvDto> filtrerParDateEtMedecin(String date,Medecin medecin){
        List<RdvDto> rdvs = new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_DATE_AND_MEDECIN);
        try {
            database.getPs().setString(1, date);
            database.getPs().setInt(2, medecin.getId());
            ResultSet rs = database.executeSelect(SQL_ALL_BY_DATE_AND_MEDECIN);
            while(rs.next()){
                RdvDto rdv = new RdvDto(rs.getString("date"),rs.getInt("id"),rs.getString("type"));
                if(rs.getInt("id_patient")!=0){
                    Patient patient = pdao.findById(rs.getInt("id_patient"));
                    rdv.setPatient(patient);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        database.closeConnection();
        return rdvs;
    }
        
    public List<RdvDto> filtrerParDateEtPatient(String date,Patient patient){
        List<RdvDto> rdvs = new ArrayList();
        database.openConnection();
        database.initPreparedStatement(SQL_ALL_BY_DATE_AND_PATIENT);
        try {
            database.getPs().setString(1, date);
            database.getPs().setInt(2, patient.getId());
            ResultSet rs = database.executeSelect(SQL_ALL_BY_DATE_AND_PATIENT);
            while(rs.next()){
                RdvDto rdv = new RdvDto(rs.getString("date"),rs.getInt("id"),rs.getString("type"));
                if(rs.getInt("id_medecin")!=0){
                    Medecin med = mdao.findById(rs.getInt("id_medecin"));
                    rdv.setMedecin(med);
                }
                if(rs.getInt("id_ordonnance")!=0){
                    Ordonnance ordonnance = Odao.findById(rs.getInt("id_ordonnance"));
                    rdv.setOrdonnance(ordonnance);
                }
                rdvs.add(rdv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        database.closeConnection();
        return rdvs;
    }
    
    public int updateOrdonnance(RdvDto rdv) {
        int nbrLigne=0;
        database.openConnection();
        database.initPreparedStatement(SQL_UPDATE_BY_ORDONNANCE);
        try {
            database.getPs().setInt(1, rdv.getOrdonnance().getId());
            database.getPs().setInt(2, rdv.getId());
            nbrLigne=database.executeUpdate(SQL_UPDATE_BY_ORDONNANCE);         
        } catch (SQLException ex) {
            Logger.getLogger(RdvDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        database.closeConnection();
        return nbrLigne;
    }
    
}
