import java.util.*;
import java.util.stream.*;
public class BookRecommendations {
    static class Book {
        String title, author, genre;
        double rating;
        public Book(String title, String author, String genre, double rating) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.rating = rating;
        }
    }
    static class BookRecommendation {
        String title;
        double rating;
        public BookRecommendation(String title, double rating) {
            this.title = title;
            this.rating = rating;
        }
        public String toString() {
            return title + " (" + rating + ")";
        }
    }
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
            new Book("Book A", "Author X", "Science Fiction", 4.5),
            new Book("Book B", "Author Y", "Science Fiction", 4.2),
            new Book("Book C", "Author Z", "Romance", 4.7)
        );
        List<BookRecommendation> result = books.stream()
            .filter(b -> b.genre.equals("Science Fiction") && b.rating > 4.0)
            .map(b -> new BookRecommendation(b.title, b.rating))
            .sorted(Comparator.comparingDouble((BookRecommendation br) -> br.rating).reversed())
            .limit(10)
            .collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
