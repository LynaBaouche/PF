package org.example.cours4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class EnCours {

    //TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

    public interface Calculateur extends Function<String, Integer> {

    }
    static Function <String, Integer> scoreFunction =
            word -> word.replaceAll("a", "").length();

    /*public static int score(String word) {
            return word.replaceAll("a", "").length();
    }*/
    /*static int scoreWithBonus(String word) {
        int base = score(word);
        return (word.contains("c")) ? base + 5 : base;
    }*/


    static List<String> rankedWords(Comparator<String> comp, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(comp);
        return rankedWords;
    }


    static Comparator<String> genComparator(Function<String, Integer> scoring) {
        return (o1, o2) -> Integer.compare(scoring.apply(o2), scoring.apply(o1));
    }

    static Calculateur score = word -> word.replaceAll("a", "").length();
    static Calculateur bonus = word ->word.contains("c") ? 5 : 0;
    static Calculateur penalty = word -> word.contains("s") ? 7 : 0;
    /*static int penalty(String word) {
        return word.contains("s") ? 7 : 0;
    } on peut aussi utiliser les méthodes*/
    static Calculateur wordScore(Calculateur base, Calculateur bonus, Calculateur penalty) {
        return word -> base.apply(word) + bonus.apply(word) - penalty.apply(word);
    }

    static List<String> rankedWords(Function<String, Integer> scoring, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(genComparator(scoring));
        return rankedWords;
    }
    static List<String> rankedWords2(Comparator<String> comp, List<String> words) {
        List<String> rankedWords = new ArrayList<>(words);
        rankedWords.sort(comp);
        return rankedWords;
    }



    public static void main(String[] args) {
        List<String> words = Arrays.asList("ada", "haskell", "scala", "java", "rust");

        //System.out.println(rankedWords(genComparator(scoreWithBonusFunction), words));
        //System.out.println(rankedWords(genComparator(w -> scoreWithBonus(w)), words));
        System.out.println(rankedWords(genComparator(wordScore(score, bonus, penalty)), words));
        //System.out.println(rankedWords(genComparator(Classe::scoreWithBonus), words));
        System.out.println(rankedWords2(genComparator(wordScore(score, bonus, penalty)), words));



    }
    }

