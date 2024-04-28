package chessGame;

import java.util.Scanner;

public class UserInput {
    private final static Scanner input = new Scanner(System.in);

    public static int readInt() throws NumberFormatException {
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Error reading int value: input a valid integer number");
        }
    }

    public static String readString() {
        return input.next().trim().toLowerCase();
    }
}
