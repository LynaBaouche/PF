package org.example.cours4;

import java.util.function.Function;

public class Classe {
    private int base;
    public Classe(int base) { this.base = base; }
    // méthode d'intance
    public int m1(String w) { return w.length() + base; }
    // méthode de classe
    static int m2(String w) { return w.length(); }
    // fonction
    static Function<String, Integer> m3 = w -> w.length();
    static Function<Function<String, Integer>, Function<String, String>> work =
            f -> w -> String.format("%s", f.apply(w));
}