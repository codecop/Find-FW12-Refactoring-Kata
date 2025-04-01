const { Helper } = require('./helper.js');
const { W } = require('./w.js');

class FindW {
    constructor(fn) {
        this.helper = new Helper();
        this.fn = fn;
    }

    find(ot) {
        const data = this.helper.l(this.fn);
        const wData = this.p(data);
        const w = this.helper.find(wData, ot);
        return w.r();
    }

    p(data) {
        return this.helper.p(data, this.startsWithDayOfMonth, this.newW);
    }

    startsWithDayOfMonth(s) {
        return /^\s*\d+\s.*/u.test(s);
    }

    newW(c) {
        const cDy = 0;
        const cMxt = 1;
        const cMnT = 2;

        const dy = parseInt(c[cDy], 10);
        const mxT = parseInt(this.substring(c[cMxt], "*"), 10);
        const mnT = parseInt(this.substring(c[cMnT], "*"), 10);

        return new W(dy, mxT, mnT);
    }

    substring(s1, s2) {
        return s1.endsWith(s2) ? s1.slice(0, -s2.length) : s1;
    }
}

module.exports = { FindW };
