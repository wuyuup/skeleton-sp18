/** This is the OffByN class.
 * @author zyf
 */
public class OffByN implements CharacterComparator {
    /** off by n. */
    private int n;

    /** Constructor of this class.
     *
     * @param N integer to give n
     */
    public OffByN(int N) {
        this.n = N;
    }

    @Override
    public boolean equalChars(char x, char y) {
        return Math.abs(x - y) == this.n;
    }
}
