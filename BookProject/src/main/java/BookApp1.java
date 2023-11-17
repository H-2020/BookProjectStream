import java.time.LocalDate;
//Oplossing met ARRAYS
public class BookApp1 {
    public static void main(String[] args) {

        Person person1 = new Person("J.K.",   "Rowling",     LocalDate.of(1965, 7, 31));
        Person person2 = new Person("Eckhart","Tolle",       LocalDate.of(1948, 2, 16));
        Person person3 = new Person("Antoine","Galland",     LocalDate.of(1646, 4, 4));
        Person person4 = new Person("Dante",  "Alighieri",   LocalDate.of(1265, 9, 14));
        Person person5 = new Person("William","Shakespeare", LocalDate.of(1564, 4, 23));

        Book1[] books = new Book1[7];
        books[0] = new Book1("HP secret chamber",person1, LocalDate.of(1997, 6,  26), "Fantastic");
        books[1] = new Book1("The power of now", person2, LocalDate.of(1997, 11, 13), "Spiritual");
        books[2] = new Book1("1001 nights",      person3, LocalDate.of(1704, 9,  5),  "Adventure");
        books[3] = new Book1("Dante's hel",      person4, LocalDate.of(1481, 1,  21), "Horror");
        books[4] = new Book1("Hamlet",           person5, LocalDate.of(1603, 6,  14), "Poetic");
        books[5] = new Book1("Romeo & Julia",    person5, LocalDate.of(1597, 5,  3),  "Poetic");
        books[6] = new Book1("HP Cursed Child",  person1, LocalDate.of(2016, 9,  11),  "Poetic");


        System.out.println("#1 Newest Book: "+Book1.getNewestBook(books).getTitle());

        System.out.println("\n#2 Youngest Writter");
        Book1.printYoungestWriter(books);

        System.out.println("\n#3 Sort A-Z by title");
        Book1.printSortedByTitle(books);

        System.out.println("\n#4 Number of books per authors");
        Book1.countBooksPerAuthor(books);

        System.out.println("\n#5 Books released in 2016");
        Book1.printBooksReleasedIn2016(books);
    }
}
