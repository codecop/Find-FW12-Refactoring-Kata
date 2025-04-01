const fs = require('fs');
const path = require('path');
const { OneTwo } = require('./one-two.js');

class Helper {

    l(s) {
        const f = path.join(__dirname, s);
        return fs.readFileSync(f, 'utf-8').split('\n');
    }

    find(data, ot) {
        if (ot === OneTwo.ONE) {
            data.sort((a, b) => a.sort() - b.sort());
        } else if (ot === OneTwo.TWO) {
            data.sort((a, b) => b.sort() - a.sort());
        } else {
            throw new Error(`Invalid argument: ${ot}`);
        }
        return data[0];
    }

    p(data, pred, fun) {
        return data
            .filter(pred)
            .map(this.sp)
            .map(fun);
    }

    sp(s) {
        return s.trim().split(/\s+/u);
    }
}

module.exports = { Helper };
