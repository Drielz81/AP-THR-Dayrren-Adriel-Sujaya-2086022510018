class Product{
    String judul;
    int tahun_rilis;
    double price;

    Product(String judul, int tahun_rilis, double price){
        if(judul.length()>255){
            throw new IllegalArgumentException("Title Exceeds 255 Characters");
        }
        if(tahun_rilis>1800 && tahun_rilis<2026){
            this.tahun_rilis=tahun_rilis;
        } else {
            throw new IllegalArgumentException("Release Year must be between 1800 adn 2026!");
        }
        this.judul=judul;
        this.price=price;
    }

    void getDescription(){
        System.out.println("Title: " + judul);
        System.out.println("releaseYear: " + tahun_rilis);
        System.out.println("Price: " + price);
    }
}

class DVDS extends Product{
    double runtime;

    DVDS(String judul, int tahun_rilis, double price, double runtime){
        super(judul,tahun_rilis,price);
        if(runtime>720){
            throw new IllegalArgumentException("Runtime exceeds the time limit");
        }
        this.runtime=runtime;
        
    }
    @Override
    void getDescription(){
        super.getDescription();
        System.out.println("Runtime: " + runtime);
    }

}

class Magazine extends Product{
    String author;
    int numPages;

    Magazine(String judul, int tahun_rilis, double price, String author, int numPages){
        super(judul, tahun_rilis, price);
        if(author.length()>50){
            throw new IllegalArgumentException("Author Name Exceeds 50 Characters");
        }
        this.author=author;
        this.numPages=numPages;
    }

    @Override
    void getDescription(){
        super.getDescription();
        System.out.println("Author: " + author);
        System.out.println("numPages: " + numPages);
    }
}

class Vinyls extends Product{
    int size;

    Vinyls(String judul, int tahun_rilis, double price, int size){
        super(judul, tahun_rilis, price);
        if (size>12){
            throw new IllegalArgumentException("Size Exceeds Size Limit");
        }
        this.size=size;
    }

    @Override
    void getDescription(){
        super.getDescription();
        System.out.println("Size: " +size);

    }
}
public class oopq4 {
    public static void main(String[] args) throws Exception {
        DVDS dvd = new DVDS("Baby be mine", 1982, 50000, 4);
        Magazine magazine = new Magazine("Nintendo Power #82", 1997, 25000, "Nintendo", 36);
        Vinyls vinyls = new Vinyls("Song of The Wind", 1967, 350000, 12);

        dvd.getDescription();
        magazine.getDescription();
        vinyls.getDescription();
        
    }
}
