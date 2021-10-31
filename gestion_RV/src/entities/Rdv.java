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
public class Rdv {
    
    protected String date;
    protected int id;
    protected String type;
    protected Patient patient;

    public Rdv() {
    }

    public Rdv(String date, Patient patient) {
        this.date = date;
        this.patient = patient;
    }
    
    public Rdv(String date, int id, String type) {
        this.date = date;
        this.type = type;
        this.id = id;
    }

    public Rdv(String date, int id, Patient patient) {
        this.date = date;
        this.id = id;
        this.patient = patient;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    
    
    
    
}
