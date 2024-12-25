public class Hero extends NPC {
    public Hero(String name, String element, double hp, double attack) {
        super(name, element, hp, attack);
    }

    @Override
    public String toString() {
        return "Name:" + name + '\n' +
                "Element: " + element + '\n' +
                "HP: " + hp + '\n' +
                "Attack: " + attack + '\n';
    }

    // Return damage
    public double calculateDamage(Villain enemy, int rsMultiplier) {
        return getAttack() * RuneStones.getWeakness(getElement(), enemy.getElement()) * rsMultiplier - enemy.getDefense();
    }

}
