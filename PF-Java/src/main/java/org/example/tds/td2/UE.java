package org.example.tds.td2;

import java.util.HashMap;
import java.util.Map;

public class UE {
        private String nom;
        private Map<Matiere, Integer> ects;

        public UE(String nom, Map<Matiere, Integer> ects) {
            this.nom = nom;
            this.ects = new HashMap<>(ects);
        }

        public String getNom() { return nom; }
        public Map<Matiere, Integer> getEcts() { return ects; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof UE)) return false;
            UE ue = (UE) o;
            return nom.equals(ue.nom);
        }

        @Override
        public int hashCode() { return nom.hashCode(); }

        @Override
        public String toString() { return nom; }
    }


