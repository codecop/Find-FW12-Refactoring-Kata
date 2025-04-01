package algorithm;

public class W implements Data {

    public final int dy;
    public final int mxT;
    public final int mnT;

    public W(int dy, int mxT, int mnT) {
        this.dy = dy;
        this.mxT = mxT;
        this.mnT = mnT;
    }

    @Override
    public String r() {
        return Integer.toString(dy);
    }

    @Override
    public int sort() {
        return mxT - mnT;
    }

}
