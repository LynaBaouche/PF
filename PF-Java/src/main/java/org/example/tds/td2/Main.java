package org.example.tds.td2;

// Main.java
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Matiere m1 = new Matiere("MAT1");
        Matiere m2 = new Matiere("MAT2");
        Matiere m3 = new Matiere("MAT3");

        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
        UE ue2 = new UE("UE2", Map.of(m3, 1));

        Annee a1 = new Annee(Set.of(ue1, ue2));

        Etudiant e1 = new Etudiant("39081", "Alice", "Merveille", a1);
        e1.noter(m1, 12.0);
        e1.noter(m2, 14.0);
        System.out.println(e1);

        Etudiant e2 = new Etudiant("39082", "Bob", "Eponge", a1);
        e2.noter(m1, 10.0);
        e2.noter(m2, 9.0);

        Etudiant e3 = new Etudiant("39083", "Charles", "Chaplin", a1);
        e3.noter(m2, 15.0);
        e3.noter(m3, 18.0);

        System.out.println(a1.getEtudiants());
        System.out.println(e1.getNotes());
    }
}

