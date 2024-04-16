package com.epam.rd.autotasks.words;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if(words == null || sample==null) return 0;
        if(sample.isEmpty() || words.length == 0 || sample.isBlank()) return 0;

        sample = sample.replaceAll("\\s", "").toLowerCase();
        int countWords = 0;

        String pattern = "\\s*" + sample + "\\s*";
        for (String word: words) {
            if(word.toLowerCase().matches(pattern)) countWords++;
        }
        return countWords;
    }

    public static String[] splitWords(String text) {
        if(text == null || text.isEmpty()) return null;
        Pattern pattern = Pattern.compile("[ ,.;:?!]+");
        Matcher matcher = pattern.matcher(text);
        text = matcher.replaceAll(" ").trim();
        String[] words = pattern.split(text);
        if(words == null || words.length == 0 || words[0].isBlank() || words[0].isEmpty()) return null;
        return words;
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.isBlank()) return null;
        String windowsPattern = "^([C][:])?(\\\\?[a-zA-Z0-9_ (.){0,2}]+)*\\\\?$";
        String unixPattern = "^[~]?(/?[a-zA-Z0-9_ (.){0,2}]+)*/?$";
        String filePattern = "^[a-zA-Z0-9]+\\.[a-zA-Z]+$";

        if(Pattern.matches(filePattern, path)) return path;
//        Pattern winPattern = Pattern.compile(windowsPattern);
//        Pattern unixPattern = Pattern.compile(unixStringPattern);

        if(toWin){
            if(Pattern.matches(windowsPattern, path)) return path;
            if(Pattern.matches(unixPattern, path)){
                if(path.equals("~")) return "C:\\User";
                if(path.equals("~/")) return "C:\\User\\";
                path = path.replaceAll("~", "C:\\\\User");
                path = path.replaceAll("/", "\\\\");

                if(path.startsWith("\\")) path = "C:" + path;
                return path;
            } else {
                return null;
            }
        } else {
            if(Pattern.matches(unixPattern, path)) return path;
            if(Pattern.matches(windowsPattern, path)){
                if(path.equals("C:\\\\User")) return "~";
                if(path.equals("C:\\\\User\\\\")) return "~/";
                if(path.equals("C:\\")) return "/";
                path = path.replaceAll( "C:\\\\User","~");
                path = path.replaceAll( "C:","");
                path = path.replaceAll("\\\\", "/");
                return path;
            } else {
                return null;
            }
        }
    }

    public static String joinWords(String[] words) {
        if(words == null || words.length == 0) return null;
        StringBuilder stringBuilder = new StringBuilder("[");
        for (String word: words) {
            if(!word.isEmpty() && !word.isBlank()) stringBuilder.append(word).append(", ");
        }
        if(stringBuilder.length() > 2) stringBuilder.setLength(stringBuilder.length()-2);
        String wordToReturn = stringBuilder + "]";
        return wordToReturn.equals("[]") ? null : wordToReturn;
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}