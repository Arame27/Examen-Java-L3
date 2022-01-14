/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MedecinDao;
import dao.RdvDao;
import dao.UserDao;
import dto.RdvDto;
import entities.Medecin;
import entities.Ordonnance;
import entities.Rdv;
import entities.User;
import java.util.List;

/**
 *
 * @author armem
 */
public class Service implements IService {

    private final UserDao udao = new UserDao();
    private final RdvDao rdao= new RdvDao();
    private final MedecinDao mdao = new MedecinDao();
    
    @Override
    public User setConnection(String login, String password) {
        
        return udao.findByLoginAndPassword(login, password);
    }

    @Override
    public List<RdvDto> rdvByPatient(int id) {
        return rdao.findAllByPatient(id);
    }

    @Override
    public List<RdvDto> rdvByType(String type) {
        return rdao.findAllByType(type);
    }

    @Override
    public Medecin findById(int id) {
        return mdao.findById(id);
    }

    @Override
    public List<RdvDto> filtrerParDate(String date) {
        return rdao.filtrerParDate(date);
    }

    @Override
    public void deconnexion(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deletePrestation(int id) {
        return rdao.delete(id);
    }

    @Override
    public int DemandeRdvByPatient(RdvDto rdv) {
        return rdao.insert(rdv);
    }

    @Override
    public int ConfirmerRdvBySecretaire(RdvDto rdv) {
        return rdao.update(rdv);
    }

    @Override
    public int AffecterOrdonnanceToRdv(RdvDto rdv) {
        return rdao.updateOrdonnance(rdv);
    }
    
}
