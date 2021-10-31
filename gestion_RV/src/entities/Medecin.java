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
public class Medecin extends User{
    
    private String statut;
    private String disponibilite;

    public Medecin() {
        this.role="ROLE_MEDECIN";
    }

    public Medecin(String statut, String disponibilite, String nom, String login, String password) {
        super(nom, login, password);
        this.statut = statut;
        this.role="ROLE_MEDECIN";
        this.disponibilite = disponibilite;
    }

    public Medecin(String statut, String disponibilite, String nom, String login, String password, int id) {
        super(nom, login, password, id);
        this.statut = statut;
        this.role="ROLE_MEDECIN";
        this.disponibilite = disponibilite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }
    
    
    
}
