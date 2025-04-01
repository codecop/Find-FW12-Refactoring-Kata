package algorithm;

import java.io.IOException;
import java.util.List;

public class FindTeamWithMinGoalDifference {

    private final Helper dataMunger = new Helper();
    private final String dataFileName;

    public FindTeamWithMinGoalDifference(String dataFileName) {
        this.dataFileName = dataFileName;
    }

    public String findTeam(OneTwo mode) throws IOException {
        List<String> rawData = dataMunger.l(dataFileName);
        List<F> footballDataList = parse(rawData);
        F footballDataWithMinDifference = dataMunger.find(footballDataList, mode);
        return footballDataWithMinDifference.i();
    }

    List<F> parse(List<String> footballDataLines) {
        return dataMunger.p(footballDataLines, //
                this::startsWithRank, //
                this::parseTeamAndGoalDifference);
    }

    private boolean startsWithRank(String line) {
        return line.matches("\\s*\\d+\\.\\s.*");
    }

    private F parseTeamAndGoalDifference(String[] columns) {
        int colTeam = 1;
        int colF = 6;
        int colA = 8;

        String team = columns[colTeam];
        int forTeam = Integer.parseInt(columns[colF]);
        int againstTeam = Integer.parseInt(columns[colA]);

        return new F(team, forTeam, againstTeam);
    }

}
