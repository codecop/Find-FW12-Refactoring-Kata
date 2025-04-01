package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IntegrationTest {

    @Nested
    class A {
        FindDayWithMinTemperatureSpread minSpread = new FindDayWithMinTemperatureSpread("w.dat");

        @Test
        void shouldFindSpreadDayNumberOfAssignment_One() throws IOException {
            String day = minSpread.findDay(OneTwo.ONE);

            assertEquals("14", day);
        }

        @Test
        void shouldFindSpreadDayNumberOfAssignment_Two() throws IOException {
            String day = minSpread.findDay(OneTwo.TWO);

            assertEquals("9", day);
        }

    }

    @Nested
    class B {
        FindTeamWithMinGoalDifference minDiff = new FindTeamWithMinGoalDifference("f.dat");

        @Test
        void shouldFindGoalDifferenceTeamOfAssignment_One() throws IOException {
            String team = minDiff.findTeam(OneTwo.ONE);

            assertEquals("Aston_Villa", team);
        }

        @Test
        void shouldFindMinGoalDifferenceTeamOfAssignment_Two() throws IOException {
            String team = minDiff.findTeam(OneTwo.TWO);

            assertEquals("Arsenal", team);
        }

    }

}
