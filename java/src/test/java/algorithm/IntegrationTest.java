package algorithm;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import algorithm.FindDayWithMinTemperatureSpread;
import algorithm.FindTeamWithMinGoalDifference;


class IntegrationTest {

    @Test
    void shouldFindMinSpreadDayNumberOfAssignment() throws IOException {
        FindDayWithMinTemperatureSpread minSpread = new FindDayWithMinTemperatureSpread("weather.dat");

        String day = minSpread.findDay();

        assertEquals("14", day);
    }

    @Test
    void shouldFindMinGoalDifferenceTeamOfAssignment() throws IOException {
        FindTeamWithMinGoalDifference minDiff = new FindTeamWithMinGoalDifference("football.dat");

        String team = minDiff.findTeam();

        assertEquals("Aston_Villa", team);
    }

}
