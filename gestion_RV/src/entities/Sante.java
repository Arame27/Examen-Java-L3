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
public class Sante {
    
    private Patient patient;
    private Antecedent antecedent;

    public Sante() {
    }

    public Sante(Patient patient, Antecedent antecedent) {
        this.patient = patient;
        this.antecedent = antecedent;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Antecedent getAntecedent() {
        return antecedent;
    }

    public void setAntecedent(Antecedent antecedent) {
        this.antecedent = antecedent;
    }
    
    
}
