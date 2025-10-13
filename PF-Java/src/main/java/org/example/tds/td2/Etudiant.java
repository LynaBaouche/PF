package org.example.tds.td2;

import java.util.HashMap;
import java.util.Map;

public class Etudiant {
        private String numero;
        private String prenom;
        private String nom;
        private Annee annee;
        private Map<Matiere, Double> notes;

        public Etudiant(String numero, String prenom, String nom, Annee annee) {
            this.numero = numero;
            this.prenom = prenom;
            this.nom = nom;
            this.annee = annee;
            this.notes = new HashMap<>();
            annee.inscrire(this);
        }

        public void noter(Matiere matiere, double note) {
            notes.put(matiere, note);
        }

        public Map<Matiere, Double> getNotes() { return notes; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Etudiant)) return false;
            Etudiant e = (Etudiant) o;
            return numero.equals(e.numero);
        }

        @Override
        public int hashCode() { return numero.hashCode(); }

        @Override
        public String toString() {
            return prenom + " " + nom + " (" + numero + ")";
        }
    }


