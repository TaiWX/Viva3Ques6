public class Team {
    Hero[] deck;
    int[] heroesList;
    double teamHp;

    public Team(Hero[] deck) {
        this.deck = deck;
        teamHp = 0; // todo
    }

    private void formTeam(){

    }

    // Reset the team hp
    public void resetTeamHp(){
        teamHp = calculateTeamHp();
    }

    // Return total hp of a hero list
    private double calculateTeamHp(){
        double totalHp = 0;
        for(int i : heroesList){
            totalHp+=deck[i].getHp();
        }
        return totalHp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Team's HP: ").append(getTeamHp()).append('\n');

        for (int i = 0; i < heroesList.length; i++) {
            sb.append("Hero ").append(i + 1).append('\n');
            sb.append(deck[heroesList[i]].toString());
        }

        return sb.toString();
    }

    public double getTeamHp() {
        return teamHp;
    }

    // Return hero from deck
    public Hero getHero(int index){
        return deck[index];
    }
}
