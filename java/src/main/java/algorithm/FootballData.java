package algorithm;

public class FootballData implements Data {

    public final String team;
    public final int forGoals;
    public final int againstGoals;

    public FootballData(String team, int forGoals, int againstGoals) {
        this.team = team;
        this.forGoals = forGoals;
        this.againstGoals = againstGoals;
    }

    private int goalDifference() {
        return Math.abs(forGoals - againstGoals);
    }

    @Override
    public String resultId() {
        return team;
    }

    @Override
    public int sortBy() {
        return goalDifference();
    }
}
