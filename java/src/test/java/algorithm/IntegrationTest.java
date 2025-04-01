package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class IntegrationTest {

    @Test
    void shouldFindMinSpreadDayNumberOfAssignment() throws IOException {
        FindDayWithMinTemperatureSpread minSpread = new FindDayWithMinTemperatureSpread("weather.dat");

        String day = minSpread.findDay(MinMax.MIN);

        assertEquals("14", day);
    }

    @Test
    void shouldFindMinSpreadDayNumberOfAssignmentMAX() throws IOException {
        FindDayWithMinTemperatureSpread minSpread = new FindDayWithMinTemperatureSpread("weather.dat");

        String day = minSpread.findDay(MinMax.MAX);

        assertEquals("9", day);
    }

    @Test
    void shouldFindMinGoalDifferenceTeamOfAssignment() throws IOException {
        FindTeamWithMinGoalDifference minDiff = new FindTeamWithMinGoalDifference("football.dat");

        String team = minDiff.findTeam(MinMax.MIN);

        assertEquals("Aston_Villa", team);
    }

    @Test
    void shouldFindMinGoalDifferenceTeamOfAssignmentMax() throws IOException {
        FindTeamWithMinGoalDifference minDiff = new FindTeamWithMinGoalDifference("football.dat");

        String team = minDiff.findTeam(MinMax.MAX);

        assertEquals("Arsenal", team);
    }

}
