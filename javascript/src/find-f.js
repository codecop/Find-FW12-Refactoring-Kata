const { Helper } = require('./helper.js');
const { F } = require('./f.js');

class FindF {
    constructor(fn) {
        this.helper = new Helper();
        this.fn = fn;
    }

    find(ot) {
        const data = this.helper.l(this.fn);
        const fData = this.p(data);
        const f = this.helper.find(fData, ot);
        return f.r();
    }

    p(data) {
        return this.helper.p(data, this.startsWithRank, this.newF);
    }

    startsWithRank(s) {
        return /^\s*\d+\.\s.*/u.test(s);
    }

    newF(c) {
        const cTeam = 1;
        const cF = 6;
        const cA = 8;

        const team = c[cTeam];
        const f = parseInt(c[cF], 10);
        const a = parseInt(c[cA], 10);

        return new F(team, f, a);
    }
}

module.exports = { FindF };
