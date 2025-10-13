package org.example.tds.td2;
import java.util.Map;

// Matiere.java
public class Matiere {
    private String nom;

    public Matiere(String nom) { this.nom = nom; }
    public String getNom() { return nom; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matiere)) return false;
        Matiere m = (Matiere) o;
        return nom.equals(m.nom);
    }

    @Override
    public int hashCode() { return nom.hashCode(); }

    @Override
    public String toString() { return nom; }
}

