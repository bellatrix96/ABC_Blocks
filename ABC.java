/* ABC Problem - You are given a collection of ABC blocks,There are twenty blocks with two letters on each block.
A complete alphabet is guaranteed amongst all sides of the blocks.
The sample collection of blocks:
 (B O) (X K) (D Q) (C P) (N A) (G T) (R E) (T G) (Q D) (F S) (J W) (H U) (V I) (A N) (O B) (E R) (F S) (L Y) (P C) (Z M)
Task
Write a function that takes a string (word) and determines whether the word can be spelled with the given collection of blocks.

The rules are simple:
  Once a letter on a block is used that block cannot be used again
  The function should be case-insensitive
  Show the output on this page for the following 7 words in the following example 
Example
    >>> can_make_word("A")
    True
    >>> can_make_word("BARK")
    True
    >>> can_make_word("BOOK")
    False
    >>> can_make_word("TREAT")
    True
    >>> can_make_word("COMMON")
    False
    >>> can_make_word("SQUAD")
    True
    >>> can_make_word("CONFUSE")
    True
*/


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
 
public class ABC {
 
    public static void main(String[] args) {
        List<String> blocks = Arrays.asList(
                "BO", "XK", "DQ", "CP", "NA",
                "GT", "RE", "TG", "QD", "FS",
                "JW", "HU", "VI", "AN", "OB",
                "ER", "FS", "LY", "PC", "ZM");
 
        for (String word : Arrays.asList("", "A", "BARK", "BOOK", "TREAT", "COMMON", "SQUAD", "CONFUSE")) {
            System.out.printf("%s: %s%n", word.isEmpty() ? "\"\"" : word, canMakeWord(word, blocks));
        }
    }
 
    public static boolean canMakeWord(String word, List<String> blocks) {
        if (word.isEmpty())
            return true;
 
        char c = word.charAt(0);
        for (int i = 0; i < blocks.size(); i++) {
            String b = blocks.get(i);
            if (b.charAt(0) != c && b.charAt(1) != c)
                continue;
            Collections.swap(blocks, 0, i);
            if (canMakeWord(word.substring(1), blocks.subList(1, blocks.size())))
                return true;
            Collections.swap(blocks, 0, i);
        }
 
        return false;
    }
}