class W {

    constructor(dy, mxT, mnT) {
        this.dy = dy;
        this.mxT = mxT;
        this.mnT = mnT;
    }

    r() {
        return "" + this.dy;
    }

    sort() {
        return this.mxT - this.mnT;
    }
}

module.exports = {
    W
};
