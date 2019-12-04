package edu.kovalyshyn.util;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static String concatAllParameters(List<? extends CharSequence> params) {
        StringBuilder result = new StringBuilder();
        for (CharSequence param : params) {
            String p = param.toString().replaceAll("\\s+", "");
            result.append(p);
        }
        return result.toString();
    }

    public static boolean checkSentence(String sentence) {
        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]*\\b(.$)");
        Matcher matcher = pattern.matcher(sentence);
        return matcher.matches();
    }

    public static String splitString(String text) {
        String[] splitted = text.split("\\bthe|you\\b");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : splitted) {
            stringBuilder.append(s);
        }
        return stringBuilder.toString().trim();
    }

    public static String replaceVowels(String text) {
        String vowels = "[aeiouy]";
        return text.toLowerCase().replaceAll(vowels, "_");
    }

    public static List<String> sortTextByWordCount(List<String> text) {
         text.sort(new SentenceComparator());
         return text;
    }

    static class SentenceComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            String[] word1 = o1.split(" ");
            String[] word2 = o2.split(" ");
            if (word1.length>word2.length){
                return 1;
            }else if (word1.length < word2.length){
                return -1;
            }
                return 0;
        }
    }
}
