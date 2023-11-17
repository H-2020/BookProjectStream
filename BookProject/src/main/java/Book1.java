import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

//Oplossing met ARRAYS
public class Book1 {

    public String title;
    public Person author;
    public LocalDate releaseDate;
    public String genre;

    public Book1(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public Person getAuthor() {
        return author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }


//    public static Book1 getNewestBook(Book1[] books){
//        return (Book1) Arrays.stream(books).sorted(Comparator.comparing(Book1::getReleaseDate).reversed()).toArray()[0];
//    }
//    public static void printYoungestWriter(Book1[] books){
//        Person[] person       = Arrays.stream(books).map(Book1::getAuthor).toArray(Person[]::new);
//        Person youngestWriter = (Person)Arrays.stream(person).sorted(Comparator.comparing(Person::getDateOfBirth).reversed()).toArray()[0];
//        System.out.println("Youngest writer: " +youngestWriter.getFirstName()+" "+youngestWriter.getLastName());
//    }
//    public static void printSortedByTitle(Book1[] books){
//        Book1[] booksAlphabeticalOrder = Arrays.stream(books).sorted(Comparator.comparing(Book1::getTitle)).toArray(Book1[]::new);
//        for (Book1 b : booksAlphabeticalOrder){
//            System.out.println(b.title);
//        }
//    }
//    public static void countBooksPerAuthor(Book1[] libraryBooks){
//        System.out.println("Counting books per author: \n"+Arrays.stream(libraryBooks).
//                collect(Collectors.groupingBy(Book1::getAuthor,Collectors.counting()))
//                +"\n\n");
////
////        tweede manier:
////        Map<Person, Integer> hashMap = new HashMap<>();
////        for (Book1 b : books) {
////            hashMap.put(b.getAuthor(), hashMap.getOrDefault(b.getAuthor(), 0)+1);
////        }
////        hashMap.forEach((k,v)->{
////            System.out.println(k.getFirstName() + " " + k.getLastName() + ": "+ v);
////        });
//    }
//    public static void printBooksReleasedIn2016(Book1[] books){
//        Book1[] booksReleasedIn2016 = Arrays.stream(books).filter(b->b.getReleaseDate().getYear() == 2016).toArray(Book1[]::new);
//        for (Book1 b : booksReleasedIn2016){
//            System.out.println(b.title+" by "+b.getAuthor().getFirstName()+" "+b.getAuthor().getLastName());
//        } //
//    }
public static Book1 getNewestBook(Book1[] books) {
    return Stream.of(books)
            .sorted(Comparator.comparing(Book1::getReleaseDate).reversed())
            .findFirst()
            .orElse(null);
}
    public static void printYoungestWriter(Book1[] books) {
        Optional<Person> youngestAuthor = Stream.of(books)
                .map(Book1::getAuthor)
                .distinct().max(Comparator.comparing(Person::getDateOfBirth));
        //print and verification
        //if the youngestAuthor Optional object is empty, then null will be assigned to the author variable.
        // orElse is used to handle the case where the Optional object is empty
        Person author = youngestAuthor.orElse(null);
        if (author != null) {
            System.out.println("Youngest author: " + author.firstName + " " + author.lastName);
        } else {
            System.out.println("No authors found");
        }
    }

    public static void printSortedByTitle(Book1[] books) {
        System.out.println("Sorted By Title");
        Arrays.stream(books)
                .sorted(Comparator.comparing(Book1::getTitle))
                .forEach(book -> System.out.println(book.getTitle()));
    }


    public static void printBooksReleasedIn2016(Book1[] books) {
        System.out.println("Books Released In 2016 or later");

        Arrays.stream(books)
                .filter(book -> book.getReleaseDate().getYear() >= 2016)
                .map(Book1::getTitle)
                .forEach(System.out::println);
    }


    public static void countBooksPerAuthor(Book1[] books) {
        System.out.println("Count Books Per Author");
        Map<String, Long> authorBookCount = Arrays.stream(books)
                .map(book -> book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName())
                .collect(groupingBy(author -> author, counting()));

        System.out.println("Books Per Author: " + authorBookCount);
    }
}
