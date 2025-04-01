package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IntegrationTest {

    @Nested
    class A {
        FindW minSpread = new FindW("w.dat");

        @Test
        void shouldFindSpreadDayNumberOfAssignment_One() throws IOException {
            String day = minSpread.find(OneTwo.ONE);

            assertEquals("14", day);
        }

        @Test
        void shouldFindSpreadDayNumberOfAssignment_Two() throws IOException {
            String day = minSpread.find(OneTwo.TWO);

            assertEquals("9", day);
        }

    }

    @Nested
    class B {
        FindF minDiff = new FindF("f.dat");

        @Test
        void shouldFindGoalDifferenceTeamOfAssignment_One() throws IOException {
            String team = minDiff.find(OneTwo.ONE);

            assertEquals("Aston_Villa", team);
        }

        @Test
        void shouldFindMinGoalDifferenceTeamOfAssignment_Two() throws IOException {
            String team = minDiff.find(OneTwo.TWO);

            assertEquals("Arsenal", team);
        }

    }

}
