import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String calculation = scan.nextLine();
        System.out.println(calc(calculation));
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");
        if (parts.length != 3) {
            throw new IllegalStateException();
        }

        String str1 = parts[0];
        String str2 = parts[2];
        boolean rom1 = str1.matches("^[a-zA-Z]+$");
        boolean rom2 = str2.matches("^[a-zA-Z]+$");
        if ((rom1 == true && rom2) == true) {
            str1 = String.valueOf(romanToNumber(parts[0]));
            str2 = String.valueOf(romanToNumber(parts[2]));
        } else {
            str1 = String.valueOf(parts[0]);
            str2 = String.valueOf(parts[2]);
        }

        int part1 = Integer.parseInt(str1);
        if (part1 > 0 && part1 < 11) {
            part1 = Integer.parseInt(str1);
        } else {
            throw new IllegalStateException();
        }

        int part2 = Integer.parseInt(str2);
        if (part2 > 0 && part2 < 11) {
            part2 = Integer.parseInt(str2);
        } else {
            throw new IllegalStateException();
        }

        String operation = parts[1];
        int answer = switch (operation) {
            case "+" -> part1 + part2;
            case "-" -> part1 - part2;
            case "*" -> part1 * part2;
            case "/" -> part1 / part2;
            default -> throw new IllegalStateException();
        };

        if ((rom1 == true && rom2) == true && answer > 0) {
            return integerToRoman(answer);
        } else if ((rom1 == true && rom2) == true && answer < 1) {
            throw new IllegalStateException();
        } else {
            return String.valueOf(answer);
        }
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static String integerToRoman(int num) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }
}