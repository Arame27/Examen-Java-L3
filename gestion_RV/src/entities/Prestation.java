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
public class Prestation extends Rdv{
    
    private String libelle;
    private Consultation consultation;

    public Prestation(String libelle, Consultation consultation, String date, String type, Patient patient) {
        super(date, patient);
        this.libelle = libelle;
        this.consultation = consultation;
        this.type="PRESTATION";
    }
    
    public Prestation(){
        this.type="PRESTATION";
    }

    public Prestation(String libelle, Consultation consultation, String date, int id, Patient patient) {
        super(date, id, patient);
        this.libelle = libelle;
        this.consultation = consultation;
        this.type="PRESTATION";
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Consultation getConsultation() {
        return consultation;
    }

    public void setConsultation(Consultation consultation) {
        this.consultation = consultation;
    }
    
    
    
}
