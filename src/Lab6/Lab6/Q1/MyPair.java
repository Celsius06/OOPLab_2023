package Lab6.Q1;

public class MyPair <T, U> {
    public final T Fst;
    public final U Snd;
    public MyPair(T fst, U snd) {
    this.Fst = fst;
    this.Snd = snd;
    }
    public String toString() {
    return "(" + Fst + ", " + Snd + ")";
    }

    public MyPair<U, T> Swap () {
        return new MyPair<U, T>(this.Snd, this.Fst);
    }
}