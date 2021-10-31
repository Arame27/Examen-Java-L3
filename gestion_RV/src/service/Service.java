/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RdvDao;
import dao.UserDao;
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
    
    @Override
    public User setConnection(String login, String password) {
        
        return udao.findByLoginAndPassword(login, password);
    }

    @Override
    public List<Rdv> rdvByPatient(int id) {
        return rdao.findAllByPatient(id);
    }
    
}
