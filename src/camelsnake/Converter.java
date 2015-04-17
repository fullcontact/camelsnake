package camelsnake;

public class Converter {

    private enum Type {
        UPPER,
        LOWER,
        DIGIT,
        DASH,
        UNDERSCORE,
        OTHER
    }

    static private Type getCharType(char ch) {
        if (Character.isUpperCase(ch)) {
            return Type.UPPER;
        } else if (Character.isLowerCase(ch)) {
            return Type.LOWER;
        } else if (Character.isDigit(ch)) {
            return Type.DIGIT;
        } else if (ch == '_') {
            return Type.UNDERSCORE;
        } else if (ch == '-') {
            return Type.DASH;
        } else {
            return Type.OTHER;
        }
    }

    /**
     * Converts given string to kebab-case, for example
     * AdventureTimes -> adventure-times
     * ADVENTURETimes -> adventure-times
     * adventure_times -> adventure-times
     * etc
     *
     * This is implemented in Java for max performance as even tiny improvement
     * can significantly increase aggregate efficiency.
     */
    static public String toKebabCase(String in) {
        StringBuffer out = new StringBuffer();
        Type prevType = null;
        int prevBoundary = 0;
        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);
            Type type = getCharType(ch);
            if ((type != prevType
                    && (i - prevBoundary) > 0
                    && (Type.UPPER != prevType || Type.LOWER != type))
                ||
                 // special case for HTTPServer -> http-server
                (Type.UPPER == prevType
                    && Type.UPPER == type
                    && in.length() > (i + 1)
                    && Type.LOWER == getCharType(in.charAt(i + 1)))) {
                out.append("-");
                prevBoundary = i;
            }
            if (type != Type.UNDERSCORE && type != Type.DASH) {
                out.append(Character.toLowerCase(ch));
            } else {
                prevBoundary++;
            }
            prevType = type;
        }
        return out.toString();
    }
}
