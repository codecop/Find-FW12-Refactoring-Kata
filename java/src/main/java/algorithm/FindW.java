package algorithm;

import java.io.IOException;
import java.util.List;

public class FindW {

    private final Helper helper = new Helper();
    private final String fn;

    public FindW(String fn) {
        this.fn = fn;
    }

    public String find(OneTwo ot) throws IOException {
        List<String> data = helper.l(fn);
        List<W> wData = p(data);
        W w = helper.find(wData, ot);
        return w.r();
    }

    private List<W> p(List<String> data) {
        return helper.p(data, //
                this::startsWithDayOfMonth, //
                this::newW);
    }

    private boolean startsWithDayOfMonth(String s) {
        return s.matches("\\s*\\d+\\s.*");
    }

    private W newW(String[] c) {
        int cDy = 0;
        int cMxt = 1;
        int cMnT = 2;

        int dy = Integer.parseInt(c[cDy]);
        int mxT = Integer.parseInt(substring(c[cMxt], "*"));
        int mnT = Integer.parseInt(substring(c[cMnT], "*"));

        return new W(dy, mxT, mnT);
    }

    private String substring(String s1, String s2) {
        if (s1.endsWith(s2)) {
            int b = s1.length() - s2.length();
            return s1.substring(0, b);
        }
        return s1;
    }

}
