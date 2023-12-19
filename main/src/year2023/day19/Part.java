package year2023.day19;

public record Part(int x, int m, int a, int s) {
    public int rating() {
        return x + m + a + s;
    }

    public static Part of(String string) {
        string = string.substring(1, string.length() - 1);
        String[] values = string.split(",");
        int x = 0, m = 0, a = 0, s = 0;
        for (String value : values) {
            var v = value.split("=");
            switch (v[0]) {
                case "x" -> x = Integer.parseInt(v[1]);
                case "m" -> m = Integer.parseInt(v[1]);
                case "a" -> a = Integer.parseInt(v[1]);
                case "s" -> s = Integer.parseInt(v[1]);
            }
        }
        return new Part(x, m, a, s);
    }
}
