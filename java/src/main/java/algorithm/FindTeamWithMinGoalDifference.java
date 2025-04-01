package algorithm;

import java.io.IOException;
import java.util.List;

public class FindTeamWithMinGoalDifference {

    private final DataMunger dataMunger = new DataMunger();
    private final String dataFileName;

    public FindTeamWithMinGoalDifference(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    //TODO findTeam and findDay are still the same
    public String findTeam() throws IOException {
        List<String> rawData = dataMunger.load(dataFileName);
        List<FootballData> footballDataList = parse(rawData);
        FootballData footballDataWithMinDifference = dataMunger.findMinDifference(footballDataList);
        return footballDataWithMinDifference.resultId();
    }

    // package access for unit test
    List<FootballData> parse(List<String> footballDataLines) {
        return dataMunger.parse(footballDataLines, //
                this::startsWithRank, //
                this::parseTeamAndGoalDifference);
    }

    private boolean startsWithRank(String line) {
        return line.matches("\\s*\\d+\\.\\s.*");
    }

    private FootballData parseTeamAndGoalDifference(String[] columns) {
        int colTeam = 1;
        int colF = 6;
        int colA = 8;

        String team = columns[colTeam];
        int forTeam = Integer.parseInt(columns[colF]);
        int againstTeam = Integer.parseInt(columns[colA]);

        return new FootballData(team, forTeam, againstTeam);
    }

    public static void main(String... args) throws IOException {
        FindTeamWithMinGoalDifference min = new FindTeamWithMinGoalDifference("football.dat");
        System.out.println(min.findTeam());
    }

}
