import java.util.Random;

public class RuneStones{
    static String[] runeStonesList = {"Water", "Fire", "Earth", "Light", "Dark"};
    static double[][] weakness = {
            {1, 1.5, 0.5, 1, 1},
            {0.5, 1, 1.5, 1, 1},
            {1.5, 0.5, 1, 1, 1},
            {1, 1, 1, 1, 1.5},
            {1, 1, 1, 1.5, 1}
    };

    // Return the multiplier of attack runeStone to defense runeStone
    public static double getWeakness(String firstRuneStone, String secondRuneStone) {
        int vertical = 0;
        for (int i = 0; i < runeStonesList.length; i++) {
            if (firstRuneStone.equals(runeStonesList[i])) {
                vertical = i;
                break;
            }
        }

        int horizontal = 0;
        for (int i = 0; i < runeStonesList.length; i++) {
            if (secondRuneStone.equals(runeStonesList[i])) {
                horizontal = i;
                break;
            }
        }

        return weakness[vertical][horizontal];
    }

    // Return 3 random runeStones
    public static String[] randomRuneStone() {
        Random rand = new Random();
        String[] chosen = new String[3];
        for (int i = 0; i < chosen.length; i++) {
            chosen[i] = runeStonesList[rand.nextInt(0, runeStonesList.length)];
        }
        return chosen;
    }

}