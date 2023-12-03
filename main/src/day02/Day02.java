package day02;

public class Day02 {
    public static void main(String[] args) {
        Game[] games = new Game[Input.INPUT.length];
        for (int i = 0; i < Input.INPUT.length; i++) {
            String[] s = Input.INPUT[i].split(":");
            int ID = Integer.parseInt(s[0].split(" ")[1]);
            String[] roundStrings = s[1].split(";");
            Round[] rounds = new Round[roundStrings.length];
            for (int j = 0; j < roundStrings.length; j++) {
                String[] colors = roundStrings[j].split(",");
                int red = 0, green = 0, blue = 0;
                for (String color : colors) {
                    if (color.endsWith(" red")) {
                        red = Integer.parseInt(color.split(" ")[1]);
                    } else if (color.endsWith(" green")) {
                        green = Integer.parseInt(color.split(" ")[1]);
                    } else if (color.endsWith(" blue")) {
                        blue = Integer.parseInt(color.split(" ")[1]);
                    }
                }
                rounds[j] = new Round(red, green, blue);
            }
            games[i] = new Game(ID, rounds);
        }

        int solution = 0;
        for (Game game : games) {
            if(game.isPossible(Input.MAX_RED, Input.MAX_GREEN, Input.MAX_BLUE)) {
                solution += game.ID();
            }
        }
        System.out.println(solution);

        //Part Two
        long power = 0;
        for (Game game : games) {
            power += game.getMinimumCubes().getPower();
        }
        System.out.println(power);
    }
}
