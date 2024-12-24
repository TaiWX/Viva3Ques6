public class Villain extends NPC{
    double maxHp;
    double defense;
    int initialCd;
    int currentCd;

    public Villain(String name, String element, double attack, double maxHp, double defense, int initialCd) {
        super(name, element, maxHp, attack);
        this.maxHp = maxHp;
        this.defense = defense;
        this.initialCd = initialCd;
        this.currentCd = initialCd;
    }

    // TODO
    public double getDamaged(double damage){
        if (super.getHp()<0)
            super.setHp(0);
        return 0;
    }

    public void resetHp(){
        super.setHp(maxHp);
    }

    // Decrease currentCd by one
    public void decreaseCd(){
        currentCd--;
    }

    public void resetCd(){
        setCurrentCd(getInitialCd());
    }

    //TODO
    @Override
    public String toString() {
        return "Villain{" +
                "maxHp=" + maxHp +
                ", defense=" + defense +
                ", initialCd=" + initialCd +
                ", currentCd=" + currentCd +
                ", name='" + name + '\'' +
                ", element='" + element + '\'' +
                ", hp=" + hp +
                ", attack=" + attack +
                '}';
    }

    public double getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(double maxHp) {
        this.maxHp = maxHp;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public int getInitialCd() {
        return initialCd;
    }

    public void setInitialCd(int initialCd) {
        this.initialCd = initialCd;
    }

    public int getCurrentCd() {
        return currentCd;
    }

    public void setCurrentCd(int currentCd) {
        this.currentCd = currentCd;
    }
}
