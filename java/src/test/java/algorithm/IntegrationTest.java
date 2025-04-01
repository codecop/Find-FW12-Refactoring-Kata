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
        void shouldFindMinSpreadDayNumberOfAssignment() throws IOException {
            String day = minSpread.findDay(MinMax.ONE);

            assertEquals("14", day);
        }

        @Test
        void shouldFindMinSpreadDayNumberOfAssignmentMAX() throws IOException {
            String day = minSpread.findDay(MinMax.TWO);

            assertEquals("9", day);
        }

    }

    @Nested
    class B {
        FindTeamWithMinGoalDifference minDiff = new FindTeamWithMinGoalDifference("f.dat");

        @Test
        void shouldFindMinGoalDifferenceTeamOfAssignment() throws IOException {
            String team = minDiff.findTeam(MinMax.ONE);

            assertEquals("Aston_Villa", team);
        }

        @Test
        void shouldFindMinGoalDifferenceTeamOfAssignmentMax() throws IOException {
            String team = minDiff.findTeam(MinMax.TWO);

            assertEquals("Arsenal", team);
        }

    }

}
