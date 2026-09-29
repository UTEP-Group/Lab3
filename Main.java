import java.util.Scanner;
 
public class Main {
    //Main File
    //Team 8
 
    private static Scanner scanner = new Scanner(System.in);
    private static Chessboard board = new Chessboard();

    // starts the program and lets the user select a piece and test its moves
    public static void main(String[] args) {
        boolean playAgain = true;
        // repeats program while the user selects another chess piece
        while (playAgain) {
 
            PieceType type = selectPieceType();
            String color = selectColor();
 
            char startCol = readColumn("Enter the starting column (a-h): ");
            int startRow = readRow("Enter the starting row (1-8): ");

            // keeps asking for a starting position until it's inside the chessboard
            while (!board.inChessboard(startCol, startRow)) {
                System.out.println("Position out of the board. Valid columns: a-h, valid rows: 1-8.");
                startCol = readColumn("Enter the starting column (a-h): ");
                startRow = readRow("Enter the starting row (1-8): ");
            }
 
            chessFigure piece = createPiece(type, color, startCol, startRow);
 
            boolean checkAnotherTarget = true;

            // lets user check multiple target positions using the same chess piece
            while (checkAnotherTarget) {
 
                char targetCol = readColumn("Enter the target column (a-h): ");
                int targetRow = readRow("Enter the target row (1-8): ");

                // keeps asking for a target position until it is inside the chessboard
                while (!board.inChessboard(targetCol, targetRow)) {
                    System.out.println("Position out of the board. Valid columns: a-h, valid rows: 1-8.");
                    targetCol = readColumn("Enter the target column (a-h): ");
                    targetRow = readRow("Enter the target row (1-8): ");
                }

                // keeps asking until the target position is different from the starting position
                while (targetCol == startCol && targetRow == startRow) {
                    System.out.println("The target position must be different from the current position.");
                    targetCol = readColumn("Enter the target column (a-h): ");
                    targetRow = readRow("Enter the target row (1-8): ");
                }
 
                boolean valid = piece.verifyMove(targetCol, targetRow);
 
                System.out.println("Piece " + type + " in position " + startCol + startRow
                        + (valid ? " CAN move to " : " CANNOT move to ")
                        + targetCol + targetRow);
 
                System.out.print("Would you like to verify another target position with the same piece? (y/n): ");
                checkAnotherTarget = scanner.next().equalsIgnoreCase("y");
            }
 
            System.out.print("Would you like to select another piece? (y/n): ");
            playAgain = scanner.next().equalsIgnoreCase("y");
        }
 
        System.out.println("Program terminated.");
        scanner.close();
    }

    // ssks the user to choose a chess piece
    // keeps asking until a valid piece is entered
    private static PieceType selectPieceType() {
        // repeats until user enters a valid chess piece type
        while (true) {
            System.out.println("Select a piece: PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING");
            String input = scanner.next().toUpperCase();
            try {
                return PieceType.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid piece. Please try again.");
            }
        }
    }

    // asks user to choose WHITE or BLACK (changes rule depending on color)
    // keeps asking until a valid color is entered
    private static String selectColor() {
        // repeats until the user enters either white or black (not case senstive)
        while (true) {
            System.out.println("Select a color: WHITE, BLACK");
            String input = scanner.next();
            if (input.equalsIgnoreCase("white") || input.equalsIgnoreCase("black")) {
                return input;
            }
            System.out.println("Invalid color. Please try again.");
        }
    }

    // reads inputted column and makes sure it is between a - h
    private static char readColumn(String prompt) {
        // repeats until user enters a valid column from a - h
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().toLowerCase();
            if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'h') {
                return input.charAt(0);
            }
            System.out.println("Invalid column. Use a letter between a and h.");
        }
    }

    // reads row and makes sure it is between 1 - 8.
    private static int readRow(String prompt) {
        // repeats until user enters a valid row from 1 - 8.
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.next());
                if (value >= 1 && value <= 8) {
                    return value;
                }
                System.out.println("Invalid row. Use a number between 1 and 8.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number between 1 and 8.");
            }
        }
    }

    // creates and returns the correct chess piece object + rules for it based on the piece type selected by the user
    private static chessFigure createPiece(PieceType type, String color, char column, int row) {
        switch (type) {
            case PAWN:
                return new Pawn(color, column, row);
            case ROOK:
                return new Rook(color, column, row);
            case KNIGHT:
                return new Knight(color, column, row);
            case BISHOP:
                return new Bishop(color, column, row);
            case QUEEN:
                return new Queen(color, column, row);
            case KING:
                return new King(color, column, row);
            default:
                return null;
        }
    }
}
