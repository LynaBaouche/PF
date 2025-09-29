package org.example.cours2;
import java.util.ArrayList;
import java.util.List;
public class Main
{
    static List<String> replan(List<String> plan,
                              String newCity,
                              String beforeCity) {
    int newCityIndex = plan.indexOf(beforeCity);
    plan.add(newCityIndex, newCity);
    return plan;

}
    static List<String> replan2(List<String> plan,
                               String newCity,
                               String beforeCity) {
        int newCityIndex = plan.indexOf(beforeCity);
        List<String> replanned = new ArrayList<>(plan);
        replanned.add(newCityIndex, newCity);
        return replanned;
// on crée une nouvelle liste (copie) pour éviter de modifier la liste d'origine( éviter Mutability)
    }
    public static void main(String[] args) {
        List<String> planA = new ArrayList<>();
        planA.add("Paris");
        planA.add("Berlin");
        planA.add("Kraków");
        System.out.println("Plan A: " + planA);
        List<String> planB = replan(planA, "Vienna", "Kraków");
        System.out.println("Plan B: " + planB);
        System.out.println("Plan A: " + planA);
        // Plan A: [Paris, Berlin, Vienna, Kraków], car on modifie plan qui est en mémoire donc
        // toute modification affecte toutes les références sur plan impactera de même plan

    }
}
