package algorithm;

import java.io.IOException;
import java.util.List;

public class FindF {

    private final Helper helper = new Helper();
    private final String fn;

    public FindF(String fn) {
        this.fn = fn;
    }

    public String find(OneTwo ot) throws IOException {
        List<String> data = helper.l(fn);
        List<F> fData = p(data);
        F r = helper.find(fData, ot);
        return r.i();
    }

    List<F> p(List<String> data) {
        return helper.p(data, //
                this::startsWithRank, //
                this::newF);
    }

    private boolean startsWithRank(String s) {
        return s.matches("\\s*\\d+\\.\\s.*");
    }

    private F newF(String[] c) {
        int cTeam = 1;
        int cF = 6;
        int cA = 8;

        String team = c[cTeam];
        int f = Integer.parseInt(c[cF]);
        int a = Integer.parseInt(c[cA]);

        return new F(team, f, a);
    }

}
