public class AssignmentProblem4{
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        if (trimmed.length() >= 3) {
            String pubCode = trimmed.substring(0, 3).toUpperCase();
            return pubCode + trimmed.substring(3);
        }
        return trimmed;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must be digits";
            }
        }

        String pubCode = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        return "[" + pubCode + "] YEAR: " + year + " | CATALOG: " + catalog;
    }

    public static void main(String[] args) {
        String normalized = normalizeCode(" pen2026004251 ");
        System.out.println(validateAndFormat(normalized));

        normalized = normalizeCode("12N2026004251");
        System.out.println(validateAndFormat(normalized));
    }
}
