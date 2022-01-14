/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

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
public interface IService {
    
    
    public User setConnection(String login,String password);
    public List<RdvDto> rdvByPatient(int id);
    public List<RdvDto> rdvByType(String type);
    public Medecin findById(int id);
    public List<RdvDto> filtrerParDate(String date);
    public void deconnexion(User user);
    public int deletePrestation(int id);
    public int DemandeRdvByPatient(RdvDto rdv);
    //Mettre à jour Rdv en ajoutant medecin
    public int ConfirmerRdvBySecretaire(RdvDto rdv);
    public int AffecterOrdonnanceToRdv(RdvDto rdv);
    
}
