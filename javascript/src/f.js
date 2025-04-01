class F {

    constructor(team, f, a) {
        this.team = team;
        this.f = f;
        this.a = a;
    }

    r() {
        return this.team;
    }

    sort() {
        return Math.abs(this.f - this.a);
    }
}

module.exports = {
    F
};
