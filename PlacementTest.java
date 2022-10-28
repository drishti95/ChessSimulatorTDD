import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.junit.Assert.fail;

public class PlacementTest {
    private ChessBoard board = new ChessBoard();
    KingPiece king = new KingPiece(Player.WHITE);


    @Test
    public void testCanPlaceKingOnBoard() {
        board.place(king, new Square(File.A, Rank.ONE));
        assertThat(board.isOccupiedAt(new Square(File.A, Rank.ONE))).isTrue();
    }

    @Test
    public void testUnoccupiedSpaceIsFree() {
        assertThat(board.isOccupiedAt(new Square(File.A, Rank.ONE))).isFalse();
    }

    @Test
    public void canPlaceKingAtAnotherPosition() {
        board.place(king, new Square(File.B,Rank.TWO));
        assertThat(board.isOccupiedAt(new Square(File.A,Rank.ONE))).isFalse();
    }

    @Test
    public void twoPiecesCannotBeInTheSameSquare() {
        board.place(king, new Square(File.A, Rank.ONE));
        try {
            board.place(new QueenPiece(Player.WHITE), new Square(File.A, Rank.ONE));
            fail("should have thrown");
        } catch (Exception e) {
        }
    }

    @Test
    public void canGetSquareOfPiece() {
        board.place(king, new Square(File.C, Rank.FOUR));
        assertThat(king.getSquare()).isEqualTo(new Square(File.C, Rank.FOUR));
    }

    @Test
    public void canGetLocationOfMultiplePieces() {
        board.place(king, new Square(File.C, Rank.FOUR));
        board.place(king, new Square(File.C, Rank.FIVE));
        assertThat(king.getSquare()).isEqualTo(new Square(File.C, Rank.FIVE));
    }

    @Test
    public void cannotPutTwoPiecesOnTheSameSquare() {
        board.place(king, new Square(File.C, Rank.FOUR));
        Piece queen = new QueenPiece(Player.BLACK);
        board.place(queen, new Square(File.C, Rank.THREE));
        try {
            board.place(queen, new Square(File.C, Rank.FOUR));
        } catch (Exception exception) {
        }
        assertThat(queen.getSquare()).isEqualTo(new Square(File.C, Rank.THREE));
    }

    @Test
    public void getPieceOnTheSquare() {
        board.place(king, new Square(File.C, Rank.FOUR));
        assertThat(board.getPiece(File.C, Rank.FOUR)).isEqualTo(king);
    }

    @Test
    public void getPieceForAPlayer() {
        board.place(new KingPiece(Player.WHITE), new Square(File.C, Rank.FOUR));
        assertThat(board.getPiece(File.C, Rank.FOUR)).isEqualTo(new KingPiece(Player.WHITE));
    }

    @Test
    public void getPiecesForMultiplePlayers() {
        board.place(new KingPiece(Player.WHITE), new Square(File.C, Rank.FOUR));
        assertThat(board.getPiece(File.C, Rank.FOUR)).isEqualTo(new KingPiece(Player.WHITE));
        board.place(new KingPiece(Player.BLACK),new Square(File.D, Rank.THREE));
        assertThat(board.getPiece(File.D, Rank.THREE)).isEqualTo(new KingPiece(Player.BLACK));
    }

    @Test
    public void twoBlackKingsAreNotTheSamePiece() {
        KingPiece king1 = new KingPiece(Player.BLACK);
        KingPiece king2 = new KingPiece(Player.BLACK);
        board.place(king1, new Square(File.C, Rank.ONE));
        board.place(king2, new Square(File.C, Rank.TWO));
        assertThat(king1.getSquare()).isEqualTo(new Square(File.C, Rank.ONE));
        assertThat(board.getPiece(File.C, Rank.ONE)).isNotEqualTo(king2);
    }

    @Test
    public void placeQueenPieceAndVerifyLocation() {
        QueenPiece queen = new QueenPiece(Player.WHITE);
        board.place(queen, new Square(File.C,Rank.ONE));
        assertThat(queen.getSquare()).isEqualTo(new Square(File.C,Rank.ONE));
        assertThat(board.getPiece(File.C, Rank.ONE)).isEqualTo(queen);
    }


}

