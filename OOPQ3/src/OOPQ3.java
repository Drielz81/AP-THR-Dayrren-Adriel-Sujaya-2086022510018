class Food{
    protected String nama_makanan;
    protected int harga;

    public Food(String nama_makanan, int harga){
        if(harga > 1000000){
            throw new IllegalArgumentException("Exceeds Limit Price");
        }
        this.nama_makanan=nama_makanan;
        this.harga=harga;
    }

    int calcPrice(int harga){
        int harga_akhir = harga + 5000;
        return harga_akhir;
    }

    void getInfo(){
        System.out.println("Name:" + nama_makanan );
        System.out.println("Price:" + calcPrice(harga));
    }
}

class RegularMenu extends Food{
    RegularMenu(String nama_makanan, int harga){
        super(nama_makanan, harga);
    }

    @Override
    int calcPrice(int harga){
        int harga_akhir_regular_tax = super.calcPrice(harga) + 10000;
        return harga_akhir_regular_tax;
    }

    void getInfo(){
        System.out.println("Name:" + nama_makanan );
        System.out.println("Price:" + calcPrice(harga));
    }
}

class SpecialMenu extends Food{
    SpecialMenu(String nama_makanan, int harga){
        super(nama_makanan, harga);
    }

    @Override
    int calcPrice(int harga){
        int harga_akhir_special_tax = super.calcPrice(harga) + 20000;
        return harga_akhir_special_tax;
    }

    void getInfo(){
        System.out.println("Name:" + nama_makanan );
        System.out.println("Price:" + calcPrice(harga));
    }
}

public class OOPQ3 {
    public static void main(String[] args) throws Exception {
        Food food = new Food("Beef Rendang", 15000);
        RegularMenu regular = new RegularMenu("Chicken Ramen", 20000);
        SpecialMenu special = new SpecialMenu("Fiery Fried Rice", 80000);

        food.getInfo();
        regular.getInfo();
        special.getInfo();
    }
}
