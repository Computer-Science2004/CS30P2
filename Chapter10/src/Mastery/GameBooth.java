package Mastery;

import java.util.Random;

public class GameBooth {
    private String firstPrize;
    private String consolationPrize;

    public GameBooth(String p1, String p2) {
        firstPrize = p1;
        consolationPrize = p2;
    }

    public String start() {
        Random rand = new Random();
        int platesBroken = 0;

        // roll three times
        for (int i = 0; i < 3; i++) {
            if (rand.nextInt(2) == 1) { // random 0 or 1
                platesBroken++;
            }
        }

        if (platesBroken == 3) {
            return firstPrize;
        } else {
            return consolationPrize;
        }
    }
}
