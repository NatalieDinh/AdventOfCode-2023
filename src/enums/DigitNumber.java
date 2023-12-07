package enums;

public enum DigitNumber {

    ONE("on", "1"),
    TWO("tw", "2"),
    THREE("th", "3"),
    FOUR("fo", "4"),
    FIVE("fi", "5"),
    SIX("si", "6"),
    SEVEN("se", "7"),
    EIGHT("ei", "8"),
    NINE("ni", "9");

    private final String sortKey;
    private final String numberValue;

    private DigitNumber(String sortKey, String numberValue) {
        this.sortKey = sortKey;
        this.numberValue = numberValue;
    }

    public String getSortKey() {
        return sortKey;
    }

    public String getNumberValue() {
        return numberValue;
    }

    public static DigitNumber fromSortKey(String text) {
        for (DigitNumber num : DigitNumber.values()) {
            if (num.sortKey.equalsIgnoreCase(text)) {
                return num;
            }
        }
        return null;
    }
}
