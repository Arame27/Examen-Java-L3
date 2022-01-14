/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author armem
 */
public class Patient extends User{
    
    private String code;

    public Patient() {
        this.role="ROLE_PATIENT";
    }

    public Patient(String code, String nom, String login, String password) {
        super(nom, login, password);
        this.role="ROLE_PATIENT";
        this.code = code;
    }

    public Patient(String code, String nom, String login, String password, int id) {
        super(nom, login, password, id);
        this.role="ROLE_PATIENT";
        this.code = code;
    }

    public Patient(String code) {
        this.code = code;
    }
    
    

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
