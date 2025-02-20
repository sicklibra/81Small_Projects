package BlackJack;
import org.javatuples.Pair;
public interface Deck {
    public char[] suits=new char[4];
    public int[] cards=new int[14];
    public Pair<Integer, Character>[] deck=new Pair[52];

    public void shuffle();
    public Pair<Integer, Character> deal(int numdelt);
}
