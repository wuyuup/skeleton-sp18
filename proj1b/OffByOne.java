/** OffByOne class.
 * @author zyf. */
public class OffByOne implements CharacterComparator {

    /** test if two chars are equal.
     *
     * @param x char type.
     * @param y char type.
     * @return true if x == y.
     */
    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == 1;
    }
}
