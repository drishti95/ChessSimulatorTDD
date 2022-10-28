import java.util.HashMap;
import java.util.Map;

public class ChessBoard {
    private Map<Square, Piece> locations = new HashMap<>();

    public void place(Piece piece, Square square) {
        if(isOccupiedAt(square)){
            throw new RuntimeException();
        }
        piece.setSquare(square);
        locations.put(square, piece);
    }

    public boolean isOccupiedAt(Square square) {
        return locations.containsKey(square);
    }

    public Piece getPiece(File file, Rank rank) {
        return locations.get(new Square(file, rank));
    }
}
