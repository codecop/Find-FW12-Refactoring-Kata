package algorithm;

public class F implements Data {

    public final String team;
    public final int f;
    public final int a;

    public F(String team, int f, int a) {
        this.team = team;
        this.f = f;
        this.a = a;
    }

    @Override
    public String r() {
        return team;
    }

    @Override
    public int sort() {
        return Math.abs(f - a);
    }
}
