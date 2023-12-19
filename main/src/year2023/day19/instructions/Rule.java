package year2023.day19.instructions;

import year2023.day19.Part;

record Rule(Category category, Condition condition, int value, Result result) {

    private Rule(Result result) {
        this(Category.ALL, Condition.ALWAYS, 0, result);
    }

    public boolean matches(Part part) {
        return condition.compare(value, switch (category) {
            case x -> part.x();
            case m -> part.m();
            case a -> part.a();
            case s -> part.s();
            case ALL -> value;
        });
    }

    static Rule of(String string) {
        String[] s = string.split(":");
        String resultString = s[s.length - 1];
        Result result = switch (resultString) {
            case "A":
                yield Result.ACCEPTED;
            case "R":
                yield Result.REJECTED;
            default:
                yield new Result(Result.Type.MOVED, resultString);
        };
        if (s.length != 2) return new Rule(result);

        if (s[0].contains(">")) {
            s = s[0].split(">");
            return new Rule(Category.of(s[0]), Condition.GREATER, Integer.parseInt(s[1]), result);
        } else if (s[0].contains("<")) {
            s = s[0].split("<");
            return new Rule(Category.of(s[0]), Condition.LESSER, Integer.parseInt(s[1]), result);
        } else {
            throw new IllegalArgumentException("Rule " + string + " not a valid Rule");
        }
    }

    private enum Category {
        x, m, a, s, ALL;

        private static Category of(String string) {
            return switch (string) {
                case "x" -> x;
                case "m" -> m;
                case "a" -> a;
                case "s" -> s;
                default -> throw new IllegalArgumentException("Unknown Category: " + string);
            };
        }
    }

    private enum Condition {
        GREATER {
            @Override
            public boolean compare(int value, int part) {
                return value < part;
            }
        }, LESSER {
            @Override
            public boolean compare(int value, int part) {
                return value > part;
            }
        }, ALWAYS {
            @Override
            public boolean compare(int value, int part) {
                return true;
            }
        };

        public abstract boolean compare(int value, int part);
    }
}