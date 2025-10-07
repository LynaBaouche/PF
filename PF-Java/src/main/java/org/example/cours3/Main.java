package org.example.cours3;
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

    static double totalTime(List <Double> laptimes){
        laptimes.remove(0);
        double sum =0;
        for(double x : laptimes){
            sum += x;
        }
        return sum;
    }
    static double avgTime(List<Double> laptimes){
        double time = totalTime(laptimes);
        int laps = laptimes.size();
        return time/laps;
    }
    //Exo Livre page 94
    public static String abbreviate(String name) {
        String initial = name.substring(0, 1);
        int separator = name.indexOf(' ');
        String lastName = name.substring(separator + 1);
        return initial + ". " + lastName;
    }

    public static void main(String[] args) {
        List<String> planA = new ArrayList<>();
        planA.add("Paris");
        planA.add("Berlin");
        planA.add("Kraków");
        //System.out.println("Plan A: " + planA);
        List<String> planB = replan(planA, "Vienna", "Kraków");
        //System.out.println("Plan B: " + planB);
        //System.out.println("Plan A: " + planA);
        // Plan A: [Paris, Berlin, Vienna, Kraków], car on modifie plan qui est en mémoire donc
        // toute modification affecte toutes les références sur plan impactera de même plan
        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(31.0); // warm-up lap (not taken into calculations)
        lapTimes.add(20.9);
        lapTimes.add(21.1);
        lapTimes.add(21.3);
        System.out.printf("Total: %.1fs\n", totalTime(lapTimes));
        System.out.printf("Avg: %.1fs", avgTime(lapTimes));
        System.out.println(abbreviate("Jean Dupont"));
        System.out.println(abbreviate("Claire Dupont"));
        System.out.println(abbreviate("Alex Charles"));

    }
}
