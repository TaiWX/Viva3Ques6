public class Game {
    Team team;
    Villain enemy;

    public Game() {

    }

    public void battle(Team team, Villain enemy) {
        this.team = team;
        this.enemy = enemy;

        do {
            process();
        } while (team.getTeamHp() > 0 && enemy.getHp() > 0);

        if (team.getTeamHp() == 0)
            System.out.println("The team lose.");
        else
            System.out.println("The team won!");
    }


    private double calculateDamage(Hero hero, int multiplier) {
        double damage = hero.calculateDamage(this.enemy, multiplier);
        return (damage < 1) ? 1 : damage;
    }

    private void displayDamageDealt(String heroName, double damage) {
        System.out.printf("%s dealt %f damage to %s\n", heroName, damage, enemy.getName());
    }

    private void displayRemainingHp() {
        System.out.printf("Team's remaining HP: %f\n", team.getTeamHp());
        System.out.printf("Enemy's remaining HP: %f\n", enemy.getHp());
    }

    private void process() {
        // get runeStone
        String[] runeStone = RuneStones.randomRuneStone();

        double totalDamage = 0;
        // iterate each hero in team, to get damage
        for (int i = 0; i < team.heroesList.length; i++) {
            // iterate runeStone to check
            int multiplier = 0;
            for (String s : runeStone) {
                if (team.getHero(i).getElement().equals(s))
                    multiplier++;
            }

            if (multiplier == 0) continue;

            double damage = calculateDamage(team.getHero(i), multiplier);
            totalDamage += damage;
            // display damage
            displayDamageDealt(team.getHero(i).getName(), damage);
        }

        //
        enemy.getDamaged(totalDamage);
        if (enemy.getHp() <= 0)
            return;

        //
        displayRemainingHp();
    }
}
