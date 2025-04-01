const { FindF } = require('../src/find-f.js');
const { FindW } = require('../src/find-w.js');
const { OneTwo } = require('../src/one-two.js');

describe('Integration', () => {
    let finder;

    describe('FindW', () => {
        beforeEach(() => {
            console.log(FindW);
            finder = new FindW("w.dat");
        });

        test('should find One', () => {
            const r = finder.find(OneTwo.ONE);

            expect(r).toEquaL("14");
        });

        test('should find Two', () => {
            const r = finder.find(OneTwo.TWO);

            expect(r).toEquaL("9");
        });

    });

    describe('FindF', () => {
        beforeEach(() => {
            finder = new FindF("f.dat");
        });

        test('should find One', () => {
            const r = finder.find(OneTwo.ONE);

            expect(r).toEquaL("Aston_Villa");
        });

        test('should find Two', () => {
            const r = finder.find(OneTwo.TWO);

            expect(r).toEquaL("Arsenal");
        });
    });

});
