/** Palindrome class.
 * @author zyf. */
public class Palindrome {

    /** convert string to deque.
     * @param word the string that need to be converted.
     * @return the converted deque. */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new ArrayDeque<Character>();
        for (int i = 0; i < word.length(); ++i) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    /** helper function of isPalindrome, return true if it is.
     * @param d a Deque type. */
    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() <= 1) {
            return true;
        }
        if (d.removeFirst() != d.removeLast()) {
            return false;
        }
        return isPalindrome(d);
    }

    /** check whether a string is palindrome, return true if it is.
     * @param word the string that need to be checked. */
    public boolean isPalindrome(String word) {
        Deque<Character> res = wordToDeque(word);
        return isPalindrome(res);
    }


    /** find if a deque d is palindrome or not.
     *
     * @param d deque
     * @param cc charcomp, see *.java
     * @return true or false
     */
    private boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() <= 1) {
            return true;
        }
        if (!cc.equalChars(d.removeFirst(), d.removeLast())) {
            return false;
        }
        return isPalindrome(d, cc);
    }

    /** find if a string word is palindrome or not.
     *
     * @param word string
     * @param cc charcomp, see *.java
     * @return true or false
     */
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> res = wordToDeque(word);
        return isPalindrome(res, cc);
    }
}
