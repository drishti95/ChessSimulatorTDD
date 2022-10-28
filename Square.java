import java.util.Objects;

public class Square {

    Rank rank;
    File file ;
    public Square(File file, Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    static Square square(File file, Rank rank) {
        return new Square(file,rank);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;

        Square square = (Square) o;

        if (rank != square.rank) return false;
        return file == square.file;
    }

    @Override
    public int hashCode() {
        int result = rank != null ? rank.hashCode() : 0;
        result = 31 * result + (file != null ? file.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Square{" +
                "rank=" + rank +
                ", file=" + file +
                '}';
    }
}
