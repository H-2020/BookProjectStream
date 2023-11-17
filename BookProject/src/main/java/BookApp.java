import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
//Oplossing met LIST
public class BookApp {


    public static void main(String[] args) {

        Person author1 = new Person("George ", "Orwell", LocalDate.of(1903, 6, 25));
        Person author2 = new Person("F. Scott", "Fitzgerald's ", LocalDate.of(1900, 12, 21));
        Person author3 = new Person("Jane ", "Austen", LocalDate.of(1775, 12, 18));
        Person author4 = new Person("Antoine ", "de Saint-Exupéry", LocalDate.of(1900, 7, 31));
        Person author5 = new Person("Franz ", "Kafka", LocalDate.of(1883, 6, 3));


        Book book1 = new Book("Animal Farm", author1, LocalDate.of(1945, 8, 17), "Story");
        Book book2 = new Book("The Great Gatsby", author2, LocalDate.of(1925, 1, 1), "Novel");
        Book book3 = new Book("Pride and Prejudice", author3, LocalDate.of(1813, 1, 28), "Novel");
        Book book4 = new Book("The Little Prince", author4, LocalDate.of(1943, 6, 6), "Story");
        Book book5 = new Book("The Metamorphosis", author5, LocalDate.of(1915, 1, 1), "Novel");


        List<Book> books = Arrays.asList(book1, book2, book3, book4, book5);

        System.out.println(getNewestBook((books)));
        System.out.println("***************************************************************************");

        printYoungestWriter(books);
        System.out.println("***************************************************************************");

        printSortedByTitle(books);
        System.out.println("***************************************************************************");

        countBooksPerAuthor(books);
        System.out.println("***************************************************************************");

        printBooksReleasedIn1945(books);

    }

    public static Optional<Book> getNewestBook(List<Book> books) {
        return books.stream()
                .max(Comparator.comparing(t -> t.getReleaseDate()));
    }

    public static void printYoungestWriter(List<Book> books) {
        books.stream()
                .max(Comparator.comparing(t -> t.getAuthor().getDateOfBirth().getYear()))
                .ifPresent(System.out::println);

    }
    public static void printSortedByTitle(List<Book> books) {
        books
                .stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .forEach(System.out::println);
    }

    public static void countBooksPerAuthor(List<Book> books) {
        books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
                .forEach((author, count) -> System.out.println(author + " wrote " + count + " books"));
    }

    public static void printBooksReleasedIn1945(List<Book> books) {
        books.stream()
                .filter(book -> book.getReleaseDate().getYear() == 1945)
                .forEach(System.out::println);



    }

//    public static Book getNewestBook(List<Book> books) {
//        return Objects.requireNonNull(books
//                .stream()
//                .max((a, b) -> a.getReleaseDate() - b.getReleaseDate())
//                .get());
//    }
//
//    public static void printYoungestWriter(List<Book> books) {
//        System.out.println(Objects.requireNonNull(books
//                .stream()
//                .min((a, b) -> b.getAuthor().dateOfBirth.compareTo(a.getAuthor().dateOfBirth))
//                .get()).getAuthor());
//    }
//
//
//
//    public static void countBooksPerAuthor(List<Book> books) {
//        books
//                .stream()
//                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()))
//                .forEach((author, count) -> System.out.printf(
//                        "%s %s has %s book(s) in the library\n",
//                        author.getFirstName(), author.getLastName(), count));
//    }
//
//    public static void printBooksReleasedIn2016(List<Book> books) {
//        books
//                .stream()
//                .filter(book -> book.getReleaseDate() == 2016)
//                .forEach(System.out::println);
//    }

}
