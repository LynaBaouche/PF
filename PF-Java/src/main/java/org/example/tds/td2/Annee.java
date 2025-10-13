package org.example.tds.td2;

import java.util.HashSet;
import java.util.Set;
    public class Annee {
        private Set<UE> ues;
        private Set<Etudiant> etudiants;

        public Annee(Set<UE> ues) {
            this.ues = ues;
            this.etudiants = new HashSet<>();
        }

        public Set<UE> getUes() { return ues; }
        public Set<Etudiant> getEtudiants() { return etudiants; }

        public void inscrire(Etudiant e) {
            etudiants.add(e);
        }

        @Override
        public String toString() {
            return "Annee{" + "ues=" + ues + ", etudiants=" + etudiants + '}';
        }
    }


