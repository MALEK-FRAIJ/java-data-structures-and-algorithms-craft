package com.DataStructure;

/**
 * Main
 */
public class Main {

    public int length(String s) {
        int i = 0;
        while (s.charAt(i) != '\0') {
            i++;
        }
        return i;
    }

    public boolean isEmpty(String s) {
        return length(s) == 0;
    }

    public String toUpperCase(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 96 && c < 123) {
                str += (char) (c - 32);
            } else {
                str += c;
            }
        }
        return str;
    }

    public String toLoweCase(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 64 && c < 91) {
                str += (char) (c + 32);
            } else {
                str += c;
            }
        }
        return str;

    }

    public int CountVowels(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                    || c == 'U') {
                count++;
            }
        }
        return count;
    }

    public int CountConsonants(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'A' || c == 'e' || c == 'E' || c == 'i' || c == 'I' || c == 'o' || c == 'O' || c == 'u'
                    || c == 'U') {
                continue;
            } else if ((c > 64 && c < 91) || (c > 96 && c < 123)) {
                count++;
            }

        }
        return count;
    }

    public int countWorld(String s) {
        int word = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && s.charAt(i - 1) != ' ') {
                word++;
            }
        }
        return word + 1;
    }

    public String reverse(String s) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            str = s.charAt(i) + str;
        }
        return str;
    }

    public int compareString(String s1, String s2) {
        int i = 0, j = 0;
        while (i < s1.length() - 1 && j < s2.length() - 1) {
            if (s1.charAt(i) != s2.charAt(j)) {
                break;
            }
            i++;
            j++;
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            return 0;
        } else if (s1.charAt(i) > s2.charAt(j)) {
            return 1;
        } else {
            return -1;
        }
    }

    public int validating(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!((c > 64 && c < 91) || (c > 96 && c < 123) || (c > 47 && c < 59))) {
                return 0;
            }
        }
        return 1;
    }

    public boolean isPalindrome(String s1, String s2) {
        s2 = reverse(s2);
        if (compareString(s1, s2) == 0) {
            return true;
        }
        return false;
    }

    public void duplicated(String s) {

    }

    public boolean checkAnagramWords(String s1, String s2) {
        int[] a = new int[25];

        for (int i = 0; i < s1.length(); i++) {
            a[s1.charAt(i) - 97]++;
            a[s2.charAt(i) - 97]--;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        String s = "care";
        /*
         * System.out.println("The Length is: " + main.length(s));
         * System.out.println("Is Empty: " + main.isEmpty(s));
         */
        System.out.println("to LowerCase is: " + main.toLoweCase(s));
        System.out.println("to UpperCse is: " + main.toUpperCase(s));
        System.out.println("Count Vowels is: " + main.CountVowels(s));
        System.out.println("Count Consonants is: " + main.CountConsonants(s));
        System.out.println("Count word is: " + main.countWorld(s));
        /* System.out.println("trim statement  is: " + main.trim(s)); */
        System.out.println("Reverse Statement is: " + main.reverse(s));
        System.out.println("Compare Two String is: " + main.compareString(s, "race"));
        System.out.println("validating String is: " + main.validating("Malek12%412"));
        System.out.println("is Palindrome: " + main.isPalindrome(s, s));
        main.duplicated(s);
        System.out.println("check Anagram Word is: " + main.checkAnagramWords("verbose", "observe"));
    }

}