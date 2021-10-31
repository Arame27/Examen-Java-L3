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
public class Consultation extends Rdv{
    
    private Medecin medecin;
    private Ordonnance ordonnance;

    public Consultation() {
        this.type="CONSULTATION";
    }

    public Consultation(Medecin medecin, Ordonnance ordonnance, String date, Patient patient) {
        super(date, patient);
        this.type="CONSULTATION";
        this.medecin = medecin;
        this.ordonnance = ordonnance;
    }

    public Consultation(Medecin medecin, Ordonnance ordonnance, String date, int id, Patient patient) {
        super(date, id, patient);
        this.medecin = medecin;
        this.ordonnance = ordonnance;
        this.type="CONSULTATION";
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Ordonnance getOrdonnance() {
        return ordonnance;
    }

    public void setOrdonnance(Ordonnance ordonnance) {
        this.ordonnance = ordonnance;
    }
    
    
    
}
