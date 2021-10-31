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
public class Ordonnance {
    
    private int id;
    private String posologie;

    public Ordonnance() {
    }

    public Ordonnance(String posologie) {
        this.posologie = posologie;
    }

    public Ordonnance(int id, String posologie) {
        this.id = id;
        this.posologie = posologie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosologie() {
        return posologie;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }
    
    
    
}
