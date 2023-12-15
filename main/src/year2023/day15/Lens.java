package year2023.day15;

public class Lens {
    public final String code;
    public final int hash;
    public final int focalLength;
    public final boolean isSubtractive;

    private Lens(String code, int hash, int focalLength, boolean isSubtractive) {
        this.code = code;
        this.hash = hash;
        this.focalLength = focalLength;
        this.isSubtractive = isSubtractive;
    }

    public static Lens of(String lens) {
        String code;
        int focalLength = 0;
        boolean isSubtractive = false;
        if (lens.endsWith("-")) {
            code = lens.substring(0, lens.length() - 2);
            isSubtractive = true;
        } else {
            var l = lens.split("=");
            code = l[0];
            focalLength = Integer.parseInt(l[1]);
        }
        return new Lens(code, hash(code), focalLength, isSubtractive);
    }

    @Override
    public String toString() {
        return "Lens{" +
                "code='" + code + '\'' +
                ", hash=" + hash +
                ", FocalLength=" + focalLength +
                ", isSubtractive=" + isSubtractive +
                '}';
    }

    public static int hash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = ((hash + s.charAt(i)) * 17) % 256;
        }
        return hash;
    }
}
