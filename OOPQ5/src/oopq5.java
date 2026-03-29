import java.util.*;

class Book{
    String title;
    String author;
    int publicationYear;

    Book(String title, String author, int publicationYear){
        if(title.length()>=255){
            throw new IllegalArgumentException("Title Exceeds Character Limit!");
        }
        if(author.length()>=50){
            throw new IllegalArgumentException("Author Exceeds Character Limit!");
        }
        if(publicationYear<=1800 || publicationYear>=2026){
            throw new IllegalArgumentException("Year of Publication must be between 1800 and 2026!");
        }
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
    }

    void getInfo(){
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Year: " + publicationYear);
    }
}
class generalBook extends Book{
    String genre;
    generalBook(String title, String author, int publicationYear, String genre){
        super(title, author, publicationYear);
        this.genre=genre;
    }

    @Override
    void getInfo(){
        super.getInfo();
        System.out.println("Genre: " + genre);
    }
}

class childrenBook extends Book{
    int minAge;
    boolean hasVisualisation;
    
    childrenBook(String title, String author, int publicationYear, int minAge, boolean hasVisualisation){
        super(title, author, publicationYear);
        if(minAge<3 || minAge>12){
            throw new IllegalArgumentException("Minimum Age must be between 3 and 12!");
        }
        this.minAge=minAge;
        this.hasVisualisation=hasVisualisation;
    }

    @Override
    void getInfo(){
        super.getInfo();
        System.out.println("Minimum Age: " + minAge);
        System.out.println("Has Visualisation: " + (hasVisualisation? "Yes" : "No"));
    }
}

public class oopq5 {
    public static void main(String[] args) throws Exception {
        Stack<Book> bookStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);


        bookStack.push(new Book("Why Black Moves First", "Wesley So", 2025));
        bookStack.push(new generalBook("Inside Black Mesa", "Dr. Isaac Kleiner", 1997, "Documentary"));
        bookStack.push(new childrenBook("Got Science?", "Rachel Dawes", 2015, 5, true));

        boolean while1 = true;
        while(while1){
            System.out.print("1. add book\n2. View Books\n3. Delete Book\n4. Exit App\nChoose: ");
            int user_choice = scanner.nextInt();
            scanner.nextLine();

            switch (user_choice){
                case 1:
                    System.out.print("Book Type:\n1. Book\n2. General Book\n3. Children Book\nChoose: ");
                    int jenis_buku = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Publication Year: ");
                    int year = scanner.nextInt();

                    switch (jenis_buku){
                        case 1:
                            bookStack.push(new Book(title, author, year));
                        case 2:
                            System.out.print("Genre: ");
                            String genre = scanner.nextLine();
                            bookStack.push(new generalBook(title, author, year, genre));
                        case 3:
                            System.out.print("Minimum Age");
                            int min_age = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Has Visualisation (true/false): ");
                            boolean visual = scanner.nextBoolean();
                            bookStack.push(new childrenBook(title, author, year, min_age, visual));
                    }
                    System.out.println("Book added!");
                    break;
                case 2:
                    System.out.println("Books List\n");
                    Stack<Book> tempat_isi = new Stack<>();
                    while(!bookStack.isEmpty()){
                        tempat_isi.push(bookStack.pop());
                    }
                    while(!tempat_isi.isEmpty()){
                        Book b = tempat_isi.pop();
                        b.getInfo();
                        System.out.println();
                        bookStack.push(b);
                        
                    }
                    break;
                case 3:
                    System.out.print("Book Title to Delete: ");
                    String hapus = scanner.nextLine();
                    Stack<Book> stack_hapus = new Stack<>();

                    while(!bookStack.isEmpty()){
                        Book b = bookStack.pop();
                        if (b.title.equalsIgnoreCase(hapus)){
                            System.out.println("Book Successfully deleted: " + b.title);
                        } else {
                            stack_hapus.push(b);
                        }
                    }
                    while(!stack_hapus.isEmpty()){
                        bookStack.push(stack_hapus.pop());
                    }
                    break;
                case 4:
                    System.out.println("Thank You For Visiting!");
                    while1 = false;
                    break;
            }
        }
        scanner.close();
    }
}
