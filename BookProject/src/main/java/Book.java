import java.time.LocalDate;


public class Book {
    private String title;
    private Person author;
    private LocalDate releaseDate;
    private String genre;


    //constructor
    public Book(String title, Person author, LocalDate releaseDate, String genre) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }


    //getters
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

    @Override
    public String toString() {
        return  "Title=" + title + ","+"\n"+
                "Author=" + author.getFirstName()+author.getLastName() +"\n"+
                "Birthdate= " + author.getDateOfBirth().getYear() +"\n"+
                "ReleaseDate=" + releaseDate +"\n"+
                "Genre=" + genre ;
    }
}