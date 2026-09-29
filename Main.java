import java.util.Scanner;
 
public class Main {
    //Main File
    //Team 8
 
    private static Scanner scanner = new Scanner(System.in);
    private static Chessboard board = new Chessboard();
 
    public static void main(String[] args) {
 
        boolean playAgain = true;
 
        while (playAgain) {
 
            PieceType type = selectPieceType();
            String color = selectColor();
 
            char startCol = readColumn("Enter the starting column (a-h): ");
            int startRow = readRow("Enter the starting row (1-8): ");
 
            while (!board.inChessboard(startCol, startRow)) {
                System.out.println("Position out of the board. Valid columns: a-h, valid rows: 1-8.");
                startCol = readColumn("Enter the starting column (a-h): ");
                startRow = readRow("Enter the starting row (1-8): ");
            }
 
            chessFigure piece = createPiece(type, color, startCol, startRow);
 
            boolean checkAnotherTarget = true;
 
            while (checkAnotherTarget) {
 
                char targetCol = readColumn("Enter the target column (a-h): ");
                int targetRow = readRow("Enter the target row (1-8): ");
 
                while (!board.inChessboard(targetCol, targetRow)) {
                    System.out.println("Position out of the board. Valid columns: a-h, valid rows: 1-8.");
                    targetCol = readColumn("Enter the target column (a-h): ");
                    targetRow = readRow("Enter the target row (1-8): ");
                }
 
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
 
    private static PieceType selectPieceType() {
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
 
    private static String selectColor() {
        while (true) {
            System.out.println("Select a color: WHITE, BLACK");
            String input = scanner.next();
            if (input.equalsIgnoreCase("white") || input.equalsIgnoreCase("black")) {
                return input;
            }
            System.out.println("Invalid color. Please try again.");
        }
    }
 
    private static char readColumn(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.next().toLowerCase();
            if (input.length() == 1 && input.charAt(0) >= 'a' && input.charAt(0) <= 'h') {
                return input.charAt(0);
            }
            System.out.println("Invalid column. Use a letter between a and h.");
        }
    }
 
    private static int readRow(String prompt) {
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
