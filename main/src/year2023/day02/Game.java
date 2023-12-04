package year2023.day02;

public record Game(int ID, Round[] rounds) {
    public boolean isPossible(int red, int green, int blue) {
        for (int i = 0; i < rounds.length; i++) {
            if (rounds()[i].red() > red) return false;
            if (rounds()[i].green() > green) return false;
            if (rounds()[i].blue() > blue) return false;
        }
        return true;
    }

    public Round getMinimumCubes() {
        int red = 0, green = 0, blue = 0;

        for (Round round : rounds) {
            red = Math.max(red, round.red());
            green = Math.max(green, round.green());
            blue = Math.max(blue, round.blue());
        }

        return new Round(red, green, blue);
    }
}
