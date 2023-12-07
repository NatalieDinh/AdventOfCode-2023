import enums.DigitNumber;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        dayTwoMain();
    }
    public static int dayOneMain(String convertedString) throws IOException {
        return Integer.parseInt(
                    String.valueOf(convertedString.charAt(0) + ""
                            + convertedString.charAt(convertedString.length() - 1)));
    }

    public static void dayTwoMain() throws IOException {
        File inputFile = new File("src/Day1Input.txt");
        Scanner scanner = new Scanner(inputFile);

        int sum = 0;
        while(scanner.hasNextLine()) {
            StringBuilder convertedString = new StringBuilder();
            String data = scanner.nextLine();

            int pointer = 0;
            while(pointer < data.length()) {
                String character = String.valueOf(data.charAt(pointer));
                String secondCharacter = pointer != data.length() - 1
                        ? String.valueOf(data.charAt(pointer + 1))
                        : "";
                DigitNumber number = DigitNumber.fromSortKey(
                        character.concat(secondCharacter));
                if (character.matches("[0-9]")) {
                    convertedString.append(character);
                    pointer++;
                } else if(number != null) {
                    pointer = findMatchingNumber(data, pointer,
                            convertedString, number);
                } else {
                    pointer++;
                }
            }
            sum += dayOneMain(convertedString.toString());
        }
        System.out.println(sum);
    }

    public static int findMatchingNumber(String inputLine, int pointer,
                                         StringBuilder convertedString, DigitNumber number) {
        String numberToMatch = number.toString();
        int endOfString = pointer + numberToMatch.length();
        if(endOfString > inputLine.length())
            return ++pointer;
        String dataNumber = inputLine.substring(pointer, pointer + numberToMatch.length());
        if(dataNumber.equalsIgnoreCase(numberToMatch)) {
            convertedString.append(number.getNumberValue());
            return pointer + numberToMatch.length() - 1;
        }
        return ++pointer;
    }
}