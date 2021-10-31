/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entities.Rdv;
import entities.User;
import java.util.List;

/**
 *
 * @author armem
 */
public interface IService {
    
    
    public User setConnection(String login,String password);
    public List<Rdv> rdvByPatient(int id);
    
    
}
