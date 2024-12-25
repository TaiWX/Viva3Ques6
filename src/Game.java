public class Game {
    Team team;
    Villain enemy;

    public Game() {

    }

    public void battle(Team team, Villain enemy) {
        this.team = team;
        this.enemy = enemy;

        // reset all hp
        team.resetTeamHp();
        enemy.resetHp();

        for (int i = 1; team.getTeamHp() > 0 && enemy.getHp() > 0; i++) {
            System.out.println("Round " + i);
            process();
        }

        if (team.getTeamHp() == 0)
            System.out.println("The team lose.");
        else
            System.out.println("\nThe team won!");
    }


    private double calculateDamage(Hero hero, int multiplier) {
        double damage = hero.calculateDamage(this.enemy, multiplier);
        return (damage < 1) ? 1 : damage;
    }

    private void displayDamageDealt(String heroName, double damage) {
        System.out.printf("%s dealt %.2f damage to %s\n", heroName, damage, enemy.getName());
    }

    private void displayRemainingHp() {
        System.out.println("Team's remaining HP: " + team.getTeamHp());
        System.out.println("Enemy's remaining HP: " + enemy.getHp());
        System.out.println();
    }

    private void process() {
        // display enemy current cd
        System.out.println("Enemy's current CD: " + enemy.getCurrentCd());

        // get runeStone
        String[] runeStone = RuneStones.randomRuneStone();
        // display chosen runStones
        displayChosenRuneStone(runeStone);

        System.out.println(); //nextLine

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

        // if no damage dealt
        if (totalDamage == 0)
            System.out.println("No hero attacked in this round");

        //
        enemy.getDamaged(totalDamage);
        if (enemy.getHp() <= 0)
            return;

        // villain dealt damage
        if (enemy.getCurrentCd() == 1){
            team.getDamaged(enemy.getAttack());
            System.out.println(enemy.getName() + " dealt " + enemy.getAttack() + " damage to the team\n");

            //reset cd
            enemy.resetCd();
        } else{
            enemy.decreaseCd();
        }

        //
        displayRemainingHp();
    }

    private void displayChosenRuneStone(String[] runStones) {
        System.out.println("Runestones dissolved:"); // header
        for (String s : runStones) {
            System.out.println(" - " + s);
        }
    }
}
