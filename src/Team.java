import java.util.Random;

public class Team {
    Hero[] deck;
    int[] heroesList;
    double teamHp;

    public Team(Hero[] deck) {
        this.deck = deck;
    }

    public void formTeam() {
        shuffle(deck); // Randomize the deck

        int len = Math.min(deck.length, 4);

        heroesList = new int[len]; // initialize

        for (int i = 0; i < len; i++) {
            heroesList[i] = i; // grab the first four value from deck
        }

        teamHp = calculateTeamHp();
    }

    // Reset the team hp
    public void resetTeamHp() {
        teamHp = calculateTeamHp();
    }

    // Return total hp of a hero list
    private double calculateTeamHp() {
        double totalHp = 0;
        for (int i : heroesList) {
            totalHp += deck[i].getHp();
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
    public Hero getHero(int index) {
        return deck[index];
    }

    // Fisher–Yates shuffle
    private void shuffle(Hero[] deck) {
        Random rand = new Random();
        for (int i = deck.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);

            // swap
            Hero temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
    }

    public void getDamaged(double damage){
        teamHp -= damage;
        if (teamHp < 0)
            teamHp = 0;
    }
}
