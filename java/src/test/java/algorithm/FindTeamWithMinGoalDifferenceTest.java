package algorithm;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import algorithm.FindTeamWithMinGoalDifference;
import algorithm.FootballData;

class FindTeamWithMinGoalDifferenceTest {

    FindTeamWithMinGoalDifference minDifference = new FindTeamWithMinGoalDifference("does_not_exist");

    @Test
    void shouldParseSingleLineIntoListOfFootballData() {
        List<String> lines = Collections.singletonList("   1. Arsenal         38    26   9   3    79  -  36    87");
        List<FootballData> data = minDifference.parse(lines);

        assertEquals("Arsenal", data.get(0).team);
        assertEquals(79, data.get(0).forGoals);
        assertEquals(36, data.get(0).againstGoals);
    }

    @Test
    void shouldIgnoreHeader() {
        List<String> lines = Arrays.asList(//
                "       Team            P     W    L   D    F      A     Pts", //
                "    4. Newcastle       38    21   8   9    74  -  52    71");

        List<FootballData> data = minDifference.parse(lines);

        assertEquals(1, data.size());
        assertEquals("Newcastle", data.get(0).team);
    }

}
